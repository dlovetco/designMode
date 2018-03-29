package visitormode;

public class VisitorMode {
    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();
        Action success = new Success();
        Action failure = new Failure();
        man.accept(success);
        man.accept(failure);
        woman.accept(success);
        woman.accept(failure);
    }
}

/**
 * 人接口
 */
interface Human {
    //人接受状态之后做出的反应
    void accept(Action action);
}

class Man implements Human {

    @Override
    public void accept(Action action) {
        action.manConclusion(this);
    }
}

class Woman implements Human {

    @Override
    public void accept(Action action) {
        action.womanConclusion(this);
    }
}

/**
 * 状态接口
 */
interface Action {
    //男人的反应
    void manConclusion(Human man);

    //女人的反应
    void womanConclusion(Human woman);
}

class Success implements Action {
    @Override
    public void manConclusion(Human man) {
        System.out.println(man.getClass().getSimpleName() + "成功的时候背后有个伟大的女人");
    }

    @Override
    public void womanConclusion(Human woman) {
        System.out.println(woman.getClass().getSimpleName() + "成功的时候背后有个不成功的男人");
    }
}

class Failure implements Action {

    @Override
    public void manConclusion(Human man) {
        System.out.println(man.getClass().getSimpleName() + "失败时闷头喝酒");
    }

    @Override
    public void womanConclusion(Human woman) {
        System.out.println(woman.getClass().getSimpleName() + "失败时默默流泪");
    }
}
