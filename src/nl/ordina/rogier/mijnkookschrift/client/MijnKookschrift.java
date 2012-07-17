package nl.ordina.rogier.mijnkookschrift.client;

import nl.ordina.rogier.mijnkookschrift.client.view.MainMenuView;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

/**
 * Entry point classes define <code>onModuleLoad()</code>.
 */
public class MijnKookschrift implements EntryPoint {
	/**
	 * This is the entry point method.
	 */
	public void onModuleLoad() {
		
		// Add the nameField and sendButton to the RootPanel
		// Use RootPanel.get() to get the entire body element
		RootPanel rootPanel = RootPanel.get("rootPanel");
		rootPanel.add(new MainMenuView());
		
	}
}
