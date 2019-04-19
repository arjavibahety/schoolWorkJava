import java.util.*;

public class KebabCase implements TextFormatter {
    private String sentence;
    public KebabCase(String s) {
        sentence = s;
    }

    public TextFormatter clone(String s) {
        return null;
    }

    @Override
        public String format() {
            String[] strings = sentence.split(" ");
            StringBuilder str = new StringBuilder();
            str.append(strings[0].toLowerCase());
            for(int i = 1; i < strings.length; i++) {
                str.append("-" + strings[i].toLowerCase()); 
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

//Split string using Regex
/*public static String[] splitString(String string) {
  return string.split(" ");
  } 

  public static String wordToLowerCase(String word) {
  return word.toLowerCase();
  }*/
