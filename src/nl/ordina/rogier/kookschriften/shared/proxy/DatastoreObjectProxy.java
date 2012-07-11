package nl.ordina.rogier.kookschriften.shared.proxy;

import nl.ordina.rogier.kookschriften.domain.DatastoreObject;
import nl.ordina.rogier.kookschriften.server.locator.DatastoreObjectLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=DatastoreObject.class, locator=DatastoreObjectLocator.class)
public interface DatastoreObjectProxy  extends EntityProxy  {
    public Long getId();
    public void setId(Long id);
    public Integer getVersion();
    public void setVersion(Integer version);
}
