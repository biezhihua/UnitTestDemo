package com.bzh.unit.demo;

import android.os.Handler;

import org.junit.Test;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


public class ExampleUnitTest {


    @Test
    public void testHandler() {

        Handler handler = mock(Handler.class);

        // 验证Handler的post方法是否被执行了
        handler.post(new Runnable() {
            @Override
            public void run() {

            }
        });
        verify(handler).post(any(Runnable.class));

        // 模拟post方法执行，并验证run方法有没有被执行
        when(handler.post(any(Runnable.class))).thenAnswer(new Answer() {
            @Override
            public Object answer(InvocationOnMock invocation) throws Throwable {
                Runnable runnable = invocation.getArgument(0);
                runnable.run();
                return null;
            }
        });
        Runnable spy = spy(new Runnable() {
            @Override
            public void run() {

            }
        });
        handler.post(spy);
        verify(spy).run();
    }
}