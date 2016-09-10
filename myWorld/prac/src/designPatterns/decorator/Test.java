package designPatterns.decorator;

/**
 * Created by keshav.gupta on 06/03/16.
 */
public class Test
{
    public static void main(String args[])
    {
        Computer computer = new Computer();
        computer = new Disc(computer);
        computer = new Monitor(computer);
        System.out.println("You're getting a " + computer.description() + ".");
    }
}