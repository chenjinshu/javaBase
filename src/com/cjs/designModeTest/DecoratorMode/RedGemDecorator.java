package com.cjs.designModeTest.DecoratorMode;

/**
 * 红宝石装饰器
 * @author chen.jinshu
 * 2018/11/16
 */
public class RedGemDecorator implements IEquipDecorator {

    private IEquip iEquip;

    public RedGemDecorator(IEquip iEquip) {
        this.iEquip = iEquip;
    }

    @Override
    public int getPower() {
        return 2 + iEquip.getPower();
    }
}
