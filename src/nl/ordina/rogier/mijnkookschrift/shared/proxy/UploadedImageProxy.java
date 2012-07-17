package nl.ordina.rogier.mijnkookschrift.shared.proxy;

import java.util.Date;
import java.util.List;

import nl.ordina.rogier.mijnkookschrift.domain.UploadedImage;
import nl.ordina.rogier.mijnkookschrift.server.locator.UploadedImageLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value=UploadedImage.class, locator=UploadedImageLocator.class)
public interface UploadedImageProxy extends EntityProxy  {
    public Long getId();
    public void setId(Long id);
    public String getServingUrl();
    public void setServingUrl(String servingUrl); 
    public Date getCreatedAt() ;
    public void setCreatedAt(Date createdAt); 
    public String getOwnerId();
    public void setOwnerId(String ownerId); 
    public List<TagProxy> getTags() ;
    public void setTags(List<TagProxy> tags); 

 }