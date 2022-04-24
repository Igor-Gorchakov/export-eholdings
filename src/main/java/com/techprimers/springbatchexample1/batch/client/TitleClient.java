package com.techprimers.springbatchexample1.batch.client;

import com.techprimers.springbatchexample1.batch.model.EHoldingsTitle;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class EHoldingsTitleClient {
    private AtomicInteger id = new AtomicInteger(0);

    public List<EHoldingsTitle> get(int offset, int limit) {
        List<EHoldingsTitle> eTitles = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            int id = this.id.getAndIncrement();
            eTitles.add(new EHoldingsTitle(id, "eHoldings title" + id));
        }
        return eTitles;
    }
}
