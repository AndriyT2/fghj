package service;

import models.AdditionalMaterials;
import models.ResourceType;
import repository.AdditionalMaterialsRepository;
import utility.ScannerThis;
import utilityLog.LogFactory;

import java.util.NoSuchElementException;

public class AdditionalMaterialsService {
    public AdditionalMaterialsService() {
    }

    public  AdditionalMaterialsService(String name, int lectureId) {
     AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new  AdditionalMaterials(name, lectureId));
    }

    public void createAdditionalMaterialsService(String name, int lectureId) {
        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new  AdditionalMaterials(name, lectureId));
    }

    public void createAdditionalMaterialsService(String name, int lectureId, ResourceType resourceType) {
        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new  AdditionalMaterials(name, lectureId, resourceType));

    }

    public void sortByChoose () {
        AdditionalMaterialsRepository.getInstance().sortAdditionalMaterialsById();
        String answer;
        do{
        System.out.println("Do you want to sort AdditionalMaterials by other methods? [Y/N]");
        answer = ScannerThis.getInstance().nextLine();}
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        if (answer.equalsIgnoreCase("y")) {
            int answerMethod;
            do{
            System.out.println("""
                                    Choose the method number to sort:
                                    1 Sort by lectureId;
                                    2 Sort by resourceType.""");
            answerMethod = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();}
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
            String ask;

            do {
            System.out.println("Чи бажаєте додати елемент ResourceType до AdditionalMaterials? [Y/N]");
            ask = ScannerThis.getInstance().nextLine();
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
                    ask1 = ScannerThis.getInstance().nextInt();
                    ScannerThis.getInstance().nextLine();
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

    public void removeAdditionalMaterialsMenu(int lectureId) {

                boolean flag = false;
                for (AdditionalMaterials  additionalMaterials : AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList()) {
                    if (additionalMaterials.getLectureId() == lectureId) {
                        flag = true;
                        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().remove(additionalMaterials);
                    break;}
                }
                if (!flag) {

                    NoSuchElementException e = new NoSuchElementException();
                    LogFactory.warning(this.getClass().getName(), "Id don't exist", e.getStackTrace());
                    throw e;
                }

                System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());
    }

    public void shoveAdditionalMaterialsTreeMapWithOptions() { //  перевірити правопис
        System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());
        String answer;
        do{
            System.out.println("Do you want to add or remove  AdditionalMaterials? [Y/N]");
            answer = ScannerThis.getInstance().nextLine();}
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        if (answer.equalsIgnoreCase("y")) {
            int answerDo;
            do{
                System.out.println("""
                                    Select the desired action number:
                                    1 Add new AdditionalMaterials;
                                    2 Remove the exist AdditionalMaterials.""");
                answerDo = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();}
            while (answerDo < 1 | answerDo > 2);
            if (answerDo == 1) {
                System.out.println("Enter a name for the new AdditionalMaterials:");
                String name = ScannerThis.getInstance().nextLine();
                int freeId = AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap().lastKey() + 1;
                System.out.println("Enter the lectureId for the new AdditionalMaterials (" + freeId + "):");
                int lectureId = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
                new AdditionalMaterialsService(name, lectureId);
                System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());

            } else {
                System.out.println("Enter a lectureId to remove AdditionalMaterials:");
                int lectureId = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
                boolean flag = false;
                for (AdditionalMaterials  additionalMaterials : AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList()) {
                    if (additionalMaterials.getLectureId() == lectureId) {
                        flag = true;
                        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().remove(additionalMaterials);
                        break;}
                }
                if (!flag) { throw new NoSuchElementException();
                }

                System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());

            }

        }else {
            System.out.println("You refused to make changes!");
        }

    }

}
