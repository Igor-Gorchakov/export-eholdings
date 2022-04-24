package com.epam.spring.batch.client;

import com.epam.spring.batch.Constants;
import com.epam.spring.batch.model.Title;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class TitleClient {
    private AtomicInteger id = new AtomicInteger(0);

    public List<Title> get(int offset, int limit) {
        List<Title> titles = new ArrayList<>(limit);
        for (int i = 0; i < limit; i++) {
            int id = this.id.getAndIncrement();
            titles.add(new Title(id, "title" + id));
        }
        return titles;
    }

    public int getTotalCount() {
        return Constants.TOTAL_ITEM_COUNT;
    }
}
