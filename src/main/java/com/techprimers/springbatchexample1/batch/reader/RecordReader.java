package com.techprimers.springbatchexample1.batch.reader;

import com.techprimers.springbatchexample1.batch.client.PackageClient;
import com.techprimers.springbatchexample1.batch.client.TitleClient;
import com.techprimers.springbatchexample1.batch.model.Record;
import com.techprimers.springbatchexample1.batch.model.Package;
import com.techprimers.springbatchexample1.batch.model.Title;
import com.techprimers.springbatchexample1.batch.processor.RecordProcessor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.StepExecution;
import org.springframework.batch.core.annotation.BeforeStep;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("RecordReader")
@StepScope
public class RecordReader extends AbstractPaginatedReader<Record> {
    private final static Logger LOGGER = LoggerFactory.getLogger(RecordReader.class);
    private final PackageClient packageClient = new PackageClient();
    private final TitleClient titleClient = new TitleClient();
    private Package ePackage;

    @Override
    protected List<Record> getItems(int offset, int limit) {
        LOGGER.info(String.format("RecordReader: reading %s title records", limit));
        List<Title> titles = titleClient.get(offset, limit);
        List<Record> records = new ArrayList<>(titles.size());
        for (Title eTitle : titles) {
            records.add(new Record(this.ePackage, eTitle));
        }
        return records;
    }

    @Override
    protected int getTotalCount() {
        return titleClient.getTotalCount();
    }


    @BeforeStep
    public void readPackage(StepExecution stepExecution) {
        this.ePackage = packageClient.get();
    }
}
