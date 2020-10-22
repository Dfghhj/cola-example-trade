package top.dfghhj.controller;

import com.alibaba.cola.dto.Response;
import com.alibaba.cola.extension.BizScenario;
import top.dfghhj.api.trade.TradeServiceI;
import top.dfghhj.dto.trade.TradeAddCmd;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;

@Slf4j
@RestController
@RequestMapping("/trade")
public class TradeController {

    @Resource
    private TradeServiceI tradeService;

    @PostMapping
    public Response createTrade(@RequestBody @Valid TradeAddCmd tradeAddCmd) {
        log.info("创建订单命令: {}", tradeAddCmd);
        // 设置交易的业务场景
        BizScenario bizScenario = BizScenario.valueOf("trade", tradeAddCmd.getSource(), tradeAddCmd.getType());
        tradeAddCmd.setBizScenario(bizScenario);
        return tradeService.createTrade(tradeAddCmd);
    }

//    @Resource
//    private DomainEventMQPublisher domainEventMQPublisher;
//    @Resource
//    private DomainEventPublisher domainEventPublisher;
//
//    @GetMapping("/send")
//    public Response send(String msg) {
//        TradeCreatedEvent tradeCreatedEvent = new TradeCreatedEvent(UUID.randomUUID().toString() + ":" + msg);
//        domainEventMQPublisher.publish(tradeCreatedEvent);
//        domainEventPublisher.publish(tradeCreatedEvent);
//        return Response.buildSuccess();
//    }

}
