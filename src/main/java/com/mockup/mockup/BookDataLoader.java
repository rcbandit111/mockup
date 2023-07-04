package com.mockup.mockup;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class BookDataLoader {

    @Value("${init.message}")
    String message;

    @EventListener(ApplicationReadyEvent.class)
    public void loadBookTestData()
    {
        System.out.println(message);
    }
}
