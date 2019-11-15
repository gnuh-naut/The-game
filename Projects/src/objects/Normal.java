package objects;

public class Normal extends Tank    {
    public Normal(){
        this(1.5,100,"./Image/Normal.png",35,35,2,0,185);
    }

    public Normal(double speed, double health, String text, int width, int height,double attack,double x,double y) {
        super(1.5, 100, "./Image/Normal.png", 35, 35,2,0,185);
    }

}
