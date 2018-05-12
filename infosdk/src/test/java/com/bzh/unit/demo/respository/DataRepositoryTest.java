package com.bzh.unit.demo.respository;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.hamcrest.core.IsNull.notNullValue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class DataRepositoryTest {

    @Test
    public void getInstance() {
        DataRepository instance = getNewInstance();

    }

    private DataRepository getNewInstance() {
        DataRepository instance = DataRepository.getInstance();
        // 断言：instance不为null
        assertThat(instance, is(notNullValue()));
        return instance;
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

    }
}
