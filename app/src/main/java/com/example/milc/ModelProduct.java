package com.example.milc;

public class ModelProduct {

    String key;
    String productId,uid,productIcon,productName,productDescription,productCompany,productIndication,productIngredient,productAvailability,productRetailPrice;
    String productSpecialFeatures,productStorage,productCalorie,productOtherInfo,productServingSize,productPackSize;
    String productCategory,productSubCategory,productAmount,productAmountUnit,productAmountType;
    String specialAvailable, packSizeAvailable, servingSizeAvailable, otherInfoAvailable, calorieAvailable, storageAvailable;

    String productEnergy,productProtein;
    String productFat,productMUFA,productPUFA,productLinoleicAcidOmega6,productαlinolenicAcidOmega3,productEPA,productDHA,productSFA,productMCTOil,productTransFattyAcids;
    String productCholesterol,productCarbohydrate,productSalt,productLactose,productPolyols,productFiber,productFOS,productDietaryFiber,productSolubleFiber,productSugar;
    String productEssentialAminoAcids,productBranchedChainAminoAcids,productInulin,productCholine,productTaurine,productCarnitine,productLCarnitine,productCaHMB,productHMB,productInositol;

    String productαLactalbumin,productβLactoglobulin,productGlycomacropeptide,productImmunoglobulinGIgG,productBovineSerumAlbumin,productProteasePeptone5;

    String productVitaminA,productVitaminAPalmitate,productVitaminABCarotene,productVitaminD,productVitaminD3,productVitaminE,productVitaminK,productVitaminK1,productVitaminC,productVitaminB1;
    String productVitaminB2,productVitaminB6,productVitaminB12,productNiacin,productNiacinEquivalent,productFolicAcid,productBiotin,productPantothenicAcid;

    String productSodium,productPotassium,productChloride,productCalcium,productPhosphorus,productMagnesium,productIron,productZinc,productManganese,productCopper;
    String productIodine,productSelenium,productChromium,productMolybdenum,productWater;

    String productIsoleucine,productLeucine,productLysine,productMethionine,productPhenylalanine,productThreonine,productTryptophan,productValine,productHistidine,productAlanine;
    String productArginine,productAsparticAcid,productCysteine,productGlutamicAcid,productGlycine,productProline,productSerine,productTyrosine,productHydroxyLysine,productHydroxyProline;

//    *********************************************************************************************************************************************************************************************************************************************
    String productEnergyUnit,productProteinUnit;
    String productFatUnit,productMUFAUnit,productPUFAUnit,productLinoleicAcidOmega6Unit,productαlinolenicAcidOmega3Unit,productEPAUnit,productDHAUnit,productSFAUnit,productMCTOilUnit,productTransFattyAcidsUnit;
    String productCholesterolUnit,productCarbohydrateUnit,productSaltUnit,productLactoseUnit,productPolyolsUnit,productFiberUnit,productFOSUnit,productDietaryFiberUnit,productSolubleFiberUnit,productSugarUnit;
    String productEssentialAminoAcidsUnit,productBranchedChainAminoAcidsUnit,productInulinUnit,productCholineUnit,productTaurineUnit,productCarnitineUnit,productLCarnitineUnit,productCaHMBUnit,productHMBUnit,productInositolUnit;

    String productαLactalbuminUnit,productβLactoglobulinUnit,productGlycomacropeptideUnit,productImmunoglobulinGIgGUnit,productBovineSerumAlbuminUnit,productProteasePeptone5Unit;

    String productVitaminAUnit,productVitaminAPalmitateUnit,productVitaminABCaroteneUnit,productVitaminDUnit,productVitaminD3Unit,productVitaminEUnit,productVitaminKUnit,productVitaminK1Unit,productVitaminCUnit,productVitaminB1Unit;
    String productVitaminB2Unit,productVitaminB6Unit,productVitaminB12Unit,productNiacinUnit,productNiacinEquivalentUnit,productFolicAcidUnit,productBiotinUnit,productPantothenicAcidUnit;

    String productSodiumUnit,productPotassiumUnit,productChlorideUnit,productCalciumUnit,productPhosphorusUnit,productMagnesiumUnit,productIronUnit,productZincUnit,productManganeseUnit,productCopperUnit;
    String productIodineUnit,productSeleniumUnit,productChromiumUnit,productMolybdenumUnit,productWaterUnit;

    String productIsoleucineUnit,productLeucineUnit,productLysineUnit,productMethionineUnit,productPhenylalanineUnit,productThreonineUnit,productTryptophanUnit,productValineUnit,productHistidineUnit,productAlanineUnit;
    String productArginineUnit,productAsparticAcidUnit,productCysteineUnit,productGlutamicAcidUnit,productGlycineUnit,productProlineUnit,productSerineUnit,productTyrosineUnit,productHydroxyLysineUnit,productHydroxyProlineUnit;

