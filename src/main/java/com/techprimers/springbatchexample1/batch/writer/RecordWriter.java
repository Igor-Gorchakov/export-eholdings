package com.techprimers.springbatchexample1.batch.writer;

import com.techprimers.springbatchexample1.batch.model.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RecordConsoleWriter")
public class RecordConsoleWriter implements ItemWriter<Record> {
    private final static Logger LOGGER = LoggerFactory.getLogger(RecordConsoleWriter.class);

    @Override
    public void write(List<? extends Record> records) {
        LOGGER.info(String.format("RecordConsoleWriter: writing %s records", records.size()));
    }
}
