package path;

public class ListPoint {
    public Point[] listPoint = new Point[]{
            new Point(135,185),
            new Point(135,15),
            new Point(385,15),
            new Point(385,335),
            new Point(85,335),
            new Point(85,535),
            new Point(690,535)
    };
//  Tinh khoang cach den diem xoay tiep theo
    public double distance(double x,double y,double x1,double y1){
        return Math.sqrt((x - x1)*(x-x1) + (y - y1)*(y - y1));
    }
}
