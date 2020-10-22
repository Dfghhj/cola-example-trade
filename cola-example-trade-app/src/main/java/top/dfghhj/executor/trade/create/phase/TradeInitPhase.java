package top.dfghhj.executor.trade.create.phase;

import top.dfghhj.domain.DomainFactory;
import top.dfghhj.domain.commodity.Commodity;
import top.dfghhj.domain.gateway.commodity.CommodityGatewayI;
import top.dfghhj.domain.gateway.shopper.ShopperGatewayI;
import top.dfghhj.domain.shopper.Shopper;
import top.dfghhj.domain.trade.Trade;
import top.dfghhj.domain.trade.commodity.TradeCommodity;
import top.dfghhj.dto.trade.TradeAddCmd;
import top.dfghhj.dto.trade.domainmodel.TradeCommodityDTO;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Component
public class TradeInitPhase {

    @Resource
    private ShopperGatewayI shopperGateway;
    @Resource
    private CommodityGatewayI commodityGateway;

    public Trade initTrade(TradeAddCmd cmd) {
        //下单人
        Shopper shopper = shopperGateway.getShopperById(cmd.getShopperId());
        //商品列表
        List<TradeCommodity> tradeCommodityList = new ArrayList<>();
        for (TradeCommodityDTO tradeCommodityDTO:cmd.getCommodityList()) {
            Commodity commodity = commodityGateway.getCommodityById(tradeCommodityDTO.getCommodityId());
            TradeCommodity tradeCommodity = new TradeCommodity(commodity, tradeCommodityDTO.getCount());
            tradeCommodityList.add(tradeCommodity);
        }
        //订单信息
        Trade trade = DomainFactory.getTrade();
        trade.setBizScenario(cmd.getBizScenario());
        trade.setShopper(shopper);
        trade.setCommodityList(tradeCommodityList);
        trade.setTargetAddr(cmd.getTargetAddr());
        trade.setSource(cmd.getSource());
        trade.setType(cmd.getType());
        trade.setCreatTime(System.currentTimeMillis());

        return trade;
    }
}
