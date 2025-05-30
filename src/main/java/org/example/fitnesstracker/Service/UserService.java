package org.example.fitnesstracker.Service;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.UserCredential;
import org.example.fitnesstracker.DTO.UsersDTOUpload;
import org.example.fitnesstracker.exception.NotFoundDatabaseException;
import org.example.fitnesstracker.exception.UserAlreadyExistsException;
import org.example.fitnesstracker.models.Users;
import org.example.fitnesstracker.repository.UserRepo;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;
    private final PasswordEncoder passwordEncoder;

    public List<Users> findAll(){
        return userRepo.findAll();
    }

    public Users findById(long id) {
        Users users = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return users;
    }

//    public void register(UserCredential userCredential) {
//        userRepo.findByEmail(userCredential.getEmail()).orElseThrow(() ->
//                new UserAlreadyExistsException("User with email " + userCredential.getEmail() + " already exists"));
//
//        users.setPassword();
//
//        userRepo.save(users);
//    }

    public Users register(UsersDTOUpload user) {
        if (userRepo.findByEmail(user.getEmail()).isPresent()) {
            throw  new UserAlreadyExistsException("User with email " + user.getEmail() + " already exists");
        }

        return userRepo.save(new Users(
                null,
                user.getUsername(),
                user.getEmail(),
                passwordEncoder.encode(user.getPassword()),
                user.getWeight(),
                user.getHeight(),
                user.getBirthDate(),
                "ROLE_USER",
                null,
                null,
                null
        ));
    }

    public void delete(long id) {
        userRepo.deleteById(id);
    }

    public Users findByEmail(String email) {
        return userRepo.findByEmail(email).orElseThrow(()->
                new NotFoundDatabaseException("User with email " + email + " not found"));
    }
}
