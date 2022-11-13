package collectionHierarchy;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String element) {
        if(items.size()<maxSize){
            items.add(element);
        }
        return items.indexOf(element);
    }
}
