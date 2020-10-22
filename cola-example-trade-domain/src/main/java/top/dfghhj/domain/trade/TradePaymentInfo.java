package top.dfghhj.domain.trade;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class TradePaymentInfo {

    /* 支付Id */
    private String paymentId;

    /* 支付方式 */
    private String payMode;

    /* 原始金额 */
    private BigDecimal originalAmount;

    /* 实付金额 */
    private BigDecimal actuallyAmount;


    private Trade trade;

    @Override
    public String toString() {
        return "TradePaymentInfo{" +
                "paymentId='" + paymentId + '\'' +
                ", payMode='" + payMode + '\'' +
                ", originalAmount='" + originalAmount + '\'' +
                ", actuallyAmount='" + actuallyAmount + '\'' +
                ", trade=" + trade.getOrderId() +
                '}';
    }
}
