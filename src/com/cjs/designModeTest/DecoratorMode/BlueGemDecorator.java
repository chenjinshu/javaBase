package com.cjs.designModeTest.DecoratorMode;

/**
 * 蓝宝石装饰器
 * @author chen.jinshu
 * 2018/11/16
 */
public class BlueGemDecorator implements IEquipDecorator {

    private IEquip iEquip;

    public BlueGemDecorator(IEquip iEquip) {
        this.iEquip = iEquip;
    }

    @Override
    public int getPower() {
        return 1 + iEquip.getPower();
    }
}
