package top.dfghhj.extension.trade.validation;

import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.extension.Extension;
import top.dfghhj.dto.trade.TradeAddCmd;
import lombok.extern.slf4j.Slf4j;

/**
 * 默认校验
 */
@Slf4j
@Extension(bizId = "trade")
public class TradeDefaultValidationExt implements TradeValidationExtPt {
    @Override
    public void validate(TradeAddCmd tradeAddCmd) {
        log.info("默认订单校验......");
        if (tradeAddCmd.getTargetAddr() == null) {
            throw new BizException("交易的收获地址不能为空");
        }
    }
}
