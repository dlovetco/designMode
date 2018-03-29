package iteratormode;

import java.util.ArrayList;
import java.util.List;

public class IteratorMode {
    public static void main(String[] args) {
        StudentAggregate studentAggregate = new StudentAggregate();//创建学生集合
        Iterator iterator = studentAggregate.createIterator();//创建迭代器
        studentAggregate.addStudent(new Student("小红"));
        studentAggregate.addStudent(new Student("小刚"));
        studentAggregate.addStudent(new Student("小明"));
        System.out.println(studentAggregate);
        System.out.println("迭代器开始遍历");
        System.out.println(iterator.first());
        while (iterator.hasNext()) {
            iterator.next();
            System.out.println(iterator.currentItem());
        }
    }
}

interface Iterator {
    Object next();

    Object first();

    boolean hasNext();

    Object currentItem();

}

class StudentIterator implements Iterator {
    private StudentAggregate studentAggregate;

    private int current = 0;

    public StudentIterator(StudentAggregate studentAggregate) {
        this.studentAggregate = studentAggregate;
    }

    @Override
    public Student next() {
        if (hasNext()) {
            return studentAggregate.getStudent(++current);
        }
        return null;
    }

    @Override
    public Student first() {
        if (studentAggregate != null && studentAggregate.size() > 0) {
            return studentAggregate.getStudent(0);
        }
        return null;
    }

    @Override
    public boolean hasNext() {
        return studentAggregate != null && studentAggregate.size() > 0 && studentAggregate.size() - current > 1;
    }

    @Override
    public Object currentItem() {
        return studentAggregate.getStudent(current);
    }
}

/**
 * 集合类的抽象接口
 */
interface Aggregate {
    Iterator createIterator();
}

/**
 * 表示学生的集合
 */
class StudentAggregate implements Aggregate {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public Student getStudent(int index) {
        return students.get(index);
    }

    @Override
    public Iterator createIterator() {
        return new StudentIterator(this);
    }

    public int size() {
        return students.size();
    }

    @Override
    public String toString() {
        return "StudentAggregate{" +
                "students=" + students +
                '}';
    }
}

/**
 * 学生个体
 */
class Student {
    public Student(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }
}
