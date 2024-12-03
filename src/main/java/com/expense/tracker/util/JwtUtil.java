package com.expense.tracker.util; // Declares the package this file belongs to

import io.jsonwebtoken.Claims; // Imports the Claims class from the io.jsonwebtoken package
import io.jsonwebtoken.Jwts; // Imports the Jwts class from the io.jsonwebtoken package
import io.jsonwebtoken.SignatureAlgorithm; // Imports the SignatureAlgorithm enum from the io.jsonwebtoken package
import org.springframework.stereotype.Component; // Imports the Component annotation from Spring

import java.util.Date; // Imports the Date class from the java.util package

@Component // Indicates that this class is a Spring component
public class JwtUtil {

    private final String SECRET_KEY = "your_secret_key"; // Defines a constant for the secret key used in signing the JWT
    private final long EXPIRATION_TIME = 1000 * 60 * 60 * 10; // Defines a constant for the expiration time of the JWT (10 hours)

    // Method to generate a JWT token for a given username
    public String generateToken(String username) {
        return Jwts.builder() // Creates a new JWT builder
                .setSubject(username) // Sets the subject (username) of the token
                .setIssuedAt(new Date()) // Sets the issued date of the token to the current date
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // Sets the expiration date of the token
                .signWith(SignatureAlgorithm.HS256, SECRET_KEY) // Signs the token with the HS256 algorithm and the secret key
                .compact(); // Builds the JWT and serializes it to a compact, URL-safe string
    }

    // Method to extract the username from a given JWT token
    public String extractUsername(String token) {
        return extractClaims(token).getSubject(); // Extracts the claims from the token and returns the subject (username)
    }

    // Method to validate a given JWT token against a username
    public boolean validateToken(String token, String username) {
        return extractUsername(token).equals(username) && !isTokenExpired(token); // Checks if the token's username matches and if the token is not expired
    }

    // Method to check if a given JWT token is expired
    private boolean isTokenExpired(String token) {
        return extractClaims(token).getExpiration().before(new Date()); // Checks if the token's expiration date is before the current date
    }

    // Method to extract claims from a given JWT token
    private Claims extractClaims(String token) {
        return Jwts.parser() // Creates a new JWT parser
                .setSigningKey(SECRET_KEY) // Sets the signing key for the parser
                .parseClaimsJws(token) // Parses the JWT token
                .getBody(); // Returns the body (claims) of the token
    }
}