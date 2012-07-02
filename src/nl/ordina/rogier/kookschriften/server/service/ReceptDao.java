package nl.ordina.rogier.kookschriften.server.service;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.kookschriften.domain.Recept;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.util.DAOBase;

@Entity public class ReceptDao extends DAOBase {

    static
	{
		ObjectifyService.register(Recept.class);
	}

    public static List<Recept> findAllRecepten()
    {
	return null;
    }
    public static List<Recept> findMyRecepten()
    {
	Objectify objectify=ObjectifyService.begin();
	List<Recept> result=new ArrayList<Recept>();
	Query<Recept> recepten=objectify.query(Recept.class);
	for (Recept recept : recepten) {
	    result.add(recept);
	}
	return result;
    }
    public static Recept findUser(Long id)
    {
	Objectify objectify=ObjectifyService.begin();
	Recept recept = objectify.get(new Key<Recept>(Recept.class, id));
	return recept;
    }
    public void persist()
    {
	System.out.println("persist");
    }
    public static Void save(Recept recept)
    {
	Objectify objectify=ObjectifyService.begin();
	objectify.put(recept);
	return null;
    }
}
