/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.KeyDeserializer;
import java.io.IOException;
import java.util.HashMap;


/**
 *
 * @author rcurzon
 */
public class StudentDeserializer extends KeyDeserializer {

    @Override
    public Student deserializeKey(String key, DeserializationContext dc) throws IOException, JsonProcessingException {
        return new Student(key);
    } 
}
