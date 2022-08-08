package com.example.milc;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class AddProductNutrientActivity extends AppCompatActivity {

//    private TextView AmountUnit,EnergyUnit,ProteinUnit, FatUnit,MUFAUnit,PUFAUnit,LinoleicAcidUnit,αlinolenicAcidUnit,EPAUnit,DHAUnit,SFAUnit, MCToilUnit,TransfattyAcidUnit,CholesterolUnit,
//                     CarbohydrateUnit ,LactoseUnit,TotalFatUnit,EssentialAminoAcidsUnit,BranchedChainAminoAcidsUnit,PolyolsUnit,TotalSugarUnit,FiberUnit,InulinUnit,DietaryfiberUnit,
//                     SolublefiberUnit,SugarUnit,FOSUnit,CholineUnit,TaurineUnit,InositolUnit,LcarnitineUnit,CarnitineUnit;

//    private TextView VitaminAUnit,VitaminAPalmitateUnit ,VitaminABcaroteneUnit,VitaminDUnit,VitaminD3Unit,VitaminEUnit ,VitaminKUnit,VitaminK1Unit,VitaminCUnit ,
//                      VitaminB1Unit,VitaminB2Unit,VitaminB6Unit,VitaminB12Unit ,NiacinUnit,NiacinEquivalentUnit,FolicAcidUnit,BiotinUnit ,PantothenicAcidUnit;

//    private TextView SodiumUnit ,PotassiumUnit,ChlorideUnit,CalciumUnit,PhosphorusUnit,MagnesiumUnit ,IronUnit ,ZincUnit ,ManganeseUnit,CopperUnit,IodineUnit,SeleniumUnit ,
//                      ChromiumUnit,MolybdenumUnit,αLactalbuminUnit,βLactoglobulinUnit,GlycomacropeptideUnit,ImmunoglobulinUnit,BovineSerumAlbuminUnit,Proteasepeptone5Unit,WaterUnit ,SaltUnit;

//    private TextView IsoleucineUnit, LeucineUnit ,LysineUnit,MethionineUnit,PhenylalanineUnit,ThreonineUnit ,TryptophanUnit,ValineUnit,HistidineUnit,AlanineUnit ,
//                      ArginineUnit ,AsparticAcidUnit, CysteineUnit,GlutamicAcidUnit ,GlycineUnit,ProlineUnit ,SerineUnit ,TyrosineUnit ,HydroxyProlineUnit,HydroxyLysineUnit,caHMBUnit ,HMBUnit;


//    private TextView amountType;
//    private EditText AmountEt,EnergyEt,ProteinEt,FatEt,MUFAEt,PUFAEt,LinoleicAcidEt,αlinolenicAcidEt,EPAEt,DHAEt,SFAEt,MCToilEt,TransfattyAcidsEt ,CholesterolEt ,CarbohydrateEt ,
//                      LactoseEt,TotalFatEt,EssentialAminoAcidsEt,BranchedChainAminoAcidsEt,PolyolsEt ,TotalSugarEt,FiberEt,InulinEt,DietaryfiberEt,SolubleFiberEt,SugarEt,FOSEt,CholineEt,
//                      TaurineEt,InositolEt,LcarnitineEt,CarnitineEt;

//    private EditText VitaminAEt,VitaminAPalmitateEt ,VitaminABcaroteneEt ,VitaminDEt,VitaminD3Et, VitaminEEt,VitaminKEt ,VitaminK1Et ,VitaminCEt ,VitaminB1Et ,VitaminB2Et,
//                      VitaminB6Et ,VitaminB12Et,NiacinEt ,NiacinEquivalentEt ,FolicAcidEt,BiotinEt ,PantothenicAcidEt;

//    private EditText SodiumEt,PotassiumEt,ChlorideEt ,CalciumEt ,PhosphorusEt ,MagnesiumEt ,IronEt ,ZincEt,ManganeseEt,CopperEt ,IodineEt,SeleniumEt ,ChromiumEt,MolybdenumEt,
//                      αLactalbuminEt,βLactoglobulinEt,GlycomacropeptideEt,ImmunoglobulinEt,BovineSerumAlbuminEt,Proteasepeptone5Et,WaterEt ,SaltEt;

//    private EditText IsoleucineEt ,LeucineEt,LysineEt,MethionineEt,PhenylalanineEt,ThreonineEt ,TryptophanEt ,ValineEt,HistidineEt ,AlanineEt,ArginineEt ,AsparticAcidEt,
//                      CysteineEt ,GlutamicAcidEt,GlycineEt ,ProlineEt ,SerineEt ,TyrosineEt ,HydroxyProlineEt,HydroxyLysineEt,caHMBEt ,HMBEt;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product_nutrient);

//        //value
//        amountEt  = findViewById(R.id.AmountEt);
//        EnergyEt  = findViewById(R.id.EnergyEt);
//        ProteinEt  = findViewById(R.id.ProteinEt);
//        FatEt  = findViewById(R.id.FatEt);
//        MUFAEt  = findViewById(R.id.MUFAEt);
//        PUFAEt  = findViewById(R.id.PUFAEt);
//        LinoleicAcidEt  = findViewById(R.id.LinoleicAcidEt);
//        αlinolenicAcidEt  = findViewById(R.id.αlinolenicAcidEt);
//        SFAEt  = findViewById(R.id.SFAEt);
//        MCToilEt  = findViewById(R.id.MCToilEt);
//        TransfattyAcidsEt  = findViewById(R.id.TransfattyAcidsEt);
//        CholesterolEt  = findViewById(R.id.CholesterolEt);
//        CarbohydrateEt  = findViewById(R.id.CarbohydrateEt);
//        LactoseEt  = findViewById(R.id.LactoseEt);
//        PolyolsEt  = findViewById(R.id.PolyolsEt);
//        TotalsugarEt  = findViewById(R.id.TotalsugarEt);
//        FiberEt  = findViewById(R.id.FiberEt);
//        DietaryfiberEt  = findViewById(R.id.DietaryfiberEt);
//        FOSEt  = findViewById(R.id.FOSEt);
//        CholineEt  = findViewById(R.id.CholineEt);
//        TaurineEt  = findViewById(R.id.TaurineEt);
//        LcarnitineEt  = findViewById(R.id.LcarnitineEt);
//        CarnitineEt  = findViewById(R.id.CarnitineEt);
//        VitaminAEt  = findViewById(R.id.VitaminAEt);
//        VitaminAPalmitateEt  = findViewById(R.id.VitaminAPalmitateEt);
//        VitaminABcaroteneEt  = findViewById(R.id.VitaminABcaroteneEt);
//        VitaminDEt  = findViewById(R.id.VitaminDEt);
//        VitaminD3Et  = findViewById(R.id.VitaminD3Et);
//        VitaminEEt  = findViewById(R.id.VitaminEEt);
//        VitaminKEt  = findViewById(R.id.VitaminKEt);
//        VitaminK1Et  = findViewById(R.id.VitaminK1Et);
//        VitaminCEt  = findViewById(R.id.VitaminCEt);
//        VitaminB1Et  = findViewById(R.id.VitaminB1Et);
//        VitaminB2Et  = findViewById(R.id.VitaminB2Et);
//        VitaminB6Et  = findViewById(R.id.VitaminB6Et);
//        VitaminB12Et  = findViewById(R.id.VitaminB12Et);
//        NiacinEt  = findViewById(R.id.NiacinEt);
//        NiacinEquivalentEt  = findViewById(R.id.NiacinEquivalentEt);
//        FolicAcidEt  = findViewById(R.id.FolicAcidEt);
//        BiotinEt  = findViewById(R.id.BiotinEt);
//        PantothenicAcidEt  = findViewById(R.id.PantothenicAcidEt);
//        SodiumEt  = findViewById(R.id.SodiumEt);
//        PotassiumEt  = findViewById(R.id.PotassiumEt);
//        ChlorideEt  = findViewById(R.id.ChlorideEt);
//        CalciumEt  = findViewById(R.id.CalciumEt);
//        PhosphorusEt  = findViewById(R.id.PhosphorusEt);
//        MagnesiumEt  = findViewById(R.id.MagnesiumEt);
//        IronEt  = findViewById(R.id.IronEt);
//        ZincEt  = findViewById(R.id.ZincEt);
//        ManganeseEt  = findViewById(R.id.ManganeseEt);
//        CopperEt  = findViewById(R.id.CopperEt);
//        IodineEt  = findViewById(R.id.IodineEt);
//        SeleniumEt  = findViewById(R.id.SeleniumEt);
//        ChromiumEt  = findViewById(R.id.ChromiumEt);
//        MolybdenumEt  = findViewById(R.id.MolybdenumEt);
//        WaterEt  = findViewById(R.id.WaterEt);
//        SaltEt  = findViewById(R.id.SaltEt);
//        IsoleucineEt  = findViewById(R.id.IsoleucineEt);
//        LeucineEt  = findViewById(R.id.LeucineEt);
//        LysineEt  = findViewById(R.id.LysineEt);
//        MethionineEt  = findViewById(R.id.MethionineEt);
//        PhenylalanineEt  = findViewById(R.id.PhenylalanineEt);
//        ThreonineEt  = findViewById(R.id.ThreonineEt);
//        TryptophanEt  = findViewById(R.id.TryptophanEt);
//        ValineEt  = findViewById(R.id.ValineEt);
//        HistidineEt  = findViewById(R.id.HistidineEt);
//        AlanineEt  = findViewById(R.id.AlanineEt);
//        ArginineEt  = findViewById(R.id.ArginineEt);
//        AsparticAcidEt  = findViewById(R.id.AsparticAcidEt);
//        CysteineEt  = findViewById(R.id.CysteineEt);
//        GlutamicAcidEt  = findViewById(R.id.GlutamicAcidEt);
//        GlycineEt  = findViewById(R.id.GlycineEt);
//        ProlineEt  = findViewById(R.id.ProlineEt);
//        SerineEt  = findViewById(R.id.SerineEt);
//        TyrosineEt  = findViewById(R.id.TyrosineEt);
//        caHMBEt  = findViewById(R.id.caHMBEt);
//        HMBEt  = findViewById(R.id.HMBEt);
//
//        //unit
//        amountUnit  = findViewById(R.id.AmountUnit);
//        amountType  = findViewById(R.id.AmountType);
//        EnergyUnit  = findViewById(R.id.EnergyUnit);
//        ProteinUnit  = findViewById(R.id.ProteinUnit);
//        FatUnit  = findViewById(R.id.FatUnit);
//        MUFAUnit  = findViewById(R.id.MUFAUnit);
//        PUFAUnit  = findViewById(R.id.PUFAUnit);
//        LinoleicAcidUnit  = findViewById(R.id.LinoleicAcidUnit);
//        αlinolenicAcidUnit  = findViewById(R.id.αlinolenicAcidUnit);
//        SFAUnit  = findViewById(R.id.SFAUnit);
//        MCToilUnit  = findViewById(R.id.MCToilUnit);
//        TransfattyAcidUnit  = findViewById(R.id.TransfattyAcidUnit);
//        CholesterolUnit  = findViewById(R.id.CholesterolUnit);
//        CarbohydrateUnit  = findViewById(R.id.CarbohydrateUnit);
//        LactoseUnit  = findViewById(R.id.LactoseUnit);
//        PolyolsUnit  = findViewById(R.id.PolyolsUnit);
//        TotalsugarUnit  = findViewById(R.id.TotalsugarUnit);
//        FiberUnit  = findViewById(R.id.FiberUnit);
//        DietaryfiberUnit  = findViewById(R.id.DietaryfiberUnit);
//        FOSUnit  = findViewById(R.id.FOSUnit);
//        CholineUnit  = findViewById(R.id.CholineUnit);
//        TaurineUnit  = findViewById(R.id.TaurineUnit);
//        LcarnitineUnit  = findViewById(R.id.LcarnitineUnit);
//        CarnitineUnit  = findViewById(R.id.CarnitineUnit);
//        VitaminAUnit  = findViewById(R.id.VitaminAUnit);
//        VitaminAPalmitateUnit  = findViewById(R.id.VitaminAPalmitateUnit);
//        VitaminABcaroteneUnit  = findViewById(R.id.VitaminABcaroteneUnit);
//        VitaminDUnit  = findViewById(R.id.VitaminDUnit);
//        VitaminD3Unit  = findViewById(R.id.VitaminD3Unit);
//        VitaminEUnit  = findViewById(R.id.VitaminEUnit);
//        VitaminKUnit  = findViewById(R.id.VitaminKUnit);
//        VitaminK1Unit  = findViewById(R.id.VitaminK1Unit);
//        VitaminCUnit  = findViewById(R.id.VitaminCUnit);
//        VitaminB1Unit  = findViewById(R.id.VitaminB1Unit);
//        VitaminB2Unit  = findViewById(R.id.VitaminB2Unit);
//        VitaminB6Unit  = findViewById(R.id.VitaminB6Unit);
//        VitaminB12Unit  = findViewById(R.id.VitaminB12Unit);
//        NiacinUnit  = findViewById(R.id.NiacinUnit);
//        NiacinEquivalentUnit  = findViewById(R.id.NiacinEquivalentUnit);
//        FolicAcidUnit  = findViewById(R.id.FolicAcidUnit);
//        BiotinUnit  = findViewById(R.id.BiotinUnit);
//        PantothenicAcidUnit  = findViewById(R.id.PantothenicAcidUnit);
//        SodiumUnit  = findViewById(R.id.SodiumUnit);
//        PotassiumUnit  = findViewById(R.id.PotassiumUnit);
//        ChlorideUnit  = findViewById(R.id.ChlorideUnit);
//        CalciumUnit  = findViewById(R.id.CalciumUnit);
//        PhosphorusUnit  = findViewById(R.id.PhosphorusUnit);
//        MagnesiumUnit  = findViewById(R.id.MagnesiumUnit);
//        IronUnit  = findViewById(R.id.IronUnit);
//        ZincUnit  = findViewById(R.id.ZincUnit);
//        ManganeseUnit  = findViewById(R.id.ManganeseUnit);
//        CopperUnit  = findViewById(R.id.CopperUnit);
//        IodineUnit  = findViewById(R.id.IodineUnit);
//        SeleniumUnit  = findViewById(R.id.SeleniumUnit);
//        ChromiumUnit  = findViewById(R.id.ChromiumUnit);
//        MolybdenumUnit  = findViewById(R.id.MolybdenumUnit);
//        WaterUnit  = findViewById(R.id.WaterUnit);
//        SaltUnit  = findViewById(R.id.SaltUnit);
//        IsoleucineUnit  = findViewById(R.id.IsoleucineUnit);
//        LeucineUnit  = findViewById(R.id.LeucineUnit);
//        LysineUnit  = findViewById(R.id.LysineUnit);
//        MethionineUnit  = findViewById(R.id.MethionineUnit);
//        PhenylalanineUnit  = findViewById(R.id.PhenylalanineUnit);
//        ThreonineUnit  = findViewById(R.id.ThreonineUnit);
//        TryptophanUnit  = findViewById(R.id.TryptophanUnit);
//        ValineUnit  = findViewById(R.id.ValineUnit);
//        HistidineUnit  = findViewById(R.id.HistidineUnit);
//        AlanineUnit  = findViewById(R.id.AlanineUnit);
//        ArginineUnit  = findViewById(R.id.ArginineUnit);
//        AsparticAcidUnit  = findViewById(R.id.AsparticAcidUnit);
//        CysteineUnit  = findViewById(R.id.CysteineUnit);
//        GlutamicAcidUnit  = findViewById(R.id.GlutamicAcidUnit);
//        GlycineUnit  = findViewById(R.id.GlycineUnit);
//        ProlineUnit  = findViewById(R.id.ProlineUnit);
//        SerineUnit  = findViewById(R.id.SerineUnit);
//        TyrosineUnit  = findViewById(R.id.TyrosineUnit);
//        caHMBUnit  = findViewById(R.id.caHMBUnit);
//        HMBUnit  = findViewById(R.id.HMBUnit);
//        InositolUnit = findViewById(R.id.InositolUnit);

        //visibility
//        amountEt.setVisibility(View.GONE);
//        EnergyEt.setVisibility(View.GONE);
//        ProteinEt.setVisibility(View.GONE);
//        FatEt.setVisibility(View.GONE);
//        MUFAEt.setVisibility(View.GONE);
//        PUFAEt.setVisibility(View.GONE);
//        LinoleicAcidEt.setVisibility(View.GONE);
//        αlinolenicAcidEt.setVisibility(View.GONE);
//        SFAEt.setVisibility(View.GONE);
//        MCToilEt.setVisibility(View.GONE);
//        TransfattyAcidsEt.setVisibility(View.GONE);
//        CholesterolEt.setVisibility(View.GONE);
//        CarbohydrateEt .setVisibility(View.GONE);
//        LactoseEt.setVisibility(View.GONE);
//        PolyolsEt.setVisibility(View.GONE);
//        TotalsugarEt .setVisibility(View.GONE);
//        FiberEt.setVisibility(View.GONE);
//        DietaryfiberEt.setVisibility(View.GONE);
//        FOSEt.setVisibility(View.GONE);
//        CholineEt .setVisibility(View.GONE);
//        TaurineEt.setVisibility(View.GONE);
//        LcarnitineEt.setVisibility(View.GONE);
//        CarnitineEt.setVisibility(View.GONE);
//        VitaminAEt.setVisibility(View.GONE);
//        VitaminAPalmitateEt.setVisibility(View.GONE);
//        VitaminABcaroteneEt .setVisibility(View.GONE);
//        VitaminDEt.setVisibility(View.GONE);
//        VitaminD3Et.setVisibility(View.GONE);
//        VitaminEEt.setVisibility(View.GONE);
//        VitaminKEt .setVisibility(View.GONE);
//        VitaminK1Et .setVisibility(View.GONE);
//        VitaminCEt.setVisibility(View.GONE);
//        VitaminB1Et.setVisibility(View.GONE);
//        VitaminB2Et.setVisibility(View.GONE);
//        VitaminB6Et .setVisibility(View.GONE);
//        VitaminB12Et.setVisibility(View.GONE);
//        NiacinEt.setVisibility(View.GONE);
//        NiacinEquivalentEt.setVisibility(View.GONE);
//        FolicAcidEt.setVisibility(View.GONE);
//        BiotinEt.setVisibility(View.GONE);
//        PantothenicAcidEt.setVisibility(View.GONE);
//        SodiumEt.setVisibility(View.GONE);
//        PotassiumEt.setVisibility(View.GONE);
//        ChlorideEt.setVisibility(View.GONE);
//        CalciumEt.setVisibility(View.GONE);
//        PhosphorusEt.setVisibility(View.GONE);
//        MagnesiumEt.setVisibility(View.GONE);
//        IronEt .setVisibility(View.GONE);
//        ZincEt.setVisibility(View.GONE);
//        ManganeseEt.setVisibility(View.GONE);
//        CopperEt .setVisibility(View.GONE);
//        IodineEt .setVisibility(View.GONE);
//        SeleniumEt.setVisibility(View.GONE);
//        ChromiumEt.setVisibility(View.GONE);
//        MolybdenumEt .setVisibility(View.GONE);
//        WaterEt.setVisibility(View.GONE);
//        SaltEt .setVisibility(View.GONE);
//        IsoleucineEt .setVisibility(View.GONE);
//        LeucineEt.setVisibility(View.GONE);
//        LysineEt .setVisibility(View.GONE);
//        MethionineEt.setVisibility(View.GONE);
//        PhenylalanineEt.setVisibility(View.GONE);
//        ThreonineEt.setVisibility(View.GONE);
//        TryptophanEt .setVisibility(View.GONE);
//        ValineEt .setVisibility(View.GONE);
//        HistidineEt .setVisibility(View.GONE);
//        AlanineEt .setVisibility(View.GONE);
//        ArginineEt .setVisibility(View.GONE);
//        AsparticAcidEt .setVisibility(View.GONE);
//        CysteineEt.setVisibility(View.GONE);
//        GlutamicAcidEt.setVisibility(View.GONE);
//        GlycineEt .setVisibility(View.GONE);
//        ProlineEt.setVisibility(View.GONE);
//        SerineEt .setVisibility(View.GONE);
//        TyrosineEt.setVisibility(View.GONE);
//        caHMBEt .setVisibility(View.GONE);
//        HMBEt .setVisibility(View.GONE);
//
//        amountUnit.setVisibility(View.GONE);
//        amountType.setVisibility(View.GONE);
//        EnergyUnit.setVisibility(View.GONE);
//        ProteinUnit .setVisibility(View.GONE);
//        FatUnit .setVisibility(View.GONE);
//        MUFAUnit.setVisibility(View.GONE);
//        PUFAUnit.setVisibility(View.GONE);
//        LinoleicAcidUnit.setVisibility(View.GONE);
//        αlinolenicAcidUnit .setVisibility(View.GONE);
//        SFAUnit.setVisibility(View.GONE);
//        MCToilUnit .setVisibility(View.GONE);
//        TransfattyAcidUnit .setVisibility(View.GONE);
//        CholesterolUnit.setVisibility(View.GONE);
//        CarbohydrateUnit .setVisibility(View.GONE);
//        LactoseUnit .setVisibility(View.GONE);
//        PolyolsUnit .setVisibility(View.GONE);
//        TotalsugarUnit .setVisibility(View.GONE);
//        FiberUnit .setVisibility(View.GONE);
//        DietaryfiberUnit .setVisibility(View.GONE);
//        FOSUnit .setVisibility(View.GONE);
//        CholineUnit .setVisibility(View.GONE);
//        TaurineUnit .setVisibility(View.GONE);
//        LcarnitineUnit.setVisibility(View.GONE);
//        CarnitineUnit .setVisibility(View.GONE);
//        VitaminAUnit .setVisibility(View.GONE);
//        VitaminAPalmitateUnit.setVisibility(View.GONE);
//        VitaminABcaroteneUnit .setVisibility(View.GONE);
//        VitaminDUnit .setVisibility(View.GONE);
//        VitaminD3Unit.setVisibility(View.GONE);
//        VitaminEUnit.setVisibility(View.GONE);
//        VitaminKUnit.setVisibility(View.GONE);
//        VitaminK1Unit.setVisibility(View.GONE);
//        VitaminCUnit.setVisibility(View.GONE);
//        VitaminB1Unit.setVisibility(View.GONE);
//        VitaminB2Unit.setVisibility(View.GONE);
//        VitaminB6Unit .setVisibility(View.GONE);
//        VitaminB12Unit .setVisibility(View.GONE);
//        NiacinUnit.setVisibility(View.GONE);
//        NiacinEquivalentUnit.setVisibility(View.GONE);
//        FolicAcidUnit.setVisibility(View.GONE);
//        BiotinUnit.setVisibility(View.GONE);
//        PantothenicAcidUnit.setVisibility(View.GONE);
//        SodiumUnit.setVisibility(View.GONE);
//        PotassiumUnit.setVisibility(View.GONE);
//        ChlorideUnit.setVisibility(View.GONE);
//        CalciumUnit.setVisibility(View.GONE);
//        PhosphorusUnit.setVisibility(View.GONE);
//        MagnesiumUnit.setVisibility(View.GONE);
//        IronUnit.setVisibility(View.GONE);
//        ZincUnit .setVisibility(View.GONE);
//        ManganeseUnit .setVisibility(View.GONE);
//        CopperUnit.setVisibility(View.GONE);
//        IodineUnit.setVisibility(View.GONE);
//        SeleniumUnit .setVisibility(View.GONE);
//        ChromiumUnit .setVisibility(View.GONE);
//        MolybdenumUnit .setVisibility(View.GONE);
//        WaterUnit.setVisibility(View.GONE);
//        SaltUnit.setVisibility(View.GONE);
//        IsoleucineUnit .setVisibility(View.GONE);
//        LeucineUnit.setVisibility(View.GONE);
//        LysineUnit .setVisibility(View.GONE);
//        MethionineUnit .setVisibility(View.GONE);
//        PhenylalanineUnit .setVisibility(View.GONE);
//        ThreonineUnit.setVisibility(View.GONE);
//        TryptophanUnit .setVisibility(View.GONE);
//        ValineUnit .setVisibility(View.GONE);
//        HistidineUnit .setVisibility(View.GONE);
//        AlanineUnit .setVisibility(View.GONE);
//        ArginineUnit .setVisibility(View.GONE);
//        AsparticAcidUnit .setVisibility(View.GONE);
//        CysteineUnit .setVisibility(View.GONE);
//        GlutamicAcidUnit.setVisibility(View.GONE);
//        GlycineUnit .setVisibility(View.GONE);
//        ProlineUnit.setVisibility(View.GONE);
//        SerineUnit .setVisibility(View.GONE);
//        TyrosineUnit .setVisibility(View.GONE);
//        caHMBUnit .setVisibility(View.GONE);
//        HMBUnit  .setVisibility(View.GONE);

        //        amountSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    amountEt.setVisibility(View.VISIBLE);
//                    amountUnit.setVisibility(View.VISIBLE);
//                    amountType.setVisibility(View.VISIBLE);
//                }else{
//                    amountEt.setVisibility(View.GONE);
//                    amountUnit.setVisibility(View.GONE);
//                    amountType.setVisibility(View.GONE);
//                }
//            }
//        });
//        EnergySwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    EnergyEt.setVisibility(View.VISIBLE);
//                    EnergyUnit.setVisibility(View.VISIBLE);
//                }else{
//                    EnergyEt.setVisibility(View.GONE);
//                    EnergyUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ProteinSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ProteinEt.setVisibility(View.VISIBLE);
//                    ProteinUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ProteinEt.setVisibility(View.GONE);
//                    ProteinUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        FatSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    FatEt.setVisibility(View.VISIBLE);
//                    FatUnit.setVisibility(View.VISIBLE);
//                }else{
//                    FatEt.setVisibility(View.GONE);
//                    FatUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        MUFASwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    MUFAEt.setVisibility(View.VISIBLE);
//                    MUFAUnit.setVisibility(View.VISIBLE);
//                }else{
//                    MUFAEt.setVisibility(View.GONE);
//                    MUFAUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        PUFASwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    PUFAEt.setVisibility(View.VISIBLE);
//                    PUFAUnit.setVisibility(View.VISIBLE);
//                }else{
//                    PUFAEt.setVisibility(View.GONE);
//                    PUFAUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        LinoleicAcidSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    LinoleicAcidEt.setVisibility(View.VISIBLE);
//                    LinoleicAcidUnit.setVisibility(View.VISIBLE);
//                }else{
//                    LinoleicAcidEt.setVisibility(View.GONE);
//                    LinoleicAcidUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        αlinolenicAcidSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    αlinolenicAcidEt.setVisibility(View.VISIBLE);
//                    αlinolenicAcidUnit.setVisibility(View.VISIBLE);
//                }else{
//                    αlinolenicAcidEt.setVisibility(View.GONE);
//                    αlinolenicAcidUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        SFASwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    SFAEt.setVisibility(View.VISIBLE);
//                    SFAUnit.setVisibility(View.VISIBLE);
//                }else{
//                    SFAEt.setVisibility(View.GONE);
//                    SFAUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        MCToilSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    MCToilEt.setVisibility(View.VISIBLE);
//                    MCToilUnit.setVisibility(View.VISIBLE);
//                }else{
//                    MCToilEt.setVisibility(View.GONE);
//                    MCToilUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        TransfattyAcidsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    TransfattyAcidsEt.setVisibility(View.VISIBLE);
//                    TransfattyAcidUnit.setVisibility(View.VISIBLE);
//                }else{
//                    TransfattyAcidsEt.setVisibility(View.GONE);
//                    TransfattyAcidUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        CholesterolSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    CholesterolEt.setVisibility(View.VISIBLE);
//                    CholesterolUnit.setVisibility(View.VISIBLE);
//                }else{
//                    CholesterolEt.setVisibility(View.GONE);
//                    CholesterolUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        CarbohydrateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    CarbohydrateEt.setVisibility(View.VISIBLE);
//                    CarbohydrateUnit.setVisibility(View.VISIBLE);
//                }else{
//                    CarbohydrateEt.setVisibility(View.GONE);
//                    CarbohydrateUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        LactoseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    LactoseEt.setVisibility(View.VISIBLE);
//                    LactoseUnit.setVisibility(View.VISIBLE);
//                }else{
//                    LactoseEt.setVisibility(View.GONE);
//                    LactoseUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        PolyolsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    PolyolsEt.setVisibility(View.VISIBLE);
//                    PolyolsUnit.setVisibility(View.VISIBLE);
//                }else{
//                    PolyolsEt.setVisibility(View.GONE);
//                    PolyolsUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        TotalsugarSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    TotalsugarEt.setVisibility(View.VISIBLE);
//                    TotalsugarUnit.setVisibility(View.VISIBLE);
//                }else{
//                    TotalsugarEt.setVisibility(View.GONE);
//                    TotalsugarUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        FiberSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    FiberEt.setVisibility(View.VISIBLE);
//                    FiberUnit.setVisibility(View.VISIBLE);
//                }else{
//                    FiberEt.setVisibility(View.GONE);
//                    FiberUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        DietaryfiberSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    DietaryfiberEt.setVisibility(View.VISIBLE);
//                    DietaryfiberUnit.setVisibility(View.VISIBLE);
//                }else{
//                    DietaryfiberEt.setVisibility(View.GONE);
//                    DietaryfiberUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        FOSSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    FOSEt.setVisibility(View.VISIBLE);
//                    FOSUnit.setVisibility(View.VISIBLE);
//                }else{
//                    FOSEt.setVisibility(View.GONE);
//                    FOSUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        CholineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    CholineEt.setVisibility(View.VISIBLE);
//                    CholineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    CholineEt.setVisibility(View.GONE);
//                    CholineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        TaurineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    TaurineEt.setVisibility(View.VISIBLE);
//                    TaurineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    TaurineEt.setVisibility(View.GONE);
//                    TaurineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        LcarnitineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    LcarnitineEt.setVisibility(View.VISIBLE);
//                    LcarnitineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    LcarnitineEt.setVisibility(View.GONE);
//                    LcarnitineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        CarnitineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    CarnitineEt.setVisibility(View.VISIBLE);
//                    CarnitineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    CarnitineEt.setVisibility(View.GONE);
//                    CarnitineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminASwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminAEt.setVisibility(View.VISIBLE);
//                    VitaminAUnit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminAEt.setVisibility(View.GONE);
//                    VitaminAUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminAPalmitateSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminAPalmitateEt.setVisibility(View.VISIBLE);
//                    VitaminAPalmitateUnit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminAPalmitateEt.setVisibility(View.GONE);
//                    VitaminAPalmitateUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminABcaroteneSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminABcaroteneEt.setVisibility(View.VISIBLE);
//                    VitaminABcaroteneUnit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminABcaroteneEt.setVisibility(View.GONE);
//                    VitaminABcaroteneUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminDSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminDEt.setVisibility(View.VISIBLE);
//                    VitaminDUnit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminDEt.setVisibility(View.GONE);
//                    VitaminDUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminD3Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminD3Et.setVisibility(View.VISIBLE);
//                    VitaminD3Unit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminD3Et.setVisibility(View.GONE);
//                    VitaminD3Unit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminESwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminEEt.setVisibility(View.VISIBLE);
//                    VitaminEUnit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminEEt.setVisibility(View.GONE);
//                    VitaminEUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminKSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminKEt.setVisibility(View.VISIBLE);
//                    VitaminKUnit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminKEt.setVisibility(View.GONE);
//                    VitaminKUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminK1Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminK1Et.setVisibility(View.VISIBLE);
//                    VitaminK1Unit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminK1Et.setVisibility(View.GONE);
//                    VitaminK1Unit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminCSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminCEt.setVisibility(View.VISIBLE);
//                    VitaminCUnit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminCEt.setVisibility(View.GONE);
//                    VitaminCUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminB1Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminB1Et.setVisibility(View.VISIBLE);
//                    VitaminB1Unit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminB1Et.setVisibility(View.GONE);
//                    VitaminB1Unit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminB2Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminB2Et.setVisibility(View.VISIBLE);
//                    VitaminB2Unit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminB2Et.setVisibility(View.GONE);
//                    VitaminB2Unit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminB6Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminB6Et.setVisibility(View.VISIBLE);
//                    VitaminB6Unit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminB6Et.setVisibility(View.GONE);
//                    VitaminB6Unit.setVisibility(View.GONE);
//                }
//            }
//        });
//        VitaminB12Switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    VitaminB12Et.setVisibility(View.VISIBLE);
//                    VitaminB12Unit.setVisibility(View.VISIBLE);
//                }else{
//                    VitaminB12Et.setVisibility(View.GONE);
//                    VitaminB12Unit.setVisibility(View.GONE);
//                }
//            }
//        });
//
//        NiacinSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    NiacinEt.setVisibility(View.VISIBLE);
//                    NiacinUnit.setVisibility(View.VISIBLE);
//                }else{
//                    NiacinEt.setVisibility(View.GONE);
//                    NiacinUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        NiacinEquivalentSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    NiacinEquivalentEt.setVisibility(View.VISIBLE);
//                    NiacinEquivalentUnit.setVisibility(View.VISIBLE);
//                }else{
//                    NiacinEquivalentEt.setVisibility(View.GONE);
//                    NiacinEquivalentUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        FolicAcidSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    FolicAcidEt.setVisibility(View.VISIBLE);
//                    FolicAcidUnit.setVisibility(View.VISIBLE);
//                }else{
//                    FolicAcidEt.setVisibility(View.GONE);
//                    FolicAcidUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        BiotinSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    BiotinEt.setVisibility(View.VISIBLE);
//                    BiotinUnit.setVisibility(View.VISIBLE);
//                }else{
//                    BiotinEt.setVisibility(View.GONE);
//                    BiotinUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        PantothenicAcidSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    PantothenicAcidEt.setVisibility(View.VISIBLE);
//                    PantothenicAcidUnit.setVisibility(View.VISIBLE);
//                }else{
//                    PantothenicAcidEt.setVisibility(View.GONE);
//                    PantothenicAcidUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        SodiumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    SodiumEt.setVisibility(View.VISIBLE);
//                    SodiumUnit.setVisibility(View.VISIBLE);
//                }else{
//                    SodiumEt.setVisibility(View.GONE);
//                    SodiumUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        PotassiumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    PotassiumEt.setVisibility(View.VISIBLE);
//                    PotassiumUnit.setVisibility(View.VISIBLE);
//                }else{
//                    PotassiumEt.setVisibility(View.GONE);
//                    PotassiumUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ChlorideSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ChlorideEt.setVisibility(View.VISIBLE);
//                    ChlorideUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ChlorideEt.setVisibility(View.GONE);
//                    ChlorideUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        CalciumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    CalciumEt.setVisibility(View.VISIBLE);
//                    CalciumUnit.setVisibility(View.VISIBLE);
//                }else{
//                    CalciumEt.setVisibility(View.GONE);
//                    CalciumUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        PhosphorusSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    PhosphorusEt.setVisibility(View.VISIBLE);
//                    PhosphorusUnit.setVisibility(View.VISIBLE);
//                }else{
//                    PhosphorusEt.setVisibility(View.GONE);
//                    PhosphorusUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        MagnesiumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    MagnesiumEt.setVisibility(View.VISIBLE);
//                    MagnesiumUnit.setVisibility(View.VISIBLE);
//                }else{
//                    MagnesiumEt.setVisibility(View.GONE);
//                    MagnesiumUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        IronSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    IronEt.setVisibility(View.VISIBLE);
//                    IronUnit.setVisibility(View.VISIBLE);
//                }else{
//                    IronEt.setVisibility(View.GONE);
//                    IronUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ZincSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ZincEt.setVisibility(View.VISIBLE);
//                    ZincUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ZincEt.setVisibility(View.GONE);
//                    ZincUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ManganeseSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ManganeseEt.setVisibility(View.VISIBLE);
//                    ManganeseUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ManganeseEt.setVisibility(View.GONE);
//                    ManganeseUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        CopperSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    CopperEt.setVisibility(View.VISIBLE);
//                    CopperUnit.setVisibility(View.VISIBLE);
//                }else{
//                    CopperEt.setVisibility(View.GONE);
//                    CopperUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        IodineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    IodineEt.setVisibility(View.VISIBLE);
//                    IodineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    IodineEt.setVisibility(View.GONE);
//                    IodineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        SeleniumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    SeleniumEt.setVisibility(View.VISIBLE);
//                    SeleniumUnit.setVisibility(View.VISIBLE);
//                }else{
//                    SeleniumEt.setVisibility(View.GONE);
//                    SeleniumUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ChromiumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ChromiumEt.setVisibility(View.VISIBLE);
//                    ChromiumUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ChromiumEt.setVisibility(View.GONE);
//                    ChromiumUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        MolybdenumSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    MolybdenumEt.setVisibility(View.VISIBLE);
//                    MolybdenumUnit.setVisibility(View.VISIBLE);
//                }else{
//                    MolybdenumEt.setVisibility(View.GONE);
//                    MolybdenumUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        WaterSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    WaterEt.setVisibility(View.VISIBLE);
//                    WaterUnit.setVisibility(View.VISIBLE);
//                }else{
//                    WaterEt.setVisibility(View.GONE);
//                    WaterUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        SaltSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    SaltEt.setVisibility(View.VISIBLE);
//                    SaltUnit.setVisibility(View.VISIBLE);
//                }else{
//                    SaltEt.setVisibility(View.GONE);
//                    SaltUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        IsoleucineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    IsoleucineEt.setVisibility(View.VISIBLE);
//                    IsoleucineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    IsoleucineEt.setVisibility(View.GONE);
//                    IsoleucineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        LeucineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    LeucineEt.setVisibility(View.VISIBLE);
//                    LeucineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    LeucineEt.setVisibility(View.GONE);
//                    LeucineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        LysineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    LysineEt.setVisibility(View.VISIBLE);
//                    LysineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    LysineEt.setVisibility(View.GONE);
//                    LysineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        MethionineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    MethionineEt.setVisibility(View.VISIBLE);
//                    MethionineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    MethionineEt.setVisibility(View.GONE);
//                    MethionineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        PhenylalanineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    PhenylalanineEt.setVisibility(View.VISIBLE);
//                    PhenylalanineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    PhenylalanineEt.setVisibility(View.GONE);
//                    PhenylalanineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ThreonineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ThreonineEt.setVisibility(View.VISIBLE);
//                    ThreonineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ThreonineEt.setVisibility(View.GONE);
//                    ThreonineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        TryptophanSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    TryptophanEt.setVisibility(View.VISIBLE);
//                    TryptophanUnit.setVisibility(View.VISIBLE);
//                }else{
//                    TryptophanEt.setVisibility(View.GONE);
//                    TryptophanUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ValineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ValineEt.setVisibility(View.VISIBLE);
//                    ValineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ValineEt.setVisibility(View.GONE);
//                    ValineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        HistidineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    HistidineEt.setVisibility(View.VISIBLE);
//                    HistidineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    HistidineEt.setVisibility(View.GONE);
//                    HistidineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        AlanineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    AlanineEt.setVisibility(View.VISIBLE);
//                    AlanineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    AlanineEt.setVisibility(View.GONE);
//                    AlanineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ArginineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ArginineEt.setVisibility(View.VISIBLE);
//                    ArginineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ArginineEt.setVisibility(View.GONE);
//                    ArginineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        AsparticAcidSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    AsparticAcidEt.setVisibility(View.VISIBLE);
//                    AsparticAcidUnit.setVisibility(View.VISIBLE);
//                }else{
//                    AsparticAcidEt.setVisibility(View.GONE);
//                    AsparticAcidUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        CysteineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    CysteineEt.setVisibility(View.VISIBLE);
//                    CysteineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    CysteineEt.setVisibility(View.GONE);
//                    CysteineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        GlutamicAcidSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    GlutamicAcidEt.setVisibility(View.VISIBLE);
//                    GlutamicAcidUnit.setVisibility(View.VISIBLE);
//                }else{
//                    GlutamicAcidEt.setVisibility(View.GONE);
//                    GlutamicAcidUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        GlycineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    GlycineEt.setVisibility(View.VISIBLE);
//                    GlycineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    GlycineEt.setVisibility(View.GONE);
//                    GlycineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        ProlineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    ProlineEt.setVisibility(View.VISIBLE);
//                    ProlineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    ProlineEt.setVisibility(View.GONE);
//                    ProlineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        SerineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    SerineEt.setVisibility(View.VISIBLE);
//                    SerineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    SerineEt.setVisibility(View.GONE);
//                    SerineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        TyrosineSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    TyrosineEt.setVisibility(View.VISIBLE);
//                    TyrosineUnit.setVisibility(View.VISIBLE);
//                }else{
//                    TyrosineEt.setVisibility(View.GONE);
//                    TyrosineUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        caHMBSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    caHMBEt.setVisibility(View.VISIBLE);
//                    caHMBUnit.setVisibility(View.VISIBLE);
//                }else{
//                    caHMBEt.setVisibility(View.GONE);
//                    caHMBUnit.setVisibility(View.GONE);
//                }
//            }
//        });
//        HMBSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    HMBEt.setVisibility(View.VISIBLE);
//                    HMBUnit.setVisibility(View.VISIBLE);
//                }else{
//                    HMBEt.setVisibility(View.GONE);
//                    HMBUnit.setVisibility(View.GONE);
//                }
//            }
//        });

        //        amountUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                amountUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//
//        });
//        amountType.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Amount.perAmount, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Amount.perAmount[which];
//                                //set picked category
//                                amountType.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//
//        });
//        EnergyUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                EnergyUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        ProteinUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ProteinUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        FatUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                FatUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        MUFAUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                MUFAUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        PUFAUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                PUFAUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        LinoleicAcidUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                LinoleicAcidUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        αlinolenicAcidUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                αlinolenicAcidUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        SFAUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                SFAUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        MCToilUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                MCToilUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        TransfattyAcidUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                TransfattyAcidUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        CholesterolUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                CholesterolUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        CarbohydrateUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                CarbohydrateUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        LactoseUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                LactoseUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        PolyolsUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                PolyolsUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        TotalsugarUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                TotalsugarUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        FiberUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                FiberUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        DietaryfiberUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                DietaryfiberUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        FOSUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                FOSUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        CholineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                CholineUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        TaurineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                TaurineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        LcarnitineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                LcarnitineUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        CarnitineUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                CarnitineUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminAUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminAUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminAPalmitateUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminAPalmitateUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminABcaroteneUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminABcaroteneUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminDUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminDUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminD3Unit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminD3Unit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminEUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminEUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminKUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminKUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminK1Unit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminK1Unit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminCUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminCUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminB1Unit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminB1Unit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminB2Unit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminB2Unit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminB6Unit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminB6Unit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        VitaminB12Unit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                VitaminB12Unit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        NiacinUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                NiacinUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        NiacinEquivalentUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                NiacinEquivalentUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        FolicAcidUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                FolicAcidUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        BiotinUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                BiotinUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        PantothenicAcidUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                PantothenicAcidUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        SodiumUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                SodiumUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        PotassiumUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                PotassiumUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        ChlorideUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ChlorideUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        CalciumUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                CalciumUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        PhosphorusUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                PhosphorusUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        MagnesiumUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                MagnesiumUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        IronUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                IronUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        ZincUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ZincUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        ManganeseUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ManganeseUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        CopperUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                CopperUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        IodineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                IodineUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        SeleniumUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                SeleniumUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        ChromiumUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ChromiumUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        MolybdenumUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                MolybdenumUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        WaterUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                WaterUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        SaltUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                SaltUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        IsoleucineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                IsoleucineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        LeucineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                LeucineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        LysineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                LysineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        MethionineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                MethionineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        PhenylalanineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                PhenylalanineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        ThreonineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ThreonineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        TryptophanUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                TryptophanUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        ValineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ValineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        HistidineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                HistidineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        AlanineUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                AlanineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        ArginineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ArginineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        AsparticAcidUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                AsparticAcidUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        CysteineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                CysteineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        GlutamicAcidUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                GlutamicAcidUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        GlycineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                GlycineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        ProlineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                ProlineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        SerineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                SerineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        TyrosineUnit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                TyrosineUnit.setText(unit);
//                            }
//                        })
//                        .show();            }
//        });
//        caHMBUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                caHMBUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });
//        HMBUnit .setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //dialog
//                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
//                builder.setTitle("Units")
//                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
//                            @Override
//                            public void onClick(DialogInterface dialog, int which) {
//                                //get picked category
//                                String unit = Units.nutrientUnits[which];
//                                //set picked category
//                                HMBUnit.setText(unit);
//                            }
//                        })
//                        .show();
//            }
//        });

    }

