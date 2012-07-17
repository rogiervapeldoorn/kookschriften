package nl.ordina.rogier.mijnkookschrift.client;

import nl.ordina.rogier.mijnkookschrift.server.service.UploadedImageDao;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.UploadedImageProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(UploadedImageDao.class)
public interface UploadedImageRequest extends RequestContext{
    Request<UploadedImageProxy> findUploadedImageWithId(String id);
}
