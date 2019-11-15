import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Path;
import javafx.stage.Stage;
import objects.Boss;
import objects.Elite;
import objects.Normal;
import objects.Tank;
import path.Road;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static  void main (String[] args){
        Application.launch(args);
    }
    List<Tank> tankList = new ArrayList<>();
    GraphicsContext gc;
    public void start(Stage stage){
        Canvas canvas = new Canvas(700,600);
        gc = canvas.getGraphicsContext2D();

        Group group = new Group();
        Road road = new Road();
        Path path = road.creatPath();
        group.getChildren().addAll(path,canvas);

        Scene scene = new Scene(group,700,600);
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
            }
        };
        timer.start();
        tankList.add(new Normal());
        tankList.add(new Elite());
        tankList.add(new Boss());
    }
    public void update() {
        tankList.forEach(Tank::update);
    }

    public void render() {
        tankList.forEach(g -> g.render(gc));
    }
}
