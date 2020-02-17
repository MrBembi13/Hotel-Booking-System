package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IPaymentTypeDAO;
import com.solvd.hotel_booking_system.model.PaymentTypeModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PaymentTypeDAO implements IPaymentTypeDAO {

    private static final Logger LOGGER = LogManager.getLogger(PaymentTypeDAO.class);

    private IPaymentTypeDAO entityDAO;
    private Class<IPaymentTypeDAO> DAOClass = IPaymentTypeDAO.class;
    private SqlSession session;

    @Override
    public PaymentTypeModel getPaymentTypeById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentTypeById(id);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public List<PaymentTypeModel> getPaymentTypeList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentTypeList();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public void insertPaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertPaymentType(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void deletePaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deletePaymentType(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }

    @Override
    public void updatePaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updatePaymentType(entity);
            session.commit();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
    }
}
