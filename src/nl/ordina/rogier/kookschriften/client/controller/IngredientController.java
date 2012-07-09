package nl.ordina.rogier.kookschriften.client.controller;

import java.util.List;

import nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory;
import nl.ordina.rogier.kookschriften.client.GewichtEenheid;
import nl.ordina.rogier.kookschriften.client.IngredientRequest;
import nl.ordina.rogier.kookschriften.client.view.IngredientView;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientProxy;

import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

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
