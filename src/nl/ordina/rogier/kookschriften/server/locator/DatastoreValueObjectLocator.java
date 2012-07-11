package nl.ordina.rogier.kookschriften.server.locator;

import nl.ordina.rogier.kookschriften.domain.DatastoreObject;
import nl.ordina.rogier.kookschriften.domain.Recept;

import com.google.web.bindery.requestfactory.shared.Locator;

public class DatastoreValueObjectLocator extends Locator<DatastoreObject, Long> {

    @Override
    public DatastoreObject create(Class<? extends DatastoreObject> clazz) {
	return new Recept();
    }

    @Override
    public DatastoreObject find(Class<? extends DatastoreObject> clazz, Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<DatastoreObject> getDomainType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Long getId(DatastoreObject domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Long> getIdType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getVersion(DatastoreObject domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

}
