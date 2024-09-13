package org.group492project3.backEnd.entity;

public class EducationalMaterials {

    private Integer idOfMaterial;
    private Integer idOfCourse;
    private String materialType;
    private String materialDescription;

    public Integer getIdOfCourse() {
        return idOfCourse;
    }

    public Integer getIdOfMaterial() {
        return idOfMaterial;
    }

    public String getMaterialDescription() {
        return materialDescription;
    }

    public String getMaterialType() {
        return materialType;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public EducationalMaterials(Integer idOfMaterial, Integer idOfCourse, String materialType, String materialDescription) {
        this.idOfCourse = idOfCourse;
        this.idOfMaterial = idOfMaterial;
        this.materialDescription = materialDescription;
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "Учебный материал: " +
                "id курса" + idOfCourse +
                ", id материала " + idOfMaterial + "\n" +
                ", тип материала '" + materialType + "\n"  +
                ", задание для самостоятельной работы: " + "\n" + materialDescription + '.';
    }
}
