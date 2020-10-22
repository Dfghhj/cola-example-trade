package top.dfghhj.executor.trade.create;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.extension.ExtensionExecutor;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.dto.trade.TradeAddCmd;
import top.dfghhj.dto.trade.domainevent.TradeCreatedEvent;
import top.dfghhj.executor.trade.create.phase.TradeCheckPhase;
import top.dfghhj.executor.trade.create.phase.TradeCreatePhase;
import top.dfghhj.executor.trade.create.phase.TradeInitPhase;
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
    private TradeInitPhase tradeInitPhase;
    @Resource
    private TradeCheckPhase tradeCheckPhase;
    @Resource
    private TradeCreatePhase tradeCreatePhase;

    @Resource
    private ExtensionExecutor extensionExecutor;
    @Resource
    private DomainEventPublisher domainEventPublisher;
    @Resource
    private DomainEventMQPublisher domainEventMQPublisher;

    public Response execute(TradeAddCmd cmd) {
        log.info("开始处理命令: {}", cmd);

        //校验各种类型订单的必须参数和类型
        extensionExecutor.executeVoid(TradeValidationExtPt.class, cmd.getBizScenario(), extension->extension.validate(cmd));

        //组装Trade信息
        Trade trade = initTrade(cmd);

        //校验订单信息（库存、金额）
        checkData(trade);

        //生成单号、初始化交易状态、保存订单信息
        create(trade);

        //推送订单创建事件
        // 1.减库存
        // 2.通知商家
        TradeCreatedEvent tradeCreatedEvent = new TradeCreatedEvent(trade.getTradeId());
        domainEventPublisher.publish(tradeCreatedEvent);
        domainEventMQPublisher.publish(tradeCreatedEvent);
        return Response.buildSuccess();
    }

    private Trade initTrade(TradeAddCmd cmd) {
        return tradeInitPhase.initTrade(cmd);
    }

    private void checkData(Trade trade) {
        tradeCheckPhase.checkData(trade);
    }

    private void create(Trade trade) {
        tradeCreatePhase.createTrade(trade);
    }

}
