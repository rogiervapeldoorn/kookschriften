package nl.ordina.rogier.kookschriften.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface NewIngredientEventHandler extends EventHandler {
    void onNewIngredient(NewIngredientEvent event);
}