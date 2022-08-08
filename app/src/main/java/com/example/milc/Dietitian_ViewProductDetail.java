package com.example.milc;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.squareup.picasso.Picasso;

public class Dietitian_ViewProductDetail extends AppCompatActivity {

    TextView nameDetail,descriptionDetail,companyDetail,indicationDetail;
    TextView ingredientDetail,availabilityDetail,retailPriceDetail;
    TextView SpecialFeaturesDetail,StorageDetail,CalorieDetail,OtherInformationDetail,ServingDetail,PackSizeDetail;

    ImageView icon;

    private void initializeWidgets(){
        nameDetail= findViewById(R.id.nameDetailTextView);
        descriptionDetail= findViewById(R.id.descriptionDetailTextView);
        companyDetail= findViewById(R.id.companyDetailTextView);
        indicationDetail= findViewById(R.id.indicationDetailTextView);
        ingredientDetail= findViewById(R.id.ingredientDetailTextView);
        availabilityDetail= findViewById(R.id.availabilityDetailTextView);
        retailPriceDetail= findViewById(R.id.retailPriceDetailTextView);
        SpecialFeaturesDetail= findViewById(R.id.SpecialFeaturesDetailTextView);
        StorageDetail= findViewById(R.id.StorageDetailTextView);
        CalorieDetail= findViewById(R.id.CalorieDetailTextView);
        OtherInformationDetail= findViewById(R.id.OtherInformationDetailTextView);
        ServingDetail= findViewById(R.id.ServingDetailTextView);
        PackSizeDetail= findViewById(R.id.PackSizeDetailTextView);

        icon=findViewById(R.id.teacherDetailImageView);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dietitian_view_product_detail);

        initializeWidgets();

        //RECEIVE DATA FROM new_items VIA INTENT
        Intent i=this.getIntent();
        String name=i.getExtras().getString("NAME_KEY");
        String description=i.getExtras().getString("DESCRIPTION_KEY");
        String imageURL=i.getExtras().getString("IMAGE_KEY");
        String company=i.getExtras().getString("COMPANY_KEY");
        String indication=i.getExtras().getString("INDICATION_KEY");
        String ingredient=i.getExtras().getString("INGREDIENT_KEY");
        String availability=i.getExtras().getString("AVAILABILITY_KEY");
        String retailPrice=i.getExtras().getString("PRICE_KEY");
        String SpecialFeatures=i.getExtras().getString("SPECIAL_KEY");
        String Storage=i.getExtras().getString("STORAGE_KEY");
        String Calorie=i.getExtras().getString("CALORIE_KEY");
        String OtherInformation=i.getExtras().getString("OTHER_KEY");
        String Serving=i.getExtras().getString("SERVING_KEY");
        String PackSize=i.getExtras().getString("SIZE_KEY");

        //SET RECEIVED DATA TO TEXTVIEWS AND IMAGEVIEWS
        nameDetail.setText(name);
        descriptionDetail.setText(description);
        companyDetail.setText(company);
        indicationDetail.setText(indication);
        ingredientDetail.setText(ingredient);
        availabilityDetail.setText(availability);
        retailPriceDetail.setText(retailPrice);
        SpecialFeaturesDetail.setText(SpecialFeatures);
        StorageDetail.setText(Storage);
        CalorieDetail.setText(Calorie);
        OtherInformationDetail.setText(OtherInformation);
        ServingDetail.setText(Serving);
        PackSizeDetail.setText(PackSize);

//        if(SpecialFeatures.isEmpty()){
//            calorieLine.setVisibility(View.GONE);
//        }

        Picasso.get()
                .load(imageURL)
                .placeholder(R.drawable.home)
                .fit()
                .centerCrop()
                .into(icon);

    }
}