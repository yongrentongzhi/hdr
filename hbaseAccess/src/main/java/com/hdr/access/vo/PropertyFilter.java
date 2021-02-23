package com.hdr.access.vo;

public class PropertyFilter {

    private String propertyName;
    private String propertyType;
    private Object propertyValue;
    private String matchType;


    public PropertyFilter(String propertyName, String propertyType, Object propertyValue, String matchType) {
        this.propertyName = propertyName;
        this.propertyType = propertyType;
        this.propertyValue = propertyValue;
        this.matchType = matchType;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public String getPropertyType() {
        return propertyType;
    }

    public void setPropertyType(String propertyType) {
        this.propertyType = propertyType;
    }

    public Object getPropertyValue() {
        return propertyValue;
    }

    public void setPropertyValue(Object propertyValue) {
        this.propertyValue = propertyValue;
    }

    public String getMatchType() {
        return matchType;
    }

    public void setMatchType(String matchType) {
        this.matchType = matchType;
    }
}


