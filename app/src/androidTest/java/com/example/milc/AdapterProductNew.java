//package com.example.milc;
//
//import android.content.Context;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.Filter;
//import android.widget.Filterable;
//import android.widget.ImageView;
//import android.widget.TextView;
//
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.google.android.material.bottomsheet.BottomSheetDialog;
//import com.squareup.picasso.Picasso;
//
//import java.util.ArrayList;
//
//public class AdapterProductNew extends RecyclerView.Adapter<AdapterProductUser.HolderProduct> implements Filterable {
//
//    private Context context;
//    public ArrayList<ModelProduct> productList, filterList;
//    private FilterProductUser filter;
//
//    public AdapterProductNew(Context context, ArrayList<ModelProduct> productList) {
//        this.context = context;
//        this.productList = productList;
//        this.filterList = productList;
//    }
//
//
//    @NonNull
//    @Override
//    public AdapterProductNew.HolderProduct onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        //inflate layout
//        View view = LayoutInflater.from(context).inflate(R.layout.row_product_seller,parent,false);
//        return new AdapterProductNew.HolderProduct(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull AdapterProductUser.HolderProduct holder, int position) {
//        //get data
//        ModelProduct modelProduct = productList.get(position);
//
//        String uid = modelProduct.getUid();
//        String productName = modelProduct.getProductName();
//        String productDescription = modelProduct.getProductDescription();
//        String productIcon = modelProduct.getProductIcon();
//        String productCategory = modelProduct.getProductCategory();
//        String productSubCategory = modelProduct.getProductSubCategory();
//
//        //set data dlm row_product
//        holder.productNameTv.setText(productName);
//        holder.productDescriptionTv.setText(productDescription);
//        holder.productCategoryTv.setText(productCategory);
//        holder.productSubCategoryTv.setText(productSubCategory);
//
//        try{
//            Picasso.get().load(productIcon).placeholder(R.drawable.cart).into(holder.productIconIv);
//
//        }catch (Exception e){
//            holder.productIconIv.setImageResource(R.drawable.cart);
//        }
//
//        holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //when handle item clicks, it will show item details
//
//                detailPage(modelProduct); //here modelProduct contains details of clicked product
//            }
//        });
//
//
//    }
//
//    private void detailPage(ModelProduct modelProduct) {
//
//        //bottom sheet
//        BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(context);
//        //inflate view for bottom sheet
//        View view = LayoutInflater.from(context).inflate(R.layout.product_detail,null);
//        //set view to bottom sheet
//        bottomSheetDialog.setContentView(view);
//
//        //init views
//        ImageView productIconIv = view.findViewById(R.id.imageView);
//        TextView nameDetailTv = view.findViewById(R.id.nameDetailTv);
//        TextView companyDetailTv = view.findViewById(R.id.companyDetailTv);
//        TextView descriptionDetailTv = view.findViewById(R.id.descriptionDetailTv);
//        TextView indicationDetailTv = view.findViewById(R.id.indicationDetailTv);
//        TextView ingredientDetailTv = view.findViewById(R.id.ingredientDetailTv);
//        TextView availabilityDetailTv = view.findViewById(R.id.availabilityDetailTv);
//        TextView retailPriceDetailTv = view.findViewById(R.id.retailPriceDetailTv);
//        TextView SpecialFeaturesDetailTv = view.findViewById(R.id.SpecialFeaturesDetailTv);
//        TextView StorageDetailTv = view.findViewById(R.id.StorageDetailTv);
//        TextView CalorieDetailTv = view.findViewById(R.id.CalorieDetailTv);
//        TextView OtherInformationDetailTv = view.findViewById(R.id.OtherInformationDetailTv);
//        TextView ServingDetailTv = view.findViewById(R.id.ServingDetailTv);
//        TextView PackSizeDetailTv = view.findViewById(R.id.PackSizeDetailTv);
//
//        TextView SpecialFeaturesTitle = view.findViewById(R.id.SpecialFeaturesTitle);
//        TextView PackSizeTitle = view.findViewById(R.id.PackSizeTitle);
//        TextView ServingTitle = view.findViewById(R.id.ServingTitle);
//        TextView OtherInformationTitle = view.findViewById(R.id.OtherInformationTitle);
//        TextView CalorieTitle = view.findViewById(R.id.CalorieTitle);
//        TextView StorageTitle = view.findViewById(R.id.StorageTitle);
//
//        TextView Amount = view.findViewById(R.id.amount);
//        TextView Energy = view.findViewById(R.id.Energy);
//        TextView Protein = view.findViewById(R.id.Protein);
//
//        TextView Fat = view.findViewById(R.id.Fat);
//        TextView MUFA = view.findViewById(R.id.MUFA);
//        TextView PUFA = view.findViewById(R.id.PUFA);
//        TextView Linoleic = view.findViewById(R.id.Linoleic);
//        TextView LinoAcid = view.findViewById(R.id.LinoAcid);
//        TextView EPA = view.findViewById(R.id.EPA);
//        TextView DHA = view.findViewById(R.id.DHA);
//        TextView SFA = view.findViewById(R.id.SFA);
//        TextView MCToil = view.findViewById(R.id.MCToil);
//        TextView Trans = view.findViewById(R.id.Trans);
//
//        TextView Cholesterol = view.findViewById(R.id.Cholesterol);
//        TextView Carbohydrate = view.findViewById(R.id.Carbohydrate);
//        TextView Salt = view.findViewById(R.id.Salt);
//        TextView Lactose = view.findViewById(R.id.Lactose);
//        TextView Polyols = view.findViewById(R.id.Polyols);
//        TextView Fiber = view.findViewById(R.id.Fiber);
//        TextView FOS = view.findViewById(R.id.FOS);
//        TextView DietaryFiber = view.findViewById(R.id.DietaryFiber);
//        TextView SolubleFiber = view.findViewById(R.id.SolubleFiber);
//        TextView Sugar = view.findViewById(R.id.Sugar);
//
//        TextView EssentialAminoAcids = view.findViewById(R.id.EssentialAminoAcids);
//        TextView BranchedChainAminoAcids = view.findViewById(R.id.BranchedChainAminoAcids);
//        TextView Inulin = view.findViewById(R.id.Inulin);
//        TextView Choline = view.findViewById(R.id.Choline);
//        TextView Taurine = view.findViewById(R.id.Taurine);
//        TextView Carnitine = view.findViewById(R.id.Carnitine);
//        TextView LCarnitine = view.findViewById(R.id.LCarnitine);
//        TextView CaHMB = view.findViewById(R.id.CaHMB);
//        TextView HMB = view.findViewById(R.id.HMB);
//        TextView Inositol = view.findViewById(R.id.Inositol);
//
//        TextView VitaminA = view.findViewById(R.id.VitaminA);
//        TextView VitaminA1 = view.findViewById(R.id.VitaminA1);
//        TextView VitaminA2 = view.findViewById(R.id.VitaminA2);
//        TextView VitaminD = view.findViewById(R.id.VitaminD);
//        TextView VitaminD3 = view.findViewById(R.id.VitaminD3);
//        TextView VitaminE = view.findViewById(R.id.VitaminE);
//        TextView VitaminK = view.findViewById(R.id.VitaminK);
//        TextView VitaminK1 = view.findViewById(R.id.VitaminK1);
//        TextView VitaminC = view.findViewById(R.id.VitaminC);
//        TextView VitaminB1 = view.findViewById(R.id.VitaminB1);
//        TextView VitaminB2 = view.findViewById(R.id.VitaminB2);
//        TextView VitaminB6 = view.findViewById(R.id.VitaminB6);
//        TextView VitaminB12 = view.findViewById(R.id.VitaminB12);
//        TextView Niacin = view.findViewById(R.id.Niacin);
//        TextView NiacinEquivalent = view.findViewById(R.id.NiacinEquivalent);
//        TextView FolicAcid = view.findViewById(R.id.FolicAcid);
//        TextView Biotin = view.findViewById(R.id.Biotin);
//        TextView PantothenicAcid = view.findViewById(R.id.PantothenicAcid);
//
//        TextView Sodium = view.findViewById(R.id.Sodium);
//        TextView Potassium = view.findViewById(R.id.Potassium);
//        TextView Chloride = view.findViewById(R.id.Chloride);
//        TextView Calcium = view.findViewById(R.id.Calcium);
//        TextView Phosphorus = view.findViewById(R.id.Phosphorus);
//        TextView Magnesium = view.findViewById(R.id.Magnesium);
//        TextView Iron = view.findViewById(R.id.Iron);
//        TextView Zinc = view.findViewById(R.id.Zinc);
//        TextView Manganese = view.findViewById(R.id.Manganese);
//        TextView Copper = view.findViewById(R.id.Copper);
//        TextView Iodine = view.findViewById(R.id.Iodine);
//        TextView Selenium = view.findViewById(R.id.Selenium);
//        TextView Chromium = view.findViewById(R.id.Chromium);
//        TextView Molybdenum = view.findViewById(R.id.Molybdenum);
//        TextView Water = view.findViewById(R.id.Water);
//
//        TextView αLactalbumin = view.findViewById(R.id.αLactalbumin);
//        TextView βLactoglobulin = view.findViewById(R.id.βLactoglobulin);
//        TextView Glycomacropeptide = view.findViewById(R.id.Glycomacropeptide);
//        TextView ImmunoglobulinGIgG = view.findViewById(R.id.ImmunoglobulinGIgG);
//        TextView BovineSerumAlbumin = view.findViewById(R.id.BovineSerumAlbumin);
//        TextView ProteasePeptone5 = view.findViewById(R.id.ProteasePeptone5);
//
//        TextView Isoleucine = view.findViewById(R.id.Isoleucine);
//        TextView Leucine = view.findViewById(R.id.Leucine);
//        TextView Lysine = view.findViewById(R.id.Lysine);
//        TextView Methionine = view.findViewById(R.id.Methionine);
//        TextView Phenylalanine = view.findViewById(R.id.Phenylalanine);
//        TextView Threonine = view.findViewById(R.id.Threonine);
//        TextView Tryptophan = view.findViewById(R.id.Tryptophan);
//        TextView Valine = view.findViewById(R.id.Valine);
//        TextView Histidine = view.findViewById(R.id.Histidine);
//        TextView Alanine = view.findViewById(R.id.Alanine);
//        TextView Arginine = view.findViewById(R.id.Arginine);
//        TextView AsparticAcid = view.findViewById(R.id.AsparticAcid);
//        TextView Cysteine = view.findViewById(R.id.Cysteine);
//        TextView GlutamicAcid = view.findViewById(R.id.GlutamicAcid);
//        TextView Glycine = view.findViewById(R.id.Glycine);
//        TextView Proline = view.findViewById(R.id.Proline);
//        TextView Serine = view.findViewById(R.id.Serine);
//        TextView Tyrosine = view.findViewById(R.id.Tyrosine);
//        TextView HydroxyLysine = view.findViewById(R.id.HydroxyLysine);
//        TextView HydroxyProline = view.findViewById(R.id.HydroxyProline);
//
//        TextView EnergyTitle = view.findViewById(R.id.EnergyTitle);
//        TextView ProteinTitle = view.findViewById(R.id.ProteinTitle);
//
//        TextView FatTitle = view.findViewById(R.id.FatTitle);
//        TextView MUFATitle = view.findViewById(R.id.MUFATitle);
//        TextView PUFATitle = view.findViewById(R.id.PUFATitle);
//        TextView LinoleicTitle = view.findViewById(R.id.LinoleicTitle);
//        TextView LinoAcidTitle = view.findViewById(R.id.LinoAcidTitle);
//        TextView EPATitle = view.findViewById(R.id.EPATitle);
//        TextView DHATitle = view.findViewById(R.id.DHATitle);
//        TextView SFATitle = view.findViewById(R.id.SFATitle);
//        TextView MCToilTitle = view.findViewById(R.id.MCToilTitle);
//        TextView TransTitle = view.findViewById(R.id.TransTitle);
//
//        TextView CholesterolTitle = view.findViewById(R.id.CholesterolTitle);
//        TextView CarbohydrateTitle = view.findViewById(R.id.CarbohydrateTitle);
//        TextView SaltTitle = view.findViewById(R.id.SaltTitle);
//        TextView LactoseTitle = view.findViewById(R.id.LactoseTitle);
//        TextView PolyolsTitle = view.findViewById(R.id.PolyolsTitle);
//        TextView FiberTitle = view.findViewById(R.id.FiberTitle);
//        TextView FOSTitle = view.findViewById(R.id.FOSTitle);
//        TextView DietaryFiberTitle = view.findViewById(R.id.DietaryFiberTitle);
//        TextView SolubleFiberTitle = view.findViewById(R.id.SolubleFiberTitle);
//        TextView SugarTitle = view.findViewById(R.id.SugarTitle);
//
//        TextView EssentialAminoAcidsTitle = view.findViewById(R.id.EssentialAminoAcidsTitle);
//        TextView BranchedChainAminoAcidsTitle = view.findViewById(R.id.BranchedChainAminoAcidsTitle);
//        TextView InulinTitle = view.findViewById(R.id.InulinTitle);
//        TextView CholineTitle = view.findViewById(R.id.CholineTitle);
//        TextView TaurineTitle = view.findViewById(R.id.TaurineTitle);
//        TextView CarnitineTitle = view.findViewById(R.id.CarnitineTitle);
//        TextView LCarnitineTitle = view.findViewById(R.id.LCarnitineTitle);
//        TextView CaHMBTitle = view.findViewById(R.id.CaHMBTitle);
//        TextView HMBTitle = view.findViewById(R.id.HMBTitle);
//        TextView InositolTitle = view.findViewById(R.id.InositolTitle);
//
//        TextView VitaminATitle = view.findViewById(R.id.VitaminATitle);
//        TextView VitaminA1Title = view.findViewById(R.id.VitaminA1Title);
//        TextView VitaminA2Title = view.findViewById(R.id.VitaminA2Title);
//        TextView VitaminDTitle = view.findViewById(R.id.VitaminDTitle);
//        TextView VitaminD3Title = view.findViewById(R.id.VitaminD3Title);
//        TextView VitaminETitle = view.findViewById(R.id.VitaminETitle);
//        TextView VitaminKTitle = view.findViewById(R.id.VitaminKTitle);
//        TextView VitaminK1Title = view.findViewById(R.id.VitaminK1Title);
//        TextView VitaminCTitle = view.findViewById(R.id.VitaminCTitle);
//        TextView VitaminB1Title = view.findViewById(R.id.VitaminB1Title);
//        TextView VitaminB2Title = view.findViewById(R.id.VitaminB2Title);
//        TextView VitaminB6Title = view.findViewById(R.id.VitaminB6Title);
//        TextView VitaminB12Title = view.findViewById(R.id.VitaminB12Title);
//        TextView NiacinTitle = view.findViewById(R.id.NiacinTitle);
//        TextView NiacinEquivalentTitle = view.findViewById(R.id.NiacinEquivalentTitle);
//        TextView FolicAcidTitle = view.findViewById(R.id.FolicAcidTitle);
//        TextView BiotinTitle = view.findViewById(R.id.BiotinTitle);
//        TextView PantothenicAcidTitle = view.findViewById(R.id.PantothenicAcidTitle);
//
//        TextView SodiumTitle = view.findViewById(R.id.SodiumTitle);
//        TextView PotassiumTitle = view.findViewById(R.id.PotassiumTitle);
//        TextView ChlorideTitle = view.findViewById(R.id.ChlorideTitle);
//        TextView CalciumTitle = view.findViewById(R.id.CalciumTitle);
//        TextView PhosphorusTitle = view.findViewById(R.id.PhosphorusTitle);
//        TextView MagnesiumTitle = view.findViewById(R.id.MagnesiumTitle);
//        TextView IronTitle = view.findViewById(R.id.IronTitle);
//        TextView ZincTitle = view.findViewById(R.id.ZincTitle);
//        TextView ManganeseTitle = view.findViewById(R.id.ManganeseTitle);
//        TextView CopperTitle = view.findViewById(R.id.CopperTitle);
//        TextView IodineTitle = view.findViewById(R.id.IodineTitle);
//        TextView SeleniumTitle = view.findViewById(R.id.SeleniumTitle);
//        TextView ChromiumTitle = view.findViewById(R.id.ChromiumTitle);
//        TextView MolybdenumTitle = view.findViewById(R.id.MolybdenumTitle);
//        TextView WaterTitle = view.findViewById(R.id.WaterTitle);
//
//        TextView αLactalbuminTitle = view.findViewById(R.id.αLactalbuminTitle);
//        TextView βLactoglobulinTitle = view.findViewById(R.id.βLactoglobulinTitle);
//        TextView GlycomacropeptideTitle = view.findViewById(R.id.GlycomacropeptideTitle);
//        TextView ImmunoglobulinGIgGTitle = view.findViewById(R.id.ImmunoglobulinGIgGTitle);
//        TextView BovineSerumAlbuminTitle = view.findViewById(R.id.BovineSerumAlbuminTitle);
//        TextView ProteasePeptone5Title = view.findViewById(R.id.ProteasePeptone5Title);
//
//        TextView IsoleucineTitle = view.findViewById(R.id.IsoleucineTitle);
//        TextView LeucineTitle = view.findViewById(R.id.LeucineTitle);
//        TextView LysineTitle = view.findViewById(R.id.LysineTitle);
//        TextView MethionineTitle = view.findViewById(R.id.MethionineTitle);
//        TextView PhenylalanineTitle = view.findViewById(R.id.PhenylalanineTitle);
//        TextView ThreonineTitle = view.findViewById(R.id.ThreonineTitle);
//        TextView TryptophanTitle = view.findViewById(R.id.TryptophanTitle);
//        TextView ValineTitle = view.findViewById(R.id.ValineTitle);
//        TextView HistidineTitle = view.findViewById(R.id.HistidineTitle);
//        TextView AlanineTitle = view.findViewById(R.id.AlanineTitle);
//        TextView ArginineTitle = view.findViewById(R.id.ArginineTitle);
//        TextView AsparticAcidTitle = view.findViewById(R.id.AsparticAcidTitle);
//        TextView CysteineTitle = view.findViewById(R.id.CysteineTitle);
//        TextView GlutamicAcidTitle = view.findViewById(R.id.GlutamicAcidTitle);
//        TextView GlycineTitle = view.findViewById(R.id.GlycineTitle);
//        TextView ProlineTitle = view.findViewById(R.id.ProlineTitle);
//        TextView SerineTitle = view.findViewById(R.id.SerineTitle);
//        TextView TyrosineTitle = view.findViewById(R.id.TyrosineTitle);
//        TextView HydroxyLysineTitle = view.findViewById(R.id.HydroxyLysineTitle);
//        TextView HydroxyProlineTitle = view.findViewById(R.id.HydroxyProlineTitle);
//
//        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>get data
//        final String id = modelProduct.getProductId();
//        String productIcon = modelProduct.getProductIcon();
//        String productName = modelProduct.getProductName();
//        String productDescription = modelProduct.getProductDescription();
//        String productCompany = modelProduct.getProductCompany();
//        String productIndications = modelProduct.getProductIndication();
//        String productIngredients = modelProduct.getProductIngredient();
//        String productAvailability = modelProduct.getProductAvailability();
//        String productRetailPrice = modelProduct.getProductRetailPrice();
//        String productSpecial = modelProduct.getProductSpecialFeatures();
//        String productPackSize = modelProduct.getProductPackSize();
//        String productServingSize = modelProduct.getProductServingSize();
//        String productOtherInfo = modelProduct.getProductOtherInfo();
//        String productCalorie = modelProduct.getProductCalorie();
//        String productStorage = modelProduct.getProductStorage();
//
//        String productAmount = modelProduct.getProductAmount();
//        String productAmountType = modelProduct.getProductAmountType();
//        String productAmountUnit = modelProduct.getProductAmountUnit();
//
//        String productEnergyUnit = modelProduct.getProductEnergyUnit();
//        String productProteinUnit = modelProduct.getProductProteinUnit();
//        String productFatUnit =  modelProduct.getProductFatUnit();
//        String productMUFAUnit =  modelProduct.getProductMUFAUnit();
//        String productPUFAUnit =  modelProduct.getProductPUFAUnit();
//        String productLinoleicAcidOmega6Unit =  modelProduct.getProductLinoleicAcidOmega6Unit();
//        String productαlinolenicAcidOmega3Unit =  modelProduct.getProductαlinolenicAcidOmega3Unit();
//        String productEPAUnit =  modelProduct.getProductEPAUnit();
//        String productDHAUnit =  modelProduct.getProductDHAUnit();
//        String productSFAUnit =  modelProduct.getProductSFAUnit();
//        String productMCTOilUnit =  modelProduct.getProductMCTOilUnit();
//        String productTransFattyAcidsUnit =  modelProduct.getProductTransFattyAcidsUnit();
//        String productCholesterolUnit =  modelProduct.getProductCholesterolUnit();
//        String productCarbohydrateUnit =  modelProduct.getProductCarbohydrateUnit();
//        String productSaltUnit =  modelProduct.getProductSaltUnit();
//        String productLactoseUnit =  modelProduct.getProductLactoseUnit();
//        String productPolyolsUnit =  modelProduct.getProductPolyolsUnit();
//        String productFiberUnit =  modelProduct.getProductFiberUnit();
//        String productFOSUnit =  modelProduct.getProductFOSUnit();
//        String productDietaryFiberUnit =  modelProduct.getProductDietaryFiberUnit();
//        String productSolubleFiberUnit =  modelProduct.getProductSolubleFiberUnit();
//        String productSugarUnit =  modelProduct.getProductSugarUnit();
//        String productEssentialAminoAcidsUnit =  modelProduct.getProductEssentialAminoAcidsUnit();
//        String productBranchedChainAminoAcidsUnit =  modelProduct.getProductBranchedChainAminoAcidsUnit();
//        String productInulinUnit =  modelProduct.getProductInulinUnit();
//        String productCholineUnit =  modelProduct.getProductCholineUnit();
//        String productTaurineUnit =  modelProduct.getProductTaurineUnit();
//        String productCarnitineUnit =  modelProduct.getProductCarnitineUnit();
//        String productLCarnitineUnit =  modelProduct.getProductLCarnitineUnit();
//        String productCaHMBUnit =  modelProduct.getProductCaHMBUnit();
//        String productHMBUnit =  modelProduct.getProductHMBUnit();
//        String productInositolUnit =  modelProduct.getProductInositolUnit();
//        String productαLactalbuminUnit =  modelProduct.getProductαLactalbuminUnit();
//        String productβLactoglobulinUnit =  modelProduct.getProductβLactoglobulinUnit();
//        String productGlycomacropeptideUnit =  modelProduct.getProductGlycomacropeptideUnit();
//        String productImmunoglobulinGIgGUnit =  modelProduct.getProductImmunoglobulinGIgGUnit();
//        String productBovineSerumAlbuminUnit =  modelProduct.getProductBovineSerumAlbuminUnit();
//        String productProteasePeptone5Unit =  modelProduct.getProductProteasePeptone5Unit();
//        String productVitaminAUnit =  modelProduct.getProductVitaminAUnit();
//        String productVitaminAPalmitateUnit =  modelProduct.getProductVitaminAPalmitateUnit();
//        String productVitaminABCaroteneUnit =  modelProduct.getProductVitaminABCaroteneUnit();
//        String productVitaminDUnit =  modelProduct.getProductVitaminDUnit();
//        String productVitaminD3Unit =  modelProduct.getProductVitaminD3Unit();
//        String productVitaminEUnit =  modelProduct.getProductVitaminEUnit();
//        String productVitaminKUnit =  modelProduct.getProductVitaminKUnit();
//        String productVitaminK1Unit =  modelProduct.getProductVitaminK1Unit();
//        String productVitaminCUnit =  modelProduct.getProductVitaminCUnit();
//        String productVitaminB1Unit =  modelProduct.getProductVitaminB1Unit();
//        String productVitaminB2Unit =  modelProduct.getProductVitaminB2Unit();
//        String productVitaminB6Unit =  modelProduct.getProductVitaminB6Unit();
//        String productVitaminB12Unit =  modelProduct.getProductVitaminB12Unit();
//        String productNiacinUnit =  modelProduct.getProductNiacinUnit();
//        String productNiacinEquivalentUnit =  modelProduct.getProductNiacinEquivalentUnit();
//        String productFolicAcidUnit =  modelProduct.getProductFolicAcidUnit();
//        String productBiotinUnit =  modelProduct.getProductBiotinUnit();
//        String productPantothenicAcidUnit =  modelProduct.getProductPantothenicAcidUnit();
//        String productSodiumUnit =  modelProduct.getProductSodiumUnit();
//        String productPotassiumUnit =  modelProduct.getProductPotassiumUnit();
//        String productChlorideUnit =  modelProduct.getProductChlorideUnit();
//        String productCalciumUnit =  modelProduct.getProductCalciumUnit();
//        String productPhosphorusUnit =  modelProduct.getProductPhosphorusUnit();
//        String productMagnesiumUnit =  modelProduct.getProductMagnesiumUnit();
//        String productIronUnit =  modelProduct.getProductIronUnit();
//        String productZincUnit =  modelProduct.getProductZincUnit();
//        String productManganeseUnit =  modelProduct.getProductManganeseUnit();
//        String productCopperUnit =  modelProduct.getProductCopperUnit();
//        String productIodineUnit =  modelProduct.getProductIodineUnit();
//        String productSeleniumUnit =  modelProduct.getProductSeleniumUnit();
//        String productChromiumUnit =  modelProduct.getProductChromiumUnit();
//        String productMolybdenumUnit =  modelProduct.getProductMolybdenumUnit();
//        String productWaterUnit =  modelProduct.getProductWaterUnit();
//
//        String productIsoleucineUnit = modelProduct.getProductIsoleucineUnit();
//        String productLeucineUnit = modelProduct.getProductLeucineUnit();
//        String productLysineUnit = modelProduct.getProductLysineUnit();
//        String productMethionineUnit = modelProduct.getProductMethionineUnit();
//        String productPhenylalanineUnit = modelProduct.getProductPhenylalanineUnit();
//        String productThreonineUnit = modelProduct.getProductThreonineUnit();
//        String productTryptophanUnit = modelProduct.getProductTryptophanUnit();
//        String productValineUnit = modelProduct.getProductValineUnit();
//        String productHistidineUnit = modelProduct.getProductHistidineUnit();
//        String productAlanineUnit = modelProduct.getProductAlanineUnit();
//        String productArginineUnit = modelProduct.getProductArginineUnit();
//        String productAsparticAcidUnit = modelProduct.getProductAsparticAcidUnit();
//        String productCysteineUnit = modelProduct.getProductCysteineUnit();
//        String productGlutamicAcidUnit = modelProduct.getProductGlutamicAcidUnit();
//        String productGlycineUnit = modelProduct.getProductGlycineUnit();
//        String productProlineUnit = modelProduct.getProductProlineUnit();
//        String productSerineUnit = modelProduct.getProductSerineUnit();
//        String productTyrosineUnit = modelProduct.getProductTyrosineUnit();
//        String productHydroxyLysineUnit = modelProduct.getProductHydroxyLysineUnit ();
//        String productHydroxyProlineUnit = modelProduct.getProductHydroxyProlineUnit();
//
//
//        //>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>set data
//        nameDetailTv.setText(productName);
//        companyDetailTv.setText(productCompany);
//        descriptionDetailTv.setText(productDescription);
//        indicationDetailTv.setText(productIndications);
//        ingredientDetailTv.setText(productIngredients);
//        availabilityDetailTv.setText(productAvailability);
//        retailPriceDetailTv.setText(productRetailPrice);
//        SpecialFeaturesDetailTv.setText(productSpecial);
//        StorageDetailTv.setText(productStorage);
//        CalorieDetailTv.setText(productCalorie);
//        OtherInformationDetailTv.setText(productOtherInfo);
//        ServingDetailTv.setText(productServingSize);
//        PackSizeDetailTv.setText(productPackSize);
//
//        Amount.setText("Per" + " " + productAmountType + " ( " + productAmount + " " + productAmountUnit + " ) " );
//        Energy.setText(productEnergyUnit);
//        Protein.setText(productProteinUnit);
//
//        Fat.setText(productFatUnit);
//        MUFA.setText(productMUFAUnit);
//        PUFA.setText(productPUFAUnit);
//        Linoleic.setText(productLinoleicAcidOmega6Unit);
//        LinoAcid.setText(productαlinolenicAcidOmega3Unit);
//        EPA.setText(productEPAUnit);
//        DHA.setText(productDHAUnit);
//        SFA.setText(productSFAUnit);
//        MCToil.setText(productMCTOilUnit);
//        Trans.setText(productTransFattyAcidsUnit);
//
//        Cholesterol.setText(productCholesterolUnit);
//        Carbohydrate.setText(productCarbohydrateUnit);
//        Salt.setText(productSaltUnit);
//        Lactose.setText(productLactoseUnit);
//        Polyols.setText(productPolyolsUnit);
//        Fiber.setText(productFiberUnit);
//        FOS.setText(productFOSUnit);
//        DietaryFiber.setText(productDietaryFiberUnit);
//        SolubleFiber.setText(productSolubleFiberUnit);
//        Sugar.setText(productSugarUnit);
//
//        EssentialAminoAcids.setText(productEssentialAminoAcidsUnit);
//        BranchedChainAminoAcids.setText(productBranchedChainAminoAcidsUnit);
//        Inulin.setText(productInulinUnit);
//        Choline.setText(productCholineUnit);
//        Taurine.setText(productTaurineUnit);
//        Carnitine.setText(productCarnitineUnit);
//        LCarnitine.setText(productLCarnitineUnit);
//        CaHMB.setText(productCaHMBUnit);
//        HMB.setText(productHMBUnit);
//        Inositol.setText(productInositolUnit);
//
//        VitaminA.setText(productVitaminAUnit);
//        VitaminA1.setText(productVitaminAPalmitateUnit);
//        VitaminA2.setText(productVitaminABCaroteneUnit);
//        VitaminD.setText(productVitaminDUnit);
//        VitaminD3.setText(productVitaminD3Unit);
//        VitaminE.setText(productVitaminEUnit);
//        VitaminK.setText(productVitaminKUnit);
//        VitaminK1.setText(productVitaminK1Unit);
//        VitaminC.setText(productVitaminCUnit);
//        VitaminB1.setText(productVitaminB1Unit);
//        VitaminB2.setText(productVitaminB2Unit);
//        VitaminB6.setText(productVitaminB6Unit);
//        VitaminB12.setText(productVitaminB12Unit);
//        Niacin.setText(productNiacinUnit);
//        NiacinEquivalent.setText(productNiacinEquivalentUnit);
//        FolicAcid.setText(productFolicAcidUnit);
//        Biotin.setText(productBiotinUnit);
//        PantothenicAcid.setText(productPantothenicAcidUnit);
//
//        Sodium.setText(productSodiumUnit);
//        Potassium.setText(productPotassiumUnit);
//        Chloride.setText(productChlorideUnit);
//        Calcium.setText(productCalciumUnit);
//        Phosphorus.setText(productPhosphorusUnit);
//        Magnesium.setText(productMagnesiumUnit);
//        Iron.setText(productIronUnit);
//        Zinc.setText(productZincUnit);
//        Manganese.setText(productManganeseUnit);
//        Copper.setText(productCopperUnit);
//        Iodine.setText(productIodineUnit);
//        Selenium.setText(productSeleniumUnit);
//        Chromium.setText(productChromiumUnit);
//        Molybdenum.setText(productMolybdenumUnit);
//        Water.setText(productWaterUnit);
//
//        αLactalbumin.setText(productαLactalbuminUnit);
//        βLactoglobulin.setText(productβLactoglobulinUnit);
//        Glycomacropeptide.setText(productGlycomacropeptideUnit);
//        ImmunoglobulinGIgG.setText(productImmunoglobulinGIgGUnit);
//        BovineSerumAlbumin.setText(productBovineSerumAlbuminUnit);
//        ProteasePeptone5.setText(productProteasePeptone5Unit);
//
//        Isoleucine.setText(productIsoleucineUnit);
//        Leucine.setText(productLeucineUnit);
//        Lysine.setText(productLysineUnit);
//        Methionine.setText(productMethionineUnit);
//        Phenylalanine.setText(productPhenylalanineUnit);
//        Threonine.setText(productThreonineUnit);
//        Tryptophan.setText(productTryptophanUnit);
//        Valine.setText(productValineUnit);
//        Histidine.setText(productHistidineUnit);
//        Alanine.setText(productAlanineUnit);
//        Arginine.setText(productArginineUnit);
//        AsparticAcid.setText(productAsparticAcidUnit);
//        Cysteine.setText(productCysteineUnit);
//        GlutamicAcid.setText(productGlutamicAcidUnit);
//        Glycine.setText(productGlycineUnit);
//        Proline.setText(productProlineUnit);
//        Serine.setText(productSerineUnit);
//        Tyrosine.setText(productTyrosineUnit);
//        HydroxyLysine.setText(productHydroxyLysineUnit);
//        HydroxyProline.setText(productHydroxyProlineUnit);
//
//
//
//        try{
//            Picasso.get().load(productIcon).placeholder(R.drawable.cart).into(productIconIv);
//
//        }catch (Exception e){
//            productIconIv.setImageResource(R.drawable.cart);
//        }
//
//        if(productSpecial.equals("")){
//            SpecialFeaturesTitle.setVisibility(View.GONE);
//            SpecialFeaturesDetailTv.setVisibility(View.GONE);
//        } else{
//            SpecialFeaturesTitle.setVisibility(View.VISIBLE);
//            SpecialFeaturesDetailTv.setVisibility(View.VISIBLE);
//        }
//        if(productPackSize.equals("")){
//            PackSizeTitle.setVisibility(View.GONE);
//            PackSizeDetailTv.setVisibility(View.GONE);
//        } else{
//            PackSizeTitle.setVisibility(View.VISIBLE);
//            PackSizeDetailTv.setVisibility(View.VISIBLE);
//        }
//        if(productServingSize.equals("")){
//            ServingTitle.setVisibility(View.GONE);
//            ServingDetailTv.setVisibility(View.GONE);
//        } else{
//            ServingTitle.setVisibility(View.VISIBLE);
//            ServingDetailTv.setVisibility(View.VISIBLE);
//        }
//        if(productOtherInfo.equals("")){
//            OtherInformationTitle.setVisibility(View.GONE);
//            OtherInformationDetailTv.setVisibility(View.GONE);
//        } else{
//            OtherInformationTitle.setVisibility(View.VISIBLE);
//            OtherInformationDetailTv.setVisibility(View.VISIBLE);
//        }
//        if(productCalorie.equals("")){
//            CalorieTitle.setVisibility(View.GONE);
//            CalorieDetailTv.setVisibility(View.GONE);
//        } else{
//            CalorieTitle.setVisibility(View.VISIBLE);
//            CalorieDetailTv.setVisibility(View.VISIBLE);
//        }
//        if(productStorage.equals("")){
//            StorageTitle.setVisibility(View.GONE);
//            StorageDetailTv.setVisibility(View.GONE);
//        } else{
//            StorageTitle.setVisibility(View.VISIBLE);
//            StorageDetailTv.setVisibility(View.VISIBLE);
//        }
//
//
////*****************************************************************************VITAMIN
//        if(productEnergyUnit.equals(" ")){
//            EnergyTitle.setVisibility(View.GONE);
//            Energy.setVisibility(View.GONE);
//        } else{
//            EnergyTitle.setVisibility(View.VISIBLE);
//            Energy.setVisibility(View.VISIBLE);
//        }
//        if(productProteinUnit.equals(" ")){
//            ProteinTitle.setVisibility(View.GONE);
//            Protein.setVisibility(View.GONE);
//        } else{
//            ProteinTitle.setVisibility(View.VISIBLE);
//            Protein.setVisibility(View.VISIBLE);
//        }
//        if(productFatUnit.equals(" ")){
//            FatTitle.setVisibility(View.GONE);
//            Fat.setVisibility(View.GONE);
//        } else{
//            FatTitle.setVisibility(View.VISIBLE);
//            Fat.setVisibility(View.VISIBLE);
//        }
//        if(productMUFAUnit.equals(" ")){
//            MUFATitle.setVisibility(View.GONE);
//            MUFA.setVisibility(View.GONE);
//        } else{
//            MUFATitle.setVisibility(View.VISIBLE);
//            MUFA.setVisibility(View.VISIBLE);
//        }
//        if(productPUFAUnit.equals(" ")){
//            PUFATitle.setVisibility(View.GONE);
//            PUFA.setVisibility(View.GONE);
//        } else{
//            PUFATitle.setVisibility(View.VISIBLE);
//            PUFA.setVisibility(View.VISIBLE);
//        }
//        if(productLinoleicAcidOmega6Unit.equals(" ")){
//            LinoleicTitle.setVisibility(View.GONE);
//            Linoleic.setVisibility(View.GONE);
//        } else{
//            LinoleicTitle.setVisibility(View.VISIBLE);
//            Linoleic.setVisibility(View.VISIBLE);
//        }
//        if(productαlinolenicAcidOmega3Unit.equals(" ")){
//            LinoAcidTitle.setVisibility(View.GONE);
//            LinoAcid.setVisibility(View.GONE);
//        } else{
//            LinoAcidTitle.setVisibility(View.VISIBLE);
//            LinoAcid.setVisibility(View.VISIBLE);
//        }
//        if(productEPAUnit.equals(" ")){
//            EPATitle.setVisibility(View.GONE);
//            EPA.setVisibility(View.GONE);
//        } else{
//            EPA.setVisibility(View.VISIBLE);
//            EPA.setVisibility(View.VISIBLE);
//        }
//        if(productDHAUnit.equals(" ")){
//            DHATitle.setVisibility(View.GONE);
//            DHA.setVisibility(View.GONE);
//        } else{
//            DHATitle.setVisibility(View.VISIBLE);
//            DHA.setVisibility(View.VISIBLE);
//        }
//        if(productSFAUnit.equals(" ")){
//            SFATitle.setVisibility(View.GONE);
//            SFA.setVisibility(View.GONE);
//        } else{
//            SFATitle.setVisibility(View.VISIBLE);
//            SFA.setVisibility(View.VISIBLE);
//        }
//        if(productMCTOilUnit.equals(" ")){
//            MCToilTitle.setVisibility(View.GONE);
//            MCToil.setVisibility(View.GONE);
//        } else{
//            MCToilTitle.setVisibility(View.VISIBLE);
//            MCToil.setVisibility(View.VISIBLE);
//        }
//        if(productTransFattyAcidsUnit.equals(" ")){
//            TransTitle.setVisibility(View.GONE);
//            Trans.setVisibility(View.GONE);
//        } else{
//            TransTitle.setVisibility(View.VISIBLE);
//            Trans.setVisibility(View.VISIBLE);
//        }
//
//        if(productCholesterolUnit.equals(" ")){
//            CholesterolTitle.setVisibility(View.GONE);
//            Cholesterol.setVisibility(View.GONE);
//        } else{
//            CholesterolTitle.setVisibility(View.VISIBLE);
//            Cholesterol.setVisibility(View.VISIBLE);
//        }
//        if(productCarbohydrateUnit.equals(" ")){
//            CarbohydrateTitle.setVisibility(View.GONE);
//            Carbohydrate.setVisibility(View.GONE);
//        } else{
//            CarbohydrateTitle.setVisibility(View.VISIBLE);
//            Carbohydrate.setVisibility(View.VISIBLE);
//        }
//        if(productSaltUnit.equals(" ")){
//            SaltTitle.setVisibility(View.GONE);
//            Salt.setVisibility(View.GONE);
//        } else{
//            SaltTitle.setVisibility(View.VISIBLE);
//            Salt.setVisibility(View.VISIBLE);
//        }
//        if(productLactoseUnit.equals(" ")){
//            LactoseTitle.setVisibility(View.GONE);
//            Lactose.setVisibility(View.GONE);
//        } else{
//            LactoseTitle.setVisibility(View.VISIBLE);
//            Lactose.setVisibility(View.VISIBLE);
//        }
//        if(productPolyolsUnit.equals(" ")){
//            PolyolsTitle.setVisibility(View.GONE);
//            Polyols.setVisibility(View.GONE);
//        } else{
//            PolyolsTitle.setVisibility(View.VISIBLE);
//            Polyols.setVisibility(View.VISIBLE);
//        }
//        if(productFiberUnit.equals(" ")){
//            FiberTitle.setVisibility(View.GONE);
//            Fiber.setVisibility(View.GONE);
//        } else{
//            FiberTitle.setVisibility(View.VISIBLE);
//            Fiber.setVisibility(View.VISIBLE);
//        }
//        if(productFOSUnit.equals(" ")){
//            FOSTitle.setVisibility(View.GONE);
//            FOS.setVisibility(View.GONE);
//        } else{
//            FOSTitle.setVisibility(View.VISIBLE);
//            FOS.setVisibility(View.VISIBLE);
//        }
//        if(productDietaryFiberUnit.equals(" ")){
//            DietaryFiberTitle.setVisibility(View.GONE);
//            DietaryFiber.setVisibility(View.GONE);
//        } else{
//            DietaryFiberTitle.setVisibility(View.VISIBLE);
//            DietaryFiber.setVisibility(View.VISIBLE);
//        }
//        if(productSolubleFiberUnit.equals(" ")){
//            SolubleFiberTitle.setVisibility(View.GONE);
//            SolubleFiber.setVisibility(View.GONE);
//        } else{
//            SolubleFiberTitle.setVisibility(View.VISIBLE);
//            SolubleFiber.setVisibility(View.VISIBLE);
//        }
//        if(productSugarUnit.equals(" ")){
//            SugarTitle.setVisibility(View.GONE);
//            Sugar.setVisibility(View.GONE);
//        } else{
//            SugarTitle.setVisibility(View.VISIBLE);
//            Sugar.setVisibility(View.VISIBLE);
//        }
//
//        if(productEssentialAminoAcidsUnit.equals(" ")){
//            EssentialAminoAcidsTitle.setVisibility(View.GONE);
//            EssentialAminoAcids.setVisibility(View.GONE);
//        } else{
//            EssentialAminoAcidsTitle.setVisibility(View.VISIBLE);
//            EssentialAminoAcids.setVisibility(View.VISIBLE);
//        }
//        if(productBranchedChainAminoAcidsUnit.equals(" ")){
//            BranchedChainAminoAcidsTitle.setVisibility(View.GONE);
//            BranchedChainAminoAcids.setVisibility(View.GONE);
//        } else{
//            BranchedChainAminoAcidsTitle.setVisibility(View.VISIBLE);
//            BranchedChainAminoAcids.setVisibility(View.VISIBLE);
//        }
//        if(productInulinUnit.equals(" ")){
//            InulinTitle.setVisibility(View.GONE);
//            Inulin.setVisibility(View.GONE);
//        } else{
//            InulinTitle.setVisibility(View.VISIBLE);
//            Inulin.setVisibility(View.VISIBLE);
//        }
//        if(productCholineUnit.equals(" ")){
//            CholineTitle.setVisibility(View.GONE);
//            Choline.setVisibility(View.GONE);
//        } else{
//            CholineTitle.setVisibility(View.VISIBLE);
//            Choline.setVisibility(View.VISIBLE);
//        }
//        if(productTaurineUnit.equals(" ")){
//            TaurineTitle.setVisibility(View.GONE);
//            Taurine.setVisibility(View.GONE);
//        } else{
//            TaurineTitle.setVisibility(View.VISIBLE);
//            Taurine.setVisibility(View.VISIBLE);
//        }
//        if(productCarnitineUnit.equals(" ")){
//            CarnitineTitle.setVisibility(View.GONE);
//            Carnitine.setVisibility(View.GONE);
//        } else{
//            CarnitineTitle.setVisibility(View.VISIBLE);
//            Carnitine.setVisibility(View.VISIBLE);
//        }
//        if(productLCarnitineUnit.equals(" ")){
//            LCarnitineTitle.setVisibility(View.GONE);
//            LCarnitine.setVisibility(View.GONE);
//        } else{
//            LCarnitineTitle.setVisibility(View.VISIBLE);
//            LCarnitine.setVisibility(View.VISIBLE);
//        }
//        if(productCaHMBUnit.equals(" ")){
//            CaHMBTitle.setVisibility(View.GONE);
//            CaHMB.setVisibility(View.GONE);
//        } else{
//            CaHMBTitle.setVisibility(View.VISIBLE);
//            CaHMB.setVisibility(View.VISIBLE);
//        }
//        if(productHMBUnit.equals(" ")){
//            HMBTitle.setVisibility(View.GONE);
//            HMB.setVisibility(View.GONE);
//        } else{
//            HMBTitle.setVisibility(View.VISIBLE);
//            HMB.setVisibility(View.VISIBLE);
//        }
//        if(productInositolUnit.equals(" ")){
//            InositolTitle.setVisibility(View.GONE);
//            Inositol.setVisibility(View.GONE);
//        } else{
//            InositolTitle.setVisibility(View.VISIBLE);
//            Inositol.setVisibility(View.VISIBLE);
//        }
//////*****************************************************************************VITAMIN
//        if(productVitaminAUnit.equals(" ")){
//            VitaminATitle.setVisibility(View.GONE);
//            VitaminA.setVisibility(View.GONE);
//        } else{
//            VitaminATitle.setVisibility(View.VISIBLE);
//            VitaminA.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminAPalmitateUnit.equals(" ")){
//            VitaminA1Title.setVisibility(View.GONE);
//            VitaminA1.setVisibility(View.GONE);
//        } else{
//            VitaminA1Title.setVisibility(View.VISIBLE);
//            VitaminA1.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminABCaroteneUnit.equals(" ")){
//            VitaminA2Title.setVisibility(View.GONE);
//            VitaminA2.setVisibility(View.GONE);
//        } else{
//            VitaminA2Title.setVisibility(View.VISIBLE);
//            VitaminA2.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminDUnit.equals(" ")){
//            VitaminDTitle.setVisibility(View.GONE);
//            VitaminD.setVisibility(View.GONE);
//        } else{
//            VitaminDTitle.setVisibility(View.VISIBLE);
//            VitaminD.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminD3Unit.equals(" ")){
//            VitaminD3Title.setVisibility(View.GONE);
//            VitaminD3.setVisibility(View.GONE);
//        } else{
//            VitaminD3Title.setVisibility(View.VISIBLE);
//            VitaminD3.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminEUnit.equals(" ")){
//            VitaminETitle.setVisibility(View.GONE);
//            VitaminE.setVisibility(View.GONE);
//        } else{
//            VitaminETitle.setVisibility(View.VISIBLE);
//            VitaminE.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminKUnit.equals(" ")){
//            VitaminKTitle.setVisibility(View.GONE);
//            VitaminK.setVisibility(View.GONE);
//        } else{
//            VitaminKTitle.setVisibility(View.VISIBLE);
//            VitaminK.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminK1Unit.equals(" ")){
//            VitaminK1Title.setVisibility(View.GONE);
//            VitaminK1.setVisibility(View.GONE);
//        } else{
//            VitaminK1Title.setVisibility(View.VISIBLE);
//            VitaminK1.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminCUnit.equals(" ")){
//            VitaminCTitle.setVisibility(View.GONE);
//            VitaminC.setVisibility(View.GONE);
//        } else{
//            VitaminCTitle.setVisibility(View.VISIBLE);
//            VitaminC.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminB1Unit.equals(" ")){
//            VitaminB1Title.setVisibility(View.GONE);
//            VitaminB1.setVisibility(View.GONE);
//        } else{
//            VitaminB1Title.setVisibility(View.VISIBLE);
//            VitaminB1.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminB2Unit.equals(" ")){
//            VitaminB2Title.setVisibility(View.GONE);
//            VitaminB2.setVisibility(View.GONE);
//        } else{
//            VitaminB2Title.setVisibility(View.VISIBLE);
//            VitaminB2.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminB6Unit.equals(" ")){
//            VitaminB6Title.setVisibility(View.GONE);
//            VitaminB6.setVisibility(View.GONE);
//        } else{
//            VitaminB6Title.setVisibility(View.VISIBLE);
//            VitaminB6.setVisibility(View.VISIBLE);
//        }
//        if(productVitaminB12Unit.equals(" ")){
//            VitaminB12Title.setVisibility(View.GONE);
//            VitaminB12.setVisibility(View.GONE);
//        } else{
//            VitaminB12Title.setVisibility(View.VISIBLE);
//            VitaminB12.setVisibility(View.VISIBLE);
//        }
//        if(productNiacinUnit.equals(" ")){
//            NiacinTitle.setVisibility(View.GONE);
//            Niacin.setVisibility(View.GONE);
//        } else{
//            NiacinTitle.setVisibility(View.VISIBLE);
//            Niacin.setVisibility(View.VISIBLE);
//        }
//        if(productNiacinEquivalentUnit.equals(" ")){
//            NiacinEquivalentTitle.setVisibility(View.GONE);
//            NiacinEquivalent.setVisibility(View.GONE);
//        } else{
//            NiacinEquivalentTitle.setVisibility(View.VISIBLE);
//            NiacinEquivalent.setVisibility(View.VISIBLE);
//        }
//        if(productFolicAcidUnit.equals(" ")){
//            FolicAcidTitle.setVisibility(View.GONE);
//            FolicAcid.setVisibility(View.GONE);
//        } else{
//            FolicAcidTitle.setVisibility(View.VISIBLE);
//            FolicAcid.setVisibility(View.VISIBLE);
//        }
//        if(productBiotinUnit.equals(" ")){
//            BiotinTitle.setVisibility(View.GONE);
//            Biotin.setVisibility(View.GONE);
//        } else{
//            BiotinTitle.setVisibility(View.VISIBLE);
//            Biotin.setVisibility(View.VISIBLE);
//        }
//        if(productPantothenicAcidUnit.equals(" ")){
//            PantothenicAcidTitle.setVisibility(View.GONE);
//            PantothenicAcid.setVisibility(View.GONE);
//        } else{
//            PantothenicAcidTitle.setVisibility(View.VISIBLE);
//            PantothenicAcid.setVisibility(View.VISIBLE);
//        }
//
//////*****************************************************************************VITAMIN
//        if(productSodiumUnit.equals(" ")){
//            SodiumTitle.setVisibility(View.GONE);
//            Sodium.setVisibility(View.GONE);
//        } else{
//            SodiumTitle.setVisibility(View.VISIBLE);
//            Sodium.setVisibility(View.VISIBLE);
//        }
//
//        if(productPotassiumUnit.equals(" ")){
//            PotassiumTitle.setVisibility(View.GONE);
//            Potassium.setVisibility(View.GONE);
//        } else{
//            PotassiumTitle.setVisibility(View.VISIBLE);
//            Potassium.setVisibility(View.VISIBLE);
//        }
//        if(productChlorideUnit.equals(" ")){
//            ChlorideTitle.setVisibility(View.GONE);
//            Chloride.setVisibility(View.GONE);
//        } else{
//            ChlorideTitle.setVisibility(View.VISIBLE);
//            Chloride.setVisibility(View.VISIBLE);
//        }
//        if(productCalciumUnit.equals(" ")){
//            CalciumTitle.setVisibility(View.GONE);
//            Calcium.setVisibility(View.GONE);
//        } else{
//            CalciumTitle.setVisibility(View.VISIBLE);
//            Calcium.setVisibility(View.VISIBLE);
//        }
//        if(productPhosphorusUnit.equals(" ")){
//            PhosphorusTitle.setVisibility(View.GONE);
//            Phosphorus.setVisibility(View.GONE);
//        } else{
//            PhosphorusTitle.setVisibility(View.VISIBLE);
//            Phosphorus.setVisibility(View.VISIBLE);
//        }
//        if(productMagnesiumUnit.equals(" ")){
//            MagnesiumTitle.setVisibility(View.GONE);
//            Magnesium.setVisibility(View.GONE);
//        } else{
//            MagnesiumTitle.setVisibility(View.VISIBLE);
//            Magnesium.setVisibility(View.VISIBLE);
//        }
//        if(productIronUnit.equals(" ")){
//            IronTitle.setVisibility(View.GONE);
//            Iron.setVisibility(View.GONE);
//        } else{
//            IronTitle.setVisibility(View.VISIBLE);
//            Iron.setVisibility(View.VISIBLE);
//        }
//        if(productZincUnit.equals(" ")){
//            ZincTitle.setVisibility(View.GONE);
//            Zinc.setVisibility(View.GONE);
//        } else{
//            ZincTitle.setVisibility(View.VISIBLE);
//            Zinc.setVisibility(View.VISIBLE);
//        }
//        if(productManganeseUnit.equals(" ")){
//            ManganeseTitle.setVisibility(View.GONE);
//            Manganese.setVisibility(View.GONE);
//        } else{
//            ManganeseTitle.setVisibility(View.VISIBLE);
//            Manganese.setVisibility(View.VISIBLE);
//        }
//        if(productCopperUnit.equals(" ")){
//            CopperTitle.setVisibility(View.GONE);
//            Copper.setVisibility(View.GONE);
//        } else{
//            CopperTitle.setVisibility(View.VISIBLE);
//            Copper.setVisibility(View.VISIBLE);
//        }
//        if(productIodineUnit.equals(" ")){
//            IodineTitle.setVisibility(View.GONE);
//            Iodine.setVisibility(View.GONE);
//        } else{
//            IodineTitle.setVisibility(View.VISIBLE);
//            Iodine.setVisibility(View.VISIBLE);
//        }
//        if(productSeleniumUnit.equals(" ")){
//            SeleniumTitle.setVisibility(View.GONE);
//            Selenium.setVisibility(View.GONE);
//        } else{
//            SeleniumTitle.setVisibility(View.VISIBLE);
//            Selenium.setVisibility(View.VISIBLE);
//        }
//        if(productChromiumUnit.equals(" ")){
//            ChromiumTitle.setVisibility(View.GONE);
//            Chromium.setVisibility(View.GONE);
//        } else{
//            ChromiumTitle.setVisibility(View.VISIBLE);
//            Chromium.setVisibility(View.VISIBLE);
//        }
//        if(productMolybdenumUnit.equals(" ")){
//            MolybdenumTitle.setVisibility(View.GONE);
//            Molybdenum.setVisibility(View.GONE);
//        } else{
//            MolybdenumTitle.setVisibility(View.VISIBLE);
//            Molybdenum.setVisibility(View.VISIBLE);
//        }
//        if(productWaterUnit.equals(" ")){
//            WaterTitle.setVisibility(View.GONE);
//            Water.setVisibility(View.GONE);
//        } else{
//            WaterTitle.setVisibility(View.VISIBLE);
//            Water.setVisibility(View.VISIBLE);
//        }
//////*****************************************************************************VITAMIN
//        if(productαLactalbuminUnit.equals(" ")){
//            αLactalbuminTitle.setVisibility(View.GONE);
//            αLactalbumin.setVisibility(View.GONE);
//        } else{
//            αLactalbuminTitle.setVisibility(View.VISIBLE);
//            αLactalbumin.setVisibility(View.VISIBLE);
//        }
//        if(productβLactoglobulinUnit.equals(" ")){
//            βLactoglobulinTitle.setVisibility(View.GONE);
//            βLactoglobulin.setVisibility(View.GONE);
//        } else{
//            βLactoglobulinTitle.setVisibility(View.VISIBLE);
//            βLactoglobulin.setVisibility(View.VISIBLE);
//        }
//        if(productGlycomacropeptideUnit.equals(" ")){
//            GlycomacropeptideTitle.setVisibility(View.GONE);
//            Glycomacropeptide.setVisibility(View.GONE);
//        } else{
//            GlycomacropeptideTitle.setVisibility(View.VISIBLE);
//            Glycomacropeptide.setVisibility(View.VISIBLE);
//        }
//        if(productImmunoglobulinGIgGUnit.equals(" ")){
//            ImmunoglobulinGIgGTitle.setVisibility(View.GONE);
//            ImmunoglobulinGIgG.setVisibility(View.GONE);
//        } else{
//            ImmunoglobulinGIgGTitle.setVisibility(View.VISIBLE);
//            ImmunoglobulinGIgG.setVisibility(View.VISIBLE);
//        }
//        if(productBovineSerumAlbuminUnit.equals(" ")){
//            BovineSerumAlbuminTitle.setVisibility(View.GONE);
//            BovineSerumAlbumin.setVisibility(View.GONE);
//        } else{
//            BovineSerumAlbuminTitle.setVisibility(View.VISIBLE);
//            BovineSerumAlbumin.setVisibility(View.VISIBLE);
//        }
//        if(productProteasePeptone5Unit.equals(" ")){
//            ProteasePeptone5Title.setVisibility(View.GONE);
//            ProteasePeptone5.setVisibility(View.GONE);
//        } else{
//            ProteasePeptone5Title.setVisibility(View.VISIBLE);
//            ProteasePeptone5.setVisibility(View.VISIBLE);
//        }
//
//////*****************************************************************************VITAMIN
//        if(productIsoleucineUnit.equals(" ")){
//            IsoleucineTitle.setVisibility(View.GONE);
//            Isoleucine.setVisibility(View.GONE);
//        } else{
//            IsoleucineTitle.setVisibility(View.VISIBLE);
//            Isoleucine.setVisibility(View.VISIBLE);
//        }
//        if(productLeucineUnit.equals(" ")){
//            LeucineTitle.setVisibility(View.GONE);
//            Leucine.setVisibility(View.GONE);
//        } else{
//            LeucineTitle.setVisibility(View.VISIBLE);
//            Leucine.setVisibility(View.VISIBLE);
//        }
//        if(productLysineUnit.equals(" ")){
//            LysineTitle.setVisibility(View.GONE);
//            Lysine.setVisibility(View.GONE);
//        } else{
//            LysineTitle.setVisibility(View.VISIBLE);
//            Lysine.setVisibility(View.VISIBLE);
//        }
//        if(productMethionineUnit.equals(" ")){
//            MethionineTitle.setVisibility(View.GONE);
//            Methionine.setVisibility(View.GONE);
//        } else{
//            MethionineTitle.setVisibility(View.VISIBLE);
//            Methionine.setVisibility(View.VISIBLE);
//        }
//        if(productPhenylalanineUnit.equals(" ")){
//            PhenylalanineTitle.setVisibility(View.GONE);
//            Phenylalanine.setVisibility(View.GONE);
//        } else{
//            PhenylalanineTitle.setVisibility(View.VISIBLE);
//            Phenylalanine.setVisibility(View.VISIBLE);
//        }
//        if(productThreonineUnit.equals(" ")){
//            ThreonineTitle.setVisibility(View.GONE);
//            Threonine.setVisibility(View.GONE);
//        } else{
//            ThreonineTitle.setVisibility(View.VISIBLE);
//            Threonine.setVisibility(View.VISIBLE);
//        }
//        if(productTryptophanUnit.equals(" ")){
//            TryptophanTitle.setVisibility(View.GONE);
//            Tryptophan.setVisibility(View.GONE);
//        } else{
//            TryptophanTitle.setVisibility(View.VISIBLE);
//            Tryptophan.setVisibility(View.VISIBLE);
//        }
//        if(productValineUnit.equals(" ")){
//            ValineTitle.setVisibility(View.GONE);
//            Valine.setVisibility(View.GONE);
//        } else{
//            ValineTitle.setVisibility(View.VISIBLE);
//            Valine.setVisibility(View.VISIBLE);
//        }
//        if(productHistidineUnit.equals(" ")){
//            HistidineTitle.setVisibility(View.GONE);
//            Histidine.setVisibility(View.GONE);
//        } else{
//            HistidineTitle.setVisibility(View.VISIBLE);
//            Histidine.setVisibility(View.VISIBLE);
//        }
//        if(productAlanineUnit.equals(" ")){
//            AlanineTitle.setVisibility(View.GONE);
//            Alanine.setVisibility(View.GONE);
//        } else{
//            AlanineTitle.setVisibility(View.VISIBLE);
//            Alanine.setVisibility(View.VISIBLE);
//        }
//        if(productArginineUnit.equals(" ")){
//            ArginineTitle.setVisibility(View.GONE);
//            Arginine.setVisibility(View.GONE);
//        } else{
//            ArginineTitle.setVisibility(View.VISIBLE);
//            Arginine.setVisibility(View.VISIBLE);
//        }
//        if(productAsparticAcidUnit.equals(" ")){
//            AsparticAcidTitle.setVisibility(View.GONE);
//            AsparticAcid.setVisibility(View.GONE);
//        } else{
//            AsparticAcidTitle.setVisibility(View.VISIBLE);
//            AsparticAcid.setVisibility(View.VISIBLE);
//        }
//        if(productCysteineUnit.equals(" ")){
//            CysteineTitle.setVisibility(View.GONE);
//            Cysteine.setVisibility(View.GONE);
//        } else{
//            CysteineTitle.setVisibility(View.VISIBLE);
//            Cysteine.setVisibility(View.VISIBLE);
//        }
//        if(productGlutamicAcidUnit.equals(" ")){
//            GlutamicAcidTitle.setVisibility(View.GONE);
//            GlutamicAcid.setVisibility(View.GONE);
//        } else{
//            GlutamicAcidTitle.setVisibility(View.VISIBLE);
//            GlutamicAcid.setVisibility(View.VISIBLE);
//        }
//        if(productGlycineUnit.equals(" ")){
//            GlycineTitle.setVisibility(View.GONE);
//            Glycine.setVisibility(View.GONE);
//        } else{
//            GlycineTitle.setVisibility(View.VISIBLE);
//            Glycine.setVisibility(View.VISIBLE);
//        }
//        if(productProlineUnit.equals(" ")){
//            ProlineTitle.setVisibility(View.GONE);
//            Proline.setVisibility(View.GONE);
//        } else{
//            ProlineTitle.setVisibility(View.VISIBLE);
//            Proline.setVisibility(View.VISIBLE);
//        }
//        if(productSerineUnit.equals(" ")){
//            SerineTitle.setVisibility(View.GONE);
//            Serine.setVisibility(View.GONE);
//        } else{
//            SerineTitle.setVisibility(View.VISIBLE);
//            Serine.setVisibility(View.VISIBLE);
//        }
//        if(productTyrosineUnit.equals(" ")){
//            TyrosineTitle.setVisibility(View.GONE);
//            Tyrosine.setVisibility(View.GONE);
//        } else{
//            TyrosineTitle.setVisibility(View.VISIBLE);
//            Tyrosine.setVisibility(View.VISIBLE);
//        }
//        if(productHydroxyLysineUnit.equals(" ")){
//            HydroxyLysineTitle.setVisibility(View.GONE);
//            HydroxyLysine.setVisibility(View.GONE);
//        } else{
//            HydroxyLysineTitle.setVisibility(View.VISIBLE);
//            HydroxyLysine.setVisibility(View.VISIBLE);
//        }
//        if(productHydroxyProlineUnit.equals(" ")){
//            HydroxyProlineTitle.setVisibility(View.GONE);
//            HydroxyProline.setVisibility(View.GONE);
//        } else{
//            HydroxyProlineTitle.setVisibility(View.VISIBLE);
//            HydroxyProline.setVisibility(View.VISIBLE);
//        }
//
//        bottomSheetDialog.show();
//
//
//
//    }
//
//    @Override
//    public int getItemCount() {
//        return productList.size();
//    }
//
//    @Override
//    public Filter getFilter() {
//        if (filter == null){
//            filter = new FilterProductUser(this,filterList);
//        }
//        return filter;
//    }
//
//    //holds view of recyclerview
//    class HolderProduct extends RecyclerView.ViewHolder{
//
//        private ImageView productIconIv;
//        private TextView productNameTv,productDescriptionTv,productCategoryTv,productSubCategoryTv;
//
//        //create constructor
//        public HolderProduct(@NonNull View itemView) {
//            super(itemView);
//
//            productIconIv =itemView.findViewById(R.id.productIconIv);
//            productNameTv =itemView.findViewById(R.id.productNameTv);
//            productDescriptionTv =itemView.findViewById(R.id.productDescriptionTv);
//            productCategoryTv =itemView.findViewById(R.id.productCategoryTv);
//            productSubCategoryTv =itemView.findViewById(R.id.productSubCategoryTv);
//
//        }
//    }
//}
