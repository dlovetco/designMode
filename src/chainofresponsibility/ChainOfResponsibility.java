package chainofresponsibility;

public class ChainOfResponsibility {
    public static void main(String[] args) {
        //初始化三个人
        Manager leader = new Leader();
        Manager director = new Director();
        Manager boss = new Boss();

        //设置彼此之间的上下级关系
        leader.setSuperManager(director);
        director.setSuperManager(boss);

        //处理小明请假的事情 等级为10
        leader.dealThings(10);
    }
}

/**
 * 管理者接口
 */
interface Manager {
    //根据事情能级处理
    void dealThings(int level);

    void setSuperManager(Manager manager);
}

/**
 * 组长
 */
class Leader implements Manager {
    private Manager superManager;

    //设置上级
    @Override
    public void setSuperManager(Manager manager) {
        superManager = manager;
    }

    @Override
    public void dealThings(int level) {
        if (level < 5) {
            System.out.println("组长成功处理事情");
        } else {
            //处理不了则上抛
            superManager.dealThings(level);
        }
    }
}

/**
 * 经理
 */
class Director implements Manager{
    private Manager superManager;

    //设置上级
    @Override
    public void setSuperManager(Manager manager) {
        superManager = manager;
    }

    @Override
    public void dealThings(int level) {
        if (level < 8) {
            System.out.println("经理成功处理事情");
        } else {
            //处理不了则上抛
            superManager.dealThings(level);
        }
    }
}
class Boss implements Manager{
    @Override
    public void dealThings(int level) {
        System.out.println("总经理成功处理事情");
    }

    @Override
    public void setSuperManager(Manager manager) {
        System.out.println("boss无上级");
    }
}
