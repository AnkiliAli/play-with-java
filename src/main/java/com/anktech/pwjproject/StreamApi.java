package com.anktech.pwjproject;

import java.util.List;
import java.lang.Integer;

class StreamApi {

    /**
     * @param data
     * @return double representing the average of the data array
     */
    public double getAverage(List<Integer> data) {
        return data.stream()
                .mapToDouble(d -> Integer.valueOf(d).doubleValue())
                .average()
                .orElse(0.0);
    }

    public List<String> cases(List<String> data, String caseType) {
        if (caseType.equals("upper"))
            return doUpperCase(data);
        if (caseType.equals("lower"))
            return doLowerCase(data);
        return data;
    }

    private List<String> doLowerCase(List<String> data) {
        return data.stream().map(String::toLowerCase).toList();
    }

    private List<String> doUpperCase(List<String> data) {
        return data.stream().map(String::toUpperCase).toList();
    }
}