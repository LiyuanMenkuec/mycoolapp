package com.theCode.demo.mycoolapp.entities;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student")
public class InfoOfStudent {
	
	//define fields for Columns in database
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="first_name")
    private String firstname;

    @Column(name="last_name")
    public String lastname;

    @Column(name="email")
    public String email;

    //define no-argument constructor
    public InfoOfStudent() { }

    
    public InfoOfStudent(String email, String firstname, String lastname) {
        this.email = email;
        this.firstname = firstname;
        this.lastname = lastname;
        
    }

    //define setter and getter
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

	@Override
	public String toString() {
		return "InfoOfStudent [firstname=" + firstname + ", lastname=" + lastname + ", email=" + email + "]";
	}
    
    //define toString methods

  
}
