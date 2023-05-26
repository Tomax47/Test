public class Child {
    private String name;
    private double height;
    private double weight;
    private int age;

    public Child(String name, double height, double weight, int age) {
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.age = age;
    }

    public Child() { }

    public String getName() { return name;    }
    public void setName(String name) {        this.name = name;    }

    public double getHeight() {        return height;    }
    public void setHeight(double height) {        this.height = height;    }

    public double getWeight() {        return weight;    }
    public void setWeight(double weight) {        this.weight = weight;    }

    public int getAge() {        return age;    }
    public void setAge(int age) {        this.age = age;    }

    @Override
    public String toString() {
        return "Child{" +
                "name='" + name + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                ", age=" + age +
                '}';
    }
}