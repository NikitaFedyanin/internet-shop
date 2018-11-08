package dao;

import entity.Order;
import entity.Product;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class ProductDAO implements AbstractController<Product> {

    @Autowired
    EntityManager entityManager;

    public List<Product> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Product> cq = cb.createQuery(Product.class);
        CriteriaQuery<Product> all = cq.select(cq.from(Product.class));
        TypedQuery<Product> allQuery = entityManager.createQuery(all);
        List<Product> products= allQuery.getResultList();
        return products;
    }

    public Product getById(Long id) {
        return entityManager.find(Product.class, id);
    }

    public Product update(Product entity) {
        entityManager.getTransaction().begin();
        Product merge = entityManager.merge(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return merge;
    }

    public boolean create(Product entity) {
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

    public boolean delete(Product entity) {
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
