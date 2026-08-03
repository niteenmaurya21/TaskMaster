package org.niteen.tasktracker.service.team;

import org.niteen.tasktracker.dto.team.AddMemberRequest;
import org.niteen.tasktracker.dto.team.CreateTeamRequest;
import org.niteen.tasktracker.dto.team.TeamDTO;
import org.niteen.tasktracker.dto.team.UpdateTeamRequest;
import org.niteen.tasktracker.entity.Team;
import org.niteen.tasktracker.entity.User;
import org.niteen.tasktracker.exception.TeamAlreadyExistsException;
import org.niteen.tasktracker.exception.TeamNotFoundException;
import org.niteen.tasktracker.exception.UserNotFoundException;
import org.niteen.tasktracker.exception.ValidationFailedException;
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

        if(teamRepository.findByTeamName(request.getTeamName()).isPresent()) {
            throw new TeamAlreadyExistsException("Team already exists");
        }

        User leader = userRepository.findById(request.getLeaderId()).orElseThrow(()->
                new UserNotFoundException("Leader not found"));
        Team team = new Team(
                request.getTeamName(),
                request.getTeamDescription(),
                leader
        );

        team.getMembers().add(leader);
        Team savedTeam = teamRepository.save(team);

        return teamMapper.toDto(savedTeam);
    }

    @Override
    public TeamDTO getTeamById(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(()->
                new TeamNotFoundException("Team with id " + id + " not found"));
        return teamMapper.toDto(team);
    }

    @Override
    public List<TeamDTO> getAllTeams() {
        List<Team> teams = teamRepository.findAll();
        if(teams.isEmpty()) {throw new TeamNotFoundException("Team not found");}

        return teams.stream().map(teamMapper :: toDto).toList();
    }

    @Override
    public TeamDTO updateTeam(Long id, UpdateTeamRequest request) {
        Team team = teamRepository.findById(id).orElseThrow(()->
                new TeamNotFoundException("Team with id " + id + " not found"));

        teamRepository.findByTeamName(request.getTeamName()).ifPresent(existingTeam -> {
            if(!existingTeam.getId().equals(team.getId())) {
                throw new TeamAlreadyExistsException("Team already exists");
            }
        });


        team.setTeamName(request.getTeamName());
        team.setTeamDescription(request.getTeamDescription());
        teamRepository.save(team);
        return teamMapper.toDto(team);
    }

    @Override
    public void deleteTeam(Long id) {
        Team team = teamRepository.findById(id).orElseThrow(()->
                new TeamNotFoundException("Team with id " + id + " not found"));

        teamRepository.delete(team);

    }

    @Override
    public TeamDTO addMember(Long teamId, AddMemberRequest request) {
        Team team = teamRepository.findById(teamId).orElseThrow(()->
                new  TeamNotFoundException("Team with id " + teamId + " not found"));
        User user = userRepository.findById(request.getUserId()).orElseThrow(()->
                new UserNotFoundException("User with id " + request.getUserId() + " not found"));

        if(team.getMembers().contains(user)){
            throw new ValidationFailedException("User is already member");
        };
        team.getMembers().add(user);
        Team savedTeam = teamRepository.save(team);

        return teamMapper.toDto(savedTeam);
    }

    @Override
    public TeamDTO removeMember(Long teamId, Long userId) {
        Team team = teamRepository.findById(teamId).orElseThrow(()->
                new  TeamNotFoundException("Team with id " + teamId + " not found"));
        User user = userRepository.findById(userId).orElseThrow(()->
                new UserNotFoundException("User with id " + userId + " not found"));

        if(!team.getMembers().contains(user)){
            throw new ValidationFailedException("User is not member");
        }

        team.getMembers().remove(user);

        Team UpdatedTeam = teamRepository.save(team);
        return teamMapper.toDto(UpdatedTeam);


    }
}