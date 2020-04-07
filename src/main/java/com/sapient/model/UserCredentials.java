package com.sapient.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_credentials_details")
public class UserCredentials {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_credentials_id")
    private Integer userCredentialsId;
	
	@Column(name ="user_id")
	private Integer userId;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	

}
