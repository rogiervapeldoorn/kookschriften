package nl.ordina.rogier.mijnkookschrift.client.model;

import nl.ordina.rogier.mijnkookschrift.client.view.EigenReceptenView;
import nl.ordina.rogier.mijnkookschrift.client.view.HistoryController;
import nl.ordina.rogier.mijnkookschrift.client.view.HistoryToken;
import nl.ordina.rogier.mijnkookschrift.client.view.HomeView;
import nl.ordina.rogier.mijnkookschrift.client.view.LoginView;
import nl.ordina.rogier.mijnkookschrift.client.view.LogoutView;
import nl.ordina.rogier.mijnkookschrift.client.view.ReceptToevoegenView;
import nl.ordina.rogier.mijnkookschrift.client.view.ReceptView;
import nl.ordina.rogier.mijnkookschrift.client.view.ReceptenZoekenView;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.DatastoreObjectProxy;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class HistoryManager implements ValueChangeHandler<String> {

    HistoryController controller;

    public HistoryManager(HistoryController controller) {
	this.controller = controller;
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
	changeValue(HistoryToken.valueOf(event.getValue()),null);
    }

    public void changeValue(HistoryToken selectedMenuItem,DatastoreObjectProxy datastoreObjectProxy) {
	
	switch (selectedMenuItem) {
	case Home: {
	    controller.changeWidget(new HomeView());
	    break;
	}
	case EigenRecepten: {
	    controller.changeWidget(new EigenReceptenView(this));
	    break;
	}
	case ReceptenZoeken: {
	    controller.changeWidget(new ReceptenZoekenView(this));
	    break;
	}
	case ReceptToevoegen: {
	    controller.changeWidget(new ReceptToevoegenView(this,datastoreObjectProxy));
	    break;
	}
	case Login: {
	    controller.changeWidget(new LoginView(this,datastoreObjectProxy));
	    break;
	}
	case ReceptView: {
	    controller.changeWidget(new ReceptView(this,datastoreObjectProxy));
	    break;
	}
	default:
	    break;
	}
    }

}
