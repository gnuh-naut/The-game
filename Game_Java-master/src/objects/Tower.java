package objects;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.List;

public class Tower {
     public double x,y;
     public double width, height;
     public double range;
     public Image image ;
     public String text;
     public int ID;
     public double spaw;
     public List<Bullet> bulletList = new ArrayList<>();
     public Tower(double width,double height,double range,String text,int id){
         image = new Image(text);
         this.height = height;
         this.width = width;
         this.range = range;
         this. ID =id;
         this.spaw = 70;
     }

    public void render(GraphicsContext gc) {
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        ImageView iv = new ImageView(image);
        iv.setFitWidth(65);
        iv.setFitHeight(75);
        Image tImg = iv.snapshot(params, null);

        gc.drawImage(tImg, x+8, y+3);
        gc.setFill(Color.RED);
        gc.fillOval(x, y, 10, 10);
    }

    public void  update(){

    }

}
