package leetcode75.level1;

public class AddDigits {

    public static int addDigits(int num) {
        int sum = 0;

        if (num / 10 == 0) {
            return num;
        }

        while (num != 0) {
            sum = sum + num % 10;
            num = num / 10;
        }

        return addDigits(sum);
    }

    public static int adđigits2(int num) {
        if (num == 0) return 0;
        if (num % 9 == 0) return 9;
        return num % 9;
    }
}
