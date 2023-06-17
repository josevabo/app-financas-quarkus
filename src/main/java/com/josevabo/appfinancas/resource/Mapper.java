package com.josevabo.appfinancas.resource;

import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import java.util.List;
import java.util.stream.Collectors;

@ApplicationScoped
public class Mapper {
    @Inject
    ObjectMapper objectMapper;

    public <T> T map(Object obj, Class<T> returnType) {
        return objectMapper.convertValue(obj, returnType);
    }

    public <T,R> List<R> mapList(List<T> list, Class<R> returnType){
        return list.stream().map(item -> map(item, returnType)).collect(Collectors.toList());
    }
}
