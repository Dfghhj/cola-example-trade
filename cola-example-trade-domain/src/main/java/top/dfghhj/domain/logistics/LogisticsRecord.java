package top.dfghhj.domain.logistics;

import lombok.Data;

@Data
public class LogisticsRecord {

    private String sourceAddr;

    private String targetAddr;

    private Long createTime;

    private Long modifiedTime;

    private Logistics logistics;

    public LogisticsRecord(Logistics logistics) {
        this.logistics = logistics;
    }
}
