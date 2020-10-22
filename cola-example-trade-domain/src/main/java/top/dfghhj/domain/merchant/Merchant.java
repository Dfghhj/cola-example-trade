package top.dfghhj.domain.merchant;

import com.alibaba.cola.domain.EntityObject;
import lombok.Data;

@Data
public class Merchant extends EntityObject {

    /* id */
    private Long id;

    /* 商家Id */
    private String merchantId;

    /* 商家名称 */
    private String merchantName;

    /* 商家状态 */
    private String status;

    public boolean isNormal() {
        return "normal".equals(status);
    }
}
