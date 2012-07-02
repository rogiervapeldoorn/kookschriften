package nl.ordina.rogier.kookschriften.shared.proxy;

import java.util.List;

import nl.ordina.rogier.kookschriften.client.SoortRecepten;
import nl.ordina.rogier.kookschriften.client.TijdEenheden;
import nl.ordina.rogier.kookschriften.domain.Recept;
import nl.ordina.rogier.kookschriften.server.locator.ReceptLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Recept.class, locator=ReceptLocator.class)
public interface ReceptProxy extends EntityProxy  {
    public Integer getBereidingTijd();
    public void setBereidingTijd(Integer bereidingTijd);
    public Long getId();
    public void setId(Long id);
    public Integer getVersion();
    public void setVersion(Integer version);
    public String getEmail();
    public void setEmail(String email);
    public String getNaamRecept();
    public void setNaamRecept(String naamRecept);
    public SoortRecepten getSoortRecept();
    public void setSoortRecept(SoortRecepten soortRecept);
    public String getAfkomstigVan();
    public void setAfkomstigVan(String afkomstigVan);
    public List<String> getIngredienten();
    public void setIngredienten(List<String> ingredienten);
    public String getBereiding();
    public void setBereiding(String bereiding);
    public String getBereidingsTijd();
    public void setBereidingsTijd(String bereidingsTijd);
    public TijdEenheden getBereidingsTijdEenheid();
    public void setBereidingsTijdEenheid(TijdEenheden bereidingsTijdEenheid);
    public List<String> getUploadedImages();
    public void setUploadedImages(List<String> uploadedImages);
    
}
