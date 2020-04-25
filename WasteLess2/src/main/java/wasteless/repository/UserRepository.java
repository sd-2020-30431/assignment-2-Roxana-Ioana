package wasteless.repository;

import org.springframework.data.jpa.repository.*;
import wasteless.model.*;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByIdUser(int idUser);
}
