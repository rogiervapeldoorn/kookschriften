package nl.ordina.rogier.mijnkookschrift.shared.proxy;

import nl.ordina.rogier.mijnkookschrift.domain.Ingredient;
import nl.ordina.rogier.mijnkookschrift.server.locator.ObjectifyLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Ingredient.class, locator=ObjectifyLocator.class)
public interface IngredientProxy extends DatastoreObjectProxy {
    public String getIngredient();
    public void setIngredient(String ingredient);
    
}
