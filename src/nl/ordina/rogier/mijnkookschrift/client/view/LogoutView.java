package nl.ordina.rogier.mijnkookschrift.client.view;

import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.DatastoreObjectProxy;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.LoginInfoProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;


public class LogoutView extends Composite implements HasText {

    private static LogoutViewUiBinder uiBinder = GWT.create(LogoutViewUiBinder.class);

    interface LogoutViewUiBinder extends UiBinder<Widget, LogoutView> {
    }


    HTMLPanel panel;

    public LogoutView(HistoryManager historyManager,DatastoreObjectProxy datastoreObjectProxy) {
	LoginInfoProxy loginInfoProxy=(LoginInfoProxy)datastoreObjectProxy;
	initWidget(uiBinder.createAndBindUi(this));
	Anchor signOutLink = new Anchor("Logout");
	signOutLink.setHref(loginInfoProxy.getLogoutUrl());
	panel.add(signOutLink);
    }

    
    public void setText(String text) {
	
    }

    public String getText() {
	return null;
    }

}
