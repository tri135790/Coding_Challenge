package leetcode75.level1.twopointers;

public class BackspaceCompare {

    public static boolean compare(String str1, String str2) {
        int count1 = str1.length() - 1, count2 = str2.length() - 1;
        int skip1 = 0, skip2 = 0;

        while (count1 >= 0 || count2 >= 0) {
            while (count1 >= 0) {
                if (str1.charAt(count1) == '#') {skip1++; count1--;}
                else if (skip1 > 0) {skip1--; count1--;}
                else break;
            }
            while (count2 >= 0) { // Find position of next possible char in build(T)
                if (str2.charAt(count2) == '#') {skip2++; count2--;}
                else if (skip2 > 0) {skip2--; count2--;}
                else break;
            }
            if (count1 >= 0 && count2 >= 0 && str1.charAt(count1) != str2.charAt(count2))
                return false;
            if ((count1 >= 0) != (count2 >= 0))
                return false;
            count1--; count2--;
        }
        return true;
    }





    public static void main(String[] args) {
        System.out.println(BackspaceCompare.compare("xy#z", "xzz#"));
        System.out.println(BackspaceCompare.compare("xy#z", "xyz#"));
        System.out.println(BackspaceCompare.compare("xp#", "xyz##"));
        System.out.println(BackspaceCompare.compare("xywrrmp", "xywrrmu#p"));
    }
}
