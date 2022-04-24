package com.epam.spring.batch.batch.client;

import com.epam.spring.batch.batch.model.Package;

public class PackageClient {
    public Package get() {
        return new Package(0, "package0");
    }
}
