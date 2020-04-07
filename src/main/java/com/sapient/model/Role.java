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
@Table(name = "role_details")
public class Role {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_Iden")
    private Integer roleIden;
    
    @Column(name = "role_name")
    private String roleName;
    @Column(name = "read_access")
    private Boolean readAccess;
    @Column(name = "write_access")
    private Boolean writeAccess;
    @Column(name = "delete_access")
    private Boolean deleteAccess;
    @OneToMany(mappedBy = "role_details")

    
	@Override
	public String toString() {
		return "";
	}
	public Role(String roleName, Boolean readAccess, Boolean writeAccess, Boolean deleteAccess) {
		super();
		this.roleName = roleName;
		this.readAccess = readAccess;
		this.writeAccess = writeAccess;
		this.deleteAccess = deleteAccess;
	}
    
    
    
    
    
    
    
    
    
    
    
    
 

    

 

    

 

    
 

   

 

}