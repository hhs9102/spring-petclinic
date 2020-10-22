package org.springframework.samples.petclinic.user;

import org.springframework.data.repository.Repository;
import org.springframework.samples.petclinic.model.User;

import java.util.Optional;


public interface UserRepository extends Repository<User, Integer> {

    void save(User user);
    Optional<User> findById(Integer id);
    User findByUsername(String username);
}
