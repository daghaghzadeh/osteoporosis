package com.phoenix.osteoporosis.util;

import android.content.Context;

import java.util.HashMap;

/**
 * Created by phoenix on 30/11/2014.
 */
public class RawHelper {

    public static int getResourceID(Context context, String name) {

        HashMap<String, String> map = new HashMap<String, String>();

        map.put("9c348902-485c-11e4-9fb0-f8e603fe302b_iStock_000032950550_Large--646x363","01");
        map.put("10ce92b6d3f6582001b210bf3d1e91b3","02");
        map.put("36c6f4a1b75a3cf8314d1456fdf5d41f","03");
        map.put("388","04");
        map.put("2717","05");
        map.put("2847_67","06");
        map.put("3123","07");
        map.put("52331","08");
        map.put("195878-vitamin-wheel","09");
        map.put("336139-396920-409","10");
        map.put("180775478-617x416","11");
        map.put("13930727095006669575004","12");
        map.put("14224622045919916912060213236467196206143","13");
        map.put("60731264780698215957","14");
        map.put("Aerobics_class_-_cropped","15");
        map.put("article-g01_400_515","16");
        map.put("Avoid-caffeine-and-nicotine-consumption","17");
        map.put("backache","18");
        map.put("battle-of-bulge","19");
        map.put("calcium-osteoporosis","20");
        map.put("carbamazepine_200_f copy","21");
        map.put("dan","22");
        map.put("drink-and-cigarette","23");
        map.put("Fotolia_31911584_XS","24");
        map.put("gender","25");
        map.put("harmful-food-additives","26");
        map.put("help-weight-loss","27");
        map.put("heparin_s","28");
        map.put("high-protein-foods","29");
        map.put("hormone-replacement-boca-raton-fl","30");
        map.put("Hormone-Tests-234x178","31");
        map.put("images","32");
        map.put("imagesepilepsy","33");
        map.put("imagesprostate","34");
        map.put("imagessuplement","35");
        map.put("Img1G51S42M0D272013115021PM","36");
        map.put("laziness","37");
        map.put("menopause-treatment","38");
        map.put("MRI-May-Help-Predict-Soft-Tissue-Reaction-in-Metal-on-Metal-Hip-Implant-Patients-AAOS-Says","39");
        map.put("o-DOCTOR-PATIENT-RELATIONSHIP-facebook","40");
        map.put("osteo_US copy","41");
        map.put("osteopathie-femme-enceinte","42");
        map.put("osteopenia","43");
        map.put("osteoporosis","44");
        map.put("osteoporosis3","45");
        map.put("Osteoporosis-diagnosis-test-6","46");
        map.put("otc_medication","47");
        map.put("princ_rm_photo_of_stages_of_osteoporosis","48");
        map.put("serological-test","49");
        map.put("shutterstock_50390293","50");
        map.put("tomography","51");
        map.put("too_much_exercise1","52");
        map.put("untitled","53");
        map.put("Untitled-36","54");
        map.put("uterine-and-cervical-cancer-2339","55");
        map.put("vitamin-D","56");
        map.put("what-about-race-nmnh","57");
        map.put("تغذیه-و-پوکی-استخوان","58");



        int id = context.getResources().getIdentifier("r"+map.get(name), "raw", context.getPackageName());
        return id;
    }

}
