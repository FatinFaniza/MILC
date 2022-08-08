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
import android.text.TextUtils;
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
import com.google.android.gms.tasks.Task;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;

public class AddProductActivity extends AppCompatActivity {

    ScrollView scrollView;
    FloatingActionButton scrollUp,scrollDown;
    private ImageView productIconIv;
    private TextView categoryEt,subcategoryEt;
    private EditText nameEt,descriptionEt,companyEt,indicationsEt,ingredientsEt,availabilityEt,retailPriceEt;
    private EditText specialEt,packSizeEt,servingSizeEt,otherInfoEt,calorieEt,storageEt,uploadPDFNameEt;
    private Button addProductBtn;
//    private Button uploadPDFBtn,searchPDFBtn;
    private SwitchCompat specialSwitch,packSizeSwitch,servingSizeSwitch,otherInfoSwitch,calorieSwitch,storageSwitch,uploadPDFSwitch;

    private TextView AmountType;
    private TextView AmountUnit,EnergyUnit,ProteinUnit;
    private TextView FatUnit,MUFAUnit,PUFAUnit,LinoleicUnit,LinoAcidUnit,EPAUnit,DHAUnit,SFAUnit,MCToilUnit,TransUnit;
    private TextView CholesterolUnit,CarbohydrateUnit,SaltUnit,LactoseUnit,PolyolsUnit,FiberUnit,FOSUnit,DietaryFiberUnit,SolubleFiberUnit,SugarUnit;
    private TextView EssentialAminoAcidsUnit,BranchedChainAminoAcidsUnit,InulinUnit,CholineUnit,TaurineUnit,CarnitineUnit,LCarnitineUnit,CaHMBUnit,HMBUnit,InositolUnit;

    private TextView VitaminAUnit,VitaminA1Unit,VitaminA2Unit,VitaminDUnit,VitaminD3Unit,VitaminEUnit,VitaminKUnit,VitaminK1Unit,VitaminCUnit,VitaminB1Unit;
    private TextView VitaminB2Unit,VitaminB6Unit,VitaminB12Unit,NiacinUnit,NiacinEquivalentUnit,FolicAcidUnit,BiotinUnit,PantothenicAcidUnit;

    private TextView SodiumUnit,PotassiumUnit,ChlorideUnit,CalciumUnit,PhosphorusUnit,MagnesiumUnit,IronUnit,ZincUnit,ManganeseUnit,CopperUnit;
    private TextView IodineUnit,SeleniumUnit,ChromiumUnit,MolybdenumUnit,WaterUnit;

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

    FirebaseAuth firebaseAuth;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        scrollView = findViewById(R.id.scrollView);
        scrollUp = findViewById(R.id.scrollUp);
        scrollDown = findViewById(R.id.scrollDown);

        productIconIv = findViewById(R.id.productIconIv);
        categoryEt  = findViewById(R.id.categoryEt);
        subcategoryEt = findViewById(R.id.subcategoryEt);
        nameEt = findViewById (R.id.nameEt);
        descriptionEt = findViewById(R.id.descriptionEt);
        companyEt = findViewById(R.id.companyEt);
        indicationsEt = findViewById(R.id.indicationsEt);
        ingredientsEt = findViewById(R.id.ingredientsEt);
        availabilityEt = findViewById(R.id.availabilityEt);
        retailPriceEt = findViewById(R.id.retailPriceEt);

        specialEt  = findViewById(R.id.specialEt);
        packSizeEt  = findViewById(R.id.packSizeEt);
        servingSizeEt  = findViewById(R.id.servingSizeEt);
        otherInfoEt  = findViewById(R.id.otherInfoEt);
        calorieEt  = findViewById(R.id.calorieEt);
        storageEt  = findViewById(R.id.storageEt);
//        uploadPDFNameEt  = findViewById(R.id.uploadPDFEt);
//        uploadPDFBtn  = findViewById(R.id.uploadPDFBtn);
//        searchPDFBtn  = findViewById(R.id.searchPDFBtn);

