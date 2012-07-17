package nl.ordina.rogier.mijnkookschrift.server.locator;

import nl.ordina.rogier.mijnkookschrift.domain.DatastoreObject;
import nl.ordina.rogier.mijnkookschrift.domain.Recept;
import nl.ordina.rogier.mijnkookschrift.server.service.ObjectifyDao;

import com.google.web.bindery.requestfactory.shared.Locator;

/**
 * Generic @Locator for objects that extend DatastoreObject
 */
public class ObjectifyLocator extends Locator<DatastoreObject, Long> {
  @Override
  public DatastoreObject create(Class<? extends DatastoreObject> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public DatastoreObject find(Class<? extends DatastoreObject> clazz, Long id) {
    //ObjectifyDao daoBase = new ObjectifyDao();
    return null;
  }

  @Override
  public Class<DatastoreObject> getDomainType() {
    // Never called
    return null;
  }

  @Override
  public Long getId(DatastoreObject domainObject) {
    return domainObject.getId();
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }

  @Override
  public Object getVersion(DatastoreObject domainObject) {
    return domainObject.getVersion();
  }
}
