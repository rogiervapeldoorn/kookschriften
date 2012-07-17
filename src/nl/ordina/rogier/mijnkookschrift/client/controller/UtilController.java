package nl.ordina.rogier.mijnkookschrift.client.controller;

import nl.ordina.rogier.mijnkookschrift.client.GewichtEenheid;
import nl.ordina.rogier.mijnkookschrift.client.SoortKeuken;
import nl.ordina.rogier.mijnkookschrift.client.SoortRecept;
import nl.ordina.rogier.mijnkookschrift.client.TijdEenheid;

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

    public static void initSoortKeuken(ListBox soortKeuken) {
	SoortKeuken[] soortKeukens = SoortKeuken.values();
	for (SoortKeuken soortKeukenValue : soortKeukens) {
	    soortKeuken.addItem(soortKeukenValue.toString());
	}
    }
    
    public static void initAantalPersonen(ListBox aantalPersonen) {
	for (int i=1;i<13;i++) {
	    aantalPersonen.addItem(""+i);
	}
    }
    public static void initGewichtsEenheid(ListBox eenheid) {
	GewichtEenheid[] gewichtEenhedenArray = GewichtEenheid.values();
	for (GewichtEenheid gewichtEenheid : gewichtEenhedenArray) {
	    eenheid.addItem(gewichtEenheid.toString());
	}
    }

    public static void selectItem(ListBox listBox, String string) {
	for (int i = 0; i < listBox.getItemCount(); i++) {
	    if (listBox.getItemText(i).equals(string)) {
		listBox.setSelectedIndex(i);
		break;
	    }
	}
    }
}
