package top.dfghhj.service.trade;

import com.alibaba.cola.dto.Response;
import top.dfghhj.api.trade.TradeServiceI;
import top.dfghhj.dto.trade.TradeAddCmd;
import top.dfghhj.executor.trade.create.TradeAddCmdExe;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class TradeServiceImpl implements TradeServiceI {

    @Resource
    private TradeAddCmdExe tradeAddCmdExe;

    @Override
    public Response createTrade(TradeAddCmd tradeAddCmd) {
        return tradeAddCmdExe.execute(tradeAddCmd);
    }
}
