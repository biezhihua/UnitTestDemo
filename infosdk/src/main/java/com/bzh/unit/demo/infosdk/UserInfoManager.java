package com.bzh.unit.demo.infosdk;

import java.util.List;

class UserInfoManager {

    List<UserInfo> mAllUserInfo;
    private FileCacheHelper mFileCacheHelper;
    private NetHelper mNetHelper;

    UserInfoManager(FileCacheHelper fileCacheHelper, NetHelper netHelper) {
        mFileCacheHelper = fileCacheHelper;
        mNetHelper = netHelper;
    }

    public static UserInfoManager getInstance() {
        return InnerUserInfoManager.sInstance;
    }

    private static class InnerUserInfoManager {
        static UserInfoManager sInstance = new UserInfoManager(FileCacheHelper.getInstance(), NetHelper.getInstance());
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

        // 获取网络数据，将值赋给内存缓存并返回数据
        mAllUserInfo = mNetHelper.getAllUserInfoFromNet();
        return mAllUserInfo;
    }
}
