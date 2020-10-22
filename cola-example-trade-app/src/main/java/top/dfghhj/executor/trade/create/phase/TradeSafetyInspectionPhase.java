package top.dfghhj.executor.trade.create.phase;

import com.alibaba.cola.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.dfghhj.domain.customer.Customer;
import top.dfghhj.domain.merchant.Merchant;
import top.dfghhj.domain.trade.Trade;

@Slf4j
@Component
public class TradeSafetyInspectionPhase {

    public void safetyInspection(Trade trade) {
        log.info("安全检测...");
        //1.检查商户是否是存在违规，处于处罚期
        Merchant merchant = trade.getMerchant();

        if (!merchant.isNormal()) {
            throw new BizException("商家状态异常，不能下单");
        }

        //2.检查顾客账户是否有异常操作
        Customer customer = trade.getCustomer();

        if (!customer.isNormal()) {
            throw new BizException("账号状态异常，不能下单");
        }

    }
}
