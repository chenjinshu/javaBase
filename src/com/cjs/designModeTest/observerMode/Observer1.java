package com.cjs.designModeTest.observerMode;

import java.util.Observable;
import java.util.Observer;

/**
 * @author chen.jinshu
 * 2018/11/09
 */
public class Observer1 implements Observer {

    public void registrySubject(Observable observable) {
        observable.addObserver(this);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("观察者1接收到参数：" + arg);
    }
}
