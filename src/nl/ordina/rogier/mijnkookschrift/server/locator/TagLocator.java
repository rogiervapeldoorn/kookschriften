package nl.ordina.rogier.mijnkookschrift.server.locator;

import nl.ordina.rogier.mijnkookschrift.domain.Tag;

import com.google.web.bindery.requestfactory.shared.Locator;

public class TagLocator extends Locator<Tag, Long> {

    @Override
    public Tag create(Class<? extends Tag> clazz) {
	return new Tag();
    }

    @Override
    public Tag find(Class<? extends Tag> clazz, Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Tag> getDomainType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Long getId(Tag domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Long> getIdType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getVersion(Tag domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

}
