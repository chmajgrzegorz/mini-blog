package pl.grzegorzchmaj.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorzchmaj.blog.model.entities.Tag;

@Repository
public interface TagRepository extends JpaRepository<Tag, Long> {
}
