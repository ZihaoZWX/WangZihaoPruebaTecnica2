
package com.mycompany.wangzihaopruebatecnica2.persistence;

import com.mycompany.wangzihaopruebatecnica2.logic.Turn;
import java.io.Serializable;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import com.mycompany.wangzihaopruebatecnica2.logic.Users;
import com.mycompany.wangzihaopruebatecnica2.persistence.exceptions.NonexistentEntityException;
import com.mycompany.wangzihaopruebatecnica2.persistence.exceptions.PreexistingEntityException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Zihao Wang
 */
public class TurnJpaController implements Serializable {

    /**
     * 
     * @param emf 
     */
    public TurnJpaController(EntityManagerFactory emf) {
        this.emf = emf;
    }
    public TurnJpaController(){
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
     * @param turn
     * @throws PreexistingEntityException
     * @throws Exception 
     */
    public void create(Turn turn) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Users users = turn.getUsers();
            if (users != null) {
                users = em.merge(users);
                turn.setUsers(users);
            }
            em.persist(turn);
            if (users != null) {
                users.getTurn().add(turn);
                users = em.merge(users);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findTurn(turn.getId()) != null) {
                throw new PreexistingEntityException("Turn " + turn + " already exists.", ex);
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
     * @param turn
     * @throws NonexistentEntityException
     * @throws Exception 
     */
    public void edit(Turn turn) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Turn persistentTurn = em.find(Turn.class, turn.getId());
            Users usersOld = persistentTurn.getUsers();
            Users usersNew = turn.getUsers();
            if (usersNew != null) {
                usersNew = em.merge(usersNew);
                turn.setUsers(usersNew);
            }
            turn = em.merge(turn);
            if (usersOld != null && !usersOld.equals(usersNew)) {
                usersOld.getTurn().remove(turn);
                usersOld = em.merge(usersOld);
            }
            if (usersNew != null && !usersNew.equals(usersOld)) {
                usersNew.getTurn().add(turn);
                usersNew = em.merge(usersNew);
            }
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                String id = turn.getId();
                if (findTurn(id) == null) {
                    throw new NonexistentEntityException("The turn with id " + id + " no longer exists.");
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
            Turn turn;
            try {
                turn = em.getReference(Turn.class, id);
                turn.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The turn with id " + id + " no longer exists.", enfe);
            }
            Users users = turn.getUsers();
            if (users != null) {
                users.getTurn().remove(turn);
                users = em.merge(users);
            }
            em.remove(turn);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    /**
     * 
     * @return List of Objects Turn
     */
    public List<Turn> findTurnEntities() {
        return findTurnEntities(true, -1, -1);
    }

    /**
     * 
     * @param maxResults
     * @param firstResult
     * @return List of Turn
     */
    public List<Turn> findTurnEntities(int maxResults, int firstResult) {
        return findTurnEntities(false, maxResults, firstResult);
    }

    /**
     * 
     * @param all
     * @param maxResults
     * @param firstResult
     * @return List of Turn
     */
    private List<Turn> findTurnEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            cq.select(cq.from(Turn.class));
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
     * @return Object type Turn
     */
    public Turn findTurn(String id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Turn.class, id);
        } finally {
            em.close();
        }
    }

    /**
     * 
     * @return int
     */
    public int getTurnCount() {
        EntityManager em = getEntityManager();
        try {
            CriteriaQuery cq = em.getCriteriaBuilder().createQuery();
            Root<Turn> rt = cq.from(Turn.class);
            cq.select(em.getCriteriaBuilder().count(rt));
            Query q = em.createQuery(cq);
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }

}
