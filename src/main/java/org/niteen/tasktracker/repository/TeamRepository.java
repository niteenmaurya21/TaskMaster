package org.niteen.tasktracker.repository;

import org.niteen.tasktracker.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByTeamName(String teamName);
}
