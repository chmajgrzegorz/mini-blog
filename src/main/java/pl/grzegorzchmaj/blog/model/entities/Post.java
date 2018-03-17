package pl.grzegorzchmaj.blog.model.entities;

import pl.grzegorzchmaj.blog.model.dtos.TagDTO;

import javax.persistence.*;
import java.util.Date;
import java.util.Set;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @Embedded
    private AuditEntity audit = new AuditEntity();



}
