package top.dfghhj.extension.trade.checkData.addr;

import com.alibaba.cola.extension.Extension;
import top.dfghhj.common.bizcode.TradeBizCode;
import top.dfghhj.domain.trade.Trade;

/**
 * 虚拟订单校验
 */
@Extension(bizId = "trade", useCase = TradeBizCode.USE_CASE.MOBILE, scenario = TradeBizCode.SCENARIO.VIRTUAL)
public class TradeCheckAddrVirtualValidationExt implements TradeCheckAddrValidationExtPt {
    @Override
    public void checkAddr(Trade trade) {
        return;
    }
}
