package nl.ordina.rogier.kookschriften.client.controller;

import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;

public class HistoryController {
    private HTMLPanel currentWidget;
    public HistoryController(final HTMLPanel widget) {
	currentWidget=widget;
    }
    
    public void changeWidget(Widget widget)
    {
	currentWidget.clear();
	currentWidget.add(widget);
	
    }
    public void addWidget(Widget widget)
    {
	currentWidget.add(widget);
	
    }

}

