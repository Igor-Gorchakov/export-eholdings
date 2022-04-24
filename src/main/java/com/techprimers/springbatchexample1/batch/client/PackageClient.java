package com.techprimers.springbatchexample1.batch.client;

import com.techprimers.springbatchexample1.batch.model.EHoldingsPackage;

public class EHoldingsPackageClient {
    public EHoldingsPackage get() {
        return new EHoldingsPackage(0, "eHoldings package0");
    }
}
