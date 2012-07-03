package nl.ordina.rogier.kookschriften.client.controller;

import nl.ordina.rogier.kookschriften.client.SoortRecept;
import nl.ordina.rogier.kookschriften.client.TijdEenheid;

import com.google.gwt.user.client.ui.ListBox;

public class UtilController {

    public static void initSoortRecept(ListBox soortRecept) {
	SoortRecept[] soortRecepten = SoortRecept.values();
	for (SoortRecept soortReceptvalue : soortRecepten) {
	    soortRecept.addItem(soortReceptvalue.toString());
	}
    }
    public static void initTijdEenheid(ListBox tijdEenheid) {
	TijdEenheid[] tijdEenheden = TijdEenheid.values();
	for (TijdEenheid tijdEenheidValue : tijdEenheden) {
	    tijdEenheid.addItem(tijdEenheidValue.toString());
	}
    }

}
