package top.dfghhj.domain.trade.commodity;

import top.dfghhj.domain.commodity.Commodity;
import lombok.Data;

@Data
public class TradeCommodity {

    private Commodity commodity;

    private Integer count;

    public TradeCommodity(Commodity commodity, Integer count) {
        this.commodity = commodity;
        this.count = count;
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
