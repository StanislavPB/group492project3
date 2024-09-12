package org.group492project3.backEnd.service;

import org.group492project3.backEnd.dto.Response;
import org.group492project3.backEnd.entity.EducationalMaterials;
import org.group492project3.backEnd.repository.EdMatRepository;

import java.util.List;

public class EducationalMaterialsService {
    private EdMatRepository edMatRepository;

    public EducationalMaterialsService(EdMatRepository edMatRepository) {
        this.edMatRepository = edMatRepository;
    }

    public Response<EducationalMaterials,String>  addMaterial(Integer idOfCourse, String materialType, String materialDescription) {

        EducationalMaterials materialsForSave = edMatRepository.addMaterial(idOfCourse, materialType, materialDescription);
        //------------------  Здесь должна быть ВАЛИДАЦИЯ
        if(materialsForSave == null){
            return new Response<>(null, false, "Произошла ошибка при сохранении EducationalMaterials.");
        }

        return new Response<>(materialsForSave, true,"");
    }

    public Response<List<EducationalMaterials>,String> getEducationalMaterialsForCourse(Integer idCourse) {
        List<EducationalMaterials> educationalMaterialsList = edMatRepository.getEducationalMaterialsForCourse(idCourse);

        if(educationalMaterialsList.size() == 0){
            return new Response<>(null, false, "EducationalMaterials этого курса отсутствуют.");
        }
        return new Response<>(educationalMaterialsList, true,"");
    }





}
