package nl.ordina.rogier.mijnkookschrift.client.view;

import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.DatastoreObjectProxy;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class ReceptView extends Composite implements HasText {

    private static ReceptViewUiBinder uiBinder = GWT.create(ReceptViewUiBinder.class);

    interface ReceptViewUiBinder extends UiBinder<Widget, ReceptView> {
    }
    ReceptProxy receptProxy;
    
    public ReceptView(HistoryManager historyManager,DatastoreObjectProxy datastoreObjectProxy) {
	receptProxy=(ReceptProxy) datastoreObjectProxy;
	initWidget(uiBinder.createAndBindUi(this));
	ControllerInterface receptToevoegenController = ControllerFactory.newController(historyManager, this);
	receptToevoegenController.init();
	
    }

    
    public void setText(String text) {
	
    }

    public String getText() {
	return null;
    }

}
