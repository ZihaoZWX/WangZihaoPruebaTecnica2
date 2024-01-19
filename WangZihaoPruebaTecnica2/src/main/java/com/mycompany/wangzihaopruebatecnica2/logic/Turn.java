
package com.mycompany.wangzihaopruebatecnica2.logic;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Zihao Wang
 */
@Entity
@Table(name="turn")
public class Turn implements Serializable{
    
    @Id
    @Column(name="id")
    private String id;
    @Column(name="turnDate")
    private LocalDate turnDate;
    @Column(name="turnProcedure")
    private String turnProcedure;
    @Column(name="province")
    private String province;
    @Column(name="office")
    private String office;
    @Column(name="postalCode")
    private String postalCode;
    @Column(name="description")
    private String description;
    @Column(name="turnState")
    private String turnState;
    
    @ManyToOne
    @JoinColumn(name="userId")
    private Users users;

    public Turn() {
    }
    
    /**
     * 
     * @param id
     * @param turnDate
     * @param turnProcedure
     * @param province
     * @param office
     * @param postalCode
     * @param description
     * @param turnState
     * @param users 
     */
    public Turn(String id, LocalDate turnDate, String turnProcedure, String province, String office, String postalCode, String description, String turnState, Users users) {
        this.id = id;
        this.turnDate = turnDate;
        this.turnProcedure = turnProcedure;
        this.province = province;
        this.office = office;
        this.postalCode = postalCode;
        this.description = description;
        this.turnState = turnState;
        this.users = users;
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
     * @return Object type LocalDate turnDate
     */
    public LocalDate getTurnDate() {
        return turnDate;
    }

    /**
     * 
     * @param turnDate 
     */
    public void setTurnDate(LocalDate turnDate) {
        this.turnDate = turnDate;
    }

    /**
     * 
     * @return String turnProcedure
     */
    public String getTurnProcedure() {
        return turnProcedure;
    }

    /**
     * 
     * @param turnProcedure 
     */
    public void setTurnProcedure(String turnProcedure) {
        this.turnProcedure = turnProcedure;
    }

    /**
     * 
     * @return String province
     */
    public String getProvince() {
        return province;
    }

    /**
     * 
     * @param province 
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 
     * @return String office
     */
    public String getOffice() {
        return office;
    }

    /**
     * 
     * @param office 
     */
    public void setOffice(String office) {
        this.office = office;
    }

    /**
     * 
     * @return String postalCode
     */
    public String getPostalCode() {
        return postalCode;
    }

    /**
     * 
     * @param postalCode 
     */
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     * 
     * @return String description
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return String turnState
     */
    public String getTurnState() {
        return turnState;
    }

    /**
     * 
     * @param turnState 
     */
    public void setTurnState(String turnState) {
        this.turnState = turnState;
    }

    /**
     * 
     * @return Object type Users
     */
    public Users getUsers() {
        return users;
    }

    /**
     * 
     * @param users 
     */
    public void setUsers(Users users) {
        this.users = users;
    }
    
}
