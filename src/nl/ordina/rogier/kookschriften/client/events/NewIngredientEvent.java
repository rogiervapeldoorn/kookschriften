package nl.ordina.rogier.kookschriften.client.events;

import com.google.gwt.event.shared.GwtEvent;

public class NewIngredientEvent extends GwtEvent<NewIngredientEventHandler>{

    public static Type<NewIngredientEventHandler> TYPE = new Type<NewIngredientEventHandler>();

    private final String message;

    public NewIngredientEvent(String message) {
        this.message = message;
    }

    @Override
    public Type<NewIngredientEventHandler> getAssociatedType() {
        return TYPE;
    }

    @Override
    protected void dispatch(NewIngredientEventHandler handler) {
        handler.onNewIngredient(this);
    }

    public String getMessage() {
        return message;
    }

}
