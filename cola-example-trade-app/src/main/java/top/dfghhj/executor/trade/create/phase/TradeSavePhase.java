package top.dfghhj.executor.trade.create.phase;

import lombok.extern.slf4j.Slf4j;
import top.dfghhj.domain.gateway.trade.TradeGatewayI;
import top.dfghhj.domain.gateway.trade.TradeStatusGatewayI;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.domain.trade.TradeStatus;
import top.dfghhj.dto.trade.domainmodel.TradeStatusEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Slf4j
@Component
public class TradeSavePhase {

    @Resource
    private TradeGatewayI tradeGateway;
    @Resource
    private TradeStatusGatewayI tradeStatusGateway;

    public void saveTrade(Trade trade) {
        log.info("保存订单...");
        String orderId = generateTradeId();
        trade.setOrderId(orderId);
        tradeGateway.save(trade);
    }

    private String generateTradeId() {
        return UUID.randomUUID().toString();
    }
}
