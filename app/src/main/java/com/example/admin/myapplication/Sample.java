package com.example.admin.myapplication;

public class Sample {
    private int imageId;          //imageId：图片ID
    private String serialNumber;  //serialNumber序号
    private String CFU;           //CFU：菌落数
    private String date;          //date：日期

    public Sample(int imageId, String serialNumber, String CFU, String date) {
        this.imageId = imageId;
        this.serialNumber = serialNumber;
        this.CFU = CFU;
        this.date = date;
    }

    public int getImageId() {
        return imageId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public String getCFU() {
        return CFU;
    }

    public String getDate() {
        return date;
    }
}
