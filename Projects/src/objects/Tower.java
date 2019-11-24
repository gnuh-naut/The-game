package objects;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import objects.Interface.X_y;

import java.util.ArrayList;
import java.util.List;

public class Tower extends X_y {
     public double width, height;
     public double range;
     public Image image ;
     public int ID;
     public double spaw;
     public List<Bullet> bulletList = new ArrayList<>();
     public double price;

    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(image);
        iv.setFitWidth(65);
        iv.setFitHeight(75);
        Image tImg = iv.snapshot(params, null);
        gc.drawImage(tImg, x, y);

    }

    public void  update(){
    }
}

