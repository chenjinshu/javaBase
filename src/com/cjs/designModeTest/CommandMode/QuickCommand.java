package com.cjs.designModeTest.CommandMode;

/**
 * @author chen.jinshu
 * 2018/11/15
 */
public class QuickCommand implements Command {

    private Command[] commands;

    public QuickCommand(Command... commands) {
        this.commands = new Command[commands.length];
        for (int i = 0; i < commands.length; i++) {
            this.commands[i] = commands[i];
        }
    }

    @Override
    public void execute() {
        for (Command command : commands) {
            command.execute();
        }
    }
}
