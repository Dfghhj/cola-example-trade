package top.dfghhj.dto.trade.domainmodel;

import lombok.Data;

@Data
public class ShippingAddrDTO {

    /* 目的地 */
    private String destinationAddr;

    /* 收件人 */
    private String addressee;

    /* 收件人联系电话 */
    private String phoneNumber;

}


