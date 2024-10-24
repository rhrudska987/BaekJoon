import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Date time = new Date();
        SimpleDateFormat Format = new SimpleDateFormat("yyyy-MM-dd");
        String now = Format.format(time);
        System.out.println(now);
    }
}