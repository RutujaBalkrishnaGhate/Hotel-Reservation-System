package com.example.hotelreservation.pojo;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "admin")
public class Admin {
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long aid;

	    @Column(name = "firstName")
	    private String firstName;

	    @Column(name = "lastName")
	    private String lastName;

	    @Column(name = "email")
	    private String email;

	    @Column(name = "password")
	    private String password;

		public Long getAid() {
			return aid;
		}

		public void setAid(Long aid) {
			this.aid = aid;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}
	    
	    

}
