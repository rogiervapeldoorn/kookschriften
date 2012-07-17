package nl.ordina.rogier.mijnkookschrift.server.service;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.mijnkookschrift.domain.IngredientRegel;
import nl.ordina.rogier.mijnkookschrift.domain.LoginInfo;
import nl.ordina.rogier.mijnkookschrift.domain.Recept;

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
		ObjectifyService.register(IngredientRegel.class);
	}

    public static List<Recept> findAllRecepten(Recept params)
    {
	Objectify objectify=ObjectifyService.begin();
	List<Recept> result=new ArrayList<Recept>();
	Query<Recept> recepten=objectify.query(Recept.class);
	if(params.getAfkomstigVan()!=null&&!params.getAfkomstigVan().equals(""))
	{
	    recepten.filter("afkomstigVan", params.getAfkomstigVan());
	}
	if(params.getNaamRecept()!=null&&!params.getNaamRecept().equals(""))
	{
	    recepten.filter("naamRecept", params.getNaamRecept());
	}
	if(params.getSoortKeuken()!=null)
	{
	    recepten.filter("soortKeuken", params.getSoortKeuken());
	}
	if(params.getSoortRecept()!=null)
	{
	    recepten.filter("soortRecept", params.getSoortRecept());
	}
	for (Recept recept : recepten) {
	    result.add(recept);
	}
	return result;
    }
    public static List<Recept> findMyRecepten()
    {
	LoginInfo loginInfo=LoginDao.login("");
	String emailAdress=loginInfo.getEmailAddress();
	Objectify objectify=ObjectifyService.begin();
	List<Recept> result=new ArrayList<Recept>();
	Query<Recept> recepten=objectify.query(Recept.class).filter("afkomstigVan", emailAdress);
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
    public static Recept findRecept(Long id)
    {
	Objectify objectify=ObjectifyService.begin();
	Recept recept = objectify.get(Recept.class, id);
	return recept;
    }
    public void persist()
    {
	System.out.println("persist");
    }
    public static Void save(Recept recept)
    {
	LoginInfo loginInfo=LoginDao.login("");
	recept.setAfkomstigVan(loginInfo.getEmailAddress());
	Objectify objectify=ObjectifyService.begin();
	objectify.put(recept);
	return null;
    }
    
    public static Void delete(Long id)
    {
	Objectify objectify=ObjectifyService.begin();
	objectify.delete(new Key<Recept>(Recept.class, id));
	return null;
    }
}
