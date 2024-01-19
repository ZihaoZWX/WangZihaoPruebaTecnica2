
package com.mycompany.wangzihaopruebatecnica2.logic;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Zihao Wang
 */

@Entity
@Table(name="users")
public class Users implements Serializable {
    
    @Id
    @Column(name="id")
    private String id;
    @Column(name="name")
    private String name;
    @Column(name="lastName")
    private String surname;
    @Column (name="phoneNumber")
    private String phoneNumber;
    @Column (name="gmail")
    private String gmail;
    
    @OneToMany(mappedBy="users")
    private List<Turn> turn;

    public Users() {
    }

    /**
     * 
     * @param id
     * @param name
     * @param surname
     * @param phoneNumber
     * @param gmail
     * @param turn 
     */
    public Users(String id, String name, String surname, String phoneNumber, String gmail, List<Turn> turn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.phoneNumber = phoneNumber;
        this.gmail = gmail;
        this.turn = turn;
    }

    /**
     * 
     * @return String id
     */
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return String name
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return String surname
     */
    public String getSurname() {
        return surname;
    }

    /**
     * 
     * @param surname 
     */
    public void setSurname(String surname) {
        this.surname = surname;
    }

    /**
     * 
     * @return String phoneNumber
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 
     * @return String gmail
     */
    public String getGmail() {
        return gmail;
    }

    /**
     * 
     * @param gmail 
     */
    public void setGmail(String gmail) {
        this.gmail = gmail;
    }

    /**
     * 
     * @return List of Turns
     */
    public List<Turn> getTurn() {
        return turn;
    }

    /**
     * 
     * @param turn 
     */
    public void setTurn(List<Turn> turn) {
        this.turn = turn;
    }
    
}
