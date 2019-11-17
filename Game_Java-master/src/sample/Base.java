package sample;
import objects.Interface.Health;

public class Base implements Health {
    public double health = 50;
    public double coin = 15;
    public void subHealth(double damage){
        health = health - damage;
    }
    public void addCoin(double reward){
        coin = coin + reward;
    }
}
