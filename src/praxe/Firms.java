/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package praxe;

/**
 *
 * @author Пользователь
 */
public class Firms {
    private String name;
    private String branch_office;
    private String first_name_cp;
    private String last_name_cp;
    private String email_cp;
    private String password_cp;
    private String city;

    public Firms(){
        
    }
    
    public Firms(String name, String branch_office, String first_name_cp, String last_name_cp, String email_cp, String password_cp, String city) {
        this.name = name;
        this.branch_office = branch_office;
        this.first_name_cp = first_name_cp;
        this.last_name_cp = last_name_cp;
        this.email_cp = email_cp;
        this.password_cp = password_cp;
        this.city = city;
    }
    public Firms(Firms f) {
        this.name = f.name;
        this.branch_office = f.branch_office;
        this.first_name_cp = f.first_name_cp;
        this.last_name_cp = f.last_name_cp;
        this.email_cp = f.email_cp;
        this.password_cp = f.password_cp;
        this.city = f.city;
    }

    public String getName() {
        return name;
    }

    public String getBranch_office() {
        return branch_office;
    }

    public String getFirst_name_cp() {
        return first_name_cp;
    }

    public String getLast_name_cp() {
        return last_name_cp;
    }

    public String getEmail_cp() {
        return email_cp;
    }

    public String getPassword_cp() {
        return password_cp;
    }

    public String getCity() {
        return city;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBranch_office(String branch_office) {
        this.branch_office = branch_office;
    }

    public void setFirst_name_cp(String first_name_cp) {
        this.first_name_cp = first_name_cp;
    }

    public void setLast_name_cp(String last_name_cp) {
        this.last_name_cp = last_name_cp;
    }

    public void setEmail_cp(String email_cp) {
        this.email_cp = email_cp;
    }

    public void setPassword_cp(String password_cp) {
        this.password_cp = password_cp;
    }

    public void setCity(String city) {
        this.city = city;
    }
    
    
}
