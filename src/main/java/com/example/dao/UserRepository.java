package com.example.dao;

import java.util.List;


import com.example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	
	List<User> findByAddress(String address);

}
