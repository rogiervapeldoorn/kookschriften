package nl.ordina.rogier.kookschriften.client.view;

import nl.ordina.rogier.kookschriften.client.model.HistoryManager;
import nl.ordina.rogier.kookschriften.shared.proxy.DatastoreObjectProxy;
import nl.ordina.rogier.kookschriften.shared.proxy.LoginInfoProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class LoginView extends Composite implements HasText {

    private static LoginViewUiBinder uiBinder = GWT.create(LoginViewUiBinder.class);

    interface LoginViewUiBinder extends UiBinder<Widget, LoginView> {
    }

    @UiField
    HTMLPanel panel;

    public LoginView(HistoryManager historyManager,DatastoreObjectProxy datastoreObjectProxy) {
	LoginInfoProxy loginInfoProxy=(LoginInfoProxy)datastoreObjectProxy;
	initWidget(uiBinder.createAndBindUi(this));
	Anchor signInLink = new Anchor("Login");
	signInLink.setHref( loginInfoProxy.getLoginUrl());
	panel.add(signInLink);
    }

    public void setText(String text) {

    }

    public String getText() {
	return null;
    }

}
