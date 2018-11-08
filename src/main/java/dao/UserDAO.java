package dao;

import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class UserDAO implements AbstractController<User> {

    @Autowired
    EntityManager entityManager;

    public List<User> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<User> cq = cb.createQuery(User.class);
        CriteriaQuery<User> all = cq.select(cq.from(User.class));
        TypedQuery<User> allQuery = entityManager.createQuery(all);
        List<User> users = allQuery.getResultList();
        return users;
    }

    public User getById(Long id) {
        User user = entityManager.find(User.class, id);
        return user;
    }

    public User update(User entity) {
        entityManager.getTransaction().begin();
        User merge = entityManager.merge(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return merge;
    }

    public boolean create(User entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean delete(User entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.flush();
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
