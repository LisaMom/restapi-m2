package kh.edu.istad.restapi.repository;

import kh.edu.istad.restapi.model.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        users = new ArrayList<>();
        User userAdmin = new User(UUID.randomUUID(), "admin", "admin12!@", "admin12@gmail.com", true);
        User userEditor = new User(UUID.randomUUID(), "editor", "editor12", "editor12@gmail.com", true);

        users.add(userAdmin);
        users.add(userEditor);
    }

    public List<User> selectAll() {
        return users;
    }

    public Optional<User> selectById(UUID id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst();
    }


    public User insert(User user) {
        users.add(user);
        return user;
    }


    public User create(User user) {
        users.add(user);
        return user;
    }

    public boolean deleteById(UUID id) {
        return users.removeIf(user -> user.getId().equals(id));
    }
}
