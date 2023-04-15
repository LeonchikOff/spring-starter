package org.example.spring.listener;


import org.example.spring.listener.entity.EntityEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EntityListener {

    @EventListener(condition = "#root.args[0].accessType.name() == 'READ'")
    public void acceptEntityRead(EntityEvent entityEvent) {
        System.out.println("Entity: " + entityEvent);
    }
}
