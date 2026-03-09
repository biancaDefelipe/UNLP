public class Calculator {
    public void printPrimitive(String name, int age) {
        System.out.println(name + "tiene" + age + "años")
    }
    public void printObject(Person p) {
        System.out.println(p.getName() + "tiene" + p.getEdad() + "años");
    }
    printPrimitive("carla",50);
    printObject(new Person("carla", 50));

}