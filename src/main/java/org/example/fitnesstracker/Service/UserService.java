package org.example.fitnesstracker.Service;

import lombok.RequiredArgsConstructor;
import org.example.fitnesstracker.DTO.UsersDTOUpload;
import org.example.fitnesstracker.models.Users;
import org.example.fitnesstracker.repository.UserRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepo userRepo;

    public List<Users> findAll(){
        return userRepo.findAll();
    }

    public Users findById(long id) {
        Users users = userRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("User with id " + id + " not found"));
        return users;
    }

    public void save(UsersDTOUpload user) {
        userRepo.save(new Users(
                null,
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user.getWeight(),
                user.getHeight(),
                user.getBirthDate(),
                null,
                null,
                null
        ));
    }

    public void delete(long id) {
        userRepo.deleteById(id);
    }
}
