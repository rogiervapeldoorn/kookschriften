package nl.ordina.rogier.mijnkookschrift.client.view;

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
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class ReceptenZoekenView extends Composite implements HasText {

    @UiField
    TextBox naamRecept;
    @UiField
    ListBox soortRecept;
    @UiField
    ListBox soortKeuken;
    @UiField
    TextBox ingredient;
    @UiField
    TextBox afkomstigVan;
    @UiField
    Button zoeken;
    @UiField
    DataGrid<ReceptProxy> dataGrid;
    @UiField
    SimplePager pager;


    private static ReceptenZoekenUiBinder uiBinder = GWT.create(ReceptenZoekenUiBinder.class);

    interface ReceptenZoekenUiBinder extends UiBinder<Widget, ReceptenZoekenView> {
    }

    public ReceptenZoekenView(HistoryManager historyManager) {
	initWidget(uiBinder.createAndBindUi(this));
	ControllerInterface controller=ControllerFactory.newController(this,historyManager);
	controller.init();
	
    }

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

}
