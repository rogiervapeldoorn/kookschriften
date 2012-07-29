package nl.ordina.rogier.mijnkookschrift.client.view;

import com.google.gwt.user.client.History;

public enum HistoryToken {
	    Home,EigenRecepten,ReceptenZoeken,ReceptToevoegen,Login,ReceptView;

	    public void fire(){
	        History.newItem(this.toString());
	    }
}
