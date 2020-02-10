package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IPositionDAO;
import com.solvd.hotel_booking_system.model.PositionModel;
import com.solvd.hotel_booking_system.util.LoggerUtil;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PositionDAO implements IPositionDAO {

    private IPositionDAO entityDAO;
    private Class<IPositionDAO> DAOClass = IPositionDAO.class;
    private SqlSession session;

    @Override
    public PositionModel getPositionById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPositionById(id);
        } catch (Exception e){
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<PositionModel> getPositionList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPositionList();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public void insertPosition(PositionModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertPosition(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePosition(PositionModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deletePosition(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void updatePosition(PositionModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updatePosition(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }
}