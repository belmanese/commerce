package com.beitech.commerce.dto;

import com.beitech.commerce.model.Customer;
import com.beitech.commerce.model.Order;
import lombok.*;

import java.util.List;

/**
 * @author belman
 * Created by on 9/6/15.
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDto extends Customer {

    @Getter @Setter
    private Order order;

    @Getter @Setter
    private List<Customer> customers;

}
