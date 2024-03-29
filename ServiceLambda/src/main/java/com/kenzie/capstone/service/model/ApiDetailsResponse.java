package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Optional;

public class ApiDetailsResponse {

    @JsonProperty("id")
    private int id;
    @JsonProperty("common_name")
    private String commonName;
    @JsonProperty("medicinal")
    private boolean medicinal;
    @JsonProperty("flower_color")
    private String flowerColor;
    @JsonProperty("flowers")
    private boolean flowers;
    @JsonProperty("care_level")
    private String careLevel;
    @JsonProperty("indoor")
    private boolean indoor;
    @JsonProperty("growth_rate")
    private String growthRate;
    @JsonProperty("maintenance")
    private String maintenance;
    @JsonProperty("watering_general_benchmark")
    private Object wateringGeneralBenchmark;
    @JsonProperty("hardiness")
    private Object hardiness;
    @JsonProperty("description")
    private String description;
    @JsonProperty("other_name")
    private Object otherName;
    @JsonProperty("scientific_name")
    private Object scientificName;
    @JsonProperty("default_image")
    private Object defaultImage;
    @JsonProperty("poisonous_to_pets")
    private int poisonousToPets;
    @JsonProperty("poisonous_to_humans")
    private int poisonousToHumans;
    @JsonProperty("cuisine")
    private boolean cuisine;
    @JsonProperty("edible_leaf")
    private boolean edibleLeaf;
    @JsonProperty("leaf_color")
    private Object leafColor;
    @JsonProperty("leaf")
    private boolean leaf;
    @JsonProperty("fruit_color")
    private Object fruitColor;
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
    @JsonProperty("pest_susceptibility_api")
    private String pestSusceptibilityApi;
    @JsonProperty("pest_susceptibility")
    private Object pestSusceptibility;
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
    @JsonProperty("soil")
    private Object soil;
    @JsonProperty("care-guides")
    private String careGuides;
    @JsonProperty("seeds")
    private int seeds;
    @JsonProperty("pruning_count")
    private Object pruningCount;
    @JsonProperty("pruning_month")
    private Object pruningMonth;
    @JsonProperty("sunlight")
    private Object sunlight;
    @JsonProperty("plant_anatomy")
    private Object plantAnatomy;
    @JsonProperty("volume_water_requirement")
    private Object volumeWaterRequirement;
    @JsonProperty("watering_period")
    private String wateringPeriod;
    @JsonProperty("depth_water_requirement")
    private Object depthWaterRequirement;
    @JsonProperty("watering")
    private String watering;
    @JsonProperty("hardiness_location")
    private Object hardinessLocation;
    @JsonProperty("propagation")
    private Object propagation;
    @JsonProperty("attracts")
    private Object attracts;
    @JsonProperty("cycle")
    private String cycle;
    @JsonProperty("dimensions")
    private Object dimensions;
    @JsonProperty("dimension")
    private String dimension;
    @JsonProperty("type")
    private String type;
    @JsonProperty("origin")
    private Object origin;
    @JsonProperty("family")
    private String family;
    @JsonProperty("flowering_season")
    private String floweringSeason;
    @JsonProperty("harvest_season")
    private String harvestSeason;
    @JsonProperty("other_images")
    private String otherImages;

    public ApiDetailsResponse() {
    }

    public Optional<Integer> getId() {
        return Optional.of(id);
    }

    public void setId(int id) {
        this.id = id;
    }

