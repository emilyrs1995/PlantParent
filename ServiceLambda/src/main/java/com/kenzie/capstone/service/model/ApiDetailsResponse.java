package com.kenzie.capstone.service.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
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
    private WateringGeneralBenchmark wateringGeneralBenchmark;
    @JsonProperty("hardiness")
    private Hardiness hardiness;
    @JsonProperty("description")
    private String description;
    @JsonProperty("other_name")
    private List<String> otherName;
    @JsonProperty("scientific_name")
    private List<String> scientificName;
    @JsonProperty("default_image")
    private DefaultImage defaultImage;
    @JsonProperty("poisonous_to_pets")
    private int poisonousToPets;
    @JsonProperty("poisonous_to_humans")
    private int poisonousToHumans;
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
    @JsonProperty("pest_susceptibility_api")
    private String pestSusceptibilityApi;
    @JsonProperty("pest_susceptibility")
    private List<String> pestSusceptibility;
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
    private List<String> soil;
    @JsonProperty("care-guides")
    private String careGuides;
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
    @JsonProperty("volume_water_requirement")
    private List<String> volumeWaterRequirement;
    @JsonProperty("watering_period")
    private String wateringPeriod;
    @JsonProperty("depth_water_requirement")
    private DepthWaterRequirement depthWaterRequirement;
    @JsonProperty("watering")
    private String watering;
    @JsonProperty("hardiness_location")
    private HardinessLocation hardinessLocation;
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
    private List<String> origin;
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

    public Optional<WateringGeneralBenchmark> getWateringGeneralBenchmark() {
        return Optional.ofNullable(wateringGeneralBenchmark);
    }

    public void setWateringGeneralBenchmark(WateringGeneralBenchmark wateringGeneralBenchmark) {
        this.wateringGeneralBenchmark = wateringGeneralBenchmark;
    }

    public Optional<Hardiness> getHardiness() {
        return Optional.ofNullable(hardiness);
    }

    public void setHardiness(Hardiness hardiness) {
        this.hardiness = hardiness;
    }

    public Optional<String> getDescription() {
        return Optional.ofNullable(description);
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getOtherName() {
        return otherName;
    }

    public void setOtherName(List<String> otherName) {
        this.otherName = otherName;
    }

    public List<String> getScientificName() {
        return scientificName;
    }

    public void setScientificName(List<String> scientificName) {
        this.scientificName = scientificName;
    }

    public DefaultImage getDefaultImage() {
        return defaultImage;
    }

    public void setDefaultImage(DefaultImage defaultImage) {
        this.defaultImage = defaultImage;
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

    public List<String> getLeafColor() {
        return leafColor;
    }

    public void setLeafColor(List<String> leafColor) {
        this.leafColor = leafColor;
    }

    public boolean isLeaf() {
        return leaf;
    }

    public void setLeaf(boolean leaf) {
        this.leaf = leaf;
    }

    public List<String> getFruitColor() {
        return fruitColor;
    }

    public void setFruitColor(List<String> fruitColor) {
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

    public List<String> getPestSusceptibility() {
        return pestSusceptibility;
    }

    public void setPestSusceptibility(List<String> pestSusceptibility) {
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

    public List<String> getSoil() {
        return soil;
    }

    public void setSoil(List<String> soil) {
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

    public PruningCount getPruningCount() {
        return pruningCount;
    }

    public void setPruningCount(PruningCount pruningCount) {
        this.pruningCount = pruningCount;
    }

    public List<String> getPruningMonth() {
        return pruningMonth;
    }

    public void setPruningMonth(List<String> pruningMonth) {
        this.pruningMonth = pruningMonth;
    }

    public List<String> getSunlight() {
        return sunlight;
    }

    public void setSunlight(List<String> sunlight) {
        this.sunlight = sunlight;
    }

    public List<PlantAnatomy> getPlantAnatomy() {
        return plantAnatomy;
    }

    public void setPlantAnatomy(List<PlantAnatomy> plantAnatomy) {
        this.plantAnatomy = plantAnatomy;
    }

    public List<String> getVolumeWaterRequirement() {
        return volumeWaterRequirement;
    }

    public void setVolumeWaterRequirement(List<String> volumeWaterRequirement) {
        this.volumeWaterRequirement = volumeWaterRequirement;
    }

    public DepthWaterRequirement getDepthWaterRequirement() {
        return depthWaterRequirement;
    }

    public void setDepthWaterRequirement(DepthWaterRequirement depthWaterRequirement) {
        this.depthWaterRequirement = depthWaterRequirement;
    }

    public String getWatering() {
        return watering;
    }

    public void setWatering(String watering) {
        this.watering = watering;
    }

    public HardinessLocation getHardinessLocation() {
        return hardinessLocation;
    }

    public void setHardinessLocation(HardinessLocation hardinessLocation) {
        this.hardinessLocation = hardinessLocation;
    }

    public List<String> getPropagation() {
        return propagation;
    }

    public void setPropagation(List<String> propagation) {
        this.propagation = propagation;
    }

    public List<String> getAttracts() {
        return attracts;
    }

    public void setAttracts(List<String> attracts) {
        this.attracts = attracts;
    }

    public String getCycle() {
        return cycle;
    }

    public void setCycle(String cycle) {
        this.cycle = cycle;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }

    public void setDimensions(Dimensions dimensions) {
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

    public List<String> getOrigin() {
        return origin;
    }

    public void setOrigin(List<String> origin) {
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
