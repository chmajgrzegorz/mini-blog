package pl.grzegorzchmaj.blog.model.entities;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Tag {

    @Id
    @GeneratedValue
    private Long id;

    private String tagName;

    @Embedded
    private AuditEntity audit = new AuditEntity();

    

}
