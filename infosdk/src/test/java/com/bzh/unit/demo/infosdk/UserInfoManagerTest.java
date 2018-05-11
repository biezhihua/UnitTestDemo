package com.bzh.unit.demo.infosdk;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.Matchers.nullValue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class UserInfoManagerTest {

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
    public void getAllUserInfoSync_memoryCacheNull_diskCacheExist(){

    }

    // Refactor Get Instance Method
    private UserInfoManager getNewInstance() {
        UserInfoManager instance = UserInfoManager.getInstance();
        assertThat(instance, is(notNullValue()));
        return instance;
    }

}
