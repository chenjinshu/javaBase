package com.cjs.designModeTest.observerMode;

import java.util.Observable;

/**
 * 新闻广播(被观察者)
 * @author chen.jinshu
 * 2018/11/09
 */
public class NewsBroadcast extends Observable {

    public void sendBroadcast(String broadcast) {
        this.setChanged();
        this.notifyObservers(broadcast);
    }
}
