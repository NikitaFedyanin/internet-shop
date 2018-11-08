package dao;

import entity.Category;
import entity.Order;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class OrderDAO implements AbstractController<Order> {

    @Autowired
    EntityManager entityManager;

    public List<Order> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Order> cq = cb.createQuery(Order.class);
        CriteriaQuery<Order> all = cq.select(cq.from(Order.class));
        TypedQuery<Order> allQuery = entityManager.createQuery(all);
        List<Order> orders= allQuery.getResultList();
        return orders;
    }

    public Order getById(Long id) {
        return entityManager.find(Order.class, id);
    }

    public Order update(Order entity) {
        entityManager.getTransaction().begin();
        Order merge = entityManager.merge(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return merge;
    }

    public boolean create(Order entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(entity);
            entityManager.flush();
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean delete(Order entity) {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(entity);
            entityManager.flush();
            entityManager.getTransaction().commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
