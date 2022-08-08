package com.example.milc;

import android.Manifest;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.HashMap;

public class ProductEditActivity extends AppCompatActivity {

    String productId;
    ImageView productIconIv;
    ScrollView scrollView;
    FloatingActionButton scrollUp,scrollDown;
    EditText nameEt,companyEt,descriptionEt,indicationsEt,ingredientsEt,availabilityEt,retailPriceEt;
    EditText specialEt,packSizeEt,servingSizeEt,otherInfoEt,calorieEt,storageEt,uploadPDFNameEt;
    SwitchCompat specialSwitch,packSizeSwitch,servingSizeSwitch,otherInfoSwitch,calorieSwitch,storageSwitch,uploadPDFSwitch;
    Button updateProductBtn;

    TextView AmountType;
    TextView AmountUnit,EnergyUnit,ProteinUnit;
    TextView FatUnit,MUFAUnit,PUFAUnit,LinoleicUnit,LinoAcidUnit,EPAUnit,DHAUnit,SFAUnit,MCToilUnit,TransUnit;
    TextView CholesterolUnit,CarbohydrateUnit,SaltUnit,LactoseUnit,PolyolsUnit,FiberUnit,FOSUnit,DietaryFiberUnit,SolubleFiberUnit,SugarUnit;
    TextView EssentialAminoAcidsUnit,BranchedChainAminoAcidsUnit,InulinUnit,CholineUnit,TaurineUnit,CarnitineUnit,LCarnitineUnit,CaHMBUnit,HMBUnit,InositolUnit;

    TextView VitaminAUnit,VitaminA1Unit,VitaminA2Unit,VitaminDUnit,VitaminD3Unit,VitaminEUnit,VitaminKUnit,VitaminK1Unit,VitaminCUnit,VitaminB1Unit;
    TextView VitaminB2Unit,VitaminB6Unit,VitaminB12Unit,NiacinUnit,NiacinEquivalentUnit,FolicAcidUnit,BiotinUnit,PantothenicAcidUnit;

    TextView SodiumUnit,PotassiumUnit,ChlorideUnit,CalciumUnit,PhosphorusUnit,MagnesiumUnit,IronUnit,ZincUnit,ManganeseUnit,CopperUnit;
    TextView IodineUnit,SeleniumUnit,ChromiumUnit,MolybdenumUnit,WaterUnit;

    private TextView αLactalbuminUnit,βLactoglobulinUnit,GlycomacropeptideUnit,ImmunoglobulinGIgGUnit,BovineSerumAlbuminUnit,ProteasePeptone5Unit;

    private TextView IsoleucineUnit,LeucineUnit,LysineUnit,MethionineUnit,PhenylalanineUnit,ThreonineUnit,TryptophanUnit,ValineUnit,HistidineUnit,AlanineUnit;
    private TextView ArginineUnit,AsparticAcidUnit,CysteineUnit,GlutamicAcidUnit,GlycineUnit,ProlineUnit,SerineUnit,TyrosineUnit,HydroxyLysineUnit,HydroxyProlineUnit;


    private EditText AmountEt,EnergyEt,ProteinEt;
    private TextView FatEt,MUFAEt,PUFAEt,LinoleicEt,LinoAcidEt,EPAEt,DHAEt,SFAEt,MCToilEt,TransEt;
    private TextView CholesterolEt,CarbohydrateEt,SaltEt,LactoseEt,PolyolsEt,FiberEt,FOSEt,DietaryFiberEt,SolubleFiberEt,SugarEt;
    private TextView EssentialAminoAcidsEt,BranchedChainAminoAcidsEt,InulinEt,CholineEt,TaurineEt,CarnitineEt,LCarnitineEt,CaHMBEt,HMBEt,InositolEt;

    private TextView VitaminAEt,VitaminA1Et,VitaminA2Et,VitaminDEt,VitaminD3Et,VitaminEEt,VitaminKEt,VitaminK1Et,VitaminCEt,VitaminB1Et;
    private TextView VitaminB2Et,VitaminB6Et,VitaminB12Et,NiacinEt,NiacinEquivalentEt,FolicAcidEt,BiotinEt,PantothenicAcidEt;

    private TextView SodiumEt,PotassiumEt,ChlorideEt,CalciumEt,PhosphorusEt,MagnesiumEt,IronEt,ZincEt,ManganeseEt,CopperEt;
    private TextView IodineEt,SeleniumEt,ChromiumEt,MolybdenumEt,WaterEt;

    private TextView αLactalbuminEt,βLactoglobulinEt,GlycomacropeptideEt,ImmunoglobulinGIgGEt,BovineSerumAlbuminEt,ProteasePeptone5Et;

    private EditText IsoleucineEt,LeucineEt,LysineEt,MethionineEt,PhenylalanineEt,ThreonineEt,TryptophanEt,ValineEt,HistidineEt,AlanineEt;
    private EditText ArginineEt,AsparticAcidEt,CysteineEt,GlutamicAcidEt,GlycineEt,ProlineEt,SerineEt,TyrosineEt,HydroxyLysineEt,HydroxyProlineEt;


    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    StorageReference storageReference;
    DatabaseReference databaseReference;

    //permission constants
    private static final int CAMERA_REQUEST_CODE = 200;
    private static final int STORAGE_REQUEST_CODE = 300;

    //image pick constants
    private static final int IMAGE_PICK_GALLERY_CODE = 400;
    private static final int IMAGE_PICK_CAMERA_CODE = 500;

    //permission arrays
    private String[] cameraPermissions;
    private String[] storagePermissions;

