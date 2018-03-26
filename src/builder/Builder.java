package builder;

public class Builder {
    public static void main(String[] args) {
        //捏胖子
        PersonDirector fatMan = new PersonDirector(new FatBuilder());
        fatMan.createPerson();
        //捏瘦子
        PersonDirector thinMan = new PersonDirector(new ThinBuilder());
        thinMan.createPerson();
    }
}

/**
 * 建造者
 */
interface PersonBuilder {
    void buildHead();

    void buildBody();

    void buildArmsAndLegs();
}

class ThinBuilder implements PersonBuilder {

    @Override
    public void buildHead() {
        System.out.println("瘦子的头");
    }

    @Override
    public void buildBody() {
        System.out.println("瘦子的身体");
    }

    @Override
    public void buildArmsAndLegs() {
        System.out.println("瘦子的四肢");
    }

}

class FatBuilder implements PersonBuilder {


    @Override
    public void buildHead() {
        System.out.println("胖子的头");
    }

    @Override
    public void buildBody() {
        System.out.println("胖子的身体");
    }

    @Override
    public void buildArmsAndLegs() {
        System.out.println("胖子的四肢");
    }
}

/**
 * 指挥者
 */
class PersonDirector{
    PersonBuilder personBuilder;

    //通过构造方法来告诉指挥者要捏一个胖子还是瘦子
    public PersonDirector(PersonBuilder personBuilder) {
        this.personBuilder = personBuilder;
    }

    public void createPerson() {
        personBuilder.buildHead();
        personBuilder.buildBody();
        personBuilder.buildArmsAndLegs();
    }
}