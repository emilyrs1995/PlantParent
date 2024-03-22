package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ApiDetailsResponse {

    @JsonProperty("id")
    private int id;
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("other_name")
    private List<String> otherName;
    @JsonProperty("scientific_name")
    private List<String> scientificName;
    @JsonProperty("default_image")
    private DefaultImage defaultImage;
    @JsonProperty("description")
    private String description;
    @JsonProperty("poisonous_to_pets")
    private int poisonousToPets;
    @JsonProperty("poisonous_to_humans")
    private int poisonousToHumans;
    @JsonProperty("medicinal")
    private boolean medicinal;
    @JsonProperty("cuisine")
    private boolean cuisine;
    @JsonProperty("edible_leaf")
    private boolean edibleLeaf;
    @JsonProperty("leaf_color")
    private List<String> leafColor;
    @JsonProperty("leaf")
    private boolean leaf;
    @JsonProperty("fruit_color")
    private List<String> fruitColor;
    @JsonProperty("fruit_nutritional_value")
    private String fruitNutritionalValue;
    @JsonProperty("edible_fruit_taste_profile")
    private String edibleFruitTasteProfile;
    @JsonProperty("edible_fruit")
    private boolean edibleFruit;
    @JsonProperty("fruits")
    private boolean fruits;
    @JsonProperty("cones")
    private boolean cones;
    @JsonProperty("flower_color")
    private String flowerColor;
    @JsonProperty("flowers")
    private boolean flowers;
    @JsonProperty("pest_susceptibility_api")
    private String pestSusceptibilityApi;
    @JsonProperty("pest_susceptibility")
    private List<String> pestSusceptibility;
    @JsonProperty("care_level")
    private String careLevel;
    @JsonProperty("indoor")
    private boolean indoor;
    @JsonProperty("tropical")
    private boolean tropical;
    @JsonProperty("invasive")
    private boolean invasive;
    @JsonProperty("thorny")
    private boolean thorny;
    @JsonProperty("salt_tolerant")
    private boolean saltTolerant;
    @JsonProperty("drought_tolerant")
    private boolean droughtTolerant;
    @JsonProperty("growth_rate")
    private String growthRate;
    @JsonProperty("soil")
    private List<String> soil;
    @JsonProperty("care-guides")
    private String careGuides;
    @JsonProperty("maintenance")
    private String maintenance;
    @JsonProperty("seeds")
    private int seeds;
    @JsonProperty("pruning_count")
    private PruningCount pruningCount;
    @JsonProperty("pruning_month")
    private List<String> pruningMonth;
    @JsonProperty("sunlight")
    private List<String> sunlight;
    @JsonProperty("plant_anatomy")
    private List<PlantAnatomy> plantAnatomy;
    @JsonProperty("watering_general_benchmark")
    private WateringGeneralBenchmark wateringGeneralBenchmark;
    @JsonProperty("volume_water_requirement")
    private List<String> volumeWaterRequirement;
    @JsonProperty("depth_water_requirement")
    private List<String> depthWaterRequirement;
    @JsonProperty("watering")
    private String watering;
    @JsonProperty("hardiness_location")
    private HardinessLocation hardinessLocation;
    @JsonProperty("hardiness")
    private Hardiness hardiness;
    @JsonProperty("propagation")
    private List<String> propagation;
    @JsonProperty("attracts")
    private List<String> attracts;
    @JsonProperty("cycle")
    private String cycle;
    @JsonProperty("dimensions")
    private Dimensions dimensions;
    @JsonProperty("dimension")
    private String dimension;
    @JsonProperty("type")
    private String type;
    @JsonProperty("origin")
    private java.util.List<String> origin;
    @JsonProperty("family")
    private String family;

    public ApiDetailsResponse() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public boolean isMedicinal() {
        return medicinal;
    }

    public void setMedicinal(boolean medicinal) {
        this.medicinal = medicinal;
    }

    public String getFlowerColor() {
        return flowerColor;
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public boolean isFlowers() {
        return flowers;
    }

    public void setFlowers(boolean flowers) {
        this.flowers = flowers;
    }

    public String getCareLevel() {
        return careLevel;
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    public boolean isIndoor() {
        return indoor;
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    public String getGrowthRate() {
        return growthRate;
    }

    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    public String getMaintenance() {
        return maintenance;
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public WateringGeneralBenchmark getWateringGeneralBenchmark() {
        return wateringGeneralBenchmark;
    }

    public void setWateringGeneralBenchmark(WateringGeneralBenchmark wateringGeneralBenchmark) {
        this.wateringGeneralBenchmark = wateringGeneralBenchmark;
    }

    public Hardiness getHardiness() {
        return hardiness;
    }

    public void setHardiness(Hardiness hardiness) {
        this.hardiness = hardiness;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
