package com.bzh.unit.demo.infosdk;

import java.util.List;

class UserInfoManager {

    List<UserInfo> mAllUserInfo;
    private FileCacheHelper mFileCacheHelper;

    UserInfoManager(FileCacheHelper fileCacheHelper) {
        mFileCacheHelper = fileCacheHelper;
    }

    public static UserInfoManager getInstance() {
        return InnerUserInfoManager.sInstance;
    }

    private static class InnerUserInfoManager {
        static UserInfoManager sInstance = new UserInfoManager(FileCacheHelper.getInstance());
    }

    public List<UserInfo> getAllUserInfoSync() {

        // 内存缓存存在时直接返回
        if (mAllUserInfo != null) {
            return mAllUserInfo;
        }

        // 获取文件缓存，文件缓存存在时赋值给内存缓存并返回数据
        mAllUserInfo = mFileCacheHelper.getAllUserInfoCache();
        if (mAllUserInfo != null) {
            return mAllUserInfo;
        }

        return null;
    }
}
