package com.samson.events.promotion;

import com.samson.events.customer.Customer;
import com.samson.events.customer.CustomerRepository;
import com.samson.events.order.Order;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

import static java.math.BigDecimal.TEN;

@Slf4j
@RequiredArgsConstructor
@Component
public class PromotionService
{
    private final CustomerRepository customerRepository;

    public void applyPromotion(Customer customer)
    {
        log.info("Apply free gift for a customer {}", customer);
    }

    public void calculateRewardPoints(Order order)
    {
        Customer customer = order.getCustomer();

        //for each order entry (product + quantity) gather reward status points
        //for simulation we will append 10 points per order
        BigDecimal newRewardPoints = customer.getRewardPoints().add(TEN);
        customer.setRewardPoints(newRewardPoints);
        customerRepository.save(customer);
        log.info("Customer {}, reward points old: {}, new: {}", customer.getId(), customer.getRewardPoints(), newRewardPoints);
    }
}
