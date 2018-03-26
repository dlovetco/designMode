package abstractfactory.simplefactory;

public class SimpleFactory {

    public static void main(String[] args) {
        DecorateFactory decorateFactory = new DecorateFactory();
        Kitchen kitchen = decorateFactory.createKitchen();
        Bedroom bedroom = decorateFactory.createBedroom();
        System.out.println(kitchen);
        System.out.println(bedroom);
    }
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

class DecorateFactory {
    private static String type = "小明";

    Kitchen createKitchen() {
        switch (type) {
            case "小明":
                return new MingKitchen();
            case "小红":
                return new HongKitchen();
            default:
                return null;
        }
    }

    Bedroom createBedroom() {
        switch (type) {
            case "小明":
                return new MingBedroom();
            case "小红":
                return new HongBedroom();
            default:
                return null;
        }
    }
}
