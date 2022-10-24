package leetcode75.level1.modifiedbinarysearch;

public class MaxInBitonicArray {

    public static int findMax(int[] arr) {
        int start = 0, end = arr.length - 1;

        while (start <= end) {
            int mid = start + (end-start)/2;
            if (mid == arr.length - 1) return arr[arr.length - 1];
            if (mid == 0) return arr[0];

            if (arr[mid-1] < arr[mid] && arr[mid] < arr[mid+1]) {
                start = mid + 1;
            } else if (arr[mid-1] > arr[mid] && arr[mid] > arr[mid+1]) {
                end = mid - 1;
            } else if(arr[mid - 1] < arr[mid] && arr[mid]>arr[mid+1]) {
                return arr[mid];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
        System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
    }
}
