package top.dfghhj.extension.trade.validation;

import com.alibaba.cola.extension.ExtensionPointI;
import top.dfghhj.dto.trade.TradeAddCmd;

public interface TradeValidationExtPt extends ExtensionPointI {

    public void validate(TradeAddCmd tradeAddCmd);

}
