package com.example.MachineCodingQuestions.JobSchedulingSystem;

import javax.swing.*;

public class Main {
    public static void main(String args[]){
        ClusterManager clusterManager=ClusterManager.getInstance();

//        adding clusters
        clusterManager.addCluster(new Cluster(001,8,32));
        clusterManager.addCluster(new Cluster(002,16,64));

//        creating scheduler
        JobScheduler jobScheduler=new JobScheduler();

//        creating jobs
        Job job1=new Job("job1",4,16,3);
        Job job2=new Job("job2",2,8,9);
        Job job3=new Job("job3",6,24,12);

//        submit jobs
        jobScheduler.submitJob(job1);
        jobScheduler.submitJob(job2);
        jobScheduler.submitJob(job3);
    }
}
