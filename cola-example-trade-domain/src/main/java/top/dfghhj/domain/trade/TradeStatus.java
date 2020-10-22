package top.dfghhj.domain.trade;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TradeStatus {

    private Long id;

    private String status;

    private Long createTime;

    private Long modifiedTime;

    private Trade trade;

    public TradeStatus(Trade trade, String status) {
        this.status = status;
        this.createTime = System.currentTimeMillis();
        this.trade = trade;
        List<TradeStatus> statusList = trade.getTradeStatus();
        if (statusList == null) {
            statusList = new ArrayList<>();
        }
        statusList.add(this);
    }
}
