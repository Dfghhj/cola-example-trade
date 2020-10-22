package top.dfghhj.domain.trade.logistics;

import lombok.Data;

@Data
public class LogisticsRecord {

    private String source;

    private String target;

    private Long createTime;

    private Long modifiedTime;

    private Logistics logistics;

    public LogisticsRecord(Logistics logistics) {
        this.logistics = logistics;
    }
}
