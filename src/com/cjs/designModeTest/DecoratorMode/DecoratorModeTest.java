package com.cjs.designModeTest.DecoratorMode;

/**
 * 装饰器模式
 * @author chen.jinshu
 * 2018/11/16
 */
public class DecoratorModeTest {

    public static void main(String[] args) {
        IEquip equip = new BlackGemDecorator(new RedGemDecorator(new BlueGemDecorator(new YTJ())));
        System.out.println(equip.getPower());
    }
}
