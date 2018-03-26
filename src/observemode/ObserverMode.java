package observemode;

import java.util.ArrayList;
import java.util.List;

public class ObserverMode {
    public static void main(String[] args) {
        Ming ming = new Ming();
        Observer gang = new Student("小刚", "打篮球", ming);
        Observer hong = new Student("小红", "画画", ming);
        ming.addObserver(gang);
        ming.addObserver(hong);
        ming.seeTeacherComing();
    }
}

/**
 * 观察者 希望得到通知的人
 */
interface Observer {
    void update();
}

/**
 * 通知者 发出通知的人
 */
interface Informer {
    void seeTeacherComing();

    String sendNotice();
}

class Ming implements Informer {

    private List<Observer> observers = new ArrayList<>();

    void addObserver(Observer observer) {
        observers.add(observer);
    }

    void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void seeTeacherComing() {
        observers.forEach(Observer::update);
    }

    @Override
    public String sendNotice() {
        return "小明说老师回来了";
    }

}

class Student implements Observer {

    public Student(String name, String action, Informer informer) {
        this.name = name;
        this.action = action;
        this.informer = informer;
    }

    String name;
    String action;
    Informer informer;

    @Override
    public void update() {
        System.out.println(informer.sendNotice() + name + "停止" + action + "认真学习");
    }
}