package nl.ordina.rogier.mijnkookschrift.server.service;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.mijnkookschrift.domain.UploadedImage;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import com.googlecode.objectify.Query;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.util.DAOBase;

@Entity 
public class UploadedImageDao extends DAOBase{

    static
	{
		ObjectifyService.register(UploadedImage.class);
	}


    public static List<UploadedImage> findUploadedImages()
    {
	return null;
    }
    public static List<UploadedImage> findUploadedImagesForRecept()
    {
	Objectify objectify=ObjectifyService.begin();
	List<UploadedImage> result=new ArrayList<UploadedImage>();
	Query<UploadedImage> uploadedImages=objectify.query(UploadedImage.class);
	for (UploadedImage uploadedImage : uploadedImages) {
	    result.add(uploadedImage);
	}
	return result;
    }
    
    public static UploadedImage findUploadedImageWithId(String id)
    {
	Objectify objectify=ObjectifyService.begin();
	UploadedImage uploadedImages = objectify.get(UploadedImage.class,new Long(id));
	return uploadedImages;
    }
    
    public Key<UploadedImage> put(UploadedImage entity)

    {
	return ofy().put(entity);
    }
    public void persist()
    {
	System.out.println("persist");
    }
    public static Void save(UploadedImage uploadedImage)
    {
	Objectify objectify=ObjectifyService.begin();
	objectify.put(uploadedImage);
	return null;
    }
}
