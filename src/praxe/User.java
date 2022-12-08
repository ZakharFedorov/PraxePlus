/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praxe;

public class User {
    private int id;
    private String firstName;
    private String lastName;
    private int year_of_study;
    private String faculty;
    private String email;
    private String role;
    private String heslo;
    
    public User(){    
    }

    public User(int id, String firstName, String lastName, int year_of_study, String faculty, String email, String role, String heslo) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.year_of_study = year_of_study;
        this.faculty = faculty;
        this.email = email;
        this.role = role;
        this.heslo = heslo;
    }
    
    public User(User s) {
        this.id = s.id;
        this.lastName = s.lastName;
        this.year_of_study = s.year_of_study;
        this.faculty = s.faculty;
        this.email = s.email;
        this.role = s.role;
        this.heslo = s.heslo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getYear_of_study() {
        return year_of_study;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() {
        return role;
    }

    public String getHeslo() {
        return heslo;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setYear_of_study(int year_of_study) {
        this.year_of_study = year_of_study;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setHeslo(String heslo) {
        this.heslo = heslo;
    }
    

    @Override
    public String toString() {
        return "User{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", Year_of_study=" + year_of_study + ", Faculty=" + faculty + ", Email=" + email + ", Role=" + role + ", Heslo:" + heslo +  '}';
    }
}
