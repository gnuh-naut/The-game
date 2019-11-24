import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import objects.*;
import path.ListPoint;

import java.util.ArrayList;
import java.util.List;

public class Main extends Application {
    public static  void main (String[] args){
        Application.launch(args);
    }
    List<Tower> towerList = new ArrayList<>();
    List<Tank> tankList = new ArrayList<>();
    List<Tank> tanks = new ListTank().tanks();
    CreateTower createTower = new CreateTower();
    CreateBullet createBullet = new CreateBullet();
    GraphicsContext gc;
    Tank tank;
    int quantity = tankList.size();
    int count = 0;
    int time = 0;
    Base base = new Base();
    int [] timeB = new int[10];
    int flag1 = 0;
    int flag2 = 0;
    int flag3 = 0;
    int flag = 0;
    int again = 0;



    public void start(Stage stage) throws Exception{

        Button button1 = new Button("Normal");
        button1.setPrefWidth(60);
        button1.setLayoutX(100);
        button1.setLayoutY(651);
        ImageView iv1 = new ImageView(new Image("./Image/Nor1.jpg",60,70,true,true));
        iv1.setX(100);
        iv1.setY(677);
        Button button2 = new Button("Epic");
        button2.setPrefWidth(60);
        button2.setLayoutX(170);
        button2.setLayoutY(651);
        ImageView iv2 = new ImageView(new Image("./Image/Epic1.jpg",60,70,true,true));
        iv2.setX(170);
        iv2.setY(677);
        Button button3 = new Button("Legend");
        button3.setPrefWidth(60);
        button3.setLayoutX(240);
        button3.setLayoutY(651);
        ImageView iv3 = new ImageView(new Image("./Image/Legend1.png",60,70,true,true));
        iv3.setX(240);
        iv3.setY(677);
        Button button = new Button("X");
        button.setLayoutX(310);
        button.setLayoutY(670);
        Text textCoin = new Text("$$$ " + (int)base.coin);
        textCoin.setLayoutX(10);
        textCoin.setLayoutY(660);
        Text textHealth = new Text(("Health " + (int)base.health));
        textHealth.setLayoutX(10);
        textHealth.setLayoutY(700);

        Button buttonAgain = new Button("Play Again");
        buttonAgain.setLayoutX(350);
        buttonAgain.setLayoutY(670);

        Canvas canvas = new Canvas(700,650);
        gc = canvas.getGraphicsContext2D();

        Group group = new Group();
        if(flag == 1){
            ImageView imageView = new ImageView(new Image("./Image/game_over.png"));
            imageView.setX(200);
            imageView.setY(200);
            group.getChildren().add(imageView);
        }
        group.getChildren().addAll(canvas, textCoin,textHealth,button1,button2,button3,button,iv1,iv2,iv3,buttonAgain);

        Scene scene1 = new Scene(group,700,750);


        stage.setScene(scene1);
        stage.setTitle("Tower Defense");
        stage.show();
        PauseTransition pause = new PauseTransition();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long l) {
                if(flag == 1){
                    drawLose(gc);
                }
                if(flag == 2){
                    drawWin(gc);
                }
                buttonAgain.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent mouseEvent) {
                        flag = 0;
                        tankList.clear();
                        towerList.clear();
                        base.health = 50;
                        base.coin = 200;
                    }
                });

                if (flag == 0) {
                    drawMap(gc);
                    render();
                    update();
                    if(base.health <= 0) {
                        flag = 1;
                    }
                    textCoin.setText("$$$   " + (int) base.coin);
                    textHealth.setText("Health  " + (int) base.health);
                    // Thời gian sinh tank
                    if (time >= 400 && count <= 55) {
                        try {
                            tankList.add(tanks.get(count++));
                        } catch (Exception e) {
                        }
                        time = 0;
                    }
                    //Kiểm tra tank
                    int iT = 0;
                    while (iT < tankList.size()) {
                        if(iT == 55){
                            if (tankList.get(iT).idDead()) {
                                flag = 2;
                            }
                        }
                        if (tankList.get(iT).idDead()) {
                            base.addCoin(tankList.get(iT).reward);
                            tankList.remove(iT);
                        } else if (tankList.get(iT).pass()) {
                            tankList.remove(iT);
                            base.subHealth(tankList.get(iT).attack);
                        } else iT++;
                    }
                    //chon trụ
                    button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            flag1 = 1;
                        }
                    });
                    button2.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            flag2 = 1;
                        }
                    });
                    button3.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            flag3 = 1;
                        }
                    });
                    //hủy chọn
                    button.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            flag1 = 0;
                            flag2 = 0;
                            flag3 = 0;
                        }
                    });
                    //đặt trụ
                    canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent mouseEvent) {
                            double x = mouseEvent.getX();
                            double y = mouseEvent.getY();
                            if (flag1 == 1)
                                if (base.coin >= 50) {
                                    Tower tower = createTower.cre_NorTower(x, y);
                                    towerList.add(tower);
                                    base.coin -= tower.price;
                                    flag1 = 0;
                                } else {
                                    flag1 = 0;
                                }
                            if (flag2 == 1)
                                if (base.coin >= 70) {
                                    Tower tower = createTower.cre_EpicTower(x, y);
                                    towerList.add(tower);
                                    base.coin -= tower.price;
                                    flag2 = 0;
                                } else {
                                    flag2 = 0;
                                }
                            if (flag3 == 1)
                                if (base.coin >= 100) {
                                    Tower tower = createTower.cre_LegendTower(x, y);
                                    towerList.add(tower);
                                    base.coin -= tower.price;
                                    flag3 = 0;
                                } else {
                                    flag3 = 0;
                                }
                        }
                    });
                    //sinh đạn
                    for (int tower = 0; tower < towerList.size(); tower++) {
                        ImageView view = new ImageView(towerList.get(tower).image);
                        view.setOnMouseClicked(new EventHandler<MouseEvent>() {
                            @Override
                            public void handle(MouseEvent mouseEvent) {
                                System.out.println("1");
                            }
                        });
                        iT = 0;
                        if (timeB[tower] > towerList.get(tower).spaw) {
                            while (iT < tankList.size()) {
                                double xEnemy = tankList.get(iT).x;
                                double yEnemy = tankList.get(iT).y;
                                double distance = ListPoint.distance(towerList.get(tower).x + 20, towerList.get(tower).y + 20, xEnemy, yEnemy);
                                if (distance <= towerList.get(tower).range) {
                                    timeB[tower] = 0;
                                    if (towerList.get(tower).ID == 1)
                                        towerList.get(tower).bulletList.add(createBullet.cre_NorBullet(towerList.get(tower).x, towerList.get(tower).y, tankList.get(iT)));
                                    if (towerList.get(tower).ID == 2)
                                        towerList.get(tower).bulletList.add(createBullet.cre_EpicBullet(towerList.get(tower).x, towerList.get(tower).y, tankList.get(iT)));
                                    if (towerList.get(tower).ID == 3)
                                        towerList.get(tower).bulletList.add(createBullet.cre_LegendBullet(towerList.get(tower).x, towerList.get(tower).y, tankList.get(iT)));
                                    break;
                                }
                                iT++;
                            }
                        }
                        int iB = 0;
                        while (iB < towerList.get(tower).bulletList.size()) {
                            if (towerList.get(tower).bulletList.get(iB).hit) {
                                towerList.get(tower).bulletList.get(iB).tank.subHealth(towerList.get(tower).bulletList.get(iB).damage);
                                towerList.get(tower).bulletList.remove(iB);
                            } else iB++;
                        }
                        timeB[tower]++;
                    }

                    time += 6;
                }
            }
        };
        timer.start();

    }
    public void drawWin(GraphicsContext gc){
        gc.drawImage(new Image("./win.jpg"),150,200);
    }
    public void drawLose(GraphicsContext gc){
        gc.drawImage(new Image("./game_over.png"),200,200);
    }
    public void drawMap(GraphicsContext gc){
        gc.drawImage(new Image("./Image/map.png"),0,0);
        gc.drawImage(new Image("./Image/road.png"),0,180,135,50);
        gc.drawImage(new Image("./Image/road.png"),135,15,50,215);
        gc.drawImage(new Image("./Image/road.png"),185,15,250,50);
        gc.drawImage(new Image("./Image/road.png"),385,65,50,270);
        gc.drawImage(new Image("./Image/road.png"),85,335,350,50);
        gc.drawImage(new Image("./Image/road.png"),85,335,50,200);
        gc.drawImage(new Image("./Image/road.png"),85,535,615,50);
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
}
