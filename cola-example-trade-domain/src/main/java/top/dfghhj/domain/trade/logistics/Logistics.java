package top.dfghhj.domain.trade.logistics;

import com.alibaba.cola.exception.Assert;
import top.dfghhj.domain.trade.Trade;
import lombok.Data;

import java.util.Comparator;
import java.util.List;

@Data
public class Logistics {

    private String type;

    /* 物流单号 */
    private String logisticsId;

    private String source;

    private String target;

    private Long createTime;

    private Long modifiedTime;

    private List<LogisticsRecord> recordList;

    private Trade trade;

    public Logistics(Trade trade) {
        this.trade = trade;
        trade.setLogistics(this);
    }

    /**
     * 获取最新物流信息
     * @return
     */
    public LogisticsRecord checkTheLatestLogisticsInfo() {
        Assert.notEmpty(recordList, "物流信息为空");
        return recordList.stream().max(Comparator.comparingLong(LogisticsRecord::getCreateTime)).orElse(null);
    }
}
