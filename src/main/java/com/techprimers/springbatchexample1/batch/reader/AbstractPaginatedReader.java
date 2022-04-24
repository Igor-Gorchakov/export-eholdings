package com.techprimers.springbatchexample1.batch.reader;

import com.techprimers.springbatchexample1.batch.Constants;
import org.springframework.batch.item.support.AbstractItemCountingItemStreamItemReader;

import java.util.List;
import java.util.UUID;

public abstract class AbstractReader<T> extends AbstractItemCountingItemStreamItemReader<T> {

    private int currentOffset;
    private List<T> currentChunk;
    private int currentChunkOffset;

    protected AbstractReader() {
        currentOffset = 0;
        setCurrentItemCount(0);
        setMaxItemCount(Constants.READER_HTTP_REQUEST_QUANTITY);
        setSaveState(false);
        setExecutionContextName(getClass().getSimpleName() + '_' + UUID.randomUUID());
    }

    @Override
    protected T doRead() {
        if (currentChunk == null || currentChunkOffset >= currentChunk.size()) {
            currentChunk = getItems(currentOffset, Constants.READER_HTTP_REQUEST_QUANTITY);
            currentOffset += Constants.READER_HTTP_REQUEST_QUANTITY;
            currentChunkOffset = 0;
        }
        if (currentChunk.isEmpty()) {
            return null;
        }
        var item = currentChunk.get(currentChunkOffset);
        currentChunkOffset++;
        return item;
    }

    @Override
    protected void doOpen() {
        // Nothing to do
    }

    @Override
    protected void doClose() {
        // Nothing to do
    }

    protected abstract List<T> getItems(int offset, int limit);
}
