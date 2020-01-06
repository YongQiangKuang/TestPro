package com.kyq.test.fitpath;

public class FitPathParam {

    public String feeId;
    public String enStation;
    public String entime;
    public String exStation;
    public String extime;
    public String tollHexGroup;

    public String getFeeId() {
        return feeId;
    }

    public void setFeeId(String feeId) {
        this.feeId = feeId;
    }

    public String getEnStation() {
        return enStation;
    }

    public void setEnStation(String enStation) {
        this.enStation = enStation;
    }

    public String getEntime() {
        return entime;
    }

    public void setEntime(String entime) {
        this.entime = entime;
    }

    public String getExStation() {
        return exStation;
    }

    public void setExStation(String exStation) {
        this.exStation = exStation;
    }

    public String getExtime() {
        return extime;
    }

    public void setExtime(String extime) {
        this.extime = extime;
    }

    public String getTollHexGroup() {
        return tollHexGroup;
    }

    public void setTollHexGroup(String tollHexGroup) {
        this.tollHexGroup = tollHexGroup;
    }

    public String toString() {
        StringBuffer sb = new StringBuffer();
        return sb.append(feeId == null ? "" : feeId).append(",")
                .append(enStation == null ? "" : enStation).append(",")
                .append(entime == null ? "" : entime).append(",")
                .append(exStation == null ? "" : exStation).append(",")
                .append(extime == null ? "" : extime).append(",")
                .append(tollHexGroup == null ? "" : tollHexGroup).append(",").toString();
    }
}
