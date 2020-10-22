package top.dfghhj.executor.trade.create;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.dto.SingleResponse;
import com.alibaba.cola.extension.ExtensionExecutor;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.dto.trade.TradeAddCmd;
import top.dfghhj.dto.trade.domainevent.TradeCreatedEvent;
import top.dfghhj.executor.trade.create.phase.*;
import top.dfghhj.extension.trade.validation.TradeValidationExtPt;
import top.dfghhj.message.DomainEventMQPublisher;
import top.dfghhj.message.DomainEventPublisher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Slf4j
@Component
public class TradeAddCmdExe {

    @Resource
    private TradeSafetyInspectionPhase tradeSafetyInspectionPhase;
    @Resource
    private TradeInitPhase tradeInitPhase;
    @Resource
    private TradeVerifyTradeInfoPhase tradeVerifyTradeInfoPhase;
    @Resource
    private TradeCalculateTradePhase tradeCalculateTradePhase;
    @Resource
    private TradeInventoryLockPhase tradeInventoryLockPhase;
    @Resource
    private TradeSavePhase tradeSavePhase;

    @Resource
    private ExtensionExecutor extensionExecutor;
    @Resource
    private DomainEventPublisher domainEventPublisher;
    @Resource
    private DomainEventMQPublisher domainEventMQPublisher;

    public Response execute(TradeAddCmd cmd) {
        //参数完整性校验
        extensionExecutor.executeVoid(TradeValidationExtPt.class, cmd.getBizScenario(), extension->extension.validate(cmd));
        //组装订单信息
        Trade trade = initTrade(cmd);
        //安全检测
        safetyInspectionPhase(trade);
        //校验订单信息
        verifyTradeInfoPhase(trade);
        //计算商品金额、会员权益
        calculateTradePhase(trade);
        //库存锁定
        inventoryLockPhase(trade);
        //生成单号，保存
        save(trade);
        //推送订单创建事件
        TradeCreatedEvent tradeCreatedEvent = new TradeCreatedEvent(trade.getOrderId());
        domainEventPublisher.publish(tradeCreatedEvent);
        domainEventMQPublisher.publish(tradeCreatedEvent);
        //返回订单信息
        //todo 转换成DTO返回
        return SingleResponse.of(trade.getOrderId());
    }

    private Trade initTrade(TradeAddCmd cmd) {
        return tradeInitPhase.initTrade(cmd);
    }

    private void safetyInspectionPhase(Trade trade) {
        tradeSafetyInspectionPhase.safetyInspection(trade);
    }

    private void verifyTradeInfoPhase(Trade trade) {
        tradeVerifyTradeInfoPhase.verifyTradeInfo(trade);
    }

    private void calculateTradePhase(Trade trade) {
        tradeCalculateTradePhase.calculateTrade(trade);
    }

    private void inventoryLockPhase(Trade trade) {
        tradeInventoryLockPhase.inventoryLock(trade);
    }

    private void save(Trade trade) {
        tradeSavePhase.saveTrade(trade);
    }

}
