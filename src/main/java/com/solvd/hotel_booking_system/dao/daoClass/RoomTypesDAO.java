package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IRoomTypesDAO;
import com.solvd.hotel_booking_system.model.RoomTypesModel;
import com.solvd.hotel_booking_system.util.LoggerUtil;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class RoomTypesDAO implements IRoomTypesDAO {

    private IRoomTypesDAO entityDAO;
    private Class<IRoomTypesDAO> DAOClass = IRoomTypesDAO.class;
    private SqlSession session;

    @Override
    public RoomTypesModel getRoomTypesById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getRoomTypesById(id);
        } catch (Exception e){
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<RoomTypesModel> getRoomTypesList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getRoomTypesList();
        } catch (Exception e){
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void insertRoomTypes(RoomTypesModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertRoomTypes(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteRoomTypes(RoomTypesModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteRoomTypes(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void updateRoomTypes(RoomTypesModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateRoomTypes(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }
}