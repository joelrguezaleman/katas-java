package com.joelrguezaleman.katas.marsrover;

public class MarsRover
{
    private CommandFactory commandFactory;
    private Position position;

    public MarsRover(
        CommandFactory commandFactory,
        Position position
    ) {
        this.commandFactory = commandFactory;
        this.position       = position;
    }

    public void move(char[] rawCommands) throws InvalidCommandException
    {
        for (char rawCommand : rawCommands) {
            Command command = this.commandFactory.create(rawCommand);
            command.run(this.position);
        }
    }

    public Position position()
    {
        return this.position;
    }
}
