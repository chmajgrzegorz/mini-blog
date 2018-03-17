package pl.grzegorzchmaj.blog.model.entities;

import javax.persistence.Embeddable;
import java.util.Date;

@Embeddable
public class AuditEntity {

    private Date added = new Date();
    private String addedBy;
    private Date modified;
    private String modifiedBy;

    public AuditEntity(Date added, String addedBy, Date modified, String modifiedBy) {
        this.added = added;
        this.addedBy = addedBy;
        this.modified = modified;
        this.modifiedBy = modifiedBy;
    }

    public AuditEntity() {
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }

    public String getAddedBy() {
        return addedBy;
    }

    public void setAddedBy(String addedBy) {
        this.addedBy = addedBy;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }


}
