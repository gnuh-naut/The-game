package path;

public enum Direction {
    Left(180),Up(270),Right(0),Down(90);
    int rotation;
    Direction(int i){
        this.rotation = i;
    }
    public int getRotation(){
         return rotation;
    }
}
