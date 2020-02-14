package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IBookingsDAO;
import com.solvd.hotel_booking_system.model.BookingsModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
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
        } catch (Exception e) {
            LOGGER.error(e);
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
        } catch (Exception e){
            LOGGER.error(e);
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
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public void insertBookings(BookingsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertBookings(entity);
            session.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void deleteBookings(BookingsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteBookings(entity);
            session.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void updateBookings(BookingsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateBookings(entity);
            session.commit();
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }
}
