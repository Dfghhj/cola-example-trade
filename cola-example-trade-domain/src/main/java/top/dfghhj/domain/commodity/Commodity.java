package top.dfghhj.domain.commodity;

import com.alibaba.cola.domain.EntityObject;
import com.alibaba.cola.exception.BizException;
import top.dfghhj.domain.commodity.rule.ActivityRules;
import top.dfghhj.domain.commodity.rule.InventoryRules;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class Commodity extends EntityObject {

    private String id;
    private String commodityId;
    private String commodityName;
    private String description;
    /* 价格 */
    private BigDecimal price;
    /* 价格活动策略 */
    private ActivityRules activityRules;

    /* 库存数量 */
    private Integer inventory;
    /* 库存规则 */
    private InventoryRules inventoryRules;

    /**
     * 限购数量
     * -1 ： 表示不限购，只要有库存
     */
    private Integer purchaseLimit;


    /**
     * 根据 price 和 activityRules，计算活动价格
     * @return
     */
    public BigDecimal calculateActivityPrice() {
        // 计算活动价格

        return price;
    }

    /**
     * 计算库存是否足够
     * @param count
     * @return
     */
    public boolean preReduceInventory(Integer count) {
        if (inventory >= count ) {
            return true;
        } else if (inventoryRules != null && inventoryRules.isCanOversold()) {
            if (inventory + inventoryRules.getAllowCount() - inventoryRules.getCount() > count) {
                return true;
            }
        }
        return false;
    }

    /**
     * 减库存
     * @param count
     */
    public void reduceInventory(Integer count) {
        if (preReduceInventory(count)) {
            if (inventory > count) {
                inventory -= count;
            } else {
                inventory = 0;
                inventoryRules.setCount(inventoryRules.getCount() + count - inventory);
            }
        } else {
            throw new BizException("库存不足");
        }
    }

}
