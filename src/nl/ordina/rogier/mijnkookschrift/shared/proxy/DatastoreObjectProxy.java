package nl.ordina.rogier.mijnkookschrift.shared.proxy;

import nl.ordina.rogier.mijnkookschrift.domain.DatastoreObject;
import nl.ordina.rogier.mijnkookschrift.server.locator.ObjectifyLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=DatastoreObject.class, locator=ObjectifyLocator.class)
public interface DatastoreObjectProxy  extends EntityProxy  {
    public Long getId();
    public void setId(Long id);
    public Integer getVersion();
    public void setVersion(Integer version);
}
