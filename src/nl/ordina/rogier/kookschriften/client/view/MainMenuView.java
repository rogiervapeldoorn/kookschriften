package nl.ordina.rogier.kookschriften.client.view;

import nl.ordina.rogier.kookschriften.client.controller.HistoryController;
import nl.ordina.rogier.kookschriften.client.model.HistoryManager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.History;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.event.dom.client.ClickEvent;

public class MainMenuView extends Composite implements HasText {

    private static MainMenuUiBinder uiBinder = GWT.create(MainMenuUiBinder.class);
    @UiField MenuBar menuBar;
    @UiField MenuItem homeMenuItem;
    @UiField MenuItem eigenReceptenMenuItem;
    @UiField MenuItem receptToevoegenMenuItem;
    @UiField MenuItem receptenZoekenMenuItem;
    @UiField HTMLPanel appSpace;
    private HistoryManager historyManager;
    interface MainMenuUiBinder extends UiBinder<Widget, MainMenuView> {
    }

    public MainMenuView() {
	initWidget(uiBinder.createAndBindUi(this));
	homeMenuItem.setCommand(new MenuCommandView(HistoryToken.Home));
	eigenReceptenMenuItem.setCommand(new MenuCommandView(HistoryToken.EigenRecepten));
	receptToevoegenMenuItem.setCommand(new MenuCommandView(HistoryToken.ReceptToevoegen));
	receptenZoekenMenuItem.setCommand(new MenuCommandView(HistoryToken.ReceptenZoeken));
	HistoryController controller=new HistoryController(appSpace);
	historyManager=new HistoryManager(controller);
	History.addValueChangeHandler(historyManager);
	HistoryToken.Home.fire();
	History.fireCurrentHistoryState();
    }
    

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }
}
