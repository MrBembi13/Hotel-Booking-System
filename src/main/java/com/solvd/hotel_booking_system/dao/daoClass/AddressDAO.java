package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IAddressDAO;
import com.solvd.hotel_booking_system.model.AddressModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class AddressDAO implements IAddressDAO {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    private IAddressDAO entityDAO;
    private Class<IAddressDAO> DAOClass = IAddressDAO.class;
    private SqlSession session;

    @Override
    public AddressModel getAddressById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getAddressById(id);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public List<AddressModel> getAddressList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getAddressList();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public void insertAddress(AddressModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertAddress(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deleteAddress(AddressModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deleteAddress(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updateAddress(AddressModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updateAddress(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }
}
