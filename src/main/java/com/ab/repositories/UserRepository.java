package com.ab.repositories;

import java.util.List;

import com.ab.entities.User;

import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);

	List<User> findByEmail(String email);

}
