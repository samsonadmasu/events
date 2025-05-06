package com.samson.events.order;

import lombok.Data;

@Data
public class OrderCompletedEvent {
    private final Order order;
}
