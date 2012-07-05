package nl.ordina.rogier.kookschriften.client.view;

import nl.ordina.rogier.kookschriften.client.controller.EigenReceptenController;
import nl.ordina.rogier.kookschriften.client.model.EigenReceptenManager;
import nl.ordina.rogier.kookschriften.client.model.HistoryManager;
import nl.ordina.rogier.kookschriften.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.cellview.client.SimplePager;

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
	EigenReceptenController eigenReceptenController = new EigenReceptenController(this, historyManager);
	EigenReceptenManager eigenReceptenManager = new EigenReceptenManager(eigenReceptenController);
    }

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

}
