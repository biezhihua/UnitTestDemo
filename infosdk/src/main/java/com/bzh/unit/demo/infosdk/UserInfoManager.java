package com.bzh.unit.demo.infosdk;

import java.util.List;

class UserInfoManager {

    private UserInfoManager() {

    }

    public static UserInfoManager getInstance() {
        return InnerUserInfoManager.sInstance;
    }

    private static class InnerUserInfoManager {
        static UserInfoManager sInstance = new UserInfoManager();
    }

    public List<UserInfo> getAllUserInfoSync() {
        return null;
    }
}
