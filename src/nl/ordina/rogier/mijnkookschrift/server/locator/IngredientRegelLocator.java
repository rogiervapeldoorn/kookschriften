package nl.ordina.rogier.mijnkookschrift.server.locator;

import nl.ordina.rogier.mijnkookschrift.domain.IngredientRegel;

import com.google.web.bindery.requestfactory.shared.Locator;

public class IngredientRegelLocator extends Locator<IngredientRegel, Long> {

    @Override
    public IngredientRegel create(Class<? extends IngredientRegel> clazz) {
	return new IngredientRegel();
    }

    @Override
    public IngredientRegel find(Class<? extends IngredientRegel> clazz, Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<IngredientRegel> getDomainType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Long getId(IngredientRegel domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Long> getIdType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getVersion(IngredientRegel domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

}
