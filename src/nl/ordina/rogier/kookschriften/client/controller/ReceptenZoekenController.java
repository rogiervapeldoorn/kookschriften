package nl.ordina.rogier.kookschriften.client.controller;

import nl.ordina.rogier.kookschriften.client.view.ReceptenZoekenView;

public class ReceptenZoekenController {
    
    ReceptenZoekenView receptenZoeken;
    public ReceptenZoekenController(ReceptenZoekenView receptenZoeken) {
	this.receptenZoeken= receptenZoeken;
	UtilController.initSoortRecept(receptenZoeken.soortRecept);
	
    }
    

    public void init() {
	// Add default values.
	//for (SoortRecepten soortRecepten : SoortRecepten.values()) {
	//    soortRecept.addItem(soortRecepten.toString());
	//	}
	//getRecepten();
    }
    public void zoekRecepten()
    {
	System.out.println(receptenZoeken.naamRecept.getValue());
	System.out.println(receptenZoeken.soortRecept.getItemText(receptenZoeken.soortRecept.getSelectedIndex()));
	System.out.println(receptenZoeken.ingredient.getValue());
	System.out.println(receptenZoeken.afkomstigVan.getValue());
    }
}
