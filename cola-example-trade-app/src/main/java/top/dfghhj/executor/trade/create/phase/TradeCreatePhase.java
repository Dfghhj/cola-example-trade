package top.dfghhj.executor.trade.create.phase;

import top.dfghhj.domain.gateway.trade.TradeGatewayI;
import top.dfghhj.domain.gateway.trade.TradeStatusGatewayI;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.domain.trade.TradeStatus;
import top.dfghhj.dto.trade.domainmodel.TradeStatusEnum;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.UUID;

@Component
public class TradeCreatePhase {

    @Resource
    private TradeGatewayI tradeGateway;
    @Resource
    private TradeStatusGatewayI tradeStatusGateway;

    public void createTrade(Trade trade) {

        String tradeId = generateTradeId();
        trade.setTradeId(tradeId);
        tradeGateway.save(trade);

        TradeStatus tradeStatus = new TradeStatus(trade, TradeStatusEnum.NORMAL.name());
        tradeStatusGateway.save(tradeStatus);
    }

    private String generateTradeId() {
        return UUID.randomUUID().toString();
    }
}
