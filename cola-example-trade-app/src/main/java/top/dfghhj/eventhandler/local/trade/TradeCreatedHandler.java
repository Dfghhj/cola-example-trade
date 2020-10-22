package top.dfghhj.eventhandler.local.trade;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.event.EventHandler;
import com.alibaba.cola.event.EventHandlerI;
import top.dfghhj.dto.trade.domainevent.TradeCreatedEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EventHandler
public class TradeCreatedHandler implements EventHandlerI<Response, TradeCreatedEvent> {

    @Override
    public Response execute(TradeCreatedEvent tradeCreatedEvent) {

        log.info("收到TradeCreatedEvent：{}", tradeCreatedEvent);

        return null;
    }
}
