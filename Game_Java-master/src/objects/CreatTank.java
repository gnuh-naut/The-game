package objects;

import java.util.ArrayList;
import java.util.List;

public class CreatTank {
    public List<Tank> tanks(){
        List<Tank> list = new ArrayList<>();
        for(int i = 0; i < 5;i++){
            list.add(new Normal());
        }
        for(int i = 0;i < 5; i++){
            list.add(new Elite());
        }
        for( int i = 0;i < 5;i++){
            list.add(new Normal());
            list.add(new Normal());
            list.add(new Elite());
        }
        for(int i = 0; i < 10;i++){
            list.add(new Elite());
            list.add(new Normal());
        }
        list.add(new Boss());
        return list;
    }
}
