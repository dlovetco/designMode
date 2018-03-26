package factorymode;

class Main {
    public static void main(String[] args) {
        Factory plusFactory = new PlusFactory();//定义一个加法工厂
        CalculateMode plus = plusFactory.getCalculate();
        System.out.println(plus.calculate(1, 2));

        Factory minusFactory = new MinusFactory();//定义一个减法工厂
        CalculateMode minus = minusFactory.getCalculate();
        System.out.println(minus.calculate(1, 2));
    }
}

/**
 * 抽象工厂
 */
interface Factory {
    CalculateMode getCalculate();
}

class PlusFactory implements Factory {

    @Override
    public CalculateMode getCalculate() {
        return new Plus();
    }
}

class MinusFactory implements Factory {

    @Override
    public CalculateMode getCalculate() {
        return new Minus();
    }
}

/**
 * 计算模式
 */
interface CalculateMode {
    int calculate(int num1, int num2);
}

class Plus implements CalculateMode {

    @Override
    public int calculate(int num1, int num2) {
        return num1 + num2;
    }
}

class Minus implements CalculateMode {

    @Override
    public int calculate(int num1, int num2) {
        return num1 - num2;
    }
}