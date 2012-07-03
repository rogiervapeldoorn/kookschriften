package nl.ordina.rogier.kookschriften.client.view;

import nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory;
import nl.ordina.rogier.kookschriften.client.GewichtEenheid;
import nl.ordina.rogier.kookschriften.client.IngredientRegelRequest;
import nl.ordina.rogier.kookschriften.client.ReceptRequest;
import nl.ordina.rogier.kookschriften.client.controller.IngredientController;
import nl.ordina.rogier.kookschriften.client.model.IngredientManager;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientRegelProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.IntegerBox;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class IngredientView extends Composite implements HasText {

    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    private static IngredientUiBinder uiBinder = GWT.create(IngredientUiBinder.class);
    @UiField 
    public TextBox Ingredient;
    @UiField 
    public ListBox Eenheid;
    @UiField public IntegerBox Gewicht;

    interface IngredientUiBinder extends UiBinder<Widget, IngredientView> {
    }

    public IngredientView() {
	initWidget(uiBinder.createAndBindUi(this));
	IngredientController ingredientController= new IngredientController( this);
	IngredientManager ingredientManager = new IngredientManager(ingredientController);
    }

    
    public void setText(String text) {
    }

    public String getText() {
	return null;
    }
    
    public IngredientRegelProxy getIngredientRegelProxy(ReceptRequest receptRequest)
    {
	IngredientRegelProxy ingredientRegelProxy =receptRequest.create(IngredientRegelProxy.class);
	ingredientRegelProxy.setGewicht(new Long(Gewicht.getValue()));
	ingredientRegelProxy.setGewichtEenheid(GewichtEenheid.valueOf(Eenheid.getValue(Eenheid.getSelectedIndex())));
	ingredientRegelProxy.setIngredient(Ingredient.getValue());
	System.out.println("Gewicht:"+ingredientRegelProxy.getGewicht());
	System.out.println("GewichtEenheid:"+ingredientRegelProxy.getGewichtEenheid());
	System.out.println("Ingredient:"+ingredientRegelProxy.getIngredient());
	return ingredientRegelProxy;
    }

}
