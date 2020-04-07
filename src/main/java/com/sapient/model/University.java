package com.sapient.model;


import java.util.Date;


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
@Table(name = "university_details")
public class University {
   
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="university_iden")
    private Integer universityIden;
    @Column(name="university_name")
    private String universityName;
    @Column(name="university_address")
    private String universityAddress;
	@OneToMany(mappedBy = "university_details")
    @Override
	public String toString() {
		return "";
	}

	public University(String universityName, String universityAddress) {
		super();
		this.universityName = universityName;
		this.universityAddress = universityAddress;
	}


	
	
    
    
}
 






