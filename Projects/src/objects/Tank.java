package objects;

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
    public double attack;
    public Direction direction;
    public double x;
    public double y;
    public int reward;
    public int wayPointIndex = 0;
    public ListPoint points = new ListPoint();
    public double spaceHealth;

    public void subHealth(double damage){
        this.health = this.health - damage;
    }

    public boolean idDead(){
        return health <= 0;
    }

    public Point getNextPoint() {
        if (wayPointIndex < points.listPoint.length - 1)
            return points.listPoint[++wayPointIndex];
        return null;
    }

    public void render(GraphicsContext gr){
        SnapshotParameters snapshotParameters = new SnapshotParameters();
        snapshotParameters.setFill(Color.TRANSPARENT);
        ImageView imageView = new ImageView(image);
        imageView.setRotate(this.direction.getRotation());
        Image tank = imageView.snapshot(snapshotParameters,null);
        gr.drawImage(tank,x,y);
        gr.setFill(Color.GREEN);
        gr.fillRect(x, y-4, health/spaceHealth, 2);
    }
    public boolean pass(){
        return (x>=690&&y>=535);
    }

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
