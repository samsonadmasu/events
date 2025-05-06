package com.samson.events.promotion;

import com.samson.events.customer.CustomerRegisteredEvent;
import com.samson.events.order.OrderCompletedEvent;
import lombok.AllArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class PromotionListeners {

    private final PromotionService promotionService;

    @EventListener(condition = "#event.customer.newsletter")
    public void onRegistrationEvent(CustomerRegisteredEvent event){
        promotionService.applyPromotion(event.getCustomer());
    }

    @EventListener
    public void onOrderCompletedEvent(OrderCompletedEvent event){
        promotionService.calculateRewardPoints(event.getOrder());
    }
}
