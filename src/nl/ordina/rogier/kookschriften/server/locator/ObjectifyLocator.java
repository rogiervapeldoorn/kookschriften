package nl.ordina.rogier.kookschriften.server.locator;

import nl.ordina.rogier.kookschriften.domain.Recept;
import nl.ordina.rogier.kookschriften.server.service.ObjectifyDao;

import com.google.web.bindery.requestfactory.shared.Locator;

/**
 * Generic @Locator for objects that extend DatastoreObject
 */
public class ObjectifyLocator extends Locator<Recept, Long> {
  @Override
  public Recept create(Class<? extends Recept> clazz) {
    try {
      return clazz.newInstance();
    } catch (InstantiationException e) {
      throw new RuntimeException(e);
    } catch (IllegalAccessException e) {
      throw new RuntimeException(e);
    }
  }

  @Override
  public Recept find(Class<? extends Recept> clazz, Long id) {
    ObjectifyDao daoBase = new ObjectifyDao();
    return daoBase.ofy().find(clazz, id);
  }

  @Override
  public Class<Recept> getDomainType() {
    // Never called
    return null;
  }

  @Override
  public Long getId(Recept domainObject) {
    return domainObject.getId();
  }

  @Override
  public Class<Long> getIdType() {
    return Long.class;
  }

  @Override
  public Object getVersion(Recept domainObject) {
    return domainObject.getVersion();
  }
}
