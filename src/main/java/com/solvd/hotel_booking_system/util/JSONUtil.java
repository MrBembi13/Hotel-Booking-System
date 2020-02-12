package com.solvd.hotel_booking_system.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

public class JSONUtil<T> {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void toJson(T entity, String file) throws IOException {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        objectMapper.writeValue(fileOutputStream, entity);
        fileOutputStream.close();
    }

    public void toJson(Collection<T> entities, String file) throws IOException {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        FileOutputStream fileOutputStream = new FileOutputStream(file);
        objectMapper.writeValue(fileOutputStream, entities);
        fileOutputStream.close();
    }

    public void fromJson(Class<T> entity, String file) throws IOException {
        InputStream fileInputStream = new FileInputStream(file);
        objectMapper.readValue(fileInputStream, entity);
    }
}
