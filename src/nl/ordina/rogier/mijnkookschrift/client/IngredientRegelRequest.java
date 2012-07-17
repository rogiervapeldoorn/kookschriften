package nl.ordina.rogier.mijnkookschrift.client;

import nl.ordina.rogier.mijnkookschrift.server.service.IngredientRegelDao;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.IngredientRegelProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(IngredientRegelDao.class)
public interface IngredientRegelRequest extends RequestContext{
    Request<Void> save(IngredientRegelProxy ingredientRegelProxy);
}

