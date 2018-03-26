package facade;

public class Facade {
    public static void main(String[] args) {
        TotalSwitch totalSwitch = new TotalSwitch();
        //打开开关
        totalSwitch.turnOn();
        //关闭开关
        totalSwitch.turnOff();
    }
}

/**
 * 总电闸
 */
class TotalSwitch {
    Switch1 switch1 = new Switch1();
    Switch2 switch2 = new Switch2();
    Switch3 switch3 = new Switch3();

    //打开开关
    void turnOn() {
        switch1.turnOn();
        switch2.turnOn();
        switch3.turnOn();
    }

    //关闭开关
    void turnOff() {
        switch1.turnOff();
        switch2.turnOff();
        switch3.turnOff();
    }
}

/**
 * 开关一
 */
class Switch1 {
    void turnOn() {
        System.out.println("打开开关1");
    }

    void turnOff() {
        System.out.println("关闭开关1");
    }
}

class Switch2 {
    void turnOn() {
        System.out.println("打开开关2");
    }

    void turnOff() {
        System.out.println("关闭开关2");
    }
}

class Switch3 {
    void turnOn() {
        System.out.println("打开开关3");
    }

    void turnOff() {
        System.out.println("关闭开关3");
    }
}