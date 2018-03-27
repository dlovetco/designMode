package singleton;

public class Singleton {
    public static void main(String[] args) {

    }
}

/**
 * 懒汉式 所谓懒汉即只有当需要这个对象的时候才会去生成
 */
class Singleton1 {
    private static Singleton1 singleton1;

    private Singleton1() {

    }

    public static Singleton1 getInstance() {
        if (singleton1 == null) {
            singleton1 = new Singleton1();
        }
        return singleton1;
    }
}

/**
 * 饿汉式 所谓饿汉就是即使系统不需要类中已经迫不及待的生成对象等待系统调用了
 */
class Singleton2 {
    private static Singleton2 singleton2 = new Singleton2();

    private Singleton2() {

    }

    public static Singleton2 getInstance() {
        return singleton2;
    }
}

/**
 * 考虑到多线程中单例 则需要考虑到锁机制(只有饱汉式才需要考虑多线程情况)
 *
 */
class Singleton3 {
    private static Singleton3 singleton3;

    private Singleton3() {

    }

    //不建议这么写。在低版本jdk中都不能够保证正确性
//    public static Singleton3 getInstance() {
//        if (singleton3 == null) {
//            synchronized (Singleton3.class){
//                if (singleton3 == null) {
//                    singleton3 = new Singleton3();
//                }
//            }
//
//        }
//        return singleton3;
//    }
    //取而代之应该用这种简单的写法
    public static synchronized Singleton3 getSingleton3() {
        if (singleton3 == null) {
            singleton3 = new Singleton3();
        }
        return singleton3;
    }
}

/**
 * 静态内部类
 */
class Singleton4 {
    private Singleton4() {

    }

    public static Singleton4 getInstance() {
        return innerSingleton4.singleton4;
    }

    private static class innerSingleton4{
        private static Singleton4 singleton4 = new Singleton4();
    }
}

/**
 * 枚举类 极力推荐这种写法 简单暴力不怕反射~~~
 */
enum  Singleton5 {
    SINGLETON;
}
