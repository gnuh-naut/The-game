package sample;

import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import objects.*;
import path.Road;

import java.util.ArrayList;
import java.util.List;


public class Main extends Application {
    public static int x;
    List<Tower> towerList = new ArrayList<>();
    List<Tank> tankList = new ArrayList<>();
    List<Tank> tanks = new CreatTank().tanks();
    GraphicsContext gc;
    Tank tank;
    int quantity = tankList.size();
    int count = 0;
    int time = 0;
    Base base =new Base();
    int [] timeB = new int[10];
    public Canvas canvas = new Canvas(700,600);

    @Override
    public void start(Stage primaryStage) throws Exception {

        gc = canvas.getGraphicsContext2D();
        FXMLLoader firstPaneLoader = new FXMLLoader(getClass().getResource("main.fxml"));

        Pane firstPane = firstPaneLoader.load();

        Scene firstScene = new Scene(firstPane, 1080, 615);
;

        FXMLLoader secondPageLoader = new FXMLLoader(getClass().getResource("sample.fxml"));
        Pane secondPane = secondPageLoader.load();
        secondPane.getChildren().addAll(canvas);
        Scene secondScene = new Scene(secondPane, 1080, 720);


        ControllerMain firstPaneController = firstPaneLoader.getController();
        firstPaneController.setSecondScene(secondScene);


        Controller secondPaneController = secondPageLoader.getController();
        secondPaneController.setFirstScene(firstScene);

        primaryStage.setTitle("Tower Defense");

        primaryStage.setScene(firstScene);
        primaryStage.show();
        PauseTransition pause = new PauseTransition();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                render();
                update();
                if (time >= 600 && count <=55) {
                    tankList.add(tanks.get(count++));
                    time = 0;
                }
                int iT = 0;
                while (iT < tankList.size()) {
                    if (tankList.get(iT).idDead()) {
                        base.addCoin(tankList.get(iT).reward);
                        tankList.remove(iT);
                    } else if (tankList.get(iT).pass()) {
                        tankList.remove(iT);
                        base.subHealth(tankList.get(iT).attack);
                    } else iT++;
                }
                for (int tower = 0; iT < towerList.size(); tower++) {
                    iT = 0;
                    if (timeB[tower] > towerList.get(tower).spaw) {
                        while (iT < tankList.size()) {
                            double xEnemy = tankList.get(iT).x;
                            double yEnemy = tankList.get(iT).y;
                            double distance = Road.distance(towerList.get(iT).x, towerList.get(iT).y, xEnemy, yEnemy);
                            if (distance <= towerList.get(iT).range) {
                                timeB[tower] = 0;
                                if (towerList.get(iT).ID == 1)
                                    towerList.get(iT).bulletList.add(new Nor_Bullet());
                                if (towerList.get(iT).ID == 2)
                                    towerList.get(iT).bulletList.add(new Sniper_Bullet());
                                if (towerList.get(iT).ID == 3)
                                    towerList.get(iT).bulletList.add(new Big_Bullet());
                                break;
                            }
                            iT++;
                        }
                    }
                    int iB = 0;
                    while (iB < towerList.get(iT).bulletList.size()) {
                        if (towerList.get(iT).bulletList.get(iB).hit) {
                            towerList.get(iT).bulletList.get(iB).tank.subHealth(towerList.get(iT).bulletList.get(iB).damage);
                            towerList.get(iT).bulletList.remove(iB);
                        } else iB++;
                    }
                    timeB[iT]++;
                }
                time += 6;
            }
        };
        timer.start();

    }
    public void update() {
        towerList.forEach(bT -> bT.bulletList.forEach(Bullet::update));
        tankList.forEach(Tank::update);
        towerList.forEach(Tower::update);

    }

    public void render() {
        tankList.forEach(g -> g.render(gc));
        towerList.forEach(g -> g.render(gc));
        for (Tower towerObject : towerList) {
            for (int j = 0; j < towerObject.bulletList.size(); j++) {
                towerObject.bulletList.get(j).render(gc);
            }
        }
    }



    public static void main(String[] args) {
        launch(args);
    }
}
