package top.dfghhj.extension.trade.checkData.purchaseLimit;

import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.extension.Extension;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.domain.trade.commodity.TradeCommodity;

/**
 * 默认校验
 */
@Extension(bizId = "trade")
public class TradeCheckPurchaseLimitDefaultValidationExt implements TradeCheckPurchaseLimitValidationExtPt {
    @Override
    public void checkPurchaseLimit(Trade trade) {
        for (TradeCommodity tradeCommodity:trade.getCommodityList()) {
            if (!tradeCommodity.checkPurchaseLimit()) {
                throw new BizException("超出限购数量");
            }
        }
    }
}
