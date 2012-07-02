package nl.ordina.rogier.kookschriften.client;

import com.google.web.bindery.requestfactory.shared.RequestFactory;

public interface ExpensesRequestFactory extends RequestFactory {

    ReceptRequest receptRequest();
    UploadUrlRequest uploadUrlRequest();
    UploadedImageRequest uploadedImageRequest();

  }