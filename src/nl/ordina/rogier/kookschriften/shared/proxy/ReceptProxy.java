package nl.ordina.rogier.kookschriften.shared.proxy;

import java.util.List;

import nl.ordina.rogier.kookschriften.client.SoortRecept;
import nl.ordina.rogier.kookschriften.client.TijdEenheid;
import nl.ordina.rogier.kookschriften.domain.Recept;
import nl.ordina.rogier.kookschriften.server.locator.ObjectifyLocator;
import nl.ordina.rogier.kookschriften.server.locator.ReceptLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Recept.class, locator=ObjectifyLocator.class)
public interface ReceptProxy extends DatastoreObjectProxy {

    public String getEmail();
    public void setEmail(String email);
    public String getNaamRecept();
    public void setNaamRecept(String naamRecept);
    public SoortRecept getSoortRecept();
    public void setSoortRecept(SoortRecept soortRecept);
    public String getAfkomstigVan();
    public void setAfkomstigVan(String afkomstigVan);
    public String getBereiding();
    public void setBereiding(String bereiding);
    public String getBereidingsTijd();
    public void setBereidingsTijd(String bereidingsTijd);
    public TijdEenheid getBereidingsTijdEenheid();
    public void setBereidingsTijdEenheid(TijdEenheid bereidingsTijdEenheid);
    public List<String> getUploadedImages();
    public void setUploadedImages(List<String> uploadedImages);
    public void setIngredienten(List<IngredientRegelProxy> ingredienten );
    public List<IngredientRegelProxy> getIngredienten();
    
}
