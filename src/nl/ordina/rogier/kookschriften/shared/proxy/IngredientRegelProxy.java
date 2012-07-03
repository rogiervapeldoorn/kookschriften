package nl.ordina.rogier.kookschriften.shared.proxy;

import nl.ordina.rogier.kookschriften.client.GewichtEenheid;
import nl.ordina.rogier.kookschriften.domain.IngredientRegel;
import nl.ordina.rogier.kookschriften.server.locator.IngredientRegelLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;
@ProxyFor(value=IngredientRegel.class, locator=IngredientRegelLocator.class)
public interface IngredientRegelProxy extends ValueProxy  {
    public String getIngredient();
    public void setIngredient(String ingredient);
    public Long getGewicht();
    public void setGewicht(Long	gewicht);
    public GewichtEenheid getGewichtEenheid();
    public void setGewichtEenheid(GewichtEenheid GewichtEenheden);
}
