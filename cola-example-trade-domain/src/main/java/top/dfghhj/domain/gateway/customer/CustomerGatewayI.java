package top.dfghhj.domain.gateway.customer;

import top.dfghhj.domain.customer.Customer;

public interface CustomerGatewayI {

    Customer getCustomerByCustomerId(String customerId);
}
