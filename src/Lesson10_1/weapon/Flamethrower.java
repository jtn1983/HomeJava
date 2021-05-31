package Lesson10_1.weapon;

public class Flamethrower extends Weapon {
    public Flamethrower() {
        this.name = "Flamethrower";
    }

    @Override
    public void shot() {
        System.out.println("Flamethrower shoots!");
    }
}
