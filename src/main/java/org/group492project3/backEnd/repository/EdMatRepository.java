package org.group492project3.backEnd.repository;
import org.group492project3.backEnd.entity.Course;
import org.group492project3.backEnd.entity.EducationalMaterials;

import java.util.ArrayList;
import java.util.List;

public class EdMatRepository {

    private List<EducationalMaterials> materials = new ArrayList<>();
    private Integer getiIdMaterials = 0;

    public EducationalMaterials addMaterial(Integer idOfCourse, String materialType, String materialDescription) {
        getiIdMaterials = materials.size()+1;
        EducationalMaterials materialsForSave = new EducationalMaterials(idOfCourse, materialType, materialDescription);
        materials.add(materialsForSave);
        return materialsForSave;
    }

    public EducationalMaterials findByMaterialsId(Integer idOfMaterial) {

        return materials.stream()
                .filter(note -> note.getIdOfMaterial().equals(idOfMaterial))
                .findFirst()
                .orElse(null);
    }

    public EducationalMaterials updateDescription(EducationalMaterials materialForUpdate) {
        materialForUpdate.setMaterialDescription(materialForUpdate.getMaterialDescription());
        return materialForUpdate;
    }

    public EducationalMaterials deleteMaterial(EducationalMaterials materialForDelete) {

        for (EducationalMaterials currentItem : materials) {
            if (currentItem.equals(materialForDelete)) {
                materials.remove(materialForDelete);
                System.out.println("Материал успешно удалён.");
            }
        } return null;

    }
}
