package leetcode75.level1.topologicalsort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

public class CourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] incomingEdges = new int[numCourses];

        List<Integer>[] goCourses = new List[numCourses];

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            List<Integer> list = new LinkedList<>();
            goCourses[i] = list;
        }

        for (int[] pair : prerequisites) {
            incomingEdges[pair[0]]++;
            goCourses[pair[1]].add(pair[0]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (incomingEdges[i] == 0) {
                queue.add(i);
            }
        }
        int edgeCount = prerequisites.length;;
        while (!queue.isEmpty()) {
            Integer current = queue.poll();

            for (int course : goCourses[current]) {
                edgeCount--;
                incomingEdges[course]--;
                if (incomingEdges[course] == 0) {
                    queue.add(course);
                }
            }
        }

        return edgeCount == 0;
    }


    public static void main(String[] args) {
        int[][] prerequisites = new int[][] {{1,0}, {0,1}};
        canFinish(2, prerequisites);
    }
}
