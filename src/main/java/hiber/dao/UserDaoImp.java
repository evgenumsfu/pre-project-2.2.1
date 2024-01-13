package hiber.dao;

import hiber.model.User;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class UserDaoImp implements UserDao {

    private final SessionFactory sessionFactory;

    public UserDaoImp(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void add(User user) {
        sessionFactory.getCurrentSession().save(user);
    }

    @Override
    public List<User> listUsers() {
        TypedQuery<User> query = sessionFactory.getCurrentSession().createQuery("from User", User.class);
        return query.getResultList();
    }

    @Override
    public List<User> listGetUser(String model, int series) {
        TypedQuery<User> query = sessionFactory.getCurrentSession()
                .createQuery("From User " + "where car.model= :modelParam and car.series= :seriesParam", User.class);
        query.setParameter("modelParam", model);
        query.setParameter("seriesParam", series);
        return query.getResultList();
    }
}
