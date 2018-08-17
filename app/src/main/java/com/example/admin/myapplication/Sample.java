package com.example.admin.myapplication;

public class Sample {
    private int imageId;
    private String serialNumber;
    private String CFU;
    private String date;

    public Sample(int imageId,String serialNumber,String  CFU,String date){
        this.imageId=imageId;
        this.serialNumber=serialNumber;
        this.CFU=CFU;
        this.date=date;
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
