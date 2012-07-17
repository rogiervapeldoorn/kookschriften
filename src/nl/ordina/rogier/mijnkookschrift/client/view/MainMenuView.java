package nl.ordina.rogier.mijnkookschrift.client.view;

import nl.ordina.rogier.mijnkookschrift.client.ExpensesRequestFactory;
import nl.ordina.rogier.mijnkookschrift.client.LoginRequest;
import nl.ordina.rogier.mijnkookschrift.client.controller.HistoryController;
import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.LoginInfoProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Anchor;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.MenuItemSeparator;
import com.google.gwt.user.client.ui.RootPanel;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class MainMenuView extends Composite implements HasText {

    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    private static MainMenuUiBinder uiBinder = GWT.create(MainMenuUiBinder.class);
    @UiField
    MenuBar menuBar;
    @UiField
    MenuItem homeMenuItem;
    @UiField
    MenuItem eigenReceptenMenuItem;
    @UiField
    MenuItemSeparator eigenReceptenSeparator;
    @UiField
    MenuItem receptToevoegenMenuItem;
    @UiField
    MenuItemSeparator receptToevoegenSeparator;
    @UiField
    MenuItem receptenZoekenMenuItem;
    @UiField
    HTMLPanel appSpace;
    private HistoryManager historyManager;

    interface MainMenuUiBinder extends UiBinder<Widget, MainMenuView> {
    }

    public MainMenuView() {
	initWidget(uiBinder.createAndBindUi(this));
	homeMenuItem.setCommand(new MenuCommandView(HistoryToken.Home));
	showMenu(false);
	eigenReceptenMenuItem.setCommand(new MenuCommandView(HistoryToken.EigenRecepten));
	receptToevoegenMenuItem.setCommand(new MenuCommandView(HistoryToken.ReceptToevoegen));
	receptenZoekenMenuItem.setCommand(new MenuCommandView(HistoryToken.ReceptenZoeken));
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	LoginRequest loginRequest = requestFactory.loginRequest();
	Request<LoginInfoProxy> loginRequestProxy = loginRequest.login(GWT.getHostPageBaseURL());
	loginRequestProxy.fire(new Receiver<LoginInfoProxy>() {

	    @Override
	    public void onSuccess(LoginInfoProxy response) {
		Anchor signInOutLink = new Anchor();
		if (response.isLoggedIn()) {
		    showMenu(true);
		    signInOutLink.setText("Logout");
		    signInOutLink.setHref(response.getLogoutUrl());
		} else {
		    showMenu(false);
		    signInOutLink.setText("Login");
		    signInOutLink.setHref(response.getLoginUrl());
		}
		RootPanel loginoutPanel = RootPanel.get("loginout");
		loginoutPanel.add(signInOutLink);

	    }
	});
	HistoryController controller = new HistoryController(appSpace);
	historyManager = new HistoryManager(controller);
	History.addValueChangeHandler(historyManager);
	HistoryToken.Home.fire();
	History.fireCurrentHistoryState();
    }

    private void showMenu(boolean value)
    {
	eigenReceptenMenuItem.setVisible(value);
	    eigenReceptenSeparator.setVisible(value);
	    receptToevoegenMenuItem.setVisible(value);
	    receptToevoegenSeparator.setVisible(value);
    }
    public void setText(String text) {
    }

    public String getText() {
	return null;
    }
}
