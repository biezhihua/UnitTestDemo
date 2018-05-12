package com.bzh.unit.demo.respository;

class DataRepository {

    private DataRepository() {

    }

    public static DataRepository getInstance() {
        return InnerClass.sInstance;
    }

    private static class InnerClass {
        static DataRepository sInstance = new DataRepository();
    }
}
