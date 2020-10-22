package top.dfghhj.domain.customer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddr {

    private String addr;

    /* 收件人 */
    private String addressee;

    /* 联系电话 */
    private String phoneNumber;

    private boolean isDefault;

    public boolean isDefault() {
        return isDefault;
    }

    @Override
    public String toString() {
        return "ShippingAddr{" +
                "addr='" + addr + '\'' +
                ", isDefault=" + isDefault +
                '}';
    }
}
