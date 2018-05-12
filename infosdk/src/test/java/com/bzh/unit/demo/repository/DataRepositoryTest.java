package com.bzh.unit.demo.repository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNull.notNullValue;
import static org.powermock.api.mockito.PowerMockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class DataRepositoryTest {

    // 模拟一个FileCacheHelper实例
    @Mock
    FileCacheHelper mFileCacheHelper;

    @Mock
    NetHelper mNetHelper;

    @Test
    public void getInstance() {
        DataRepository instance = getNewInstance();
    }

    @Test
    public void getAllVideoSync() {
        DataRepository instance = getNewInstance();

        // 验证结果为空
        // 由于只是验证getAllVideoSync方法是否调用成功
        // 所以本次并不关心结果中是否含有数据
        List<VideoInfo> userInfoList = instance.getAllVideoSync();
        assertThat(userInfoList, is(nullValue()));
    }

    @Test
    public void getAllVideoSync_memoryCacheExist() {

        DataRepository instance = getNewInstance();

        // 模拟内存中存在数据
        instance.mAllVideoInfo = new ArrayList<VideoInfo>();

        // 验证内存缓存值存在，获取结果不为null
        List<VideoInfo> videoInfos = instance.getAllVideoSync();
        assertThat(videoInfos, is(notNullValue()));
    }

    @Test
    public void getAllVideoSync_memoryCacheNull_diskCacheExist() {
        DataRepository instance = getNewInstance();

        // 假设逻辑调用mFileCacheHelper.getAllVideoCache()时，返回一个空列表
        when(mFileCacheHelper.getAllVideoCache()).thenReturn(new ArrayList<VideoInfo>());

        // 验证文件缓存值存在，获取结果不为null
        List<VideoInfo> userInfoList = instance.getAllVideoSync();
        assertThat(userInfoList, is(notNullValue()));
    }

    @Test
    public void getAllVideoSync_memoryCacheNull_diskCacheNull_requestNet() {
        DataRepository instance = getNewInstance();

        // 模拟获取网络数据时，返回一个空列表
        when(mFileCacheHelper.getAllVideoCache()).thenReturn(new ArrayList<VideoInfo>());

        // 验证网络数据值存在，获取结果不为null
        List<VideoInfo> userInfoList = instance.getAllVideoSync();
        assertThat(userInfoList, is(notNullValue()));
    }

    private DataRepository getNewInstance() {

        DataRepository instance = new DataRepository(mFileCacheHelper, mNetHelper);

        // 断言：instance不为null
        assertThat(instance, is(notNullValue()));

        // 让FileCacheHelper.getAllVideoCache默认返回null
        when(mFileCacheHelper.getAllVideoCache()).thenReturn(null);

        // 让NetHelper.getAllVideoInfoFromNet默认返回null
        when(mNetHelper.getAllVideoInfoFromNet()).thenReturn(null);

        return instance;
    }

}
