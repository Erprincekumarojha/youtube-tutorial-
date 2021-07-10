package com.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.model.UserData;

@Repository
public interface UserRepositery  extends JpaRepository<UserData, String>{

}
