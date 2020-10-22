package top.dfghhj.domain.logistics;

import lombok.Data;

@Data
public class LogisticsStatus {

    private String status;

    private Long createTime;

    private Long modifiedTime;

    private Logistics logistics;

    public LogisticsStatus(Logistics logistics) {
        this.logistics = logistics;
    }
}
