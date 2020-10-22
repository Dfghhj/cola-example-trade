package top.dfghhj.extension.trade.checkData.inventory;

import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.extension.Extension;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.domain.trade.commodity.TradeCommodity;

/**
 * 默认校验
 */
@Extension(bizId = "trade")
public class TradeCheckInventoryDefaultValidationExt implements TradeCheckInventoryValidationExtPt {
    @Override
    public void checkInventory(Trade trade) {
        for (TradeCommodity tradeCommodity:trade.getCommodityList()) {
            if (!tradeCommodity.checkInventory()) {
                throw new BizException("库存不足");
            }
        }
    }
}
