package objects;

import javafx.scene.image.Image;
import path.Direction;

public class CreateTank {
    public Tank cre_NorTank(){
        Tank tank = new Tank();
        tank.x = 0;
        tank.y = 185;
        tank.speed = 3;
        tank.attack = 2;
        tank.reward = 20;
        tank.health = 100;
        tank.spaceHealth = 100/26;
        tank.direction = Direction.Right;
        tank.image = new Image("./Image/Normal.png",30,30,true,true);
        return tank;
    }
    public Tank cre_EliteTank(){
        Tank tank = new Tank();
        tank.x = 0;
        tank.y = 185;
        tank.speed = 4;
        tank.attack = 3;
        tank.reward = 30;
        tank.health = 150;
        tank.spaceHealth = 150/31;
        tank.direction = Direction.Right;
        tank.image = new Image("./Image/Elite.png",35,35,true,true);
        return tank;
    }
    public Tank cre_BossTank(){
        Tank tank = new Tank();
        tank.x = 0;
        tank.y = 185;
        tank.speed = 1;
        tank.attack = 1000;
        tank.reward = 1000;
        tank.health = 300;
        tank.spaceHealth = 300/41;
        tank.direction = Direction.Right;
        tank.image = new Image("./Image/Boss.png",45,45,true,true);
        return tank;
    }
}
