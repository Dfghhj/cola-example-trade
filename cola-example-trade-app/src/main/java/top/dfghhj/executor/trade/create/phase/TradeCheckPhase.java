package top.dfghhj.executor.trade.create.phase;

import com.alibaba.cola.extension.ExtensionExecutor;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.extension.trade.checkData.addr.TradeCheckAddrValidationExtPt;
import top.dfghhj.extension.trade.checkData.inventory.TradeCheckInventoryValidationExtPt;
import top.dfghhj.extension.trade.checkData.purchaseLimit.TradeCheckPurchaseLimitValidationExtPt;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class TradeCheckPhase {

    @Resource
    private ExtensionExecutor extensionExecutor;

    public void checkData(Trade trade) {

        //检查是否限购
        extensionExecutor.executeVoid(TradeCheckPurchaseLimitValidationExtPt.class, trade.getBizScenario(), extension -> extension.checkPurchaseLimit(trade));

        //校验库存
        extensionExecutor.executeVoid(TradeCheckInventoryValidationExtPt.class, trade.getBizScenario(), extension -> extension.checkInventory(trade));

        //校验收获地址和是否可配送
        extensionExecutor.executeVoid(TradeCheckAddrValidationExtPt.class, trade.getBizScenario(), extension -> extension.checkAddr(trade));


    }
}
