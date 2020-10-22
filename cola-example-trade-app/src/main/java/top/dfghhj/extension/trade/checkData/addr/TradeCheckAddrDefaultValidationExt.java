package top.dfghhj.extension.trade.checkData.addr;

import com.alibaba.cola.extension.Extension;
import top.dfghhj.domain.trade.Trade;

/**
 * 默认校验
 */
@Extension(bizId = "trade")
public class TradeCheckAddrDefaultValidationExt implements TradeCheckAddrValidationExtPt {
    @Override
    public void checkAddr(Trade trade) {
        return;
    }
}
