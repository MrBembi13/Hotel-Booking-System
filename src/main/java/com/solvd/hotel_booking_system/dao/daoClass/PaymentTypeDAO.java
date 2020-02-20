package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.IPaymentTypeDAO;
import com.solvd.hotel_booking_system.model.PaymentTypeModel;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
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
        } catch (Exception e){
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
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
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public boolean insertPaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.insertPaymentType(entity);
            session.commit();
            return true;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean deletePaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.deletePaymentType(entity);
            session.commit();
            return true;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return false;
    }

    @Override
    public boolean updatePaymentType(PaymentTypeModel entity) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            entityDAO.updatePaymentType(entity);
            session.commit();
            return true;
        } catch (Exception e) {
            LOGGER.error(e);
        } finally {
            if(session != null) session.close();
        }
        return false;
    }
}
