package nl.ordina.rogier.kookschriften.client.model;

import nl.ordina.rogier.kookschriften.client.controller.EigenReceptenController;
import nl.ordina.rogier.kookschriften.client.view.HistoryToken;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class EigenReceptenManager {

    EigenReceptenController eigenReceptenController;
    public EigenReceptenManager(EigenReceptenController eigenReceptenController)
    {
	this.eigenReceptenController=eigenReceptenController;
    }
  

}
