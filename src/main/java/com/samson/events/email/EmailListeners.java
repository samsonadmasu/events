package com.samson.events.email;

import com.samson.events.customer.CustomerRegisteredEvent;
import com.samson.events.customer.CustomerRemovedEvent;
import com.samson.events.order.OrderCompletedEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class EmailListeners {
    private final EmailService emailService;

    @EventListener
    public void onRegistered(CustomerRegisteredEvent event) {
        emailService.sendRegisterEmail(event.getCustomer());
    }

    @EventListener
    public void onDeleted(CustomerRemovedEvent event) {
        emailService.sendCustomerRemovedEmail(event.getCustomer());
    }

    @EventListener
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    public void onOrderCompletedEvent(OrderCompletedEvent event){
        emailService.sendOrderEmail(event.getOrder());
    }
}
