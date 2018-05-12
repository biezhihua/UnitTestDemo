package com.bzh.unit.demo.infosdk;

import java.util.List;

class NetHelper {

    private NetHelper() {

    }

    public static NetHelper getInstance() {
        return NetHelper.InnerClass.sInstance;
    }

    public List<UserInfo> getAllUserInfoFromNet() {
        // TODO
        return null;
    }

    private static class InnerClass {
        static NetHelper sInstance = new NetHelper();
    }
}
