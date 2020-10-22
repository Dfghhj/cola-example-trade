package top.dfghhj.gateway.customer;

import org.springframework.stereotype.Service;
import top.dfghhj.domain.customer.Customer;
import top.dfghhj.domain.gateway.customer.CustomerGatewayI;

@Service
public class CustomerGateway implements CustomerGatewayI {

    @Override
    public Customer getCustomerByCustomerId(String customerId) {
        Customer customer = new Customer();
        customer.setCustomerId(customerId);
        customer.setStatus("normal");
        return customer;
    }
}
