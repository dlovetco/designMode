package abstractfactory;

public class AbstractFactory {

    public static void main(String[] args) {
        //先使用小明的方法
        Kitchen kitchen = new MingDecorate().decorateKitchen();
        Bedroom bedroom = new MingDecorate().decorateBedroom();
        System.out.println(kitchen);
        System.out.println(bedroom);

        //再使用小红的方法
        kitchen = new HongDecorate().decorateKitchen();
        bedroom = new HongDecorate().decorateBedroom();
        System.out.println(kitchen);
        System.out.println(bedroom);
    }
}

/**
 * 装饰方法
 */
interface DecorateFactory {

    Bedroom decorateBedroom();

    Kitchen decorateKitchen();
}

/**
 * 未被装修的厨房
 */
interface Kitchen {

}

class MingKitchen implements Kitchen {
    @Override
    public String toString() {
        return "小明装修出来的厨房";
    }
}

class HongKitchen implements Kitchen {
    @Override
    public String toString() {
        return "小红装修出来的厨房";
    }
}

interface Bedroom {

}

class MingBedroom implements Bedroom {
    @Override
    public String toString() {
        return "小明装修出来的卧室";
    }
}

class HongBedroom implements Bedroom {
    @Override
    public String toString() {
        return "小红装修出来的卧室";
    }
}


class MingDecorate implements DecorateFactory {

    @Override
    public Bedroom decorateBedroom() {
        return new MingBedroom();
    }

    @Override
    public Kitchen decorateKitchen() {
        return new MingKitchen();
    }
}

class HongDecorate implements DecorateFactory {

    @Override
    public Bedroom decorateBedroom() {
        return new HongBedroom();
    }

    @Override
    public Kitchen decorateKitchen() {
        return new HongKitchen();
    }
}
