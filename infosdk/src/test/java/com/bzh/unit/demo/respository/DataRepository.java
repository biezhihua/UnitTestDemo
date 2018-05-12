package com.bzh.unit.demo.respository;

import java.util.List;

class DataRepository {

    List<VideoInfo> mAllVideoInfo;

    private DataRepository() {

    }

    public static DataRepository getInstance() {
        return InnerClass.sInstance;
    }

    public List<VideoInfo> getAllVideoSync() {
        return mAllVideoInfo;
    }

    private static class InnerClass {
        static DataRepository sInstance = new DataRepository();
    }
}
