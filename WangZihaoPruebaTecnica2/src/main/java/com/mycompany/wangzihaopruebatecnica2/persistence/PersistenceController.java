
package com.mycompany.wangzihaopruebatecnica2.persistence;

import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import com.mycompany.wangzihaopruebatecnica2.logic.Users;
import com.mycompany.wangzihaopruebatecnica2.persistence.exceptions.NonexistentEntityException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Zihao Wang
 */
public class PersistenceController {
    TurnJpaController turnJpaController=new TurnJpaController();
    UsersJpaController userJpaController=new UsersJpaController();
    
    /**
     * 
     * @param turn 
     */
    public void createTurn(Turn turn){
        try {
            turnJpaController.create(turn);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    /**
     * 
     * @param users 
     */
    public void createUsers(Users users){
        try {
            userJpaController.create(users);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param turn 
     */
    public void editTurn(Turn turn){
        try {
            turnJpaController.edit(turn);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param users 
     */
    public void editUsers(Users users){
        try {
            userJpaController.edit(users);
        } catch (Exception ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param id 
     */
    public void deleteTurn(String id){
        try {
            turnJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param id 
     */
    public void deleteUsers(String id){
        try {
            userJpaController.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(PersistenceController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @return List of Users
     */
    public ArrayList<Users> findAllUsers(){
        ArrayList<Users> usersList=new ArrayList<>(userJpaController.findUsersEntities());
        return usersList;
    }
    
    /**
     * 
     * @return List of Turns
     */
    public ArrayList<Turn> findAllTurns(){
        ArrayList<Turn> turnList=new ArrayList<>(turnJpaController.findTurnEntities());
        return turnList;
    }
    
    /**
     * 
     * @param id
     * @return Object type Users
     */
    public Users findUser(String id){
        return userJpaController.findUsers(id);
    }
    
    /**
     * 
     * @param id
     * @return Object type Turn
     */
    public Turn findTurn(String id){
        return turnJpaController.findTurn(id);
    }
    
}
