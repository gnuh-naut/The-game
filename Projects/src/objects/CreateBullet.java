package objects;

import javafx.scene.image.Image;

public class CreateBullet  {
    public Bullet cre_NorBullet(double x,double y,Tank tank){
        Bullet bullet = new Bullet();
        bullet.damage = 15;
        bullet.speed = 13;
        bullet.tank = tank;
        bullet.x = x + 20;
        bullet.y = y + 20;
        bullet.image = new Image("./Image/NorBullet.png");
        return bullet;
    }
    public Bullet cre_EpicBullet(double x,double y,Tank tank){
        Bullet bullet = new Bullet();
        bullet.damage = 10;
        bullet.speed = 15;
        bullet.tank = tank;
        bullet.x = x + 20;
        bullet.y = y + 20;
        bullet.image = new Image("./Image/EpicBullet.png");
        return bullet;
    }public Bullet cre_LegendBullet(double x,double y,Tank tank){
        Bullet bullet = new Bullet();
        bullet.damage = 50;
        bullet.speed = 15;
        bullet.tank = tank;
        bullet.x = x + 20;
        bullet.y = y + 20;
        bullet.image = new Image("./Image/LegendBullet.png");
        return bullet;
    }
}
