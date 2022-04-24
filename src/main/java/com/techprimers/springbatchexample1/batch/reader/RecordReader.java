package com.techprimers.springbatchexample1.batch.reader;

import com.techprimers.springbatchexample1.batch.client.PackageClient;
import com.techprimers.springbatchexample1.batch.client.TitleClient;
import com.techprimers.springbatchexample1.batch.model.EHoldingsRecord;
import com.techprimers.springbatchexample1.batch.model.Package;
import com.techprimers.springbatchexample1.batch.model.Title;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("Reader")
@StepScope
public class Reader extends AbstractPaginatedReader<EHoldingsRecord> {
    private final PackageClient packageClient = new PackageClient();
    private final TitleClient titleClient = new TitleClient();
    private Package ePackage;

    @Override
    protected List<EHoldingsRecord> getItems(int offset, int limit) {
        System.out.println(String.format("Record: reading %s title records", limit));
        List<Title> titles = titleClient.get(offset, limit);
        List<EHoldingsRecord> records = new ArrayList<>(titles.size());
        for (Title eTitle : titles) {
            records.add(new EHoldingsRecord(this.ePackage, eTitle));
        }
        return records;
    }

    @BeforeStep
    public void readPackage(StepExecution stepExecution) {
        this.ePackage = packageClient.get();
    }
}
