package nl.ordina.rogier.mijnkookschrift.client.events;

import com.google.gwt.event.shared.EventHandler;

public interface NewIngredientEventHandler extends EventHandler {
    void onNewIngredient(NewIngredientEvent event);
}