package com.solvd.hotel_booking_system.dao.daoClass;

import com.solvd.hotel_booking_system.dao.ISystemInformationDAO;
import com.solvd.hotel_booking_system.util.MyBatisConfigUtil;
import org.apache.ibatis.exceptions.PersistenceException;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Date;

public class SystemInformationDAO implements ISystemInformationDAO {

    private static final Logger LOGGER = LogManager.getLogger(SystemInformationDAO.class);

    private ISystemInformationDAO entityDAO;
    private Class<ISystemInformationDAO> DAOClass = ISystemInformationDAO.class;
    private SqlSession session;

    @Override
    public Date getCurrentDate() {

        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getCurrentDate();
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return null;
    }

    @Override
    public Long getActualInsertId(String tableName) {
        try {
            session = MyBatisConfigUtil.getSqlSessionFactory().openSession();
            entityDAO = session.getMapper(DAOClass);
            return entityDAO.getActualInsertId(tableName);
        } catch (PersistenceException e) {
            LOGGER.error(e.getMessage());
        } finally {
            if(session != null) session.close();
        }
        return null;
    }
}
