import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<TextFormatter> formatter = new ArrayList<>();
        while(sc.hasNextLine()) {
            String input = sc.nextLine();
            formatter.add(new SnakeCase(input));
            formatter.add(new KebabCase(input));
            formatter.add(new PascalCase(input));
            formatter.add(new MixedFormatter(input));
        }

        TextEditor txt = new TextEditor(formatter);
        txt.printAll();
    }
}
