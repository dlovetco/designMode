package compositemode;

import java.util.ArrayList;
import java.util.List;

public class CompositeMode {
    public static void main(String[] args) {
        Root branch1 = new Branch("branch1");
        Root branch2 = new Branch("branch2");
        Root leaf1 = new Leaf("leaf1");
        Root leaf2 = new Branch("leaf2");
        branch1.grow(branch2);
        branch2.grow(leaf1);
        branch2.grow(leaf2);
        branch1.display(1);
    }
}

interface Root {
    void grow(Root root);

    void cut(Root root);

    void display(int num);
}

class Branch implements Root {

    private String name;

    public Branch(String name) {
        this.name = name;
    }

    //每个枝条都可以看做是一个根
    private List<Root> rootList = new ArrayList<>();

    @Override
    public void grow(Root root) {
        rootList.add(root);
    }

    @Override
    public void cut(Root root) {
        rootList.remove(root);
    }

    @Override
    public void display(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println(name);
        for (Root root : rootList) {
            root.display(num + 2);
        }
    }
}

class Leaf implements Root {

    private String name;

    public Leaf(String name) {
        this.name = name;
    }

    @Override
    public void grow(Root root) {
        System.out.println("长不了东西");
    }

    @Override
    public void cut(Root root) {
        System.out.println("砍不了东西");
    }

    @Override
    public void display(int num) {
        for (int i = 0; i < num; i++) {
            System.out.print("-");
        }
        System.out.println(name);
    }
}
