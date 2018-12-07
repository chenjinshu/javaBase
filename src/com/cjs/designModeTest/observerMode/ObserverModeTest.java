package com.cjs.designModeTest.observerMode;

/**
 * @author chen.jinshu
 * 2018/11/09
 */
public class ObserverModeTest {

    public static void main(String[] args) {
        // 定义一个被观察者
        NewsBroadcast newsBroadcast = new NewsBroadcast();

        // 定义第一个观察者
        Observer1 observer1 = new Observer1();

        // 定义第二个观察者
        Observer2 observer2 = new Observer2();

        // 注册第一个观察者到被观察者中
        observer1.registrySubject(newsBroadcast);

        // 注册第二个观察者到被观察者中
        observer2.registrySubject(newsBroadcast);

        // 被观察者向所有绑定在其上的观察者发送消息
        newsBroadcast.sendBroadcast("hahaha");
    }
}