        specialEt.setVisibility(View.GONE);
        packSizeEt.setVisibility(View.GONE);
        servingSizeEt.setVisibility(View.GONE);
        otherInfoEt.setVisibility(View.GONE);
        calorieEt.setVisibility(View.GONE);
        storageEt.setVisibility(View.GONE);
//        uploadPDFNameEt.setVisibility(View.GONE);
////        uploadPDFBtn.setVisibility(View.GONE);
////        searchPDFBtn.setVisibility(View.GONE);
//
        specialSwitch  = findViewById(R.id.specialSwitch);
        packSizeSwitch  = findViewById(R.id.packSizeSwitch);
        servingSizeSwitch  = findViewById(R.id.servingSizeSwitch);
        otherInfoSwitch  = findViewById(R.id.otherInfoSwitch);
        calorieSwitch  = findViewById(R.id.calorieSwitch);
        storageSwitch  = findViewById(R.id.storageSwitch);
//        uploadPDFSwitch  = findViewById(R.id.uploadPDFSwitch);

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

        addProductBtn = findViewById(R.id.addProductBtn);

//        storageReference = FirebaseStorage.getInstance().getReference();
////        databaseReference = FirebaseDatabase.getInstance().getReference("uploadPDF");
//        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Users Info");
//
////        uploadPDFBtn.setEnabled(false);
//
////        searchPDFBtn.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                selectPDF();
////            }
////        });

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

        //init permission arrays
        cameraPermissions = new String[]{Manifest.permission.CAMERA,Manifest.permission.WRITE_EXTERNAL_STORAGE};
        storagePermissions = new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE};

        productIconIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //show dialog to pick image (either gallery or camera)
                showImagePickDialog();
            }
        });

//*******************************************************************************************************************************DROPDOWN

        addProductBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                //flow
//                //1. input data
//                //2. validate data
//                //3. add data to db
                inputData();
            }
        });

        categoryEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                categoryDialog();
            }
        });
        subcategoryEt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                subcategoryDialog();
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
        hashMap.put("productName", "" + productName);
        hashMap.put("productCompany", "" + productCompany);

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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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
                AlertDialog.Builder builder = new AlertDialog.Builder(AddProductActivity.this);
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

    String timestamp = ""+System.currentTimeMillis();
    boolean specialAvailable,packSizeAvailable,servingSizeAvailable,otherInfoAvailable,calorieAvailable,storageAvailable,PDFAvailable = false;

    String productName,productDescription,productCategory,productSubCategory,productCompany,productIndications,productIngredients,productAvailability, productRetailPrice;
    String productSpecial,productPackSize,productServingSize,productOtherInfo,productCalorie,productStorage,productPDF;

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


