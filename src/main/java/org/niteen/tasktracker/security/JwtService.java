package org.niteen.tasktracker.security;


import org.springframework.security.core.userdetails.UserDetails;

import java.time.Instant;

public interface JwtService {

    //Every Method here has a single responsibility
    String generateToken(UserDetails userDetails);
    String extractUsername(String token);
    Instant extractExpiration(String token);
    boolean isTokenExpired(String token);
    boolean isTokenValid (String token, UserDetails userDetails);
}
