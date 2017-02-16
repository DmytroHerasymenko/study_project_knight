package ua.study.epam.knight;

import org.junit.Test;
import ua.study.epam.equipment.Equipment;
import ua.study.epam.equipment.defenceEquipment.*;
import ua.study.epam.equipment.materialForEquipment.Material;
import ua.study.epam.forge.Forge;
import ua.study.epam.forge.ForgeImpl;
import ua.study.epam.knight.gender.Gender;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by dima on 12.02.17.
 */
public class KnightTest {
    Knight knight = new Knight(Gender.MALE, "Petro", 30);
    Forge forge = ForgeImpl.instance();
    @Test
    public void countEquipmentPriceTest() throws Exception {
        forge.createFullKnightEquipment(knight);
        int price = 0;
        for(Equipment equip : knight.getEquipment()){
            price += equip.getPrice();
        }
        assertEquals(price, knight.countEquipmentPrice());
    }

    @Test
    public void countEquipmentPriceNullTest() throws Exception {
        assertEquals(0, knight.countEquipmentPrice());
    }
    @Test
    public void sortEquipmentByWeightTest() throws Exception {

        knight.getEquipment().add(new Helmet(Material.IRON, 7, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 3, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 5, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 1, 100));
        knight.getEquipment().add(new Helmet(Material.IRON, 2, 100));

        List<Equipment> equip = new ArrayList<>();
        equip.add(knight.getEquipment().get(3));
        equip.add(knight.getEquipment().get(4));
        equip.add(knight.getEquipment().get(1));
        equip.add(knight.getEquipment().get(2));
        equip.add(knight.getEquipment().get(0));
        knight.sortEquipmentByWeight();
        assertEquals(equip,knight.getEquipment());
    }
    @Test
    public void sortEquipmentByWeightEmptyTest() throws Exception {
        List<Equipment> equip = new ArrayList<>();
        knight.sortEquipmentByWeight();
        assertEquals(equip, knight.getEquipment());
    }

    @Test
    public void getEquipmentByPriceNullTest() throws Exception {
        List<Equipment> equip = new ArrayList<>();
        assertEquals(equip, knight.getEquipmentByPrice());
    }
}