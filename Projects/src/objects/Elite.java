package objects;

public class Elite extends Tank {
    public Elite(){
        this(2,150,"./Image/Elite.png",35,35,2,0,185);
    }

    public Elite(double speed, double health, String text, int width, int height,double attack,double x,double y) {
        super(2, 150, "./Image/Elite.png", 35, 35,2,0,185);
    }

}
