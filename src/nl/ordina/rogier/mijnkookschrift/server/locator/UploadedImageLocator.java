package nl.ordina.rogier.mijnkookschrift.server.locator;

import nl.ordina.rogier.mijnkookschrift.domain.UploadedImage;
import nl.ordina.rogier.mijnkookschrift.server.service.UploadedImageDao;

import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.web.bindery.requestfactory.shared.Locator;

public class UploadedImageLocator extends Locator<UploadedImage, Long> {
    public String getUploadUrl(){
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();
	return blobstoreService.createUploadUrl("/upload");
    }
    
    public UploadedImage getUploadedImage(String key)
    {
	UploadedImage image = UploadedImageDao.findUploadedImageWithId(key);
	return image;
    }

    @Override
    public UploadedImage create(Class<? extends UploadedImage> clazz) {
	return null;
    }

    @Override
    public UploadedImage find(Class<? extends UploadedImage> clazz, Long id) {
	return null;
    }

    @Override
    public Class<UploadedImage> getDomainType() {
	return null;
    }

    @Override
    public Long getId(UploadedImage domainObject) {
	return null;
    }

    @Override
    public Class<Long> getIdType() {
	return null;
    }

    @Override
    public Object getVersion(UploadedImage domainObject) {
	return null;
    }
}
