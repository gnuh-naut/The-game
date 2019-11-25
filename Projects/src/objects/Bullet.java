package objects;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import objects.Interface.X_y;

public class Bullet extends X_y {
    public double damage;
    public double speed;
    public Image image;
    public Tank tank;
    public boolean hit = false;

    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(image);
        iv.setFitWidth(5);
        iv.setFitHeight(5);
        Image bImg = iv.snapshot(params, null);

        gc.drawImage(bImg, x, y);
    }

    public void update() {
        if (Math.abs(x-tank.x + y-tank.y) < 20)  hit = true;

        x += Math.round( (tank.x-x)*speed/Math.abs(tank.x-x + tank.y-y) );
        y += Math.round( (tank.y-y)*speed/Math.abs(tank.x-x + tank.y-y) );
    }
}

