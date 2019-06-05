package com.example.triplerecyclerview;

import java.util.ArrayList;

public class Motor {

    private String motorName;
    private String horsePower;
    private String volume;

    private ArrayList<Detail> detailList;

    private boolean expandedMotor;

    public Motor(String motorName, String horsePower, String volume, ArrayList<Detail> detailList) {
        this.motorName = motorName;
        this.horsePower = horsePower;
        this.volume = volume;
        this.detailList = detailList;
    }

    public Motor() {
    }


    public void setMotorName(String motorName) {
        this.motorName = motorName;
    }
    public String getMotorName() {
        return motorName;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }
    public String getHorsePower() {
        return horsePower;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }
    public String getVolume() {
        return volume;
    }

    public void setdetailList(ArrayList<Detail> detail) {
        this.detailList = detailList;
    }
    public ArrayList<Detail> getdetailList() {
        return detailList;
    }

    public void setExpandedMotor(boolean expandedMotor) {
        this.expandedMotor = expandedMotor;
    }

    public boolean isExpandedMotor() {
        return expandedMotor;
    }

    @Override
    public String toString() {
        return "Motor{" +
                "motorName='" + motorName + '\'' +
                ", horsePower='" + horsePower + '\'' +
                ", volume='" + volume + '\'' +
                ", detail=" + detailList +
                ", expandedMotor=" + expandedMotor +
                '}';
    }
}