//    private void selectPDF() {
//
//        Intent intent = new Intent();
//        intent.setType("application/pdf");
//        intent.setAction(Intent.ACTION_GET_CONTENT);
//        startActivityForResult(Intent.createChooser(intent,"Select PDF File"),12);
//
//    }

    private void inputData() {
        //1. input data

        productName = nameEt.getText().toString().trim();
        productDescription = descriptionEt.getText().toString().trim();
        productCategory = categoryEt.getText().toString().trim();
        productSubCategory = subcategoryEt.getText().toString().trim();
        productCompany = companyEt.getText().toString().trim();
        productIndications = indicationsEt.getText().toString().trim();
        productIngredients = ingredientsEt.getText().toString().trim();
        productAvailability = availabilityEt.getText().toString().trim();
        productRetailPrice = retailPriceEt.getText().toString().trim();

        productSpecial = specialEt.getText().toString().trim();
        productPackSize = packSizeEt.getText().toString().trim();
        productServingSize = servingSizeEt.getText().toString().trim();
        productOtherInfo = otherInfoEt.getText().toString().trim();
        productCalorie = calorieEt.getText().toString().trim();
        productStorage= storageEt.getText().toString().trim();
//        productPDF= uploadPDFNameEt.getText().toString().trim();

        specialAvailable = specialSwitch.isChecked(); //true or false
        packSizeAvailable = packSizeSwitch.isChecked(); //true or false
        servingSizeAvailable = servingSizeSwitch.isChecked(); //true or false
        otherInfoAvailable = otherInfoSwitch.isChecked(); //true or false
        calorieAvailable = calorieSwitch.isChecked(); //true or false
        storageAvailable = storageSwitch.isChecked(); //true or false
//        PDFAvailable = uploadPDFSwitch.isChecked(); //true or false

        //2. validate data
        if(TextUtils.isEmpty(productCategory)){
            categoryEt.setError("Please choose product category.");
            Toast.makeText(AddProductActivity.this, "Please choose product category.", Toast.LENGTH_SHORT).show();
            categoryEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productSubCategory)){
            subcategoryEt.setError("Please choose product subcategory.");
            Toast.makeText(AddProductActivity.this, "Please choose product subcategory.", Toast.LENGTH_SHORT).show();
            subcategoryEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productName)){
            nameEt.setError("Please enter product name.");
            Toast.makeText(AddProductActivity.this, "Please enter product name.", Toast.LENGTH_SHORT).show();
            nameEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productDescription)){
            descriptionEt.setError("Please enter product description.");
            Toast.makeText(AddProductActivity.this, "Please enter product description.", Toast.LENGTH_SHORT).show();

            descriptionEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productCompany)){
            companyEt.setError("Please choose product Company.");
            Toast.makeText(AddProductActivity.this, "Please choose product Company.", Toast.LENGTH_SHORT).show();

            companyEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productIndications)){
            indicationsEt.setError("Please enter product indications.");
            Toast.makeText(AddProductActivity.this, "Please enter product indications.", Toast.LENGTH_SHORT).show();

            indicationsEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productIngredients)){
            ingredientsEt.setError("Please enter product ingredients.");
            Toast.makeText(AddProductActivity.this, "Please enter product ingredients.", Toast.LENGTH_SHORT).show();

            ingredientsEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productAvailability)){
            availabilityEt.setError("Please enter product availability.");
            Toast.makeText(AddProductActivity.this, "Please enter product availability.", Toast.LENGTH_SHORT).show();

            availabilityEt.requestFocus();
            return;
        }
        if(TextUtils.isEmpty(productRetailPrice)){
            retailPriceEt.setError("Please enter product retail price.");
            Toast.makeText(AddProductActivity.this, "Please enter product retail price.", Toast.LENGTH_SHORT).show();

            retailPriceEt.requestFocus();
            return;
        }

        if(specialAvailable){
            //product has special feature
            if(TextUtils.isEmpty(productSpecial)){
                specialEt.setError("Please enter product special feature.");
                Toast.makeText(AddProductActivity.this, "Please enter product special feature.", Toast.LENGTH_SHORT).show();

                specialEt.requestFocus();
                return; //don't proceed further
            }
            else {
                //without special feature
                productSpecial = "";
            }
        }
        if(packSizeAvailable){
            //product has special feature
            if(TextUtils.isEmpty(productPackSize)){
                packSizeEt.setError("Please enter product pack size.");
                Toast.makeText(AddProductActivity.this, "Please enter product pack size.", Toast.LENGTH_SHORT).show();

                packSizeEt.requestFocus();
                return; //don't proceed further
            }
            else {
                //without special feature
                productPackSize = "";
            }
        }
        if(servingSizeAvailable){
            //product has special feature
            if(TextUtils.isEmpty(productServingSize)){
                specialEt.setError("Please enter product serving size.");
                Toast.makeText(AddProductActivity.this, "Please enter product serving size.", Toast.LENGTH_SHORT).show();

                specialEt.requestFocus();
                return; //don't proceed further
            }
            else {
                //without special feature
                productServingSize = "";
            }
        }
        if(otherInfoAvailable){
            //product has special feature
            if(TextUtils.isEmpty(productOtherInfo)){
                otherInfoEt.setError("Please enter other product information (if have).");
                Toast.makeText(AddProductActivity.this, "Please enter other product information (if have).", Toast.LENGTH_SHORT).show();

                otherInfoEt.requestFocus();
                return; //don't proceed further
            }
            else {
                //without special feature
                productOtherInfo = "";
            }
        }
        if(calorieAvailable){
            //product has special feature
            if(TextUtils.isEmpty(productCalorie)){
                calorieEt.setError("Please enter product equivalent calorie and serving size.");
                Toast.makeText(AddProductActivity.this, "Please enter product equivalent calorie and serving size.", Toast.LENGTH_SHORT).show();

                calorieEt.requestFocus();
                return; //don't proceed further
            }
            else {
                //without special feature
                productCalorie = "";
            }
        }
        if(storageAvailable){
            //product has special feature
            if(TextUtils.isEmpty(productStorage)){
                storageEt.setError("Please enter product storage information.");
                Toast.makeText(AddProductActivity.this, "Please enter product storage information.", Toast.LENGTH_SHORT).show();

                storageEt.requestFocus();
                return; //don't proceed further
            }
            else {
                //without special feature
                productStorage = "";
            }
        }

        addProduct();

    }

    private void addProduct() {
        //3. add data to db

        final ProgressDialog progressDialog = new ProgressDialog(this);
        progressDialog.setTitle("Uploading...");
        progressDialog.show();

        productName = nameEt.getText().toString().trim();
        productDescription = descriptionEt.getText().toString().trim();
        productCategory = categoryEt.getText().toString().trim();
        productSubCategory = subcategoryEt.getText().toString().trim();
        productCompany = companyEt.getText().toString().trim();
        productIndications = indicationsEt.getText().toString().trim();
        productIngredients = ingredientsEt.getText().toString().trim();
        productAvailability = availabilityEt.getText().toString().trim();
        productRetailPrice = retailPriceEt.getText().toString().trim();

        productSpecial = specialEt.getText().toString().trim();
        productPackSize = packSizeEt.getText().toString().trim();
        productServingSize = servingSizeEt.getText().toString().trim();
        productOtherInfo = otherInfoEt.getText().toString().trim();
        productCalorie = calorieEt.getText().toString().trim();
        productStorage= storageEt.getText().toString().trim();
//        productPDF = uploadPDFNameEt.getText().toString().trim();

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

        if(image_uri == null){
            //upload without image
            //setup data to save (replace cara kat user class)

            HashMap<String,Object> hashMap = new HashMap<>();
            hashMap.put("companyId", "" + firebaseAuth.getUid());
            hashMap.put("productId", "" + timestamp);
            hashMap.put("productName", "" + productName);
            hashMap.put("productDescription", "" + productDescription);
            hashMap.put("productCategory", "" + productCategory);
            hashMap.put("productSubCategory", "" + productSubCategory);
            hashMap.put("productIcon", "");
            hashMap.put("productCompany", "" + productCompany);
            hashMap.put("productIndication", "" + productIndications);
            hashMap.put("productIngredient", "" + productIngredients);
            hashMap.put("productAvailability", "" + productAvailability);
            hashMap.put("productRetailPrice", "" + productRetailPrice);
            hashMap.put("productSpecialFeatures", "" + productSpecial);
            hashMap.put("productPackSize", "" + productPackSize);
            hashMap.put("productServingSize", "" + productServingSize);
            hashMap.put("productOtherInfo", "" + productOtherInfo);
            hashMap.put("productCalorie", "" + productCalorie);
            hashMap.put("productStorage", "" + productStorage);
//            hashMap.put("productPDF", "" + productCalorie);

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

            DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Products");
            databaseReference.child(timestamp).setValue(hashMap)
                    .addOnSuccessListener(new OnSuccessListener<Void>() {
                        @Override
                        public void onSuccess(Void unused) {
                            //added to db
                            progressDialog.dismiss();
                            Toast.makeText(AddProductActivity.this, "Product added...", Toast.LENGTH_SHORT).show();
                            clearData();
                            addToNotifications("add");
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            progressDialog.dismiss();
                            Toast.makeText(AddProductActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    });

        }
        else{
//
//            //upload with image
//            //setup data to save (replace cara kat user class)
//            //1st upload image to storage
//            //name and path of image to be uploaded
//
            String filePathAndName  = "ProductImages/" + "" + timestamp;
            StorageReference storageReference = FirebaseStorage.getInstance().getReference(filePathAndName);
            storageReference.putFile(image_uri)
                    .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                            //success uploading image
                            //get url of uploaded image
                            Task<Uri> uriTask = taskSnapshot.getStorage().getDownloadUrl();
                            while (!uriTask.isSuccessful());
                            Uri downloadImageUri = uriTask.getResult();

                            if(uriTask.isSuccessful()){
                                //url of image received, upload to db

                                HashMap<String,Object> hashMap = new HashMap<>();
                                hashMap.put("companyId", "" + firebaseAuth.getUid());
                                hashMap.put("productId", "" + timestamp);
                                hashMap.put("productName", "" + productName);
                                hashMap.put("productDescription", "" + productDescription);
                                hashMap.put("productCategory", "" + productCategory);
                                hashMap.put("productSubCategory", "" + productSubCategory);
                                hashMap.put("productIcon", "" + downloadImageUri);
                                hashMap.put("productCompany", "" + productCompany);
                                hashMap.put("productIndication", "" + productIndications);
                                hashMap.put("productIngredient", "" + productIngredients);
                                hashMap.put("productAvailability", "" + productAvailability);
                                hashMap.put("productRetailPrice", "" + productRetailPrice);
                                hashMap.put("productSpecialFeatures", "" + productSpecial);
                                hashMap.put("productPackSize", "" + productPackSize);
                                hashMap.put("productServingSize", "" + productServingSize);
                                hashMap.put("productOtherInfo", "" + productOtherInfo);
                                hashMap.put("productCalorie", "" + productCalorie);
                                hashMap.put("productStorage", "" + productStorage);

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


                                DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Products");
                                databaseReference.child(timestamp).setValue(hashMap)
                                        .addOnSuccessListener(new OnSuccessListener<Void>() {
                                            @Override
                                            public void onSuccess(Void unused) {
                                                //added to db
                                                progressDialog.dismiss();
                                                Toast.makeText(AddProductActivity.this, "Product added...", Toast.LENGTH_SHORT).show();
                                                clearData();
                                                addToNotifications("add");
                                            }
                                        })
                                        .addOnFailureListener(new OnFailureListener() {
                                            @Override
                                            public void onFailure(@NonNull Exception e) {
                                                progressDialog.dismiss();
                                                Toast.makeText(AddProductActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();
                                            }
                                        });
                            }
                        }
                    })
                    .addOnFailureListener(new OnFailureListener() {
                        @Override
                        public void onFailure(@NonNull Exception e) {
                            //failed uploading image
                            progressDialog.dismiss();
                            Toast.makeText(AddProductActivity.this, "Error!" + e.getMessage(), Toast.LENGTH_SHORT).show();

                        }
                    });
        }

    }

    private void clearData() {
        //clear data after uploading product
        nameEt.setText("");
        descriptionEt.setText("");
        categoryEt.setText("");
        productIconIv.setImageResource(R.drawable.add_photo);
        image_uri = null;

        companyEt.setText("");
        indicationsEt.setText("");
        ingredientsEt.setText("");
        availabilityEt.setText("");
        retailPriceEt.setText("");

        subcategoryEt.setText("");
        specialEt.setText("");
        packSizeEt.setText("");
        servingSizeEt.setText("");
        otherInfoEt.setText("");
        calorieEt.setText("");
        storageEt.setText("");
        AmountEt.setText("");
        AmountType.setText("");
        EnergyEt.setText("");
        ProteinEt.setText("");

        FatEt.setText("");
        MUFAEt.setText("");
        PUFAEt.setText("");
        LinoleicEt.setText("");
        LinoAcidEt.setText("");
        EPAEt.setText("");
        DHAEt.setText("");
        SFAEt.setText("");
        MCToilEt.setText("");
        TransEt.setText("");

        CholesterolEt.setText("");
        CarbohydrateEt.setText("");
        SaltEt.setText("");
        LactoseEt.setText("");
        PolyolsEt.setText("");
        FiberEt.setText("");
        FOSEt.setText("");
        DietaryFiberEt.setText("");
        SolubleFiberEt.setText("");
        SugarEt.setText("");

        EssentialAminoAcidsEt.setText("");
        BranchedChainAminoAcidsEt.setText("");
        InulinEt.setText("");
        CholineEt.setText("");
        TaurineEt.setText("");
        CarnitineEt.setText("");
        LCarnitineEt.setText("");
        CaHMBEt.setText("");
        HMBEt.setText("");
        InositolEt.setText("");

        VitaminAEt.setText("");
        VitaminA1Et.setText("");
        VitaminA2Et.setText("");
        VitaminDEt.setText("");
        VitaminD3Et.setText("");
        VitaminEEt.setText("");
        VitaminKEt.setText("");
        VitaminK1Et.setText("");
        VitaminCEt.setText("");
        VitaminB1Et.setText("");

        VitaminB2Et.setText("");
        VitaminB6Et.setText("");
        VitaminB12Et.setText("");
        NiacinEt.setText("");
        NiacinEquivalentEt.setText("");
        FolicAcidEt.setText("");
        BiotinEt.setText("");
        PantothenicAcidEt.setText("");

        SodiumEt.setText("");
        PotassiumEt.setText("");
        ChlorideEt.setText("");
        CalciumEt.setText("");
        PhosphorusEt.setText("");
        MagnesiumEt.setText("");
        IronEt.setText("");
        ZincEt.setText("");
        ManganeseEt.setText("");
        CopperEt.setText("");

        IodineEt.setText("");
        SeleniumEt.setText("");
        ChromiumEt.setText("");
        MolybdenumEt.setText("");
        WaterEt.setText("");

        αLactalbuminEt.setText("");
        βLactoglobulinEt.setText("");
        GlycomacropeptideEt.setText("");
        ImmunoglobulinGIgGEt.setText("");
        BovineSerumAlbuminEt.setText("");
        ProteasePeptone5Et.setText("");

        IsoleucineEt.setText("");
        LeucineEt.setText("");
        LysineEt.setText("");
        MethionineEt.setText("");
        PhenylalanineEt.setText("");
        ThreonineEt.setText("");
        TryptophanEt.setText("");
        ValineEt.setText("");
        HistidineEt.setText("");
        AlanineEt.setText("");
        ArginineEt.setText("");
        AsparticAcidEt.setText("");
        CysteineEt.setText("");
        GlutamicAcidEt.setText("");
        GlycineEt.setText("");
        ProlineEt.setText("");
        SerineEt.setText("");
        TyrosineEt.setText("");
        HydroxyLysineEt.setText("");
        HydroxyProlineEt.setText("");

        specialEt.setVisibility(View.GONE);
        packSizeEt.setVisibility(View.GONE);
        servingSizeEt.setVisibility(View.GONE);
        otherInfoEt.setVisibility(View.GONE);
        calorieEt.setVisibility(View.GONE);

        AmountUnit.setText("");
        AmountType.setText("");
        EnergyUnit.setText("");
        ProteinUnit.setText("");

        FatUnit.setText("");
        MUFAUnit.setText("");
        PUFAUnit.setText("");
        LinoleicUnit.setText("");
        LinoAcidUnit.setText("");
        EPAUnit.setText("");
        DHAUnit.setText("");
        SFAUnit.setText("");
        MCToilUnit.setText("");
        TransUnit.setText("");

        CholesterolUnit.setText("");
        CarbohydrateUnit.setText("");
        SaltUnit.setText("");
        LactoseUnit.setText("");
        PolyolsUnit.setText("");
        FiberUnit.setText("");
        FOSUnit.setText("");
        DietaryFiberUnit.setText("");
        SolubleFiberUnit.setText("");
        SugarUnit.setText("");

        EssentialAminoAcidsUnit.setText("");
        BranchedChainAminoAcidsUnit.setText("");
        InulinUnit.setText("");
        CholineUnit.setText("");
        TaurineUnit.setText("");
        CarnitineUnit.setText("");
        LCarnitineUnit.setText("");
        CaHMBUnit.setText("");;
        HMBUnit.setText("");
        InositolUnit.setText("");

        VitaminAUnit.setText("");
        VitaminA1Unit.setText("");
        VitaminA2Unit.setText("");
        VitaminDUnit.setText("");
        VitaminD3Unit.setText("");
        VitaminEUnit.setText("");
        VitaminKUnit.setText("");
        VitaminK1Unit.setText("");
        VitaminCUnit.setText("");
        VitaminB1Unit.setText("");
        VitaminB2Unit.setText("");
        VitaminB6Unit.setText("");
        VitaminB12Unit.setText("");
        NiacinUnit.setText("");
        NiacinEquivalentUnit.setText("");
        FolicAcidUnit.setText("");
        BiotinUnit.setText("");
        PantothenicAcidUnit.setText("");

        SodiumUnit.setText("");
        PotassiumUnit.setText("");
        ChlorideUnit.setText("");
        CalciumUnit.setText("");
        PhosphorusUnit.setText("");
        MagnesiumUnit.setText("");
        IronUnit.setText("");
        ZincUnit.setText("");
        ManganeseUnit.setText("");
        CopperUnit.setText("");
        IodineUnit.setText("");
        SeleniumUnit.setText("");
        ChromiumUnit.setText("");
        MolybdenumUnit.setText("");
        WaterUnit.setText("");

        αLactalbuminUnit.setText("");
        βLactoglobulinUnit.setText("");
        GlycomacropeptideUnit.setText("");
        ImmunoglobulinGIgGUnit.setText("");
        BovineSerumAlbuminUnit.setText("");
        ProteasePeptone5Unit.setText("");

        IsoleucineUnit.setText("");
        LeucineUnit.setText("");
        LysineUnit.setText("");
        MethionineUnit.setText("");
        PhenylalanineUnit.setText("");
        ThreonineUnit.setText("");
        TryptophanUnit.setText("");
        ValineUnit.setText("");
        HistidineUnit.setText("");
        AlanineUnit.setText("");
        ArginineUnit.setText("");
        AsparticAcidUnit.setText("");
        CysteineUnit.setText("");
        GlutamicAcidUnit.setText("");
        GlycineUnit.setText("");
        ProlineUnit.setText("");
        SerineUnit.setText("");
        TyrosineUnit.setText("");
        HydroxyLysineUnit.setText("");
    }

    private void categoryDialog() {
        //dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Product Category")
                .setItems(Constants.productCategories, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get picked category
                        String category = Constants.productCategories[which];
                        //set picked category
                        categoryEt.setText(category);
                    }
                })
                .show();
    }

    private void subcategoryDialog() {
        //dialog
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Product Category").setItems(Subcategory1.AdultProduct, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //get picked category
                        String subcategory = Subcategory1.AdultProduct[which];
                        //set picked category
                        subcategoryEt.setText(subcategory);
                    }
                })
                .show();
    }

    private void showImagePickDialog() {
         //options to display in dialog
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
//                            //camera clicked
//                            if(checkCameraPermission()){
//                                pickFromCamera();
//                            }else{
//                                //permission not granted, request
//                                requestCameraPermission();
//                            }
                        }
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

