package com.cjs.designModeTest.AdapterMode;

/**
 * 手机充电适配器, 同时适配android手机和iphone手机
 * @author chen.jinshu
 * 2018/11/15
 */
public class MobilePowerAdapter implements IPhonePowerProvider, AndroidPowerProvider{

    private HomePower homePower;

    public MobilePowerAdapter(HomePower homePower) {
        this.homePower = homePower;
    }

    @Override
    public int provideAndroidPower() {
        return homePower.providePower() / 44;
    }

    @Override
    public int provideIPhonePower() {
        return homePower.providePower() / 22;
    }
}