    //image picked uri
    private Uri image_uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_edit);

        //get id of the product from intent
        productId = getIntent().getStringExtra("productId");
        scrollView = findViewById(R.id.scrollView);
        scrollUp = findViewById(R.id.scrollUp);
        scrollDown = findViewById(R.id.scrollDown);

        productIconIv = findViewById(R.id.productIconIv);
        nameEt = findViewById (R.id.nameEt);
        companyEt = findViewById (R.id.companyEt);
        descriptionEt = findViewById (R.id.descriptionEt);
        indicationsEt = findViewById (R.id.indicationsEt);
        ingredientsEt = findViewById (R.id.ingredientsEt);
        availabilityEt = findViewById (R.id.availabilityEt);
        retailPriceEt = findViewById (R.id.retailPriceEt);

        specialEt  = findViewById(R.id.specialEt);
        packSizeEt  = findViewById(R.id.packSizeEt);
        servingSizeEt  = findViewById(R.id.servingSizeEt);
        otherInfoEt  = findViewById(R.id.otherInfoEt);
        calorieEt  = findViewById(R.id.calorieEt);
        storageEt  = findViewById(R.id.storageEt);

        specialEt.setVisibility(View.GONE);
        packSizeEt.setVisibility(View.GONE);
        servingSizeEt.setVisibility(View.GONE);
        otherInfoEt.setVisibility(View.GONE);
        calorieEt.setVisibility(View.GONE);
        storageEt.setVisibility(View.GONE);

        specialSwitch  = findViewById(R.id.specialSwitch);
        packSizeSwitch  = findViewById(R.id.packSizeSwitch);
        servingSizeSwitch  = findViewById(R.id.servingSizeSwitch);
        otherInfoSwitch  = findViewById(R.id.otherInfoSwitch);
        calorieSwitch  = findViewById(R.id.calorieSwitch);
        storageSwitch  = findViewById(R.id.storageSwitch);


        AmountType  = findViewById(R.id.AmountType);
        AmountEt = findViewById(R.id.AmountEt);
        EnergyEt  = findViewById(R.id.EnergyEt);
        ProteinEt  = findViewById(R.id.ProteinEt);

        FatEt  = findViewById(R.id.FatEt);
        MUFAEt  = findViewById(R.id.MUFAEt);
        PUFAEt  = findViewById(R.id.PUFAEt);
        LinoleicEt  = findViewById(R.id.LinoleicAcidEt);
        LinoAcidEt  = findViewById(R.id.αlinolenicAcidEt);
        EPAEt  = findViewById(R.id.EPAEt);
        DHAEt  = findViewById(R.id.DHAEt);
        SFAEt  = findViewById(R.id.SFAEt);
        MCToilEt  = findViewById(R.id.MCToilEt);
        TransEt  = findViewById(R.id.TransFattyAcidsEt);

        CholesterolEt  = findViewById(R.id.CholesterolEt);
        CarbohydrateEt  = findViewById(R.id.CarbohydrateEt);
        SaltEt  = findViewById(R.id.SaltEt);
        LactoseEt  = findViewById(R.id.LactoseEt);
        PolyolsEt  = findViewById(R.id.PolyolsEt);
        FiberEt  = findViewById(R.id.FiberEt);
        FOSEt  = findViewById(R.id.FOSEt);
        DietaryFiberEt  = findViewById(R.id.DietaryFiberEt);
        SolubleFiberEt  = findViewById(R.id.SolubleFiberEt);
        SugarEt  = findViewById(R.id.SugarEt);

        EssentialAminoAcidsEt  = findViewById(R.id.EssentialAminoAcidsEt);
        BranchedChainAminoAcidsEt  = findViewById(R.id.BranchedChainAminoAcidsEt);
        InulinEt  = findViewById(R.id.InulinEt);
        CholineEt  = findViewById(R.id.CholineEt);
        TaurineEt  = findViewById(R.id.TaurineEt);
        CarnitineEt  = findViewById(R.id.CarnitineEt);
        LCarnitineEt  = findViewById(R.id.LCarnitineEt);
        CaHMBEt  = findViewById(R.id.CaHMBEt);
        HMBEt  = findViewById(R.id.HMBEt);
        InositolEt  = findViewById(R.id.InositolEt);

        VitaminAEt  = findViewById(R.id.VitaminAEt);
        VitaminA1Et  = findViewById(R.id.VitaminAPalmitateEt);
        VitaminA2Et  = findViewById(R.id.VitaminABcaroteneEt);
        VitaminDEt  = findViewById(R.id.VitaminDEt);
        VitaminD3Et  = findViewById(R.id.VitaminD3Et);
        VitaminEEt  = findViewById(R.id.VitaminEEt);
        VitaminKEt  = findViewById(R.id.VitaminKEt);
        VitaminK1Et  = findViewById(R.id.VitaminK1Et);
        VitaminCEt  = findViewById(R.id.VitaminCEt);
        VitaminB1Et  = findViewById(R.id.VitaminB1Et);

        VitaminB2Et  = findViewById(R.id.VitaminB2Et);
        VitaminB6Et  = findViewById(R.id.VitaminB6Et);
        VitaminB12Et  = findViewById(R.id.VitaminB12Et);
        NiacinEt  = findViewById(R.id.NiacinEt);
        NiacinEquivalentEt  = findViewById(R.id.NiacinEquivalentEt);
        FolicAcidEt  = findViewById(R.id.FolicAcidEt);
        BiotinEt  = findViewById(R.id.BiotinEt);
        PantothenicAcidEt  = findViewById(R.id.PantothenicAcidEt);

        SodiumEt  = findViewById(R.id.SodiumEt);
        PotassiumEt  = findViewById(R.id.PotassiumEt);
        ChlorideEt  = findViewById(R.id.ChlorideEt);
        CalciumEt  = findViewById(R.id.CalciumEt);
        PhosphorusEt  = findViewById(R.id.PhosphorusEt);
        MagnesiumEt  = findViewById(R.id.MagnesiumEt);
        IronEt  = findViewById(R.id.IronEt);
        ZincEt  = findViewById(R.id.ZincEt);
        ManganeseEt  = findViewById(R.id.ManganeseEt);
        CopperEt  = findViewById(R.id.CopperEt);

        IodineEt  = findViewById(R.id.IodineEt);
        SeleniumEt  = findViewById(R.id.SeleniumEt);
        ChromiumEt  = findViewById(R.id.ChromiumEt);
        MolybdenumEt  = findViewById(R.id.MolybdenumEt);
        WaterEt  = findViewById(R.id.WaterEt);

        αLactalbuminEt  = findViewById(R.id.αLactalbuminEt);
        βLactoglobulinEt  = findViewById(R.id.βLactoglobulinEt);
        GlycomacropeptideEt  = findViewById(R.id.GlycomacropeptideEt);
        ImmunoglobulinGIgGEt  = findViewById(R.id.ImmunoglobulinGIgGEt);
        BovineSerumAlbuminEt  = findViewById(R.id.BovineSerumAlbuminEt);
        ProteasePeptone5Et  = findViewById(R.id.ProteasePeptone5Et);

        IsoleucineEt  = findViewById(R.id.IsoleucineEt);
        LeucineEt = findViewById(R.id.LeucineEt);
        LysineEt = findViewById(R.id.LysineEt);
        MethionineEt = findViewById(R.id.MethionineEt);
        PhenylalanineEt = findViewById(R.id.PhenylalanineEt);
        ThreonineEt = findViewById(R.id.ThreonineEt);
        TryptophanEt = findViewById(R.id.TryptophanEt);
        ValineEt = findViewById(R.id.ValineEt);
        HistidineEt = findViewById(R.id.HistidineEt);
        AlanineEt = findViewById(R.id.AlanineEt);
        ArginineEt = findViewById(R.id.ArginineEt);
        AsparticAcidEt = findViewById(R.id.AsparticAcidEt);
        CysteineEt = findViewById(R.id.CysteineEt);
        GlutamicAcidEt = findViewById(R.id.GlutamicAcidEt);
        GlycineEt = findViewById(R.id.GlycineEt);
        ProlineEt = findViewById(R.id.ProlineEt);
        SerineEt = findViewById(R.id.SerineEt);
        TyrosineEt = findViewById(R.id.TyrosineEt);
        HydroxyLysineEt = findViewById(R.id.HydroxyLysineEt);
        HydroxyProlineEt = findViewById(R.id.HydroxyProlineEt);

        AmountUnit = findViewById(R.id.AmountUnit);
        EnergyUnit  = findViewById(R.id.EnergyUnit);
        ProteinUnit  = findViewById(R.id.ProteinUnit);

        FatUnit = findViewById(R.id.FatUnit);
        MUFAUnit = findViewById(R.id.MUFAUnit);
        PUFAUnit = findViewById(R.id.PUFAUnit);
        LinoleicUnit = findViewById(R.id.LinoleicAcidUnit);
        LinoAcidUnit = findViewById(R.id.αlinolenicAcidUnit);
        EPAUnit = findViewById(R.id.EPAUnit);
        DHAUnit = findViewById(R.id.DHAUnit);
        SFAUnit = findViewById(R.id.SFAUnit);
        MCToilUnit = findViewById(R.id.MCToilUnit);
        TransUnit = findViewById(R.id.TransFattyAcidsUnit);

        CholesterolUnit = findViewById(R.id.CholesterolUnit);
        CarbohydrateUnit = findViewById(R.id.CarbohydrateUnit);
        SaltUnit = findViewById(R.id.SaltUnit);
        LactoseUnit  = findViewById(R.id.LactoseUnit);
        PolyolsUnit  = findViewById(R.id.PolyolsUnit);
        FiberUnit  = findViewById(R.id.FiberUnit);
        FOSUnit  = findViewById(R.id.FOSUnit);
        DietaryFiberUnit  = findViewById(R.id.DietaryFiberUnit);
        SolubleFiberUnit  = findViewById(R.id.SolubleFiberUnit);
        SugarUnit  = findViewById(R.id.SugarUnit);

        EssentialAminoAcidsUnit = findViewById(R.id.EssentialAminoAcidsUnit);
        BranchedChainAminoAcidsUnit = findViewById(R.id.BranchedChainAminoAcidsUnit);
        InulinUnit = findViewById(R.id.InulinUnit);
        CholineUnit = findViewById(R.id.CholineUnit);
        TaurineUnit = findViewById(R.id.TaurineUnit);
        CarnitineUnit = findViewById(R.id.CarnitineUnit);
        LCarnitineUnit = findViewById(R.id.LCarnitineUnit);
        CaHMBUnit = findViewById(R.id.CaHMBUnit);
        HMBUnit = findViewById(R.id.HMBUnit);
        InositolUnit = findViewById(R.id.InositolUnit);

        VitaminAUnit = findViewById(R.id.VitaminAUnit);
        VitaminA1Unit = findViewById(R.id.VitaminAPalmitateUnit);
        VitaminA2Unit = findViewById(R.id.VitaminABcaroteneUnit);
        VitaminDUnit = findViewById(R.id.VitaminDUnit);
        VitaminD3Unit = findViewById(R.id.VitaminD3Unit);
        VitaminEUnit = findViewById(R.id.VitaminEUnit);
        VitaminKUnit = findViewById(R.id.VitaminKUnit);
        VitaminK1Unit = findViewById(R.id.VitaminK1Unit);
        VitaminCUnit = findViewById(R.id.VitaminCUnit);
        VitaminB1Unit = findViewById(R.id.VitaminB1Unit);
        VitaminB2Unit = findViewById(R.id.VitaminB2Unit);
        VitaminB6Unit = findViewById(R.id.VitaminB6Unit);
        VitaminB12Unit = findViewById(R.id.VitaminB12Unit);
        NiacinUnit = findViewById(R.id.NiacinUnit);
        NiacinEquivalentUnit = findViewById(R.id.NiacinEquivalentUnit);
        FolicAcidUnit = findViewById(R.id.FolicAcidUnit);
        BiotinUnit = findViewById(R.id.BiotinUnit);
        PantothenicAcidUnit = findViewById(R.id.PantothenicAcidUnit);

        SodiumUnit = findViewById(R.id.SodiumUnit);
        PotassiumUnit = findViewById(R.id.PotassiumUnit);
        ChlorideUnit = findViewById(R.id.ChlorideUnit);
        CalciumUnit = findViewById(R.id.CalciumUnit);
        PhosphorusUnit = findViewById(R.id.PhosphorusUnit);
        MagnesiumUnit = findViewById(R.id.MagnesiumUnit);
        IronUnit = findViewById(R.id.IronUnit);
        ZincUnit = findViewById(R.id.ZincUnit);
        ManganeseUnit = findViewById(R.id.ManganeseUnit);
        CopperUnit = findViewById(R.id.CopperUnit);
        IodineUnit = findViewById(R.id.IodineUnit);
        SeleniumUnit = findViewById(R.id.SeleniumUnit);
        ChromiumUnit = findViewById(R.id.ChromiumUnit);
        MolybdenumUnit = findViewById(R.id.MolybdenumUnit);
        WaterUnit = findViewById(R.id.WaterUnit);

        αLactalbuminUnit  = findViewById(R.id.αLactalbuminUnit);
        βLactoglobulinUnit  = findViewById(R.id.βLactoglobulinUnit);
        GlycomacropeptideUnit  = findViewById(R.id.GlycomacropeptideUnit);
        ImmunoglobulinGIgGUnit  = findViewById(R.id.ImmunoglobulinGIgGUnit);
        BovineSerumAlbuminUnit  = findViewById(R.id.BovineSerumAlbuminUnit);
        ProteasePeptone5Unit  = findViewById(R.id.ProteasePeptone5Unit);

        IsoleucineUnit  = findViewById(R.id.IsoleucineUnit);
        LeucineUnit = findViewById(R.id.LeucineUnit);
        LysineUnit = findViewById(R.id.LysineUnit);
        MethionineUnit = findViewById(R.id.MethionineUnit);
        PhenylalanineUnit = findViewById(R.id.PhenylalanineUnit);
        ThreonineUnit = findViewById(R.id.ThreonineUnit);
        TryptophanUnit = findViewById(R.id.TryptophanUnit);
        ValineUnit = findViewById(R.id.ValineUnit);
        HistidineUnit = findViewById(R.id.HistidineUnit);
        AlanineUnit = findViewById(R.id.AlanineUnit);
        ArginineUnit = findViewById(R.id.ArginineUnit);
        AsparticAcidUnit = findViewById(R.id.AsparticAcidUnit);
        CysteineUnit = findViewById(R.id.CysteineUnit);
        GlutamicAcidUnit = findViewById(R.id.GlutamicAcidUnit);
        GlycineUnit = findViewById(R.id.GlycineUnit);
        ProlineUnit = findViewById(R.id.ProlineUnit);
        SerineUnit = findViewById(R.id.SerineUnit);
        TyrosineUnit = findViewById(R.id.TyrosineUnit);
        HydroxyLysineUnit = findViewById(R.id.HydroxyLysineUnit);
        HydroxyProlineUnit = findViewById(R.id.HydroxyProlineUnit);

        AmountType  = findViewById(R.id.AmountType);
        AmountEt = findViewById(R.id.AmountEt);
        EnergyEt  = findViewById(R.id.EnergyEt);
        ProteinEt  = findViewById(R.id.ProteinEt);

        FatEt  = findViewById(R.id.FatEt);
        MUFAEt  = findViewById(R.id.MUFAEt);
        PUFAEt  = findViewById(R.id.PUFAEt);
        LinoleicEt  = findViewById(R.id.LinoleicAcidEt);
        LinoAcidEt  = findViewById(R.id.αlinolenicAcidEt);
        EPAEt  = findViewById(R.id.EPAEt);
        DHAEt  = findViewById(R.id.DHAEt);
        SFAEt  = findViewById(R.id.SFAEt);
        MCToilEt  = findViewById(R.id.MCToilEt);
        TransEt  = findViewById(R.id.TransFattyAcidsEt);

        CholesterolEt  = findViewById(R.id.CholesterolEt);
        CarbohydrateEt  = findViewById(R.id.CarbohydrateEt);
        SaltEt  = findViewById(R.id.SaltEt);
        LactoseEt  = findViewById(R.id.LactoseEt);
        PolyolsEt  = findViewById(R.id.PolyolsEt);
        FiberEt  = findViewById(R.id.FiberEt);
        FOSEt  = findViewById(R.id.FOSEt);
        DietaryFiberEt  = findViewById(R.id.DietaryFiberEt);
        SolubleFiberEt  = findViewById(R.id.SolubleFiberEt);
        SugarEt  = findViewById(R.id.SugarEt);

        EssentialAminoAcidsEt  = findViewById(R.id.EssentialAminoAcidsEt);
        BranchedChainAminoAcidsEt  = findViewById(R.id.BranchedChainAminoAcidsEt);
        InulinEt  = findViewById(R.id.InulinEt);
        CholineEt  = findViewById(R.id.CholineEt);
        TaurineEt  = findViewById(R.id.TaurineEt);
        CarnitineEt  = findViewById(R.id.CarnitineEt);
        LCarnitineEt  = findViewById(R.id.LCarnitineEt);
        CaHMBEt  = findViewById(R.id.CaHMBEt);
        HMBEt  = findViewById(R.id.HMBEt);
        InositolEt  = findViewById(R.id.InositolEt);

        VitaminAEt  = findViewById(R.id.VitaminAEt);
        VitaminA1Et  = findViewById(R.id.VitaminAPalmitateEt);
        VitaminA2Et  = findViewById(R.id.VitaminABcaroteneEt);
        VitaminDEt  = findViewById(R.id.VitaminDEt);
        VitaminD3Et  = findViewById(R.id.VitaminD3Et);
        VitaminEEt  = findViewById(R.id.VitaminEEt);
        VitaminKEt  = findViewById(R.id.VitaminKEt);
        VitaminK1Et  = findViewById(R.id.VitaminK1Et);
        VitaminCEt  = findViewById(R.id.VitaminCEt);
        VitaminB1Et  = findViewById(R.id.VitaminB1Et);

        VitaminB2Et  = findViewById(R.id.VitaminB2Et);
        VitaminB6Et  = findViewById(R.id.VitaminB6Et);
        VitaminB12Et  = findViewById(R.id.VitaminB12Et);
        NiacinEt  = findViewById(R.id.NiacinEt);
        NiacinEquivalentEt  = findViewById(R.id.NiacinEquivalentEt);
        FolicAcidEt  = findViewById(R.id.FolicAcidEt);
        BiotinEt  = findViewById(R.id.BiotinEt);
        PantothenicAcidEt  = findViewById(R.id.PantothenicAcidEt);

        SodiumEt  = findViewById(R.id.SodiumEt);
        PotassiumEt  = findViewById(R.id.PotassiumEt);
        ChlorideEt  = findViewById(R.id.ChlorideEt);
        CalciumEt  = findViewById(R.id.CalciumEt);
        PhosphorusEt  = findViewById(R.id.PhosphorusEt);
        MagnesiumEt  = findViewById(R.id.MagnesiumEt);
        IronEt  = findViewById(R.id.IronEt);
        ZincEt  = findViewById(R.id.ZincEt);
        ManganeseEt  = findViewById(R.id.ManganeseEt);
        CopperEt  = findViewById(R.id.CopperEt);

        IodineEt  = findViewById(R.id.IodineEt);
        SeleniumEt  = findViewById(R.id.SeleniumEt);
        ChromiumEt  = findViewById(R.id.ChromiumEt);
        MolybdenumEt  = findViewById(R.id.MolybdenumEt);
        WaterEt  = findViewById(R.id.WaterEt);

        αLactalbuminEt  = findViewById(R.id.αLactalbuminEt);
        βLactoglobulinEt  = findViewById(R.id.βLactoglobulinEt);
        GlycomacropeptideEt  = findViewById(R.id.GlycomacropeptideEt);
        ImmunoglobulinGIgGEt  = findViewById(R.id.ImmunoglobulinGIgGEt);
        BovineSerumAlbuminEt  = findViewById(R.id.BovineSerumAlbuminEt);
        ProteasePeptone5Et  = findViewById(R.id.ProteasePeptone5Et);

        IsoleucineEt  = findViewById(R.id.IsoleucineEt);
        LeucineEt = findViewById(R.id.LeucineEt);
        LysineEt = findViewById(R.id.LysineEt);
        MethionineEt = findViewById(R.id.MethionineEt);
        PhenylalanineEt = findViewById(R.id.PhenylalanineEt);
        ThreonineEt = findViewById(R.id.ThreonineEt);
        TryptophanEt = findViewById(R.id.TryptophanEt);
        ValineEt = findViewById(R.id.ValineEt);
        HistidineEt = findViewById(R.id.HistidineEt);
        AlanineEt = findViewById(R.id.AlanineEt);
        ArginineEt = findViewById(R.id.ArginineEt);
        AsparticAcidEt = findViewById(R.id.AsparticAcidEt);
        CysteineEt = findViewById(R.id.CysteineEt);
        GlutamicAcidEt = findViewById(R.id.GlutamicAcidEt);
        GlycineEt = findViewById(R.id.GlycineEt);
        ProlineEt = findViewById(R.id.ProlineEt);
        SerineEt = findViewById(R.id.SerineEt);
        TyrosineEt = findViewById(R.id.TyrosineEt);
        HydroxyLysineEt = findViewById(R.id.HydroxyLysineEt);
        HydroxyProlineEt = findViewById(R.id.HydroxyProlineEt);

        AmountUnit = findViewById(R.id.AmountUnit);
        EnergyUnit  = findViewById(R.id.EnergyUnit);
        ProteinUnit  = findViewById(R.id.ProteinUnit);

        FatUnit = findViewById(R.id.FatUnit);
        MUFAUnit = findViewById(R.id.MUFAUnit);
        PUFAUnit = findViewById(R.id.PUFAUnit);
        LinoleicUnit = findViewById(R.id.LinoleicAcidUnit);
        LinoAcidUnit = findViewById(R.id.αlinolenicAcidUnit);
        EPAUnit = findViewById(R.id.EPAUnit);
        DHAUnit = findViewById(R.id.DHAUnit);
        SFAUnit = findViewById(R.id.SFAUnit);
        MCToilUnit = findViewById(R.id.MCToilUnit);
        TransUnit = findViewById(R.id.TransFattyAcidsUnit);

        CholesterolUnit = findViewById(R.id.CholesterolUnit);
        CarbohydrateUnit = findViewById(R.id.CarbohydrateUnit);
        SaltUnit = findViewById(R.id.SaltUnit);
        LactoseUnit  = findViewById(R.id.LactoseUnit);
        PolyolsUnit  = findViewById(R.id.PolyolsUnit);
        FiberUnit  = findViewById(R.id.FiberUnit);
        FOSUnit  = findViewById(R.id.FOSUnit);
        DietaryFiberUnit  = findViewById(R.id.DietaryFiberUnit);
        SolubleFiberUnit  = findViewById(R.id.SolubleFiberUnit);
        SugarUnit  = findViewById(R.id.SugarUnit);

        EssentialAminoAcidsUnit = findViewById(R.id.EssentialAminoAcidsUnit);
        BranchedChainAminoAcidsUnit = findViewById(R.id.BranchedChainAminoAcidsUnit);
        InulinUnit = findViewById(R.id.InulinUnit);
        CholineUnit = findViewById(R.id.CholineUnit);
        TaurineUnit = findViewById(R.id.TaurineUnit);
        CarnitineUnit = findViewById(R.id.CarnitineUnit);
        LCarnitineUnit = findViewById(R.id.LCarnitineUnit);
        CaHMBUnit = findViewById(R.id.CaHMBUnit);
        HMBUnit = findViewById(R.id.HMBUnit);
        InositolUnit = findViewById(R.id.InositolUnit);

        VitaminAUnit = findViewById(R.id.VitaminAUnit);
        VitaminA1Unit = findViewById(R.id.VitaminAPalmitateUnit);
        VitaminA2Unit = findViewById(R.id.VitaminABcaroteneUnit);
        VitaminDUnit = findViewById(R.id.VitaminDUnit);
        VitaminD3Unit = findViewById(R.id.VitaminD3Unit);
        VitaminEUnit = findViewById(R.id.VitaminEUnit);
        VitaminKUnit = findViewById(R.id.VitaminKUnit);
        VitaminK1Unit = findViewById(R.id.VitaminK1Unit);
        VitaminCUnit = findViewById(R.id.VitaminCUnit);
        VitaminB1Unit = findViewById(R.id.VitaminB1Unit);
        VitaminB2Unit = findViewById(R.id.VitaminB2Unit);
        VitaminB6Unit = findViewById(R.id.VitaminB6Unit);
        VitaminB12Unit = findViewById(R.id.VitaminB12Unit);
        NiacinUnit = findViewById(R.id.NiacinUnit);
        NiacinEquivalentUnit = findViewById(R.id.NiacinEquivalentUnit);
        FolicAcidUnit = findViewById(R.id.FolicAcidUnit);
        BiotinUnit = findViewById(R.id.BiotinUnit);
        PantothenicAcidUnit = findViewById(R.id.PantothenicAcidUnit);

        SodiumUnit = findViewById(R.id.SodiumUnit);
        PotassiumUnit = findViewById(R.id.PotassiumUnit);
        ChlorideUnit = findViewById(R.id.ChlorideUnit);
        CalciumUnit = findViewById(R.id.CalciumUnit);
        PhosphorusUnit = findViewById(R.id.PhosphorusUnit);
        MagnesiumUnit = findViewById(R.id.MagnesiumUnit);
        IronUnit = findViewById(R.id.IronUnit);
        ZincUnit = findViewById(R.id.ZincUnit);
        ManganeseUnit = findViewById(R.id.ManganeseUnit);
        CopperUnit = findViewById(R.id.CopperUnit);
        IodineUnit = findViewById(R.id.IodineUnit);
        SeleniumUnit = findViewById(R.id.SeleniumUnit);
        ChromiumUnit = findViewById(R.id.ChromiumUnit);
        MolybdenumUnit = findViewById(R.id.MolybdenumUnit);
        WaterUnit = findViewById(R.id.WaterUnit);

        αLactalbuminUnit  = findViewById(R.id.αLactalbuminUnit);
        βLactoglobulinUnit  = findViewById(R.id.βLactoglobulinUnit);
        GlycomacropeptideUnit  = findViewById(R.id.GlycomacropeptideUnit);
        ImmunoglobulinGIgGUnit  = findViewById(R.id.ImmunoglobulinGIgGUnit);
        BovineSerumAlbuminUnit  = findViewById(R.id.BovineSerumAlbuminUnit);
        ProteasePeptone5Unit  = findViewById(R.id.ProteasePeptone5Unit);

        IsoleucineUnit  = findViewById(R.id.IsoleucineUnit);
        LeucineUnit = findViewById(R.id.LeucineUnit);
        LysineUnit = findViewById(R.id.LysineUnit);
        MethionineUnit = findViewById(R.id.MethionineUnit);
        PhenylalanineUnit = findViewById(R.id.PhenylalanineUnit);
        ThreonineUnit = findViewById(R.id.ThreonineUnit);
        TryptophanUnit = findViewById(R.id.TryptophanUnit);
        ValineUnit = findViewById(R.id.ValineUnit);
        HistidineUnit = findViewById(R.id.HistidineUnit);
        AlanineUnit = findViewById(R.id.AlanineUnit);
        ArginineUnit = findViewById(R.id.ArginineUnit);
        AsparticAcidUnit = findViewById(R.id.AsparticAcidUnit);
        CysteineUnit = findViewById(R.id.CysteineUnit);
        GlutamicAcidUnit = findViewById(R.id.GlutamicAcidUnit);
        GlycineUnit = findViewById(R.id.GlycineUnit);
        ProlineUnit = findViewById(R.id.ProlineUnit);
        SerineUnit = findViewById(R.id.SerineUnit);
        TyrosineUnit = findViewById(R.id.TyrosineUnit);
        HydroxyLysineUnit = findViewById(R.id.HydroxyLysineUnit);
        HydroxyProlineUnit = findViewById(R.id.HydroxyProlineUnit);

        updateProductBtn = findViewById(R.id.updateProductBtn);

        firebaseAuth = FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Please wait");
        progressDialog.setCanceledOnTouchOutside(false);

        scrollDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(ScrollView.FOCUS_DOWN);
                scrollUp.show();
            }
        });
        scrollUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                scrollView.fullScroll(ScrollView.FOCUS_UP);
                scrollDown.show();
            }
        });

        storageReference = FirebaseStorage.getInstance().getReference();

        //init permission arrays
        cameraPermissions = new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        loadProductDetails(productId); //to set on views

