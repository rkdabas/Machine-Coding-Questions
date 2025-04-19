package com.example.MachineCodingQuestions.JobSchedulingSystem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Job {
    private String jobId;
    private int requiredCpu;
    private int requiredRam;
    private int executionTimeInSeconds;

}
