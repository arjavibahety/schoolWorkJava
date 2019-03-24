import java.util.*;

public class MixedFormatter implements TextFormatter {
    private String word;
    private int choosing;

    public MixedFormatter(String s) {
        word = s;
    }



    public String format() {
        char character = word.charAt(0);
        int choosing = ((int) character) % 3;
        TextFormatter t = new SnakeCase("I Love CS2030");
        String tString = t.format();
        TextFormatter calling;

        if(choosing == 0) {
            calling = new SnakeCase(word);
        } else if(choosing == 1) {
            calling = new KebabCase(word);
        } else {
            calling = new PascalCase(word);
        }

        if(getASCII(t.format()) < getASCII(calling.format())) {
            return calling.format();
        } else {
            return t.format();
        }

    }

    public TextFormatter clone(String s) {
        return null;
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
