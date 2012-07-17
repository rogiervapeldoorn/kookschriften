package nl.ordina.rogier.mijnkookschrift.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

@Entity
public class UploadedImage {

    public static final String SERVING_URL = "servingUrl";
    public static final String CREATED_AT = "createdAt";
    public static final String OWNER_ID = "ownerId";
    
    @Id
    public Long id;
    String servingUrl;
   
    Integer version = 0;
    Date createdAt;
    String ownerId; // Refers to the User that uploaded this

    List<Tag> tags;

    public UploadedImage() {
	// No-arg constructor required by Objectify
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public String getServingUrl() {
	return servingUrl;
    }

    public void setServingUrl(String servingUrl) {
	this.servingUrl = servingUrl;
    }

    public Date getCreatedAt() {
	return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
	this.createdAt = createdAt;
    }

    public String getOwnerId() {
	return ownerId;
    }

    public void setOwnerId(String ownerId) {
	this.ownerId = ownerId;
    }

    public List<Tag> getTags() {
	return tags;
    }

    public void setTags(List<Tag> tags) {
	this.tags = tags;
    }

    public Integer getVersion() {
	return version;
    }

    public void setVersion(Integer version) {
	this.version = version;
    }

    /**
     * Auto-increment version # whenever persisted
     */
    @PrePersist
    void onPersist() {
	this.version++;
    }

}
