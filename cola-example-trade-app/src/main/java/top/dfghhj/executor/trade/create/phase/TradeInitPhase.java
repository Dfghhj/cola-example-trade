package top.dfghhj.executor.trade.create.phase;

import com.alibaba.cola.exception.Assert;
import top.dfghhj.domain.DomainFactory;
import top.dfghhj.domain.commodity.Commodity;
import top.dfghhj.domain.customer.Customer;
import top.dfghhj.domain.gateway.commodity.CommodityGatewayI;
import top.dfghhj.domain.gateway.customer.CustomerGatewayI;
import top.dfghhj.domain.gateway.merchant.MerchantGatewayI;
import top.dfghhj.domain.logistics.Logistics;
import top.dfghhj.domain.merchant.Merchant;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.domain.trade.TradeCommodity;
import top.dfghhj.domain.trade.TradeStatus;
import top.dfghhj.dto.trade.TradeAddCmd;
import top.dfghhj.dto.trade.domainmodel.TradeCommodityDTO;
import org.springframework.stereotype.Component;
import top.dfghhj.dto.trade.domainmodel.TradeStatusEnum;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class TradeInitPhase {

    @Resource
    private CustomerGatewayI customerGateway;
    @Resource
    private MerchantGatewayI merchantGateway;
    @Resource
    private CommodityGatewayI commodityGateway;

    public Trade initTrade(TradeAddCmd cmd) {
        //下单人
        Customer customer = customerGateway.getCustomerByCustomerId(cmd.getCustomerId());
        //商家
        Merchant merchant = merchantGateway.getMerchantByMerchantId(cmd.getMerchantId());
        //商品列表
        List<TradeCommodity> tradeCommodityList = new ArrayList<>();
        for (TradeCommodityDTO tradeCommodityDTO:cmd.getCommodityList()) {
            Commodity commodity = commodityGateway.getCommodityById(tradeCommodityDTO.getCommodityId());
            Assert.isTrue(merchant.getMerchantId().equals(commodity.getMerchantId()), "商家没有该商品：" + commodity.getCommodityName());
            TradeCommodity tradeCommodity = new TradeCommodity(commodity, tradeCommodityDTO.getCount());
            tradeCommodityList.add(tradeCommodity);
        }
        //订单信息
        Trade trade = DomainFactory.createNewTrade();
        trade.setBizScenario(cmd.getBizScenario());
        trade.setCustomer(customer);
        trade.setMerchant(merchant);
        trade.setCommodityList(tradeCommodityList);
        trade.setCreateTime(System.currentTimeMillis());
        if (cmd.getShippingAddr() != null) {
            Logistics logistics = new Logistics();
            logistics.setDestinationAddr(cmd.getShippingAddr().getDestinationAddr());
            logistics.setAddressee(cmd.getShippingAddr().getAddressee());
            logistics.setPhoneNumber(cmd.getShippingAddr().getPhoneNumber());
            logistics.setTrade(trade);
            trade.setLogistics(logistics);
        }
        trade.changeStatus(TradeStatusEnum.TO_BE_PAID);
        return trade;
    }
}
