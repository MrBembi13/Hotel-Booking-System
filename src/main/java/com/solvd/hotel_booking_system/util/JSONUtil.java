package com.solvd.hotel_booking_system.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.solvd.hotel_booking_system.dao.daoClass.AddressDAO;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class JSONUtil<T> {

    private static final Logger LOGGER = LogManager.getLogger(AddressDAO.class);
    
    private ObjectMapper objectMapper = new ObjectMapper();

    public void toJson(T entity, String file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(fileOutputStream, entity);
        } catch (IOException e){
            LOGGER.error(e);
        }
    }

    public void toJson(Collection<T> entities, String file) {
        try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
            objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
            objectMapper.writeValue(fileOutputStream, entities);
        } catch (IOException e){
            LOGGER.error(e);
        }
    }

    public T fromJson(Class<T> entity, String file) {
        try (InputStream fileInputStream = new FileInputStream(file)){
            return objectMapper.readValue(fileInputStream, entity);
        }catch (IOException e){
            LOGGER.error(e);
        }
        return null;
    }

    public List<T> fromJsonFile(Class entityArrayClass, String filePath) {
        try (InputStream fileInputStream = new FileInputStream(filePath)) {
            List<T> entities = Arrays.asList((T[]) objectMapper.readValue(fileInputStream, entityArrayClass));
            fileInputStream.close();
            return entities;
        } catch (IOException e) {
            LOGGER.error(e.getMessage());
        }
        return null;
    }
}
