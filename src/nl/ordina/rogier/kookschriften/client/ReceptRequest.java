package nl.ordina.rogier.kookschriften.client;

import java.util.List;

import nl.ordina.rogier.kookschriften.server.service.ReceptDao;
import nl.ordina.rogier.kookschriften.shared.proxy.ReceptProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(ReceptDao.class)
public interface ReceptRequest extends RequestContext{
    Request<List<ReceptProxy>> findAllRecepten();
    Request<List<ReceptProxy>> findMyRecepten();
    Request<Void> save(ReceptProxy receptProxy);
}

