package top.dfghhj.extension.trade.checkData.purchaseLimit;

import com.alibaba.cola.extension.ExtensionPointI;
import top.dfghhj.domain.trade.Trade;

public interface TradeCheckPurchaseLimitValidationExtPt extends ExtensionPointI {

    public void checkPurchaseLimit(Trade trade);
}
