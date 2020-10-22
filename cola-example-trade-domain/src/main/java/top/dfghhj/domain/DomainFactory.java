package top.dfghhj.domain;

import top.dfghhj.domain.trade.Trade;

public class DomainFactory {

    public static Trade createNewTrade() {
        return new Trade();
    }

}
