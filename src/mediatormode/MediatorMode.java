package mediatormode;

public class MediatorMode {
    public static void main(String[] args) {
        //定义两个国家
        Country usa = new USA();
        Country china = new China();

        //定义中介者
        Union union = new Union();

        //为国家和中介者之间建立起关系
        usa.setUnion(union);
        china.setUnion(union);
        union.setChina(china);
        union.setUsa(usa);

        //国家之间对话
        china.sendMessage("美国你好啊");
        usa.sendMessage("好的好的，中国你也好啊");
    }
}

/**
 * 国家接口
 */
interface Country {

    void setUnion(Mediator mediator);

    void sendMessage(String message);

    void getMessage(String message);
}

class USA implements Country {

    private Mediator union;

    @Override
    public void setUnion(Mediator union) {
        this.union = union;
    }

    @Override
    public void sendMessage(String message) {
        union.sendMessage(this, message);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("usa接收到了消息，消息内容为:" + message);
    }
}

class China implements Country {

    private Mediator union;

    @Override
    public void setUnion(Mediator union) {
        this.union = union;
    }

    @Override
    public void sendMessage(String message) {
        union.sendMessage(this, message);
    }

    @Override
    public void getMessage(String message) {
        System.out.println("china接收到了消息，消息内容为:" + message);
    }


}

/**
 * 中介者
 */
interface Mediator {
    void sendMessage(Country country, String message);
}

/**
 * 联合国
 */
class Union implements Mediator {
    private Country china;
    private Country usa;

    public void setChina(Country china) {
        this.china = china;
    }

    public void setUsa(Country usa) {
        this.usa = usa;
    }

    @Override
    public void sendMessage(Country country, String message) {
        if (country == china) {
            usa.getMessage(message);
        } else if (country == usa) {
            china.getMessage(message);
        }
    }
}
