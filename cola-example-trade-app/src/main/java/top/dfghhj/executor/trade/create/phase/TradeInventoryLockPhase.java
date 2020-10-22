package top.dfghhj.executor.trade.create.phase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.dfghhj.domain.trade.Trade;

@Slf4j
@Component
public class TradeInventoryLockPhase {


    /**
     * 调用库存系统尝试锁库存，不被别人买走
     * @param trade
     */
    public void inventoryLock(Trade trade) {
        log.info("锁定库存...");
    }

}
