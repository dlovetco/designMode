package statemode;

public class StateMode {
    public static void main(String[] args) {
        Life life = new Life();
        life.setPeriod("青年");
        life.doThings();
    }
}

interface State {
    void doThings(Life life);
}

class Life {
    private String period;

    private State state = new Childhood();//初始化是童年

    public void doThings() {
        state.doThings(this);
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}

class Childhood implements State {

    @Override
    public void doThings(Life life) {
        //是童年就玩耍 否则自动转入青年
        if ("童年".equals(life.getPeriod())) {
            System.out.println("玩耍");
        } else {
            life.setPeriod("青年");
            life.setState(new Youth());
            life.doThings();
        }
    }
}

class Youth implements State {

    @Override
    public void doThings(Life life) {
        if ("青年".equals(life.getPeriod())) {
            System.out.println("工作");
        } else {
            life.setPeriod("老年");
            life.setState(new Elder());
            life.doThings();
        }
    }
}

class Elder implements State {

    @Override
    public void doThings(Life life) {
        if ("老年".equals(life.getPeriod())) {
            System.out.println("享受天伦之乐");
        }
    }
}

