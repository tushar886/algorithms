package com.dynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

//Define JOB class which will have the start time, finsishTime and the weight
class Job {
    int startTime;
    int finishTime;
    int weight;

    public Job(int startTime, int finishTime, int weight) {
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.weight = weight;
    }
}

public class WeightedJobScheduling {

    public static int findNonConflictingJobIndex(List<Job> jobs, int n) {
            return -1;
    }
    
    public static int maxProfitNaiveRecursion(List<Job> jobs, int n) {
        /*
        The jobs received here will be always sorted as per the finish times.
         */

        //base case first
        if (n < 0) {
            return 0;
        }

        if ( n == 0) {
            //there is only one item remaining.
            // return as it is
            return jobs.get(n).weight;
        }

        //firststep find index of last joob which is non conflicting with this current nth job.
        int nonconflictIndex = findNonConflictingJobIndex(jobs, n);

        return -1;



    }

    public static void main(String args[]) {

        List<Job> jobList = Arrays.asList(
                                            new Job(0, 6, 60),
                                            new Job(1, 4, 30),
                                            new Job(3, 5, 10),
                                            new Job(5, 7, 30),
                                            new Job(5, 9, 50),
                                            new Job(7, 8, 10)
                                    );
        //sort the job list before sending it to
        //Sorting to be done basis of finsish time
        Collections.sort(jobList, (x, y) -> x.finishTime - y.finishTime);
        System.out.println("Max Profit naive recursion is as: " + maxProfitNaiveRecursion(jobList, jobList.size()  - 1));
    }
}
