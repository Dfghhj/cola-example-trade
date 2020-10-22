package top.dfghhj.extension.trade.validation;

import com.alibaba.cola.exception.BizException;
import com.alibaba.cola.extension.Extension;
import top.dfghhj.common.bizcode.TradeBizCode;
import top.dfghhj.dto.trade.TradeAddCmd;
import top.dfghhj.dto.trade.domainmodel.TradeType;
import lombok.extern.slf4j.Slf4j;

/**
 * 虚拟订单校验
 */
@Slf4j
@Extension(bizId = "trade", useCase = TradeBizCode.USE_CASE.MOBILE, scenario = TradeBizCode.SCENARIO.VIRTUAL)
public class TradeVirtualValidationExt implements TradeValidationExtPt {

    @Override
    public void validate(TradeAddCmd tradeAddCmd) {
        log.info("虚拟订单校验......");
        if (!tradeAddCmd.getType().equals(TradeType.VIRTUAL.name())) {
            throw new BizException("交易类型不是虚拟交易");
        }
    }
}
