package path;

import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;

public class Road {

    public Path creatPath(){
        Path path = new Path();
        MoveTo moveto = new MoveTo(0,200);
        LineTo line1 = new LineTo(150,200);
        LineTo line2 = new LineTo(150,30);
        LineTo line3 = new LineTo(400,30);
        LineTo line4 = new LineTo(400,350);
        LineTo line5 = new LineTo(100,350);
        LineTo line6 = new LineTo(100,550);
        LineTo line7 = new LineTo(700,550);
        path.getElements().addAll(moveto,line1,line2,line3,line4,line5,line6,line7);
        return path;
    }
}
