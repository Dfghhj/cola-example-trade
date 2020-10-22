package top.dfghhj.domain.shopper;

import com.alibaba.cola.domain.EntityObject;
import com.alibaba.cola.exception.Assert;
import lombok.Data;

import java.util.List;

@Data
public class Shopper extends EntityObject {

    private String id;
    private String userId;
    private String userName;
    /* 收货地址 */
    private List<ShippingAddr> shippingAddrList;

    /* 获取默认地址 */
    public ShippingAddr getDefaultShippingAddr() {
        Assert.notEmpty(shippingAddrList, "收获地址为空");
        return shippingAddrList.stream().filter(ShippingAddr::isDefault).findFirst().orElse(shippingAddrList.get(0));
    }

}
