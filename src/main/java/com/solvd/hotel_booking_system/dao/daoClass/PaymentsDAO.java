package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IPaymentsDAO;
import com.solvd.hotel_booking_system.model.PaymentsModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PaymentsDAO implements IPaymentsDAO {

    private static final Logger LOGGER = LogManager.getLogger(PaymentsDAO.class);

    private IPaymentsDAO entityDAO;
    private Class<IPaymentsDAO> DAOClass = IPaymentsDAO.class;
    private SqlSession session;

    @Override
    public PaymentsModel getPaymentsById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentsById(id);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public List<PaymentsModel> getPaymentsList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentsList();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return null;
    }

    @Override
    public boolean insertPayments(PaymentsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertPayments(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean deletePayments(PaymentsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deletePayments(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean updatePayments(PaymentsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updatePayments(entity);
            session.commit();
            return true;
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if (session != null) session.close();
        }
        return false;
    }
}
