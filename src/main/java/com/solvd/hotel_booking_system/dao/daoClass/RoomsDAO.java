package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IRoomsDAO;
import com.solvd.hotel_booking_system.model.RoomsModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class RoomsDAO implements IRoomsDAO {

    private static final Logger LOGGER = LogManager.getLogger(RoomsDAO.class);

    private IRoomsDAO entityDAO;
    private Class<IRoomsDAO> DAOClass = IRoomsDAO.class;
    private SqlSession session;

    @Override
    public List<RoomsModel> getFreeRoomsForHotel(Map<String, Object> map) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getFreeRoomsForHotel(map);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public RoomsModel getRoomsById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getRoomsById(id);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public List<RoomsModel> getRoomsList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getRoomsList();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public void insertRooms(RoomsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertRooms(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void deleteRooms(RoomsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteRooms(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void updateRooms(RoomsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateRooms(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
    }
}
