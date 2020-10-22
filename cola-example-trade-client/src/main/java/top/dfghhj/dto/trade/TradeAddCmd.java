package top.dfghhj.dto.trade;

import com.alibaba.cola.dto.Command;
import top.dfghhj.dto.trade.domainmodel.ShippingAddrDTO;
import top.dfghhj.dto.trade.domainmodel.TradeCommodityDTO;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Data
public class TradeAddCmd extends Command {

    @NotEmpty
    private String customerId;

    @NotEmpty
    private String merchantId;

    private ShippingAddrDTO shippingAddr;

    @NotEmpty
    private List<TradeCommodityDTO> commodityList;

    /* 订单来源 */
    @NotEmpty
    private String source;

    /* 订单类型 */
    @NotEmpty
    private String type;
}
