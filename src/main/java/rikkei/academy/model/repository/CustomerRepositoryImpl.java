package rikkei.academy.model.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import rikkei.academy.model.entity.Customer;

import java.util.ArrayList;
import java.util.List;
@Repository
public class CustomerRepositoryImpl implements CustomerRepository{
    @Autowired
    SessionFactory sessionFactory;
    @Override
    public List<Customer> findAll() {

        List<Customer> list = new ArrayList<>();
        // khoi tao doi tuong sesssion
        Session session = sessionFactory.openSession();
        try {
            list = session.createQuery("from Customer ").list();
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            session.close();
        }
        return list;
    }

    @Override
    public Boolean saveOrUpdate(Customer customer) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                session.save(customer);
                transaction.commit();
                return true;
            } catch (HibernateException e) {
                e.printStackTrace();
                transaction.rollback();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(Integer id) {

    }
}
