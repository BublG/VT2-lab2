package by.bsuir.webtech.secondLab.main;

import by.bsuir.webtech.secondLab.entity.Appliance;

import java.util.List;

/**
 * PrinterApplianceInfo class.
 * Class for printing info about found appliances.
 *
 * @author Artsiom Sharakhouski
 * @version 1.0
 */
public class ApplianceInfoPrinter {

    public static void print(List<Appliance> appliances) {
        if (appliances == null) {
            System.out.println("Wrong criteria or other problems");
            return;
        }
        if (appliances.isEmpty()) {
            System.out.println("Nothing found");
            return;
        }
        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }
    }

    public static void print(Appliance appliance) {
        if (appliance == null) {
            System.out.println("Nothing found");
            return;
        }
        System.out.println(appliance);
    }
}
