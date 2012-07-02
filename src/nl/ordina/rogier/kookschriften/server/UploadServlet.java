package nl.ordina.rogier.kookschriften.server;

import java.io.IOException;
import java.util.Date;
import java.util.Map;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import nl.ordina.rogier.kookschriften.domain.UploadedImage;
import nl.ordina.rogier.kookschriften.server.service.ObjectifyDao;
import nl.ordina.rogier.kookschriften.server.service.UploadedImageDao;

import com.google.appengine.api.blobstore.BlobKey;
import com.google.appengine.api.blobstore.BlobstoreService;
import com.google.appengine.api.blobstore.BlobstoreServiceFactory;
import com.google.appengine.api.images.ImagesService;
import com.google.appengine.api.images.ImagesServiceFactory;
import com.googlecode.objectify.Key;


@SuppressWarnings("serial")
public class UploadServlet extends HttpServlet {
    private static final Logger log = Logger.getLogger(UploadServlet.class.getName());

	
    public void doPost(HttpServletRequest req, HttpServletResponse res)
        throws ServletException, IOException {
	BlobstoreService blobstoreService = BlobstoreServiceFactory.getBlobstoreService();    
        Map<String, BlobKey> blobs = blobstoreService.getUploadedBlobs(req);
        BlobKey blobKey = blobs.get("image");
       
        if (blobKey == null) {

        } else {
		ImagesService imagesService = ImagesServiceFactory.getImagesService();
        	
        	String imageUrl = imagesService.getServingUrl(blobKey);
        	imageUrl=imageUrl.replaceFirst("http://0.0.0.0", "http://127.0.0.1");
        	UploadedImageDao uploadedImageDao=new UploadedImageDao();
        	UploadedImage uploadedImage=new UploadedImage();
        	uploadedImage.setCreatedAt(new Date());
        	uploadedImage.setServingUrl( imageUrl);
        	uploadedImageDao.put(uploadedImage);
        	Long keyString = uploadedImage.getId();
        	res.setContentType("text/html");
        	res.getWriter().print(keyString.toString());
        	res.getWriter().flush();
         }
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	
    	String uploadedImageKey = req.getParameter("uploadedImageKey");
    	resp.setHeader("Content-Type", "text/html");
    	System.out.println("uploadedImageKey "+uploadedImageKey );
    	resp.getWriter().println(uploadedImageKey);
    	    	
    }
}
