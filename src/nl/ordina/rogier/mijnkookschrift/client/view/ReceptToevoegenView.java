package nl.ordina.rogier.mijnkookschrift.client.view;

import java.util.logging.Logger;

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
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextArea;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Widget;

public class ReceptToevoegenView extends Composite implements HasText {
    private static final Logger log = Logger.getLogger(ReceptToevoegenView.class.getName());

    private static ReceptToevoegenViewUiBinder uiBinder = GWT.create(ReceptToevoegenViewUiBinder.class);

    interface ReceptToevoegenViewUiBinder extends UiBinder<Widget, ReceptToevoegenView> {
    }

    @UiField
    TextBox naamRecept;
    @UiField
    ListBox soortRecept;
    @UiField
    ListBox soortKeuken;
    @UiField
    ListBox aantalPersonen;
    @UiField
    Button opslaan;
    @UiField
    HorizontalPanel tumbnails;
    @UiField
    FileUpload uploadField;
    @UiField
    Button uploadButton;
    @UiField
    FormPanel uploadForm;
    @UiField VerticalPanel ingredienten;
    @UiField TextBox bereidingsTijd;
    @UiField ListBox tijdEenheid;
    @UiField TextArea bereiding;
    @UiField HTMLPanel mainPanel;
    
    ReceptProxy receptProxy;
    public ReceptToevoegenView(HistoryManager historyManager,DatastoreObjectProxy datastoreObjectProxy) {
	receptProxy=(ReceptProxy) datastoreObjectProxy;
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
	ControllerInterface receptToevoegenController = ControllerFactory.newController(historyManager, this);
	receptToevoegenController.init();
    }

    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

    @UiHandler("uploadButton")
    void onSubmit(ClickEvent e) {
	uploadForm.submit();
	uploadField.setEnabled(false);
	uploadButton.setEnabled(false);
	uploadButton.setText("...");

    }

}
