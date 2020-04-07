package com.sapient.model;

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
@Table(name = "institute_details")
public class Institute {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="institute_id")
    private Integer instituteId;
    @Column(name="institute_name")
    private String instituteName;
    @Column(name="institute_address")
    private String instituteAddress;
    @Column(name="poc_name")
    private String pocName;
    @Column(name="poc_mobile")
    private Long pocMobile;
    @ManyToOne
	@JoinColumn(name="universityIden")
    private University university;
	@OneToMany(mappedBy = "institute_details")
    @Override
	public String toString() {
		return "";
	}
    
	
}
