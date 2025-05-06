package com.samson.events.ticket;

import com.samson.events.order.OrderCompletedEvent;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@AllArgsConstructor
public class TicketOrderFailedListener {

    private final TicketService ticketService;

    @TransactionalEventListener(phase = TransactionPhase.AFTER_ROLLBACK)
    public void onOrderCompletedEvent(OrderCompletedEvent event){
        ticketService.createTicket(event.getOrder());
    }
}
