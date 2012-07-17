package nl.ordina.rogier.mijnkookschrift.shared.proxy;

import nl.ordina.rogier.mijnkookschrift.domain.Upload;
import nl.ordina.rogier.mijnkookschrift.server.locator.UploadedImageLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=Upload.class, locator=UploadedImageLocator.class)
public interface UploadProxy extends EntityProxy  {
    public String getUploadUrl();
}
