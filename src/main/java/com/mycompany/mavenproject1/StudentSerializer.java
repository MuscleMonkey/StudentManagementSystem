/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import java.io.IOException;
import java.io.StringWriter;

/**
 *
 * @author rcurzon
 */
public class StudentSerializer extends JsonSerializer<Student> {

    ObjectMapper mapper = new ObjectMapper();

    @Override
    public void serialize(Student t, JsonGenerator jg, SerializerProvider sp) throws IOException {
        StringWriter writer = new StringWriter();
        mapper.writeValue(writer, t);
        jg.writeFieldName(writer.toString());
    }

}
