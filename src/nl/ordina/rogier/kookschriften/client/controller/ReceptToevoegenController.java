package nl.ordina.rogier.kookschriften.client.controller;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory;
import nl.ordina.rogier.kookschriften.client.IngredientRequest;
import nl.ordina.rogier.kookschriften.client.ReceptRequest;
import nl.ordina.rogier.kookschriften.client.TijdEenheid;
import nl.ordina.rogier.kookschriften.client.UploadUrlRequest;
import nl.ordina.rogier.kookschriften.client.events.NewIngredientEvent;
import nl.ordina.rogier.kookschriften.client.events.NewIngredientEventHandler;
import nl.ordina.rogier.kookschriften.client.model.HistoryManager;
import nl.ordina.rogier.kookschriften.client.view.HistoryToken;
import nl.ordina.rogier.kookschriften.client.view.IngredientView;
import nl.ordina.rogier.kookschriften.client.view.ReceptToevoegenView;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientProxy;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientRegelProxy;
import nl.ordina.rogier.kookschriften.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class ReceptToevoegenController {

    ReceptToevoegenView receptToevoegen;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    HistoryManager historyManager;
    List<String> uploadedImages = new ArrayList<String>();

    public ReceptToevoegenController(HistoryManager historyManager, ReceptToevoegenView receptToevoegen) {
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	this.historyManager = historyManager;
	this.receptToevoegen = receptToevoegen;
	init();
	startNewBlobstoreSession();
	bind();
    }

    private void init() {
	UtilController.initSoortRecept(receptToevoegen.soortRecept);
	UtilController.initTijdEenheid(receptToevoegen.tijdEenheid);
	IngredientView ingredient = new IngredientView();
	NewIngredientEventHandler newIngredientEventHandler = new NewIngredientEventHandler() {

	    @Override
	    public void onNewIngredient(NewIngredientEvent event) {
		if (receptToevoegen.ingredienten.getWidgetCount() < 40) {
		    IngredientView ingredient = new IngredientView();
		    receptToevoegen.ingredienten.add(ingredient);
		    ingredient.addNewIngredientEventHandler(this);
		}
	    }
	};
	ingredient.addNewIngredientEventHandler(newIngredientEventHandler);
	receptToevoegen.ingredienten.add(ingredient);
    }

    private void bind() {
	receptToevoegen.opslaan.addClickHandler(new ClickHandler() {
	    @Override
	    public void onClick(ClickEvent event) {
		save();
	    }
	});

	receptToevoegen.uploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {

	    @Override
	    public void onSubmitComplete(SubmitCompleteEvent event) {
		receptToevoegen.uploadForm.reset();
		startNewBlobstoreSession();
		String imageUrl = event.getResults();
		uploadedImages.add(imageUrl);
		Image image = new Image();
		image.setUrl(imageUrl+"=s200");
		final PopupPanel imagePopup = new PopupPanel(true);
		imagePopup.setAnimationEnabled(true);
		imagePopup.setWidget(image);
		imagePopup.setGlassEnabled(true);
		imagePopup.setAutoHideEnabled(true);
		imagePopup.center();
		imagePopup.setHeight("100px");
		receptToevoegen.tumbnails.add(imagePopup);

	    }
	});
    }

    public void startNewBlobstoreSession() {
	UploadUrlRequest uploadUrlRequest = requestFactory.uploadUrlRequest();
	Request<String> url = uploadUrlRequest.getUploadUrl();
	url.fire(new Receiver<String>() {

	    @Override
	    public void onSuccess(String response) {
		// TODO: for debug
		response = response.replace("BA91-CNU1491W0W", "127.0.0.1");
		receptToevoegen.uploadForm.setAction(response);
		receptToevoegen.uploadButton.setText("Upload");
		receptToevoegen.uploadButton.setEnabled(true);
	    }
	});

    }

    public void save() {
	receptToevoegen.opslaan.setEnabled(false);
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	ReceptRequest receptRequest = requestFactory.receptRequest();
	ReceptProxy receptProxy = receptRequest.create(ReceptProxy.class);
	receptProxy.setNaamRecept(receptToevoegen.naamRecept.getValue());
	receptProxy.setAfkomstigVan(receptToevoegen.afkomstigVan.getValue());
	receptProxy.setBereiding(receptToevoegen.bereiding.getValue());
	receptProxy.setBereidingsTijd(receptToevoegen.bereidingsTijd.getValue());
	receptProxy.setBereidingsTijdEenheid(TijdEenheid.valueOf(receptToevoegen.tijdEenheid.getValue(receptToevoegen.tijdEenheid.getSelectedIndex())));
	receptProxy.setUploadedImages(uploadedImages);
	List<IngredientRegelProxy> list = new ArrayList<IngredientRegelProxy>();
	for (int i = 0; i < receptToevoegen.ingredienten.getWidgetCount(); i++) {
	    IngredientView ingredientView = (IngredientView) receptToevoegen.ingredienten.getWidget(i);
	    IngredientRegelProxy ingredientRegelProxy = ingredientView.getIngredientRegelProxy(receptRequest);
	    list.add(ingredientRegelProxy);
	}
	receptProxy.setIngredienten(list);
	Request<Void> saveRequest = receptRequest.save(receptProxy);
	saveRequest.fire(new Receiver<Void>() {

	    @Override
	    public void onSuccess(Void response) {


		historyManager.changeValue(HistoryToken.EigenRecepten);
		HistoryToken.EigenRecepten.fire();
		
	    }

	});
	IngredientRequest ingredientRequest = requestFactory.ingredientRequest();
	List<IngredientProxy> lists = new ArrayList<IngredientProxy>();
	for (int i = 0; i < receptToevoegen.ingredienten.getWidgetCount(); i++) {
	    IngredientView ingredientView = (IngredientView) receptToevoegen.ingredienten.getWidget(i);
	    IngredientProxy ingredientProxy= ingredientRequest.create(IngredientProxy.class);
	    ingredientProxy.setIngredient(ingredientView.Ingredient.getValue());
	    if (!ingredientView.listofIngredients.contains(ingredientView.Ingredient.getValue()))
	    {
		lists.add(ingredientProxy);
	    }
	}
	Request<Void> saveRequestI =ingredientRequest.saveAll(lists);
	saveRequestI.fire(new Receiver<Void>() {

	    @Override
	    public void onSuccess(Void response) {
		
	    }
	});

    }

}
