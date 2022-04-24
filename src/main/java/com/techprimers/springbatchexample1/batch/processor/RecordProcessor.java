package com.techprimers.springbatchexample1.batch.processor;

import com.techprimers.springbatchexample1.batch.model.EHoldingsRecord;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

@Component("Processor")
public class Processor implements ItemProcessor<EHoldingsRecord, EHoldingsRecord> {

    @Override
    public EHoldingsRecord process(EHoldingsRecord record) {
        System.out.println("Processor: processing 1 record: " + record);
        return record;
    }
}
