package top.dfghhj.gateway.trade;

import top.dfghhj.domain.gateway.trade.TradeStatusGatewayI;
import top.dfghhj.domain.trade.TradeStatus;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TradeStatusGatewayImpl implements TradeStatusGatewayI {

    @Override
    public void save(TradeStatus tradeStatus) {
        log.info("保存订单状态：{}", tradeStatus);
    }
}
