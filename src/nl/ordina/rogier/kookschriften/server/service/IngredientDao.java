package nl.ordina.rogier.kookschriften.server.service;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.kookschriften.domain.Ingredient;
import nl.ordina.rogier.kookschriften.domain.IngredientRegel;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.util.DAOBase;

@Entity public class IngredientDao extends DAOBase {

    static
	{
		ObjectifyService.register(Ingredient.class);
	}

    public static List<Ingredient> findAllRecepten()
    {
	return null;
    }
    public static List<Ingredient> findMyIngredient()
    {
	Objectify objectify=ObjectifyService.begin();
	List<Ingredient> result=new ArrayList<Ingredient>();
	Query<Ingredient> ingredienten=objectify.query(Ingredient.class);
	for (Ingredient ingredient : ingredienten) {
	    result.add(ingredient);
	}
	return result;
    }
    public static Ingredient findIngredientWithId(Long id)
    {
	Objectify objectify=ObjectifyService.begin();
	Ingredient ingredient = objectify.get(new Key<Ingredient>(Ingredient.class, id));
	return ingredient ;
    }
    public void persist()
    {
	System.out.println("persist");
    }
    public static Void save(Ingredient ingredient )
    {
	Objectify objectify=ObjectifyService.begin();
	objectify.put(ingredient);
	return null;
    }
}
