package com.cjs.designModeTest.CommandMode;

/**
 * @author chen.jinshu
 * 2018/11/15
 */
public class DoorOpenCommand implements Command {
    @Override
    public void execute() {
        System.out.println("开门");
    }
}
