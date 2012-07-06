package nl.ordina.rogier.kookschriften.server.locator;

import nl.ordina.rogier.kookschriften.domain.UploadedImage;
import nl.ordina.rogier.kookschriften.server.service.UploadedImageDao;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.web.bindery.requestfactory.shared.Locator;

public class UploadedImageLocator extends Locator<UploadedImage, Long> {
    public String getUploadUrl(){
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	String url=blobstoreService.createUploadUrl("/upload");
	System.out.println("Upload URL"+url);
	return url;
    }
    
    public UploadedImage getUploadedImage(String key)
    {
	UploadedImage image = UploadedImageDao.findUploadedImageWithId(key);
	return image;
    }

    @Override
    public UploadedImage create(Class<? extends UploadedImage> clazz) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public UploadedImage find(Class<? extends UploadedImage> clazz, Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<UploadedImage> getDomainType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Long getId(UploadedImage domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Long> getIdType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getVersion(UploadedImage domainObject) {
	// TODO Auto-generated method stub
	return null;
    }
}
