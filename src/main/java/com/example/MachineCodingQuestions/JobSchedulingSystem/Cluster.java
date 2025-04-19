package com.example.MachineCodingQuestions.JobSchedulingSystem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cluster {
    private int clusterId;
    private int totalCpu;
    private int totalRam;
    private int availableCpu;
    private int availablenRam;
    private Lock resourcesLock;

    public Cluster(int clusterId, int totalCpu, int totalRam) {
        this.clusterId = clusterId;
        this.totalCpu = totalCpu;
        this.totalRam = totalRam;
        this.availableCpu = this.totalCpu;
        this.availablenRam = this.totalRam;
        resourcesLock=new ReentrantLock();
    }

    public boolean isResourceAvailable(int cpu,int ram){
        if(availableCpu>=cpu && availablenRam>=ram){
            return true;
        }
        else{
            return false;
        }

    }

    public boolean allocateResource(int cpu,int ram){
        System.out.println("allocating resources to the cluser");
        try{
            System.out.println("trying to acquire lock for cluster "+clusterId+" at "+System.currentTimeMillis());
            if(resourcesLock.tryLock(5, TimeUnit.MILLISECONDS)){
                try{
                    if(isResourceAvailable(cpu,ram)){
                        availableCpu-=cpu;
                        availablenRam-=ram;
                        return true;
                    }
                    else{
                        System.out.println("Resources not available for cluster "+clusterId);
                        return false;
                    }
                }
                finally {
                    System.out.println("Releasing lock for cluster "+clusterId+" at "+System.currentTimeMillis());
                    resourcesLock.unlock();
                }
            }
            else{
                return false;
            }
        }
        catch (InterruptedException e){
            e.printStackTrace();
            return false;
        }

    }

    public void deallocateResource(int cpu,int ram){
        resourcesLock.lock();
        try{
            availableCpu+=cpu;
            availablenRam+=ram;
        }
        finally {
            resourcesLock.unlock();
        }

    }
}
