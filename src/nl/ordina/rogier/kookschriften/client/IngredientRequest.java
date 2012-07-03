package nl.ordina.rogier.kookschriften.client;

import nl.ordina.rogier.kookschriften.server.service.IngredientDao;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(IngredientDao.class)
public interface IngredientRequest extends RequestContext{
    Request<Void> save(IngredientProxy receptProxy);
}

