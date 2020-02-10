package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IPaymentTypeDAO;
import com.solvd.hotel_booking_system.model.PaymentTypeModel;
import com.solvd.hotel_booking_system.util.LoggerUtil;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class PaymentTypeDAO implements IPaymentTypeDAO {

    private IPaymentTypeDAO entityDAO;
    private Class<IPaymentTypeDAO> DAOClass = IPaymentTypeDAO.class;
    private SqlSession session;

    @Override
    public PaymentTypeModel getPaymentTypeById(Long id) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentTypeById(id);
        } catch (Exception e){
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public List<PaymentTypeModel> getPaymentTypeList() {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getPaymentTypeList();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
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
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void deletePaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deletePaymentType(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }

    @Override
    public void updatePaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updatePaymentType(entity);
            session.commit();
        } catch (Exception e) {
            LoggerUtil.LOGGER.error(e);
        } finally {
            session.close();
        }
    }
}