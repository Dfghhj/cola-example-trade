package top.dfghhj.dto.trade.domainevent;

import com.alibaba.cola.event.DomainEventI;
import com.alibaba.cola.event.MessageQueueEventI;
import lombok.Data;

@Data
public class TradeCreatedEvent implements DomainEventI, MessageQueueEventI {

    public static final String eventType = "create";

    public static final String eventTopic = "trade-created";

    private String tradeId;

    public TradeCreatedEvent(String tradeId) {
        this.tradeId = tradeId;
    }

    @Override
    public String getEventType() {
        return eventType;
    }

    @Override
    public String getEventTopic() {
        return eventTopic;
    }
}
