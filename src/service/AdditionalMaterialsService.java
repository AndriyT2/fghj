package service;

import models.AdditionalMaterials;
import models.ResourceType;
import repository.AdditionalMaterialsRepository;

import java.util.Scanner;

public class AdditionalMaterialsService {
    public AdditionalMaterialsService() {
    }

    public  AdditionalMaterialsService(String name, int lectureId) {
     AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new  AdditionalMaterials(name, lectureId));
    }

    public void createAdditionalMaterialsService(String name, int lectureId, ResourceType resourceType) {
        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new  AdditionalMaterials(name, lectureId, resourceType));

    }

    public void sortByChoose () {
        AdditionalMaterialsRepository.getInstance().sortAdditionalMaterialsById();
        String answer;
        Scanner scanner = new Scanner(System.in);
        do{
        System.out.println("Do you want to sort AdditionalMaterials by other methods? [Y/N]");
        answer = scanner.nextLine();}
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        if (answer.equalsIgnoreCase("y")) {
            int answerMethod;
            do{
            System.out.println("""
                                    Choose the method number to sort:
                                    1 Sort by lectureId;
                                    2 Sort by resourceType.""");
            answerMethod = scanner.nextInt();
            scanner.nextLine();}
            while (answerMethod < 1 | answerMethod > 2);
            if (answerMethod == 1) {
                AdditionalMaterialsRepository.getInstance().sortAdditionalMaterialsByLectureId();
            } else {AdditionalMaterialsRepository.getInstance().sortAdditionalMaterialsByResourceType();}
        }else {
            System.out.println("You refused to change the sorting method!");
        }


    }





    public void addResourceType (int idAdditionalMaterials) {
            AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials);
            Scanner scanner = new Scanner(System.in);
            String ask;

            do {
            System.out.println("Чи бажаєте додати елемент ResourceType до AdditionalMaterials? [Y/N]");
            ask = scanner.nextLine();
            } while (!ask.equalsIgnoreCase("n") && !ask.equalsIgnoreCase("y"));


            if (ask.equalsIgnoreCase("n")) {
                System.out.println("Ви відмовилися додати елемент ResourceType до AdditionalMaterials!");

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

                } else if (ask1 == 2) {

                    System.out.println("Ви створили новий компонент - VIDEO.");
                    AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials).setResourceType(ResourceType.VIDEO);
                    System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
                }else {
                    System.out.println("Ви створили новий компонент - BOOK.");
                    AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials).setResourceType(ResourceType.BOOK);
                    System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
                }

            }
    }

}
