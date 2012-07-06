package nl.ordina.rogier.kookschriften.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class Ingredient {
    @Id
    private Long id;
    private Integer version = 0;
    private String ingredient;
    
    /**
     * Auto-increment version # whenever persisted
     */
    @PrePersist
    void onPersist() {
	this.version++;
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
