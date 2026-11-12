package kh.edu.istad.restapi.dto;

public record CreateUserRequest(
        String username,
        String password,
        String email
) {
}
