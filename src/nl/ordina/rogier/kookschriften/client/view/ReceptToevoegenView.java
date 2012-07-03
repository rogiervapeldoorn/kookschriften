package nl.ordina.rogier.kookschriften.client.view;

import java.util.logging.Logger;

import nl.ordina.rogier.kookschriften.client.controller.ReceptToevoegenController;
import nl.ordina.rogier.kookschriften.client.model.HistoryManager;
import nl.ordina.rogier.kookschriften.client.model.ReceptToevoegenManager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.TextArea;

public class ReceptToevoegenView extends Composite implements HasText {
    private static final Logger log = Logger.getLogger(ReceptToevoegenView.class.getName());

    private static ReceptToevoegenViewUiBinder uiBinder = GWT.create(ReceptToevoegenViewUiBinder.class);

    interface ReceptToevoegenViewUiBinder extends UiBinder<Widget, ReceptToevoegenView> {
    }

    @UiField
    public TextBox naamRecept;
    @UiField
    public ListBox soortRecept;
    @UiField
    public TextBox afkomstigVan;
    @UiField
    public Button opslaan;
    @UiField
    public HorizontalPanel tumbnails;
    @UiField
    public FileUpload uploadField;
    @UiField
    public Button uploadButton;
    @UiField
    public FormPanel uploadForm;
    @UiField public Button moreLines;
    @UiField public Button lessLines;
    @UiField public VerticalPanel ingredienten;
    @UiField public TextBox bereidingsTijd;
    @UiField public ListBox tijdEenheid;
    @UiField public TextArea bereiding;

    public ReceptToevoegenView(HistoryManager historyManager) {
	initWidget(uiBinder.createAndBindUi(this));

	naamRecept.addChangeHandler(new ChangeHandler() {
	    @Override
	    public void onChange(ChangeEvent event) {

	    }
	});
	uploadForm.setEncoding(FormPanel.ENCODING_MULTIPART);
	uploadForm.setMethod(FormPanel.METHOD_POST);
	uploadButton.setText("...");
	uploadButton.setEnabled(false);
	uploadField.setName("image");

	ReceptToevoegenController receptToevoegenController = new ReceptToevoegenController(historyManager, this);
	ReceptToevoegenManager receptToevoegenManager = new ReceptToevoegenManager(receptToevoegenController);
    }

    
    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

    @UiHandler("uploadButton")
    void onSubmit(ClickEvent e) {

	uploadForm.submit();

    }

}
