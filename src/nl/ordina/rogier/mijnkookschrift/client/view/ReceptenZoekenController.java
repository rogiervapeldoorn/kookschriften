package nl.ordina.rogier.mijnkookschrift.client.view;

import java.util.List;

import nl.ordina.rogier.mijnkookschrift.client.ExpensesRequestFactory;
import nl.ordina.rogier.mijnkookschrift.client.ReceptRequest;
import nl.ordina.rogier.mijnkookschrift.client.SoortKeuken;
import nl.ordina.rogier.mijnkookschrift.client.SoortRecept;
import nl.ordina.rogier.mijnkookschrift.client.model.HistoryManager;
import nl.ordina.rogier.mijnkookschrift.shared.proxy.ReceptProxy;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.logical.shared.ResizeEvent;
import com.google.gwt.event.logical.shared.ResizeHandler;
import com.google.gwt.user.cellview.client.DataGrid;
import com.google.gwt.user.cellview.client.TextColumn;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.view.client.ListDataProvider;
import com.google.gwt.view.client.SelectionChangeEvent;
import com.google.gwt.view.client.SingleSelectionModel;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;

public class ReceptenZoekenController implements ControllerInterface {
    private final ExpensesRequestFactory requestFactory = GWT.create(ExpensesRequestFactory.class);

    ReceptenZoekenView receptenZoeken;
    HistoryManager historyManager;

    ReceptenZoekenController(ReceptenZoekenView receptenZoeken, HistoryManager historyManager) {
	this.historyManager = historyManager;
	this.receptenZoeken = receptenZoeken;

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

    public void zoekRecepten() {
	UtilController.emptyDataGrid(receptenZoeken.dataGrid);
	
	receptenZoeken.dataGrid.setLoadingIndicator(new Image("ajax-loader.gif"));
	receptenZoeken.dataGrid.setEmptyTableWidget(new HTMLPanel("Geen recept gevonden."));
	receptenZoeken.pager.setDisplay(receptenZoeken.dataGrid);
	receptenZoeken.pager.setPageSize(6);
	final ListDataProvider<ReceptProxy> dataProvider = new ListDataProvider<ReceptProxy>();
	dataProvider.addDataDisplay(receptenZoeken.dataGrid);
	final EventBus eventBus = new SimpleEventBus();
	requestFactory.initialize(eventBus);
	ReceptRequest receptRequest = requestFactory.receptRequest();
	ReceptProxy receptProxy = receptRequest.create(ReceptProxy.class);
	receptProxy.setAfkomstigVan(receptenZoeken.afkomstigVan.getValue());
	receptProxy.setNaamRecept(receptenZoeken.naamRecept.getValue());
	if (!receptenZoeken.soortKeuken.getValue(receptenZoeken.soortKeuken.getSelectedIndex()).equals("")) {
	    receptProxy.setSoortKeuken(SoortKeuken.valueOf(receptenZoeken.soortKeuken.getValue(receptenZoeken.soortKeuken.getSelectedIndex())));
	}
	if (!receptenZoeken.soortRecept.getValue(receptenZoeken.soortRecept.getSelectedIndex()).equals("")) {
	    receptProxy.setSoortRecept(SoortRecept.valueOf(receptenZoeken.soortRecept.getValue(receptenZoeken.soortRecept.getSelectedIndex())));
	}
	Request<List<ReceptProxy>> receptProxyList = receptRequest.findAllRecepten(receptProxy);
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

		receptenZoeken.dataGrid.addColumn(imageColumn, "plaatje");

		TextColumn<ReceptProxy> naamReceptColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			return object.getNaamRecept();
		    }
		};

		receptenZoeken.dataGrid.addColumn(naamReceptColumn, "Recept");

		TextColumn<ReceptProxy> soortReceptColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			if (object.getSoortRecept() != null) {
			    return object.getSoortRecept().toString();
			}
			return "";
		    }
		};
		receptenZoeken.dataGrid.addColumn(soortReceptColumn, "Soort Recept");

		TextColumn<ReceptProxy> soortKeukenColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			if (object.getSoortKeuken() != null) {
			    return object.getSoortKeuken().toString();
			}
			return "";
		    }
		};
		receptenZoeken.dataGrid.addColumn(soortKeukenColumn, "Soort Keuken");

		TextColumn<ReceptProxy> afkomstigVanColumn = new TextColumn<ReceptProxy>() {
		    @Override
		    public String getValue(ReceptProxy object) {
			return object.getAfkomstigVan();
		    }
		};
		receptenZoeken.dataGrid.addColumn(afkomstigVanColumn, "Afkomstig van");

		receptenZoeken.dataGrid.setRowCount(response.size(), true);
		receptenZoeken.dataGrid.setRowData(0, response);

		receptenZoeken.dataGrid.setHeight((com.google.gwt.user.client.Window.getClientHeight() - 300) + "px");
		com.google.gwt.user.client.Window.addResizeHandler(new ResizeHandler() {

		    @Override
		    public void onResize(ResizeEvent event) {
			receptenZoeken.dataGrid.setHeight((com.google.gwt.user.client.Window.getClientHeight() - 300) + "px");

		    }
		});

		// Set row selector
		final SingleSelectionModel<ReceptProxy> selectionModel = new SingleSelectionModel<ReceptProxy>();
		receptenZoeken.dataGrid.setSelectionModel(selectionModel);
		selectionModel.addSelectionChangeHandler(new SelectionChangeEvent.Handler() {
		    public void onSelectionChange(SelectionChangeEvent event) {
			ReceptProxy selected = selectionModel.getSelectedObject();
			if (selected != null) {
			    ReceptRequest receptRequest = requestFactory.receptRequest();
			    Request<ReceptProxy> requestReceptProxy = receptRequest.findRecept(selected.getId()).with("ingredienten");
			    requestReceptProxy.fire(new Receiver<ReceptProxy>() {

				@Override
				public void onSuccess(ReceptProxy response) {
				    HistoryToken.ReceptView.fire();
				    historyManager.changeValue(HistoryToken.ReceptView, response);
				}
			    });
			}
		    }
		});
	    }

	});
    }
}
