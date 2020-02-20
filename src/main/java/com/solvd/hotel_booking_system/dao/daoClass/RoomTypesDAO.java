package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IRoomTypesDAO;
import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class RoomTypesDAO implements IRoomTypesDAO {

    private static final Logger LOGGER = LogManager.getLogger(RoomTypesDAO.class);

    private IRoomTypesDAO entityDAO;
    private Class<IRoomTypesDAO> DAOClass = IRoomTypesDAO.class;
    private SqlSession session;

    @Override
    public RoomTypesModel getRoomTypesById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getRoomTypesById(id);
        } catch (PersistenceException e){
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public List<RoomTypesModel> getRoomTypesList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getRoomTypesList();
        } catch (PersistenceException e){
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public boolean insertRoomTypes(RoomTypesModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertRoomTypes(entity);
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
    public boolean deleteRoomTypes(RoomTypesModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteRoomTypes(entity);
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
    public boolean updateRoomTypes(RoomTypesModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateRoomTypes(entity);
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