//            if(requestCode == 12  && resultCode == RESULT_OK  && data !=null && data.getData() != null ){
//                uploadPDFBtn.setEnabled(true);
//                uploadPDFNameEt.setText(data.getDataString()
//                .substring(data.getDataString().lastIndexOf("/") +1));
//
//                uploadPDFBtn.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        //flow
//                        //1. input data
//                        //2. validate data
//                        //3. add data to db
////                        inputData();
//                        uploadtoFirebase(data.getData());
//
//                    }
//                });
//
//            }
        }
//
//    private void uploadtoFirebase(Uri data) {
//
//        final ProgressDialog progressDialog = new ProgressDialog(this);
//        progressDialog.setTitle("Uploading...");
//        progressDialog.show();
//
//        // take new storageRefrence
//        StorageReference reference = storageReference.child("Files/"+System.currentTimeMillis()+".pdf");
//        reference.putFile(data)
//                .addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
//                    @SuppressWarnings("VisibleForTests")
//                    @Override
//                    public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
//
//                        Task<Uri> uri=taskSnapshot.getStorage().getDownloadUrl();
//                        while (!uri.isComplete());    // Important condition because this will wait till the access token of url is generated.
//                        Uri url = uri.getResult();   // Gets us the url of the file stored in Firebase Storage
////                        putPDF PutPDF = new putPDF(uploadPDFNameEt.getText().toString(),url.toString());   // Storing this key value pair in Realtime Database
//                        putPDF PutPDF = new putPDF(url.toString());   // Storing this key value pair in Realtime Database
//                        databaseReference.child(databaseReference.push().getKey()).setValue(PutPDF);
//                        Toast.makeText(AddProductActivity.this,"File Uploaded Successfully",Toast.LENGTH_LONG).show();
//                        progressDialog.dismiss();
//                    }
//                }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception exception) {
//                Toast.makeText(AddProductActivity.this,"Failed", Toast.LENGTH_LONG).show();
//            }
//
//        }).addOnProgressListener(new OnProgressListener<UploadTask.TaskSnapshot>() {
//            @Override
//            public void onProgress(@NonNull UploadTask.TaskSnapshot snapshot) {
//
//                double progress = (100.0 * snapshot.getBytesTransferred()) / snapshot.getTotalByteCount();
//                progressDialog.setMessage("Uploading "+(int)progress+"%");
//
//            }
//        });
//
//    }
}



