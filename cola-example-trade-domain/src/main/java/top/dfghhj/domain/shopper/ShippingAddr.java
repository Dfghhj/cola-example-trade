package top.dfghhj.domain.shopper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShippingAddr {

    private String addr;

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
