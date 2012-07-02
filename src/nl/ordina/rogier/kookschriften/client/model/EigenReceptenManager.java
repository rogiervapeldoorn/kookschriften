package nl.ordina.rogier.kookschriften.client.model;

import nl.ordina.rogier.kookschriften.client.controller.EigenReceptenController;
import nl.ordina.rogier.kookschriften.client.view.HistoryToken;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class EigenReceptenManager implements ClickHandler {

    HistoryManager historyManager;
    EigenReceptenController eigenReceptenController;
    public EigenReceptenManager(HistoryManager historyManager,EigenReceptenController eigenReceptenController)
    {
	this.historyManager=historyManager;
	this.eigenReceptenController=eigenReceptenController;
    }
    @Override
    public void onClick(ClickEvent event) {
	historyManager.changeValue(HistoryToken.ReceptToevoegen);
	HistoryToken.ReceptToevoegen.fire();
	
			
    }

}
