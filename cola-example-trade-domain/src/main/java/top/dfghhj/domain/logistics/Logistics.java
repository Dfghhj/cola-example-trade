package top.dfghhj.domain.logistics;

import com.alibaba.cola.domain.EntityObject;
import lombok.Data;
import top.dfghhj.domain.trade.Trade;

import java.util.List;

@Data
public class Logistics extends EntityObject {

    /* 物流单号 */
    private String logisticsId;

    /* 始发地 */
    private String originAddr;

    /* 目的地 */
    private String destinationAddr;

    /* 收件人 */
    private String addressee;

    /* 收件人联系电话 */
    private String phoneNumber;

    /* 物流流转记录 */
    private List<LogisticsRecord> recordList;

    /* 物流状态流 */
    private List<LogisticsStatus> statusList;

    private Trade trade;

    @Override
    public String toString() {
        return "Logistics{" +
                "logisticsId='" + logisticsId + '\'' +
                ", originAddr='" + originAddr + '\'' +
                ", destinationAddr='" + destinationAddr + '\'' +
                ", addressee='" + addressee + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", recordList=" + recordList +
                ", statusList=" + statusList +
                ", trade=" + trade.getOrderId() +
                '}';
    }
}