    public ModelProduct(String key, String productId, String uid, String productIcon, String productName, String productDescription, String productCompany, String productIndication, String productIngredient, String productAvailability, String productRetailPrice, String productSpecialFeatures, String productStorage, String productCalorie, String productOtherInfo, String productServingSize, String productPackSize, String productCategory, String productSubCategory, String productAmount, String productAmountUnit, String productAmountType, String specialAvailable, String packSizeAvailable, String servingSizeAvailable, String otherInfoAvailable, String calorieAvailable, String storageAvailable, String productEnergy, String productProtein, String productFat, String productMUFA, String productPUFA, String productLinoleicAcidOmega6, String productαlinolenicAcidOmega3, String productEPA, String productDHA, String productSFA, String productMCTOil, String productTransFattyAcids, String productCholesterol, String productCarbohydrate, String productSalt, String productLactose, String productPolyols, String productFiber, String productFOS, String productDietaryFiber, String productSolubleFiber, String productSugar, String productEssentialAminoAcids, String productBranchedChainAminoAcids, String productInulin, String productCholine, String productTaurine, String productCarnitine, String productLCarnitine, String productCaHMB, String productHMB, String productInositol, String productαLactalbumin, String productβLactoglobulin, String productGlycomacropeptide, String productImmunoglobulinGIgG, String productBovineASerumAlbumin, String productProteasePeptone5, String productVitaminA, String productVitaminAPalmitate, String productVitaminABCarotene, String productVitaminD, String productVitaminD3, String productVitaminE, String productVitaminK, String productVitaminK1, String productVitaminC, String productVitaminB1, String productVitaminB2, String productVitaminB6, String productVitaminB12, String productNiacin, String productNiacinEquivalent, String productFolicAcid, String productBiotin, String productPantothenicAcid, String productSodium, String productPotassium, String productChloride, String productCalcium, String productPhosphorus, String productMagnesium, String productIron, String productZinc, String productManganese, String productCopper, String productIodine, String productSelenium, String productChromium, String productMolybdenum, String productWater, String productIsoleucine, String productLeucine, String productLysine, String productMethionine, String productPhenylalanine, String productThreonine, String productTryptophan, String productValine, String productHistidine, String productAlanine, String productArginine, String productAsparticAcid, String productCysteine, String productGlutamicAcid, String productGlycine, String productProline, String productSerine, String productTyrosine, String productHydroxyLysine, String productHydroxyProline, String productEnergyUnit, String productProteinUnit, String productFatUnit, String productMUFAUnit, String productPUFAUnit, String productLinoleicAcidOmega6Unit, String productαlinolenicAcidOmega3Unit, String productEPAUnit, String productDHAUnit, String productSFAUnit, String productMCTOilUnit, String productTransFattyAcidsUnit, String productCholesterolUnit, String productCarbohydrateUnit, String productSaltUnit, String productLactoseUnit, String productPolyolsUnit, String productFiberUnit, String productFOSUnit, String productDietaryFiberUnit, String productSolubleFiberUnit, String productSugarUnit, String productEssentialAminoAcidsUnit, String productBranchedChainAminoAcidsUnit, String productInulinUnit, String productCholineUnit, String productTaurineUnit, String productCarnitineUnit, String productLCarnitineUnit, String productCaHMBUnit, String productHMBUnit, String productInositolUnit, String productαLactalbuminUnit, String productβLactoglobulinUnit, String productGlycomacropeptideUnit, String productImmunoglobulinGIgGUnit, String productBovineASerumAlbuminUnit, String productProteasePeptone5Unit, String productVitaminAUnit, String productVitaminAPalmitateUnit, String productVitaminABCaroteneUnit, String productVitaminDUnit, String productVitaminD3Unit, String productVitaminEUnit, String productVitaminKUnit, String productVitaminK1Unit, String productVitaminCUnit, String productVitaminB1Unit, String productVitaminB2Unit, String productVitaminB6Unit, String productVitaminB12Unit, String productNiacinUnit, String productNiacinEquivalentUnit, String productFolicAcidUnit, String productBiotinUnit, String productPantothenicAcidUnit, String productSodiumUnit, String productPotassiumUnit, String productChlorideUnit, String productCalciumUnit, String productPhosphorusUnit, String productMagnesiumUnit, String productIronUnit, String productZincUnit, String productManganeseUnit, String productCopperUnit, String productIodineUnit, String productSeleniumUnit, String productChromiumUnit, String productMolybdenumUnit, String productWaterUnit, String productIsoleucineUnit, String productLeucineUnit, String productLysineUnit, String productMethionineUnit, String productPhenylalanineUnit, String productThreonineUnit, String productTryptophanUnit, String productValineUnit, String productHistidineUnit, String productAlanineUnit, String productArginineUnit, String productAsparticAcidUnit, String productCysteineUnit, String productGlutamicAcidUnit, String productGlycineUnit, String productProlineUnit, String productSerineUnit, String productTyrosineUnit, String productHydroxyLysineUnit, String productHydroxyProlineUnit, int position) {
        this.key = key;
        this.productId = productId;
        this.uid = uid;
        this.productIcon = productIcon;
        this.productName = productName;
        this.productDescription = productDescription;
        this.productCompany = productCompany;
        this.productIndication = productIndication;
        this.productIngredient = productIngredient;
        this.productAvailability = productAvailability;
        this.productRetailPrice = productRetailPrice;
        this.productSpecialFeatures = productSpecialFeatures;
        this.productStorage = productStorage;
        this.productCalorie = productCalorie;
        this.productOtherInfo = productOtherInfo;
        this.productServingSize = productServingSize;
        this.productPackSize = productPackSize;
        this.productCategory = productCategory;
        this.productSubCategory = productSubCategory;
        this.productAmount = productAmount;
        this.productAmountUnit = productAmountUnit;
        this.productAmountType = productAmountType;
        this.specialAvailable = specialAvailable;
        this.packSizeAvailable = packSizeAvailable;
        this.servingSizeAvailable = servingSizeAvailable;
        this.otherInfoAvailable = otherInfoAvailable;
        this.calorieAvailable = calorieAvailable;
        this.storageAvailable = storageAvailable;
        this.productEnergy = productEnergy;
        this.productProtein = productProtein;
        this.productFat = productFat;
        this.productMUFA = productMUFA;
        this.productPUFA = productPUFA;
        this.productLinoleicAcidOmega6 = productLinoleicAcidOmega6;
        this.productαlinolenicAcidOmega3 = productαlinolenicAcidOmega3;
        this.productEPA = productEPA;
        this.productDHA = productDHA;
        this.productSFA = productSFA;
        this.productMCTOil = productMCTOil;
        this.productTransFattyAcids = productTransFattyAcids;
        this.productCholesterol = productCholesterol;
        this.productCarbohydrate = productCarbohydrate;
        this.productSalt = productSalt;
        this.productLactose = productLactose;
        this.productPolyols = productPolyols;
        this.productFiber = productFiber;
        this.productFOS = productFOS;
        this.productDietaryFiber = productDietaryFiber;
        this.productSolubleFiber = productSolubleFiber;
        this.productSugar = productSugar;
        this.productEssentialAminoAcids = productEssentialAminoAcids;
        this.productBranchedChainAminoAcids = productBranchedChainAminoAcids;
        this.productInulin = productInulin;
        this.productCholine = productCholine;
        this.productTaurine = productTaurine;
        this.productCarnitine = productCarnitine;
        this.productLCarnitine = productLCarnitine;
        this.productCaHMB = productCaHMB;
        this.productHMB = productHMB;
        this.productInositol = productInositol;
        this.productαLactalbumin = productαLactalbumin;
        this.productβLactoglobulin = productβLactoglobulin;
        this.productGlycomacropeptide = productGlycomacropeptide;
        this.productImmunoglobulinGIgG = productImmunoglobulinGIgG;
        this.productBovineSerumAlbumin = productBovineSerumAlbumin;
        this.productProteasePeptone5 = productProteasePeptone5;
        this.productVitaminA = productVitaminA;
        this.productVitaminAPalmitate = productVitaminAPalmitate;
        this.productVitaminABCarotene = productVitaminABCarotene;
        this.productVitaminD = productVitaminD;
        this.productVitaminD3 = productVitaminD3;
        this.productVitaminE = productVitaminE;
        this.productVitaminK = productVitaminK;
        this.productVitaminK1 = productVitaminK1;
        this.productVitaminC = productVitaminC;
        this.productVitaminB1 = productVitaminB1;
        this.productVitaminB2 = productVitaminB2;
        this.productVitaminB6 = productVitaminB6;
        this.productVitaminB12 = productVitaminB12;
        this.productNiacin = productNiacin;
        this.productNiacinEquivalent = productNiacinEquivalent;
        this.productFolicAcid = productFolicAcid;
        this.productBiotin = productBiotin;
        this.productPantothenicAcid = productPantothenicAcid;
        this.productSodium = productSodium;
        this.productPotassium = productPotassium;
        this.productChloride = productChloride;
        this.productCalcium = productCalcium;
        this.productPhosphorus = productPhosphorus;
        this.productMagnesium = productMagnesium;
        this.productIron = productIron;
        this.productZinc = productZinc;
        this.productManganese = productManganese;
        this.productCopper = productCopper;
        this.productIodine = productIodine;
        this.productSelenium = productSelenium;
        this.productChromium = productChromium;
        this.productMolybdenum = productMolybdenum;
        this.productWater = productWater;
        this.productIsoleucine = productIsoleucine;
        this.productLeucine = productLeucine;
        this.productLysine = productLysine;
        this.productMethionine = productMethionine;
        this.productPhenylalanine = productPhenylalanine;
        this.productThreonine = productThreonine;
        this.productTryptophan = productTryptophan;
        this.productValine = productValine;
        this.productHistidine = productHistidine;
        this.productAlanine = productAlanine;
        this.productArginine = productArginine;
        this.productAsparticAcid = productAsparticAcid;
        this.productCysteine = productCysteine;
        this.productGlutamicAcid = productGlutamicAcid;
        this.productGlycine = productGlycine;
        this.productProline = productProline;
        this.productSerine = productSerine;
        this.productTyrosine = productTyrosine;
        this.productHydroxyLysine = productHydroxyLysine;
        this.productHydroxyProline = productHydroxyProline;
        this.productEnergyUnit = productEnergyUnit;
        this.productProteinUnit = productProteinUnit;
        this.productFatUnit = productFatUnit;
        this.productMUFAUnit = productMUFAUnit;
        this.productPUFAUnit = productPUFAUnit;
        this.productLinoleicAcidOmega6Unit = productLinoleicAcidOmega6Unit;
        this.productαlinolenicAcidOmega3Unit = productαlinolenicAcidOmega3Unit;
        this.productEPAUnit = productEPAUnit;
        this.productDHAUnit = productDHAUnit;
        this.productSFAUnit = productSFAUnit;
        this.productMCTOilUnit = productMCTOilUnit;
        this.productTransFattyAcidsUnit = productTransFattyAcidsUnit;
        this.productCholesterolUnit = productCholesterolUnit;
        this.productCarbohydrateUnit = productCarbohydrateUnit;
        this.productSaltUnit = productSaltUnit;
        this.productLactoseUnit = productLactoseUnit;
        this.productPolyolsUnit = productPolyolsUnit;
        this.productFiberUnit = productFiberUnit;
        this.productFOSUnit = productFOSUnit;
        this.productDietaryFiberUnit = productDietaryFiberUnit;
        this.productSolubleFiberUnit = productSolubleFiberUnit;
        this.productSugarUnit = productSugarUnit;
        this.productEssentialAminoAcidsUnit = productEssentialAminoAcidsUnit;
        this.productBranchedChainAminoAcidsUnit = productBranchedChainAminoAcidsUnit;
        this.productInulinUnit = productInulinUnit;
        this.productCholineUnit = productCholineUnit;
        this.productTaurineUnit = productTaurineUnit;
        this.productCarnitineUnit = productCarnitineUnit;
        this.productLCarnitineUnit = productLCarnitineUnit;
        this.productCaHMBUnit = productCaHMBUnit;
        this.productHMBUnit = productHMBUnit;
        this.productInositolUnit = productInositolUnit;
        this.productαLactalbuminUnit = productαLactalbuminUnit;
        this.productβLactoglobulinUnit = productβLactoglobulinUnit;
        this.productGlycomacropeptideUnit = productGlycomacropeptideUnit;
        this.productImmunoglobulinGIgGUnit = productImmunoglobulinGIgGUnit;
        this.productBovineSerumAlbuminUnit = productBovineSerumAlbuminUnit;
        this.productProteasePeptone5Unit = productProteasePeptone5Unit;
        this.productVitaminAUnit = productVitaminAUnit;
        this.productVitaminAPalmitateUnit = productVitaminAPalmitateUnit;
        this.productVitaminABCaroteneUnit = productVitaminABCaroteneUnit;
        this.productVitaminDUnit = productVitaminDUnit;
        this.productVitaminD3Unit = productVitaminD3Unit;
        this.productVitaminEUnit = productVitaminEUnit;
        this.productVitaminKUnit = productVitaminKUnit;
        this.productVitaminK1Unit = productVitaminK1Unit;
        this.productVitaminCUnit = productVitaminCUnit;
        this.productVitaminB1Unit = productVitaminB1Unit;
        this.productVitaminB2Unit = productVitaminB2Unit;
        this.productVitaminB6Unit = productVitaminB6Unit;
        this.productVitaminB12Unit = productVitaminB12Unit;
        this.productNiacinUnit = productNiacinUnit;
        this.productNiacinEquivalentUnit = productNiacinEquivalentUnit;
        this.productFolicAcidUnit = productFolicAcidUnit;
        this.productBiotinUnit = productBiotinUnit;
        this.productPantothenicAcidUnit = productPantothenicAcidUnit;
        this.productSodiumUnit = productSodiumUnit;
        this.productPotassiumUnit = productPotassiumUnit;
        this.productChlorideUnit = productChlorideUnit;
        this.productCalciumUnit = productCalciumUnit;
        this.productPhosphorusUnit = productPhosphorusUnit;
        this.productMagnesiumUnit = productMagnesiumUnit;
        this.productIronUnit = productIronUnit;
        this.productZincUnit = productZincUnit;
        this.productManganeseUnit = productManganeseUnit;
        this.productCopperUnit = productCopperUnit;
        this.productIodineUnit = productIodineUnit;
        this.productSeleniumUnit = productSeleniumUnit;
        this.productChromiumUnit = productChromiumUnit;
        this.productMolybdenumUnit = productMolybdenumUnit;
        this.productWaterUnit = productWaterUnit;
        this.productIsoleucineUnit = productIsoleucineUnit;
        this.productLeucineUnit = productLeucineUnit;
        this.productLysineUnit = productLysineUnit;
        this.productMethionineUnit = productMethionineUnit;
        this.productPhenylalanineUnit = productPhenylalanineUnit;
        this.productThreonineUnit = productThreonineUnit;
        this.productTryptophanUnit = productTryptophanUnit;
        this.productValineUnit = productValineUnit;
        this.productHistidineUnit = productHistidineUnit;
        this.productAlanineUnit = productAlanineUnit;
        this.productArginineUnit = productArginineUnit;
        this.productAsparticAcidUnit = productAsparticAcidUnit;
        this.productCysteineUnit = productCysteineUnit;
        this.productGlutamicAcidUnit = productGlutamicAcidUnit;
        this.productGlycineUnit = productGlycineUnit;
        this.productProlineUnit = productProlineUnit;
        this.productSerineUnit = productSerineUnit;
        this.productTyrosineUnit = productTyrosineUnit;
        this.productHydroxyLysineUnit = productHydroxyLysineUnit;
        this.productHydroxyProlineUnit = productHydroxyProlineUnit;
        this.position = position;
    }

