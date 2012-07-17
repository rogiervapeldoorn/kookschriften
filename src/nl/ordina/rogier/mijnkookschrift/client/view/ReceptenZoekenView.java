package nl.ordina.rogier.mijnkookschrift.client.view;

import nl.ordina.rogier.mijnkookschrift.client.controller.ControllerFactory;
import nl.ordina.rogier.mijnkookschrift.client.controller.ControllerInterface;
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
    public TextBox naamRecept;
    @UiField
    public ListBox soortRecept;
    @UiField
    public ListBox soortKeuken;
    @UiField
    public TextBox ingredient;
    @UiField
    public TextBox afkomstigVan;
    @UiField
    public Button zoeken;
    @UiField
    public DataGrid<ReceptProxy> dataGrid;
    @UiField
    public SimplePager pager;


    private static ReceptenZoekenUiBinder uiBinder = GWT.create(ReceptenZoekenUiBinder.class);

    interface ReceptenZoekenUiBinder extends UiBinder<Widget, ReceptenZoekenView> {
    }

    public ReceptenZoekenView() {
	initWidget(uiBinder.createAndBindUi(this));
	ControllerInterface controller=ControllerFactory.newController(this);
	controller.init();
	
    }

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

}
