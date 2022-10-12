package leetcode75.level1.mergeIntervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class Job {
    int start;
    int end;
    int cpuLoad;

    public Job(int start, int end, int cpuLoad) {
        this.start = start;
        this.end = end;
        this.cpuLoad = cpuLoad;
    }
};

class MaximumCPULoad {

    public static int findMaxCPULoad(List<Job> jobs) {
        jobs.sort((a,b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Job> activeJobs = new PriorityQueue<>(jobs.size(),
            (a,b) -> Integer.compare(a.end, b.end));

        int maxCpu = 0;
        int cpuCount = 0;

        for (Job job : jobs) {
            while (!activeJobs.isEmpty() && job.start >= activeJobs.peek().end) {
                cpuCount  -= activeJobs.poll().cpuLoad;
            }
            activeJobs.offer(job);
            cpuCount += job.cpuLoad;
            maxCpu = Math.max(maxCpu, cpuCount);
        }

        return maxCpu;
    }

    public static void main(String[] args) {
        List<Job> input = new ArrayList<Job>(
            Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
    }
}
