package com.cjs.designModeTest.StrategyMode;

/**
 * @author chen.jinshu
 * 2018/11/12
 */
public abstract class GameRole {

    // 角色名称
    protected String name;

    // 攻击行为
    protected IAttackBehavior iAttackBehavior;

    // 防御行为
    protected IDeffendBehavior iDeffendBehavior;

    // 逃跑行为
    protected IRunBehavior iRunBehavior;

    public GameRole setiAttackBehavior(IAttackBehavior iAttackBehavior) {
        this.iAttackBehavior = iAttackBehavior;
        return this;
    }

    public GameRole setiDeffendBehavior(IDeffendBehavior iDeffendBehavior) {
        this.iDeffendBehavior = iDeffendBehavior;
        return this;
    }

    public GameRole setiRunBehavior(IRunBehavior iRunBehavior) {
        this.iRunBehavior = iRunBehavior;
        return this;
    }


    public void attack() {
        this.iAttackBehavior.attack();
    }

    public void deffend() {
        this.iDeffendBehavior.deffend();
    }

    public void run() {
        this.iRunBehavior.run();
    }
}
