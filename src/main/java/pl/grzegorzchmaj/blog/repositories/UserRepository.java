package pl.grzegorzchmaj.blog.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.grzegorzchmaj.blog.model.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    //TODO - findByUsername method - Optional
}
