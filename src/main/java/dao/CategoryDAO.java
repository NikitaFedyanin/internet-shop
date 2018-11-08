package dao;

import entity.Category;
import entity.Product;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class CategoryDAO implements AbstractController<Category> {

    @Autowired
    private EntityManager entityManager;

    public List<Category> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Category> cq = cb.createQuery(Category.class);
        CriteriaQuery<Category> all = cq.select(cq.from(Category.class));
        TypedQuery<Category> allQuery = entityManager.createQuery(all);
        List<Category> categories = allQuery.getResultList();
        return categories;
    }

    public Category getById(Long id) {
        return entityManager.find(Category.class, id);
    }

    public Category update(Category entity) {
        entityManager.getTransaction().begin();
        Category merge = entityManager.merge(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return merge;
    }

    public boolean create(Category entity) {
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

    public boolean delete(Category entity) {
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
