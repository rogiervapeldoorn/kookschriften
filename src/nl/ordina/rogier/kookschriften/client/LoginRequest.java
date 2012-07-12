package nl.ordina.rogier.kookschriften.client;

import nl.ordina.rogier.kookschriften.server.service.LoginDao;
import nl.ordina.rogier.kookschriften.shared.proxy.LoginInfoProxy;

import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.Service;

@Service(LoginDao.class)
public interface LoginRequest extends RequestContext{
    Request<LoginInfoProxy> login(String requestUri);
}
