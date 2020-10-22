package top.dfghhj.domain.trade;

import lombok.AllArgsConstructor;
import lombok.Data;
import top.dfghhj.domain.commodity.Commodity;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class TradeCommodity {

    private Commodity commodity;

    private Integer count;

    /**
     * 计算价格
     * @return
     */
    public BigDecimal calculateAmount() {
        return  commodity.calculateAmount().multiply(BigDecimal.valueOf(count));
    }

    /**
     * 校验库存是否足够
     * @return
     */
    public boolean checkInventory() {
        return commodity.preReduceInventory(count);
    }

    /**
     * 校验有没有超过限购可以购买
     * @return
     */
    public boolean checkPurchaseLimit() {
        if (commodity.getPurchaseLimit() == -1) {
            return true;
        }
        return commodity.getPurchaseLimit() > count;
    }
}
