package com.sapient.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "user_details")
public class User {
  
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="user_id")
    private Integer userId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "email", unique = true)
    private String email;
    @Column(name = "mobile", unique = true)
    private Long mobile;
//    @Column(name = "password")
//    private String password;
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "job_location")
    private String  jobLocation; 
//    @ManyToOne
//	@JoinColumn(name="roleIden")
//    private Role role;
//  @Column(name = "institution_name")
    
    
    @ManyToOne
	@JoinColumn(name="instituteId")
    private Institute institute;
    
    
//    @Column(name = "institution_address")
//    private String institutionAddress;
    @Column(name = "residential_address")
    private String residentialAddress;
    @Column(name = "active_status")
    private Boolean activeStatus;
    @ManyToOne
	@JoinColumn(name="batchId")
    private Batch batch;
    @ManyToOne
	@JoinColumn(name="categoryId")
    private Category category;
    @OneToMany(mappedBy = "user_details")
    @Override
	public String toString() {
		return "";
	}
    public User(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
	}



	public User(String firstName) {
		super();
		this.firstName = firstName;
		
	}



	public User(String firstName, String lastName, String email, Long mobile, Date birthdate,
			String jobLocation,   String residentialAddress,
			Boolean activeStatus, Batch batch, Category category) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.mobile = mobile;
//		this.password = password;
		this.birthdate = birthdate;
		this.jobLocation = jobLocation;
//		this.role = role;
//		this.institutionName = institutionName;
//		this.institutionAddress = institutionAddress;
		this.residentialAddress = residentialAddress;
		this.activeStatus = activeStatus;
		this.batch = batch;
		this.category = category;
	}



	
	



}