class Constants{
    public static final String[]productCategories={
            "Adult Formula",
            "Modular Formula",
            "Paediatric",
    };
}

class Units{
    public static final String[]nutrientUnits={
            "kcal",
            "g",
            "IU",
            "mg",
            "mcg RE",
            "mcg",
            "mg α-TE",
            "mg NE",
    };
}

class Amount{
    public static final String[]perAmount={
            "scoop",
            "sachet",
            "ml",
    };
}

class Subcategory1{
    public static final String[]AdultProduct={
            "Standard Nutrition",
            "Diabetes Nutrition",
            "Renal Nutrition",
            "Complete nutrition with Fiber",
            "Semi elemental",
            "Clear Liquid",
            "Cancer nutrition",
            "Immunonutrition",
            "Liver Nutrition ",
            "Carbohydrate",
            "Protein",
            "Fat",
            "Fiber",
            "Probiotic",
            "Infant formula",
            "Prem Formula",
            "Anti Requrgate",
            "Energy densed infant formula",
            "Lactose Free",
            "Complete nutrition",
            "Semi Elemental",
            "Low fat pediatric formula",
            "Amino acid based formula",
            "Rice based protein ",
            "HMF",
    };

    public static final String[]AllCategories={
            "All",
            "Standard Nutrition",
            "Diabetes Nutrition",
            "Renal Nutrition",
            "Complete nutrition with Fiber",
            "Semi elemental",
            "Clear Liquid",
            "Cancer nutrition",
            "Immunonutrition",
            "Liver Nutrition ",
            "Carbohydrate",
            "Protein",
            "Fat",
            "Fiber",
            "Probiotic",
            "Infant formula",
            "Prem Formula",
            "Anti Requrgate",
            "Energy densed infant formula",
            "Lactose Free",
            "Complete nutrition",
            "Semi Elemental",
            "Low fat pediatric formula",
            "Amino acid based formula",
            "Rice based protein ",
            "HMF",
    };
}


//
//class Subcategory2{
//    public static final String[]ModularProduct={
//            "Carbohydrate",
//            "Protein",
//            "Fat",
//            "Fiber",
//            "Probiotic",
//
//    };
//}
//
//class Subcategory3{
//    public static final String[]PaediatricProduct={
//            "Infant formula",
//            "Prem Formula",
//            "Anti Requrgate",
//            "Energy densed infant formula",
//            "Lactose Free",
//            "Complete nutrition",
//            "Semi Elemental",
//            "Low fat pediatric formula",
//            "Amino acid based formula",
//            "Rice based protein ",
//            "HMF",
//    };
//}