package com.github.ltprc.algorithm.huawei.HJ43;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 题目描述
 * 定义一个二维数组N*M（其中2<=N<=10;2<=M<=10），如5 × 5数组下所示：
int maze[5][5] = {
0, 1, 0, 0, 0,
0, 1, 0, 1, 0,
0, 0, 0, 0, 0,
0, 1, 1, 1, 0,
0, 0, 0, 1, 0,
};
它表示一个迷宫，其中的1表示墙壁，0表示可以走的路，只能横着走或竖着走，不能斜着走，要求编程序找出从左上角到右下角的最短路线。入口点为[0,0],既第一空格是可以走的路。
本题含有多组数据。
 * 
 * 输入描述：
 * 输入两个整数，分别表示二位数组的行数，列数。再输入相应的数组，其中的1表示墙壁，0表示可以走的路。数据保证有唯一解,不考虑有多解的情况，即迷宫只有一条通道。
 * 
 * 输出描述：
 * 左上角到右下角的最短路径，格式如样例所示。
 * 
 * 友情提示：
 * 提交答案时，不要忘记提交import命令。
 * 类名称确保为Main且不要使用public以外的修饰符。
 * @author SHY
 *
 */
public class Main {
    static boolean keepSearching;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            keepSearching = true;
            String s = in.nextLine();
            String[] strs = s.split(" ");
            int row = Integer.parseInt(strs[0]);
            int col = Integer.parseInt(strs[1]);
            int[][] maze = new int[row][col];
            for (int i = 0; i < row; i++) {
                s = in.nextLine();
                strs = s.split(" ");
                for (int j = 0; j < col; j++) {
                    maze[i][j] = Integer.parseInt(strs[j]);
                }
            }
            boolean[][] path = new boolean[row][col];
            /**
             * 0 - Last row
             * 1 - Last column
             * 2 - Total distance
             */
            List<int[]> list = new ArrayList<>();
            list.add(new int[] {0, 0, 0});
            printShortestPath(0, 0, 0, row - 1, col - 1, list, path, maze);
        }
    }
    public static void printShortestPath(int x1, int y1, int dis, int x2, int y2, List<int[]> list, boolean[][] path, int[][] maze) {
        int row = path.length;
        int col = path[0].length;
        if (!keepSearching) {
            return;
        }
        if (x1 == x2 && y1 == y2) {
            printList(list);
            keepSearching = false;
        }
        if (x1 < row - 1 && !path[x1 + 1][y1] && maze[x1 + 1][y1] == 0) {
            list.add(new int[] {x1 + 1, y1, dis + 1});
            path[x1 + 1][y1] = true;
            printShortestPath(x1 + 1, y1, dis + 1, x2, y2, list, path, maze);
            list.remove(list.size() - 1);
            path[x1 + 1][y1] = false;
        }
        if (x1 > 0 && !path[x1 - 1][y1] && maze[x1 - 1][y1] == 0) {
            list.add(new int[] {x1 - 1, y1, dis + 1});
            path[x1 - 1][y1] = true;
            printShortestPath(x1 - 1, y1, dis + 1, x2, y2, list, path, maze);
            list.remove(list.size() - 1);
            path[x1 - 1][y1] = false;
        }
        if (y1 < col - 1 && !path[x1][y1 + 1] && maze[x1][y1 + 1] == 0) {
            list.add(new int[] {x1, y1 + 1, dis + 1});
            path[x1][y1 + 1] = true;
            printShortestPath(x1, y1 + 1, dis + 1, x2, y2, list, path, maze);
            list.remove(list.size() - 1);
            path[x1][y1 + 1] = false;
        }
        if (y1 > 0 && !path[x1][y1 - 1] && maze[x1][y1 - 1] == 0) {
            list.add(new int[] {x1, y1 - 1, dis + 1});
            path[x1][y1 - 1] = true;
            printShortestPath(x1, y1 - 1, dis + 1, x2, y2, list, path, maze);
            list.remove(list.size() - 1);
            path[x1][y1 - 1] = false;
        }
    }
    public static void printList(List<int[]> list) {
        for (int[] pos : list) {
            System.out.printf("(%d,%d)\n", pos[0], pos[1]);
        }
    }
}
