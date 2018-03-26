package proxymode;

class Main {

    public static void main(String[] args) {
        ZhuiQiuZhe ming = new ZhuiQiuZhe("小明");
        BeiZhuiQiuZhe hong = new BeiZhuiQiuZhe("小红");
        DianDengPao gang = new DianDengPao(ming, "小刚");
        gang.sendGift(hong);
    }
}

/**
 * 追求者
 */
class ZhuiQiuZhe {
    //追求者姓名
    public String name;

    public ZhuiQiuZhe(String name) {
        this.name = name;
    }

    //送礼物
    public void sendGift(BeiZhuiQiuZhe beiZhuiQiuZhe) {
        System.out.println(name + "给" + beiZhuiQiuZhe.name + "送礼物");
    }
}

/**
 * 电灯泡———用于传递礼物
 */
class DianDengPao {

    //帮谁送东西
    public ZhuiQiuZhe zhuiQiuZhe;

    private String name;

    public DianDengPao(ZhuiQiuZhe zhuiQiuZhe, String name) {
        this.zhuiQiuZhe = zhuiQiuZhe;
        this.name = name;
    }

    //送礼物
    public void sendGift(BeiZhuiQiuZhe beiZhuiQiuZhe) {
        System.out.print(name + "帮助");
        zhuiQiuZhe.sendGift(beiZhuiQiuZhe);
    }
}

/**
 * 被追求者
 */
class BeiZhuiQiuZhe {
    //追求者姓名
    public String name;

    public BeiZhuiQiuZhe(String name) {
        this.name = name;
    }
}