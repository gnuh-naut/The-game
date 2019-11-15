package objects;

public class Boss extends Tank {
    public Boss(){
        this(0.5,350,"./Image/Boss.png",50,50,10000,0,185);
    }

    public Boss(double speed, double health, String text, int width, int height,double attack,double x,double y) {
        super(0.5, 350, "./Image/Boss.png", 50, 50,10000,0,185);
    }

}
