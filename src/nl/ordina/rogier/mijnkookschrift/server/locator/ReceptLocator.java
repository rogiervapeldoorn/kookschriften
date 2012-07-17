package nl.ordina.rogier.mijnkookschrift.server.locator;

import nl.ordina.rogier.mijnkookschrift.domain.Recept;

import com.google.web.bindery.requestfactory.shared.Locator;

public class ReceptLocator extends Locator<Recept, Long> {

    @Override
    public Recept create(Class<? extends Recept> clazz) {
	return new Recept();
    }

    @Override
    public Recept find(Class<? extends Recept> clazz, Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Recept> getDomainType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Long getId(Recept domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Long> getIdType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getVersion(Recept domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

}
