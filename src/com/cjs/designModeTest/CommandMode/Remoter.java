package com.cjs.designModeTest.CommandMode;

/**
 * 遥控器
 * @author chen.jinshu
 * 2018/11/15
 */
public class Remoter {

    private final static int COMMAND_SIZE = 9;

    private Command[] commands;

    public Remoter() {
        this.commands = new Command[COMMAND_SIZE];
        for (int i = 0; i < this.commands.length; i++) {
            this.commands[i] = new BlankCommand();
        }
    }

    public void setCommand(int index, Command command) {
        this.commands[index] = command;
    }

    public void keyPressed(int index) {
        this.commands[index].execute();
    }
}
