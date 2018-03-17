package pl.grzegorzchmaj.blog.model.entities;

import pl.grzegorzchmaj.blog.model.dtos.TagDTO;

import javax.persistence.*;
import java.util.*;

@Entity
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;
    @Embedded
    private AuditEntity audit = new AuditEntity();


    @OneToMany(mappedBy = "post", cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    private List<Comment> comments = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToMany(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinTable(name = "mapPostTag", joinColumns = @JoinColumn(name = "postId"), inverseJoinColumns = @JoinColumn(name = "tagId"))
    private Set<Tag> tags = new HashSet<>();

    //====================================Get,Set,Const====================================//
}
