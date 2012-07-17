package nl.ordina.rogier.mijnkookschrift.client.controller;

import java.util.List;

import nl.ordina.rogier.mijnkookschrift.client.ExpensesRequestFactory;
import nl.ordina.rogier.mijnkookschrift.client.ReceptRequest;
import nl.ordina.rogier.mijnkookschrift.client.SoortKeuken;
import nl.ordina.rogier.mijnkookschrift.client.SoortRecept;
import nl.ordina.rogier.mijnkookschrift.client.view.ReceptenZoekenView;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class ReceptenZoekenController implements ControllerInterface {
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    ReceptenZoekenView receptenZoeken;
    ReceptenZoekenController(ReceptenZoekenView receptenZoeken) {
	this.receptenZoeken= receptenZoeken;
	
    }
    

    public void init() {
	receptenZoeken.soortRecept.addItem("");
	UtilController.initSoortRecept(receptenZoeken.soortRecept);
	receptenZoeken.soortKeuken.addItem("");
	UtilController.initSoortKeuken(receptenZoeken.soortKeuken);
	receptenZoeken.zoeken.addClickHandler(new ClickHandler() {
	    
	    @Override
	    public void onClick(ClickEvent event) {
		zoekRecepten();
	    }
	});
    }
    public void zoekRecepten()
    {
	receptenZoeken.pager.setDisplay(receptenZoeken.dataGrid);
	receptenZoeken.pager.setPageSize(6);
	final ListDataProvider<ReceptProxy> dataProvider = new ListDataProvider<ReceptProxy>();
	dataProvider.addDataDisplay(receptenZoeken.dataGrid);
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	ReceptRequest receptRequest = requestFactory.receptRequest();
	ReceptProxy receptProxy=receptRequest.create(ReceptProxy.class);
	receptProxy.setAfkomstigVan(receptenZoeken.afkomstigVan.getValue());
	receptProxy.setNaamRecept(receptenZoeken.naamRecept.getValue());
	if (!receptenZoeken.soortKeuken.getValue(receptenZoeken.soortKeuken.getSelectedIndex()).equals(""))
	{
	    receptProxy.setSoortKeuken(SoortKeuken.valueOf(receptenZoeken.soortKeuken.getValue(receptenZoeken.soortKeuken.getSelectedIndex())));
	}
	if (!receptenZoeken.soortRecept.getValue(receptenZoeken.soortRecept.getSelectedIndex()).equals(""))
	{
	    receptProxy.setSoortRecept(SoortRecept.valueOf(receptenZoeken.soortRecept.getValue(receptenZoeken.soortRecept.getSelectedIndex())));
	}
	Request<List<ReceptProxy>> receptProxyList = receptRequest.findAllRecepten(receptProxy);
	receptProxyList.fire(new Receiver<List<ReceptProxy>>() {

	    @Override
	    public void onSuccess(List<ReceptProxy> response) {
		
		dataProvider.setList(response);
		TextColumn<ReceptProxy> naamReceptColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			return object.getNaamRecept();
		    }
		};
		receptenZoeken.dataGrid.addColumn(naamReceptColumn, "Recept");
		final SingleSelectionModel<ReceptProxy> selectionModel = new SingleSelectionModel<ReceptProxy>();
		receptenZoeken.dataGrid.setSelectionModel(selectionModel);
	    }
	    
	});
	System.out.println("Zoek");
    }
}
