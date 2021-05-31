package Lesson10_1.weapon;

public class WaterPistol extends Weapon {
    public WaterPistol() {
        this.name = "Water pistol";
    }

    @Override
    public void shot() {
        System.out.println("Water pistol shoots!");
    }
}
