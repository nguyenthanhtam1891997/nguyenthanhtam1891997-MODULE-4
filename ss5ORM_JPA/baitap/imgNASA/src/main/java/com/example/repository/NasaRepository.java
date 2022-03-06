package com.example.repository;

import com.example.model.NaSaImg;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class NasaRepository implements INasaImgRepository {
    @Override
    public List<NaSaImg> findAll() {
        Session session = null;
        List<NaSaImg> naSaImgList = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            naSaImgList = session.createQuery("select I from NaSaImg as I", NaSaImg.class).getResultList();
        } finally {
            if (session != null) {
                session.close();
            }
        }


        return naSaImgList;
    }

    @Override
    public void save(NaSaImg naSaImg) {
        Session session = null;
        Transaction transaction = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(naSaImg);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    @Override
    public NaSaImg findById(Long id) {

        Transaction transaction = null;
        Session session = null;
        NaSaImg naSaImg = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            naSaImg = session.find(NaSaImg.class, id);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session != null) {
                session.close();
            }
        }
        return naSaImg;
    }

    @Override
    public void update(NaSaImg naSaImg) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.update(naSaImg);
            session.flush();
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
        }finally {
            if (session != null){
                session.close();
            }
        }
    }

}
