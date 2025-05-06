package com.samson.events.ticket;

import com.samson.events.order.Order;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class TicketService
{

    public void createTicket(Order order)
    {
        log.info("Creating ticket for helpdesk service for order {}", order);
    }
}
