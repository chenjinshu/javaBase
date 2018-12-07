package com.cjs.designModeTest.DecoratorMode;

/**
 * 黑宝石装饰器
 * @author chen.jinshu
 * 2018/11/16
 */
public class BlackGemDecorator implements IEquipDecorator {

    private IEquip iEquip;

    public BlackGemDecorator(IEquip iEquip) {
        this.iEquip = iEquip;
    }

    @Override
    public int getPower() {
        return 3 + iEquip.getPower();
    }
}
