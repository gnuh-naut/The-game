package objects;

public class Boss extends Tank {
    public Boss(){
        this(0.5,350,"./Image/Boss.png",40,40,10000);
    }

    public Boss(double speed, double health, String text, int width, int height,double attack) {
        super(0.5, 350, "./Image/Boss.png", 40, 40,10000);
    }

}
