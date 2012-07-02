package nl.ordina.rogier.kookschriften.client.view;

import com.google.gwt.user.client.History;

public enum HistoryToken {
	    Home,EigenRecepten,ReceptenZoeken,ReceptToevoegen;

	    public void fire(){
	        History.newItem(this.toString());
	    }
}
