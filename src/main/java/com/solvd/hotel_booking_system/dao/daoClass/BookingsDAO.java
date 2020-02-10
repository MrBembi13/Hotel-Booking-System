package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IBookingsDAO;
import com.solvd.hotel_booking_system.model.BookingsModel;
import com.solvd.hotel_booking_system.util.LoggerUtil;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class BookingsDAO implements IBookingsDAO {

    private IBookingsDAO entityDAO;
    private Class<IBookingsDAO> DAOClass = IBookingsDAO.class;
    private SqlSession session;

    @Override
    public BookingsModel getBookingsById(Long id) {
         try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getBookingsById(id);
        } catch (Exception e){
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
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
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
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
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
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
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
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
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }
}
