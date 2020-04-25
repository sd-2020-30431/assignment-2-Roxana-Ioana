package main.repository;

import main.model.*;
import org.springframework.data.jpa.repository.*;

public interface UserRepository extends JpaRepository<User, Integer> {

    User findByUsernameAndPassword(String username, String password);

    User findByIdUser(int idUser);
}
