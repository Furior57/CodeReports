package com.parser.service.pojo;


import java.util.List;

public class DataMatrixObject {

    public List<DataMatrix> dataMatrixs;

    public List<AggregationObject> aggregations;

    public DataMatrixObject() {

    }

    public DataMatrixObject(List<DataMatrix> dataMatrixs, List<AggregationObject> aggregations) {
        this.dataMatrixs = dataMatrixs;
        this.aggregations = aggregations;
    }

    public List<DataMatrix> getDataMatrixs() {
        return dataMatrixs;
    }

    public void setDataMatrixs(List<DataMatrix> dataMatrixs) {
        this.dataMatrixs = dataMatrixs;
    }

    public List<AggregationObject> getAggregations() {
        return aggregations;
    }

    public void setAggregations(List<AggregationObject> aggregations) {
        this.aggregations = aggregations;
    }

    @Override
    public String toString() {
        return "datamatrixList{" +
                "dataMatrixList=" + dataMatrixs +
                '}';
    }
}
