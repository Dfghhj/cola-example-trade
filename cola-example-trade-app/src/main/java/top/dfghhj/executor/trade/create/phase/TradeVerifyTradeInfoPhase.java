package top.dfghhj.executor.trade.create.phase;

import com.alibaba.cola.extension.ExtensionExecutor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.extension.trade.checkData.addr.TradeCheckAddrValidationExtPt;
import top.dfghhj.extension.trade.checkData.inventory.TradeCheckInventoryValidationExtPt;
import top.dfghhj.extension.trade.checkData.purchaseLimit.TradeCheckPurchaseLimitValidationExtPt;

import javax.annotation.Resource;

@Slf4j
@Component
public class TradeVerifyTradeInfoPhase {

    @Resource
    private ExtensionExecutor extensionExecutor;

    public void verifyTradeInfo(Trade trade) {
        log.info("校验订单信息...");

        //检查是否限购
        extensionExecutor.executeVoid(TradeCheckPurchaseLimitValidationExtPt.class, trade.getBizScenario(), extension -> extension.checkPurchaseLimit(trade));

        //校验库存
        extensionExecutor.executeVoid(TradeCheckInventoryValidationExtPt.class, trade.getBizScenario(), extension -> extension.checkInventory(trade));

        //校验收获地址和是否可配送
        extensionExecutor.executeVoid(TradeCheckAddrValidationExtPt.class, trade.getBizScenario(), extension -> extension.checkAddr(trade));

    }
}
