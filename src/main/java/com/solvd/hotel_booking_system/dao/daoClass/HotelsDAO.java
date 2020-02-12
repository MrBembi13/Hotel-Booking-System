package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IHotelsDAO;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.util.LoggerUtil;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class HotelsDAO implements IHotelsDAO {

    private IHotelsDAO entityDAO;
    private Class<IHotelsDAO> DAOClass = IHotelsDAO.class;
    private SqlSession session;

    @Override
    public HotelsModel getHotelsById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getHotelsById(id);
        } catch (Exception e){
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public List<HotelsModel> getHotelsList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getHotelsList();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public void insertHotels(HotelsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertHotels(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void deleteHotels(HotelsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteHotels(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void updateHotels(HotelsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateHotels(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }
}
