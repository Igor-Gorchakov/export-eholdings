package com.techprimers.springbatchexample1.batch;

import com.techprimers.springbatchexample1.batch.model.Record;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.TaskExecutor;

@Configuration
@EnableBatchProcessing
public class JobConfig {
    @Autowired
    private JobBuilderFactory jobBuilderFactory;
    @Autowired
    private StepBuilderFactory stepBuilderFactory;
    @Autowired
    private TaskExecutor taskExecutor;

    @Bean
    public Job job(@Qualifier("Step") Step step) {
        return jobBuilderFactory.get("JobBuilder")
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
    }

    @Bean("Step")
    public Step step(
            @Qualifier("RecordReader") ItemReader<Record> reader,
            @Qualifier("RecordProcessor") ItemProcessor<Record, Record> processor,
            @Qualifier("RecordWriter") ItemWriter<Record> writer
    ) {
        return stepBuilderFactory.get("StepBuilder")
                .<Record, Record>chunk(Constants.PROCESSING_RECORD_CHUNK_SIZE)
                .reader(reader)
                .processor(processor)
                .writer(writer)
                .build();
    }
}
