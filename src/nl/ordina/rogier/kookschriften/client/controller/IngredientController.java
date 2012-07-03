package nl.ordina.rogier.kookschriften.client.controller;

import nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory;
import nl.ordina.rogier.kookschriften.client.GewichtEenheid;
import nl.ordina.rogier.kookschriften.client.view.IngredientView;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class IngredientController{

    IngredientView ingredient;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);
    
    public IngredientController(IngredientView ingredient) {
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	this.ingredient = ingredient;
	init();
	bind();
    }

    private void init() {
	GewichtEenheid[] gewichtEenhedenArray=GewichtEenheid.values();
	for (GewichtEenheid gewichtEenheid : gewichtEenhedenArray) {
	    ingredient.Eenheid.addItem(gewichtEenheid.toString());
	}

    }

    private void bind() {
	
    }

   

}
