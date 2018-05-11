package com.bzh.unit.demo.infosdk;

class UserInfoManager {

    private UserInfoManager() {

    }

    public static UserInfoManager getInstance() {
        return InnerUserInfoManager.sInstance;
    }

    private static class InnerUserInfoManager {
        static UserInfoManager sInstance = new UserInfoManager();
    }
}
