package pl.grzegorzchmaj.blog.model.dtos;

import java.util.Date;

public class TagDTO {

    private Long id;
    private String tagName;
    private Date created;

    public TagDTO(Long id, String tagName, Date created) {
        this.id = id;
        this.tagName = tagName;
        this.created = created;
    }

    public TagDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
