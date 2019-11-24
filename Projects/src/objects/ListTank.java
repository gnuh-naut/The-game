package objects;

import java.util.ArrayList;
import java.util.List;

public class ListTank {
    CreateTank createTank = new CreateTank();
    public List<Tank> tanks(){
        List<Tank> list = new ArrayList<>();
        for(int i = 0; i < 5;i++){
            list.add(createTank.cre_NorTank());
        }
        for(int i = 0;i < 5; i++){
            list.add(createTank.cre_EliteTank());
        }
        for( int i = 0;i < 5;i++){
            list.add(createTank.cre_NorTank());
            list.add(createTank.cre_NorTank());
            list.add(createTank.cre_EliteTank());
        }
        for(int i = 0; i < 10;i++){
            list.add(createTank.cre_EliteTank());
            list.add(createTank.cre_NorTank());
        }
        list.add(createTank.cre_BossTank());
        return list;
    }
}
