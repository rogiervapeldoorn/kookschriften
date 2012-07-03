package nl.ordina.rogier.kookschriften.client.controller;

import java.util.List;

import nl.ordina.rogier.kookschriften.client.ExpensesRequestFactory;
import nl.ordina.rogier.kookschriften.client.ReceptRequest;
import nl.ordina.rogier.kookschriften.client.view.EigenReceptenView;
import nl.ordina.rogier.kookschriften.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.Window;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class EigenReceptenController {
    EigenReceptenView eigenRecepten;
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    public EigenReceptenController(EigenReceptenView eigenRecepten) {
	this.eigenRecepten = eigenRecepten;
	getEigenRecepten();
    }

    public void getEigenRecepten() {
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	ReceptRequest receptRequest = requestFactory.receptRequest();
	Request<List<ReceptProxy>> receptProxyList = receptRequest.findMyRecepten();
	receptProxyList.fire(new Receiver<List<ReceptProxy>>() {

	    @Override
	    public void onSuccess(List<ReceptProxy> response) {
		TextColumn<ReceptProxy> naamReceptColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			return object.getNaamRecept();
		    }
		};
		eigenRecepten.dataGrid.addColumn(naamReceptColumn, "Recept");
		
		TextColumn<ReceptProxy> urlColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			String urls = "URLS:";
		if (object.getUploadedImages()!=null)
			{
			for (String url : object.getUploadedImages()) {
			    urls=urls+url;
			} }
			return urls;
		    }
		};
		eigenRecepten.dataGrid.addColumn(urlColumn, "URL");
		
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
			    Window.alert("You selected: " + selected.getNaamRecept());
			}
		    }
		});

	    }

	});

    }
}
