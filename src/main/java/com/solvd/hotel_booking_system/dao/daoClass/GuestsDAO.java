package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IGuestsDAO;
import com.solvd.hotel_booking_system.model.GuestsModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class GuestsDAO implements IGuestsDAO {

    private static final Logger LOGGER = LogManager.getLogger(GuestsDAO.class);

    private IGuestsDAO entityDAO;
    private Class<IGuestsDAO> DAOClass = IGuestsDAO.class;
    private SqlSession session;

    @Override
    public GuestsModel getGuestsByPhone(String phone) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getGuestsByPhone(phone);
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public GuestsModel getGuestsById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getGuestsById(id);
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public List<GuestsModel> getGuestsList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getGuestsList();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public void insertGuests(GuestsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertGuests(entity);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteGuests(GuestsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteGuests(entity);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateGuests(GuestsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateGuests(entity);
            session.commit();
        } catch (SqlSessionException e) {
            LOGGER.error(e.getMessage());
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if (session != null) session.close();
        }
    }
}
