package com.github.ltprc.algorithm;

import java.util.BitSet;
import org.apache.commons.lang3.StringUtils;

public class IPFilterTest {
    // Java语言中没有无符号整形，int的最大值只能表示到0x7fffffff，所以需要两个BitSet来存储高低位
    private static volatile BitSet low = new BitSet(Integer.MAX_VALUE);
    private static volatile BitSet high = new BitSet(Integer.MAX_VALUE);

    /**
     * 固定8位，前面不足的补零
     * @param num
     * @return
     */
    private static String getByteBinaryStr(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            if ((num & 1) == 1) {
                sb.append(1);
            } else {
                sb.append(0);
            }
            num = num >> 1;
        }
        return sb.reverse().toString();
    }

    /**
     * 将IP地址字符串转换为int
     * @param ip
     * @return
     */
    private static int chgIpStrToInt(String ip) {
        if (ip == null || StringUtils.isEmpty(ip)) {
            throw new RuntimeException("Null string");
        }
        String[] arr = ip.split("\\.");
        if (arr == null || arr.length != 4) {
            throw new RuntimeException("Invalid ip");
        }
        if ("128.0.0.0".equals(ip)) {
            return Integer.MIN_VALUE;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(getByteBinaryStr(new Integer(arr[0])));
        sb.append(getByteBinaryStr(new Integer(arr[1])));
        sb.append(getByteBinaryStr(new Integer(arr[2])));
        sb.append(getByteBinaryStr(new Integer(arr[3])));
        String intStr = sb.toString();
        // Integer.valueOf处理负数会有问题
        if (intStr.charAt(0) == '1') {
            char[] chars = intStr.toCharArray();
            chars[0] = '0';
            intStr = new String(chars);
            return 0 - Integer.valueOf(intStr, 2).intValue();
        }
        return Integer.valueOf(intStr, 2).intValue();
    }

    public static boolean addWhiteIpAddress(String ip){
        int ipInt = chgIpStrToInt(ip);
        if (ipInt < 0) {
            high.set(ipInt+Integer.MAX_VALUE+1);
        } else {
            low.set(ipInt);
        }
        return true;
    }

    public static boolean isWhiteIpAddress(String ip) {
        int ipInt = chgIpStrToInt(ip);
        if (ipInt < 0) {
            return high.get(ipInt+Integer.MAX_VALUE+1);
        } else {
            return low.get(ipInt);
        }
    }

    public static void main(String[] args) {
        addWhiteIpAddress("0.0.0.0");
        addWhiteIpAddress("127.0.0.1");
        addWhiteIpAddress("255.255.255.255");
        System.out.println(!isWhiteIpAddress("0.0.0.0"));
        System.out.println(!isWhiteIpAddress("127.0.0.1"));
        System.out.println(!isWhiteIpAddress("255.255.255.255"));
        System.out.println(!isWhiteIpAddress("0.0.0.1"));
    }
}
