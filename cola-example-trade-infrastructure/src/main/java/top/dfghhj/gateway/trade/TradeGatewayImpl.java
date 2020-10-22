package top.dfghhj.gateway.trade;

import top.dfghhj.domain.gateway.trade.TradeGatewayI;
import top.dfghhj.domain.trade.Trade;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TradeGatewayImpl implements TradeGatewayI {

    @Override
    public void save(Trade trade) {
        log.info("保存订单：{}", trade);
    }
}
