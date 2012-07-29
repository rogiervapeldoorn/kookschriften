package nl.ordina.rogier.mijnkookschrift.client.view;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.mijnkookschrift.client.ExpensesRequestFactory;
import nl.ordina.rogier.mijnkookschrift.client.LoginRequest;
import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.LoginInfoProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class ReceptViewController implements ControllerInterface {

    ReceptView receptView;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    HistoryManager historyManager;
    List<String> uploadedImages = new ArrayList<String>();

    public final MultiWordSuggestOracle ingredients = new MultiWordSuggestOracle();
    public List<String> listofIngredients = new ArrayList<String>();

    ReceptViewController(HistoryManager historyManager, ReceptView receptView) {
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	this.historyManager = historyManager;
	this.receptView = receptView;
    }

    public void init() {
		    loggedInView();
    }

    private void loggedInView() {
	
		bind();
    }

    private void addValues() {
	
    }

    private void addImage(String imageUrl) {
	
    }

    private void bind() {
	    }



}
