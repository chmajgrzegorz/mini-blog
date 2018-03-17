package pl.grzegorzchmaj.blog.model.dtos;


import java.util.Date;
import java.util.Set;

public class PostDTO {

    private Long id;
    private String title;
    private String content;
    private Long userId;
    private Date created;
    private Set<TagDTO> tags;

    public PostDTO(Long id, String title, String content, Long userId, Date created, Set<TagDTO> tags) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.userId = userId;
        this.created = created;
        this.tags = tags;
    }

    public Set<TagDTO> getTags() {
        return tags;
    }

    public void setTags(Set<TagDTO> tags) {
        this.tags = tags;
    }

    public PostDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
}
