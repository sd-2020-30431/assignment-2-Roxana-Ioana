package main.repository;

import main.model.*;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.*;

@Repository
public interface GoalRepository extends JpaRepository<Goal, Integer> {

    Optional<List<Goal>> findAllByIdUser(int idUser);
}
