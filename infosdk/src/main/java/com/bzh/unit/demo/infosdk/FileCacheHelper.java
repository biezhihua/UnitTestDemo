package com.bzh.unit.demo.infosdk;

import java.util.List;

class FileCacheHelper {

    private FileCacheHelper() {

    }

    public static FileCacheHelper getInstance() {
        return InnerClass.sInstance;
    }

    public List<UserInfo> getAllUserInfoCache() {
        return null;
    }

    private static class InnerClass {
        static FileCacheHelper sInstance = new FileCacheHelper();
    }
}
