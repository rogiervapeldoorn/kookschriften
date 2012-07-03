package nl.ordina.rogier.kookschriften.shared.proxy;

import nl.ordina.rogier.kookschriften.domain.Ingredient;
import nl.ordina.rogier.kookschriften.server.locator.IngredientLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Ingredient.class, locator=IngredientLocator.class)
public interface IngredientProxy extends EntityProxy  {
    public Long getId();
    public void setId(Long id);
    public Integer getVersion();
    public void setVersion(Integer version);
    public String getIngredient();
    public void setIngredient(String ingredient);
    
}
