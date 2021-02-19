package com.github.ltprc.algorithm;

public class QuickSort {
    public static void quickSort(int[] arr, int startIndex, int endIndex) {
        // �ݹ����������startIndex�����endIndex��ʱ��
        if (startIndex >= endIndex) {
            return;
        }
        // �õ���׼Ԫ��λ��
        int pivotIndex = partition(arr, startIndex, endIndex);
        // �÷��η��ݹ����е�������
        quickSort(arr, startIndex, pivotIndex - 1);
        quickSort(arr, pivotIndex + 1, endIndex);
    }
    private static int partition(int[] arr, int startIndex, int endIndex) {
        // ȡ��һ��λ�õ�Ԫ����Ϊ��׼Ԫ��
        int pivot = arr[startIndex];
        int left = startIndex;
        int right = endIndex;
        // �ӵ�λ�ã���ʼ����pivot��λ��
        int index = startIndex;
        // ��ѭ��������ָ���غϻ��߽���ʱ����
        while (right >= left) {
            // rightָ�����������бȽ�
            while (right >= left) {
                if (arr[right] < pivot) {
                    arr[left] = arr[right];
                    index = right;
                    left++;
                    break;
                }
                right--;
            }
            // leftָ��������ҽ��бȽ�
            while (right >= left) {
                if (arr[left] > pivot) {
                    arr[right] = arr[left];
                    index = left;
                    right--;
                    break;
                }
                left++;
            }
        }
        arr[index] = pivot;
        return index;
    }
}
