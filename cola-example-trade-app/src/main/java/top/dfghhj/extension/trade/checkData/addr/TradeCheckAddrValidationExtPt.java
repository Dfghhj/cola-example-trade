package top.dfghhj.extension.trade.checkData.addr;

import com.alibaba.cola.extension.ExtensionPointI;
import top.dfghhj.domain.trade.Trade;

public interface TradeCheckAddrValidationExtPt extends ExtensionPointI {

    public void checkAddr(Trade trade);

}

