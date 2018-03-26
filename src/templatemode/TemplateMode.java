package templatemode;

public class TemplateMode {

    public static void main(String[] args) {
        Ming ming = new Ming();
        ming.question1();
        ming.question2();
        Gang gang = new Gang();
        gang.question1();
        gang.question2();
    }
}

abstract class Exam{
    void question1() {
        System.out.println("问题一。。。。。。。。。。");
        answerQuestion1();
    }

    abstract void answerQuestion1();

    void question2() {
        System.out.println("问题二。。。。。。。。。。");
        answerQuestion2();
    }

    abstract void answerQuestion2();
}

class Ming extends Exam {
    @Override
    void answerQuestion1() {
        System.out.println("小明回答xxxx");
    }

    @Override
    void answerQuestion2() {
        System.out.println("小明回答yyyy");
    }
}

class Gang extends Exam {

    @Override
    void answerQuestion1() {
        System.out.println("小刚回答aaaa");
    }

    @Override
    void answerQuestion2() {
        System.out.println("小刚回答bbbb");
    }
}
