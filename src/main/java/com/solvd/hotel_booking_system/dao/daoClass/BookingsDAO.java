package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IBookingsDAO;
import com.solvd.hotel_booking_system.model.BookingsModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class BookingsDAO implements IBookingsDAO {

    private static final Logger LOGGER = LogManager.getLogger(BookingsDAO.class);

    private IBookingsDAO entityDAO;
    private Class<IBookingsDAO> DAOClass = IBookingsDAO.class;
    private SqlSession session;

    @Override
    public List<BookingsModel> findByParameters(Map<String, Object> map) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.findByParameters(map);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public BookingsModel getBookingsById(Long id) {
         try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getBookingsById(id);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
             if(session != null) session.close();
        }
        return null;
    }

    @Override
    public List<BookingsModel> getBookingsList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getBookingsList();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public boolean insertBookings(BookingsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertBookings(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean deleteBookings(BookingsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteBookings(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean updateBookings(BookingsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateBookings(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return false;
    }
}
