package nl.ordina.rogier.mijnkookschrift.client.view;

import java.util.ArrayList;
import java.util.List;

import nl.ordina.rogier.mijnkookschrift.client.ExpensesRequestFactory;
import nl.ordina.rogier.mijnkookschrift.client.IngredientRequest;
import nl.ordina.rogier.mijnkookschrift.client.LoginRequest;
import nl.ordina.rogier.mijnkookschrift.client.ReceptRequest;
import nl.ordina.rogier.mijnkookschrift.client.SoortKeuken;
import nl.ordina.rogier.mijnkookschrift.client.SoortRecept;
import nl.ordina.rogier.mijnkookschrift.client.TijdEenheid;
import nl.ordina.rogier.mijnkookschrift.client.UploadUrlRequest;
import nl.ordina.rogier.mijnkookschrift.client.events.NewIngredientEvent;
import nl.ordina.rogier.mijnkookschrift.client.events.NewIngredientEventHandler;
import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.IngredientProxy;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.IngredientRegelProxy;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.LoginInfoProxy;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.MultiWordSuggestOracle;
import com.google.gwt.user.client.ui.PopupPanel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class ReceptToevoegenController implements ControllerInterface {

    ReceptToevoegenView receptToevoegen;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    HistoryManager historyManager;
    List<String> uploadedImages = new ArrayList<String>();

    public final MultiWordSuggestOracle ingredients = new MultiWordSuggestOracle();
    public List<String> listofIngredients = new ArrayList<String>();

    ReceptToevoegenController(HistoryManager historyManager, ReceptToevoegenView receptToevoegen) {
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	this.historyManager = historyManager;
	this.receptToevoegen = receptToevoegen;
    }

    public void init() {
	LoginRequest loginRequest=requestFactory.loginRequest();
	Request<LoginInfoProxy> loginRequestProxy=loginRequest.login(GWT.getHostPageBaseURL());
	loginRequestProxy.fire(new Receiver<LoginInfoProxy>() {

	    @Override
	    public void onSuccess(LoginInfoProxy response) {
		if (!response.isLoggedIn())
		{
		    historyManager.changeValue(HistoryToken.Login, response);
		    HistoryToken.Login.fire();    
		}
		else
		{
		    loggedInView();
		}
	    }
	});
	
    }

    private void loggedInView() {
	
	UtilController.initSoortRecept(receptToevoegen.soortRecept);
	UtilController.initTijdEenheid(receptToevoegen.tijdEenheid);
	UtilController.initSoortKeuken(receptToevoegen.soortKeuken);
	UtilController.initAantalPersonen(receptToevoegen.aantalPersonen);
	addValues();
	IngredientRequest ingredientRequest = requestFactory.ingredientRequest();
	Request<List<IngredientProxy>> request = ingredientRequest.findAll();
	request.fire(new Receiver<List<IngredientProxy>>() {

	    @Override
	    public void onSuccess(List<IngredientProxy> response) {

		for (IngredientProxy ingredientProxy : response) {
		    ingredients.add(ingredientProxy.getIngredient());
		    listofIngredients.add(ingredientProxy.getIngredient());
		}

	    }
	});

	IngredientView ingredient = new IngredientView(ingredients, listofIngredients, null);
	NewIngredientEventHandler newIngredientEventHandler = new NewIngredientEventHandler() {

	    @Override
	    public void onNewIngredient(NewIngredientEvent event) {
		if (receptToevoegen.ingredienten.getWidgetCount() < 40) {
		    IngredientView ingredient = new IngredientView(ingredients, listofIngredients, null);
		    receptToevoegen.ingredienten.add(ingredient);
		    ingredient.addNewIngredientEventHandler(this);
		}
	    }
	};
	ingredient.addNewIngredientEventHandler(newIngredientEventHandler);
	receptToevoegen.ingredienten.add(ingredient);
	startNewBlobstoreSession();
	bind();
    }

    private void addValues() {
	if (receptToevoegen.receptProxy != null) {
	    receptToevoegen.bereiding.setValue(receptToevoegen.receptProxy.getBereiding());
	    receptToevoegen.bereidingsTijd.setValue(receptToevoegen.receptProxy.getBereidingsTijd());
	    receptToevoegen.naamRecept.setValue(receptToevoegen.receptProxy.getNaamRecept());
	    for (IngredientRegelProxy ingredientRegelProxy : receptToevoegen.receptProxy.getIngredienten()) {
		IngredientView ingredientView = new IngredientView(ingredients, listofIngredients, ingredientRegelProxy);
		receptToevoegen.ingredienten.add(ingredientView);
	    }
	    if (receptToevoegen.receptProxy.getSoortRecept() != null) {
		UtilController.selectItem(receptToevoegen.soortRecept, receptToevoegen.receptProxy.getSoortRecept().toString());
	    }
	    if (receptToevoegen.receptProxy.getSoortKeuken() != null) {
		UtilController.selectItem(receptToevoegen.soortKeuken, receptToevoegen.receptProxy.getSoortKeuken().toString());
	    }
	    if (receptToevoegen.receptProxy.getAantalPersonen() != null) {
		UtilController.selectItem(receptToevoegen.aantalPersonen, receptToevoegen.receptProxy.getAantalPersonen().toString());
	    }
	    if (receptToevoegen.receptProxy.getBereidingsTijdEenheid() != null) {
		UtilController.selectItem(receptToevoegen.tijdEenheid, receptToevoegen.receptProxy.getBereidingsTijdEenheid().toString());
	    }
	    if (receptToevoegen.receptProxy.getUploadedImages() != null) {
		for (String imageUrl : receptToevoegen.receptProxy.getUploadedImages()) {
		    addImage(imageUrl);
		}
	    }
	    Button deleteButton = new Button();
	    deleteButton.setText("Verwijder");
	    receptToevoegen.mainPanel.add(deleteButton);
	    deleteButton.addClickHandler(new ClickHandler() {

		@Override
		public void onClick(ClickEvent event) {
		    final EventBus eventBus = new SimpleEventBus();
		    requestFactory.initialize(eventBus);
		    ReceptRequest receptRequest = requestFactory.receptRequest();
		    Request<Void> deleteRequest = receptRequest.delete(receptToevoegen.receptProxy.getId());
		    deleteRequest.fire(new Receiver<Void>() {

			@Override
			public void onSuccess(Void response) {
			    historyManager.changeValue(HistoryToken.EigenRecepten, null);
			    HistoryToken.EigenRecepten.fire();    
			}
		    });
		}
	    });
	}

    }

    private void addImage(String imageUrl) {
	uploadedImages.add(imageUrl);
	Image image = new Image();
	image.setUrl(imageUrl + "=s200");
	final PopupPanel imagePopup = new PopupPanel(true);
	imagePopup.setAnimationEnabled(true);
	imagePopup.setWidget(image);
	imagePopup.setGlassEnabled(true);
	imagePopup.setAutoHideEnabled(true);
	imagePopup.center();
	imagePopup.setHeight("100px");
	receptToevoegen.tumbnails.add(imagePopup);

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
		if (imageUrl!=null&&!imageUrl.equals(""))
		{
		    addImage(imageUrl);
		}
		receptToevoegen.uploadField.setEnabled(true);
		receptToevoegen.uploadButton.setEnabled(true);
		receptToevoegen.uploadButton.setText("Upload");

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
	if (receptToevoegen.receptProxy != null) {
	    receptProxy.setId(receptToevoegen.receptProxy.getId());
	    receptProxy.setVersion(receptToevoegen.receptProxy.getVersion());
	}
	receptProxy.setNaamRecept(receptToevoegen.naamRecept.getValue());
	receptProxy.setBereiding(receptToevoegen.bereiding.getValue());
	receptProxy.setBereidingsTijd(receptToevoegen.bereidingsTijd.getValue());
	receptProxy.setBereidingsTijdEenheid(TijdEenheid.valueOf(receptToevoegen.tijdEenheid.getValue(receptToevoegen.tijdEenheid.getSelectedIndex())));
	receptProxy.setSoortRecept(SoortRecept.valueOf(receptToevoegen.soortRecept.getValue(receptToevoegen.soortRecept.getSelectedIndex())));
	receptProxy.setSoortKeuken(SoortKeuken.valueOf(receptToevoegen.soortKeuken.getValue(receptToevoegen.soortKeuken.getSelectedIndex())));
	receptProxy.setAantalPersonen(new Integer(receptToevoegen.aantalPersonen.getValue(receptToevoegen.aantalPersonen.getSelectedIndex())));

	receptProxy.setUploadedImages(uploadedImages);
	List<IngredientRegelProxy> list = new ArrayList<IngredientRegelProxy>();
	for (int i = 0; i < receptToevoegen.ingredienten.getWidgetCount(); i++) {
	    IngredientView ingredientView = (IngredientView) receptToevoegen.ingredienten.getWidget(i);
	    IngredientRegelProxy ingredientRegelProxy = ingredientView.getIngredientRegelProxy(receptRequest);
	    if (ingredientRegelProxy != null) {
		list.add(ingredientRegelProxy);
	    }
	}
	receptProxy.setIngredienten(list);
	Request<Void> saveRequest = receptRequest.save(receptProxy);
	saveRequest.fire(new Receiver<Void>() {

	    @Override
	    public void onSuccess(Void response) {

		historyManager.changeValue(HistoryToken.EigenRecepten, null);
		HistoryToken.EigenRecepten.fire();

	    }

	    @Override
	    public void onFailure(ServerFailure error) {
		historyManager.changeValue(HistoryToken.EigenRecepten, null);
		HistoryToken.EigenRecepten.fire();
	    }

	});
	IngredientRequest ingredientRequest = requestFactory.ingredientRequest();
	List<IngredientProxy> lists = new ArrayList<IngredientProxy>();
	for (int i = 0; i < receptToevoegen.ingredienten.getWidgetCount(); i++) {
	    IngredientView ingredientView = (IngredientView) receptToevoegen.ingredienten.getWidget(i);
	    IngredientProxy ingredientProxy = ingredientRequest.create(IngredientProxy.class);
	    ingredientProxy.setIngredient(ingredientView.Ingredient.getValue());
	    if (!ingredientView.listofIngredients.contains(ingredientView.Ingredient.getValue())) {
		lists.add(ingredientProxy);
	    }
	}
	Request<Void> saveRequestI = ingredientRequest.saveAll(lists);
	saveRequestI.fire(new Receiver<Void>() {

	    @Override
	    public void onSuccess(Void response) {

	    }
	});

    }

}
