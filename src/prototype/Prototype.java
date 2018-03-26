package prototype;

public class Prototype {
    public static void main(String[] args) throws CloneNotSupportedException {
        Fruit apple1 = new Fruit("苹果", "红", 1);
        Fruit apple2 = apple1.cloneFruit();
        System.out.println(apple2);
    }
}

class Fruit implements Cloneable {
    private String name;

    private String color;

    private int kilogram;

    public Fruit(String name, String color, int kilogram) {
        this.name = name;
        this.color = color;
        this.kilogram = kilogram;
    }

    @Override
    public String toString() {
        return "Fruit{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", kilogram=" + kilogram +
                '}';
    }

    //自己写的拷贝方法
    public Fruit cloneFruit() {
        return new Fruit(this.name, this.color, this.kilogram);
    }
}

