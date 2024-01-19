
package com.mycompany.wangzihaopruebatecnica2.logic;

import com.mycompany.wangzihaopruebatecnica2.persistence.PersistenceController;
import java.util.ArrayList;

/**
 *
 * @author Zihao Wang
 */
public class Controller {
    PersistenceController persistenceController=new PersistenceController();
    
    /**
     * Create user
     * @param user
     */
    public void createUser(Users user){
        persistenceController.createUsers(user);
    }
    
    /**
     * Create turn
     * @param turn 
     */
    public void createTurn(Turn turn){
        persistenceController.createTurn(turn);
    }
    /**
     * Delete turn
     * @param id 
     */
    public void deleteTurn(String id){
        persistenceController.deleteTurn(id);
    }
    /**
     * Delete user
     * @param id 
     */
    public void deleteUser(String id){
        persistenceController.deleteUsers(id);
    }
    /**
     * Edit user
     * @param user 
     */
    public void editUser(Users user){
        persistenceController.editUsers(user);
    }
    /**
     * Edit turn
     * @param turn 
     */
    public void editTurn(Turn turn){
        persistenceController.editTurn(turn);
    }
    /**
     * Find user by id
     * @param id
     * @return Object type Users
     */
    public Users findUser(String id){
        return persistenceController.findUser(id);
    }
    /**
     * Find turn by id
     * @param id
     * @return Object type Turn
     */
    public Turn findTurn(String id){
        return persistenceController.findTurn(id);
    }
    /**
     * Find all users
     * @return List of Objects Users
     */
    public ArrayList<Users> findAllUser(){
        return persistenceController.findAllUsers();
    }
    /**
     * Find all turns
     * @return List of Objects Turn
     */
    public ArrayList<Turn> findAllTurns(){
        return persistenceController.findAllTurns();
    }
    
}