//    private void addProduct() {
//        //3. add data to db
//
//        progressDialog.setMessage("Adding product");
//        progressDialog.show();
//
//        String timestamp = ""+System.currentTimeMillis();
//
//        String productName,productDescription,productCategory,productSubCategory,productCompany,productIndications,productIngredients,productAvailability, productRetailPrice;
//        String productSpecial,productPackSize,productServingSize,productOtherInfo,productCalorie;
//        boolean specialAvailable,packSizeAvailable,servingSizeAvailable,otherInfoAvailable,calorieAvailable = false;
//
////        boolean amountAvailable, EnergyAvailable,
////                ProteinAvailable,
////                FatAvailable,
////                MUFAAvailable,
////                PUFAAvailable,
////                LinoleicAcidAvailable,
////                αlinolenicAcidAvailable,
////                SFAAvailable,
////                MCToilAvailable,
////                TransfattyAcidsAvailable,
////                CarbohydrateAvailable,
////                LactoseAvailable,
////                PolyolsAvailable ,
////                TotalsugarAvailable,
////                FiberAvailable,
////                DietaryfiberAvailable,
////                FOSAvailable,
////                CholineAvailable,
////                TaurineAvailable ,
////                LcarnitineAvailable ,
////                CarnitineAvailable,
////                VitaminAAvailable,
////                VitaminAPalmitateAvailable,
////                VitaminABcaroteneAvailable ,
////                VitaminDAvailable ,
////                VitaminD3Available,
////                VitaminEAvailable ,
////                VitaminKAvailable,
////                VitaminK1Available,
////                VitaminCAvailable ,
////                VitaminB1SAvailable,
////                VitaminB2Available ,
////                VitaminB6Available ,
////                VitaminB12Available ,
////                NiacinAvailable ,
////                NiacinEquivalentAvailable ,
////                FolicAcidAvailable ,
////                BiotinAvailable ,
////                PantothenicAcidAvailable ,
////                SodiumAvailable ,
////                PotassiumAvailable ,
////                ChlorideAvailable,
////                CalciumAvailableh ,
////                PhosphorusAvailable,
////                MagnesiumAvailable,
////                IronAvailable ,
////                ZincAvailable,
////                ManganeseAvailable,
////                CopperAvailable ,
////                IodineAvailable,
////                SeleniumAvailable,
////                ChromiumAvailable,
////                MolybdenumAvailable,
////                WaterAvailable ,
////                SaltAvailable,
////                IsoleucineAvailable,
////                LeucineAvailable ,
////                LysineAvailable,
////                MethionineAvailable ,
////                PhenylalanineAvailable,
////                ThreonineAvailable ,
////                TryptophanAvailable ,
////                ValineAvailable,
////                HistidinAvailable ,
////                AlanineAvailable,
////                ArginineAvailable ,
////                AsparticAcidAvailable,
////                CysteineAvailable ,
////                GlutamicAcidAvailable,
////                GlycineAvailable,
////                ProlineAvailable ,
////                SerineSAvailable ,
////                TyrosineAvailable,
////                caHMBAvailable ,
////                HMBAvailable = false;
////
////        String productAmountEt,productEnergyEt,
////                productProteinEt,
////                productFatEt,
////                productMUFAEt,
////                productPUFAEt,
////                productLinoleicAcidEt,
////                productαlinolenicAcidEt,
////                productSFAEt ,
////                productMCToilEt,
////                productTransfattyAcidsEt,
////                productCholesterolEt,
////                productCarbohydrateEt,
////                productLactoseEt,
////                productPolyolsEt,
////                productTotalsugarEt,
////                productFiberEt,
////                productDietaryfiberEt,
////                productFOSEt ,
////                productCholineEt,
////                productTaurineEt ,
////                productLcarnitineEt,
////                productCarnitineEt,
////                productVitaminAEt,
////                productVitaminAPalmitateEt,
////                productVitaminABcaroteneEt ,
////                productVitaminDEt,
////                productVitaminD3Et ,
////                productVitaminEEt,
////                productVitaminKEt,
////                productVitaminK1Et ,
////                productVitaminCEt ,
////                productVitaminB1Et,
////                productVitaminB2Et ,
////                productVitaminB6Et ,
////                productVitaminB12Et,
////                productNiacinEt ,
////                productNiacinEquivalentEt ,
////                productFolicAcidEt,
////                productBiotinEt,
////                productPantothenicAcidEt ,
////                productSodiumEt,
////                productPotassiumEt,
////                productChlorideEt,
////                productCalciumEt ,
////                productPhosphorusEt,
////                productMagnesiumEt ,
////                productIronEt ,
////                productZincEt ,
////                productManganeseEt,
////                productCopperEt,
////                productIodineEt ,
////                productSeleniumEt ,
////                productChromiumEt ,
////                productMolybdenumEt ,
////                productWaterEt ,
////                productSaltEt ,
////                productIsoleucineEt ,
////                productLeucineEt ,
////                productLysineEt,
////                productMethionineEt,
////                productPhenylalanineEt,
////                productThreonineEt ,
////                productTryptophanEt ,
////                productValineEt ,
////                productHistidineEt ,
////                productAlanineEt ,
////                productArginineEt,
////                productAsparticAcidEt,
////                productCysteineEt,
////                productGlutamicAcidEt ,
////                productGlycineEt ,
////                productProlineEt ,
////                productSerineEt ,
////                productTyrosineEt,
////                productcaHMBEt,
////                productHMBEt;
////
////        String
////                productAmountUnit,
////                productAmountType,
////                productEnergyUnit,
////                productProteinUnit ,
////                productFatUnit,
////                productMUFAUnit,
////                productPUFAUnit ,
////                productLinoleicAcidUnit,
////                productαlinolenicAcidUnit,
////                productSFAUnit,
////                productMCToilUnit,
////                productTransfattyAcidUnit,
////                productCholesterolUnit ,
////                productCarbohydrateUnit,
////                productLactoseUnit,
////                productPolyolsUnit,
////                productTotalsugarUnit ,
////                productFiberUnit,
////                productDietaryfiberUnit ,
////                productFOSUnit,
////                productCholineUnit ,
////                productTaurineUnit ,
////                productLcarnitineUnit,
////                productCarnitineUnit,
////                productVitaminAUnit,
////                productVitaminAPalmitateUnit,
////                productVitaminABcaroteneUnit ,
////                productVitaminDUnit,
////                productVitaminD3Unit ,
////                productVitaminEUnit ,
////                productVitaminKUnit ,
////                productVitaminK1Unit ,
////                productVitaminCUnit ,
////                productVitaminB1Unit,
////                productVitaminB2Unit,
////                productVitaminB6Unit ,
////                productVitaminB12Unit,
////                productNiacinUnit  ,
////                productNiacinEquivalentUnit  ,
////                productFolicAcidUnit ,
////                productBiotinUnit ,
////                productPantothenicAcidUnit,
////                productSodiumUnit,
////                productPotassiumUnit ,
////                productChlorideUnit ,
////                productCalciumUnit ,
////                productPhosphorusUnit ,
////                productMagnesiumUnit,
////                productIronUnit ,
////                productZincUnit  ,
////                productManganeseUnit ,
////                productCopperUnit,
////                productIodineUnit ,
////                productSeleniumUnit,
////                productChromiumUnit ,
////                productMolybdenumUnit ,
////                productWaterUnit ,
////                productSaltUnit ,
////                productIsoleucineUnit ,
////                productLeucineUnit ,
////                productLysineUnit ,
////                productMethionineUnit ,
////                productPhenylalanineUnit ,
////                productThreonineUnit  ,
////                productTryptophanUnit ,
////                productValineUnit ,
////                productHistidineUnit ,
////                productAlanineUnit ,
////                productArginineUnit ,
////                productAsparticAcidUnit ,
////                productCysteineUnit ,
////                productGlutamicAcidUnit ,
////                productGlycineUnit  ,
////                productProlineUnit ,
////                productSerineUnit   ,
////                productTyrosineUnit ,
////                productcaHMBUnit,
////                productHMBUnit ;
//
//        productName = nameEt.getText().toString().trim();
//        productDescription = descriptionEt.getText().toString().trim();
//        productCategory = categoryEt.getText().toString().trim();
//        productSubCategory = subcategoryEt.getText().toString().trim();
//        productCompany = companyEt.getText().toString().trim();
//        productIndications = indicationsEt.getText().toString().trim();
//        productIngredients = ingredientsEt.getText().toString().trim();
//        productAvailability = availabilityEt.getText().toString().trim();
//        productRetailPrice = retailPriceEt.getText().toString().trim();
//
//        specialAvailable = specialSwitch.isChecked(); //true or false
//        packSizeAvailable = packSizeSwitch.isChecked(); //true or false
//        servingSizeAvailable = servingSizeSwitch.isChecked(); //true or false
//        otherInfoAvailable = otherInfoSwitch.isChecked(); //true or false
//        calorieAvailable = calorieSwitch.isChecked(); //true or false
////        amountAvailable = amountSwitch.isChecked();
////        EnergyAvailable  = EnergySwitch.isChecked();
////        ProteinAvailable = ProteinSwitch.isChecked();
////        FatAvailable = FatSwitch.isChecked();
////        MUFAAvailable = MUFASwitch.isChecked();
////        PUFAAvailable = PUFASwitch.isChecked();
////        LinoleicAcidAvailable = LinoleicAcidSwitch.isChecked();
////        αlinolenicAcidAvailable = αlinolenicAcidSwitch.isChecked();
////        SFAAvailable = SFASwitch.isChecked();
////        MCToilAvailable = MCToilSwitch.isChecked();
////        TransfattyAcidsAvailable = TransfattyAcidsSwitch.isChecked();
////        CarbohydrateAvailable = CarbohydrateSwitch.isChecked();
////        LactoseAvailable  = LactoseSwitch.isChecked();
////        PolyolsAvailable  = PolyolsSwitch.isChecked();
////        TotalsugarAvailable  = TotalsugarSwitch.isChecked();
////        FiberAvailable = FiberSwitch.isChecked();
////        DietaryfiberAvailable  = DietaryfiberSwitch.isChecked();
////        FOSAvailable = FOSSwitch.isChecked();
////        CholineAvailable  = CholineSwitch.isChecked();
////        TaurineAvailable = TaurineSwitch.isChecked();
////        LcarnitineAvailable  = LcarnitineSwitch.isChecked();
////        CarnitineAvailable  = CarnitineSwitch.isChecked();
////        VitaminAAvailable  = VitaminASwitch.isChecked();
////        VitaminAPalmitateAvailable = VitaminAPalmitateSwitch.isChecked();
////        VitaminABcaroteneAvailable = VitaminABcaroteneSwitch.isChecked();
////        VitaminDAvailable = VitaminDSwitch.isChecked();
////        VitaminD3Available = VitaminD3Switch.isChecked();
////        VitaminEAvailable  = VitaminESwitch.isChecked();
////        VitaminKAvailable = VitaminKSwitch.isChecked();
////        VitaminK1Available  = VitaminK1Switch.isChecked();
////        VitaminCAvailable  = VitaminCSwitch.isChecked();
////        VitaminB1SAvailable = VitaminB1Switch.isChecked();
////        VitaminB2Available  = VitaminB2Switch.isChecked();
////        VitaminB6Available  = VitaminB6Switch.isChecked();
////        VitaminB12Available  = VitaminB12Switch.isChecked();
////        NiacinAvailable  = NiacinSwitch.isChecked();
////        NiacinEquivalentAvailable = NiacinEquivalentSwitch.isChecked();
////        FolicAcidAvailable  = FolicAcidSwitch.isChecked();
////        BiotinAvailable  = BiotinSwitch.isChecked();
////        PantothenicAcidAvailable  = PantothenicAcidSwitch.isChecked();
////        SodiumAvailable  = SodiumSwitch.isChecked();
////        PotassiumAvailable   = PotassiumSwitch.isChecked();
////        ChlorideAvailable  = ChlorideSwitch.isChecked();
////        CalciumAvailableh  = CalciumSwitch.isChecked();
////        PhosphorusAvailable  = PhosphorusSwitch.isChecked();
////        MagnesiumAvailable  = MagnesiumSwitch.isChecked();
////        IronAvailable  = IronSwitch.isChecked();
////        ZincAvailable  = ZincSwitch.isChecked();
////        ManganeseAvailable  = ManganeseSwitch.isChecked();
////        CopperAvailable  = CopperSwitch.isChecked();
////        IodineAvailable   = IodineSwitch.isChecked();
////        SeleniumAvailable  = SeleniumSwitch.isChecked();
////        ChromiumAvailable  = ChromiumSwitch.isChecked();
////        MolybdenumAvailable  = MolybdenumSwitch.isChecked();
////        WaterAvailable  = WaterSwitch.isChecked();
////        SaltAvailable  = SaltSwitch.isChecked();
////        IsoleucineAvailable  = IsoleucineSwitch.isChecked();
////        LeucineAvailable  = LeucineSwitch.isChecked();
////        LysineAvailable  = LysineSwitch.isChecked();
////        MethionineAvailable  = MethionineSwitch.isChecked();
////        PhenylalanineAvailable  = PhenylalanineSwitch.isChecked();
////        ThreonineAvailable  = ThreonineSwitch.isChecked();
////        TryptophanAvailable   = TryptophanSwitch.isChecked();
////        ValineAvailable  = ValineSwitch.isChecked();
////        HistidinAvailable  = HistidineSwitch.isChecked();
////        AlanineAvailable = AlanineSwitch.isChecked();
////        ArginineAvailable  = ArginineSwitch.isChecked();
////        AsparticAcidAvailable = AsparticAcidSwitch.isChecked();
////        CysteineAvailable   = CysteineSwitch.isChecked();
////        GlutamicAcidAvailable  = GlutamicAcidSwitch.isChecked();
////        GlycineAvailable = GlycineSwitch.isChecked();
////        ProlineAvailable  = ProlineSwitch.isChecked();
////        SerineSAvailable   = SerineSwitch.isChecked();
////        TyrosineAvailable = TyrosineSwitch.isChecked();
////        caHMBAvailable  = caHMBSwitch.isChecked();
////        HMBAvailable = HMBSwitch.isChecked();
//
//        productSpecial = specialEt.getText().toString().trim();
//        productPackSize = packSizeEt.getText().toString().trim();
//        productServingSize = servingSizeEt.getText().toString().trim();
//        productOtherInfo = otherInfoEt.getText().toString().trim();
//        productCalorie = calorieEt.getText().toString().trim();
//
////        productAmountEt = amountEt.getText().toString().trim();
////        productEnergyEt = EnergyEt.getText().toString().trim();
////        productProteinEt = ProteinEt.getText().toString().trim();
////        productFatEt = FatEt.getText().toString().trim();
////        productMUFAEt = MUFAEt.getText().toString().trim();
////        productPUFAEt = PUFAEt.getText().toString().trim();
////        productLinoleicAcidEt = LinoleicAcidEt.getText().toString().trim();
////        productαlinolenicAcidEt = αlinolenicAcidEt.getText().toString().trim();
////        productSFAEt = SFAEt.getText().toString().trim();
////        productMCToilEt = MCToilEt.getText().toString().trim();
////        productTransfattyAcidsEt = TransfattyAcidsEt.getText().toString().trim();
////        productCholesterolEt = CholesterolEt.getText().toString().trim();
////        productCarbohydrateEt = CarbohydrateEt.getText().toString().trim();
////        productLactoseEt = LactoseEt.getText().toString().trim();
////        productPolyolsEt = PolyolsEt.getText().toString().trim();
////        productTotalsugarEt = TotalsugarEt.getText().toString().trim();
////        productFiberEt = FiberEt.getText().toString().trim();
////        productDietaryfiberEt = DietaryfiberEt.getText().toString().trim();
////        productFOSEt = FOSEt.getText().toString().trim();
////        productCholineEt = CholineEt.getText().toString().trim();
////        productTaurineEt = TaurineEt.getText().toString().trim();
////        productLcarnitineEt = LcarnitineEt.getText().toString().trim();
////        productCarnitineEt = CarnitineEt.getText().toString().trim();
////        productVitaminAEt = VitaminAEt.getText().toString().trim();
////        productVitaminAPalmitateEt = VitaminAPalmitateEt.getText().toString().trim();
////        productVitaminABcaroteneEt = VitaminABcaroteneEt.getText().toString().trim();
////        productVitaminDEt = VitaminDEt.getText().toString().trim();
////        productVitaminD3Et = VitaminD3Et.getText().toString().trim();
////        productVitaminEEt = VitaminEEt.getText().toString().trim();
////        productVitaminKEt = VitaminKEt.getText().toString().trim();
////        productVitaminK1Et = VitaminK1Et.getText().toString().trim();
////        productVitaminCEt = VitaminCEt.getText().toString().trim();
////        productVitaminB1Et = VitaminB1Et.getText().toString().trim();
////        productVitaminB2Et = VitaminB2Et.getText().toString().trim();
////        productVitaminB6Et = VitaminB6Et.getText().toString().trim();
////        productVitaminB12Et = VitaminB12Et.getText().toString().trim();
////        productNiacinEt = NiacinEt.getText().toString().trim();
////        productNiacinEquivalentEt = NiacinEquivalentEt.getText().toString().trim();
////        productFolicAcidEt = FolicAcidEt.getText().toString().trim();
////        productBiotinEt = BiotinEt.getText().toString().trim();
////        productPantothenicAcidEt = PantothenicAcidEt.getText().toString().trim();
////        productSodiumEt = SodiumEt.getText().toString().trim();
////        productPotassiumEt = PotassiumEt.getText().toString().trim();
////        productChlorideEt = ChlorideEt.getText().toString().trim();
////        productCalciumEt = CalciumEt.getText().toString().trim();
////        productPhosphorusEt = PhosphorusEt.getText().toString().trim();
////        productMagnesiumEt = MagnesiumEt.getText().toString().trim();
////        productIronEt = IronEt.getText().toString().trim();
////        productZincEt = ZincEt.getText().toString().trim();
////        productManganeseEt = ManganeseEt.getText().toString().trim();
////        productCopperEt = CopperEt.getText().toString().trim();
////        productIodineEt = IodineEt.getText().toString().trim();
////        productSeleniumEt = SeleniumEt.getText().toString().trim();
////        productChromiumEt = ChromiumEt.getText().toString().trim();
////        productMolybdenumEt = MolybdenumEt.getText().toString().trim();
////        productWaterEt = WaterEt.getText().toString().trim();
////        productSaltEt = SaltEt.getText().toString().trim();
////        productIsoleucineEt = IsoleucineEt.getText().toString().trim();
////        productLeucineEt = LeucineEt.getText().toString().trim();
////        productLysineEt = LysineEt.getText().toString().trim();
////        productMethionineEt = MethionineEt.getText().toString().trim();
////        productPhenylalanineEt = PhenylalanineEt.getText().toString().trim();
////        productThreonineEt = ThreonineEt.getText().toString().trim();
////        productTryptophanEt = TryptophanEt.getText().toString().trim();
////        productValineEt = ValineEt.getText().toString().trim();
////        productHistidineEt = HistidineEt.getText().toString().trim();
////        productAlanineEt = AlanineEt.getText().toString().trim();
////        productArginineEt = ArginineEt.getText().toString().trim();
////        productAsparticAcidEt = AsparticAcidEt.getText().toString().trim();
////        productCysteineEt = CysteineEt.getText().toString().trim();
////        productGlutamicAcidEt = GlutamicAcidEt.getText().toString().trim();
////        productGlycineEt = GlycineEt.getText().toString().trim();
////        productProlineEt = ProlineEt.getText().toString().trim();
////        productSerineEt = SerineEt.getText().toString().trim();
////        productTyrosineEt = TyrosineEt.getText().toString().trim();
////        productcaHMBEt = caHMBEt.getText().toString().trim();
////        productHMBEt = HMBEt.getText().toString().trim();
////
////        productAmountUnit = amountUnit.getText().toString().trim();
////        productAmountType = amountType.getText().toString().trim();
////        productEnergyUnit = EnergyUnit.getText().toString().trim();
////        productProteinUnit = ProteinUnit.getText().toString().trim();
////        productFatUnit = FatUnit.getText().toString().trim();
////        productMUFAUnit = MUFAUnit.getText().toString().trim();
////        productPUFAUnit = PUFAUnit.getText().toString().trim();
////        productLinoleicAcidUnit = LinoleicAcidUnit.getText().toString().trim();
////        productαlinolenicAcidUnit = αlinolenicAcidUnit.getText().toString().trim();
////        productSFAUnit = SFAUnit.getText().toString().trim();
////        productMCToilUnit  = MCToilUnit.getText().toString().trim();
////        productTransfattyAcidUnit  = TransfattyAcidUnit.getText().toString().trim();
////        productCholesterolUnit  = CholesterolUnit.getText().toString().trim();
////        productCarbohydrateUnit = CarbohydrateUnit.getText().toString().trim();
////        productLactoseUnit  = LactoseUnit.getText().toString().trim();
////        productPolyolsUnit = PolyolsUnit.getText().toString().trim();
////        productTotalsugarUnit = TotalsugarUnit.getText().toString().trim();
////        productFiberUnit  = FiberUnit.getText().toString().trim();
////        productDietaryfiberUnit  = DietaryfiberUnit.getText().toString().trim();
////        productFOSUnit  = FOSUnit.getText().toString().trim();
////        productCholineUnit = CholineUnit.getText().toString().trim();
////        productTaurineUnit = TaurineUnit.getText().toString().trim();
////        productLcarnitineUnit  = LcarnitineUnit.getText().toString().trim();
////        productCarnitineUnit  = CarnitineUnit.getText().toString().trim();
////        productVitaminAUnit  = VitaminAUnit.getText().toString().trim();
////        productVitaminAPalmitateUnit = VitaminAPalmitateUnit.getText().toString().trim();
////        productVitaminABcaroteneUnit  = VitaminABcaroteneUnit.getText().toString().trim();
////        productVitaminDUnit  = VitaminDUnit.getText().toString().trim();
////        productVitaminD3Unit  = VitaminD3Unit.getText().toString().trim();
////        productVitaminEUnit = VitaminEUnit.getText().toString().trim();
////        productVitaminKUnit  = VitaminKUnit.getText().toString().trim();
////        productVitaminK1Unit = VitaminK1Unit.getText().toString().trim();
////        productVitaminCUnit = VitaminCUnit.getText().toString().trim();
////        productVitaminB1Unit  = VitaminB1Unit.getText().toString().trim();
////        productVitaminB2Unit  = VitaminB2Unit.getText().toString().trim();
////        productVitaminB6Unit  = VitaminB6Unit.getText().toString().trim();
////        productVitaminB12Unit = VitaminB12Unit.getText().toString().trim();
////        productNiacinUnit  = NiacinUnit.getText().toString().trim();
////        productNiacinEquivalentUnit  = NiacinEquivalentUnit.getText().toString().trim();
////        productFolicAcidUnit  = FolicAcidUnit.getText().toString().trim();
////        productBiotinUnit  = BiotinUnit.getText().toString().trim();
////        productPantothenicAcidUnit  = PantothenicAcidUnit.getText().toString().trim();
////        productSodiumUnit  = SodiumUnit.getText().toString().trim();
////        productPotassiumUnit  = PotassiumUnit.getText().toString().trim();
////        productChlorideUnit  = ChlorideUnit.getText().toString().trim();
////        productCalciumUnit  = CalciumUnit.getText().toString().trim();
////        productPhosphorusUnit  = PhosphorusUnit.getText().toString().trim();
////        productMagnesiumUnit  = MagnesiumUnit.getText().toString().trim();
////        productIronUnit  = IronUnit.getText().toString().trim();
////        productZincUnit  = ZincUnit.getText().toString().trim();
////        productManganeseUnit  = ManganeseUnit.getText().toString().trim();
////        productCopperUnit  = CopperUnit.getText().toString().trim();
////        productIodineUnit  = IodineUnit.getText().toString().trim();
////        productSeleniumUnit  = SeleniumUnit.getText().toString().trim();
////        productChromiumUnit  = ChromiumUnit.getText().toString().trim();
////        productMolybdenumUnit = MolybdenumUnit.getText().toString().trim();
////        productWaterUnit  = WaterUnit.getText().toString().trim();
////        productSaltUnit  = SaltUnit.getText().toString().trim();
////        productIsoleucineUnit  = IsoleucineUnit.getText().toString().trim();
////        productLeucineUnit  = LeucineUnit.getText().toString().trim();
////        productLysineUnit  = LysineUnit.getText().toString().trim();
////        productMethionineUnit   = MethionineUnit.getText().toString().trim();
////        productPhenylalanineUnit   = PhenylalanineUnit.getText().toString().trim();
////        productThreonineUnit  = ThreonineUnit.getText().toString().trim();
////        productTryptophanUnit  = TryptophanUnit.getText().toString().trim();
////        productValineUnit  = ValineUnit.getText().toString().trim();
////        productHistidineUnit  = HistidineUnit.getText().toString().trim();
////        productAlanineUnit   = AlanineUnit.getText().toString().trim();
////        productArginineUnit  = ArginineUnit.getText().toString().trim();
////        productAsparticAcidUnit  = AsparticAcidUnit.getText().toString().trim();
////        productCysteineUnit  = CysteineUnit.getText().toString().trim();
////        productGlutamicAcidUnit  = GlutamicAcidUnit.getText().toString().trim();
////        productGlycineUnit  = GlycineUnit.getText().toString().trim();
////        productProlineUnit  = ProlineUnit.getText().toString().trim();
////        productSerineUnit   = SerineUnit.getText().toString().trim();
////        productTyrosineUnit  = TyrosineUnit.getText().toString().trim();
////        productcaHMBUnit  = caHMBUnit.getText().toString().trim();
////        productHMBUnit = HMBUnit.getText().toString().trim();
//
//        if(image_uri == null){
//            //upload without image
//            //setup data to save (replace cara kat user class)
//
//            HashMap<String,Object> hashMap = new HashMap<>();
//            hashMap.put("product Id", "" + timestamp);
//            hashMap.put("product Name", "" + productName);
//            hashMap.put("product Description", "" + productDescription);
//            hashMap.put("product Category", "" + productCategory);
//            hashMap.put("product SubCategory", "" + productSubCategory);
//            hashMap.put("product Icon", "");
//            hashMap.put("product Company", "" + productCompany);
//            hashMap.put("product Indications", "" + productIndications);
//            hashMap.put("product Ingredients", "" + productIngredients);
//            hashMap.put("product Availability", "" + productAvailability);
//            hashMap.put("product Retail Price", "" + productRetailPrice);
//            hashMap.put("product Special Feature", "" + productSpecial);
//            hashMap.put("product Pack Size", "" + productPackSize);
//            hashMap.put("product Serving Size", "" + productServingSize);
//            hashMap.put("product Other Info", "" + productOtherInfo);
//            hashMap.put("product Calorie", "" + productCalorie);
//
////            hashMap.put("product Amount", "" + productAmountEt + " " + productAmountUnit  + " " + productAmountType);
////            hashMap.put("product Energy", "" + productEnergyEt + " " + productEnergyUnit);
////            hashMap.put("product Protein", "" + productProteinEt + " " + productProteinUnit);
////            hashMap.put("product Fat", "" + productFatEt + " " + productFatUnit);
////            hashMap.put("product MUFA", "" + productMUFAEt + " " + productMUFAUnit);
////            hashMap.put("product PUFA", "" + productPUFAEt + " " + productPUFAUnit);
////            hashMap.put("product LinoleicAcid", "" + productLinoleicAcidEt + " " + productLinoleicAcidUnit);
////            hashMap.put("product αlinolenicAcid", "" + productαlinolenicAcidEt + " " + productαlinolenicAcidUnit);
////            hashMap.put("product SFA", "" + productSFAEt + " " + productSFAUnit);
////            hashMap.put("product MCToil", "" + productMCToilEt + " " + productMCToilUnit);
////            hashMap.put("product TransfattyAcids", "" + productTransfattyAcidsEt + " " + productTransfattyAcidUnit);
////            hashMap.put("product Cholesterol", "" + productCholesterolEt + " " + productCholesterolUnit);
////            hashMap.put("product Carbohydrate", "" + productCarbohydrateEt + " " + productEnergyUnit);
////            hashMap.put("product Lactose", "" + productLactoseEt + " " + productLactoseUnit);
////            hashMap.put("product Polyols", "" + productPolyolsEt + " " + productPolyolsUnit);
////            hashMap.put("product Totalsugar", "" + productTotalsugarEt + " " + productTotalsugarUnit);
////            hashMap.put("product Fiber", "" + productFiberEt + " " + productFiberUnit);
////            hashMap.put("product Dietaryfiber", "" + productDietaryfiberEt + " " + productDietaryfiberUnit);
////            hashMap.put("product FOS", "" + productFOSEt + " " + productFOSUnit);
////            hashMap.put("product Choline", "" + productCholineEt + " " + productCholineUnit);
////            hashMap.put("product Taurine", "" + productTaurineEt + " " + productTaurineUnit);
////            hashMap.put("product Lcarnitine", "" + productLcarnitineEt + " " + productLcarnitineUnit);
////            hashMap.put("product Carnitine", "" + productCarnitineEt + " " + productCarnitineUnit);
////            hashMap.put("product VitaminA", "" + productVitaminAEt + " " + productVitaminAUnit);
////            hashMap.put("product VitaminAPalmitate", "" + productVitaminAPalmitateEt + " " + productVitaminAPalmitateUnit);
////            hashMap.put("product VitaminABcarotene", "" + productVitaminABcaroteneEt + " " + productVitaminABcaroteneUnit);
////            hashMap.put("product VitaminD", "" + productVitaminDEt + " " + productVitaminDUnit);
////            hashMap.put("product VitaminD3", "" + productVitaminD3Et + " " + productVitaminD3Unit);
////            hashMap.put("product VitaminE", "" + productVitaminEEt + " " + productVitaminEUnit);
////            hashMap.put("product VitaminK", "" + productVitaminKEt + " " + productVitaminKUnit);
////            hashMap.put("product VitaminK1", "" + productVitaminK1Et + " " + productVitaminK1Unit);
////            hashMap.put("product VitaminC", "" + productVitaminCEt + " " + productVitaminCUnit);
////            hashMap.put("product VitaminB1", "" + productVitaminB1Et + " " + productVitaminB1Unit);
////            hashMap.put("product VitaminB2", "" + productVitaminB2Et + " " + productVitaminB2Unit);
////            hashMap.put("product VitaminB6", "" + productVitaminB6Et + " " + productVitaminB6Unit);
////            hashMap.put("product VitaminB12", "" + productVitaminB12Et + " " + productVitaminB12Unit);
////            hashMap.put("product Niacin", "" + productNiacinEt + " " + productNiacinUnit);
////            hashMap.put("product NiacinEquivalent", "" + productNiacinEquivalentEt + " " + productNiacinEquivalentUnit);
////            hashMap.put("product FolicAcid", "" + productFolicAcidEt + " " + productFolicAcidUnit);
////            hashMap.put("product Biotin", "" + productBiotinEt + " " + productBiotinUnit);
////            hashMap.put("product PantothenicAcid", "" + productPantothenicAcidEt + " " + productPantothenicAcidUnit);
////            hashMap.put("product Sodium", "" + productSodiumEt + " " + productSodiumUnit);
////            hashMap.put("product Potassium", "" + productPotassiumEt + " " + productPotassiumUnit);
////            hashMap.put("product Chloride", "" + productChlorideEt + " " + productChlorideUnit);
////            hashMap.put("product Calcium", "" + productCalciumEt + " " + productCalciumUnit);
////            hashMap.put("product Phosphorus", "" + productPhosphorusEt + " " + productPhosphorusUnit);
////            hashMap.put("product Magnesium", "" + productMagnesiumEt + " " + productMagnesiumUnit);
////            hashMap.put("product Iron", "" + productIronEt + " " + productIronUnit);
////            hashMap.put("product Zinc", "" + productZincEt + " " + productZincUnit);
////            hashMap.put("product Manganese", "" + productManganeseEt + " " + productManganeseUnit);
////            hashMap.put("product Copper", "" + productCopperEt + " " + productCopperUnit);
////            hashMap.put("product Iodine", "" + productIodineEt + " " + productIodineUnit);
////            hashMap.put("product Selenium", "" + productSeleniumEt + " " + productSeleniumUnit);
////            hashMap.put("product Chromium", "" + productChromiumEt + " " + productChromiumUnit);
////            hashMap.put("product Molybdenum", "" + productMolybdenumEt + " " + productMolybdenumUnit);
////            hashMap.put("product Water", "" + productWaterEt + " " + productWaterUnit);
////            hashMap.put("product Salt", "" + productSaltEt + " " + productSaltUnit);
////            hashMap.put("product Isoleucine", "" + productIsoleucineEt + " " + productIsoleucineUnit);
////            hashMap.put("product Leucine", "" + productLeucineEt + " " + productLeucineUnit);
////            hashMap.put("product Lysine", "" + productLysineEt + " " + productLysineUnit);
////            hashMap.put("product Methionine", "" + productMethionineEt + " " + productMethionineUnit);
////            hashMap.put("product Phenylalanine", "" + productPhenylalanineEt + " " + productPhenylalanineUnit);
////            hashMap.put("product Threonine", "" + productThreonineEt + " " + productThreonineUnit);
////            hashMap.put("product Tryptophan", "" + productTryptophanEt + " " + productTryptophanUnit);
////            hashMap.put("product Valine", "" + productValineEt + " " + productValineUnit);
////            hashMap.put("product Histidine", "" + productHistidineEt + " " + productHistidineUnit);
////            hashMap.put("product Alanine", "" + productAlanineEt + " " + productAlanineUnit);
////            hashMap.put("product Arginine", "" + productArginineEt + " " + productArginineUnit);
////            hashMap.put("product AsparticAcid", "" + productAsparticAcidEt + " " + productAsparticAcidUnit);
////            hashMap.put("product Cysteine", "" + productCysteineEt + " " + productCysteineUnit);
////            hashMap.put("product GlutamicAcid", "" + productGlutamicAcidEt + " " + productGlutamicAcidUnit);
////            hashMap.put("product Glycine", "" + productGlycineEt + " " + productGlycineUnit);
////            hashMap.put("product Proline", "" + productProlineEt + " " + productProlineUnit);
////            hashMap.put("product Serine", "" + productSerineEt + " " + productSerineUnit);
////            hashMap.put("product Tyrosine", "" + productTyrosineEt + " " + productTyrosineUnit);
////            hashMap.put("product caHMB", "" + productcaHMBEt + " " + productcaHMBUnit);
////            hashMap.put("product HMB", "" + productHMBEt + " " + productHMBUnit);
//
//            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
//            databaseReference.child(firebaseAuth.getUid()).child(timestamp).setValue(hashMap)
//                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                        @Override
//                        public void onSuccess(Void unused) {
//                            //added to db
//                            progressDialog.dismiss();
//                            Toast.makeText(AddProductActivity.this, "Product added...", Toast.LENGTH_SHORT).show();
//                            clearData();
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            progressDialog.dismiss();
//                            Toast.makeText(AddProductActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                        }
//                    });
//
//        }
//        else{
////
////            //upload with image
////            //setup data to save (replace cara kat user class)
////            //1st upload image to storage
////            //name and path of image to be uploaded
////
//            String filePathAndName  = "ProductImages/" + "" + timestamp;
//            StorageReference storageReference = FirebaseStorage.getInstance().getReference(filePathAndName);
//            storageReference.putFile(image_uri)
//                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                        @Override
//                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                            //success uploading image
//                            //get url of uploaded image
//                            Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
//                            while (!uriTask.isSuccessful());
//                            Uri downloadImageUri = uriTask.getResult();
//
//                            if(uriTask.isSuccessful()){
//                                //url of image received, upload to db
//
//                                HashMap<String,Object> hashMap = new HashMap<>();
//                                hashMap.put("product Id", "" + timestamp);
//                                hashMap.put("product Name", "" + productName);
//                                hashMap.put("product Description", "" + productDescription);
//                                hashMap.put("product Category", "" + productCategory);
//                                hashMap.put("product SubCategory", "" + productSubCategory);
//                                hashMap.put("product Icon", "" + downloadImageUri);
//                                hashMap.put("product Company", "" + productCompany);
//                                hashMap.put("product Indications", "" + productIndications);
//                                hashMap.put("product Ingredients", "" + productIngredients);
//                                hashMap.put("product Availability", "" + productAvailability);
//                                hashMap.put("product Retail Price", "" + productRetailPrice);
//                                hashMap.put("product Special Feature", "" + productSpecial);
//                                hashMap.put("product Pack Size", "" + productPackSize);
//                                hashMap.put("product Serving Size", "" + productServingSize);
//                                hashMap.put("product Other Info", "" + productOtherInfo);
//                                hashMap.put("product Calorie", "" + productCalorie);
////                                hashMap.put("product Amount", "" + productAmountEt + " " + productAmountUnit  + " " + productAmountType);
////                                hashMap.put("product Energy", "" + productEnergyEt + " " + productEnergyUnit);
////                                hashMap.put("product Protein", "" + productProteinEt + " " + productProteinUnit);
////                                hashMap.put("product Fat", "" + productFatEt + " " + productFatUnit);
////                                hashMap.put("product MUFA", "" + productMUFAEt + " " + productMUFAUnit);
////                                hashMap.put("product PUFA", "" + productPUFAEt + " " + productPUFAUnit);
////                                hashMap.put("product LinoleicAcid", "" + productLinoleicAcidEt + " " + productLinoleicAcidUnit);
////                                hashMap.put("product αlinolenicAcid", "" + productαlinolenicAcidEt + " " + productαlinolenicAcidUnit);
////                                hashMap.put("product SFA", "" + productSFAEt + " " + productSFAUnit);
////                                hashMap.put("product MCToil", "" + productMCToilEt + " " + productMCToilUnit);
////                                hashMap.put("product TransfattyAcids", "" + productTransfattyAcidsEt + " " + productTransfattyAcidUnit);
////                                hashMap.put("product Cholesterol", "" + productCholesterolEt + " " + productCholesterolUnit);
////                                hashMap.put("product Carbohydrate", "" + productCarbohydrateEt + " " + productEnergyUnit);
////                                hashMap.put("product Lactose", "" + productLactoseEt + " " + productLactoseUnit);
////                                hashMap.put("product Polyols", "" + productPolyolsEt + " " + productPolyolsUnit);
////                                hashMap.put("product Totalsugar", "" + productTotalsugarEt + " " + productTotalsugarUnit);
////                                hashMap.put("product Fiber", "" + productFiberEt + " " + productFiberUnit);
////                                hashMap.put("product Dietaryfiber", "" + productDietaryfiberEt + " " + productDietaryfiberUnit);
////                                hashMap.put("product FOS", "" + productFOSEt + " " + productFOSUnit);
////                                hashMap.put("product Choline", "" + productCholineEt + " " + productCholineUnit);
////                                hashMap.put("product Taurine", "" + productTaurineEt + " " + productTaurineUnit);
////                                hashMap.put("product Lcarnitine", "" + productLcarnitineEt + " " + productLcarnitineUnit);
////                                hashMap.put("product Carnitine", "" + productCarnitineEt + " " + productCarnitineUnit);
////                                hashMap.put("product VitaminA", "" + productVitaminAEt + " " + productVitaminAUnit);
////                                hashMap.put("product VitaminAPalmitate", "" + productVitaminAPalmitateEt + " " + productVitaminAPalmitateUnit);
////                                hashMap.put("product VitaminABcarotene", "" + productVitaminABcaroteneEt + " " + productVitaminABcaroteneUnit);
////                                hashMap.put("product VitaminD", "" + productVitaminDEt + " " + productVitaminDUnit);
////                                hashMap.put("product VitaminD3", "" + productVitaminD3Et + " " + productVitaminD3Unit);
////                                hashMap.put("product VitaminE", "" + productVitaminEEt + " " + productVitaminEUnit);
////                                hashMap.put("product VitaminK", "" + productVitaminKEt + " " + productVitaminKUnit);
////                                hashMap.put("product VitaminK1", "" + productVitaminK1Et + " " + productVitaminK1Unit);
////                                hashMap.put("product VitaminC", "" + productVitaminCEt + " " + productVitaminCUnit);
////                                hashMap.put("product VitaminB1", "" + productVitaminB1Et + " " + productVitaminB1Unit);
////                                hashMap.put("product VitaminB2", "" + productVitaminB2Et + " " + productVitaminB2Unit);
////                                hashMap.put("product VitaminB6", "" + productVitaminB6Et + " " + productVitaminB6Unit);
////                                hashMap.put("product VitaminB12", "" + productVitaminB12Et + " " + productVitaminB12Unit);
////                                hashMap.put("product Niacin", "" + productNiacinEt + " " + productNiacinUnit);
////                                hashMap.put("product NiacinEquivalent", "" + productNiacinEquivalentEt + " " + productNiacinEquivalentUnit);
////                                hashMap.put("product FolicAcid", "" + productFolicAcidEt + " " + productFolicAcidUnit);
////                                hashMap.put("product Biotin", "" + productBiotinEt + " " + productBiotinUnit);
////                                hashMap.put("product PantothenicAcid", "" + productPantothenicAcidEt + " " + productPantothenicAcidUnit);
////                                hashMap.put("product Sodium", "" + productSodiumEt + " " + productSodiumUnit);
////                                hashMap.put("product Potassium", "" + productPotassiumEt + " " + productPotassiumUnit);
////                                hashMap.put("product Chloride", "" + productChlorideEt + " " + productChlorideUnit);
////                                hashMap.put("product Calcium", "" + productCalciumEt + " " + productCalciumUnit);
////                                hashMap.put("product Phosphorus", "" + productPhosphorusEt + " " + productPhosphorusUnit);
////                                hashMap.put("product Magnesium", "" + productMagnesiumEt + " " + productMagnesiumUnit);
////                                hashMap.put("product Iron", "" + productIronEt + " " + productIronUnit);
////                                hashMap.put("product Zinc", "" + productZincEt + " " + productZincUnit);
////                                hashMap.put("product Manganese", "" + productManganeseEt + " " + productManganeseUnit);
////                                hashMap.put("product Copper", "" + productCopperEt + " " + productCopperUnit);
////                                hashMap.put("product Iodine", "" + productIodineEt + " " + productIodineUnit);
////                                hashMap.put("product Selenium", "" + productSeleniumEt + " " + productSeleniumUnit);
////                                hashMap.put("product Chromium", "" + productChromiumEt + " " + productChromiumUnit);
////                                hashMap.put("product Molybdenum", "" + productMolybdenumEt + " " + productMolybdenumUnit);
////                                hashMap.put("product Water", "" + productWaterEt + " " + productWaterUnit);
////                                hashMap.put("product Salt", "" + productSaltEt + " " + productSaltUnit);
////                                hashMap.put("product Isoleucine", "" + productIsoleucineEt + " " + productIsoleucineUnit);
////                                hashMap.put("product Leucine", "" + productLeucineEt + " " + productLeucineUnit);
////                                hashMap.put("product Lysine", "" + productLysineEt + " " + productLysineUnit);
////                                hashMap.put("product Methionine", "" + productMethionineEt + " " + productMethionineUnit);
////                                hashMap.put("product Phenylalanine", "" + productPhenylalanineEt + " " + productPhenylalanineUnit);
////                                hashMap.put("product Threonine", "" + productThreonineEt + " " + productThreonineUnit);
////                                hashMap.put("product Tryptophan", "" + productTryptophanEt + " " + productTryptophanUnit);
////                                hashMap.put("product Valine", "" + productValineEt + " " + productValineUnit);
////                                hashMap.put("product Histidine", "" + productHistidineEt + " " + productHistidineUnit);
////                                hashMap.put("product Alanine", "" + productAlanineEt + " " + productAlanineUnit);
////                                hashMap.put("product Arginine", "" + productArginineEt + " " + productArginineUnit);
////                                hashMap.put("product AsparticAcid", "" + productAsparticAcidEt + " " + productAsparticAcidUnit);
////                                hashMap.put("product Cysteine", "" + productCysteineEt + " " + productCysteineUnit);
////                                hashMap.put("product GlutamicAcid", "" + productGlutamicAcidEt + " " + productGlutamicAcidUnit);
////                                hashMap.put("product Glycine", "" + productGlycineEt + " " + productGlycineUnit);
////                                hashMap.put("product Proline", "" + productProlineEt + " " + productProlineUnit);
////                                hashMap.put("product Serine", "" + productSerineEt + " " + productSerineUnit);
////                                hashMap.put("product Tyrosine", "" + productTyrosineEt + " " + productTyrosineUnit);
////                                hashMap.put("product caHMB", "" + productcaHMBEt + " " + productcaHMBUnit);
////                                hashMap.put("product HMB", "" + productHMBEt + " " + productHMBUnit);
//
////                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Products Info");
////                                databaseReference.child(firebaseAuth.getUid()).child(timestamp).setValue(hashMap)
//
//                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
//                                databaseReference.child(firebaseAuth.getUid()).child("Products").child(timestamp).setValue(hashMap)
//                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                            @Override
//                                            public void onSuccess(Void unused) {
//                                                //added to db
//                                                progressDialog.dismiss();
//                                                Toast.makeText(AddProductActivity.this, "Product added...", Toast.LENGTH_SHORT).show();
//                                                clearData();
//                                            }
//                                        })
//                                        .addOnFailureListener(new OnFailureListener() {
//                                            @Override
//                                            public void onFailure(@NonNull Exception e) {
//                                                progressDialog.dismiss();
//                                                Toast.makeText(AddProductActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
//                                            }
//                                        });
//                            }
//                        }
//                    })
//                    .addOnFailureListener(new OnFailureListener() {
//                        @Override
//                        public void onFailure(@NonNull Exception e) {
//                            //failed uploading image
//                            progressDialog.dismiss();
//                            Toast.makeText(AddProductActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                        }
//                    });
//        }
//
//    }
//
//    private void clearData() {
//        //clear data after uploading product
//        nameEt.setText("");
//        descriptionEt.setText("");
//        categoryEt.setText("");
//        productIconIv.setImageResource(R.drawable.add_photo);
//        image_uri = null;
//
//        companyEt.setText("");
//        indicationsEt.setText("");
//        ingredientsEt.setText("");
//        availabilityEt.setText("");
//        retailPriceEt.setText("");
//
//        subcategoryEt.setText("");
//        specialEt.setText("");
//        packSizeEt.setText("");
//        servingSizeEt.setText("");
//        otherInfoEt.setText("");
//        calorieEt.setText("");
////        amountEt.setText("");
////        amountType.setText("");
////        EnergyEt.setText("");
////        ProteinEt.setText("");
////        FatEt.setText("");
////        MUFAEt.setText("");
////        PUFAEt.setText("");
////        LinoleicAcidEt.setText("");
////        αlinolenicAcidEt.setText("");
////        SFAEt.setText("");
////        MCToilEt.setText("");
////        TransfattyAcidsEt.setText("");
////        CholesterolEt.setText("");
////        CarbohydrateEt.setText("");
////        LactoseEt.setText("");
////        PolyolsEt.setText("");
////        TotalsugarEt.setText("");
////        FiberEt.setText("");
////        DietaryfiberEt.setText("");
////        FOSEt.setText("");
////        CholineEt.setText("");
////        TaurineEt.setText("");
////        LcarnitineEt.setText("");
////        CarnitineEt.setText("");
////        VitaminAEt.setText("");
////        VitaminAPalmitateEt.setText("");
////        VitaminABcaroteneEt.setText("");
////        VitaminDEt.setText("");
////        VitaminD3Et.setText("");
////        VitaminEEt.setText("");
////        VitaminKEt.setText("");
////        VitaminK1Et .setText("");
////        VitaminCEt.setText("");
////        VitaminB1Et.setText("");
////        VitaminB2Et.setText("");
////        VitaminB6Et .setText("");
////        VitaminB12Et.setText("");
////        NiacinEt.setText("");
////        NiacinEquivalentEt.setText("");
////        FolicAcidEt.setText("");
////        BiotinEt.setText("");
////        PantothenicAcidEt.setText("");
////        SodiumEt.setText("");
////        PotassiumEt.setText("");
////        ChlorideEt.setText("");
////        CalciumEt.setText("");
////        PhosphorusEt.setText("");
////        MagnesiumEt.setText("");
////        IronEt.setText("");
////        ZincEt.setText("");
////        ManganeseEt.setText("");
////        CopperEt.setText("");
////        IodineEt.setText("");
////        SeleniumEt.setText("");
////        ChromiumEt.setText("");
////        MolybdenumEt.setText("");
////        WaterEt.setText("");
////        SaltEt.setText("");
////        IsoleucineEt.setText("");
////        LeucineEt.setText("");
////        LysineEt.setText("");
////        MethionineEt.setText("");
////        PhenylalanineEt.setText("");
////        ThreonineEt.setText("");
////        TryptophanEt .setText("");
////        ValineEt.setText("");
////        HistidineEt.setText("");
////        AlanineEt.setText("");
////        ArginineEt.setText("");
////        AsparticAcidEt.setText("");
////        CysteineEt.setText("");
////        GlutamicAcidEt.setText("");
////        GlycineEt.setText("");
////        ProlineEt.setText("");
////        SerineEt.setText("");
////        TyrosineEt.setText("");
////        caHMBEt .setText("");
////        HMBEt.setText("");
//
//
//        specialEt.setVisibility(View.GONE);
//        packSizeEt.setVisibility(View.GONE);
//        servingSizeEt.setVisibility(View.GONE);
//        otherInfoEt.setVisibility(View.GONE);
//        calorieEt.setVisibility(View.GONE);
////        amountEt.setVisibility(View.GONE);
////        amountType.setVisibility(View.GONE);
////        EnergyEt.setVisibility(View.GONE);
////        ProteinEt.setVisibility(View.GONE);
////        FatEt.setVisibility(View.GONE);
////        MUFAEt.setVisibility(View.GONE);
////        PUFAEt.setVisibility(View.GONE);
////        LinoleicAcidEt.setVisibility(View.GONE);
////        αlinolenicAcidEt.setVisibility(View.GONE);
////        SFAEt.setVisibility(View.GONE);
////        MCToilEt.setVisibility(View.GONE);
////        TransfattyAcidsEt.setVisibility(View.GONE);
////        CholesterolEt.setVisibility(View.GONE);
////        CarbohydrateEt .setVisibility(View.GONE);
////        LactoseEt.setVisibility(View.GONE);
////        PolyolsEt.setVisibility(View.GONE);
////        TotalsugarEt .setVisibility(View.GONE);
////        FiberEt.setVisibility(View.GONE);
////        DietaryfiberEt.setVisibility(View.GONE);
////        FOSEt.setVisibility(View.GONE);
////        CholineEt .setVisibility(View.GONE);
////        TaurineEt.setVisibility(View.GONE);
////        LcarnitineEt.setVisibility(View.GONE);
////        CarnitineEt.setVisibility(View.GONE);
////        VitaminAEt.setVisibility(View.GONE);
////        VitaminAPalmitateEt.setVisibility(View.GONE);
////        VitaminABcaroteneEt .setVisibility(View.GONE);
////        VitaminDEt.setVisibility(View.GONE);
////        VitaminD3Et.setVisibility(View.GONE);
////        VitaminEEt.setVisibility(View.GONE);
////        VitaminKEt .setVisibility(View.GONE);
////        VitaminK1Et .setVisibility(View.GONE);
////        VitaminCEt.setVisibility(View.GONE);
////        VitaminB1Et.setVisibility(View.GONE);
////        VitaminB2Et.setVisibility(View.GONE);
////        VitaminB6Et .setVisibility(View.GONE);
////        VitaminB12Et.setVisibility(View.GONE);
////        NiacinEt.setVisibility(View.GONE);
////        NiacinEquivalentEt.setVisibility(View.GONE);
////        FolicAcidEt.setVisibility(View.GONE);
////        BiotinEt.setVisibility(View.GONE);
////        PantothenicAcidEt.setVisibility(View.GONE);
////        SodiumEt.setVisibility(View.GONE);
////        PotassiumEt.setVisibility(View.GONE);
////        ChlorideEt.setVisibility(View.GONE);
////        CalciumEt.setVisibility(View.GONE);
////        PhosphorusEt.setVisibility(View.GONE);
////        MagnesiumEt.setVisibility(View.GONE);
////        IronEt .setVisibility(View.GONE);
////        ZincEt.setVisibility(View.GONE);
////        ManganeseEt.setVisibility(View.GONE);
////        CopperEt .setVisibility(View.GONE);
////        IodineEt .setVisibility(View.GONE);
////        SeleniumEt.setVisibility(View.GONE);
////        ChromiumEt.setVisibility(View.GONE);
////        MolybdenumEt .setVisibility(View.GONE);
////        WaterEt.setVisibility(View.GONE);
////        SaltEt .setVisibility(View.GONE);
////        IsoleucineEt .setVisibility(View.GONE);
////        LeucineEt.setVisibility(View.GONE);
////        LysineEt .setVisibility(View.GONE);
////        MethionineEt.setVisibility(View.GONE);
////        PhenylalanineEt.setVisibility(View.GONE);
////        ThreonineEt.setVisibility(View.GONE);
////        TryptophanEt .setVisibility(View.GONE);
////        ValineEt .setVisibility(View.GONE);
////        HistidineEt .setVisibility(View.GONE);
////        AlanineEt .setVisibility(View.GONE);
////        ArginineEt .setVisibility(View.GONE);
////        AsparticAcidEt .setVisibility(View.GONE);
////        CysteineEt.setVisibility(View.GONE);
////        GlutamicAcidEt.setVisibility(View.GONE);
////        GlycineEt .setVisibility(View.GONE);
////        ProlineEt.setVisibility(View.GONE);
////        SerineEt .setVisibility(View.GONE);
////        TyrosineEt.setVisibility(View.GONE);
////        caHMBEt .setVisibility(View.GONE);
////        HMBEt .setVisibility(View.GONE);
////
////        amountUnit.setText("");
////        amountType.setText("");
////        EnergyUnit.setText("");
////        ProteinUnit.setText("");
////        FatUnit.setText("");
////        MUFAUnit.setText("");
////        PUFAUnit.setText("");
////        LinoleicAcidUnit.setText("");
////        αlinolenicAcidUnit.setText("");
////        SFAUnit.setText("");
////        MCToilUnit.setText("");
////        TransfattyAcidUnit.setText("");
////        CholesterolUnit.setText("");
////        CarbohydrateUnit.setText("");
////        LactoseUnit.setText("");
////        PolyolsUnit.setText("");
////        TotalsugarUnit.setText("");
////        FiberUnit.setText("");
////        DietaryfiberUnit.setText("");
////        FOSUnit.setText("");
////        CholineUnit.setText("");
////        TaurineUnit .setText("");
////        LcarnitineUnit.setText("");
////        CarnitineUnit.setText("");
////        VitaminAUnit.setText("");
////        VitaminAPalmitateUnit.setText("");
////        VitaminABcaroteneUnit.setText("");
////        VitaminDUnit.setText("");
////        VitaminD3Unit.setText("");
////        VitaminEUnit.setText("");
////        VitaminKUnit.setText("");
////        VitaminK1Unit.setText("");
////        VitaminCUnit.setText("");
////        VitaminB1Unit.setText("");
////        VitaminB2Unit.setText("");
////        VitaminB6Unit.setText("");
////        VitaminB12Unit.setText("");
////        NiacinUnit.setText("");
////        NiacinEquivalentUnit.setText("");
////        FolicAcidUnit.setText("");
////        BiotinUnit.setText("");
////        PantothenicAcidUnit.setText("");
////        SodiumUnit.setText("");
////        PotassiumUnit.setText("");
////        ChlorideUnit.setText("");
////        CalciumUnit.setText("");
////        PhosphorusUnit.setText("");
////        MagnesiumUnit.setText("");
////        IronUnit.setText("");
////        ZincUnit.setText("");
////        ManganeseUnit.setText("");
////        CopperUnit.setText("");
////        IodineUnit.setText("");
////        SeleniumUnit.setText("");
////        ChromiumUnit.setText("");
////        MolybdenumUnit.setText("");
////        WaterUnit.setText("");
////        SaltUnit.setText("");
////        IsoleucineUnit.setText("");
////        LeucineUnit.setText("");
////        LysineUnit.setText("");
////        MethionineUnit .setText("");
////        PhenylalanineUnit.setText("");
////        ThreonineUnit.setText("");
////        TryptophanUnit .setText("");
////        ValineUnit.setText("");
////        HistidineUnit.setText("");
////        AlanineUnit.setText("");
////        ArginineUnit .setText("");
////        AsparticAcidUnit.setText("");
////        CysteineUnit.setText("");
////        GlutamicAcidUnit.setText("");
////        GlycineUnit .setText("");
////        ProlineUnit.setText("");
////        SerineUnit .setText("");
////        TyrosineUnit .setText("");
////        caHMBUnit .setText("");
////        HMBUnit .setText("");
////
////        amountUnit.setVisibility(View.GONE);
////        amountType.setVisibility(View.GONE);
////        EnergyUnit.setVisibility(View.GONE);
////        ProteinUnit .setVisibility(View.GONE);
////        FatUnit .setVisibility(View.GONE);
////        MUFAUnit.setVisibility(View.GONE);
////        PUFAUnit.setVisibility(View.GONE);
////        LinoleicAcidUnit.setVisibility(View.GONE);
////        αlinolenicAcidUnit .setVisibility(View.GONE);
////        SFAUnit.setVisibility(View.GONE);
////        MCToilUnit .setVisibility(View.GONE);
////        TransfattyAcidUnit .setVisibility(View.GONE);
////        CholesterolUnit.setVisibility(View.GONE);
////        CarbohydrateUnit .setVisibility(View.GONE);
////        LactoseUnit .setVisibility(View.GONE);
////        PolyolsUnit .setVisibility(View.GONE);
////        TotalsugarUnit .setVisibility(View.GONE);
////        FiberUnit .setVisibility(View.GONE);
////        DietaryfiberUnit .setVisibility(View.GONE);
////        FOSUnit .setVisibility(View.GONE);
////        CholineUnit .setVisibility(View.GONE);
////        TaurineUnit .setVisibility(View.GONE);
////        LcarnitineUnit.setVisibility(View.GONE);
////        CarnitineUnit .setVisibility(View.GONE);
////        VitaminAUnit .setVisibility(View.GONE);
////        VitaminAPalmitateUnit.setVisibility(View.GONE);
////        VitaminABcaroteneUnit .setVisibility(View.GONE);
////        VitaminDUnit .setVisibility(View.GONE);
////        VitaminD3Unit.setVisibility(View.GONE);
////        VitaminEUnit.setVisibility(View.GONE);
////        VitaminKUnit.setVisibility(View.GONE);
////        VitaminK1Unit.setVisibility(View.GONE);
////        VitaminCUnit.setVisibility(View.GONE);
////        VitaminB1Unit.setVisibility(View.GONE);
////        VitaminB2Unit.setVisibility(View.GONE);
////        VitaminB6Unit .setVisibility(View.GONE);
////        VitaminB12Unit .setVisibility(View.GONE);
////        NiacinUnit.setVisibility(View.GONE);
////        NiacinEquivalentUnit.setVisibility(View.GONE);
////        FolicAcidUnit.setVisibility(View.GONE);
////        BiotinUnit.setVisibility(View.GONE);
////        PantothenicAcidUnit.setVisibility(View.GONE);
////        SodiumUnit.setVisibility(View.GONE);
////        PotassiumUnit.setVisibility(View.GONE);
////        ChlorideUnit.setVisibility(View.GONE);
////        CalciumUnit.setVisibility(View.GONE);
////        PhosphorusUnit.setVisibility(View.GONE);
////        MagnesiumUnit.setVisibility(View.GONE);
////        IronUnit.setVisibility(View.GONE);
////        ZincUnit .setVisibility(View.GONE);
////        ManganeseUnit .setVisibility(View.GONE);
////        CopperUnit.setVisibility(View.GONE);
////        IodineUnit.setVisibility(View.GONE);
////        SeleniumUnit .setVisibility(View.GONE);
////        ChromiumUnit .setVisibility(View.GONE);
////        MolybdenumUnit .setVisibility(View.GONE);
////        WaterUnit.setVisibility(View.GONE);
////        SaltUnit.setVisibility(View.GONE);
////        IsoleucineUnit .setVisibility(View.GONE);
////        LeucineUnit.setVisibility(View.GONE);
////        LysineUnit .setVisibility(View.GONE);
////        MethionineUnit .setVisibility(View.GONE);
////        PhenylalanineUnit .setVisibility(View.GONE);
////        ThreonineUnit.setVisibility(View.GONE);
////        TryptophanUnit .setVisibility(View.GONE);
////        ValineUnit .setVisibility(View.GONE);
////        HistidineUnit .setVisibility(View.GONE);
////        AlanineUnit .setVisibility(View.GONE);
////        ArginineUnit .setVisibility(View.GONE);
////        AsparticAcidUnit .setVisibility(View.GONE);
////        CysteineUnit .setVisibility(View.GONE);
////        GlutamicAcidUnit.setVisibility(View.GONE);
////        GlycineUnit .setVisibility(View.GONE);
////        ProlineUnit.setVisibility(View.GONE);
////        SerineUnit .setVisibility(View.GONE);
////        TyrosineUnit .setVisibility(View.GONE);
////        caHMBUnit .setVisibility(View.GONE);
////        HMBUnit  .setVisibility(View.GONE);
//
//    }

    @Override
    public void onBackPressed() {
        Intent i = new Intent(AddProductNutrientActivity.this, AddProductActivity.class);
        startActivity(i);
        finish();
    }
}