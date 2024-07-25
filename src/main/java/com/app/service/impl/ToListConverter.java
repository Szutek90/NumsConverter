package com.app.service.impl;

import com.app.service.Converter;
import com.app.model.NumberWithBase;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public class ToListConverter implements Converter<String> {

    private final List<NumberWithBase> data;

    public ToListConverter(List<NumberWithBase> data) {
        this.data = data;
    }

    @Override
    public List<String> convert() {
                return data
                .stream()
                .filter(num -> !num.codingIsTheSame())
                .map(NumberWithBase::codeToTargetCode)
                .collect(Collectors.toCollection(LinkedList::new));
    }
}
