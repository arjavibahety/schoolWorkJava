import java.util.*;

public class TextEditor {
    private List<TextFormatter> _formatter;
    private ArrayList<String> strings = new ArrayList<>();
    private PriorityQueue<TextFormatter> sorting = new PriorityQueue<>();

    public TextEditor(List<TextFormatter> formatter) {
        _formatter = formatter;
        for(TextFormatter f : formatter) {
            sorting.add(f);
        }
    }

    public void addString(String s) {
        strings.add(s);
    }

    public void printAll() {
        int queueSize = sorting.size();
        for(int i = 0; i < queueSize; i++) {
            System.out.println(sorting.poll().format());
        }
    }
}
