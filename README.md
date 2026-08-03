# TaskMaster
Task master is a task tracking application where you can keep record of your task with your team and also keep the record for the changes in the task.
SpringBoot application used for managing task, team, user, comments, attachment

# includes various fetures like 
 -UserRegistration
 -TeamManagement 
 -TaskAssingment
 -Comments
 -Attachments
 -ExceptionHandling
 -DTOs
 -Mapper
 -Repositories

# TechStack Used
- JAVA
- SpringBoot
- DataJpa
- Hibernate
- MySQL
- Gradle

## few structures that i used for making this application

for DTO after thinking a while i decided to group request and dto file and separate them based on the entity 
dto
│
├── user
│   ├── UserDTO
│   ├── RegisterRequest
│   ├── LoginRequest
│   ├── LoginResponse
│   └── UpdateUserRequest
│
├── task
│   ├── TaskDTO
│   ├── CreateTaskRequest
│   ├── UpdateTaskRequest
│   └── AssignTaskRequest
│
├── team
│   ├── TeamDTO
│   ├── CreateTeamRequest
│   ├── UpdateTeamRequest
│   └── AddMemberRequest
|
|
|
ETC...
 
 Everything related to Task is in one place.
 Easy to navigate as the project grows.
 Most Spring Boot projects use this or a similar feature-based structure


##THE PROJECT WILL STILL TAKE SOME TIME TO COMPLETE##
TODO: Controller,Security, Role based Authorisation,Unit Testing  and also file Upload System
