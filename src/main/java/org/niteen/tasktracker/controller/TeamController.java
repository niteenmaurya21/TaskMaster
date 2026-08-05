package org.niteen.tasktracker.controller;

import jakarta.validation.Valid;
import org.niteen.tasktracker.dto.team.AddMemberRequest;
import org.niteen.tasktracker.dto.team.CreateTeamRequest;
import org.niteen.tasktracker.dto.team.TeamDTO;
import org.niteen.tasktracker.dto.team.UpdateTeamRequest;
import org.niteen.tasktracker.entity.Team;
import org.niteen.tasktracker.service.team.TeamService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/teams")
public class TeamController {

    //final field
    //need to assign value before the class finishes initializing.
    // failing to do so will fail the compilation or the compile process.
   private final TeamService teamService;

   public TeamController(TeamService teamService) {
       this.teamService = teamService;
   }

   @PostMapping
    public ResponseEntity<TeamDTO> createTeam(@Valid @RequestBody CreateTeamRequest request) {

       return ResponseEntity.ok(this.teamService.createTeam(request));
   }
   @GetMapping("/{id}")
   public ResponseEntity<TeamDTO> getTeamById(@PathVariable long id) {

       return ResponseEntity.ok(this.teamService.getTeamById(id));
   }
   @GetMapping("/all")
    public ResponseEntity<List<TeamDTO>> getAllTeams() {

       return ResponseEntity.ok(this.teamService.getAllTeams());
   }


   @PutMapping("/{id}")
    public ResponseEntity<TeamDTO> updateTeam(@PathVariable long id, @Valid @RequestBody UpdateTeamRequest request) {
       return ResponseEntity.ok(this.teamService.updateTeam(id, request));
   }
    @DeleteMapping("/{id}")
    public ResponseEntity<TeamDTO> deleteTeam(@PathVariable Long id) {

       teamService.deleteTeam(id);
       return ResponseEntity.noContent().build();
    }

    @PostMapping("/{teamId}/members")
    public ResponseEntity<TeamDTO> addMember(@PathVariable long teamId, @Valid @RequestBody AddMemberRequest request) {
       return ResponseEntity.ok(this.teamService.addMember(teamId, request));
    }

    @DeleteMapping("/{teamId}/members/{userId}")
    public ResponseEntity<TeamDTO> removeMember(@PathVariable long teamId, @PathVariable long userId) {
       
       return ResponseEntity.ok(this.teamService.removeMember(teamId, userId));
    }







}
