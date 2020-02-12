package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IPaymentsDAO;
import com.solvd.hotel_booking_system.model.PaymentsModel;
import com.solvd.hotel_booking_system.util.LoggerUtil;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PaymentsDAO implements IPaymentsDAO {

    private IPaymentsDAO entityDAO;
    private Class<IPaymentsDAO> DAOClass = IPaymentsDAO.class;
    private SqlSession session;

    @Override
    public PaymentsModel getPaymentsById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentsById(id);
        } catch (Exception e){
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public List<PaymentsModel> getPaymentsList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentsList();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public void insertPayments(PaymentsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertPayments(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void deletePayments(PaymentsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deletePayments(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }

    @Override
    public void updatePayments(PaymentsModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updatePayments(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
    }
}
