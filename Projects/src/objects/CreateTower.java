package objects;

import javafx.scene.image.Image;

public class CreateTower {
    public Tower cre_NorTower(double x,double y){
        Tower tower = new Tower();
        tower.x = x;
        tower.y = y;
        tower.spaw = 30;
        tower.ID = 1;
        tower.image = new Image("./Image/Nor.jpg");
        tower.range = 150;
        tower.price = 50;
        return tower;
    }
    public Tower cre_EpicTower(double x,double y){
        Tower tower = new Tower();
        tower.x = x;
        tower.y = y;
        tower.spaw = 10;
        tower.ID = 2;
        tower.image = new Image("./Image/Epic.jpg");
        tower.range = 130;
        tower.price = 70;
        return tower;
    }
    public Tower cre_LegendTower(double x,double y){
        Tower tower = new Tower();
        tower.x = x;
        tower.y = y;
        tower.spaw = 50;
        tower.ID = 3;
        tower.image = new Image("./Image/Legend.png");
        tower.range = 200;
        tower.price = 100;
        return tower;
    }
}
