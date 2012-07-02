package nl.ordina.rogier.kookschriften.client.view;

import nl.ordina.rogier.kookschriften.client.controller.ReceptenZoekenController;
import nl.ordina.rogier.kookschriften.client.model.ReceptenZoekenManager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.cellview.client.DataGrid;
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
    public TextBox ingredient;
    @UiField
    public TextBox afkomstigVan;
    @UiField
    public Button zoeken;
    @UiField
    public DataGrid<String> dataGrid;
    

    private static ReceptenZoekenUiBinder uiBinder = GWT.create(ReceptenZoekenUiBinder.class);

    interface ReceptenZoekenUiBinder extends UiBinder<Widget, ReceptenZoekenView> {
    }

    public ReceptenZoekenView() {
	initWidget(uiBinder.createAndBindUi(this));
	ReceptenZoekenController controller=new ReceptenZoekenController(this);
	ReceptenZoekenManager receptenZoekenManager=new ReceptenZoekenManager(controller);
	receptenZoekenManager.init();
	zoeken.addClickHandler(receptenZoekenManager);
    }

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

}
