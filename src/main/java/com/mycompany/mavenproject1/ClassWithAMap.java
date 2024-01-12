package com.mycompany.mavenproject1;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import java.util.HashMap;
import java.util.Map;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author rcurzon
 */
public class ClassWithAMap {

    @JsonProperty("map")
    @JsonDeserialize(keyUsing = StudentDeserializer.class)
    private HashMap<Integer, Student> map;

    @JsonCreator
    public ClassWithAMap(HashMap<Integer, Student> map) {
        this.map = map;
    }

}