    private int position;

    public ModelProduct() {
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getProductIcon() {
        return productIcon;
    }

    public void setProductIcon(String productIcon) {
        this.productIcon = productIcon;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getProductCompany() {
        return productCompany;
    }

    public void setProductCompany(String productCompany) {
        this.productCompany = productCompany;
    }

    public String getProductIndication() {
        return productIndication;
    }

    public void setProductIndication(String productIndication) {
        this.productIndication = productIndication;
    }

    public String getProductIngredient() {
        return productIngredient;
    }

    public void setProductIngredient(String productIngredient) {
        this.productIngredient = productIngredient;
    }

    public String getProductAvailability() {
        return productAvailability;
    }

    public void setProductAvailability(String productAvailability) {
        this.productAvailability = productAvailability;
    }

    public String getProductRetailPrice() {
        return productRetailPrice;
    }

    public void setProductRetailPrice(String productRetailPrice) {
        this.productRetailPrice = productRetailPrice;
    }

    public String getProductSpecialFeatures() {
        return productSpecialFeatures;
    }

    public void setProductSpecialFeatures(String productSpecialFeatures) {
        this.productSpecialFeatures = productSpecialFeatures;
    }

    public String getProductStorage() {
        return productStorage;
    }

    public void setProductStorage(String productStorage) {
        this.productStorage = productStorage;
    }

    public String getProductCalorie() {
        return productCalorie;
    }

    public void setProductCalorie(String productCalorie) {
        this.productCalorie = productCalorie;
    }

    public String getProductOtherInfo() {
        return productOtherInfo;
    }

    public void setProductOtherInfo(String productOtherInfo) {
        this.productOtherInfo = productOtherInfo;
    }

    public String getProductServingSize() {
        return productServingSize;
    }

    public void setProductServingSize(String productServingSize) {
        this.productServingSize = productServingSize;
    }

    public String getProductPackSize() {
        return productPackSize;
    }

    public void setProductPackSize(String productPackSize) {
        this.productPackSize = productPackSize;
    }

    public String getProductCategory() {
        return productCategory;
    }

    public void setProductCategory(String productCategory) {
        this.productCategory = productCategory;
    }

    public String getProductSubCategory() {
        return productSubCategory;
    }

    public void setProductSubCategory(String productSubCategory) {
        this.productSubCategory = productSubCategory;
    }

    public String getProductAmount() {
        return productAmount;
    }

    public void setProductAmount(String productAmount) {
        this.productAmount = productAmount;
    }

    public String getProductAmountUnit() {
        return productAmountUnit;
    }

    public void setProductAmountUnit(String productAmountUnit) {
        this.productAmountUnit = productAmountUnit;
    }

    public String getProductAmountType() {
        return productAmountType;
    }

    public void setProductAmountType(String productAmountType) {
        this.productAmountType = productAmountType;
    }

    public String getSpecialAvailable() {
        return specialAvailable;
    }

    public void setSpecialAvailable(String specialAvailable) {
        this.specialAvailable = specialAvailable;
    }

    public String getPackSizeAvailable() {
        return packSizeAvailable;
    }

    public void setPackSizeAvailable(String packSizeAvailable) {
        this.packSizeAvailable = packSizeAvailable;
    }

    public String getServingSizeAvailable() {
        return servingSizeAvailable;
    }

    public void setServingSizeAvailable(String servingSizeAvailable) {
        this.servingSizeAvailable = servingSizeAvailable;
    }

    public String getOtherInfoAvailable() {
        return otherInfoAvailable;
    }

    public void setOtherInfoAvailable(String otherInfoAvailable) {
        this.otherInfoAvailable = otherInfoAvailable;
    }

    public String getCalorieAvailable() {
        return calorieAvailable;
    }

    public void setCalorieAvailable(String calorieAvailable) {
        this.calorieAvailable = calorieAvailable;
    }

    public String getStorageAvailable() {
        return storageAvailable;
    }

    public void setStorageAvailable(String storageAvailable) {
        this.storageAvailable = storageAvailable;
    }

    public String getProductEnergy() {
        return productEnergy;
    }

    public void setProductEnergy(String productEnergy) {
        this.productEnergy = productEnergy;
    }

    public String getProductProtein() {
        return productProtein;
    }

    public void setProductProtein(String productProtein) {
        this.productProtein = productProtein;
    }

    public String getProductFat() {
        return productFat;
    }

    public void setProductFat(String productFat) {
        this.productFat = productFat;
    }

    public String getProductMUFA() {
        return productMUFA;
    }

    public void setProductMUFA(String productMUFA) {
        this.productMUFA = productMUFA;
    }

    public String getProductPUFA() {
        return productPUFA;
    }

    public void setProductPUFA(String productPUFA) {
        this.productPUFA = productPUFA;
    }

    public String getProductLinoleicAcidOmega6() {
        return productLinoleicAcidOmega6;
    }

    public void setProductLinoleicAcidOmega6(String productLinoleicAcidOmega6) {
        this.productLinoleicAcidOmega6 = productLinoleicAcidOmega6;
    }

    public String getProductαlinolenicAcidOmega3() {
        return productαlinolenicAcidOmega3;
    }

    public void setProductαlinolenicAcidOmega3(String productαlinolenicAcidOmega3) {
        this.productαlinolenicAcidOmega3 = productαlinolenicAcidOmega3;
    }

    public String getProductEPA() {
        return productEPA;
    }

    public void setProductEPA(String productEPA) {
        this.productEPA = productEPA;
    }

    public String getProductDHA() {
        return productDHA;
    }

    public void setProductDHA(String productDHA) {
        this.productDHA = productDHA;
    }

    public String getProductSFA() {
        return productSFA;
    }

    public void setProductSFA(String productSFA) {
        this.productSFA = productSFA;
    }

    public String getProductMCTOil() {
        return productMCTOil;
    }

    public void setProductMCTOil(String productMCTOil) {
        this.productMCTOil = productMCTOil;
    }

    public String getProductTransFattyAcids() {
        return productTransFattyAcids;
    }

    public void setProductTransFattyAcids(String productTransFattyAcids) {
        this.productTransFattyAcids = productTransFattyAcids;
    }

    public String getProductCholesterol() {
        return productCholesterol;
    }

    public void setProductCholesterol(String productCholesterol) {
        this.productCholesterol = productCholesterol;
    }

    public String getProductCarbohydrate() {
        return productCarbohydrate;
    }

    public void setProductCarbohydrate(String productCarbohydrate) {
        this.productCarbohydrate = productCarbohydrate;
    }

    public String getProductSalt() {
        return productSalt;
    }

    public void setProductSalt(String productSalt) {
        this.productSalt = productSalt;
    }

    public String getProductLactose() {
        return productLactose;
    }

    public void setProductLactose(String productLactose) {
        this.productLactose = productLactose;
    }

    public String getProductPolyols() {
        return productPolyols;
    }

    public void setProductPolyols(String productPolyols) {
        this.productPolyols = productPolyols;
    }

    public String getProductFiber() {
        return productFiber;
    }

    public void setProductFiber(String productFiber) {
        this.productFiber = productFiber;
    }

    public String getProductFOS() {
        return productFOS;
    }

    public void setProductFOS(String productFOS) {
        this.productFOS = productFOS;
    }

    public String getProductDietaryFiber() {
        return productDietaryFiber;
    }

    public void setProductDietaryFiber(String productDietaryFiber) {
        this.productDietaryFiber = productDietaryFiber;
    }

    public String getProductSolubleFiber() {
        return productSolubleFiber;
    }

    public void setProductSolubleFiber(String productSolubleFiber) {
        this.productSolubleFiber = productSolubleFiber;
    }

    public String getProductSugar() {
        return productSugar;
    }

    public void setProductSugar(String productSugar) {
        this.productSugar = productSugar;
    }

    public String getProductEssentialAminoAcids() {
        return productEssentialAminoAcids;
    }

    public void setProductEssentialAminoAcids(String productEssentialAminoAcids) {
        this.productEssentialAminoAcids = productEssentialAminoAcids;
    }

    public String getProductBranchedChainAminoAcids() {
        return productBranchedChainAminoAcids;
    }

    public void setProductBranchedChainAminoAcids(String productBranchedChainAminoAcids) {
        this.productBranchedChainAminoAcids = productBranchedChainAminoAcids;
    }

    public String getProductInulin() {
        return productInulin;
    }

    public void setProductInulin(String productInulin) {
        this.productInulin = productInulin;
    }

    public String getProductCholine() {
        return productCholine;
    }

    public void setProductCholine(String productCholine) {
        this.productCholine = productCholine;
    }

    public String getProductTaurine() {
        return productTaurine;
    }

    public void setProductTaurine(String productTaurine) {
        this.productTaurine = productTaurine;
    }

    public String getProductCarnitine() {
        return productCarnitine;
    }

    public void setProductCarnitine(String productCarnitine) {
        this.productCarnitine = productCarnitine;
    }

    public String getProductLCarnitine() {
        return productLCarnitine;
    }

    public void setProductLCarnitine(String productLCarnitine) {
        this.productLCarnitine = productLCarnitine;
    }

    public String getProductCaHMB() {
        return productCaHMB;
    }

    public void setProductCaHMB(String productCaHMB) {
        this.productCaHMB = productCaHMB;
    }

    public String getProductHMB() {
        return productHMB;
    }

    public void setProductHMB(String productHMB) {
        this.productHMB = productHMB;
    }

    public String getProductInositol() {
        return productInositol;
    }

    public void setProductInositol(String productInositol) {
        this.productInositol = productInositol;
    }

    public String getProductαLactalbumin() {
        return productαLactalbumin;
    }

    public void setProductαLactalbumin(String productαLactalbumin) {
        this.productαLactalbumin = productαLactalbumin;
    }

    public String getProductβLactoglobulin() {
        return productβLactoglobulin;
    }

    public void setProductβLactoglobulin(String productβLactoglobulin) {
        this.productβLactoglobulin = productβLactoglobulin;
    }

    public String getProductGlycomacropeptide() {
        return productGlycomacropeptide;
    }

    public void setProductGlycomacropeptide(String productGlycomacropeptide) {
        this.productGlycomacropeptide = productGlycomacropeptide;
    }

    public String getProductImmunoglobulinGIgG() {
        return productImmunoglobulinGIgG;
    }

    public void setProductImmunoglobulinGIgG(String productImmunoglobulinGIgG) {
        this.productImmunoglobulinGIgG = productImmunoglobulinGIgG;
    }

    public String getProductBovineSerumAlbumin() {
        return productBovineSerumAlbumin;
    }

    public void setProductBovineSerumAlbumin(String productBovineSerumAlbumin) {
        this.productBovineSerumAlbumin = productBovineSerumAlbumin;
    }

    public String getProductProteasePeptone5() {
        return productProteasePeptone5;
    }

    public void setProductProteasePeptone5(String productProteasePeptone5) {
        this.productProteasePeptone5 = productProteasePeptone5;
    }

    public String getProductVitaminA() {
        return productVitaminA;
    }

    public void setProductVitaminA(String productVitaminA) {
        this.productVitaminA = productVitaminA;
    }

    public String getProductVitaminAPalmitate() {
        return productVitaminAPalmitate;
    }

    public void setProductVitaminAPalmitate(String productVitaminAPalmitate) {
        this.productVitaminAPalmitate = productVitaminAPalmitate;
    }

    public String getProductVitaminABCarotene() {
        return productVitaminABCarotene;
    }

    public void setProductVitaminABCarotene(String productVitaminABCarotene) {
        this.productVitaminABCarotene = productVitaminABCarotene;
    }

    public String getProductVitaminD() {
        return productVitaminD;
    }

    public void setProductVitaminD(String productVitaminD) {
        this.productVitaminD = productVitaminD;
    }

    public String getProductVitaminD3() {
        return productVitaminD3;
    }

    public void setProductVitaminD3(String productVitaminD3) {
        this.productVitaminD3 = productVitaminD3;
    }

    public String getProductVitaminE() {
        return productVitaminE;
    }

    public void setProductVitaminE(String productVitaminE) {
        this.productVitaminE = productVitaminE;
    }

    public String getProductVitaminK() {
        return productVitaminK;
    }

    public void setProductVitaminK(String productVitaminK) {
        this.productVitaminK = productVitaminK;
    }

    public String getProductVitaminK1() {
        return productVitaminK1;
    }

    public void setProductVitaminK1(String productVitaminK1) {
        this.productVitaminK1 = productVitaminK1;
    }

    public String getProductVitaminC() {
        return productVitaminC;
    }

    public void setProductVitaminC(String productVitaminC) {
        this.productVitaminC = productVitaminC;
    }

    public String getProductVitaminB1() {
        return productVitaminB1;
    }

    public void setProductVitaminB1(String productVitaminB1) {
        this.productVitaminB1 = productVitaminB1;
    }

    public String getProductVitaminB2() {
        return productVitaminB2;
    }

    public void setProductVitaminB2(String productVitaminB2) {
        this.productVitaminB2 = productVitaminB2;
    }

    public String getProductVitaminB6() {
        return productVitaminB6;
    }

    public void setProductVitaminB6(String productVitaminB6) {
        this.productVitaminB6 = productVitaminB6;
    }

    public String getProductVitaminB12() {
        return productVitaminB12;
    }

    public void setProductVitaminB12(String productVitaminB12) {
        this.productVitaminB12 = productVitaminB12;
    }

    public String getProductNiacin() {
        return productNiacin;
    }

    public void setProductNiacin(String productNiacin) {
        this.productNiacin = productNiacin;
    }

    public String getProductNiacinEquivalent() {
        return productNiacinEquivalent;
    }

    public void setProductNiacinEquivalent(String productNiacinEquivalent) {
        this.productNiacinEquivalent = productNiacinEquivalent;
    }

    public String getProductFolicAcid() {
        return productFolicAcid;
    }

    public void setProductFolicAcid(String productFolicAcid) {
        this.productFolicAcid = productFolicAcid;
    }

    public String getProductBiotin() {
        return productBiotin;
    }

    public void setProductBiotin(String productBiotin) {
        this.productBiotin = productBiotin;
    }

    public String getProductPantothenicAcid() {
        return productPantothenicAcid;
    }

    public void setProductPantothenicAcid(String productPantothenicAcid) {
        this.productPantothenicAcid = productPantothenicAcid;
    }

    public String getProductSodium() {
        return productSodium;
    }

    public void setProductSodium(String productSodium) {
        this.productSodium = productSodium;
    }

    public String getProductPotassium() {
        return productPotassium;
    }

    public void setProductPotassium(String productPotassium) {
        this.productPotassium = productPotassium;
    }

    public String getProductChloride() {
        return productChloride;
    }

    public void setProductChloride(String productChloride) {
        this.productChloride = productChloride;
    }

    public String getProductCalcium() {
        return productCalcium;
    }

    public void setProductCalcium(String productCalcium) {
        this.productCalcium = productCalcium;
    }

    public String getProductPhosphorus() {
        return productPhosphorus;
    }

    public void setProductPhosphorus(String productPhosphorus) {
        this.productPhosphorus = productPhosphorus;
    }

    public String getProductMagnesium() {
        return productMagnesium;
    }

    public void setProductMagnesium(String productMagnesium) {
        this.productMagnesium = productMagnesium;
    }

    public String getProductIron() {
        return productIron;
    }

    public void setProductIron(String productIron) {
        this.productIron = productIron;
    }

    public String getProductZinc() {
        return productZinc;
    }

    public void setProductZinc(String productZinc) {
        this.productZinc = productZinc;
    }

    public String getProductManganese() {
        return productManganese;
    }

    public void setProductManganese(String productManganese) {
        this.productManganese = productManganese;
    }

    public String getProductCopper() {
        return productCopper;
    }

    public void setProductCopper(String productCopper) {
        this.productCopper = productCopper;
    }

    public String getProductIodine() {
        return productIodine;
    }

    public void setProductIodine(String productIodine) {
        this.productIodine = productIodine;
    }

    public String getProductSelenium() {
        return productSelenium;
    }

    public void setProductSelenium(String productSelenium) {
        this.productSelenium = productSelenium;
    }

    public String getProductChromium() {
        return productChromium;
    }

    public void setProductChromium(String productChromium) {
        this.productChromium = productChromium;
    }

    public String getProductMolybdenum() {
        return productMolybdenum;
    }

    public void setProductMolybdenum(String productMolybdenum) {
        this.productMolybdenum = productMolybdenum;
    }

    public String getProductWater() {
        return productWater;
    }

    public void setProductWater(String productWater) {
        this.productWater = productWater;
    }

    public String getProductIsoleucine() {
        return productIsoleucine;
    }

    public void setProductIsoleucine(String productIsoleucine) {
        this.productIsoleucine = productIsoleucine;
    }

    public String getProductLeucine() {
        return productLeucine;
    }

    public void setProductLeucine(String productLeucine) {
        this.productLeucine = productLeucine;
    }

    public String getProductLysine() {
        return productLysine;
    }

    public void setProductLysine(String productLysine) {
        this.productLysine = productLysine;
    }

    public String getProductMethionine() {
        return productMethionine;
    }

    public void setProductMethionine(String productMethionine) {
        this.productMethionine = productMethionine;
    }

    public String getProductPhenylalanine() {
        return productPhenylalanine;
    }

    public void setProductPhenylalanine(String productPhenylalanine) {
        this.productPhenylalanine = productPhenylalanine;
    }

    public String getProductThreonine() {
        return productThreonine;
    }

    public void setProductThreonine(String productThreonine) {
        this.productThreonine = productThreonine;
    }

    public String getProductTryptophan() {
        return productTryptophan;
    }

    public void setProductTryptophan(String productTryptophan) {
        this.productTryptophan = productTryptophan;
    }

    public String getProductValine() {
        return productValine;
    }

    public void setProductValine(String productValine) {
        this.productValine = productValine;
    }

    public String getProductHistidine() {
        return productHistidine;
    }

    public void setProductHistidine(String productHistidine) {
        this.productHistidine = productHistidine;
    }

    public String getProductAlanine() {
        return productAlanine;
    }

    public void setProductAlanine(String productAlanine) {
        this.productAlanine = productAlanine;
    }

    public String getProductArginine() {
        return productArginine;
    }

    public void setProductArginine(String productArginine) {
        this.productArginine = productArginine;
    }

    public String getProductAsparticAcid() {
        return productAsparticAcid;
    }

    public void setProductAsparticAcid(String productAsparticAcid) {
        this.productAsparticAcid = productAsparticAcid;
    }

    public String getProductCysteine() {
        return productCysteine;
    }

    public void setProductCysteine(String productCysteine) {
        this.productCysteine = productCysteine;
    }

    public String getProductGlutamicAcid() {
        return productGlutamicAcid;
    }

    public void setProductGlutamicAcid(String productGlutamicAcid) {
        this.productGlutamicAcid = productGlutamicAcid;
    }

    public String getProductGlycine() {
        return productGlycine;
    }

    public void setProductGlycine(String productGlycine) {
        this.productGlycine = productGlycine;
    }

    public String getProductProline() {
        return productProline;
    }

    public void setProductProline(String productProline) {
        this.productProline = productProline;
    }

    public String getProductSerine() {
        return productSerine;
    }

    public void setProductSerine(String productSerine) {
        this.productSerine = productSerine;
    }

    public String getProductTyrosine() {
        return productTyrosine;
    }

    public void setProductTyrosine(String productTyrosine) {
        this.productTyrosine = productTyrosine;
    }

    public String getProductHydroxyLysine() {
        return productHydroxyLysine;
    }

    public void setProductHydroxyLysine(String productHydroxyLysine) {
        this.productHydroxyLysine = productHydroxyLysine;
    }

    public String getProductHydroxyProline() {
        return productHydroxyProline;
    }

    public void setProductHydroxyProline(String productHydroxyProline) {
        this.productHydroxyProline = productHydroxyProline;
    }

    public String getProductEnergyUnit() {
        return productEnergyUnit;
    }

    public void setProductEnergyUnit(String productEnergyUnit) {
        this.productEnergyUnit = productEnergyUnit;
    }

    public String getProductProteinUnit() {
        return productProteinUnit;
    }

    public void setProductProteinUnit(String productProteinUnit) {
        this.productProteinUnit = productProteinUnit;
    }

    public String getProductFatUnit() {
        return productFatUnit;
    }

    public void setProductFatUnit(String productFatUnit) {
        this.productFatUnit = productFatUnit;
    }

    public String getProductMUFAUnit() {
        return productMUFAUnit;
    }

    public void setProductMUFAUnit(String productMUFAUnit) {
        this.productMUFAUnit = productMUFAUnit;
    }

    public String getProductPUFAUnit() {
        return productPUFAUnit;
    }

    public void setProductPUFAUnit(String productPUFAUnit) {
        this.productPUFAUnit = productPUFAUnit;
    }

    public String getProductLinoleicAcidOmega6Unit() {
        return productLinoleicAcidOmega6Unit;
    }

    public void setProductLinoleicAcidOmega6Unit(String productLinoleicAcidOmega6Unit) {
        this.productLinoleicAcidOmega6Unit = productLinoleicAcidOmega6Unit;
    }

    public String getProductαlinolenicAcidOmega3Unit() {
        return productαlinolenicAcidOmega3Unit;
    }

    public void setProductαlinolenicAcidOmega3Unit(String productαlinolenicAcidOmega3Unit) {
        this.productαlinolenicAcidOmega3Unit = productαlinolenicAcidOmega3Unit;
    }

    public String getProductEPAUnit() {
        return productEPAUnit;
    }

    public void setProductEPAUnit(String productEPAUnit) {
        this.productEPAUnit = productEPAUnit;
    }

    public String getProductDHAUnit() {
        return productDHAUnit;
    }

    public void setProductDHAUnit(String productDHAUnit) {
        this.productDHAUnit = productDHAUnit;
    }

    public String getProductSFAUnit() {
        return productSFAUnit;
    }

    public void setProductSFAUnit(String productSFAUnit) {
        this.productSFAUnit = productSFAUnit;
    }

    public String getProductMCTOilUnit() {
        return productMCTOilUnit;
    }

    public void setProductMCTOilUnit(String productMCTOilUnit) {
        this.productMCTOilUnit = productMCTOilUnit;
    }

    public String getProductTransFattyAcidsUnit() {
        return productTransFattyAcidsUnit;
    }

    public void setProductTransFattyAcidsUnit(String productTransFattyAcidsUnit) {
        this.productTransFattyAcidsUnit = productTransFattyAcidsUnit;
    }

    public String getProductCholesterolUnit() {
        return productCholesterolUnit;
    }

    public void setProductCholesterolUnit(String productCholesterolUnit) {
        this.productCholesterolUnit = productCholesterolUnit;
    }

    public String getProductCarbohydrateUnit() {
        return productCarbohydrateUnit;
    }

    public void setProductCarbohydrateUnit(String productCarbohydrateUnit) {
        this.productCarbohydrateUnit = productCarbohydrateUnit;
    }

    public String getProductSaltUnit() {
        return productSaltUnit;
    }

    public void setProductSaltUnit(String productSaltUnit) {
        this.productSaltUnit = productSaltUnit;
    }

    public String getProductLactoseUnit() {
        return productLactoseUnit;
    }

    public void setProductLactoseUnit(String productLactoseUnit) {
        this.productLactoseUnit = productLactoseUnit;
    }

    public String getProductPolyolsUnit() {
        return productPolyolsUnit;
    }

    public void setProductPolyolsUnit(String productPolyolsUnit) {
        this.productPolyolsUnit = productPolyolsUnit;
    }

    public String getProductFiberUnit() {
        return productFiberUnit;
    }

    public void setProductFiberUnit(String productFiberUnit) {
        this.productFiberUnit = productFiberUnit;
    }

    public String getProductFOSUnit() {
        return productFOSUnit;
    }

    public void setProductFOSUnit(String productFOSUnit) {
        this.productFOSUnit = productFOSUnit;
    }

    public String getProductDietaryFiberUnit() {
        return productDietaryFiberUnit;
    }

    public void setProductDietaryFiberUnit(String productDietaryFiberUnit) {
        this.productDietaryFiberUnit = productDietaryFiberUnit;
    }

    public String getProductSolubleFiberUnit() {
        return productSolubleFiberUnit;
    }

    public void setProductSolubleFiberUnit(String productSolubleFiberUnit) {
        this.productSolubleFiberUnit = productSolubleFiberUnit;
    }

    public String getProductSugarUnit() {
        return productSugarUnit;
    }

    public void setProductSugarUnit(String productSugarUnit) {
        this.productSugarUnit = productSugarUnit;
    }

    public String getProductEssentialAminoAcidsUnit() {
        return productEssentialAminoAcidsUnit;
    }

    public void setProductEssentialAminoAcidsUnit(String productEssentialAminoAcidsUnit) {
        this.productEssentialAminoAcidsUnit = productEssentialAminoAcidsUnit;
    }

    public String getProductBranchedChainAminoAcidsUnit() {
        return productBranchedChainAminoAcidsUnit;
    }

    public void setProductBranchedChainAminoAcidsUnit(String productBranchedChainAminoAcidsUnit) {
        this.productBranchedChainAminoAcidsUnit = productBranchedChainAminoAcidsUnit;
    }

    public String getProductInulinUnit() {
        return productInulinUnit;
    }

    public void setProductInulinUnit(String productInulinUnit) {
        this.productInulinUnit = productInulinUnit;
    }

    public String getProductCholineUnit() {
        return productCholineUnit;
    }

    public void setProductCholineUnit(String productCholineUnit) {
        this.productCholineUnit = productCholineUnit;
    }

    public String getProductTaurineUnit() {
        return productTaurineUnit;
    }

    public void setProductTaurineUnit(String productTaurineUnit) {
        this.productTaurineUnit = productTaurineUnit;
    }

    public String getProductCarnitineUnit() {
        return productCarnitineUnit;
    }

    public void setProductCarnitineUnit(String productCarnitineUnit) {
        this.productCarnitineUnit = productCarnitineUnit;
    }

    public String getProductLCarnitineUnit() {
        return productLCarnitineUnit;
    }

    public void setProductLCarnitineUnit(String productLCarnitineUnit) {
        this.productLCarnitineUnit = productLCarnitineUnit;
    }

    public String getProductCaHMBUnit() {
        return productCaHMBUnit;
    }

    public void setProductCaHMBUnit(String productCaHMBUnit) {
        this.productCaHMBUnit = productCaHMBUnit;
    }

    public String getProductHMBUnit() {
        return productHMBUnit;
    }

    public void setProductHMBUnit(String productHMBUnit) {
        this.productHMBUnit = productHMBUnit;
    }

    public String getProductInositolUnit() {
        return productInositolUnit;
    }

    public void setProductInositolUnit(String productInositolUnit) {
        this.productInositolUnit = productInositolUnit;
    }

    public String getProductαLactalbuminUnit() {
        return productαLactalbuminUnit;
    }

    public void setProductαLactalbuminUnit(String productαLactalbuminUnit) {
        this.productαLactalbuminUnit = productαLactalbuminUnit;
    }

    public String getProductβLactoglobulinUnit() {
        return productβLactoglobulinUnit;
    }

    public void setProductβLactoglobulinUnit(String productβLactoglobulinUnit) {
        this.productβLactoglobulinUnit = productβLactoglobulinUnit;
    }

    public String getProductGlycomacropeptideUnit() {
        return productGlycomacropeptideUnit;
    }

    public void setProductGlycomacropeptideUnit(String productGlycomacropeptideUnit) {
        this.productGlycomacropeptideUnit = productGlycomacropeptideUnit;
    }

    public String getProductImmunoglobulinGIgGUnit() {
        return productImmunoglobulinGIgGUnit;
    }

    public void setProductImmunoglobulinGIgGUnit(String productImmunoglobulinGIgGUnit) {
        this.productImmunoglobulinGIgGUnit = productImmunoglobulinGIgGUnit;
    }

    public String getProductBovineSerumAlbuminUnit() {
        return productBovineSerumAlbuminUnit;
    }

    public void setProductBovineSerumAlbuminUnit(String productBovineSerumAlbuminUnit) {
        this.productBovineSerumAlbuminUnit = productBovineSerumAlbuminUnit;
    }

    public String getProductProteasePeptone5Unit() {
        return productProteasePeptone5Unit;
    }

    public void setProductProteasePeptone5Unit(String productProteasePeptone5Unit) {
        this.productProteasePeptone5Unit = productProteasePeptone5Unit;
    }

    public String getProductVitaminAUnit() {
        return productVitaminAUnit;
    }

    public void setProductVitaminAUnit(String productVitaminAUnit) {
        this.productVitaminAUnit = productVitaminAUnit;
    }

    public String getProductVitaminAPalmitateUnit() {
        return productVitaminAPalmitateUnit;
    }

    public void setProductVitaminAPalmitateUnit(String productVitaminAPalmitateUnit) {
        this.productVitaminAPalmitateUnit = productVitaminAPalmitateUnit;
    }

    public String getProductVitaminABCaroteneUnit() {
        return productVitaminABCaroteneUnit;
    }

    public void setProductVitaminABCaroteneUnit(String productVitaminABCaroteneUnit) {
        this.productVitaminABCaroteneUnit = productVitaminABCaroteneUnit;
    }

    public String getProductVitaminDUnit() {
        return productVitaminDUnit;
    }

    public void setProductVitaminDUnit(String productVitaminDUnit) {
        this.productVitaminDUnit = productVitaminDUnit;
    }

    public String getProductVitaminD3Unit() {
        return productVitaminD3Unit;
    }

    public void setProductVitaminD3Unit(String productVitaminD3Unit) {
        this.productVitaminD3Unit = productVitaminD3Unit;
    }

    public String getProductVitaminEUnit() {
        return productVitaminEUnit;
    }

    public void setProductVitaminEUnit(String productVitaminEUnit) {
        this.productVitaminEUnit = productVitaminEUnit;
    }

    public String getProductVitaminKUnit() {
        return productVitaminKUnit;
    }

    public void setProductVitaminKUnit(String productVitaminKUnit) {
        this.productVitaminKUnit = productVitaminKUnit;
    }

    public String getProductVitaminK1Unit() {
        return productVitaminK1Unit;
    }

    public void setProductVitaminK1Unit(String productVitaminK1Unit) {
        this.productVitaminK1Unit = productVitaminK1Unit;
    }

    public String getProductVitaminCUnit() {
        return productVitaminCUnit;
    }

    public void setProductVitaminCUnit(String productVitaminCUnit) {
        this.productVitaminCUnit = productVitaminCUnit;
    }

    public String getProductVitaminB1Unit() {
        return productVitaminB1Unit;
    }

    public void setProductVitaminB1Unit(String productVitaminB1Unit) {
        this.productVitaminB1Unit = productVitaminB1Unit;
    }

    public String getProductVitaminB2Unit() {
        return productVitaminB2Unit;
    }

    public void setProductVitaminB2Unit(String productVitaminB2Unit) {
        this.productVitaminB2Unit = productVitaminB2Unit;
    }

    public String getProductVitaminB6Unit() {
        return productVitaminB6Unit;
    }

    public void setProductVitaminB6Unit(String productVitaminB6Unit) {
        this.productVitaminB6Unit = productVitaminB6Unit;
    }

    public String getProductVitaminB12Unit() {
        return productVitaminB12Unit;
    }

    public void setProductVitaminB12Unit(String productVitaminB12Unit) {
        this.productVitaminB12Unit = productVitaminB12Unit;
    }

    public String getProductNiacinUnit() {
        return productNiacinUnit;
    }

    public void setProductNiacinUnit(String productNiacinUnit) {
        this.productNiacinUnit = productNiacinUnit;
    }

    public String getProductNiacinEquivalentUnit() {
        return productNiacinEquivalentUnit;
    }

    public void setProductNiacinEquivalentUnit(String productNiacinEquivalentUnit) {
        this.productNiacinEquivalentUnit = productNiacinEquivalentUnit;
    }

    public String getProductFolicAcidUnit() {
        return productFolicAcidUnit;
    }

    public void setProductFolicAcidUnit(String productFolicAcidUnit) {
        this.productFolicAcidUnit = productFolicAcidUnit;
    }

    public String getProductBiotinUnit() {
        return productBiotinUnit;
    }

    public void setProductBiotinUnit(String productBiotinUnit) {
        this.productBiotinUnit = productBiotinUnit;
    }

    public String getProductPantothenicAcidUnit() {
        return productPantothenicAcidUnit;
    }

    public void setProductPantothenicAcidUnit(String productPantothenicAcidUnit) {
        this.productPantothenicAcidUnit = productPantothenicAcidUnit;
    }

    public String getProductSodiumUnit() {
        return productSodiumUnit;
    }

    public void setProductSodiumUnit(String productSodiumUnit) {
        this.productSodiumUnit = productSodiumUnit;
    }

    public String getProductPotassiumUnit() {
        return productPotassiumUnit;
    }

    public void setProductPotassiumUnit(String productPotassiumUnit) {
        this.productPotassiumUnit = productPotassiumUnit;
    }

    public String getProductChlorideUnit() {
        return productChlorideUnit;
    }

    public void setProductChlorideUnit(String productChlorideUnit) {
        this.productChlorideUnit = productChlorideUnit;
    }

    public String getProductCalciumUnit() {
        return productCalciumUnit;
    }

    public void setProductCalciumUnit(String productCalciumUnit) {
        this.productCalciumUnit = productCalciumUnit;
    }

    public String getProductPhosphorusUnit() {
        return productPhosphorusUnit;
    }

    public void setProductPhosphorusUnit(String productPhosphorusUnit) {
        this.productPhosphorusUnit = productPhosphorusUnit;
    }

    public String getProductMagnesiumUnit() {
        return productMagnesiumUnit;
    }

    public void setProductMagnesiumUnit(String productMagnesiumUnit) {
        this.productMagnesiumUnit = productMagnesiumUnit;
    }

    public String getProductIronUnit() {
        return productIronUnit;
    }

    public void setProductIronUnit(String productIronUnit) {
        this.productIronUnit = productIronUnit;
    }

    public String getProductZincUnit() {
        return productZincUnit;
    }

    public void setProductZincUnit(String productZincUnit) {
        this.productZincUnit = productZincUnit;
    }

    public String getProductManganeseUnit() {
        return productManganeseUnit;
    }

    public void setProductManganeseUnit(String productManganeseUnit) {
        this.productManganeseUnit = productManganeseUnit;
    }

    public String getProductCopperUnit() {
        return productCopperUnit;
    }

    public void setProductCopperUnit(String productCopperUnit) {
        this.productCopperUnit = productCopperUnit;
    }

    public String getProductIodineUnit() {
        return productIodineUnit;
    }

    public void setProductIodineUnit(String productIodineUnit) {
        this.productIodineUnit = productIodineUnit;
    }

    public String getProductSeleniumUnit() {
        return productSeleniumUnit;
    }

    public void setProductSeleniumUnit(String productSeleniumUnit) {
        this.productSeleniumUnit = productSeleniumUnit;
    }

    public String getProductChromiumUnit() {
        return productChromiumUnit;
    }

    public void setProductChromiumUnit(String productChromiumUnit) {
        this.productChromiumUnit = productChromiumUnit;
    }

    public String getProductMolybdenumUnit() {
        return productMolybdenumUnit;
    }

    public void setProductMolybdenumUnit(String productMolybdenumUnit) {
        this.productMolybdenumUnit = productMolybdenumUnit;
    }

    public String getProductWaterUnit() {
        return productWaterUnit;
    }

    public void setProductWaterUnit(String productWaterUnit) {
        this.productWaterUnit = productWaterUnit;
    }

    public String getProductIsoleucineUnit() {
        return productIsoleucineUnit;
    }

    public void setProductIsoleucineUnit(String productIsoleucineUnit) {
        this.productIsoleucineUnit = productIsoleucineUnit;
    }

    public String getProductLeucineUnit() {
        return productLeucineUnit;
    }

    public void setProductLeucineUnit(String productLeucineUnit) {
        this.productLeucineUnit = productLeucineUnit;
    }

    public String getProductLysineUnit() {
        return productLysineUnit;
    }

    public void setProductLysineUnit(String productLysineUnit) {
        this.productLysineUnit = productLysineUnit;
    }

    public String getProductMethionineUnit() {
        return productMethionineUnit;
    }

    public void setProductMethionineUnit(String productMethionineUnit) {
        this.productMethionineUnit = productMethionineUnit;
    }

    public String getProductPhenylalanineUnit() {
        return productPhenylalanineUnit;
    }

    public void setProductPhenylalanineUnit(String productPhenylalanineUnit) {
        this.productPhenylalanineUnit = productPhenylalanineUnit;
    }

    public String getProductThreonineUnit() {
        return productThreonineUnit;
    }

    public void setProductThreonineUnit(String productThreonineUnit) {
        this.productThreonineUnit = productThreonineUnit;
    }

    public String getProductTryptophanUnit() {
        return productTryptophanUnit;
    }

    public void setProductTryptophanUnit(String productTryptophanUnit) {
        this.productTryptophanUnit = productTryptophanUnit;
    }

    public String getProductValineUnit() {
        return productValineUnit;
    }

    public void setProductValineUnit(String productValineUnit) {
        this.productValineUnit = productValineUnit;
    }

    public String getProductHistidineUnit() {
        return productHistidineUnit;
    }

    public void setProductHistidineUnit(String productHistidineUnit) {
        this.productHistidineUnit = productHistidineUnit;
    }

    public String getProductAlanineUnit() {
        return productAlanineUnit;
    }

    public void setProductAlanineUnit(String productAlanineUnit) {
        this.productAlanineUnit = productAlanineUnit;
    }

    public String getProductArginineUnit() {
        return productArginineUnit;
    }

    public void setProductArginineUnit(String productArginineUnit) {
        this.productArginineUnit = productArginineUnit;
    }

    public String getProductAsparticAcidUnit() {
        return productAsparticAcidUnit;
    }

    public void setProductAsparticAcidUnit(String productAsparticAcidUnit) {
        this.productAsparticAcidUnit = productAsparticAcidUnit;
    }

    public String getProductCysteineUnit() {
        return productCysteineUnit;
    }

    public void setProductCysteineUnit(String productCysteineUnit) {
        this.productCysteineUnit = productCysteineUnit;
    }

    public String getProductGlutamicAcidUnit() {
        return productGlutamicAcidUnit;
    }

    public void setProductGlutamicAcidUnit(String productGlutamicAcidUnit) {
        this.productGlutamicAcidUnit = productGlutamicAcidUnit;
    }

    public String getProductGlycineUnit() {
        return productGlycineUnit;
    }

    public void setProductGlycineUnit(String productGlycineUnit) {
        this.productGlycineUnit = productGlycineUnit;
    }

    public String getProductProlineUnit() {
        return productProlineUnit;
    }

    public void setProductProlineUnit(String productProlineUnit) {
        this.productProlineUnit = productProlineUnit;
    }

    public String getProductSerineUnit() {
        return productSerineUnit;
    }

    public void setProductSerineUnit(String productSerineUnit) {
        this.productSerineUnit = productSerineUnit;
    }

    public String getProductTyrosineUnit() {
        return productTyrosineUnit;
    }

    public void setProductTyrosineUnit(String productTyrosineUnit) {
        this.productTyrosineUnit = productTyrosineUnit;
    }

    public String getProductHydroxyLysineUnit() {
        return productHydroxyLysineUnit;
    }

    public void setProductHydroxyLysineUnit(String productHydroxyLysineUnit) {
        this.productHydroxyLysineUnit = productHydroxyLysineUnit;
    }

    public String getProductHydroxyProlineUnit() {
        return productHydroxyProlineUnit;
    }

    public void setProductHydroxyProlineUnit(String productHydroxyProlineUnit) {
        this.productHydroxyProlineUnit = productHydroxyProlineUnit;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }
}

