package nl.ordina.rogier.kookschriften.client.view;

import nl.ordina.rogier.kookschriften.client.controller.IngredientController;
import nl.ordina.rogier.kookschriften.client.model.IngredientManager;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.ListBox;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.IntegerBox;

public class IngredientView extends Composite implements HasText {

    private static IngredientUiBinder uiBinder = GWT.create(IngredientUiBinder.class);
    @UiField 
    public TextBox Ingredient;
    @UiField 
    public ListBox Eenheid;
    @UiField IntegerBox Gewicht;

    interface IngredientUiBinder extends UiBinder<Widget, IngredientView> {
    }

    public IngredientView() {
	initWidget(uiBinder.createAndBindUi(this));
	IngredientController ingredientController= new IngredientController( this);
	IngredientManager ingredientManager = new IngredientManager(ingredientController);
    }


    public void setText(String text) {
    }

    public String getText() {
	return null;
    }

}
