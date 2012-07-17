package nl.ordina.rogier.mijnkookschrift.client;

import java.util.List;

import nl.ordina.rogier.mijnkookschrift.server.service.ReceptDao;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.ReceptProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;
import com.googlecode.objectify.Key;

@Service(ReceptDao.class)
public interface ReceptRequest extends RequestContext{
    Request<List<ReceptProxy>> findAllRecepten(ReceptProxy receptProxy);
    Request<List<ReceptProxy>> findMyRecepten();
    Request<ReceptProxy> findRecept(Long id);
    Request<Void> save(ReceptProxy receptProxy);
    Request<Void> delete(Long id);
}

