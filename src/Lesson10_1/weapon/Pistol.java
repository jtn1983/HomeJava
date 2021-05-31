package Lesson10_1.weapon;

public class Pistol extends Weapon {
    public Pistol() {
        this.name = "Pistol";
    }

    @Override
    public void shot() {
        System.out.println("Pistol shoots!");
    }
}
