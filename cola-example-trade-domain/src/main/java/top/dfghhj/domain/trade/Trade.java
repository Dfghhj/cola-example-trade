package top.dfghhj.domain.trade;

import com.alibaba.cola.domain.EntityObject;
import top.dfghhj.domain.shopper.Shopper;
import top.dfghhj.domain.trade.commodity.TradeCommodity;
import top.dfghhj.domain.trade.logistics.Logistics;
import top.dfghhj.domain.trade.payment.PaymentInfo;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
@NoArgsConstructor
public class Trade extends EntityObject {

    /* 订单号 */
    private String tradeId;

    /* 顾客信息 */
    private Shopper shopper;

    /* 商品列表 */
    private List<TradeCommodity> commodityList;

    /* 支付信息 */
    private PaymentInfo paymentInfo;

    /* 物流信息 */
    private Logistics logistics;

    /* 订单状态 */
    private List<TradeStatus> tradeStatus;

    /* 收货地址 */
    private String targetAddr;

    /* 订单来源 */
    @NotEmpty
    private String source;

    /* 订单类型 */
    @NotEmpty
    private String type;

    /* 创建时间 */
    private Long creatTime;

}