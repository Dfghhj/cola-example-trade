package top.dfghhj.domain.trade;

import lombok.Data;

@Data
public class TradeStatus {

    private Long id;

    private String status;

    private Long createTime;

    private Trade trade;

    public TradeStatus(Trade trade, String status) {
        this.trade = trade;
        this.status = status;
        this.createTime = System.currentTimeMillis();
    }

    @Override
    public String toString() {
        return "TradeStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", trade=" + trade.getOrderId() +
                '}';
    }
}
