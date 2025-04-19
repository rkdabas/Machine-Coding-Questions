package com.example.MachineCodingQuestions.JobSchedulingSystem;

import java.util.Objects;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class JobScheduler {
    private ClusterManager clusterManager;
    private BlockingQueue<Job>jobQueue;
    private ExecutorService executorService;

    public JobScheduler(){
        clusterManager=ClusterManager.getInstance();
        jobQueue=new ArrayBlockingQueue<>(100);
        executorService= Executors.newFixedThreadPool(5);

        for(int i=0;i<5;i++){
            executorService.submit(this::executeJob);
        }
    }

    public void submitJob(Job job){
        System.out.println("submitting job "+job.getJobId());
        jobQueue.add(job);
        System.out.println("job added to queue "+job.getJobId());
    }

    private void executeJob(){
        while(true){
            System.out.println("Thread id: "+Thread.currentThread().getId());
            try{
                Job job=jobQueue.take();
                Cluster cluster=clusterManager.getAvailableCluster(job.getRequiredCpu(),job.getRequiredRam());
                if(Objects.isNull(cluster)){
                    System.out.println("no available cluster for the job "+job.getJobId());
                    jobQueue.offer(job);
                    continue;
                }
                startJob(cluster,job);
            }
            catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    private void startJob(Cluster cluster,Job job){
        long currentTime=System.currentTimeMillis();
        System.out.println("Job "+job.getJobId()+" started on cluster "+cluster.getClusterId()+" at "+currentTime);
        try{
            Thread.sleep(job.getExecutionTimeInSeconds()*1000L);
        }
        catch (InterruptedException e){
            e.printStackTrace();
        }
        finally {
            cluster.deallocateResource(job.getRequiredCpu(),job.getRequiredRam());
        }
        System.out.println("Job "+job.getJobId()+" completed on cluster "+cluster.getClusterId() +" at "+System.currentTimeMillis());
        System.out.println("total time taken for job "+job.getJobId()+" is "+(System.currentTimeMillis()-currentTime)/1000+"s");
    }

}
