package top.dfghhj.executor.trade.create.phase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.domain.trade.rule.TradeRule;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Component
public class TradeCalculateTradePhase {

    public void calculateTrade(Trade trade) {
        log.info("计算金额...");
        //计算商品原始价格
        trade.calculateCommodityOriginalAmount();

        //计算商品折扣价格
        trade.calculateCommodityAmount();

        //计算运费
        // 1.是否包邮
        // 2.按距离计算运费
        // 3.按快递运输时间计算运费
        trade.calculateLogisticsAmount();

        // 获取满减、vip折扣
        List<TradeRule> tradeRuleList = new ArrayList<>();
        //计算最终价格
        trade.calculateAmount(tradeRuleList);
    }



}
