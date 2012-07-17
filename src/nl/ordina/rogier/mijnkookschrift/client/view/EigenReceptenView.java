package nl.ordina.rogier.mijnkookschrift.client.view;

import nl.ordina.rogier.mijnkookschrift.client.controller.ControllerFactory;
import nl.ordina.rogier.mijnkookschrift.client.controller.ControllerInterface;
import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.SimplePager;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class EigenReceptenView extends Composite implements HasText {

    private static EigenReceptenUiBinder uiBinder = GWT.create(EigenReceptenUiBinder.class);
    @UiField
    public Button toevoegen;
    @UiField
    public DataGrid<ReceptProxy> dataGrid;
    @UiField
    public SimplePager pager;

    interface EigenReceptenUiBinder extends UiBinder<Widget, EigenReceptenView> {

    }

    public EigenReceptenView(HistoryManager historyManager) {
	initWidget(uiBinder.createAndBindUi(this));
	ControllerInterface controllerInterface = ControllerFactory.newController(this, historyManager);
	controllerInterface.init();
    }

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

}
