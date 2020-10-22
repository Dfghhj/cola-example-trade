package top.dfghhj.gateway.commodity;

import top.dfghhj.domain.commodity.Commodity;
import top.dfghhj.domain.commodity.rule.ActivityRules;
import top.dfghhj.domain.commodity.rule.InventoryRules;
import top.dfghhj.domain.gateway.commodity.CommodityGatewayI;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class CommodityGatewayImpl implements CommodityGatewayI {

    @Override
    public List<Commodity> getCommodityListByIds(List<String> commodityIds) {
        return null;
    }

    @Override
    public Commodity getCommodityById(String commodityId) {
        Commodity commodity = new Commodity();
        commodity.setId(commodityId);
        commodity.setCommodityId(commodityId);
        commodity.setCommodityName("name_" + commodityId);
        commodity.setPrice(new BigDecimal("10"));
        commodity.setActivityRules(new ActivityRules());
        commodity.setInventory(20);
        commodity.setInventoryRules(new InventoryRules(true, 0, 10));
        commodity.setPurchaseLimit(5);
        return commodity;
    }
}
