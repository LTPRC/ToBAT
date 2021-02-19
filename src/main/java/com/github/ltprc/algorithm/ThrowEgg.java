package com.github.ltprc.algorithm;

public class ThrowEgg {
    public static int getMinSteps(int eggNum, int floorNum) {
        if (eggNum < 1 || floorNum < 1) {
            return 0;
        }
        // ����¼���洢eggNum��������floorNum��¥�����µ����Ż����Դ���
        int[][] cache = new
        int[eggNum + 1][floorNum + 1];
        // �ѱ���¼ÿ��Ԫ�س�ʼ�������ĳ��Դ���
        for (int i = 1; i <= eggNum; i++) {
            for (int j = 1; j <= floorNum; j++)
                cache[i][j] = j;
        }
        for (int n = 2; n <= eggNum; n++) {
            for (int m = 1; m <= floorNum; m++) {
                for (int k = 1; k < m; k++) {
                    // �Ӽ�����¥���1��mö��һ�飬�����ǰ����ĳ��Դ���С����һ������ĳ��Դ�������ȡ����һ�εĳ��Դ�����
                    // ������Դ�ӡk��ֵ���Ӷ�֪����һ�������Ǵӵڼ����ӵġ�
                    cache[n][m] = Math.min(cache[n][m], 1 + Math.max(cache[n - 1][k - 1], cache[n][m - k]));
                }
            }
        }
        return cache[eggNum][floorNum];
    }
    public static int getMinStepsCompressed(int eggNum, int floorNum) {
        if (eggNum < 1 || floorNum < 1) {
            return 0;
        }
        // ��һ�㱸��¼���洢��������-1��floorNum��¥�����µ����Ż����Դ���
        int[] preCache = new
        int[floorNum + 1];
        // ��ǰ����¼���洢��ǰ����������floorNum��¥�����µ����Ż����Դ���
        int[] currentCache = new
        int[floorNum + 1];
        // �ѱ���¼ÿ��Ԫ�س�ʼ�������ĳ��Դ���
        for (int i = 1; i <= floorNum; i++) {
            currentCache[i] = i;
        }
        for (int n = 2; n <= eggNum; n++) {
            // ��ǰ����¼��������һ�α���¼�������³�ʼ����ǰ����¼
            preCache = currentCache.clone();
            for (int i = 1; i <= floorNum; i++) {
                currentCache[i] = i;
            }
            for (int m = 1; m <= floorNum; m++) {
                for (int k = 1; k < m; k++) {
                    // �Ӽ�����¥���1��mö��һ�飬�����ǰ����ĳ��Դ���С����һ������ĳ��Դ�������ȡ����һ�εĳ��Դ�����
                    // ������Դ�ӡk��ֵ���Ӷ�֪����һ�������Ǵӵڼ����ӵġ�
                    currentCache[m] = Math.min(currentCache[m], 1 + Math.max(preCache[k - 1], currentCache[m - k]));
                }
            }
        }
        return currentCache[floorNum];
    }
    public static void main(String[] args) {
        System.out.println(getMinSteps(5, 500));
    }
}
