package org.group492project3.backEnd.repository;

import org.group492project3.backEnd.entity.EducationalMaterials;

import java.util.ArrayList;
import java.util.List;

public class EdMatRepository {

    private final List<EducationalMaterials> materials = new ArrayList<>();

    public EducationalMaterials addMaterial(Integer idOfCourse, String materialType, String materialDescription) {

        EducationalMaterials materialsForSave = new EducationalMaterials((materials.size() + 1), idOfCourse, materialType, materialDescription);
        materials.add(materialsForSave);
        return materialsForSave;
    }

    public List<EducationalMaterials> getEducationalMaterialsForCourse(Integer idCourse) {

        return materials.stream()
                .filter(edMat -> edMat.getIdOfCourse().equals(idCourse))
                .toList();
    }


   public boolean findByWordInDescription (String wordFromUser) {
       for (EducationalMaterials currentItem : materials) {
           if (currentItem.getMaterialDescription().contains(wordFromUser)) {
               return true;}
       }
       return false;
   }

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
        }
        return null;
    }
}
