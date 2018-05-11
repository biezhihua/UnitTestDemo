package com.bzh.unit.demo.infosdk;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

@RunWith(PowerMockRunner.class)
@PrepareForTest({})
public class UserInfoManagerTest {

    @Test
    public void getInstance() {
        UserInfoManager instance = UserInfoManager.getInstance();

        // 断言：instance不为null
        assertThat(instance, is(notNullValue()));
    }
}