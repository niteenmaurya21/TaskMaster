package org.niteen.tasktracker.service.team;

import org.niteen.tasktracker.dto.team.AddMemberRequest;
import org.niteen.tasktracker.dto.team.CreateTeamRequest;
import org.niteen.tasktracker.dto.team.TeamDTO;
import org.niteen.tasktracker.dto.team.UpdateTeamRequest;

import java.util.List;

public interface TeamService {

    TeamDTO createTeam(CreateTeamRequest request);

    TeamDTO getTeamById(Long id);

    List<TeamDTO> getAllTeams();

    TeamDTO updateTeam(Long id, UpdateTeamRequest request);

    void deleteTeam(Long id);

    TeamDTO addMember(Long teamId, AddMemberRequest request);

    TeamDTO removeMember(Long teamId, Long userId);
}
