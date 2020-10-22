package top.dfghhj.domain.customer;

import com.alibaba.cola.domain.EntityObject;
import lombok.Data;

import java.util.List;

@Data
public class Customer extends EntityObject {

    /* id */
    private Long id;

    /* 顾客Id */
    private String customerId;

    /* 顾客名称 */
    private String customerName;

    /* 联系电话 */
    private String phoneNumber;

    /* 客户类型（普通、vip） */
    private Boolean customerType;

    /* vip等级 */
    private Integer vipLevel;

    /* 收货地址 */
    private List<ShippingAddr> shippingAddrList;

    /* 顾客状态 */
    private String status;

    public boolean isNormal() {
        return "normal".equals(status);
    }
}
