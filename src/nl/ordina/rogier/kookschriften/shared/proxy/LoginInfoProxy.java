package nl.ordina.rogier.kookschriften.shared.proxy;

import nl.ordina.rogier.kookschriften.domain.LoginInfo;
import nl.ordina.rogier.kookschriften.server.locator.ObjectifyLocator;

import com.google.web.bindery.requestfactory.shared.ProxyFor;
import com.google.web.bindery.requestfactory.shared.ValueProxy;

@ProxyFor(value=LoginInfo.class, locator=ObjectifyLocator.class)
public interface LoginInfoProxy extends DatastoreObjectProxy {
    public boolean isLoggedIn();
    public void setLoggedIn(boolean loggedIn);
    public String getLoginUrl();
    public void setLoginUrl(String loginUrl);
    public String getLogoutUrl();
    public void setLogoutUrl(String logoutUrl);
    public String getEmailAddress();
    public void setEmailAddress(String emailAddress);
    public String getNickname();
    public void setNickname(String nickname);
	
}
