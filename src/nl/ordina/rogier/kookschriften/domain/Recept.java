package nl.ordina.rogier.kookschriften.domain;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import nl.ordina.rogier.kookschriften.client.SoortRecept;
import nl.ordina.rogier.kookschriften.client.TijdEenheid;

import com.googlecode.objectify.annotation.Cached;

@Cached
@Entity
public class Recept {
    @Id
    private Long id;
    private Integer version = 0;
    private String email;
    private String naamRecept;
    private SoortRecept soortRecept;
    private String afkomstigVan;
    private List<String> ingredienten;
    private Integer bereidingTijd;
    private List<String> uploadedImages;
    public Integer getBereidingTijd() {
        return bereidingTijd;
    }

    public List<String> getUploadedImages() {
        return uploadedImages;
    }

    public void setUploadedImages(List<String> uploadedImages) {
        this.uploadedImages = uploadedImages;
    }

    public void setBereidingTijd(Integer bereidingTijd) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
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

    public List<String> getIngredienten() {
        return ingredienten;
    }

    public void setIngredienten(List<String> ingredienten) {
        this.ingredienten = ingredienten;
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

    private String bereiding;
    private String bereidingsTijd;
    private TijdEenheid bereidingsTijdEenheid;

    /**
     * Auto-increment version # whenever persisted
     */
    @PrePersist
    void onPersist() {
	this.version++;
    }

    public Recept() {
	// No-arg constructor required by Objectify
    }
}
