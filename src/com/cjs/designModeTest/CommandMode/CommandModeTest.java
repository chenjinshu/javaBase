package com.cjs.designModeTest.CommandMode;

/**
 * 命令模式
 * @author chen.jinshu
 * 2018/11/15
 */
public class CommandModeTest {

    public static void main(String[] args) {
        Remoter remoter = new Remoter();
        remoter.setCommand(0, new DoorOpenCommand());
        remoter.setCommand(1, new DoorCloseCommand());
        remoter.setCommand(2, new TVOpenCommand());
        remoter.setCommand(3, new TVCloseCommand());
        remoter.setCommand(4, new QuickCommand());

        remoter.keyPressed(0);
        remoter.keyPressed(1);
        remoter.keyPressed(2);
        remoter.keyPressed(3);
        remoter.keyPressed(4);
        remoter.keyPressed(8);
    }
}
