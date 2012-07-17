package nl.ordina.rogier.mijnkookschrift.shared.proxy;

import java.util.Date;

import nl.ordina.rogier.mijnkookschrift.domain.Tag;
import nl.ordina.rogier.mijnkookschrift.server.locator.TagLocator;

import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyFor;

@ProxyFor(value = Tag.class, locator = TagLocator.class)
public interface TagProxy extends EntityProxy {
    public String getPhotoKey();

    public void setPhotoKey(String photoKey);

    public String getTaggerId();

    public void setTaggerId(String taggerId);

    public String getBody();

    public void setBody(String body);

    public Date getCreatedAt();

    public void setCreatedAt(Date createdAt);

    public Long getX();

    public void setX(Long x);

    public Long getY();

    public void setY(Long y);
}
