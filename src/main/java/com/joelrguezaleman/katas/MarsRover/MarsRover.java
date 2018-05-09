package com.joelrguezaleman.katas;

public class MarsRover
{
    private Coordinates coordinates;

    public MarsRover(Coordinates coordinates, char direction) throws InvalidCoordinatesException
    {
        if (coordinates.x < 0 || coordinates.y < 0) {
            throw new InvalidCoordinatesException();
        }

        this.coordinates = coordinates;
    }

    public void move(char[] commands)
    {
        for (char command : commands) {
            this.coordinates.x++;
        }
    }

    public Coordinates coordinates()
    {
        return this.coordinates;
    }
}
