package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IHotelsDAO;
import com.solvd.hotel_booking_system.model.HotelsModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;
import java.util.Map;

public class HotelsDAO implements IHotelsDAO {

    private static final Logger LOGGER = LogManager.getLogger(HotelsDAO.class);

    private IHotelsDAO entityDAO;
    private Class<IHotelsDAO> DAOClass = IHotelsDAO.class;
    private SqlSession session;

    @Override
    public List<HotelsModel> findByParameters(Map<String, Object> map) {
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
    public HotelsModel getHotelsById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getHotelsById(id);
        } catch (Exception e){
            LOGGER.error(e);
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
            LOGGER.error(e);
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
            LOGGER.error(e);
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
            LOGGER.error(e);
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
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }
}
