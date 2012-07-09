package nl.ordina.rogier.kookschriften.client.view;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory;
import nl.ordina.rogier.kookschriften.client.GewichtEenheid;
import nl.ordina.rogier.kookschriften.client.ReceptRequest;
import nl.ordina.rogier.kookschriften.client.controller.IngredientController;
import nl.ordina.rogier.kookschriften.client.events.NewIngredientEvent;
import nl.ordina.rogier.kookschriften.client.events.NewIngredientEventHandler;
import nl.ordina.rogier.kookschriften.client.model.IngredientManager;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientProxy;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientRegelProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerManager;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.event.shared.HasHandlers;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.SuggestBox;
import com.google.gwt.user.client.ui.SuggestOracle;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class IngredientView extends Composite implements HasText, HasHandlers {

    private boolean gewichtHasValue = false;
    private boolean ingredientHasValue = false;
    private HandlerManager handlerManager;

    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);
    
    public MultiWordSuggestOracle ingredients = new MultiWordSuggestOracle();
    public List<String> listofIngredients=new ArrayList<String>();
    private static IngredientUiBinder uiBinder = GWT.create(IngredientUiBinder.class);
    @UiField(provided = true) 
    public SuggestBox Ingredient;
    @UiField
    public ListBox Eenheid;
    @UiField
    public TextBox Gewicht;
    
    interface IngredientUiBinder extends UiBinder<Widget, IngredientView> {
    }

    public IngredientView(MultiWordSuggestOracle ingredients,List<String> listofIngredients) {
	this.ingredients=ingredients;
	this.listofIngredients=listofIngredients;
	Ingredient=new SuggestBox(ingredients);
	initWidget(uiBinder.createAndBindUi(this));
	IngredientController ingredientController = new IngredientController(this);
	IngredientManager ingredientManager = new IngredientManager(ingredientController);
	
	handlerManager = new HandlerManager(this);
	Gewicht.addValueChangeHandler(new ValueChangeHandler<String>() {

	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {
		if (event.getValue() != null && event.getValue() != "") {
		    try {
			new Double(event.getValue());
			Gewicht.setStyleName("gwt-DialogBox");
		    } catch (NumberFormatException e) {
			Gewicht.setStyleName("gwt-DialogBox-error");
		    }
		    gewichtHasValue = true;
		} else {
		    gewichtHasValue = false;
		}
		if (ingredientHasValue && gewichtHasValue) {
		    NewIngredientEvent newIngredientEvent = new NewIngredientEvent("");
		    fireEvent(newIngredientEvent);
		}
	    }
	});
	Ingredient.addValueChangeHandler(new ValueChangeHandler<String>() {

	    @Override
	    public void onValueChange(ValueChangeEvent<String> event) {

		if (event.getValue() != null && event.getValue() != "") {
		    ingredientHasValue = true;
		} else {
		    ingredientHasValue = false;
		}
		if (ingredientHasValue && gewichtHasValue) {
		    NewIngredientEvent newIngredientEvent = new NewIngredientEvent("");
		    fireEvent(newIngredientEvent);
		}
	    }
	});
    }

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

    public IngredientRegelProxy getIngredientRegelProxy(ReceptRequest receptRequest) {
	IngredientRegelProxy ingredientRegelProxy = receptRequest.create(IngredientRegelProxy.class);
	if (Gewicht != null && Gewicht.getValue() != null&&Gewicht.getValue().length()>0) {
	    ingredientRegelProxy.setGewicht(new Double(Gewicht.getValue()));
	    ingredientRegelProxy.setGewichtEenheid(GewichtEenheid.valueOf(Eenheid.getValue(Eenheid.getSelectedIndex())));
	    ingredientRegelProxy.setIngredient(Ingredient.getValue().toLowerCase());
	    return ingredientRegelProxy;
	}
	return null;
    }

    @Override
    public void fireEvent(GwtEvent<?> event) {
	handlerManager.fireEvent(event);
    }

    public HandlerRegistration addNewIngredientEventHandler(NewIngredientEventHandler handler) {
	return handlerManager.addHandler(NewIngredientEvent.TYPE, handler);
    }

}
