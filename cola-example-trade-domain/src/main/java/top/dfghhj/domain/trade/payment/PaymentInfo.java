package top.dfghhj.domain.trade.payment;

import top.dfghhj.domain.trade.Trade;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class PaymentInfo {

    private String type;

    private String paymentId;

    private BigDecimal paymentAmount;

    private Trade trade;

    public PaymentInfo(Trade trade) {
        this.trade = trade;
        trade.setPaymentInfo(this);
    }
}