//        productIconIv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                //show dialog to pick image (either gallery or camera)
//                showImagePickDialog();
//            }
//        });

        updateProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //flow
//                //1. input data
//                //2. validate data
//                //3. update data to db
                inputData();
            }
        });

        detailSwitch();
        detailUnit();

    }

    private void addToNotifications(String notification) {

        String uid = firebaseAuth.getUid();
        String timestamp = ""+System.currentTimeMillis();

        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("uid", "" + uid);
        hashMap.put("timestamp", "" + timestamp);
        hashMap.put("notification", "" + notification);
        hashMap.put("productName", "" + productName_);
        hashMap.put("productCompany", "" + productCompany_);

        DatabaseReference Notification = FirebaseDatabase.getInstance().getReference("Notifications");
        Notification.child(timestamp).setValue(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //added to db
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                    }
                });
    }


    String productName_,productDescription_,productCategory,productSubCategory,productCompany_,productIndications_,productIngredients_,productAvailability_, productRetailPrice_;
    String productSpecial_,productPackSize_,productServingSize_,productOtherInfo_,productCalorie_,productStorage_;

    String productAmountType;
    String productAmount,productEnergy,productProtein;
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

    //**************************************************************************************************************************************************************************************************************************

    String productAmountUnit,productEnergyUnit,productProteinUnit;
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


    private void detailSwitch() {

//        //*******************************************************************************************************************************SWITCH
//        //if switch is checked: show Et
//        //if switch is not checked, hide Et
        specialSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    specialEt.setVisibility(View.VISIBLE);
                }else{
                    specialEt.setVisibility(View.GONE);
                }
            }
        });
        packSizeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    packSizeEt.setVisibility(View.VISIBLE);
                }else{
                    packSizeEt.setVisibility(View.GONE);
                }
            }
        });
        servingSizeSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    servingSizeEt.setVisibility(View.VISIBLE);
                }else{
                    servingSizeEt.setVisibility(View.GONE);
                }
            }
        });
        otherInfoSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    otherInfoEt.setVisibility(View.VISIBLE);
                }else{
                    otherInfoEt.setVisibility(View.GONE);
                }
            }
        });
        calorieSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    calorieEt.setVisibility(View.VISIBLE);
                }else{
                    calorieEt.setVisibility(View.GONE);
                }
            }
        });
        storageSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    storageEt.setVisibility(View.VISIBLE);
                }else{
                    storageEt.setVisibility(View.GONE);
                }
            }
        });
