package com.bzh.unit.demo.repository;

import java.util.List;

class NetHelper {

    private NetHelper() {

    }

    public static NetHelper getInstance() {
        return NetHelper.InnerClass.sInstance;
    }

    public List<VideoInfo> getAllVideoInfoFromNet() {
        return null;
    }

    private static class InnerClass {
        static NetHelper sInstance = new NetHelper();
    }
}
