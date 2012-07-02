package nl.ordina.rogier.kookschriften.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Upload {
    @Id
    private Long id;
    private String uploadUrl;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getUploadUrl() {
        return uploadUrl;
    }
    public void setUploadUrl(String uploadUrl) {
        this.uploadUrl = uploadUrl;
    }
}
