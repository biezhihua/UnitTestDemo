package com.bzh.unit.demo.repository;

import java.util.List;

class DataRepository {

    List<VideoInfo> mAllVideoInfo;
    private FileCacheHelper mFileCacheHelper;

    DataRepository(FileCacheHelper fileCacheHelper) {
        mFileCacheHelper = fileCacheHelper;
    }

    public static DataRepository getInstance() {
        return InnerClass.sInstance;
    }

    public List<VideoInfo> getAllVideoSync() {

        // 内存缓存存在时直接返回
        if (mAllVideoInfo != null) {
            return mAllVideoInfo;
        }

        // 获取文件缓存，文件缓存存在时赋值给内存缓存并返回数据
        mAllVideoInfo = mFileCacheHelper.getAllVideoCache();
        if (mAllVideoInfo != null) {
            return mAllVideoInfo;
        }
        return mAllVideoInfo;
    }

    private static class InnerClass {
        static DataRepository sInstance = new DataRepository(FileCacheHelper.getInstance());
    }
}
