package nl.ordina.rogier.kookschriften.server.service;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.util.DAOBase;

@Entity public class UploadUrlDao extends DAOBase {

  public static String getUploadUrl()
    {
      BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	String url=blobstoreService.createUploadUrl("/upload");
	return url;
    }
    public void persist()
    {
	System.out.println("persist");
    }
    
}
