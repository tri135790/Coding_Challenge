package leetcode75.level1;

public class FloodFill {

    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int start = image[sr][sc];
        if (start != color) {
            floodFill(image, sr, sc ,color, start);
        }
        return image;
    }

    private void floodFill(int[][] image, int sr, int sc, int color, int start) {
        if (image[sr][sc] == start) {
            image[sr][sc] = color;

            if (sr > 0) {
                floodFill(image, sr - 1, sc , color, start);
            }
            if (sc > 0) {
                floodFill(image, sr, sc -1, color, start);
            }
            if (sr < image.length - 1) {
                floodFill(image, sr + 1, sc, color, start);
            }
            if (sc < image[sr].length - 1) {
                floodFill(image, sr, sc + 1, color, start);
            }
        }
    }
}
