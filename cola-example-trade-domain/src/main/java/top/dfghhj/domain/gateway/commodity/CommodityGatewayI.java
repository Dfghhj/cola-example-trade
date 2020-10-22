package top.dfghhj.domain.gateway.commodity;

import top.dfghhj.domain.commodity.Commodity;

import java.util.List;

public interface CommodityGatewayI {

    List<Commodity> getCommodityListByIds(List<String> commodityIds);

    Commodity getCommodityById(String commodityId);
}
