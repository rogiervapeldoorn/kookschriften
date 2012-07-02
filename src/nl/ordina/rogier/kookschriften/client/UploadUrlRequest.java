package nl.ordina.rogier.kookschriften.client;

import nl.ordina.rogier.kookschriften.server.service.UploadUrlDao;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(UploadUrlDao.class)
public interface UploadUrlRequest extends RequestContext{
    Request<String> getUploadUrl();
}

