package com.techprimers.springbatchexample1.batch.client;

import com.techprimers.springbatchexample1.batch.model.Package;

public class PackageClient {
    public Package get() {
        return new Package(0, "package0");
    }
}
