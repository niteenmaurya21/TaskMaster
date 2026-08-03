package org.niteen.tasktracker.service.team;

import org.niteen.tasktracker.dto.team.AddMemberRequest;
import org.niteen.tasktracker.dto.team.CreateTeamRequest;
import org.niteen.tasktracker.dto.team.TeamDTO;
import org.niteen.tasktracker.dto.team.UpdateTeamRequest;
import org.niteen.tasktracker.mapper.TeamMapper;
import org.niteen.tasktracker.repository.TeamRepository;
import org.niteen.tasktracker.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private final TeamRepository teamRepository;
    private final UserRepository userRepository;
    private final TeamMapper teamMapper;

    public TeamServiceImpl(
            TeamRepository teamRepository,
            UserRepository userRepository,
            TeamMapper teamMapper) {

        this.teamRepository = teamRepository;
        this.userRepository = userRepository;
        this.teamMapper = teamMapper;
    }

    @Override
    public TeamDTO createTeam(CreateTeamRequest request) {
        return null;
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        return null;
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        return List.of();
    }

    @Override
    public TeamDTO updateTeam(Long id, UpdateTeamRequest request) {
        return null;
    }

    @Override
    public void deleteTeam(Long id) {

    }

    @Override
    public TeamDTO addMember(Long teamId, AddMemberRequest request) {
        return null;
    }

    @Override
    public TeamDTO removeMember(Long teamId, Long userId) {
        return null;
    }
}