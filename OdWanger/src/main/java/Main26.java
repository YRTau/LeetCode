import java.util.Scanner;
import java.util.*;
import java.util.stream.Stream;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Main26 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String origin_str = in.nextLine();
        String target_str = in.nextLine().replaceAll("\\[(.*?)\\]", "[$1]");

        Pattern pattern = Pattern.compile(target_str);
        Matcher matcher = pattern.matcher(origin_str);

        System.out.println(matcher.find() ? matcher.start() :-1 );
        return;
    }
}