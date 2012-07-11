package nl.ordina.rogier.kookschriften.domain;


import nl.ordina.rogier.kookschriften.client.GewichtEenheid;
public class IngredientRegel extends DatastoreValueObject {
   
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
   

 
}
