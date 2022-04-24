package com.epam.spring.batch.client;

import com.epam.spring.batch.model.Package;

public class PackageClient {
    public Package get() {
        return new Package(0, "package0");
    }
}
