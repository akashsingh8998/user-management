package com.sapient.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
@Table(name = "batch_details")
public class Batch {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "batch_id", nullable = false)
	Integer batchId;
	@Column(name = "batch_name", nullable = false)
	String batchName;
	@Column(name = "description", nullable = false)
	String description;
	@OneToMany(mappedBy = "batch_details")
	@Override
	public String toString() {
		return "";
	}
	public Batch(String batchName, String description) {
		super();
		this.batchName = batchName;
		this.description = description;
	}
	
	
	
	
	
	

}
