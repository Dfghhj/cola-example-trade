package top.dfghhj.eventhandler.mq;

import top.dfghhj.dto.trade.domainevent.TradeCreatedEvent;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Slf4j
@Component
public class TradeMQListener {

    @Service
    @RocketMQMessageListener(consumerGroup = "1111", topic = TradeCreatedEvent.eventTopic)
    public static class CreatedEventConsumer implements RocketMQListener<String> {
        @Override
        public void onMessage(String s) {
            log.info("consumer1 rocket收到消息：{}", s);
        }
    }

}
