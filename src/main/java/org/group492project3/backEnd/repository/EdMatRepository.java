package org.group492project3.backEnd.repository;
import org.group492project3.backEnd.entity.EducationalMaterials;
//import org.group492project3.frontEnd.services.UserInputService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EdMatRepository {
    //UserInputService userInput = UserInputService();
    private List<EducationalMaterials> materials = new ArrayList<>();

    public EducationalMaterials addMaterial(Integer idOfCourse, String materialType, String materialDescription) {

        EducationalMaterials materialsForSave = new EducationalMaterials((materials.size()+1), idOfCourse, materialType, materialDescription);
        materials.add(materialsForSave);
        return materialsForSave;
    }

    public List<EducationalMaterials> getEducationalMaterialsForCourse(Integer idCourse) {

        return materials.stream()
                .filter(edMat -> edMat.getIdOfCourse().equals(idCourse))
                .toList();
    }
    /*
    public String findByWordInDescription () {


        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите слово для поиска в описании учебного материала.");
        String stringFromUser = scanner.nextLine();

        String forsearching = new String(materials.getFirst().getMaterialDescription().toLowerCase());

        if (forsearching.contains(stringFromUser)) {
            System.out.println("В этом описании есть слово: " + stringFromUser + "." );
        } else {
            System.out.println("Слова " + stringFromUser + " - в описании нет.");}

        return stringFromUser;
    }
*/
    public EducationalMaterials updateDescription(EducationalMaterials materialForUpdate) {
        materialForUpdate.setMaterialDescription(materialForUpdate.getMaterialDescription());
        return materialForUpdate;
    }

    public EducationalMaterials deleteMaterial(EducationalMaterials materialForDelete) {

        for (EducationalMaterials currentItem : materials) {
            if (currentItem.equals(materialForDelete)) {
                materials.remove(materialForDelete);
                //System.out.println("Материал успешно удалён.");
            }
        } return null;

    }
}
