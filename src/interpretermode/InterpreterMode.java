package interpretermode;

import java.util.Arrays;

public class InterpreterMode {
    public static void main(String[] args) {
        Context context = new Context();
        context.setText("1 2 3 4 5 6 7");
        Expression note = new Note();
        note.execute(context);
    }
}

/**
 * 文法表达式接口
 */
interface Expression {
    void execute(Context context);
}

/**
 * 音符类 进行具体的音符转换
 */
class Note implements Expression {

    @Override
    public void execute(Context context) {
        String[] keys = context.getText().split(" ");
        Arrays.stream(keys).forEach(key -> {
            switch (key) {
                case "1":
                    System.out.println("do");
                    break;
                case "2":
                    System.out.println("re");
                    break;
                case "3":
                    System.out.println("mi");
                    break;
                case "4":
                    System.out.println("fa");
                    break;
                case "5":
                    System.out.println("so");
                    break;
                case "6":
                    System.out.println("la");
                    break;
                case "7":
                    System.out.println("xi");
                    break;
            }
        });
    }
}

/**
 * 待解释的文本
 */
class Context {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}

