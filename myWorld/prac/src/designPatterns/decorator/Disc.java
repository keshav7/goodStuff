package designPatterns.decorator;

/**
 * Created by keshav.gupta on 06/03/16.
 */
public class Disc extends ComponentDecorator{


    Computer c;
    public Disc(Computer c) {
        this.c=c;
    }

    @Override
    public String description() {
        return c.description()+" disc";
    }
}
