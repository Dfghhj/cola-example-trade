package top.dfghhj.message;

import com.alibaba.cola.event.MessageQueueEventI;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.core.RocketMQTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * domain events are sent to RocketMQ
 */
@Slf4j
@Component
public class DomainEventMQPublisher {

    @Resource
    private RocketMQTemplate rocketMQTemplate;

    public void publish(MessageQueueEventI messageQueueEvent) {
        String eventType = messageQueueEvent.getEventType();
        String eventTopic = messageQueueEvent.getEventTopic();
        String payload = JSONObject.toJSONString(messageQueueEvent);
        log.info("发生事件到RocketMQ, eventType:{}, eventTopic:{}, payload:{}", eventType, eventTopic, payload);
        rocketMQTemplate.convertAndSend(eventTopic, payload);
    }

}
