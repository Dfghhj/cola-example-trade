package top.dfghhj.domain.commodity.rule;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryRules {

    /* 可以超卖 */
    private boolean canOversold;

    /* 当前超卖数量 */
    private Integer count;

    /* 允许超卖数量 */
    private Integer allowCount;

}
