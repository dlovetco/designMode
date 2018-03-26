package abstractfactory.reflect;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Properties;

public class Reflect {
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, IOException {
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
    private Properties properties = new Properties();

    Kitchen createKitchen() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        properties.load(new InputStreamReader(new FileInputStream("./src/abstractfactory/reflect/test.properties"), "utf-8"));
        String className = properties.getProperty("kitchenMean");
        return (Kitchen) Class.forName("abstractfactory.reflect." + className).newInstance();
    }

    Bedroom createBedroom() throws IOException, ClassNotFoundException, IllegalAccessException, InstantiationException {
        properties.load(new InputStreamReader(new FileInputStream("./src/abstractfactory/reflect/test.properties"), "utf-8"));
        String className = properties.getProperty("bedRoomMean");
        return (Bedroom) Class.forName("abstractfactory.reflect." + className).newInstance();
    }
}
