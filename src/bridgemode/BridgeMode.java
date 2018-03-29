package bridgemode;

public class BridgeMode {
    public static void main(String[] args) {
        //安卓手机玩游戏
        Brand android = new AndroidPhone();
        android.run(new Game());

        //苹果手机看电影
        Brand apple = new ApplePhone();
        apple.run(new VideoPlayer());
    }
}

/**
 * 手机品牌
 */
interface Brand {
    //每个手机都需要运行软件
    void run(Software software);
}

class AndroidPhone implements Brand{

    @Override
    public void run(Software software) {
        System.out.print("安卓手机");
        software.run();
    }
}

class ApplePhone implements Brand{

    @Override
    public void run(Software software) {
        System.out.print("苹果手机");
        software.run();
    }
}

/**
 * 不同的软件
 */
interface Software {
    //不同手机软件运行效果
    void run();
}

class Game implements Software{

    @Override
    public void run() {
        System.out.println("玩游戏");
    }
}

class VideoPlayer implements Software{

    @Override
    public void run() {
        System.out.println("播放电影");
    }
}