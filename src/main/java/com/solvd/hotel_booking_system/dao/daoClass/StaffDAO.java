package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IStaffDAO;
import com.solvd.hotel_booking_system.model.StaffModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class StaffDAO implements IStaffDAO {

    private static final Logger LOGGER = LogManager.getLogger(com.solvd.hotel_booking_system.dao.daoClass.StaffDAO.class);

    private IStaffDAO entityDAO;
    private Class<IStaffDAO> DAOClass = IStaffDAO.class;
    private SqlSession session;

    @Override
    public StaffModel getStaffById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getStaffById(id);
        } catch (PersistenceException e){
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public List<StaffModel> getAllStaffForHotel(Long hotels_id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getAllStaffForHotel(hotels_id);
        } catch (PersistenceException e){
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public List<StaffModel> getStaffList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getStaffList();
        } catch (PersistenceException e){
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public boolean insertStaff(StaffModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertStaff(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean deleteStaff(StaffModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteStaff(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean updateStaff(StaffModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateStaff(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return false;
    }
}
