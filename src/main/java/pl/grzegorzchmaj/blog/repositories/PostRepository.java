package pl.grzegorzchmaj.blog.repositories;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorzchmaj.blog.model.entities.Post;

import java.util.List;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    List<Post> findAllByTitleContains(String title);
    List<Post> findAllByTitleContains(String title, Sort sort);

    List<Post> findAllByTitleContainsOrContentContains(String likeTitle, String likeContent);

    //TODO - 2 searching methods - id, content
}
