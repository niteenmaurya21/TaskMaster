package org.niteen.tasktracker.mapper;

import org.niteen.tasktracker.dto.team.CreateTeamRequest;
import org.niteen.tasktracker.dto.team.TeamDTO;
import org.niteen.tasktracker.entity.Team;
import org.springframework.stereotype.Component;

@Component
public class TeamMapper {

    public TeamDTO toDto(Team team) {

        if (team == null) {
            return null;
        }

        TeamDTO dto = new TeamDTO();

        dto.setId(team.getId());
        dto.setTeamName(team.getTeamName());
        dto.setTeamDescription(team.getTeamDescription());
        dto.setCreatedAt(team.getCreatedAt());

        if (team.getLeader() != null) {
            dto.setLeaderId(team.getLeader().getId());
            dto.setLeaderName(team.getLeader().getName());
        }

        dto.setMemberCount(team.getMembers().size());

        return dto;
    }

    public Team toEntity(CreateTeamRequest request) {

        if (request == null) {
            return null;
        }

        Team team = new Team();

        team.setTeamName(request.getTeamName());
        team.setTeamDescription(request.getTeamDescription());

        // Leader will be set in the Service layer
        // after fetching the User from UserRepository.

        return team;
    }
}