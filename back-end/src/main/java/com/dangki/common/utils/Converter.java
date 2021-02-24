package com.dangki.common.utils;

import org.modelmapper.ModelMapper;

import java.util.ArrayList;
import java.util.List;

public class Converter<K,V> {
    private final Class<K> kClass;
    private final Class<V> vClass;
    private final ModelMapper modelMapper = new ModelMapper();
    public Converter(Class<K> kClass, Class<V> vClass) {
        this.kClass = kClass;
        this.vClass = vClass;
    }
    public K toDto(V value)
    {
        return modelMapper.map(value, kClass);
    }
    public V toEntity(K key)
    {
        return modelMapper.map(key,vClass);
    }
    public List<K> toDto(List<V> entities)
    {
        List<K> list = new ArrayList<>();
        if (entities == null || entities.isEmpty())
            return null;
        for (V entity : entities) {
            list.add(toDto(entity));
        }
        return list;
    }
    public List<V> toEntity(List<K> dtos)
    {
        List<V> list = new ArrayList<>();
        if (dtos == null || dtos.isEmpty())
            return null;
        for (K dto : dtos) {
            list.add(toEntity(dto));
        }
        return list;
    }
}