    public Optional<String> getCommonName() {
        return Optional.ofNullable(commonName);
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public Optional<Boolean> isMedicinal() {
        return Optional.of(medicinal);
    }

    public void setMedicinal(boolean medicinal) {
        this.medicinal = medicinal;
    }

    public Optional<String> getFlowerColor() {
        return Optional.ofNullable(flowerColor);
    }

    public void setFlowerColor(String flowerColor) {
        this.flowerColor = flowerColor;
    }

    public Optional<Boolean> isFlowers() {
        return Optional.of(flowers);
    }

    public void setFlowers(boolean flowers) {
        this.flowers = flowers;
    }

    public Optional<String> getCareLevel() {
        return Optional.ofNullable(careLevel);
    }

    public void setCareLevel(String careLevel) {
        this.careLevel = careLevel;
    }

    public Optional<Boolean> isIndoor() {
        return Optional.of(indoor);
    }

    public void setIndoor(boolean indoor) {
        this.indoor = indoor;
    }

    public Optional<String> getGrowthRate() {
        return Optional.ofNullable(growthRate);
    }

    public void setGrowthRate(String growthRate) {
        this.growthRate = growthRate;
    }

    public Optional<String> getMaintenance() {
        return Optional.ofNullable(maintenance);
    }

    public void setMaintenance(String maintenance) {
        this.maintenance = maintenance;
    }

    public Optional<Object> getWateringGeneralBenchmark() {
        return Optional.ofNullable(wateringGeneralBenchmark);
    }

    public void setWateringGeneralBenchmark(Object wateringGeneralBenchmark) {
        this.wateringGeneralBenchmark = wateringGeneralBenchmark;
    }

    public Optional<Object> getHardiness() {
        return Optional.ofNullable(hardiness);
    }

    public void setHardiness(Object hardiness) {
        this.hardiness = hardiness;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Optional<Object> getScientificName() {
        return Optional.ofNullable(scientificName);
    }

    public void setScientificName(Object scientificName) {
        this.scientificName = scientificName;
    }

    public Optional<Object> getDefaultImage() {
        return Optional.ofNullable(defaultImage);
    }

    public void setDefaultImage(Object defaultImage) {
        this.defaultImage = defaultImage;
    }

    public Optional<Object> getSunlight() {
        return Optional.ofNullable(sunlight);
    }

    public void setSunlight(Object sunlight) {
        this.sunlight = sunlight;
    }

    public Optional<String> getWatering() {
        return Optional.ofNullable(watering);
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public Optional<String> getCycle() {
        return Optional.ofNullable(cycle);
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Object getOtherName() {
        return otherName;
    }

    public void setOtherName(Object otherName) {
        this.otherName = otherName;
    }

    public int getPoisonousToPets() {
        return poisonousToPets;
    }

    public void setPoisonousToPets(int poisonousToPets) {
        this.poisonousToPets = poisonousToPets;
    }

    public int getPoisonousToHumans() {
        return poisonousToHumans;
    }

    public void setPoisonousToHumans(int poisonousToHumans) {
        this.poisonousToHumans = poisonousToHumans;
    }

    public boolean isCuisine() {
        return cuisine;
    }

    public void setCuisine(boolean cuisine) {
        this.cuisine = cuisine;
    }

    public boolean isEdibleLeaf() {
        return edibleLeaf;
    }

    public void setEdibleLeaf(boolean edibleLeaf) {
        this.edibleLeaf = edibleLeaf;
    }

    public Object getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(Object leafColor) {
        this.leafColor = leafColor;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public Object getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(Object fruitColor) {
        this.fruitColor = fruitColor;
    }

    public String getFruitNutritionalValue() {
        return fruitNutritionalValue;
    }

    public void setFruitNutritionalValue(String fruitNutritionalValue) {
        this.fruitNutritionalValue = fruitNutritionalValue;
    }

    public String getEdibleFruitTasteProfile() {
        return edibleFruitTasteProfile;
    }

    public void setEdibleFruitTasteProfile(String edibleFruitTasteProfile) {
        this.edibleFruitTasteProfile = edibleFruitTasteProfile;
    }

    public boolean isEdibleFruit() {
        return edibleFruit;
    }

    public void setEdibleFruit(boolean edibleFruit) {
        this.edibleFruit = edibleFruit;
    }

    public boolean isFruits() {
        return fruits;
    }

    public void setFruits(boolean fruits) {
        this.fruits = fruits;
    }

    public boolean isCones() {
        return cones;
    }

    public void setCones(boolean cones) {
        this.cones = cones;
    }

    public String getPestSusceptibilityApi() {
        return pestSusceptibilityApi;
    }

    public void setPestSusceptibilityApi(String pestSusceptibilityApi) {
        this.pestSusceptibilityApi = pestSusceptibilityApi;
    }

    public Object getPestSusceptibility() {
        return pestSusceptibility;
    }

    public void setPestSusceptibility(Object pestSusceptibility) {
        this.pestSusceptibility = pestSusceptibility;
    }

    public boolean isTropical() {
        return tropical;
    }

    public void setTropical(boolean tropical) {
        this.tropical = tropical;
    }

    public boolean isInvasive() {
        return invasive;
    }

    public void setInvasive(boolean invasive) {
        this.invasive = invasive;
    }

    public boolean isThorny() {
        return thorny;
    }

    public void setThorny(boolean thorny) {
        this.thorny = thorny;
    }

    public boolean isSaltTolerant() {
        return saltTolerant;
    }

    public void setSaltTolerant(boolean saltTolerant) {
        this.saltTolerant = saltTolerant;
    }

    public boolean isDroughtTolerant() {
        return droughtTolerant;
    }

    public void setDroughtTolerant(boolean droughtTolerant) {
        this.droughtTolerant = droughtTolerant;
    }

    public Object getSoil() {
        return soil;
    }

    public void setSoil(Object soil) {
        this.soil = soil;
    }

    public String getCareGuides() {
        return careGuides;
    }

    public void setCareGuides(String careGuides) {
        this.careGuides = careGuides;
    }

    public int getSeeds() {
        return seeds;
    }

    public void setSeeds(int seeds) {
        this.seeds = seeds;
    }

    public Object getPruningCount() {
        return pruningCount;
    }

    public void setPruningCount(Object pruningCount) {
        this.pruningCount = pruningCount;
    }

    public Object getPruningMonth() {
        return pruningMonth;
    }

    public void setPruningMonth(Object pruningMonth) {
        this.pruningMonth = pruningMonth;
    }

    public Object getPlantAnatomy() {
        return plantAnatomy;
    }

    public void setPlantAnatomy(Object plantAnatomy) {
        this.plantAnatomy = plantAnatomy;
    }

    public Object getVolumeWaterRequirement() {
        return volumeWaterRequirement;
    }

    public void setVolumeWaterRequirement(Object volumeWaterRequirement) {
        this.volumeWaterRequirement = volumeWaterRequirement;
    }

    public Object getDepthWaterRequirement() {
        return depthWaterRequirement;
    }

    public void setDepthWaterRequirement(Object depthWaterRequirement) {
        this.depthWaterRequirement = depthWaterRequirement;
    }

    public Object getHardinessLocation() {
        return hardinessLocation;
    }

    public void setHardinessLocation(Object hardinessLocation) {
        this.hardinessLocation = hardinessLocation;
    }

    public Object getPropagation() {
        return propagation;
    }

    public void setPropagation(Object propagation) {
        this.propagation = propagation;
    }

    public Object getAttracts() {
        return attracts;
    }

    public void setAttracts(Object attracts) {
        this.attracts = attracts;
    }

    public Object getDimensions() {
        return dimensions;
    }

    public void setDimensions(Object dimensions) {
        this.dimensions = dimensions;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getOrigin() {
        return origin;
    }

    public void setOrigin(Object origin) {
        this.origin = origin;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getWateringPeriod() {
        return wateringPeriod;
    }

    public void setWateringPeriod(String wateringPeriod) {
        this.wateringPeriod = wateringPeriod;
    }

    public String getFloweringSeason() {
        return floweringSeason;
    }

    public void setFloweringSeason(String floweringSeason) {
        this.floweringSeason = floweringSeason;
    }

    public String getHarvestSeason() {
        return harvestSeason;
    }

    public void setHarvestSeason(String harvestSeason) {
        this.harvestSeason = harvestSeason;
    }

    public String getOtherImages() {
        return otherImages;
    }

    public void setOtherImages(String otherImages) {
        this.otherImages = otherImages;
    }
}
