
package com.mycompany.wangzihaopruebatecnica2.persistence;

import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import com.mycompany.wangzihaopruebatecnica2.logic.Users;
import com.mycompany.wangzihaopruebatecnica2.persistence.exceptions.NonexistentEntityException;
import com.mycompany.wangzihaopruebatecnica2.persistence.exceptions.PreexistingEntityException;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zihao Wang
 */
public class UsersJpaController implements Serializable {

    /**
     * 
     * @param emf 
     */
    public UsersJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public UsersJpaController(){
        emf=Persistence.createEntityManagerFactory("turnerPersistence");
    }
    private EntityManagerFactory emf = null;

    /**
     * 
     * @return Object type EntityManager
     */
    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    /**
     * 
     * @param users
     * @throws PreexistingEntityException
     * @throws Exception 
     */
    public void create(Users users) throws PreexistingEntityException, Exception {
        if (users.getTurn() == null) {
            users.setTurn(new ArrayList<Turn>());
        }
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            List<Turn> attachedTurn = new ArrayList<Turn>();
            for (Turn turnTurnToAttach : users.getTurn()) {
                turnTurnToAttach = em.getReference(turnTurnToAttach.getClass(), turnTurnToAttach.getId());
                attachedTurn.add(turnTurnToAttach);
            }
            users.setTurn(attachedTurn);
            em.persist(users);
            for (Turn turnTurn : users.getTurn()) {
                Users oldUsersOfTurnTurn = turnTurn.getUsers();
                turnTurn.setUsers(users);
                turnTurn = em.merge(turnTurn);
                if (oldUsersOfTurnTurn != null) {
                    oldUsersOfTurnTurn.getTurn().remove(turnTurn);
                    oldUsersOfTurnTurn = em.merge(oldUsersOfTurnTurn);
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findUsers(users.getId()) != null) {
                throw new PreexistingEntityException("Users " + users + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * 
     * @param users
     * @throws NonexistentEntityException
     * @throws Exception 
     */
    public void edit(Users users) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users persistentUsers = em.find(Users.class, users.getId());
            List<Turn> turnOld = persistentUsers.getTurn();
            List<Turn> turnNew = users.getTurn();
            List<Turn> attachedTurnNew = new ArrayList<Turn>();
            for (Turn turnNewTurnToAttach : turnNew) {
                turnNewTurnToAttach = em.getReference(turnNewTurnToAttach.getClass(), turnNewTurnToAttach.getId());
                attachedTurnNew.add(turnNewTurnToAttach);
            }
            turnNew = attachedTurnNew;
            users.setTurn(turnNew);
            users = em.merge(users);
            for (Turn turnOldTurn : turnOld) {
                if (!turnNew.contains(turnOldTurn)) {
                    turnOldTurn.setUsers(null);
                    turnOldTurn = em.merge(turnOldTurn);
                }
            }
            for (Turn turnNewTurn : turnNew) {
                if (!turnOld.contains(turnNewTurn)) {
                    Users oldUsersOfTurnNewTurn = turnNewTurn.getUsers();
                    turnNewTurn.setUsers(users);
                    turnNewTurn = em.merge(turnNewTurn);
                    if (oldUsersOfTurnNewTurn != null && !oldUsersOfTurnNewTurn.equals(users)) {
                        oldUsersOfTurnNewTurn.getTurn().remove(turnNewTurn);
                        oldUsersOfTurnNewTurn = em.merge(oldUsersOfTurnNewTurn);
                    }
                }
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = users.getId();
                if (findUsers(id) == null) {
                    throw new NonexistentEntityException("The users with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * 
     * @param id
     * @throws NonexistentEntityException 
     */
    public void destroy(String id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users users;
            try {
                users = em.getReference(Users.class, id);
                users.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The users with id " + id + " no longer exists.", enfe);
            }
            List<Turn> turn = users.getTurn();
            for (Turn turnTurn : turn) {
                turnTurn.setUsers(null);
                turnTurn = em.merge(turnTurn);
            }
            em.remove(users);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * 
     * @return List of Users
     */
    public List<Users> findUsersEntities() {
        return findUsersEntities(true, -1, -1);
    }

    /**
     * 
     * @param maxResults
     * @param firstResult
     * @return List of Users
     */
    public List<Users> findUsersEntities(int maxResults, int firstResult) {
        return findUsersEntities(false, maxResults, firstResult);
    }

    /**
     * 
     * @param all
     * @param maxResults
     * @param firstResult
     * @return List of Users
     */
    private List<Users> findUsersEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Users.class));
            Query q = em.createQuery(cq);
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @param id
     * @return Users
     */
    public Users findUsers(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Users.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @return int
     */
    public int getUsersCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Users> rt = cq.from(Users.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