//        uploadPDFSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//            @Override
//            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//                if(isChecked){
//                    uploadPDFNameEt.setVisibility(View.VISIBLE);
//                    uploadPDFBtn.setVisibility(View.VISIBLE);
//                    searchPDFBtn.setVisibility(View.VISIBLE);
//                }else{
//                    uploadPDFNameEt.setVisibility(View.GONE);
//                    uploadPDFBtn.setVisibility(View.GONE);
//                    searchPDFBtn.setVisibility(View.GONE);
//
//                }
//            }
//        });
    }

    private void detailUnit() {

        AmountType.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Amount")
                        .setItems(Amount.perAmount, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Amount.perAmount[which];
                                //set picked category
                                AmountType.setText(unit);
                            }
                        })
                        .show();
            }
        });
        AmountUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                AmountUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        EnergyUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                EnergyUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ProteinUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ProteinUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });

        FatUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                FatUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        MUFAUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                MUFAUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        PUFAUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                PUFAUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        LinoleicUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                LinoleicUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        LinoAcidUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                LinoAcidUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        EPAUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                EPAUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        DHAUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                DHAUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        SFAUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                SFAUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        MCToilUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                MCToilUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        TransUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                TransUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });

        CholesterolUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CholesterolUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        CarbohydrateUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CarbohydrateUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        SaltUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                SaltUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        LactoseUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                LactoseUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        PolyolsUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                PolyolsUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        FiberUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                FiberUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        FOSUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                FOSUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        DietaryFiberUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                DietaryFiberUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        SolubleFiberUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                SolubleFiberUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        SugarUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                SugarUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });

        EssentialAminoAcidsUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                EssentialAminoAcidsUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        BranchedChainAminoAcidsUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                BranchedChainAminoAcidsUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        InulinUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                InulinUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        CholineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CholineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        TaurineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                TaurineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        CarnitineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CarnitineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        LCarnitineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                LCarnitineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        CaHMBUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CaHMBUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        HMBUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                HMBUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        InositolUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                InositolUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });

        VitaminAUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminAUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminA1Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminA1Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminA2Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminA2Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminDUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminDUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminD3Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminD3Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminEUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminEUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminKUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminKUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminK1Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminK1Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminCUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminCUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminB1Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminB1Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminB2Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminB2Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminB6Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminB6Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        VitaminB12Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                VitaminB12Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        NiacinUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                NiacinUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        NiacinEquivalentUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                NiacinEquivalentUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        FolicAcidUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                FolicAcidUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        BiotinUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                BiotinUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        PantothenicAcidUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                PantothenicAcidUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });

        SodiumUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                SodiumUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        PotassiumUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                PotassiumUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ChlorideUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ChlorideUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        CalciumUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CalciumUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        PhosphorusUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                PhosphorusUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        MagnesiumUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                MagnesiumUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        IronUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                IronUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ZincUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ZincUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ManganeseUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ManganeseUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        CopperUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CopperUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        IodineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                IodineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        SeleniumUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                SeleniumUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ChromiumUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ChromiumUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        MolybdenumUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                MolybdenumUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        WaterUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                WaterUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });

        αLactalbuminUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                αLactalbuminUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        βLactoglobulinUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                βLactoglobulinUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        GlycomacropeptideUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                GlycomacropeptideUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ImmunoglobulinGIgGUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ImmunoglobulinGIgGUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        BovineSerumAlbuminUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                BovineSerumAlbuminUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ProteasePeptone5Unit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ProteasePeptone5Unit.setText(unit);
                            }
                        })
                        .show();
            }
        });

        IsoleucineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                IsoleucineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        LeucineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                LeucineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        LysineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                LysineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        MethionineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                MethionineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        PhenylalanineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                PhenylalanineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ThreonineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ThreonineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        TryptophanUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                TryptophanUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ValineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ValineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        HistidineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                HistidineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        AlanineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                AlanineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ArginineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ArginineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        AsparticAcidUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                AsparticAcidUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        CysteineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                CysteineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        GlutamicAcidUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                GlutamicAcidUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        GlycineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                GlycineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        ProlineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                ProlineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        SerineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                SerineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        TyrosineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                TyrosineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        HydroxyLysineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                HydroxyLysineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });
        HydroxyProlineUnit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialog
                AlertDialog.Builder builder = new AlertDialog.Builder(ProductEditActivity.this);
                builder.setTitle("Units")
                        .setItems(Units.nutrientUnits, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //get picked category
                                String unit = Units.nutrientUnits[which];
                                //set picked category
                                HydroxyProlineUnit.setText(unit);
                            }
                        })
                        .show();
            }
        });


    }

    private void loadProductDetails(String productId) {

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Products");
        reference.child(productId).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {

                //get data
                String product_Icon = ""+snapshot.child("productIcon").getValue();
                String product_Name = ""+snapshot.child("productName").getValue();
                String product_Company = "" +snapshot.child("productCompany").getValue();
                String product_Description = "" +snapshot.child("productDescription").getValue();
                String product_Indication = "" +snapshot.child("productIndication").getValue();
                String product_Ingredient = "" +snapshot.child("productIngredient").getValue();
                String product_Availability = "" +snapshot.child("productAvailability").getValue();
                String product_RetailPrice = "" +snapshot.child("productRetailPrice").getValue();

                String product_SpecialFeatures = "" +snapshot.child("productSpecialFeatures").getValue();
                String product_PackSize = "" +snapshot.child("productPackSize").getValue();
                String product_ServingSize = "" +snapshot.child("productServingSize").getValue();
                String product_OtherInfo = "" +snapshot.child("productOtherInfo").getValue();
                String product_Calorie = "" +snapshot.child("productCalorie").getValue();
                String product_Storage = "" +snapshot.child("productStorage").getValue();

                String productAmount = "" +snapshot.child("productAmount").getValue();
                String productEnergy = "" +snapshot.child("productEnergy").getValue();
                String productProtein = "" +snapshot.child("productProtein").getValue();
                String productFat = "" +snapshot.child("productFat").getValue();
                String productMUFA = "" +snapshot.child("productMUFA").getValue();
                String productPUFA = "" +snapshot.child("productPUFA").getValue();
                String productLinoleicAcidOmega6 = "" +snapshot.child("productLinoleicAcidOmega6").getValue();
                String productαlinolenicAcidOmega3 = "" +snapshot.child("productαlinolenicAcidOmega3").getValue();
                String productEPA = "" +snapshot.child("productEPA").getValue();
                String productDHA = "" +snapshot.child("productDHA").getValue();
                String productSFA = "" +snapshot.child("productSFA").getValue();
                String productMCTOil = "" +snapshot.child("productMCTOil").getValue();
                String productTransFattyAcids = "" +snapshot.child("productTransFattyAcids").getValue();
                String productCholesterol = "" +snapshot.child("productCholesterol").getValue();
                String productCarbohydrate = "" +snapshot.child("productCarbohydrate").getValue();
                String productSalt = "" +snapshot.child("productSalt").getValue();
                String productLactose = "" +snapshot.child("productLactose").getValue();
                String productPolyols = "" +snapshot.child("productPolyols").getValue();
                String productFiber = "" +snapshot.child("productFiber").getValue();
                String productFOS = "" +snapshot.child("productFOS").getValue();
                String productDietaryFiber = "" +snapshot.child("productDietaryFiber").getValue();
                String productSolubleFiber = "" +snapshot.child("productSolubleFiber").getValue();
                String productSugar = "" +snapshot.child("productSugar").getValue();
                String productEssentialAminoAcids = "" +snapshot.child("productEssentialAminoAcids").getValue();
                String productBranchedChainAminoAcids = "" +snapshot.child("productBranchedChainAminoAcids").getValue();
                String productInulin = "" +snapshot.child("productInulin").getValue();
                String productCholine = "" +snapshot.child("productCholine").getValue();
                String productTaurine = "" +snapshot.child("productTaurine").getValue();
                String productCarnitine = "" +snapshot.child("productCarnitine").getValue();
                String productLCarnitine = "" +snapshot.child("productLCarnitine").getValue();
                String productCaHMB = "" +snapshot.child("productCaHMB").getValue();
                String productHMB = "" +snapshot.child("productHMB").getValue();
                String productInositol = "" +snapshot.child("productInositol").getValue();
                String productαLactalbumin = "" +snapshot.child("productαLactalbumin").getValue();
                String productβLactoglobulin = "" +snapshot.child("productβLactoglobulin").getValue();
                String productGlycomacropeptide = "" +snapshot.child("productGlycomacropeptide").getValue();
                String productImmunoglobulinGIgG = "" +snapshot.child("productImmunoglobulinGIgG").getValue();
                String productBovineSerumAlbumin = "" +snapshot.child("productBovineSerumAlbumin").getValue();
                String productProteasePeptone5 = "" +snapshot.child("productProteasePeptone5").getValue();
                String productVitaminA = "" +snapshot.child("productVitaminA").getValue();
                String productVitaminAPalmitate = "" +snapshot.child("productVitaminAPalmitate").getValue();
                String productVitaminABCarotene = "" +snapshot.child("productVitaminABCarotene").getValue();
                String productVitaminD = "" +snapshot.child("productVitaminD").getValue();
                String productVitaminD3 = "" +snapshot.child("productVitaminD3").getValue();
                String productVitaminE = "" +snapshot.child("productVitaminE").getValue();
                String productVitaminK = "" +snapshot.child("productVitaminK").getValue();
                String productVitaminK1 = "" +snapshot.child("productVitaminK1").getValue();
                String productVitaminC = "" +snapshot.child("productVitaminC").getValue();
                String productVitaminB1 = "" +snapshot.child("productVitaminB1").getValue();
                String productVitaminB2 = "" +snapshot.child("productVitaminB2").getValue();
                String productVitaminB6 = "" +snapshot.child("productVitaminB6").getValue();
                String productVitaminB12 = "" +snapshot.child("productVitaminB12").getValue();
                String productNiacin = "" +snapshot.child("productNiacin").getValue();
                String productNiacinEquivalent = "" +snapshot.child("productNiacinEquivalent").getValue();
                String productFolicAcid = "" +snapshot.child("productFolicAcid").getValue();
                String productBiotin = "" +snapshot.child("productBiotin").getValue();
                String productPantothenicAcid = "" +snapshot.child("productPantothenicAcid").getValue();
                String productSodium = "" +snapshot.child("productSodium").getValue();
                String productPotassium = "" +snapshot.child("productPotassium").getValue();
                String productChloride = "" +snapshot.child("productChloride").getValue();
                String productCalcium = "" +snapshot.child("productCalcium").getValue();
                String productPhosphorus = "" +snapshot.child("productPhosphorus").getValue();
                String productMagnesium = "" +snapshot.child("productMagnesium").getValue();
                String productIron = "" +snapshot.child("productIron").getValue();
                String productZinc = "" +snapshot.child("productZinc").getValue();
                String productManganese = "" +snapshot.child("productManganese").getValue();
                String productCopper = "" +snapshot.child("productCopper").getValue();
                String productIodine = "" +snapshot.child("productIodine").getValue();
                String productSelenium = "" +snapshot.child("productSelenium").getValue();
                String productChromium = "" +snapshot.child("productChromium").getValue();
                String productMolybdenum = "" +snapshot.child("productMolybdenum").getValue();
                String productWater = "" +snapshot.child("productWater").getValue();

                String productIsoleucine = "" +snapshot.child("productIsoleucine").getValue();
                String productLeucine = "" +snapshot.child("productLeucine").getValue();
                String productLysine = "" +snapshot.child("productLysine").getValue();
                String productMethionine = "" +snapshot.child("productMethionine").getValue();
                String productPhenylalanine = "" +snapshot.child("productPhenylalanine").getValue();
                String productThreonine = "" +snapshot.child("productThreonine").getValue();
                String productTryptophan = "" +snapshot.child("productTryptophan").getValue();
                String productValine = "" +snapshot.child("productValine").getValue();
                String productHistidine = "" +snapshot.child("productHistidine").getValue();
                String productAlanine = "" +snapshot.child("productAlanine").getValue();
                String productArginine = "" +snapshot.child("productArginine").getValue();
                String productAsparticAcid = "" +snapshot.child("productAsparticAcid").getValue();
                String productCysteine = "" +snapshot.child("productCysteine").getValue();
                String productGlutamicAcid = "" +snapshot.child("productGlutamicAcid").getValue();
                String productGlycine = "" +snapshot.child("productGlycine").getValue();
                String productProline = "" +snapshot.child("productProline").getValue();
                String productSerine = "" +snapshot.child("productSerine").getValue();
                String productTyrosine = "" +snapshot.child("productTyrosine").getValue();
                String productHydroxyLysine = "" +snapshot.child("productHydroxyLysine").getValue();
                String productHydroxyProline = "" +snapshot.child("productHydroxyProline").getValue();

                try{
                    Picasso.get().load(product_Icon).placeholder(R.drawable.cart).into(productIconIv);

                }catch (Exception e){
                    productIconIv.setImageResource(R.drawable.cart);
                }

                nameEt.setText(product_Name);
                companyEt.setText(product_Company);
                descriptionEt.setText(product_Description);
                indicationsEt.setText(product_Indication);
                ingredientsEt.setText(product_Ingredient);
                availabilityEt.setText(product_Availability);
                retailPriceEt.setText(product_RetailPrice);

                specialEt.setText(product_SpecialFeatures);
                packSizeEt.setText(product_PackSize);
                servingSizeEt.setText(product_ServingSize);
                otherInfoEt.setText(product_OtherInfo);
                calorieEt.setText(product_Calorie);
                storageEt.setText(product_Storage);

                AmountEt.setText(productAmount);
                EnergyEt.setText(productEnergy);
                ProteinEt.setText(productProtein);

                FatEt.setText(productFat);
                MUFAEt.setText(productMUFA);
                PUFAEt.setText(productPUFA);
                LinoleicEt.setText(productLinoleicAcidOmega6);
                LinoAcidEt.setText(productαlinolenicAcidOmega3);
                EPAEt.setText(productEPA);
                DHAEt.setText(productDHA);
                SFAEt.setText(productSFA);
                MCToilEt.setText(productMCTOil);
                TransEt.setText(productTransFattyAcids);

                CholesterolEt.setText(productCholesterol);
                CarbohydrateEt.setText(productCarbohydrate);
                SaltEt.setText(productSalt);
                LactoseEt.setText(productLactose);
                PolyolsEt.setText(productPolyols);
                FiberEt.setText(productFiber);
                FOSEt.setText(productFOS);
                DietaryFiberEt.setText(productDietaryFiber);
                SolubleFiberEt.setText(productSolubleFiber);
                SugarEt.setText(productSugar);

                EssentialAminoAcidsEt.setText(productEssentialAminoAcids);
                BranchedChainAminoAcidsEt.setText(productBranchedChainAminoAcids);
                InulinEt.setText(productInulin);
                CholineEt.setText(productCholine);
                TaurineEt.setText(productTaurine);
                CarnitineEt.setText(productCarnitine);
                LCarnitineEt.setText(productLCarnitine);
                CaHMBEt.setText(productCaHMB);
                HMBEt.setText(productHMB);
                InositolEt.setText(productInositol);

                VitaminAEt.setText(productVitaminA);
                VitaminA1Et.setText(productVitaminAPalmitate);
                VitaminA2Et.setText(productVitaminABCarotene);
                VitaminDEt.setText(productVitaminD);
                VitaminD3Et.setText(productVitaminD3);
                VitaminEEt.setText(productVitaminE);
                VitaminKEt.setText(productVitaminK);
                VitaminK1Et.setText(productVitaminK1);
                VitaminCEt.setText(productVitaminC);
                VitaminB1Et.setText(productVitaminB1);

                VitaminB2Et.setText(productVitaminB2);
                VitaminB6Et.setText(productVitaminB6);
                VitaminB12Et.setText(productVitaminB12);
                NiacinEt.setText(productNiacin);
                NiacinEquivalentEt.setText(productNiacinEquivalent);
                FolicAcidEt.setText(productFolicAcid);
                BiotinEt.setText(productBiotin);
                PantothenicAcidEt.setText(productPantothenicAcid);

                SodiumEt.setText(productSodium);
                PotassiumEt.setText(productPotassium);
                ChlorideEt.setText(productChloride);
                CalciumEt.setText(productCalcium);
                PhosphorusEt.setText(productPhosphorus);
                MagnesiumEt.setText(productMagnesium);
                IronEt.setText(productIron);
                ZincEt.setText(productZinc);
                ManganeseEt.setText(productManganese);
                CopperEt.setText(productCopper);

                IodineEt.setText(productIodine);
                SeleniumEt.setText(productSelenium);
                ChromiumEt.setText(productChromium);
                MolybdenumEt.setText(productMolybdenum);
                WaterEt.setText(productWater);

                αLactalbuminEt.setText(productαLactalbumin);
                βLactoglobulinEt.setText(productβLactoglobulin);
                GlycomacropeptideEt.setText(productGlycomacropeptide);
                ImmunoglobulinGIgGEt.setText(productImmunoglobulinGIgG);
                BovineSerumAlbuminEt.setText(productBovineSerumAlbumin);
                ProteasePeptone5Et.setText(productProteasePeptone5);

                IsoleucineEt.setText(productIsoleucine);
                LeucineEt.setText(productLeucine);
                LysineEt.setText(productLysine);
                MethionineEt.setText(productMethionine);
                PhenylalanineEt.setText(productPhenylalanine);
                ThreonineEt.setText(productThreonine);
                TryptophanEt.setText(productTryptophan);
                ValineEt.setText(productValine);
                HistidineEt.setText(productHistidine);
                AlanineEt.setText(productAlanine);
                ArginineEt.setText(productArginine);
                AsparticAcidEt.setText(productAsparticAcid);
                CysteineEt.setText(productCysteine);
                GlutamicAcidEt.setText(productGlutamicAcid);
                GlycineEt.setText(productGlycine);
                ProlineEt.setText(productProline);
                SerineEt.setText(productSerine);
                TyrosineEt.setText(productTyrosine);
                HydroxyLysineEt.setText(productHydroxyLysine);
                HydroxyProlineEt.setText(productHydroxyProline);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    private void inputData() {

        //show progress
        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        productName_ = nameEt.getText().toString().trim();
        productCompany_ = companyEt.getText().toString().trim();
        productDescription_ = descriptionEt.getText().toString().trim();
        productIndications_ = indicationsEt.getText().toString().trim();
        productIngredients_ = ingredientsEt.getText().toString().trim();
        productAvailability_ = availabilityEt.getText().toString().trim();
        productRetailPrice_ = retailPriceEt.getText().toString().trim();

//        productCategory = companyEt.getText().toString().trim();
//        productSubCategory = nameEt.getText().toString().trim();

        productSpecial_ = specialEt.getText().toString().trim();
        productPackSize_ = packSizeEt.getText().toString().trim();
        productServingSize_ = servingSizeEt.getText().toString().trim();
        productOtherInfo_ = otherInfoEt.getText().toString().trim();
        productCalorie_ = calorieEt.getText().toString().trim();
        productStorage_ = storageEt.getText().toString().trim();

        productAmountType = AmountType.getText().toString().trim();
        productAmount = AmountEt.getText().toString().trim();
        productEnergy = EnergyEt.getText().toString().trim();
        productProtein = ProteinEt.getText().toString().trim();

        productFat = FatEt.getText().toString().trim();
        productMUFA = MUFAEt.getText().toString().trim();
        productPUFA = PUFAEt.getText().toString().trim();
        productLinoleicAcidOmega6 = LinoleicEt.getText().toString().trim();
        productαlinolenicAcidOmega3 = LinoAcidEt.getText().toString().trim();
        productEPA = EPAEt.getText().toString().trim();
        productDHA = DHAEt.getText().toString().trim();
        productSFA = SFAEt.getText().toString().trim();
        productMCTOil = MCToilEt.getText().toString().trim();
        productTransFattyAcids = TransEt.getText().toString().trim();
        productCholesterol = CholesterolEt.getText().toString().trim();
        productCarbohydrate = CarbohydrateEt.getText().toString().trim();
        productSalt = SaltEt.getText().toString().trim();
        productLactose = LactoseEt.getText().toString().trim();
        productPolyols = PolyolsEt.getText().toString().trim();
        productFiber = FiberEt.getText().toString().trim();
        productFOS = FOSEt.getText().toString().trim();
        productDietaryFiber = DietaryFiberEt.getText().toString().trim();
        productSolubleFiber = SolubleFiberEt.getText().toString().trim();
        productSugar = SugarEt.getText().toString().trim();
        productEssentialAminoAcids = EssentialAminoAcidsEt.getText().toString().trim();
        productBranchedChainAminoAcids = BranchedChainAminoAcidsEt.getText().toString().trim();
        productInulin = InulinEt.getText().toString().trim();
        productCholine = CholineEt.getText().toString().trim();
        productTaurine = TaurineEt.getText().toString().trim();
        productCarnitine = CarnitineEt.getText().toString().trim();
        productLCarnitine = LCarnitineEt.getText().toString().trim();
        productCaHMB = CaHMBEt.getText().toString().trim();
        productHMB = HMBEt.getText().toString().trim();
        productInositol = InositolEt.getText().toString().trim();
        productαLactalbumin = αLactalbuminEt.getText().toString().trim();
        productβLactoglobulin = βLactoglobulinEt.getText().toString().trim();
        productGlycomacropeptide = GlycomacropeptideEt.getText().toString().trim();
        productImmunoglobulinGIgG = ImmunoglobulinGIgGEt.getText().toString().trim();
        productBovineSerumAlbumin = BovineSerumAlbuminEt.getText().toString().trim();
        productProteasePeptone5 = ProteasePeptone5Et.getText().toString().trim();
        productVitaminA = VitaminAEt.getText().toString().trim();
        productVitaminAPalmitate = VitaminA1Et.getText().toString().trim();
        productVitaminABCarotene = VitaminA2Et.getText().toString().trim();
        productVitaminD = VitaminDEt.getText().toString().trim();
        productVitaminD3 = VitaminD3Et.getText().toString().trim();
        productVitaminE = VitaminEEt.getText().toString().trim();
        productVitaminK = VitaminKEt.getText().toString().trim();
        productVitaminK1 = VitaminK1Et.getText().toString().trim();
        productVitaminC = VitaminCEt.getText().toString().trim();
        productVitaminB1 = VitaminB1Et.getText().toString().trim();
        productVitaminB2 = VitaminB2Et.getText().toString().trim();
        productVitaminB6 = VitaminB6Et.getText().toString().trim();
        productVitaminB12 = VitaminB12Et.getText().toString().trim();
        productNiacin = NiacinEt.getText().toString().trim();
        productNiacinEquivalent = NiacinEquivalentEt.getText().toString().trim();
        productFolicAcid = FolicAcidEt.getText().toString().trim();
        productBiotin = BiotinEt.getText().toString().trim();
        productPantothenicAcid = PantothenicAcidEt.getText().toString().trim();
        productSodium = SodiumEt.getText().toString().trim();
        productPotassium = PotassiumEt.getText().toString().trim();
        productChloride = ChlorideEt.getText().toString().trim();
        productCalcium = CalciumEt.getText().toString().trim();
        productPhosphorus = PhosphorusEt.getText().toString().trim();
        productMagnesium = MagnesiumEt.getText().toString().trim();
        productIron = IronEt.getText().toString().trim();
        productZinc = ZincEt.getText().toString().trim();
        productManganese = ManganeseEt.getText().toString().trim();
        productCopper = CopperEt.getText().toString().trim();
        productIodine = IodineEt.getText().toString().trim();
        productSelenium = SeleniumEt.getText().toString().trim();
        productChromium = ChromiumEt.getText().toString().trim();
        productMolybdenum = MolybdenumEt.getText().toString().trim();
        productWater = WaterEt.getText().toString().trim();

        productIsoleucine = IsoleucineEt.getText().toString().trim();
        productLeucine = LeucineEt.getText().toString().trim();
        productLysine = LysineEt.getText().toString().trim();
        productMethionine = MethionineEt.getText().toString().trim();
        productPhenylalanine = PhenylalanineEt.getText().toString().trim();
        productThreonine = ThreonineEt.getText().toString().trim();
        productTryptophan = TryptophanEt.getText().toString().trim();
        productValine = ValineEt.getText().toString().trim();
        productHistidine = HistidineEt.getText().toString().trim();
        productAlanine = AlanineEt.getText().toString().trim();
        productArginine = ArginineEt.getText().toString().trim();
        productAsparticAcid = AsparticAcidEt.getText().toString().trim();
        productCysteine = CysteineEt.getText().toString().trim();
        productGlutamicAcid = GlutamicAcidEt.getText().toString().trim();
        productGlycine = GlycineEt.getText().toString().trim();
        productProline = ProlineEt.getText().toString().trim();
        productSerine = SerineEt.getText().toString().trim();
        productTyrosine = TyrosineEt.getText().toString().trim();
        productHydroxyLysine = HydroxyLysineEt.getText().toString().trim();
        productHydroxyProline = HydroxyProlineEt.getText().toString().trim();

        productAmountUnit = AmountUnit.getText().toString().trim();
        productEnergyUnit = EnergyUnit.getText().toString().trim();
        productProteinUnit = ProteinUnit.getText().toString().trim();

        productFatUnit = FatUnit.getText().toString().trim();
        productMUFAUnit = MUFAUnit.getText().toString().trim();
        productPUFAUnit = PUFAUnit.getText().toString().trim();
        productLinoleicAcidOmega6Unit = LinoleicUnit.getText().toString().trim();
        productαlinolenicAcidOmega3Unit = LinoAcidUnit.getText().toString().trim();
        productEPAUnit = EPAUnit.getText().toString().trim();
        productDHAUnit = DHAUnit.getText().toString().trim();
        productSFAUnit = SFAUnit.getText().toString().trim();
        productMCTOilUnit = MCToilUnit.getText().toString().trim();
        productTransFattyAcidsUnit = TransUnit.getText().toString().trim();
        productCholesterolUnit = CholesterolUnit.getText().toString().trim();
        productCarbohydrateUnit = CarbohydrateUnit.getText().toString().trim();
        productSaltUnit = SaltUnit.getText().toString().trim();
        productLactoseUnit = LactoseUnit.getText().toString().trim();
        productPolyolsUnit = PolyolsUnit.getText().toString().trim();
        productFiberUnit = FiberUnit.getText().toString().trim();
        productFOSUnit = FOSUnit.getText().toString().trim();
        productDietaryFiberUnit = DietaryFiberUnit.getText().toString().trim();
        productSolubleFiberUnit = SolubleFiberUnit.getText().toString().trim();
        productSugarUnit = SugarUnit.getText().toString().trim();
        productEssentialAminoAcidsUnit = EssentialAminoAcidsUnit.getText().toString().trim();
        productBranchedChainAminoAcidsUnit = BranchedChainAminoAcidsUnit.getText().toString().trim();
        productInulinUnit = InulinUnit.getText().toString().trim();
        productCholineUnit = CholineUnit.getText().toString().trim();
        productTaurineUnit = TaurineUnit.getText().toString().trim();
        productCarnitineUnit = CarnitineUnit.getText().toString().trim();
        productLCarnitineUnit = LCarnitineUnit.getText().toString().trim();
        productCaHMBUnit = CaHMBUnit.getText().toString().trim();
        productHMBUnit = HMBUnit.getText().toString().trim();
        productInositolUnit = InositolUnit.getText().toString().trim();
        productαLactalbuminUnit = αLactalbuminUnit.getText().toString().trim();
        productβLactoglobulinUnit = βLactoglobulinUnit.getText().toString().trim();
        productGlycomacropeptideUnit = GlycomacropeptideUnit.getText().toString().trim();
        productImmunoglobulinGIgGUnit = ImmunoglobulinGIgGUnit.getText().toString().trim();
        productBovineSerumAlbuminUnit = BovineSerumAlbuminUnit.getText().toString().trim();
        productProteasePeptone5Unit = ProteasePeptone5Unit.getText().toString().trim();
        productVitaminAUnit = VitaminAUnit.getText().toString().trim();
        productVitaminAPalmitateUnit = VitaminA1Unit.getText().toString().trim();
        productVitaminABCaroteneUnit = VitaminA2Unit.getText().toString().trim();
        productVitaminDUnit = VitaminDUnit.getText().toString().trim();
        productVitaminD3Unit = VitaminD3Unit.getText().toString().trim();
        productVitaminEUnit = VitaminEUnit.getText().toString().trim();
        productVitaminKUnit = VitaminKUnit.getText().toString().trim();
        productVitaminK1Unit = VitaminK1Unit.getText().toString().trim();
        productVitaminCUnit = VitaminCUnit.getText().toString().trim();
        productVitaminB1Unit = VitaminB1Unit.getText().toString().trim();
        productVitaminB2Unit = VitaminB2Unit.getText().toString().trim();
        productVitaminB6Unit = VitaminB6Unit.getText().toString().trim();
        productVitaminB12Unit = VitaminB12Unit.getText().toString().trim();
        productNiacinUnit = NiacinUnit.getText().toString().trim();
        productNiacinEquivalentUnit = NiacinEquivalentUnit.getText().toString().trim();
        productFolicAcidUnit = FolicAcidUnit.getText().toString().trim();
        productBiotinUnit = BiotinUnit.getText().toString().trim();
        productPantothenicAcidUnit = PantothenicAcidUnit.getText().toString().trim();
        productSodiumUnit = SodiumUnit.getText().toString().trim();
        productPotassiumUnit = PotassiumUnit.getText().toString().trim();
        productChlorideUnit = ChlorideUnit.getText().toString().trim();
        productCalciumUnit = CalciumUnit.getText().toString().trim();
        productPhosphorusUnit = PhosphorusUnit.getText().toString().trim();
        productMagnesiumUnit = MagnesiumUnit.getText().toString().trim();
        productIronUnit = IronUnit.getText().toString().trim();
        productZincUnit = ZincUnit.getText().toString().trim();
        productManganeseUnit = ManganeseUnit.getText().toString().trim();
        productCopperUnit = CopperUnit.getText().toString().trim();
        productIodineUnit = IodineUnit.getText().toString().trim();
        productSeleniumUnit = SeleniumUnit.getText().toString().trim();
        productChromiumUnit = ChromiumUnit.getText().toString().trim();
        productMolybdenumUnit = MolybdenumUnit.getText().toString().trim();
        productWaterUnit = WaterUnit.getText().toString().trim();

        productIsoleucineUnit = IsoleucineUnit.getText().toString().trim();
        productLeucineUnit = LeucineUnit.getText().toString().trim();
        productLysineUnit = LysineUnit.getText().toString().trim();
        productMethionineUnit = MethionineUnit.getText().toString().trim();
        productPhenylalanineUnit = PhenylalanineUnit.getText().toString().trim();
        productThreonineUnit = ThreonineUnit.getText().toString().trim();
        productTryptophanUnit = TryptophanUnit.getText().toString().trim();
        productValineUnit = ValineUnit.getText().toString().trim();
        productHistidineUnit = HistidineUnit.getText().toString().trim();
        productAlanineUnit = AlanineUnit.getText().toString().trim();
        productArginineUnit = ArginineUnit.getText().toString().trim();
        productAsparticAcidUnit = AsparticAcidUnit.getText().toString().trim();
        productCysteineUnit = CysteineUnit.getText().toString().trim();
        productGlutamicAcidUnit = GlutamicAcidUnit.getText().toString().trim();
        productGlycineUnit = GlycineUnit.getText().toString().trim();
        productProlineUnit = ProlineUnit.getText().toString().trim();
        productSerineUnit = SerineUnit.getText().toString().trim();
        productTyrosineUnit = TyrosineUnit.getText().toString().trim();
        productHydroxyLysineUnit = HydroxyLysineUnit.getText().toString().trim();
        productHydroxyProlineUnit = HydroxyProlineUnit.getText().toString().trim();


        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("productName", "" + productName_);
        hashMap.put("productCompany", "" + productCompany_);
        hashMap.put("productDescription", "" + productDescription_);
        hashMap.put("productIndication", "" + productIndications_);
        hashMap.put("productIngredient", "" + productIngredients_);
        hashMap.put("productAvailability", "" + productAvailability_);
        hashMap.put("productRetailPrice", "" + productRetailPrice_);

        hashMap.put("productSpecialFeatures", "" + productSpecial_);
        hashMap.put("productPackSize", "" + productPackSize_);
        hashMap.put("productServingSize", "" + productServingSize_);
        hashMap.put("productOtherInfo", "" + productOtherInfo_);
        hashMap.put("productCalorie", "" + productCalorie_);
        hashMap.put("productStorage", "" + productStorage_);

        hashMap.put("productAmount", "" +  productAmount);
        hashMap.put("productAmountUnit", "" +  productAmountUnit);
        hashMap.put("productAmountType", "" + productAmountType);

        hashMap.put("productEnergy", "" + productEnergy);
        hashMap.put("productEnergyUnit", "" + productEnergy  + " " +  productEnergyUnit);

        hashMap.put("productProtein", "" + productProtein);
        hashMap.put("productProteinUnit", "" + productProtein  + " " +  productProteinUnit);

        hashMap.put("productFat", "" + productFat);
        hashMap.put("productFatUnit", "" + productFat  + " " +  productFatUnit);

        hashMap.put("productMUFA", "" + productMUFA);
        hashMap.put("productMUFAUnit", "" + productMUFA  + " " +  productMUFAUnit);

        hashMap.put("productPUFA", "" + productPUFA);
        hashMap.put("productPUFAUnit", "" + productPUFA  + " " +  productPUFAUnit);

        hashMap.put("productLinoleicAcidOmega6", "" + productLinoleicAcidOmega6);
        hashMap.put("productLinoleicAcidOmega6Unit", "" + productLinoleicAcidOmega6  + " " +  productLinoleicAcidOmega6Unit);

        hashMap.put("productαlinolenicAcidOmega3", "" + productαlinolenicAcidOmega3);
        hashMap.put("productαlinolenicAcidOmega3Unit", "" + productαlinolenicAcidOmega3  + " " +  productαlinolenicAcidOmega3Unit);

        hashMap.put("productEPA", "" + productEPA);
        hashMap.put("productEPAUnit", "" + productEPA  + " " +  productEPAUnit);

        hashMap.put("productDHA", "" + productDHA);
        hashMap.put("productDHAUnit", "" + productDHA  + " " +  productDHAUnit);

        hashMap.put("productSFA", "" + productSFA);
        hashMap.put("productSFAUnit", "" + productSFA  + " " +  productSFAUnit);

        hashMap.put("productMCTOil", "" + productMCTOil);
        hashMap.put("productMCTOilUnit", "" + productMCTOil  + " " +  productMCTOilUnit);

        hashMap.put("productTransFattyAcids", "" + productTransFattyAcids);
        hashMap.put("productTransFattyAcidsUnit", "" + productTransFattyAcids  + " " +  productTransFattyAcidsUnit);

        hashMap.put("productCholesterol", "" + productCholesterol);
        hashMap.put("productCholesterolUnit", "" + productCholesterol  + " " +  productCholesterolUnit);

        hashMap.put("productCarbohydrate", "" + productCarbohydrate);
        hashMap.put("productCarbohydrateUnit", "" + productCarbohydrate  + " " +  productCarbohydrateUnit);

        hashMap.put("productSalt", "" + productSalt);
        hashMap.put("productSaltUnit", "" + productSalt  + " " +  productSaltUnit);

        hashMap.put("productLactose", "" + productLactose);
        hashMap.put("productLactoseUnit", "" + productLactose  + " " +  productLactoseUnit);

        hashMap.put("productPolyols", "" + productPolyols);
        hashMap.put("productPolyolsUnit", "" + productPolyols  + " " +  productPolyolsUnit);

        hashMap.put("productFiber", "" + productFiber);
        hashMap.put("productFiberUnit", "" + productFiber  + " " +  productFiberUnit);

        hashMap.put("productFOS", "" + productFOS);
        hashMap.put("productFOSUnit", "" + productFOS  + " " +  productFOSUnit);

        hashMap.put("productDietaryFiber", "" + productDietaryFiber);
        hashMap.put("productDietaryFiberUnit", "" + productDietaryFiber  + " " +  productDietaryFiberUnit);

        hashMap.put("productSolubleFiber", "" + productSolubleFiber);
        hashMap.put("productSolubleFiberUnit", "" + productSolubleFiber  + " " +  productSolubleFiberUnit);

        hashMap.put("productSugar", "" + productSugar);
        hashMap.put("productSugarUnit", "" + productSugar  + " " +  productSugarUnit);

        hashMap.put("productEssentialAminoAcids", "" + productEssentialAminoAcids);
        hashMap.put("productEssentialAminoAcidsUnit", "" + productEssentialAminoAcids  + " " +  productEssentialAminoAcidsUnit);

        hashMap.put("productBranchedChainAminoAcids", "" + productBranchedChainAminoAcids);
        hashMap.put("productBranchedChainAminoAcidsUnit", "" + productBranchedChainAminoAcids  + " " +  productBranchedChainAminoAcidsUnit);

        hashMap.put("productInulin", "" + productInulin);
        hashMap.put("productInulinUnit", "" + productInulin  + " " +  productInulinUnit);

        hashMap.put("productCholine", "" + productCholine);
        hashMap.put("productCholineUnit", "" + productCholine  + " " +  productCholineUnit);

        hashMap.put("productTaurine", "" + productTaurine);
        hashMap.put("productTaurineUnit", "" + productTaurine  + " " +  productTaurineUnit);

        hashMap.put("productCarnitine", "" + productCarnitine);
        hashMap.put("productCarnitineUnit", "" + productCarnitine  + " " +  productCarnitineUnit);

        hashMap.put("productLCarnitine", "" + productLCarnitine);
        hashMap.put("productLCarnitineUnit", "" + productLCarnitine  + " " +  productLCarnitineUnit);

        hashMap.put("productCaHMB", "" + productCaHMB);
        hashMap.put("productCaHMBUnit", "" + productCaHMB  + " " +  productCaHMBUnit);

        hashMap.put("productHMB", "" + productHMB);
        hashMap.put("productHMBUnit", "" + productHMB  + " " +  productHMBUnit);

        hashMap.put("productInositol", "" + productInositol);
        hashMap.put("productInositolUnit", "" + productInositol  + " " +  productInositolUnit);

        //***************************************************************************************

        hashMap.put("productαLactalbumin", "" + productαLactalbumin);
        hashMap.put("productαLactalbuminUnit", "" + productαLactalbumin  + " " +  productαLactalbuminUnit);

        hashMap.put("productβLactoglobulin", "" + productβLactoglobulin);
        hashMap.put("productβLactoglobulinUnit", "" + productβLactoglobulin  + " " +  productβLactoglobulinUnit);

        hashMap.put("productGlycomacropeptide", "" + productGlycomacropeptide);
        hashMap.put("productGlycomacropeptideUnit", "" + productGlycomacropeptide  + " " +  productGlycomacropeptideUnit);

        hashMap.put("productImmunoglobulinGIgG", "" + productImmunoglobulinGIgG);
        hashMap.put("productImmunoglobulinGIgGUnit", "" + productImmunoglobulinGIgG  + " " +  productImmunoglobulinGIgGUnit);

        hashMap.put("productBovineSerumAlbumin", "" + productBovineSerumAlbumin);
        hashMap.put("productBovineSerumAlbuminUnit", "" + productBovineSerumAlbumin  + " " +  productBovineSerumAlbuminUnit);

        hashMap.put("productProteasePeptone5", "" + productProteasePeptone5);
        hashMap.put("productProteasePeptone5Unit", "" + productProteasePeptone5  + " " +  productProteasePeptone5Unit);

        //***************************************************************************************

        hashMap.put("productVitaminA", "" + productVitaminA);
        hashMap.put("productVitaminAUnit", "" + productVitaminA  + " " +  productVitaminAUnit);

        hashMap.put("productVitaminAPalmitate", "" + productVitaminAPalmitate);
        hashMap.put("productVitaminAPalmitateUnit", "" + productVitaminAPalmitate  + " " +  productVitaminAPalmitateUnit);

        hashMap.put("productVitaminABCarotene", "" + productVitaminABCarotene);
        hashMap.put("productVitaminABCaroteneUnit", "" + productVitaminABCarotene  + " " +  productVitaminABCaroteneUnit);

        hashMap.put("productVitaminD", "" + productVitaminD);
        hashMap.put("productVitaminDUnit", "" + productVitaminD  + " " +  productVitaminDUnit);

        hashMap.put("productVitaminD3", "" + productVitaminD3);
        hashMap.put("productVitaminD3Unit", "" + productVitaminD3  + " " +  productVitaminD3Unit);

        hashMap.put("productVitaminE", "" + productVitaminE);
        hashMap.put("productVitaminEUnit", "" + productVitaminE  + " " +  productVitaminEUnit);

        hashMap.put("productVitaminK", "" + productVitaminK);
        hashMap.put("productVitaminKUnit", "" + productVitaminK  + " " +  productVitaminKUnit);

        hashMap.put("productVitaminK1", "" + productVitaminK1);
        hashMap.put("productVitaminK1Unit", "" + productVitaminK1  + " " +  productVitaminK1Unit);

        hashMap.put("productVitaminC", "" + productVitaminC);
        hashMap.put("productVitaminCUnit", "" + productVitaminC  + " " +  productVitaminCUnit);

        hashMap.put("productVitaminB1", "" + productVitaminB1);
        hashMap.put("productVitaminB1Unit", "" + productVitaminB1  + " " +  productVitaminB1Unit);

        hashMap.put("productVitaminB2", "" + productVitaminB2);
        hashMap.put("productVitaminB2Unit", "" + productVitaminB2  + " " +  productVitaminB2Unit);

        hashMap.put("productVitaminB6", "" + productVitaminB6);
        hashMap.put("productVitaminB6Unit", "" + productVitaminB6  + " " + productVitaminB6Unit);

        hashMap.put("productVitaminB12", "" + productVitaminB12);
        hashMap.put("productVitaminB12Unit", "" + productVitaminB12  + " " +  productVitaminB12Unit);

        hashMap.put("productNiacin", "" + productNiacin);
        hashMap.put("productNiacinUnit", "" + productNiacin  + " " +  productNiacinUnit);

        hashMap.put("productNiacinEquivalent", "" + productNiacinEquivalent);
        hashMap.put("productNiacinEquivalentUnit", "" + productNiacinEquivalent  + " " +  productNiacinEquivalentUnit);

        hashMap.put("productFolicAcid", "" + productFolicAcid);
        hashMap.put("productFolicAcidUnit", "" + productFolicAcid  + " " +  productFolicAcidUnit);

        hashMap.put("productBiotin", "" + productBiotin);
        hashMap.put("productBiotinUnit", "" + productBiotin  + " " +  productBiotinUnit);

        hashMap.put("productPantothenicAcid", "" + productPantothenicAcid);
        hashMap.put("productPantothenicAcidUnit", "" + productPantothenicAcid  + " " +  productPantothenicAcidUnit);

        //***************************************************************************************

        hashMap.put("productSodium", "" + productSodium);
        hashMap.put("productSodiumUnit", "" + productSodium  + " " +  productSodiumUnit);

        hashMap.put("productPotassium", "" + productPotassium);
        hashMap.put("productPotassiumUnit", "" + productPotassium  + " " +  productPotassiumUnit);

        hashMap.put("productChloride", "" + productChloride);
        hashMap.put("productChlorideUnit", "" + productChloride  + " " +  productChlorideUnit);

        hashMap.put("productCalcium", "" + productCalcium);
        hashMap.put("productCalciumUnit", "" + productCalcium  + " " +  productCalciumUnit);

        hashMap.put("productPhosphorus", "" + productPhosphorus);
        hashMap.put("productPhosphorusUnit", "" + productPhosphorus  + " " +  productPhosphorusUnit);

        hashMap.put("productMagnesium", "" + productMagnesium);
        hashMap.put("productMagnesiumUnit", "" + productMagnesium  + " " +  productMagnesiumUnit);

        hashMap.put("productIron", "" + productIron);
        hashMap.put("productIronUnit", "" + productIron  + " " +  productIronUnit);

        hashMap.put("productZinc", "" + productZinc);
        hashMap.put("productZincUnit", "" + productZinc  + " " +  productZincUnit);

        hashMap.put("productManganese", "" + productManganese);
        hashMap.put("productManganeseUnit", "" + productManganese  + " " +  productManganeseUnit);

        hashMap.put("productCopper", "" + productCopper);
        hashMap.put("productCopperUnit", "" + productCopper  + " " +  productCopperUnit);

        hashMap.put("productIodine", "" + productIodine);
        hashMap.put("productIodineUnit", "" + productIodine  + " " +  productIodineUnit);

        hashMap.put("productSelenium", "" + productSelenium);
        hashMap.put("productSeleniumUnit", "" + productSelenium  + " " +  productSeleniumUnit);

        hashMap.put("productChromium", "" + productChromium);
        hashMap.put("productChromiumUnit", "" + productChromium  + " " +  productChromiumUnit);

        hashMap.put("productMolybdenum", "" + productMolybdenum);
        hashMap.put("productMolybdenumUnit", "" + productMolybdenum  + " " +  productMolybdenumUnit);

        hashMap.put("productWater", "" + productWater);
        hashMap.put("productWaterUnit", "" + productWater  + " " +  productWaterUnit);
//          //***************************************************************************************

        hashMap.put("productIsoleucine", "" + productIsoleucine);
        hashMap.put("productIsoleucineUnit", "" + productIsoleucine  + " " +  productIsoleucineUnit);

        hashMap.put("productLeucine", "" + productLeucine);
        hashMap.put("productLeucineUnit", "" + productLeucine  + " " +  productLeucineUnit);

        hashMap.put("productLysine", "" + productLysine);
        hashMap.put("productLysineUnit", "" + productLysine  + " " +  productLysineUnit);

        hashMap.put("productMethionine", "" + productMethionine);
        hashMap.put("productMethionineUnit", "" + productMethionine  + " " +  productMethionineUnit);

        hashMap.put("productPhenylalanine", "" + productPhenylalanine);
        hashMap.put("productPhenylalanineUnit", "" + productPhenylalanine  + " " +  productPhenylalanineUnit);

        hashMap.put("productThreonine", "" + productThreonine);
        hashMap.put("productThreonineUnit", "" + productThreonine  + " " +  productThreonineUnit);

        hashMap.put("productTryptophan", "" + productTryptophan);
        hashMap.put("productTryptophanUnit", "" + productTryptophan  + " " +  productTryptophanUnit);

        hashMap.put("productValine", "" + productValine);
        hashMap.put("productValineUnit", "" + productValine  + " " +  productValineUnit);

        hashMap.put("productHistidine", "" + productHistidine);
        hashMap.put("productHistidineUnit", "" + productHistidine  + " " +  productHistidineUnit);

        hashMap.put("productAlanine", "" + productAlanine);
        hashMap.put("productAlanineUnit", "" + productAlanine  + " " +  productAlanineUnit);

        hashMap.put("productArginine", "" + productArginine);
        hashMap.put("productArginineUnit", "" + productArginine  + " " +  productArginineUnit);

        hashMap.put("productAsparticAcid", "" + productAsparticAcid);
        hashMap.put("productAsparticAcidUnit", "" + productAsparticAcid  + " " +  productAsparticAcidUnit);

        hashMap.put("productCysteine", "" + productCysteine);
        hashMap.put("productCysteineUnit", "" + productCysteine  + " " +  productCysteineUnit);

        hashMap.put("productGlutamicAcid", "" + productGlutamicAcid);
        hashMap.put("productGlutamicAcidUnit", "" + productGlutamicAcid  + " " +  productGlutamicAcidUnit);

        hashMap.put("productGlycine", "" + productGlycine);
        hashMap.put("productGlycineUnit", "" + productGlycine  + " " +  productGlycineUnit);

        hashMap.put("productProline", "" + productProline);
        hashMap.put("productProlineUnit", "" + productProline  + " " +  productProlineUnit);

        hashMap.put("productSerine", "" + productSerine);
        hashMap.put("productSerineUnit", "" + productSerine  + " " +  productSerineUnit);

        hashMap.put("productTyrosine", "" + productTyrosine);
        hashMap.put("productTyrosineUnit", "" + productTyrosine  + " " +  productTyrosineUnit);

        hashMap.put("productHydroxyLysine", "" + productHydroxyLysine);
        hashMap.put("productHydroxyLysineUnit", "" + productHydroxyLysine  + " " +  productHydroxyLysineUnit);

        hashMap.put("productHydroxyProline", "" + productHydroxyProline);
        hashMap.put("productHydroxyProlineUnit", "" + productHydroxyProline  + " " +  productHydroxyProlineUnit);


        //update to db
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Products");
        databaseReference.child(productId).updateChildren(hashMap)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        //update successfully
                        progressDialog.dismiss();
                        Toast.makeText(ProductEditActivity.this, "Profile updated", Toast.LENGTH_SHORT).show();
                        addToNotifications("update");

                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        //update failed
                        progressDialog.dismiss();
                        Toast.makeText(ProductEditActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                });




//        String filePathAndName  = "ProductImages/" + "" + productId;
//        StorageReference storageReference = FirebaseStorage.getInstance().getReference(filePathAndName);
//        storageReference.putFile(image_uri)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//                        //success uploading image
//                        //get url of uploaded image
//                        Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
//                        while (!uriTask.isSuccessful());
//                        Uri downloadImageUri = uriTask.getResult();
//
//                        if(uriTask.isSuccessful()){
//                            //url of image received, upload to db
//
//                            HashMap<String,Object> hashMap = new HashMap<>();
//                            hashMap.put("productIcon", "" + downloadImageUri);
//                            hashMap.put("productName", "" + productName_);
//                            hashMap.put("productCompany", "" + productCompany_);
//                            hashMap.put("productDescription", "" + productDescription);
//                            hashMap.put("productIndication", "" + productIndications);
//                            hashMap.put("productIngredient", "" + productIngredients);
//                            hashMap.put("productAvailability", "" + productAvailability);
//                            hashMap.put("productRetailPrice", "" + productRetailPrice);
//
//                            //update to db
//                            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Products");
//                            databaseReference.child(productId).updateChildren(hashMap)
//                                    .addOnSuccessListener(new OnSuccessListener<Void>() {
//                                        @Override
//                                        public void onSuccess(Void unused) {
//                                            //update successfully
//                                            progressDialog.dismiss();
//                                            Toast.makeText(ProductEditActivity.this, "Profile updated", Toast.LENGTH_SHORT).show();
//                                        }
//                                    })
//                                    .addOnFailureListener(new OnFailureListener() {
//                                        @Override
//                                        public void onFailure(@NonNull Exception e) {
//                                            //update failed
//                                            progressDialog.dismiss();
//                                            Toast.makeText(ProductEditActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                                        }
//                                    });
//                        }
//                    }
//                })
//                .addOnFailureListener(new OnFailureListener() {
//                    @Override
//                    public void onFailure(@NonNull Exception e) {
//                        //failed uploading image
//                        progressDialog.dismiss();
//                        Toast.makeText(ProductEditActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
//
//                    }
//                });


    }
    private void showImagePickDialog() {
        //options to display in dialog
//        String[] options = {"Camera", "Gallery"};
        String[] options = {"Gallery"};


        //dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Pick Image")
                .setItems(options, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        if(which==0){
                            //gallery clicked
                            if (checkStoragePermission()){
                                //permission granted
                                pickFromGallery();
                            }else {
                                //permission not granted, request
                                requestStoragePermission();
                            }
                        }

//                        if(which==0){
//                            //camera clicked
//                            if(checkCameraPermission()){
//                                pickFromCamera();
//                            }else{
//                                //permission not granted, request
//                                requestCameraPermission();
//                            }
//                        }else{
//                            //gallery clicked
//                            if (checkStoragePermission()){
//                                //permission granted
//                                pickFromGallery();
//                            }else {
//                                //permission not granted, request
//                                requestStoragePermission();
//                            }
//                        }
                    }
                })
                .show();
    }

    private void pickFromGallery() {
        //intent to pick image from gallery
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, IMAGE_PICK_GALLERY_CODE);
    }

    private void pickFromCamera() {
        //intent to pick image from camera

        //using media store to pick high/original quality image
        ContentValues contentValues = new ContentValues();
        contentValues.put(MediaStore.Images.Media.TITLE,"Temp_image_title");
        contentValues.put(MediaStore.Images.Media.DESCRIPTION,"Temp_image_description");

        image_uri = getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI,contentValues);

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT,image_uri);
        startActivityForResult(intent, IMAGE_PICK_CAMERA_CODE);
    }

    private boolean checkStoragePermission(){
        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE ) ==
                (PackageManager.PERMISSION_GRANTED );
        return result;
    }

    private void requestStoragePermission(){
        ActivityCompat.requestPermissions(this, storagePermissions,STORAGE_REQUEST_CODE);
    }

    private boolean checkCameraPermission(){
        boolean result = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                (PackageManager.PERMISSION_GRANTED );
        boolean result1 = ContextCompat.checkSelfPermission(this,Manifest.permission.WRITE_EXTERNAL_STORAGE) ==
                (PackageManager.PERMISSION_GRANTED );

        return result && result1;
    }

    private void requestCameraPermission(){
        ActivityCompat.requestPermissions(this, cameraPermissions,CAMERA_REQUEST_CODE);
    }

    //handle permission results
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case CAMERA_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    boolean cameraAccepted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (cameraAccepted && storageAccepted) {
                        //both permission granted
                        pickFromCamera();
                    } else {
                        //both or one permission denied
                        Toast.makeText(this, "Camera & Storage permissions are required... ", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            case STORAGE_REQUEST_CODE: {
                if (grantResults.length > 0) {
                    boolean storageAccepted = grantResults[1] == PackageManager.PERMISSION_GRANTED;
                    if (storageAccepted) {
                        //both permission granted
                        pickFromGallery();
                    } else {
                        //both or one permission denied
                        Toast.makeText(this, "Storage permissions are required... ", Toast.LENGTH_SHORT).show();
                    }
                }
            }

            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

    //handle image pick results
    @Override
    protected void onActivityResult (int requestCode, int resultCode,  Intent data){
        if (resultCode == RESULT_OK) {
            if (requestCode == IMAGE_PICK_GALLERY_CODE) {
                //image picked from gallery
                //save picked image uri
                image_uri = data.getData();

                //set image
                productIconIv.setImageURI(image_uri);
            } else {
                if (requestCode == IMAGE_PICK_CAMERA_CODE) {
                    //image picked from camera
                    productIconIv.setImageURI(image_uri);
                }
            }
        }

        super.onActivityResult(requestCode, resultCode, data);

    }


}