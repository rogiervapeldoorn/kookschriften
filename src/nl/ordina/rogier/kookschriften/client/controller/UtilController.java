package nl.ordina.rogier.kookschriften.client.controller;

import nl.ordina.rogier.kookschriften.client.SoortRecepten;

import com.google.gwt.user.client.ui.ListBox;

public class UtilController {

    public static void initSoortRecept(ListBox soortRecept)
    {
	soortRecept.addItem(SoortRecepten.Voorgerecht.toString());
	soortRecept.addItem(SoortRecepten.Tussengerecht.toString());
	soortRecept.addItem(SoortRecepten.Hoofdgerecht.toString());
	soortRecept.addItem(SoortRecepten.Nagerecht.toString());
    }

}
