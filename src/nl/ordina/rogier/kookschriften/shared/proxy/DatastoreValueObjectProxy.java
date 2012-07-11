package nl.ordina.rogier.kookschriften.shared.proxy;

import nl.ordina.rogier.kookschriften.domain.DatastoreValueObject;
import nl.ordina.rogier.kookschriften.server.locator.DatastoreValueObjectLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(value=DatastoreValueObject.class, locator=DatastoreValueObjectLocator.class)
public interface DatastoreValueObjectProxy extends ValueProxy {
    public Long getId();
    public void setId(Long id);
    public Integer getVersion();
    public void setVersion(Integer version);
}
