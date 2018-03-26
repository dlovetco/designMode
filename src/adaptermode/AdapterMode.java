package adaptermode;

public class AdapterMode {
    public static void main(String[] args) {
        Vga vga = new Host();
        vga.connectVga();
        HdmiToVga hdmiToVga = new HdmiToVga();
        hdmiToVga.connectVga();
    }
}

class Screen {
    public void connectHdmi() {
        System.out.println("显示器连接");
    }
}

interface Vga {
    void connectVga();
}

class Host implements Vga {
    @Override
    public void connectVga() {
        System.out.println("主机连接");
    }
}

/**
 * 转接口类
 */
class HdmiToVga implements Vga {
    private Screen screen = new Screen();

    @Override
    public void connectVga() {
        screen.connectHdmi();
    }
}

