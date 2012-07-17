package nl.ordina.rogier.mijnkookschrift.client.view;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Widget;

public class HomeView extends Composite implements HasText {

    private static HomeUiBinder uiBinder = GWT.create(HomeUiBinder.class);

    interface HomeUiBinder extends UiBinder<Widget, HomeView> {
    }

    public HomeView() {
	initWidget(uiBinder.createAndBindUi(this));
    }

    public HomeView(String firstName) {
	initWidget(uiBinder.createAndBindUi(this));
    }

    @Override
    public String getText() {
	return null;
    }

    @Override
    public void setText(String text) {
	
    }



}
