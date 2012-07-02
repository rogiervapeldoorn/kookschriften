package nl.ordina.rogier.kookschriften.client.model;

import nl.ordina.rogier.kookschriften.client.controller.ReceptenZoekenController;

import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;

public class ReceptenZoekenManager implements ClickHandler {
    ReceptenZoekenController controller;
    public ReceptenZoekenManager(ReceptenZoekenController receptenZoekenController){
	controller=receptenZoekenController;
    }
    
    public void init(){
	controller.init();
    }

    @Override
    public void onClick(ClickEvent event) {
	controller.zoekRecepten();
	
    }
    
}
