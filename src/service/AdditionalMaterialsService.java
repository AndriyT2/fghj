package service;

import models.AdditionalMaterials;
import models.ResourceType;
import repository.AdditionalMaterialsRepository;

import java.util.Scanner;

public class AdditionalMaterialsService {
    public AdditionalMaterialsService() {
        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new  AdditionalMaterials());

    }
    public  AdditionalMaterialsService(String name, int lectureId) {
     AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new  AdditionalMaterials(name, lectureId));
    }



    public void addResourceType (int idAdditionalMaterials) {
        AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials);

        while (true) {

            Scanner scanner = new Scanner(System.in);
            System.out.println("Чи бажаєте додати елемент ResourceType до AdditionalMaterials? [Y/N]");
            String ask = scanner.nextLine();

            if (ask.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися додати елемент ResourceType до AdditionalMaterials!");
                break;

            } else if (ask.equalsIgnoreCase("y")) {

                System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());

                int ask1;

                do {
                    System.out.println("""
                            Введіть числове значення для вибору необхідного критерія:
                            1 URL;
                            2 VIDEO;
                            3 BOOK.""");
                    ask1 = scanner.nextInt();
                    scanner.nextLine();
                } while (ask1 < 1 | ask1 > 3);

                if (ask1 == 1) {
                    System.out.println("Ви створили новий компонент - URL.");
                    AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials).setResourceType(ResourceType.URL);
                    System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
                    break;

                } else if (ask1 == 2) {

                    System.out.println("Ви створили новий компонент - VIDEO.");
                    AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials).setResourceType(ResourceType.VIDEO);
                    System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
                    break;
                }else {
                    System.out.println("Ви створили новий компонент - BOOK.");
                    AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials).setResourceType(ResourceType.BOOK);
                    System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
                    break;
                }

            } else {
                throw new RuntimeException();
            }

        }
    }

}
