# TaskMaster
Task master is a task tracking application where you can keep record of your task with your team and also keep the record for the changes in the task.
SpringBoot application used for managing task, team, user, comments, attachment

# includes various features like 
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
- Data JPA
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

# project Status 

This project is currently under Development 

###completed
- user Management
- Team Management
- Comment Management
- Attachment Management
- Layered Architecture
- REST Controllers
- Service Layer
- Repository Layer
- DTO Layer
- Entity Relationships
- Validation
- Global Exception Handling
- H2 Database Integration

### Planned Features

- JWT Authentication
- Role-Based Authorization
- Unit Testing
- File Upload Implementation
