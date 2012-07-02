package nl.ordina.rogier.kookschriften.client.controller;

import nl.ordina.rogier.kookschriften.client.SoortRecept;

import com.google.gwt.user.client.ui.ListBox;

public class UtilController {

    public static void initSoortRecept(ListBox soortRecept) {
	SoortRecept[] soortRecepten = SoortRecept.values();
	for (SoortRecept soortReceptvalue : soortRecepten) {
	    soortRecept.addItem(soortReceptvalue.toString());
	}
    }

}
