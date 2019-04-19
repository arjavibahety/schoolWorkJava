import java.util.*;

public class PascalCase implements TextFormatter {
    private String sentence;
    public PascalCase(String s) {
        sentence = s;
    }

    public TextFormatter clone(String s) {
        return null;
    }

    @Override
        public String format() {
            String[] strings = sentence.split(" ");
            StringBuilder str = new StringBuilder();
            String temp = strings[0].toLowerCase();
            str.append(temp.substring(0, 1).toUpperCase() + temp.substring(1));
            for(int i = 1; i < strings.length; i++) {
                temp  =strings[i].toLowerCase();
                str.append(temp.substring(0, 1).toUpperCase() + temp.substring(1));
            }
            return str.toString();
        }

    public int getASCII(String word) {
        int thisASCII = 0;
        for(int i = 0; i < word.length(); i++) {
            char character = word.charAt(i);
            thisASCII += (int) character;
        }
        return thisASCII;
    }

    public int compareTo(TextFormatter tr) {
        int a = getASCII(this.format());
        int b = getASCII(tr.format());
        if(a < b) {
            return -1;
        } else if(a == b) {
            return 0;
        } else {
            return 1;
        }
    }
}
