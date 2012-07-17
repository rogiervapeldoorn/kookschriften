package nl.ordina.rogier.mijnkookschrift.client;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface ExpensesRequestFactory extends RequestFactory {

    ReceptRequest receptRequest();
    UploadUrlRequest uploadUrlRequest();
    UploadedImageRequest uploadedImageRequest();
    IngredientRegelRequest ingredientRegelRequest();
    IngredientRequest ingredientRequest();
    LoginRequest loginRequest();
  }