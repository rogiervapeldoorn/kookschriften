package nl.ordina.rogier.mijnkookschrift.client.controller;

import java.util.List;

import org.apache.coyote.RequestGroupInfo;

import nl.ordina.rogier.mijnkookschrift.client.ExpensesRequestFactory;
import nl.ordina.rogier.mijnkookschrift.client.ReceptRequest;
import nl.ordina.rogier.mijnkookschrift.client.UploadedImageRequest;
import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.client.view.EigenReceptenView;
import nl.ordina.rogier.mijnkookschrift.client.view.HistoryToken;
import nl.ordina.rogier.mijnkookschrift.client.view.ImageColumn;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.ReceptProxy;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.UploadedImageProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class EigenReceptenController implements ControllerInterface {
    EigenReceptenView eigenRecepten;
    HistoryManager historyManager;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    EigenReceptenController(EigenReceptenView eigenRecepten, HistoryManager historyManager) {
 	this.eigenRecepten = eigenRecepten;
	this.historyManager = historyManager;
    }

    public void init() {
	bind();
	getEigenRecepten();

    }

    private void bind() {
	eigenRecepten.pager.firstPage();

	eigenRecepten.toevoegen.addClickHandler(new ClickHandler() {

	    @Override
	    public void onClick(ClickEvent event) {
		historyManager.changeValue(HistoryToken.ReceptToevoegen,null);
		HistoryToken.ReceptToevoegen.fire();
	    }
	});

    }

    public void getEigenRecepten() {
	eigenRecepten.pager.setDisplay(eigenRecepten.dataGrid);
	eigenRecepten.pager.setPageSize(6);
	final ListDataProvider<ReceptProxy> dataProvider = new ListDataProvider<ReceptProxy>();
	dataProvider.addDataDisplay(eigenRecepten.dataGrid);
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	ReceptRequest receptRequest = requestFactory.receptRequest();
	Request<List<ReceptProxy>> receptProxyList = receptRequest.findMyRecepten();
	receptProxyList.fire(new Receiver<List<ReceptProxy>>() {

	    @Override
	    public void onSuccess(List<ReceptProxy> response) {
		dataProvider.setList(response);
		ImageColumn<ReceptProxy> imageColumn = new ImageColumn<ReceptProxy>() {

		    @Override
		    public String getValue(ReceptProxy object) {
			if (object != null) {
			    List<String> strings = object.getUploadedImages();
			    if (strings != null) {
				for (String url : strings) {
				    return url + "=s100";
				}
			    }
			}
			return null;
		    }
		};

		eigenRecepten.dataGrid.addColumn(imageColumn, "plaatje");

		TextColumn<ReceptProxy> naamReceptColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			return object.getNaamRecept();
		    }
		};

		eigenRecepten.dataGrid.addColumn(naamReceptColumn, "Recept");

		TextColumn<ReceptProxy> soortReceptColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			if (object.getSoortRecept() != null) {
			    return object.getSoortRecept().toString();
			}
			return "";
		    }
		};
		eigenRecepten.dataGrid.addColumn(soortReceptColumn, "Soort Recept");

		TextColumn<ReceptProxy> soortKeukenColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			if (object.getSoortKeuken() != null) {
			    return object.getSoortKeuken().toString();
			}
			return "";
		    }
		};
		eigenRecepten.dataGrid.addColumn(soortKeukenColumn, "Soort Keuken");

		TextColumn<ReceptProxy> afkomstigVanColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			return object.getAfkomstigVan();
		    }
		};
		eigenRecepten.dataGrid.addColumn(afkomstigVanColumn, "Afkomstig van");

		eigenRecepten.dataGrid.setRowCount(response.size(), true);
		eigenRecepten.dataGrid.setRowData(0, response);

		// Set row selector
		final SingleSelectionModel<ReceptProxy> selectionModel = new SingleSelectionModel<ReceptProxy>();
		eigenRecepten.dataGrid.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
		    public void onSelectionChange(SelectionChangeEvent event) {
			ReceptProxy selected = selectionModel.getSelectedObject();
			if (selected != null) {
			    ReceptRequest receptRequest = requestFactory.receptRequest();
			    Request<ReceptProxy> requestReceptProxy = receptRequest.findRecept(selected.getId()).with("ingredienten");
			    requestReceptProxy.fire(new Receiver<ReceptProxy>() {

				@Override
				public void onSuccess(ReceptProxy response) {
				    HistoryToken.ReceptToevoegen.fire();				    
				    historyManager.changeValue(HistoryToken.ReceptToevoegen,response);
				}});
			}
		    }
		});

	    }

	});

    }
}
