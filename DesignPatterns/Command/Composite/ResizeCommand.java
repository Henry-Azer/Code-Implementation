package DesignPatterns.Command.Composite;

import DesignPatterns.Command.CustomerService.fx.Command;

public class ResizeCommand implements Command {
    @Override
    public void execute() {
        System.out.println("Resize.");
    }
}
