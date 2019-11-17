package objects;

public class Normal extends Tank    {
    public Normal(){
        this(1.5,100,"./Image/Normal.png",30,30,2);
    }

    public Normal(double speed, double health, String text, int width, int height,double attack) {
        super(1.5, 100, "./Image/Normal.png", 30, 30,2);
    }

}
