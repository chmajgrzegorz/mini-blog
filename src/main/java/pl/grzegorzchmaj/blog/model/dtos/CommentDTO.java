package pl.grzegorzchmaj.blog.model.dtos;


import java.util.Date;

public class CommentDTO {

    private Long id;
    private String comment;
    private Date added;

    public CommentDTO(Long id, String comment, Date added) {
        this.id = id;
        this.comment = comment;
        this.added = added;
    }

    public CommentDTO() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Date getAdded() {
        return added;
    }

    public void setAdded(Date added) {
        this.added = added;
    }
}
