package com.solvd.hotel_booking_system.util;

import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;
import java.io.Reader;

public class MyBatisConfigUtil {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);

    private static final String CONFIG_FILE_NAME = "mybatis-config.xml";
    private static SqlSessionFactory sqlSessionFactory = null;

    public static SqlSessionFactory getSqlSessionFactory() {
        try {
            Reader reader = Resources.getResourceAsReader(CONFIG_FILE_NAME);
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            LOGGER.error(e.getStackTrace());
        }
        return sqlSessionFactory;
    }
}
