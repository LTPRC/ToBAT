package com.github.ltprc.algorithm.huawei.HJ43;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ��Ŀ����
 * ����һ����ά����N*M������2<=N<=10;2<=M<=10������5 �� 5��������ʾ��
int maze[5][5] = {
0, 1, 0, 0, 0,
0, 1, 0, 1, 0,
0, 0, 0, 0, 0,
0, 1, 1, 1, 0,
0, 0, 0, 1, 0,
};
����ʾһ���Թ������е�1��ʾǽ�ڣ�0��ʾ�����ߵ�·��ֻ�ܺ����߻������ߣ�����б���ߣ�Ҫ�������ҳ������Ͻǵ����½ǵ����·�ߡ���ڵ�Ϊ[0,0],�ȵ�һ�ո��ǿ����ߵ�·��
���⺬�ж������ݡ�
 * 
 * ����������
 * ���������������ֱ��ʾ��λ�������������������������Ӧ�����飬���е�1��ʾǽ�ڣ�0��ʾ�����ߵ�·�����ݱ�֤��Ψһ��,�������ж�����������Թ�ֻ��һ��ͨ����
 * 
 * ���������
 * ���Ͻǵ����½ǵ����·������ʽ��������ʾ��
 * 
 * ������ʾ��
 * �ύ��ʱ����Ҫ�����ύimport���
 * ������ȷ��ΪMain�Ҳ�Ҫʹ��public��������η���
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
