package com.cjs.designModeTest.StrategyMode;

/**
 * @author chen.jinshu
 * 2018/11/12
 */
public class AttackXLSBZ implements IAttackBehavior {

    @Override
    public void attack() {
        System.out.println("吃我降龙十八掌！");
    }
}
