package top.dfghhj.api.trade;

import com.alibaba.cola.dto.Response;
import top.dfghhj.dto.trade.TradeAddCmd;

public interface TradeServiceI {
    Response createTrade(TradeAddCmd tradeAddCmd);
}
