package com.techprimers.springbatchexample1.batch.processor;

import com.techprimers.springbatchexample1.batch.model.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("RecordProcessor")
public class RecordProcessor implements ItemProcessor<Record, Record> {
    private final static Logger LOGGER = LoggerFactory.getLogger(RecordProcessor.class);

    @Override
    public Record process(Record record) {
        LOGGER.info("RecordProcessor: processing 1 record: " + record);
        return record;
    }
}
