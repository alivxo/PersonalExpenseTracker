package com.expense.tracker.util; // Declares the package this file belongs to

import io.jsonwebtoken.Claims; // Imports the Claims class from the io.jsonwebtoken package
import io.jsonwebtoken.Jwts; // Imports the Jwts class from the io.jsonwebtoken package
import io.jsonwebtoken.SignatureAlgorithm; // Imports the SignatureAlgorithm enum from the io.jsonwebtoken package
import io.jsonwebtoken.security.Keys;

import org.springframework.stereotype.Component; // Imports the Component annotation from Spring

import java.util.Date; // Imports the Date class from the java.util package

import javax.crypto.SecretKey;

@Component // Indicates that this class is a Spring component
public class JwtUtil {

    // Define your secret key as a Base64 string or a constant for signing
    private final String SECRET = "myStrongSecretKeyThatShouldBeVeryLong";

    // Convert the secret into a valid SecretKey
    private final SecretKey SECRET_KEY = Keys.hmacShaKeyFor(SECRET.getBytes());
    // Defines a constant for the expiration time of the JWT
    // (10 hours)

    // Method to generate a JWT token for a given username
    public String generateToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // Valid for 10 hours
                .signWith(SECRET_KEY, SignatureAlgorithm.HS256) // Updated to use Key and Algorithm
                .compact();
    }

    // Method to extract the username from a given JWT token
    public String extractUsername(String token) {
        return Jwts.parser()
                .setSigningKey(SECRET_KEY)
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    // Method to validate a given JWT token against a username
    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token); // Checks if the token's username
                                                                                  // matches and if the token is not
                                                                                  // expired
    }

    // Method to check if a given JWT token is expired
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date()); // Checks if the token's expiration date is
                                                                        // before the current date
    }

    // Method to extract claims from a given JWT token
    private Claims extractClaims(String token) {
        return Jwts.parser() // Creates a new JWT parser
                .setSigningKey(SECRET_KEY) // Sets the signing key for the parser
                .parseClaimsJws(token) // Parses the JWT token
                .getBody(); // Returns the body (claims) of the token
    }
}