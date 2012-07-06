package nl.ordina.rogier.kookschriften.domain;

import java.io.Serializable;

import javax.persistence.Id;
import javax.persistence.PrePersist;

import nl.ordina.rogier.kookschriften.client.GewichtEenheid;
public class IngredientRegel implements Serializable {
   
    private static final long serialVersionUID = -2399396533066186395L;
    @Id
    private Long id;
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
    private Integer version = 0;
    private String ingredient;
    private Double gewicht;
    private GewichtEenheid gewichtEenheid;
    
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Double getGewicht() {
        return gewicht;
    }

    public void setGewicht(Double gewicht) {
        this.gewicht = gewicht;
    }

    public GewichtEenheid getGewichtEenheid() {
        return gewichtEenheid;
    }

    public void setGewichtEenheid(GewichtEenheid gewichtEenheid) {
        this.gewichtEenheid = gewichtEenheid;
    }

    public IngredientRegel() {
	// No-arg constructor required by Objectify
    }
    /**
     * Auto-increment version # whenever persisted
     */
    @PrePersist
    void onPersist() {
	this.version++;
    }

 
}
