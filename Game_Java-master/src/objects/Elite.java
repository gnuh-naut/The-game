package objects;

public class Elite extends Tank {
    public Elite(){
        this(2,150,"./Image/Elite.png",30,30,2);
    }

    public Elite(double speed, double health, String text, int width, int height,double attack) {
        super(2, 150, "./Image/Elite.png", 30, 30,2);
    }

}
