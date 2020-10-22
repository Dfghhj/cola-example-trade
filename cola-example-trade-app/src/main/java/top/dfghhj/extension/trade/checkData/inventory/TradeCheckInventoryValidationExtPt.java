package top.dfghhj.extension.trade.checkData.inventory;

import com.alibaba.cola.extension.ExtensionPointI;
import top.dfghhj.domain.trade.Trade;

public interface TradeCheckInventoryValidationExtPt extends ExtensionPointI {

    public void checkInventory(Trade trade);

}
