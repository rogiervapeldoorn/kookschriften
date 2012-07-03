package nl.ordina.rogier.kookschriften.client;

import nl.ordina.rogier.kookschriften.server.service.IngredientRegelDao;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientRegelProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(IngredientRegelDao.class)
public interface IngredientRegelRequest extends RequestContext{
    Request<Void> save(IngredientRegelProxy ingredientRegelProxy);
}

