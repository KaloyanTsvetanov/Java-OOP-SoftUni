package telephony;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Smartphone implements Callable,Browsable {

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers,List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }

    @Override
    public String browse() {

        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            boolean valid = true;
            for (int i = 0; i < url.length(); i++) {
                char ch = url.charAt(i);
                if(Character.isDigit(ch)){
                    valid = false;
                    sb.append("Invalid URL!").append("\n");
                    break;
                }
            }
            if(valid){
                sb.append("Browsing: ").append(url).append("!").append("\n");
            }
        }

        return sb.toString();
    }

    @Override
    public String call() {

        StringBuilder sb = new StringBuilder();
        for (String nums : numbers) {
            boolean valid = true;
            for (int i = 0; i < nums.length(); i++) {
                char ch = nums.charAt(i);
                if(Character.isLetter(ch)){
                    valid = false;
                    sb.append("Invalid number!").append("\n");
                    break;
                }
            }
            if(valid){
                sb.append("Calling... ").append(nums).append("\n");
            }
        }

        return sb.toString().trim();
    }
}
