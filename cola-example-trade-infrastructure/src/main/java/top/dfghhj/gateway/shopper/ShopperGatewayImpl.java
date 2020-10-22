package top.dfghhj.gateway.shopper;

import top.dfghhj.domain.gateway.shopper.ShopperGatewayI;
import top.dfghhj.domain.shopper.ShippingAddr;
import top.dfghhj.domain.shopper.Shopper;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class ShopperGatewayImpl implements ShopperGatewayI {

    @Override
    public Shopper getShopperById(String shopperId) {
        Shopper shopper = new Shopper();
        shopper.setId(shopperId);
        shopper.setUserId(shopperId);
        shopper.setUserName("张三");
        shopper.setShippingAddrList(Collections.singletonList(new ShippingAddr("hz", true)));
        return shopper;
    }
}
