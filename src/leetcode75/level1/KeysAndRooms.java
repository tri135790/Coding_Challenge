package leetcode75.level1;

import java.util.LinkedList;
import java.util.List;

public class KeysAndRooms {

    public static boolean canVisitAllRooms(List<List<Integer>> rooms) {
        boolean[] isVisited = new boolean[rooms.size()];
            isVisited[0] = true;
            int count = 0;
         dfs(rooms,0, isVisited);
        for (boolean v: isVisited)  // if any room hasn't been visited, return false
            if (!v) return false;
        return true;
    }

    private static void dfs(List<List<Integer>> rooms, int room, boolean[] isVisited
                     ) {
        for (int i = 0; i < rooms.get(room).size(); i++ ) {
            if (!isVisited[rooms.get(room).get(i)]) {
                isVisited[rooms.get(room).get(i)] = true;
                dfs(rooms, rooms.get(room).get(i), isVisited);
            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> rooms = new LinkedList<>();
        List<Integer> list0 = new LinkedList<>();
        list0.add(1);
        List<Integer> list1 = new LinkedList<>();
        list1.add(2);
        List<Integer> list2 = new LinkedList<>();
        list1.add(3);
        List<Integer> list3 = new LinkedList<>();
        rooms.add(list0);
        rooms.add(list1);
        rooms.add(list2);
        rooms.add(list3);

        canVisitAllRooms(rooms);
    }
}
