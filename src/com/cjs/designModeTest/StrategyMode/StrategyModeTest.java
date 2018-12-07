package com.cjs.designModeTest.StrategyMode;

/**
 * 策略模式
 * @author chen.jinshu
 * 2018/11/12
 */
public class StrategyModeTest {

    public static void main(String[] args) {
        WXGameRole wxGameRole = new WXGameRole("武侠游戏角色");
        wxGameRole.setiAttackBehavior(new AttackXLSBZ())
                .setiDeffendBehavior(new DeffendJZZ())
                .setiRunBehavior(new RunJDY());

        wxGameRole.attack();
        wxGameRole.deffend();
        wxGameRole.run();
    }
}
