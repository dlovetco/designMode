package commandmode;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class CommandMode {
    public static void main(String[] args) {
        String customer = "小明";
        Waiter waiter = new Waiter();//服务员
        Chef chef = new Chef();//厨师
        Order meatOrder = new MeatOrder(chef);
        waiter.addOrder(customer, meatOrder);
        waiter.addOrder(customer, new VegetableOrder(chef));
        waiter.removeOrder(customer,meatOrder);
        waiter.excuteOrders();
    }
}

/**
 * 各种各样的订单
 */
interface Order {
    //执行订单
    void excuteOrder();
}

class VegetableOrder implements Order {

    private Chef chef;

    public VegetableOrder(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void excuteOrder() {
        chef.cookVegetable();
    }

    @Override
    public String toString() {
        return "点了一串蔬菜,时间为：  " + LocalTime.now();
    }
}

class MeatOrder implements Order {

    private Chef chef;

    public MeatOrder(Chef chef) {
        this.chef = chef;
    }

    @Override
    public void excuteOrder() {
        chef.cookMeat();
    }

    @Override
    public String toString() {
        return "点了一串肉,时间为：  " + LocalTime.now();
    }
}

/**
 * 厨师
 */
class Chef {

    public void cookMeat() {
        System.out.println("厨师烤了一串肉");
    }

    public void cookVegetable() {
        System.out.println("厨师烤了一串蔬菜");
    }
}

class Waiter {
    private List<Order> orderList = new ArrayList<>();

    public void addOrder(String name, Order order) {
        System.out.println(name + "点了" + order.toString());
        orderList.add(order);
    }

    public void removeOrder(String name, Order order) {
        System.out.println(name + "取消" + order.toString());
        orderList.remove(order);
    }

    /**
     * 整个菜单交给厨师开始制作
     */
    public void excuteOrders() {
        orderList.forEach(Order::excuteOrder);
    }
}

