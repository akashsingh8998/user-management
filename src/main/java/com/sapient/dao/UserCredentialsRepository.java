package com.sapient.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.model.UserCredentials;

public interface UserCredentialsRepository extends JpaRepository<UserCredentials, Integer>{

}
