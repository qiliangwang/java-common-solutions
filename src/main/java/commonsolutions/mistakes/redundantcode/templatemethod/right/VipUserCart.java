package commonsolutions.mistakes.redundantcode.templatemethod.right;

import commonsolutions.mistakes.redundantcode.templatemethod.Db;
import commonsolutions.mistakes.redundantcode.templatemethod.Item;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service(value = "VipUserCart")
public class VipUserCart extends NormalUserCart {

    @Override
    protected void processCouponPrice(long userId, Item item) {
        if (item.getQuantity() > 2) {
            item.setCouponPrice(item.getPrice()
                    .multiply(BigDecimal.valueOf(100 - Db.getUserCouponPercent(userId)).divide(new BigDecimal("100")))
                    .multiply(BigDecimal.valueOf(item.getQuantity() - 2)));
        } else {
            item.setCouponPrice(BigDecimal.ZERO);
        }
    }
}
