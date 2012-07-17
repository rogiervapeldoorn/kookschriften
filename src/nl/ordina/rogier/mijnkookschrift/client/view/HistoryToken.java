package nl.ordina.rogier.mijnkookschrift.client.view;

import com.google.gwt.user.client.History;

public enum HistoryToken {
	    Home,EigenRecepten,ReceptenZoeken,ReceptToevoegen,Login;

	    public void fire(){
	        History.newItem(this.toString());
	    }
}
