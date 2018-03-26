package memento;

import java.util.HashMap;
import java.util.Map;

public class MementoMode {
    public static void main(String[] args) {
        Status status = new Status(100, 100, 100);
        SaveManager saveManager = new SaveManager();
        saveManager.createSave(status.save());
        System.out.println(status);
        status.attack = 0;
        status.defend = 0;
        status.hp = 0;
        System.out.println(status);
        status.load(saveManager.getSave(1));
        System.out.println(status);
    }
}

/**
 * 状态
 */
class Status {
    int attack;

    int defend;

    int hp;

    public Status(int attack, int defend, int hp) {
        this.attack = attack;
        this.defend = defend;
        this.hp = hp;
    }

    /**
     * 保存
     */
    public Save save() {
        return new Save(attack, defend, hp);
    }

    /**
     * 载入存档
     */
    public void load(Save save) {
        this.attack = save.attack;
        this.defend = save.defend;
        this.hp = save.hp;
    }

    @Override
    public String toString() {
        return "Status{" +
                "attack=" + attack +
                ", defend=" + defend +
                ", hp=" + hp +
                '}';
    }
}

class SaveManager {
    Map<Integer, Save> saveMap = new HashMap<>();

    public void createSave(Save save) {
        saveMap.put(saveMap.size() + 1, save);
    }

    public Save getSave(int num) {
        return saveMap.get(num);
    }

}

/**
 * 存档
 */
class Save {
    int attack;

    int defend;

    int hp;

    public Save(int attack, int defend, int hp) {
        this.attack = attack;
        this.defend = defend;
        this.hp = hp;
    }
}


