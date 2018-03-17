package pl.grzegorzchmaj.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorzchmaj.blog.model.entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post, Long>{

    //TODO - 3 searching methods
}
