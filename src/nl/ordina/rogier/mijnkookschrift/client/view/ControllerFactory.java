package nl.ordina.rogier.mijnkookschrift.client.view;

import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;

public class ControllerFactory {

    public static ControllerInterface newController(EigenReceptenView eigenRecepten, HistoryManager historyManager) {
	return new EigenReceptenController(eigenRecepten, historyManager);
    }

    public static ControllerInterface newController(IngredientView ingredient) {
	return new IngredientController(ingredient);
    }

    public static ControllerInterface newController(ReceptenZoekenView receptenZoeken, HistoryManager historyManager) {
	return new ReceptenZoekenController(receptenZoeken,historyManager);
    }
    public static ControllerInterface newController(HistoryManager historyManager, ReceptToevoegenView receptToevoegen) {
 	return new ReceptToevoegenController(historyManager, receptToevoegen);
     }
}
