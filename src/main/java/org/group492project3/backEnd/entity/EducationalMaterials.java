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

    public void setIdOfMaterial(Integer idOfMaterial) {
        this.idOfMaterial = idOfMaterial;
    }

    public void setMaterialDescription(String materialDescription) {
        this.materialDescription = materialDescription;
    }

    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

    public EducationalMaterials(Integer idOfCourse, String materialType, String materialDescription) {
        this.idOfCourse = idOfCourse;
        this.idOfMaterial = idOfMaterial;
        this.materialDescription = materialDescription;
        this.materialType = materialType;
    }

    @Override
    public String toString() {
        return "EducationalMaterials{" +
                "idOfCourse=" + idOfCourse +
                ", idOfMaterial=" + idOfMaterial +
                ", materialType='" + materialType + '\'' +
                ", materialDescription='" + materialDescription + '\'' +
                '}';
    }
}
