package top.dfghhj.domain.gateway.merchant;

import top.dfghhj.domain.merchant.Merchant;

public interface MerchantGatewayI {

    Merchant getMerchantByMerchantId(String merchantId);
}
