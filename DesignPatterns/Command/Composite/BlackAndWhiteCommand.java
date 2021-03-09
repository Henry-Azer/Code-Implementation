package DesignPatterns.Command.Composite;

import DesignPatterns.Command.CustomerService.fx.Command;

public class BlackAndWhiteCommand implements Command {
    @Override
    public void execute() {
        System.out.println("black and white.");
    }
}
