package com.mezzoforte.greenstreet.domain.solution.repository;

import com.mezzoforte.greenstreet.domain.solution.entity.Solution;
import com.mezzoforte.greenstreet.domain.solution.entity.SolutionSympathy;
import com.mezzoforte.greenstreet.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SolutionSympathyRepository extends JpaRepository<SolutionSympathy, Long> {

    boolean existsBySolutionAndUser(Solution solution, User user);

    Optional<SolutionSympathy> findBySolutionAndUser(Solution solution, User user);
}
