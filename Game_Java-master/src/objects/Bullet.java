package objects;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class Bullet {
    public double damage;
    public double speed;
    public Image image;
    public String text;
    public double x,y;
    public Tank tank;
    public boolean hit = false;
    public Bullet(double damage,double speed,String text){
        this.damage = damage;
        this.speed = speed;
        this.image = new Image(text);
    }
    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(image);
        iv.setFitWidth(10);
        iv.setFitHeight(10);
        Image bImg = iv.snapshot(params, null);

        gc.drawImage(bImg, x, y);
    }
    public void update() {

        if (Math.abs(x-tank.x + y-tank.y) < 20)  hit = true;

        x += Math.round( (double)(tank.x-x)*speed/Math.abs(tank.x-x + tank.y-y) );
        y += Math.round( (double)(tank.y-y)*speed/Math.abs(tank.x-x + tank.y-y) );


    }
}
