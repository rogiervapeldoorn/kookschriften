package nl.ordina.rogier.mijnkookschrift.client.view;

import nl.ordina.rogier.mijnkookschrift.client.ExpensesRequestFactory;
import nl.ordina.rogier.mijnkookschrift.client.GewichtEenheid;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.ListBox;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;

public class IngredientController implements ControllerInterface{

    IngredientView ingredient;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);
    
    IngredientController(IngredientView ingredient) {
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	this.ingredient = ingredient;
    }

    public void init() {
	UtilController.initGewichtsEenheid(ingredient.Eenheid);
	if (ingredient.ingredientRegelProxy!=null)
	{
	    if (ingredient.ingredientRegelProxy.getGewicht()!=null)
	    {
	    ingredient.Gewicht.setValue(ingredient.ingredientRegelProxy.getGewicht().toString());
	    }
	    ingredient.Ingredient.setValue(ingredient.ingredientRegelProxy.getIngredient());
	    UtilController.selectItem(ingredient.Eenheid, ingredient.ingredientRegelProxy.getGewichtEenheid().toString());
	}
	bind();
    }
    
    private void bind() {
	
    }

   

}
