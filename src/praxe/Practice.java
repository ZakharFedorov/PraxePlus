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
public class Practice {
    private String topic;
    private String description;
    private String requirement;
    private String city;
    private String orientation;
    private int state;
    private String consult_first_name;
    private String consult_last_name;
    private String consult_email;
    private String firm_name;
    private int student_id;
    private int teacher_id;
    private int year;

    public Practice(){
        
    }
    
    public Practice(String topic, String description, String requirement, String city, String orientation, int state, String consult_first_name, String consult_last_name, String consult_email, String firm_name, int student_id, int teacher_id, int year) {
        this.topic = topic;
        this.description = description;
        this.requirement = requirement;
        this.city = city;
        this.orientation = orientation;
        this.state = state;
        this.consult_first_name = consult_first_name;
        this.consult_last_name = consult_last_name;
        this.consult_email = consult_email;
        this.firm_name = firm_name;
        this.student_id = student_id;
        this.teacher_id = teacher_id;
        this.year = year;
    }
    
    public Practice(Practice p) {
        this.topic = p.topic;
        this.description = p.description;
        this.requirement = p.requirement;
        this.city = p.city;
        this.orientation = p.orientation;
        this.state = p.state;
        this.consult_first_name = p.consult_first_name;
        this.consult_last_name = p.consult_last_name;
        this.consult_email = p.consult_email;
        this.firm_name = p.firm_name;
        this.student_id = p.student_id;
        this.teacher_id = p.teacher_id;
        this.year = p.year;
    }
    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public String getRequirement() {
        return requirement;
    }

    public String getCity() {
        return city;
    }

    public String getOrientation() {
        return orientation;
    }

    public int getState() {
        return state;
    }

    public String getConsult_first_name() {
        return consult_first_name;
    }

    public String getConsult_last_name() {
        return consult_last_name;
    }

    public String getConsult_email() {
        return consult_email;
    }

    public String getFirm_name() {
        return firm_name;
    }

    public int getStudent_id() {
        return student_id;
    }

    public int getTeacher_id() {
        return teacher_id;
    }

    public int getYear() {
        return year;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void setConsult_first_name(String consult_first_name) {
        this.consult_first_name = consult_first_name;
    }

    public void setConsult_last_name(String consult_last_name) {
        this.consult_last_name = consult_last_name;
    }

    public void setConsult_email(String consult_email) {
        this.consult_email = consult_email;
    }

    public void setFirm_name(String firm_name) {
        this.firm_name = firm_name;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "Practice{" + "topic=" + topic + ", description=" + description + ", requirement=" + requirement + ", city=" + city + ", orientation=" + orientation + ", state=" + state + ", consult_first_name=" + consult_first_name + ", consult_last_name=" + consult_last_name + ", consult_email=" + consult_email + ", firm_name=" + firm_name + ", student_id=" + student_id + ", teacher_id=" + teacher_id + ", year=" + year + '}';
    }
    
    
}
