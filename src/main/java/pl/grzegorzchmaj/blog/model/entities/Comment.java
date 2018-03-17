package pl.grzegorzchmaj.blog.model.entities;


import javax.persistence.*;

@Entity
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String coment;

    @Embedded
    private AuditEntity audit = new AuditEntity();
}
