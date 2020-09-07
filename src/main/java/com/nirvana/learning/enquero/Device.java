package com.nirvana.learning.enquero;

import java.util.Objects;

public class Device {
    private String serialNumber;
    private String productId;

    public Device(String serialNumber, String productId) {
        this.serialNumber = serialNumber;
        this.productId = productId;
    }

    public Device() {
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Device device = (Device) o;
        return Objects.equals(getSerialNumber(), device.getSerialNumber()) &&
                Objects.equals(getProductId(), device.getProductId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSerialNumber(), getProductId());
    }

    @Override
    public String toString() {
        return "Device{" +
                "serialNumber='" + serialNumber + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }
}
