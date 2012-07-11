package nl.ordina.rogier.kookschriften.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Embedded;
import javax.persistence.Entity;

import nl.ordina.rogier.kookschriften.client.SoortRecept;
import nl.ordina.rogier.kookschriften.client.TijdEenheid;

import com.googlecode.objectify.annotation.Cached;

@Cached
@Entity
public class Recept extends DatastoreObject {
   
    private String email;
    private String naamRecept;
    private SoortRecept soortRecept;
    private String afkomstigVan;
    private String bereiding;
    private String bereidingsTijd;
    private TijdEenheid bereidingsTijdEenheid;
    private List<String> uploadedImages;
    @Embedded 
    private List<IngredientRegel> ingredienten=new ArrayList<IngredientRegel>();
    
    public List<IngredientRegel> getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(List<IngredientRegel> ingredienten) {
        this.ingredienten = ingredienten;
    }

    public List<String> getUploadedImages() {
        return uploadedImages;
    }

    public void setUploadedImages(List<String> uploadedImages) {
        this.uploadedImages = uploadedImages;
    }

    public void setBereidingTijd(Integer bereidingTijd) {
    }

   
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNaamRecept() {
        return naamRecept;
    }

    public void setNaamRecept(String naamRecept) {
        this.naamRecept = naamRecept;
    }

    public SoortRecept getSoortRecept() {
        return soortRecept;
    }

    public void setSoortRecept(SoortRecept soortRecept) {
        this.soortRecept = soortRecept;
    }

    public String getAfkomstigVan() {
        return afkomstigVan;
    }

    public void setAfkomstigVan(String afkomstigVan) {
        this.afkomstigVan = afkomstigVan;
    }

       public String getBereiding() {
        return bereiding;
    }

    public void setBereiding(String bereiding) {
        this.bereiding = bereiding;
    }

    public String getBereidingsTijd() {
        return bereidingsTijd;
    }

    public void setBereidingsTijd(String bereidingsTijd) {
        this.bereidingsTijd = bereidingsTijd;
    }

    public TijdEenheid getBereidingsTijdEenheid() {
        return bereidingsTijdEenheid;
    }

    public void setBereidingsTijdEenheid(TijdEenheid bereidingsTijdEenheid) {
        this.bereidingsTijdEenheid = bereidingsTijdEenheid;
    }

    public Recept() {
	// No-arg constructor required by Objectify
    }
}
