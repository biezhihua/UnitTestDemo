package com.bzh.unit.demo.respository;

import java.util.List;

class DataRepository {

    private DataRepository() {

    }

    public static DataRepository getInstance() {
        return InnerClass.sInstance;
    }

    public List<VideoInfo> getAllVideoSync() {
        return null;
    }

    private static class InnerClass {
        static DataRepository sInstance = new DataRepository();
    }
}
