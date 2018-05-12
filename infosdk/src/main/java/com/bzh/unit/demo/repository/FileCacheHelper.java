package com.bzh.unit.demo.repository;

import java.util.List;

class FileCacheHelper {

    private FileCacheHelper() {
    }

    public static FileCacheHelper getInstance() {
        return InnerClass.sInstance;
    }

    public List<VideoInfo> getAllVideoCache() {
        return null;
    }

    private static class InnerClass {
        static FileCacheHelper sInstance = new FileCacheHelper();
    }
}