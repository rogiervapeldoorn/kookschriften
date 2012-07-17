package nl.ordina.rogier.mijnkookschrift.client.controller;

import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.client.view.EigenReceptenView;
import nl.ordina.rogier.mijnkookschrift.client.view.IngredientView;
import nl.ordina.rogier.mijnkookschrift.client.view.ReceptToevoegenView;
import nl.ordina.rogier.mijnkookschrift.client.view.ReceptenZoekenView;

public class ControllerFactory {

    public static ControllerInterface newController(EigenReceptenView eigenRecepten, HistoryManager historyManager) {
	return new EigenReceptenController(eigenRecepten, historyManager);
    }

    public static ControllerInterface newController(IngredientView ingredient) {
	return new IngredientController(ingredient);
    }

    public static ControllerInterface newController(ReceptenZoekenView receptenZoeken) {
	return new ReceptenZoekenController(receptenZoeken);
    }
    public static ControllerInterface newController(HistoryManager historyManager, ReceptToevoegenView receptToevoegen) {
 	return new ReceptToevoegenController(historyManager, receptToevoegen);
     }
}
