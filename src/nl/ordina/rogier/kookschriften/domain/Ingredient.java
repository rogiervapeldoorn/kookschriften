package nl.ordina.rogier.kookschriften.domain;

import javax.persistence.Entity;

@Entity
public class Ingredient extends DatastoreObject{
    private String ingredient;
    
    public String getIngredient() {
        return ingredient;
    }

    public void setIngredient(String ingredient) {
        this.ingredient = ingredient;
    }

    public Ingredient() {
	// No-arg constructor required by Objectify
    }
 
}
