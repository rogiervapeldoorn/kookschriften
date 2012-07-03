package nl.ordina.rogier.kookschriften.client.controller;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory;
import nl.ordina.rogier.kookschriften.client.ReceptRequest;
import nl.ordina.rogier.kookschriften.client.UploadUrlRequest;
import nl.ordina.rogier.kookschriften.client.UploadedImageRequest;
import nl.ordina.rogier.kookschriften.client.model.HistoryManager;
import nl.ordina.rogier.kookschriften.client.view.HistoryToken;
import nl.ordina.rogier.kookschriften.client.view.IngredientView;
import nl.ordina.rogier.kookschriften.client.view.ReceptToevoegenView;
import nl.ordina.rogier.kookschriften.shared.proxy.IngredientRegelProxy;
import nl.ordina.rogier.kookschriften.shared.proxy.ReceptProxy;
import nl.ordina.rogier.kookschriften.shared.proxy.UploadedImageProxy;

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
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class ReceptToevoegenController {

    ReceptToevoegenView receptToevoegen;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    HistoryManager historyManager;
    private int nrOfIngredienten = 3;
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
	for (int i = 0; i < nrOfIngredienten; i++) {
	    IngredientView ingredient = new IngredientView();
	    receptToevoegen.ingredienten.add(ingredient);
	}
    }

    private void bind() {
	receptToevoegen.opslaan.addClickHandler(new ClickHandler() {
	    @Override
	    public void onClick(ClickEvent event) {
		save();
	    }
	});
	receptToevoegen.moreLines.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		IngredientView ingredient = new IngredientView();
		if (nrOfIngredienten < 40) {
		    receptToevoegen.ingredienten.add(ingredient);
		    nrOfIngredienten++;
		}
	    }
	});
	receptToevoegen.lessLines.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		if (nrOfIngredienten > 3) {
		    nrOfIngredienten--;
		    receptToevoegen.ingredienten.remove(nrOfIngredienten);
		}

	    }
	});

	receptToevoegen.uploadForm.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {

	    @Override
	    public void onSubmitComplete(SubmitCompleteEvent event) {
		receptToevoegen.uploadForm.reset();
		startNewBlobstoreSession();
		String key = event.getResults();
		UploadedImageRequest uploadedImageRequest = requestFactory.uploadedImageRequest();
		Request<UploadedImageProxy> request = uploadedImageRequest.findUploadedImageWithKey(key);
		request.fire(new Receiver<UploadedImageProxy>() {
		    @Override
		    public void onSuccess(UploadedImageProxy response) {
			uploadedImages.add(response.getId().toString());
			Image image = new Image();
			image.setUrl(response.getServingUrl());

			final PopupPanel imagePopup = new PopupPanel(true);
			imagePopup.setAnimationEnabled(true);
			imagePopup.setWidget(image);
			imagePopup.setGlassEnabled(true);
			imagePopup.setAutoHideEnabled(true);
			imagePopup.center();
			imagePopup.setHeight("100px");
			receptToevoegen.tumbnails.add(imagePopup);
		    }

		    @Override
		    public void onFailure(ServerFailure error) {
			System.out.println(error.getMessage());
		    }
		});

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
	receptProxy.setUploadedImages(uploadedImages);
	List<IngredientRegelProxy> list=new ArrayList<IngredientRegelProxy>();
	for (int i=0; i<receptToevoegen.ingredienten.getWidgetCount();i++){
	    IngredientView ingredientView=(IngredientView)receptToevoegen.ingredienten.getWidget(i);
	    IngredientRegelProxy ingredientRegelProxy=ingredientView.getIngredientRegelProxy(receptRequest);
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

    }

}
