package dao;

import entity.Status;
import entity.User;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class StatusDAO implements AbstractController<Status> {

    @Autowired
    EntityManager entityManager;

    public List<Status> getAll() {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Status> cq = cb.createQuery(Status.class);
        CriteriaQuery<Status> all = cq.select(cq.from(Status.class));
        TypedQuery<Status> allQuery = entityManager.createQuery(all);
        List<Status> statuses= allQuery.getResultList();
        return statuses;
    }

    public Status getById(Long id) {
        return entityManager.find(Status.class, id);
    }

    public Status update(Status entity) {
       entityManager.getTransaction().begin();
        Status merge = entityManager.merge(entity);
        entityManager.flush();
        entityManager.getTransaction().commit();
        return merge;
    }

    public boolean create(Status entity) {
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

    public boolean delete(Status entity) {
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
