package nl.ordina.rogier.mijnkookschrift.server.service;

import nl.ordina.rogier.mijnkookschrift.domain.LoginInfo;

import com.google.appengine.api.users.User;
import com.google.appengine.api.users.UserService;
import com.google.appengine.api.users.UserServiceFactory;

public class LoginDao {
    public static LoginInfo login(String requestUri) {
	UserService userService = UserServiceFactory.getUserService();
	User user = userService.getCurrentUser();
	LoginInfo loginInfo = new LoginInfo();

	if (user != null) {
	    loginInfo.setLoggedIn(true);
	    loginInfo.setEmailAddress(user.getEmail());
	    loginInfo.setNickname(user.getNickname());
	    loginInfo.setLogoutUrl(userService.createLogoutURL(requestUri));
	} else {
	    loginInfo.setLoggedIn(false);
	    loginInfo.setLoginUrl(userService.createLoginURL(requestUri));
	}
	return loginInfo;
    }
}
