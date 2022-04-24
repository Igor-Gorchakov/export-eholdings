package com.techprimers.springbatchexample1.batch.model;

public class EHoldingsRecord {
    private int packageId;
    private String packageName;
    private int titleId;
    private String titleName;

    public EHoldingsRecord(Package aPackage, Title title) {
        if (aPackage != null) {
            this.packageId = aPackage.getId();
            this.packageName = aPackage.getName();
        }
        if (title != null) {
            this.titleId = title.getId();
            this.titleName = title.getName();
        }
    }

    @Override
    public String toString() {
        return "Record{" +
                "packageId='" + packageId + '\'' +
                ", packageName='" + packageName + '\'' +
                ", titleId='" + titleId + '\'' +
                ", titleName='" + titleName + '\'' +
                '}';
    }
}
