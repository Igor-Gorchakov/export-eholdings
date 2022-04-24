package com.epam.spring.batch.writer;

import com.epam.spring.batch.model.Record;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("RecordWriter")
public class RecordWriter implements ItemWriter<Record> {
    private final static Logger LOGGER = LoggerFactory.getLogger(RecordWriter.class);

    @Override
    public void write(List<? extends Record> records) {
        LOGGER.info(String.format("RecordWriter: writing %s records", records.size()));
    }
}
