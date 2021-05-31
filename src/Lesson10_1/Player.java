package Lesson10_1;

import Lesson10_1.weapon.*;

public class Player {

    private Weapon[] weaponSlots;

    public Player() {
        weaponSlots = new Weapon[] {
                new Bazooka(),
                new Flamethrower(),
                new Pistol(),
                new WaterPistol()
        };
        printWeaponSlots(weaponSlots);
    }

    public int getSlotsCount() {
        return weaponSlots.length;
    }

    private void printWeaponSlots(Weapon[] weaponSlots) {
        for (int i = 0; i < weaponSlots.length; i++) {
            System.out.print((i + 1) + ": " + weaponSlots[i].getName() + "; ");
        }
    }

    public void shotWithWeapon(int slot) {
        if (slot < 0 || slot >= weaponSlots.length ) {
            System.out.println("Input error! Input number must be in the range from 1 to " + weaponSlots.length);
            return;
        }
        Weapon weapon = weaponSlots[slot];
        weapon.shot();
    }
}
