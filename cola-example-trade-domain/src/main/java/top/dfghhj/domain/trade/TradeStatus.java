package top.dfghhj.domain.trade;

import lombok.Data;

@Data
public class TradeStatus {

    private Long id;

    private String status;

    private Long createTime;

    private Long modifiedTime;

    private Trade trade;

    public TradeStatus(Trade trade, String status) {
        this.trade = trade;
        this.status = status;
    }

    @Override
    public String toString() {
        return "TradeStatus{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", trade=" + trade.getOrderId() +
                '}';
    }
}
