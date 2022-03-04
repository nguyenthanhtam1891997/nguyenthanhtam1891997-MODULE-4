package com.example.repository;

import com.example.model.Music;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@Repository
@Transactional
public class MusicRepository implements IMusicRepository {


    @Override
    public List<Music> findAll() {
//        TypedQuery<Music> query = ConnectionUtil.entityManager.
//                createQuery("SELECT M FROM Music AS M", Music.class);
//
//
//        return query.getResultList();
        Session session = null;
        List<Music> musicList = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            musicList= session.createQuery("SELECT M FROM Music AS M", Music.class).getResultList();

        }finally {
            if (session != null){
                session.close();
            }
        }
        return musicList;
    }

    @Override
    public void save(Music music) {
        Transaction transaction = null;
        Session session = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.save(music);
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
    public Music findById(long id) {
//        TypedQuery<Music> query = ConnectionUtil.entityManager.
//                createQuery("select m from Music as m where m.id = :id",Music.class);
//
//
//        return query.getSingleResult();
        Transaction transaction = null;
        Session session = null;
        Music music = null;
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            music = session.find(Music.class, id);
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
        return music;
    }

    @Override
    public void update(Music music) {
        Transaction transaction = null;
        Session session = null;

        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();

            session.update(music);
            session.flush();
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
    public void remove(long id) {
        Transaction transaction = null;
        Session session = null;
        Music music = findById(id);
        try {
            session = ConnectionUtil.sessionFactory.openSession();
            transaction = session.beginTransaction();
            session.remove(music);
            
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
}
