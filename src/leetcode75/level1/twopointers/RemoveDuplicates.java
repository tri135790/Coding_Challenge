package leetcode75.level1.twopointers;

public class RemoveDuplicates {

    public static int remove(int[] arr) {
        int nextNonDuplicate = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }

    public static int remove(int[] arr, int key) {
        int notKey = 0;
        for (int i = 0; i < arr.length; i++) {
            if(key != arr[i]) {
                arr[notKey] = arr[i];
                notKey++;
            }
        }
        return notKey;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 3,2, 3, 6,3 ,10, 9,3 };
        System.out.println(RemoveDuplicates.remove(arr, 3));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }
}
