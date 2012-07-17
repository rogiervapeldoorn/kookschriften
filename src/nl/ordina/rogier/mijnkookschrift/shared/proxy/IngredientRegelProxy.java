package nl.ordina.rogier.mijnkookschrift.shared.proxy;

import nl.ordina.rogier.mijnkookschrift.client.GewichtEenheid;
import nl.ordina.rogier.mijnkookschrift.domain.IngredientRegel;
import nl.ordina.rogier.mijnkookschrift.server.locator.IngredientRegelLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
@ProxyFor(value=IngredientRegel.class, locator=IngredientRegelLocator.class)
public interface IngredientRegelProxy extends DatastoreValueObjectProxy  {
    public String getIngredient();
    public void setIngredient(String ingredient);
    public Double getGewicht();
    public void setGewicht(Double gewicht);
    public GewichtEenheid getGewichtEenheid();
    public void setGewichtEenheid(GewichtEenheid GewichtEenheden);
}
