package nl.ordina.rogier.kookschriften.server.locator;

import nl.ordina.rogier.kookschriften.domain.Ingredient;

import com.google.web.bindery.requestfactory.shared.Locator;

public class IngredientLocator extends Locator<Ingredient, Long> {

    @Override
    public Ingredient create(Class<? extends Ingredient> clazz) {
	return new Ingredient();
    }

    @Override
    public Ingredient find(Class<? extends Ingredient> clazz, Long id) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Ingredient> getDomainType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Long getId(Ingredient domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Class<Long> getIdType() {
	// TODO Auto-generated method stub
	return null;
    }

    @Override
    public Object getVersion(Ingredient domainObject) {
	// TODO Auto-generated method stub
	return null;
    }

}
