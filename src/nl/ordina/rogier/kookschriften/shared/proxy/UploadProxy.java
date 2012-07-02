package nl.ordina.rogier.kookschriften.shared.proxy;

import nl.ordina.rogier.kookschriften.domain.Upload;
import nl.ordina.rogier.kookschriften.server.locator.UploadedImageLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Upload.class, locator=UploadedImageLocator.class)
public interface UploadProxy extends EntityProxy  {
    public String getUploadUrl();
}
