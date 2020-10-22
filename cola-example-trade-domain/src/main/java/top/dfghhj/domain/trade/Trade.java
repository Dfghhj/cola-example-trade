package top.dfghhj.domain.trade;

import com.alibaba.cola.domain.EntityObject;
import com.alibaba.cola.exception.BizException;
import lombok.Data;
import top.dfghhj.domain.customer.Customer;
import top.dfghhj.domain.logistics.Logistics;
import top.dfghhj.domain.merchant.Merchant;
import top.dfghhj.domain.trade.rule.TradeRule;
import top.dfghhj.dto.trade.domainmodel.TradeStatusEnum;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
public class Trade extends EntityObject {

    /* id */
    private Long id;

    /* 订单Id */
    private String orderId;

    /* 顾客（买方） */
    private Customer customer;

    /* 商家 */
    private Merchant merchant;

    /* 订单内容 */
    private List<TradeCommodity> commodityList;

    /* 物流信息 */
    private Logistics logistics;

    /* 商品原金额 */
    private BigDecimal commodityAmount;

    /* 商品优惠后金额 */
    private BigDecimal commodityAfterDiscountAmount;

    /* 运费 */
    private BigDecimal logisticsAmount;

    /* 总费用 */
    private BigDecimal amount;

    /* 付款信息 */
    private TradePaymentInfo paymentInfo;

    /* 订单状态流 */
    private List<TradeStatus> orderStatusList;

    /* 创建时间 */
    private Long createTime;

    public void changeStatus(TradeStatusEnum tradeStatusEnum) {
        if (orderStatusList == null) {
            orderStatusList = new ArrayList<>();
        }
        orderStatusList.add(new TradeStatus(this, tradeStatusEnum.name()));
    }



    /**
     * 计算订单最后成交金额
     */
    public void calculateAmount(List<TradeRule> tradeRuleList) {
        if (tradeRuleList == null || tradeRuleList.size() == 0) {
            this.amount = this.commodityAfterDiscountAmount.add(this.logisticsAmount);
        }
    }

    /**
     * 计算商品原始价格
     * @return
     */
    public void calculateCommodityOriginalAmount() {
        BigDecimal commodityAmount = new BigDecimal("0");
        for (TradeCommodity tradeCommodity:commodityList) {
            commodityAmount = commodityAmount.add(tradeCommodity.getCommodity().getOriginalAmount());
        }
        this.commodityAmount = commodityAmount;
    }

    /**
     * 计算商品折扣价格
     * @return
     */
    public void calculateCommodityAmount() {
        BigDecimal commodityAfterDiscountAmount = new BigDecimal("0");
        for (TradeCommodity tradeCommodity:commodityList) {
            commodityAfterDiscountAmount = commodityAfterDiscountAmount.add(tradeCommodity.calculateAmount());
        }
        this.commodityAfterDiscountAmount = commodityAfterDiscountAmount;
    }

    /**
     * 计算运费
     * 1.是否包邮
     * 2.按距离计算运费
     * 3.按快递运输时间计算运费
     */
    public void calculateLogisticsAmount() {
        this.logisticsAmount = new BigDecimal("0");
    }

    @Override
    public String toString() {
        return "Trade{" +
                "id=" + id +
                ", orderId='" + orderId + '\'' +
                ", customer=" + customer +
                ", merchant=" + merchant +
                ", commodityList=" + commodityList +
                ", logistics=" + logistics +
                ", commodityAmount=" + commodityAmount +
                ", logisticsAmount=" + logisticsAmount +
                ", amount=" + amount +
                ", paymentInfo=" + paymentInfo +
                ", orderStatusList=" + orderStatusList +
                ", createTime=" + createTime +
                '}';
    }

    public TradeStatus getLastTradeStatus() {
        Optional<TradeStatus> tradeStatusOptional = orderStatusList.stream().max(Comparator.comparing(TradeStatus::getCreateTime));
        if (!tradeStatusOptional.isPresent()) {
            throw new BizException("订单状态异常");
        }
        return tradeStatusOptional.get();
    }
}
