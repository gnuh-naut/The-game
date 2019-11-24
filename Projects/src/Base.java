import objects.Interface.Health;

public class Base implements Health {
    public double health = 50;
    public double coin = 200;
    public void subHealth(double damage){
        this.health = health - damage;
    }
    public void addCoin(double reward){
        this.coin = coin + reward;
    }

}
