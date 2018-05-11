package com.bzh.unit.demo.infosdk;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;
import static org.mockito.Mockito.when;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class UserInfoManagerTest {

    // 模拟一个FileCacheHelper实例
    @Mock
    FileCacheHelper mFileCacheHelper;

    @Test
    public void getInstance() {
        UserInfoManager instance = getNewInstance();
    }

    @Test
    public void getAllUserInfoSync() {

        UserInfoManager instance = getNewInstance();

        // 验证结果为空
        // 由于只是验证getAllUserInfoSync方法是否调用成功
        // 所以本次并不关心结果中是否含有数据
        List<UserInfo> userInfoList = instance.getAllUserInfoSync();
        assertThat(userInfoList, is(nullValue()));
    }

    @Test
    public void getAllUserInfoSync_memoryCacheExist() {

        UserInfoManager instance = getNewInstance();

        // 模拟内存中存在数据
        instance.mAllUserInfo = new ArrayList<UserInfo>();

        // 验证内存缓存值存在，获取结果不为null
        List<UserInfo> userInfoList = instance.getAllUserInfoSync();
        assertThat(userInfoList, is(notNullValue()));
    }

    @Test
    public void getAllUserInfoSync_memoryCacheNull_diskCacheExist() {
        UserInfoManager instance = getNewInstance();

        // 假设逻辑调用mFileCacheHelper.getAllUserInfoCache()时，返回一个空列表
        when(mFileCacheHelper.getAllUserInfoCache()).thenReturn(new ArrayList<UserInfo>());

        // 验证文件缓存值存在，获取结果不为null
        List<UserInfo> userInfoList = instance.getAllUserInfoSync();
        assertThat(userInfoList, is(notNullValue()));
    }

    // Refactor Get Instance Method
    private UserInfoManager getNewInstance() {

        UserInfoManager instance = new UserInfoManager(mFileCacheHelper);
        assertThat(instance, is(notNullValue()));

        // 让FileCacheHelper.getAllUserInfoCache默认返回null
        when(mFileCacheHelper.getAllUserInfoCache()).thenReturn(null);

        return instance;
    }

}
