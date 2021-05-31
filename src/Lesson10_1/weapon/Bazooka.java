package Lesson10_1.weapon;

public class Bazooka extends Weapon {
    public Bazooka() {
        this.name = "Bazooka";
    }

    @Override
    public void shot() {
        System.out.println("Bazooka shoots!");
    }
}
