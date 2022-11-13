package randomArrayList;

import java.util.ArrayList;
import java.util.Random;

public class RandomArrayList extends ArrayList <Object>{

    public Object getRandomElement(){
        Random random = new Random();

        int i = random.nextInt(super.size());
        return remove(i);
    }
}
