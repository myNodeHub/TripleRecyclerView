package com.example.triplerecyclerview;

import java.util.ArrayList;

public class Transport {
    private String transportName;

    private ArrayList<Motor> motorList;

    private boolean expandedTransport;

    public Transport(String transportName, ArrayList<Motor> motorList) {
        this.transportName = transportName;
        this.motorList = motorList;
    }

    public Transport() {
    }

    public void setTransportName(String transportName) {
        this.transportName = transportName;
    }

    public String getTransportName() {
        return transportName;
    }


    public void setMotorList(ArrayList<Motor> motorList) {
        this.motorList = motorList;
    }

    public ArrayList<Motor> getMotorList() {
        return motorList;
    }


    public void setExpandedTransport(boolean expandedTransport) {

        this.expandedTransport = expandedTransport;
    }

    public boolean isExpandedTransport() {
        return expandedTransport;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "transportName='" + transportName + '\'' +
                ", motor=" + motorList +
                ", expanded=" + expandedTransport +
                '}';
    }
}
