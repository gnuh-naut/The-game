package objects;

import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import objects.Interface.Health;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import path.Direction;
import path.ListPoint;
import path.Point;

public class Tank implements Health {
    public double speed;
    public double health;
    public int width,height;
    public String text;
    public Image image;
    public ImageView imageView;
    public double attack;
    public Direction direction;
    public double x;
    public double y;
    public int wayPointIndex = 0;
    public ListPoint points = new ListPoint();
// Khoi tao
    public Tank(double speed, double health, String text, int width, int height, double attack,double x,double y) {
        this.speed = speed;
        this.health = health;
        image = new Image(text, width, height, true, true);
        imageView = new ImageView(image);
        this.attack = attack;
        this.x = x;
        this.y = y;
        this.direction = Direction.Right;
    }
//  Tru mau
    public void subHealth(double damage){
        this.health = this.health - damage;
    }
//  Con song hay khong
    public boolean idDead(){
        return health <= 0;
    }
//  Lay diem tiep theo
    public Point getNextPoint() {
        if (wayPointIndex < points.listPoint.length - 1)
            return points.listPoint[++wayPointIndex];
        return null;
    }
//  Ve hinh
    public void render(GraphicsContext gr){
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        imageView.setRotate(this.direction.getRotation());
        Image tank = imageView.snapshot(snapshotParameters,null);
        gr.drawImage(tank,x,y);

    }
//  Tinh huong xoay
    public void calculateDirection() {
        if (wayPointIndex >= points.listPoint.length) {
            return;// Den diem cuoi thi dung lai
        }
        Point currentPoint = points.listPoint[wayPointIndex];
        if (points.distance(x, y, currentPoint.x, currentPoint.y) <= speed) {
            x = currentPoint.x;
            y = currentPoint.y;
            Point nextWayPoint = getNextPoint();
            if (nextWayPoint == null) return;
            double deltaX = nextWayPoint.x - x;
            double deltaY = nextWayPoint.y - y;
            if (deltaX > speed) this.direction = Direction.Right;
            else if (deltaX < -speed) this.direction = Direction.Left;
            else if (deltaY > speed) this.direction = Direction.Down;
            else if (deltaY <= -speed) this.direction = Direction.Up;
        }
    }
//  xoay chieu chuyen dong
    public void update() {

        calculateDirection();

        switch (this.direction) {
            case Up:
                y -= speed;
                break;
            case Down:
                y += speed;
                break;
            case Left:
                x -= speed;
                break;
            case Right:
                x += speed;
                break;
        }
    }
}
