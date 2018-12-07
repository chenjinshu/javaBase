package com.cjs.designModeTest.AdapterMode;

/**
 * @author chen.jinshu
 * 2018/11/15
 */
public class AdapterModeTest {

    public static void main(String[] args) {
        MobilePowerAdapter mobilePowerAdapter = new MobilePowerAdapter(new HomePower());
        System.out.println("适配器将家用电压适配后给安卓手机提供的电压为：" + mobilePowerAdapter.provideAndroidPower());
        System.out.println("适配器将家用电压适配后给苹果手机提供的电压为：" + mobilePowerAdapter.provideIPhonePower());
    }
}
