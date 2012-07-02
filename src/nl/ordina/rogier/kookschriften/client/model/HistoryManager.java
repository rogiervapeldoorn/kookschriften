package nl.ordina.rogier.kookschriften.client.model;

import nl.ordina.rogier.kookschriften.client.controller.HistoryController;
import nl.ordina.rogier.kookschriften.client.view.EigenReceptenView;
import nl.ordina.rogier.kookschriften.client.view.HistoryToken;
import nl.ordina.rogier.kookschriften.client.view.HomeView;
import nl.ordina.rogier.kookschriften.client.view.ReceptToevoegenView;
import nl.ordina.rogier.kookschriften.client.view.ReceptenZoekenView;

import com.google.gwt.event.logical.shared.ValueChangeEvent;
import com.google.gwt.event.logical.shared.ValueChangeHandler;

public class HistoryManager implements ValueChangeHandler<String> {

    HistoryController controller;

    public HistoryManager(HistoryController controller) {
	this.controller = controller;
    }

    @Override
    public void onValueChange(ValueChangeEvent<String> event) {
	changeValue(HistoryToken.valueOf(event.getValue()));
    }

    public void changeValue(HistoryToken selectedMenuItem) {
	
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
	    controller.changeWidget(new ReceptenZoekenView());
	    break;
	}
	case ReceptToevoegen: {
	    controller.changeWidget(new ReceptToevoegenView(this));
	    break;
	}
	default:
	    break;
	}
    }

}
