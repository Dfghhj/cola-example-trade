package top.dfghhj.gateway.merchant;

import org.springframework.stereotype.Service;
import top.dfghhj.domain.gateway.merchant.MerchantGatewayI;
import top.dfghhj.domain.merchant.Merchant;

@Service
public class MerchantGateway implements MerchantGatewayI {

    @Override
    public Merchant getMerchantByMerchantId(String merchantId) {
        Merchant merchant = new Merchant();
        merchant.setMerchantId(merchantId);
        merchant.setStatus("normal");
        return merchant;
    }
}
