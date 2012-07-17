package nl.ordina.rogier.mijnkookschrift.server.service;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.mijnkookschrift.domain.IngredientRegel;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.util.DAOBase;

@Entity public class IngredientRegelDao extends DAOBase {

    static
	{
		ObjectifyService.register(IngredientRegel.class);
	}

    public static List<IngredientRegel> findAllRecepten()
    {
	return null;
    }
    public static List<IngredientRegel> findMyIngredient()
    {
	Objectify objectify=ObjectifyService.begin();
	List<IngredientRegel> result=new ArrayList<IngredientRegel>();
	Query<IngredientRegel> ingredienten=objectify.query(IngredientRegel.class);
	for (IngredientRegel ingredient : ingredienten) {
	    result.add(ingredient);
	}
	return result;
    }
    public static IngredientRegel findIngredientWithId(Long id)
    {
	Objectify objectify=ObjectifyService.begin();
	IngredientRegel ingredient = objectify.get(new Key<IngredientRegel>(IngredientRegel.class, id));
	return ingredient ;
    }
    public void persist()
    {
	System.out.println("persist");
    }
    public static Void save(IngredientRegel ingredientRegel )
    {
	Objectify objectify=ObjectifyService.begin();
	objectify.put(ingredientRegel);
	return null;
    }
}
