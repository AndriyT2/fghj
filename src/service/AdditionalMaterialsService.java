package service;

import models.AdditionalMaterials;
import models.Lecture;
import models.ResourceType;
import repository.AdditionalMaterialsRepository;
import repository.LectureRepository;
import utility.ScannerThis;
import utility.utilityLog.LogFactory;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;

public class AdditionalMaterialsService implements Serializable {
    public AdditionalMaterialsService() {
    }

    public AdditionalMaterialsService(String name, int lectureId) {
        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new AdditionalMaterials(name, lectureId));
    }

    public void createAdditionalMaterialsService(String name, int lectureId) {
        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new AdditionalMaterials(name, lectureId));
    }

    public void createAdditionalMaterialsService(String name, int lectureId, ResourceType resourceType) {
        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().add(new AdditionalMaterials(name, lectureId, resourceType));

    }

    public void sortByChoose() {
        AdditionalMaterialsRepository.getInstance().sortAdditionalMaterialsById();
        String answer;
        do {
            System.out.println("Do you want to sort AdditionalMaterials by other methods? [Y/N]");
            answer = ScannerThis.getInstance().nextLine();
        }
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        if (answer.equalsIgnoreCase("y")) {
            int answerMethod;
            do {
                System.out.println("""
                        Choose the method number to sort:
                        1 Sort by lectureId;
                        2 Sort by resourceType.""");
                answerMethod = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
            }
            while (answerMethod < 1 | answerMethod > 2);
            if (answerMethod == 1) {
                AdditionalMaterialsRepository.getInstance().sortAdditionalMaterialsByLectureId();
            } else {
                AdditionalMaterialsRepository.getInstance().sortAdditionalMaterialsByResourceType();
            }
        } else {
            System.out.println("You refused to change the sorting method!");
        }


    }


    public void addResourceType(int idAdditionalMaterials) {
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
            } else {
                System.out.println("Ви створили новий компонент - BOOK.");
                AdditionalMaterialsRepository.getInstance().getById(idAdditionalMaterials).setResourceType(ResourceType.BOOK);
                System.out.println(AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList());
            }

        }
    }

    public void removeAdditionalMaterialsMenu(int lectureId) {

        boolean flag = false;
        for (AdditionalMaterials additionalMaterials : AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList()) {
            if (additionalMaterials.getLectureId() == lectureId) {
                flag = true;
                AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().remove(additionalMaterials);
                break;
            }
        }
        if (!flag) {

            NoSuchElementException e = new NoSuchElementException();
            LogFactory.warning(this.getClass().getName(), "Id don't exist", e.getStackTrace());
            throw e;
        }

        System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());
    }

    public void shoveAdditionalMaterialsTreeMapWithOptions() {
        System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());
        String answer;
        do {
            System.out.println("Do you want to add or remove  AdditionalMaterials? [Y/N]");
            answer = ScannerThis.getInstance().nextLine();
        }
        while (!answer.equalsIgnoreCase("y") && !answer.equalsIgnoreCase("n"));
        if (answer.equalsIgnoreCase("y")) {
            int answerDo;
            do {
                System.out.println("""
                        Select the desired action number:
                        1 Add new AdditionalMaterials;
                        2 Remove the exist AdditionalMaterials.""");
                answerDo = ScannerThis.getInstance().nextInt();
                ScannerThis.getInstance().nextLine();
            }
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
                for (AdditionalMaterials additionalMaterials : AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList()) {
                    if (additionalMaterials.getLectureId() == lectureId) {
                        flag = true;
                        AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList().remove(additionalMaterials);
                        break;
                    }
                }
                if (!flag) {
                    throw new NoSuchElementException();
                }

                System.out.println(AdditionalMaterialsRepository.getInstance().additionalMaterialsTreeMap());

            }

        } else {
            System.out.println("You refused to make changes!");
        }

    }

    public <T, P> void allAdditionalMaterialsSortedBySMT(List<T> list1, List<P> list2, Consumer<T> consumer1, Consumer<P> consumer2,  Function<T, Integer> function1, Function<P, Integer> function2) {
        for (T t : list1) {
            System.out.print("\nДля лекції: ");
            consumer1.accept(t);
            System.out.println("Відповідають наступні додаткові матеріали:");
            for (P p : list2) {
                if (Objects.equals(function1.apply(t), function2.apply(p))) {
                    consumer2.accept(p);
                }
            }
            System.out.println("---------------------------------------");
        }
        LogFactory.debug(this.getClass().getName(), "Create allAdditionalMaterialsSortedBySMT");
    }

    public void allAdditionalMaterialsSortedBySMT() {

        for (Lecture lecture : LectureRepository.getInstance().getLecturesList()) {
            List<AdditionalMaterials> additionalMaterialsList = new ArrayList<>();
            for (AdditionalMaterials aM : AdditionalMaterialsRepository.getInstance().getAdditionalMaterialsList()) {
                if (lecture.getId() == aM.getLectureId()) {
                    additionalMaterialsList.add(aM);
                }
            }
            System.out.println("Лекції " + lecture + "відповідають наступні додаткові матеріали: " + additionalMaterialsList);


        }

    }
}


