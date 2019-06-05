package com.example.triplerecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Detail implements Parcelable {

    private String detailName;
    private int detailCost;
    private String detailBarcode;
    private String detailAvailability;


    public Detail(String detailName, int detailCost, String detailBarcode, String detailAvailability) {
        this.detailName = detailName;
        this.detailCost = detailCost;
        this.detailBarcode = detailBarcode;
        this.detailAvailability = detailAvailability;
    }

    public String getDetailName() {
        return detailName;
    }

    public void setDetailName(String detailName) {
        this.detailName = detailName;
    }

    public int getDetailCost() {
        return detailCost;
    }

    public void setDetailCost(int detailCost) {
        this.detailCost = detailCost;
    }

    public String getDetailBarcode() {
        return detailBarcode;
    }

    public void setDetailBarcode(String detailBarcode) {
        this.detailBarcode = detailBarcode;
    }

    public String getDetailAvailability() {
        return detailAvailability;
    }

    public void setDetailAvailability(String detailAvailability) {
        this.detailAvailability = detailAvailability;
    }

    @Override
    public String toString() {
        return "Detail{" +
                "detailName='" + detailName + '\'' +
                ", detailCost=" + detailCost +
                ", detailBarcode='" + detailBarcode + '\'' +
                ", detailAvailability='" + detailAvailability + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(detailName);
        dest.writeInt(detailCost);
        dest.writeString(detailBarcode);
        dest.writeString(detailAvailability);
    }

    public static final Creator<Detail> CREATOR = new Creator<Detail>() {
        @Override
        public Detail createFromParcel(Parcel source) {
            return new Detail(source.readString(), source.readInt(), source.readString(),
                    source.readString());
        }

        @Override
        public Detail[] newArray(int size) {
            return new Detail[size];
        }
    };

}
