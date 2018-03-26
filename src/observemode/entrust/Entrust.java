package observemode.entrust;

import java.util.function.Supplier;

/**
 * 委托
 */
public class Entrust {
    public static void main(String[] args) {
        Informer ming = new Ming();
        Gang gang = new Gang(ming);
        Hong hong = new Hong(ming);
        ming.seeTeacherComing(() -> {
            gang.stopPlaying();
            hong.stopPainting();
            return null;
        });
    }
}
/**
 * 通知者 发出通知的人
 */
interface Informer {
    void seeTeacherComing(Supplier<?> supplier);

    String sendNotice();
}

class Ming implements Informer {

    @Override
    public void seeTeacherComing(Supplier<?> supplier) {
        supplier.get();
    }

    @Override
    public String sendNotice() {
        return "小明说老师回来了";
    }
}

class Gang {

    Informer informer;

    public Gang(Informer informer) {
        this.informer = informer;
    }

    void stopPlaying() {
        System.out.println(informer.sendNotice() + "小刚停止打篮球");
    }
}

class Hong {

    Informer informer;

    public Hong(Informer informer) {
        this.informer = informer;
    }

    void stopPainting() {
        System.out.println(informer.sendNotice() + "小红停止画画");
    }
}
