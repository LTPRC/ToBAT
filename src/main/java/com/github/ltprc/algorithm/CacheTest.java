package com.github.ltprc.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class UserInfo {
    private String userId;
    private String userName;
    private String cardNo;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }
}

public class CacheTest {
    // 用户信息缓存
    private static Map<String, UserInfo> userCacheMap;
    // 更新时间缓存
    private static Map<String, Long> lastUpdateTimeMap;
    // 过期时间30分钟
    private static final long CACHE_TIME = 30 * 60 * 1000L;

    /**
     * 初始化用户信息缓存
     */
    public void initUserInfoCache() {
        if (lastUpdateTimeMap == null || userCacheMap == null) {
            synchronized (UserInfo.class) {
                if (lastUpdateTimeMap != null && userCacheMap != null) {
                    return;
                }
                // add log
                System.out.println("initUserInfoCache start");

                Map<String, UserInfo> userCacheMapTemp = new ConcurrentHashMap<>();
                Map<String, Long> lastUpdateTimeMapTemp = new ConcurrentHashMap<>();
                while (true) {
                    // 伪代码开始
                    List<UserInfo> userInfoList = new ArrayList<>(); // 分页查询
                    UserInfo newUserInfo = new UserInfo();
                    newUserInfo.setCardNo("003");
                    newUserInfo.setUserId("lis");
                    newUserInfo.setUserName("Lee IV");
                    userInfoList.add(newUserInfo);
                    // 伪代码结束
                    if (userInfoList == null || userInfoList.size() == 0) {
                        break;
                    }
                    // add log
                    System.out.println("batch query userInfoList to cache,size is :" + userInfoList.size());

                    for (UserInfo userInfo : userInfoList) {
                        userCacheMapTemp.put(userInfo.getUserId(), userInfo);
                        lastUpdateTimeMapTemp.put(userInfo.getUserId(), System.currentTimeMillis());
                    }
                }
                // add log
                System.out.println("initUserInfoCache end");

                userCacheMap = userCacheMapTemp;
                lastUpdateTimeMap = lastUpdateTimeMapTemp;
            }
        }
    }

    /**
     * 根据id从缓存中获取用户信息
     */
    public UserInfo getUserInfoFromCacheById(String id) {
        if (id == null || "".equals(id)) {
            // add log
            System.out.println("user id is empty!");

            return null;
        }
        // 初始化缓存
        initUserInfoCache();

        Long lastUpdateTime = lastUpdateTimeMap.get(id);
        UserInfo userInfo = userCacheMap.get(id);
        if ((System.currentTimeMillis() - lastUpdateTime) > CACHE_TIME) {
            synchronized (UserInfo.class) {
                // 超时30分钟，需更新缓存
                lastUpdateTime = lastUpdateTimeMap.get(id);
                if ((System.currentTimeMillis() - lastUpdateTime) > CACHE_TIME) {
                    updateUserInfoCache(id);
                }
            }
            userInfo = userCacheMap.get(id);
        }
        return userInfo;
    }

    /**
     * 根据id更新缓存用户信息
     */
    public void updateUserInfoCache(String id) {
        // add log
        System.out.println("updateUserInfoCache start,user id:" + id);

        // 伪代码开始
        UserInfo newUserInfo = new UserInfo();
        newUserInfo.setCardNo("007");
        newUserInfo.setUserId("zhangs");
        newUserInfo.setUserName("Zhang III");
        // 伪代码结束
        userCacheMap.put(newUserInfo.getUserId(), newUserInfo);
        lastUpdateTimeMap.put(newUserInfo.getUserId(), System.currentTimeMillis());

        // add log
        System.out.println("updateUserInfoCache end");
    }
}
