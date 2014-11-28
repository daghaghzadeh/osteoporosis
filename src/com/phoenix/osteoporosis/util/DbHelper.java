package com.phoenix.osteoporosis.util;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DbHelper
{

    static final String TABLE_CITY                    = "City";
    static final String TABLE_CITY_COLUMN_CITY_ID     = "City_Id";
    static final String TABLE_CITY_COLUMN_STATE_ID    = "State_Id";
    static final String TABLE_CITY_COLUMN_CITY_NAME   = "City_Name";

    static final String TABLE_STATE                   = "State";
    static final String TABLE_STATE_COLUMN_STATE_ID   = "State_Id";
    static final String TABLE_STATE_COLUMN_STATE_NAME = "State_Name";

    final Context       context;

    DatabaseHelper      dbHelper;
    SQLiteDatabase      db;


    public DbHelper(Context ctx)
    {
        this.context = ctx;
        dbHelper = new DatabaseHelper(context);
    }


    private static class DatabaseHelper extends SQLiteOpenHelper
    {

        DatabaseHelper(Context context)
        {
            super(context, "db", null, 1);
        }


        @Override
        public void onCreate(SQLiteDatabase db)
        {
            try
            {
                db.execSQL("CREATE TABLE IF NOT EXISTS City ( City_Id INT , State_Id int , City_Name TEXT );");
                db.execSQL("CREATE TABLE IF NOT EXISTS State( State_Id INT , State_Name TEXT);");

                Log.i("TAG", "Table 'City' & 'State' Created!");
            }
            catch (SQLException e)
            {
                e.printStackTrace();
            }
        }


        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
        {
            Log.i("TAG", "Upgrading database from version " + oldVersion + " to "
                    + newVersion + ", which will destroy all old data");

            db.execSQL("DROP TABLE IF EXISTS City;");
            db.execSQL("DROP TABLE IF EXISTS State;");

            onCreate(db);
        }

    } // End class DatabaseHelper


    //--- opens the database ---    
    public DbHelper open() throws SQLException
    {
        db = dbHelper.getWritableDatabase();
        return this;
    }


    //--- closes the database ---    
    public void close()
    {
        dbHelper.close();
    }


    //--- Retrieve All Rows in Table 'State' ---    
    public Cursor get_All_States()
    {
        return db.query(TABLE_STATE, new String[]{ TABLE_STATE_COLUMN_STATE_ID, TABLE_STATE_COLUMN_STATE_NAME },
                null, null, null, null, null);
    }


    //--- Retrieve Rows in Table 'City' Related to Selected Row From Table 'State' ---    
    public Cursor get_State_Cities(int state_id)
    {
        return db.query(TABLE_CITY, new String[]{ TABLE_CITY_COLUMN_CITY_NAME },
                TABLE_CITY_COLUMN_STATE_ID + "=" + state_id, null, null, null, "City_Name ASC");
    }


    //--- Delete Total States in Table 'State' ---    
    public boolean delete_Total_States()
    {
        return db.delete(TABLE_STATE, null, null) > 0;
    }


    //--- Delete Total Cities in Table 'City' ---    
    public boolean delete_Total_Cities()
    {
        return db.delete(TABLE_CITY, null, null) > 0;
    }


    //--- Insert Total States in Table 'State' ---    
    public void insert_Total_States()
    {

        db.execSQL("INSERT INTO State ( State_Id , State_Name ) "
                + "SELECT 1, 'آذربایجان شرقی'"
                + "UNION SELECT 2, 'آذربایجان غربی'"
                + "UNION SELECT 3, 'اردبیل'"
                + "UNION SELECT 4, 'اصفهان'"
                + "UNION SELECT 5, 'ايلام'"
                + "UNION SELECT 6, 'بوشهر'"
                + "UNION SELECT 7, 'تهران'"
                + "UNION SELECT 8, 'چهارمحال بختياري'"
                + "UNION SELECT 9, 'خراسان جنوبي'"
                + "UNION SELECT 10, 'خراسان رضوي'"
                + "UNION SELECT 11, 'خراسان شمالي'"
                + "UNION SELECT 12, 'خوزستان'"
                + "UNION SELECT 13, 'زنجان'"
                + "UNION SELECT 14, 'سمنان'"
                + "UNION SELECT 15, 'سيستان و بلوچستان'"
                + "UNION SELECT 16, 'فارس'"
                + "UNION SELECT 17, 'قزوين'"
                + "UNION SELECT 18, 'قم'"
                + "UNION SELECT 19, 'کرج'"
                + "UNION SELECT 20, 'كردستان'"
                + "UNION SELECT 21, 'كرمان'"
                + "UNION SELECT 22, 'كرمانشاه'"
                + "UNION SELECT 23, 'كهكيلويه و بويراحمد'"
                + "UNION SELECT 24, 'گلستان'"
                + "UNION SELECT 25, 'گيلان'"
                + "UNION SELECT 26, 'لرستان'"
                + "UNION SELECT 27, 'مازندران'"
                + "UNION SELECT 28, 'مركزي'"
                + "UNION SELECT 29, 'هرمزگان'"
                + "UNION SELECT 30, 'همدان'"
                + "UNION SELECT 31, 'يزد'"

                + ";"
                );
    } // End 


    //--- Insert Total Cities in Table 'City' ---    
    public void insert_Total_Cities()
    {
        db.execSQL("INSERT INTO City ( City_Id , State_Id , City_Name ) "
                + "SELECT 1, 1, 'تبريز'"
                + "UNION SELECT 2, 1, 'كندوان'"
                + "UNION SELECT 3, 1, 'بندر شرفخانه'"
                + "UNION SELECT 4, 1, 'مراغه'"
                + "UNION SELECT 5, 1, 'ميانه'"
                + "UNION SELECT 6, 1, 'شبستر'"
                + "UNION SELECT 7, 1, 'مرند'"
                + "UNION SELECT 8, 1, 'جلفا'"
                + "UNION SELECT 9, 1, 'سراب'"
                + "UNION SELECT 10, 1, 'هاديشهر'"
                + "UNION SELECT 11, 1, 'بناب'"
                + "UNION SELECT 12, 1, 'كليبر'"
                + "UNION SELECT 13, 1, 'تسوج'"
                + "UNION SELECT 14, 1, 'اهر'"
                + "UNION SELECT 15, 1, 'هريس'"
                + "UNION SELECT 16, 1, 'عجبشير'"
                + "UNION SELECT 17, 1, 'هشترود'"
                + "UNION SELECT 18, 1, 'ملكان'"
                + "UNION SELECT 19, 1, 'بستان آباد'"
                + "UNION SELECT 20, 1, 'ورزقان'"
                + "UNION SELECT 21, 1, 'اسكو'"
                + "UNION SELECT 22, 1, 'آذر شهر'"
                + "UNION SELECT 23, 1, 'قره آغاج'"
                + "UNION SELECT 24, 1, 'ممقان'"
                + "UNION SELECT 25, 1, 'صوفیان'"
                + "UNION SELECT 26, 1, 'ایلخچی'"
                + "UNION SELECT 27, 1, 'خسروشهر'"
                + "UNION SELECT 28, 1, 'باسمنج'"
                + "UNION SELECT 29, 1, 'سهند'"
                + "UNION SELECT 30, 2, 'اروميه'"
                + "UNION SELECT 31, 2, 'نقده'"
                + "UNION SELECT 32, 2, 'ماكو'"
                + "UNION SELECT 33, 2, 'تكاب'"
                + "UNION SELECT 34, 2, 'خوي'"
                + "UNION SELECT 35, 2, 'مهاباد'"
                + "UNION SELECT 36, 2, 'سر دشت'"
                + "UNION SELECT 37, 2, 'چالدران'"
                + "UNION SELECT 38, 2, 'بوكان'"
                + "UNION SELECT 39, 2, 'مياندوآب'"
                + "UNION SELECT 40, 2, 'سلماس'"
                + "UNION SELECT 41, 2, 'شاهين دژ'"
                + "UNION SELECT 42, 2, 'پيرانشهر'"
                + "UNION SELECT 43, 2, 'سيه چشمه'"
                + "UNION SELECT 44, 2, 'اشنويه'"
                + "UNION SELECT 45, 2, 'چایپاره'"
                + "UNION SELECT 46, 2, 'پلدشت'"
                + "UNION SELECT 47, 2, 'شوط'"
                + "UNION SELECT 48, 3, 'اردبيل'"
                + "UNION SELECT 49, 3, 'سرعين'"
                + "UNION SELECT 50, 3, 'بيله سوار'"
                + "UNION SELECT 51, 3, 'پارس آباد'"
                + "UNION SELECT 52, 3, 'خلخال'"
                + "UNION SELECT 53, 3, 'مشگين شهر'"
                + "UNION SELECT 54, 3, 'مغان'"
                + "UNION SELECT 55, 3, 'نمين'"
                + "UNION SELECT 56, 3, 'نير'"
                + "UNION SELECT 57, 3, 'كوثر'"
                + "UNION SELECT 58, 3, 'كيوي'"
                + "UNION SELECT 59, 3, 'گرمي'"
                + "UNION SELECT 60, 4, 'اصفهان'"
                + "UNION SELECT 61, 4, 'فريدن'"
                + "UNION SELECT 62, 4, 'فريدون شهر'"
                + "UNION SELECT 63, 4, 'فلاورجان'"
                + "UNION SELECT 64, 4, 'گلپايگان'"
                + "UNION SELECT 65, 4, 'دهاقان'"
                + "UNION SELECT 66, 4, 'نطنز'"
                + "UNION SELECT 67, 4, 'نايين'"
                + "UNION SELECT 68, 4, 'تيران'"
                + "UNION SELECT 69, 4, 'كاشان'"
                + "UNION SELECT 70, 4, 'فولاد شهر'"
                + "UNION SELECT 71, 4, 'اردستان'"
                + "UNION SELECT 72, 4, 'سميرم'"
                + "UNION SELECT 73, 4, 'درچه'"
                + "UNION SELECT 74, 4, 'کوهپایه'"
                + "UNION SELECT 75, 4, 'مباركه'"
                + "UNION SELECT 76, 4, 'شهرضا'"
                + "UNION SELECT 77, 4, 'خميني شهر'"
                + "UNION SELECT 78, 4, 'شاهين شهر'"
                + "UNION SELECT 79, 4, 'نجف آباد'"
                + "UNION SELECT 80, 4, 'دولت آباد'"
                + "UNION SELECT 81, 4, 'زرين شهر'"
                + "UNION SELECT 82, 4, 'آران و بيدگل'"
                + "UNION SELECT 83, 4, 'باغ بهادران'"
                + "UNION SELECT 84, 4, 'خوانسار'"
                + "UNION SELECT 85, 4, 'مهردشت'"
                + "UNION SELECT 86, 4, 'علويجه'"
                + "UNION SELECT 87, 4, 'عسگران'"
                + "UNION SELECT 88, 4, 'نهضت آباد'"
                + "UNION SELECT 89, 4, 'حاجي آباد'"
                + "UNION SELECT 90, 4, 'تودشک'"
                + "UNION SELECT 91, 4, 'ورزنه'"
                + "UNION SELECT 92, 5, 'ايلام'"
                + "UNION SELECT 93, 5, 'مهران'"
                + "UNION SELECT 94, 5, 'دهلران'"
                + "UNION SELECT 95, 5, 'آبدانان'"
                + "UNION SELECT 96, 5, 'شيروان چرداول'"
                + "UNION SELECT 97, 5, 'دره شهر'"
                + "UNION SELECT 98, 5, 'ايوان'"
                + "UNION SELECT 99, 5, 'سرابله'"
                + "UNION SELECT 100, 6, 'بوشهر'"
                + "UNION SELECT 101, 6, 'تنگستان'"
                + "UNION SELECT 102, 6, 'دشتستان'"
                + "UNION SELECT 103, 6, 'دير'"
                + "UNION SELECT 104, 6, 'ديلم'"
                + "UNION SELECT 105, 6, 'كنگان'"
                + "UNION SELECT 106, 6, 'گناوه'"
                + "UNION SELECT 107, 6, 'ريشهر'"
                + "UNION SELECT 108, 6, 'دشتي'"
                + "UNION SELECT 109, 6, 'خورموج'"
                + "UNION SELECT 110, 6, 'اهرم'"
                + "UNION SELECT 111, 6, 'برازجان'"
                + "UNION SELECT 112, 6, 'خارك'"
                + "UNION SELECT 113, 6, 'جم'"
                + "UNION SELECT 114, 6, 'کاکی'"
                + "UNION SELECT 115, 6, 'عسلویه'"
                + "UNION SELECT 116, 6, 'بردخون'"
                + "UNION SELECT 117, 7, 'تهران'"
                + "UNION SELECT 118, 7, 'ورامين'"
                + "UNION SELECT 119, 7, 'فيروزكوه'"
                + "UNION SELECT 120, 7, 'ري'"
                + "UNION SELECT 121, 7, 'دماوند'"
                + "UNION SELECT 122, 7, 'اسلامشهر'"
                + "UNION SELECT 123, 7, 'رودهن'"
                + "UNION SELECT 124, 7, 'لواسان'"
                + "UNION SELECT 125, 7, 'بومهن'"
                + "UNION SELECT 126, 7, 'تجريش'"
                + "UNION SELECT 127, 7, 'فشم'"
                + "UNION SELECT 128, 7, 'كهريزك'"
                + "UNION SELECT 129, 7, 'پاكدشت'"
                + "UNION SELECT 130, 7, 'چهاردانگه'"
                + "UNION SELECT 131, 7, 'شريف آباد'"
                + "UNION SELECT 132, 7, 'قرچك'"
                + "UNION SELECT 133, 7, 'باقرشهر'"
                + "UNION SELECT 134, 7, 'شهريار'"
                + "UNION SELECT 135, 7, 'رباط كريم'"
                + "UNION SELECT 136, 7, 'قدس'"
                + "UNION SELECT 137, 7, 'ملارد'"
                + "UNION SELECT 138, 8, 'شهركرد'"
                + "UNION SELECT 139, 8, 'فارسان'"
                + "UNION SELECT 140, 8, 'بروجن'"
                + "UNION SELECT 141, 8, 'چلگرد'"
                + "UNION SELECT 142, 8, 'اردل'"
                + "UNION SELECT 143, 8, 'لردگان'"
                + "UNION SELECT 144, 8, 'سامان'"
                + "UNION SELECT 145, 9, 'قائن'"
                + "UNION SELECT 146, 9, 'فردوس'"
                + "UNION SELECT 147, 9, 'بيرجند'"
                + "UNION SELECT 148, 9, 'نهبندان'"
                + "UNION SELECT 149, 9, 'سربيشه'"
                + "UNION SELECT 150, 9, 'طبس مسینا'"
                + "UNION SELECT 151, 9, 'قهستان'"
                + "UNION SELECT 152, 9, 'درمیان'"
                + "UNION SELECT 153, 10, 'مشهد'"
                + "UNION SELECT 154, 10, 'نيشابور'"
                + "UNION SELECT 155, 10, 'سبزوار'"
                + "UNION SELECT 156, 10, 'كاشمر'"
                + "UNION SELECT 157, 10, 'گناباد'"
                + "UNION SELECT 158, 10, 'طبس'"
                + "UNION SELECT 159, 10, 'تربت حيدريه'"
                + "UNION SELECT 160, 10, 'خواف'"
                + "UNION SELECT 161, 10, 'تربت جام'"
                + "UNION SELECT 162, 10, 'تايباد'"
                + "UNION SELECT 163, 10, 'قوچان'"
                + "UNION SELECT 164, 10, 'سرخس'"
                + "UNION SELECT 165, 10, 'بردسكن'"
                + "UNION SELECT 166, 10, 'فريمان'"
                + "UNION SELECT 167, 10, 'چناران'"
                + "UNION SELECT 168, 10, 'درگز'"
                + "UNION SELECT 169, 10, 'كلات'"
                + "UNION SELECT 170, 10, 'طرقبه'"
                + "UNION SELECT 171, 10, 'سر ولایت'"
                + "UNION SELECT 172, 11, 'بجنورد'"
                + "UNION SELECT 173, 11, 'اسفراين'"
                + "UNION SELECT 174, 11, 'جاجرم'"
                + "UNION SELECT 175, 11, 'شيروان'"
                + "UNION SELECT 176, 11, 'آشخانه'"
                + "UNION SELECT 177, 11, 'گرمه'"
                + "UNION SELECT 178, 11, 'ساروج'"
                + "UNION SELECT 179, 12, 'اهواز'"
                + "UNION SELECT 180, 12, 'ايرانشهر'"
                + "UNION SELECT 181, 12, 'شوش'"
                + "UNION SELECT 182, 12, 'آبادان'"
                + "UNION SELECT 183, 12, 'خرمشهر'"
                + "UNION SELECT 184, 12, 'مسجد سليمان'"
                + "UNION SELECT 185, 12, 'ايذه'"
                + "UNION SELECT 186, 12, 'شوشتر'"
                + "UNION SELECT 187, 12, 'انديمشك'"
                + "UNION SELECT 188, 12, 'سوسنگرد'"
                + "UNION SELECT 189, 12, 'هويزه'"
                + "UNION SELECT 190, 12, 'دزفول'"
                + "UNION SELECT 191, 12, 'شادگان'"
                + "UNION SELECT 192, 12, 'بندر ماهشهر'"
                + "UNION SELECT 193, 12, 'بندر امام خميني'"
                + "UNION SELECT 194, 12, 'اميديه'"
                + "UNION SELECT 195, 12, 'بهبهان'"
                + "UNION SELECT 196, 12, 'رامهرمز'"
                + "UNION SELECT 197, 12, 'باغ ملك'"
                + "UNION SELECT 198, 12, 'هنديجان'"
                + "UNION SELECT 199, 12, 'لالي'"
                + "UNION SELECT 200, 12, 'رامشیر'"
                + "UNION SELECT 201, 12, 'حمیدیه'"
                + "UNION SELECT 202, 12, 'دغاغله'"
                + "UNION SELECT 203, 12, 'ملاثانی'"
                + "UNION SELECT 204, 12, 'شادگان'"
                + "UNION SELECT 205, 12, 'ویسی'"
                + "UNION SELECT 206, 13, 'زنجان'"
                + "UNION SELECT 207, 13, 'ابهر'"
                + "UNION SELECT 208, 13, 'خدابنده'"
                + "UNION SELECT 209, 13, 'كارم'"
                + "UNION SELECT 210, 13, 'ماهنشان'"
                + "UNION SELECT 211, 13, 'خرمدره'"
                + "UNION SELECT 212, 13, 'ايجرود'"
                + "UNION SELECT 213, 13, 'زرين آباد'"
                + "UNION SELECT 214, 13, 'آب بر'"
                + "UNION SELECT 215, 13, 'قيدار'"
                + "UNION SELECT 216, 14, 'سمنان'"
                + "UNION SELECT 217, 14, 'شاهرود'"
                + "UNION SELECT 218, 14, 'گرمسار'"
                + "UNION SELECT 219, 14, 'ايوانكي'"
                + "UNION SELECT 220, 14, 'دامغان'"
                + "UNION SELECT 221, 14, 'بسطام'"
                + "UNION SELECT 222, 15, 'زاهدان'"
                + "UNION SELECT 223, 15, 'چابهار'"
                + "UNION SELECT 224, 15, 'خاش'"
                + "UNION SELECT 225, 15, 'سراوان'"
                + "UNION SELECT 226, 15, 'زابل'"
                + "UNION SELECT 227, 15, 'سرباز'"
                + "UNION SELECT 228, 15, 'نيكشهر'"
                + "UNION SELECT 229, 15, 'ايرانشهر'"
                + "UNION SELECT 230, 15, 'راسك'"
                + "UNION SELECT 231, 15, 'ميرجاوه'"
                + "UNION SELECT 232, 16, 'شيراز'"
                + "UNION SELECT 233, 16, 'اقليد'"
                + "UNION SELECT 234, 16, 'داراب'"
                + "UNION SELECT 235, 16, 'فسا'"
                + "UNION SELECT 236, 16, 'مرودشت'"
                + "UNION SELECT 237, 16, 'خرم بيد'"
                + "UNION SELECT 238, 16, 'آباده'"
                + "UNION SELECT 239, 16, 'كازرون'"
                + "UNION SELECT 240, 16, 'ممسني'"
                + "UNION SELECT 241, 16, 'سپيدان'"
                + "UNION SELECT 242, 16, 'لار'"
                + "UNION SELECT 243, 16, 'فيروز آباد'"
                + "UNION SELECT 244, 16, 'جهرم'"
                + "UNION SELECT 245, 16, 'ني ريز'"
                + "UNION SELECT 246, 16, 'استهبان'"
                + "UNION SELECT 247, 16, 'لامرد'"
                + "UNION SELECT 248, 16, 'مهر'"
                + "UNION SELECT 249, 16, 'حاجي آباد'"
                + "UNION SELECT 250, 16, 'نورآباد'"
                + "UNION SELECT 251, 16, 'اردكان'"
                + "UNION SELECT 252, 16, 'صفاشهر'"
                + "UNION SELECT 253, 16, 'ارسنجان'"
                + "UNION SELECT 254, 16, 'قيروكارزين'"
                + "UNION SELECT 255, 16, 'سوريان'"
                + "UNION SELECT 256, 16, 'فراشبند'"
                + "UNION SELECT 257, 16, 'سروستان'"
                + "UNION SELECT 258, 16, 'ارژن'"
                + "UNION SELECT 259, 16, 'گويم'"
                + "UNION SELECT 260, 16, 'داريون'"
                + "UNION SELECT 261, 16, 'زرقان'"
                + "UNION SELECT 262, 16, 'خان زنیان'"
                + "UNION SELECT 263, 16, 'کوار'"
                + "UNION SELECT 264, 16, 'ده بید'"
                + "UNION SELECT 265, 16, 'باب انار/خفر'"
                + "UNION SELECT 266, 16, 'بوانات'"
                + "UNION SELECT 267, 16, 'خرامه'"
                + "UNION SELECT 268, 16, 'خنج'"
                + "UNION SELECT 269, 16, 'سیاخ دارنگون'"
                + "UNION SELECT 270, 17, 'قزوين'"
                + "UNION SELECT 271, 17, 'تاكستان'"
                + "UNION SELECT 272, 17, 'آبيك'"
                + "UNION SELECT 273, 17, 'بوئين زهرا'"
                + "UNION SELECT 274, 18, 'قم'"
                + "UNION SELECT 275, 19, 'طالقان'"
                + "UNION SELECT 276, 19, 'نظرآباد'"
                + "UNION SELECT 277, 19, 'اشتهارد'"
                + "UNION SELECT 278, 19, 'هشتگرد'"
                + "UNION SELECT 279, 19, 'كن'"
                + "UNION SELECT 280, 19, 'آسارا'"
                + "UNION SELECT 281, 19, 'شهرک گلستان'"
                + "UNION SELECT 282, 19, 'اندیشه'"
                + "UNION SELECT 283, 19, 'كرج'"
                + "UNION SELECT 284, 19, 'نظر آباد'"
                + "UNION SELECT 285, 19, 'گوهردشت'"
                + "UNION SELECT 286, 19, 'ماهدشت'"
                + "UNION SELECT 287, 19, 'مشکین دشت'"
                + "UNION SELECT 288, 20, 'سنندج'"
                + "UNION SELECT 289, 20, 'ديواندره'"
                + "UNION SELECT 290, 20, 'بانه'"
                + "UNION SELECT 291, 20, 'بيجار'"
                + "UNION SELECT 292, 20, 'سقز'"
                + "UNION SELECT 293, 20, 'كامياران'"
                + "UNION SELECT 294, 20, 'قروه'"
                + "UNION SELECT 295, 20, 'مريوان'"
                + "UNION SELECT 296, 20, 'صلوات آباد'"
                + "UNION SELECT 297, 20, 'حسن آباد'"
                + "UNION SELECT 298, 21, 'كرمان'"
                + "UNION SELECT 299, 21, 'راور'"
                + "UNION SELECT 300, 21, 'بابك'"
                + "UNION SELECT 301, 21, 'انار'"
                + "UNION SELECT 302, 21, 'کوهبنان'"
                + "UNION SELECT 303, 21, 'رفسنجان'"
                + "UNION SELECT 304, 21, 'بافت'"
                + "UNION SELECT 305, 21, 'سيرجان'"
                + "UNION SELECT 306, 21, 'كهنوج'"
                + "UNION SELECT 307, 21, 'زرند'"
                + "UNION SELECT 308, 21, 'بم'"
                + "UNION SELECT 309, 21, 'جيرفت'"
                + "UNION SELECT 310, 21, 'بردسير'"
                + "UNION SELECT 311, 22, 'كرمانشاه'"
                + "UNION SELECT 312, 22, 'اسلام آباد غرب'"
                + "UNION SELECT 313, 22, 'سر پل ذهاب'"
                + "UNION SELECT 314, 22, 'كنگاور'"
                + "UNION SELECT 315, 22, 'سنقر'"
                + "UNION SELECT 316, 22, 'قصر شيرين'"
                + "UNION SELECT 317, 22, 'گيلان غرب'"
                + "UNION SELECT 318, 22, 'هرسين'"
                + "UNION SELECT 319, 22, 'صحنه'"
                + "UNION SELECT 320, 22, 'پاوه'"
                + "UNION SELECT 321, 22, 'جوانرود'"
                + "UNION SELECT 322, 22, 'شاهو'"
                + "UNION SELECT 323, 23, 'ياسوج'"
                + "UNION SELECT 324, 23, 'گچساران'"
                + "UNION SELECT 325, 23, 'دنا'"
                + "UNION SELECT 326, 23, 'دوگنبدان'"
                + "UNION SELECT 327, 23, 'سي سخت'"
                + "UNION SELECT 328, 23, 'دهدشت'"
                + "UNION SELECT 329, 23, 'ليكك'"
                + "UNION SELECT 330, 24, 'گرگان'"
                + "UNION SELECT 331, 24, 'آق قلا'"
                + "UNION SELECT 332, 24, 'گنبد كاووس'"
                + "UNION SELECT 333, 24, 'علي آباد كتول'"
                + "UNION SELECT 334, 24, 'مينو دشت'"
                + "UNION SELECT 335, 24, 'تركمن'"
                + "UNION SELECT 336, 24, 'كردكوي'"
                + "UNION SELECT 337, 24, 'بندر گز'"
                + "UNION SELECT 338, 24, 'كلاله'"
                + "UNION SELECT 339, 24, 'آزاد شهر'"
                + "UNION SELECT 340, 24, 'راميان'"
                + "UNION SELECT 341, 25, 'رشت'"
                + "UNION SELECT 342, 25, 'منجيل'"
                + "UNION SELECT 343, 25, 'لنگرود'"
                + "UNION SELECT 344, 25, 'رود سر'"
                + "UNION SELECT 345, 25, 'تالش'"
                + "UNION SELECT 346, 25, 'آستارا'"
                + "UNION SELECT 347, 25, 'ماسوله'"
                + "UNION SELECT 348, 25, 'آستانه اشرفيه'"
                + "UNION SELECT 349, 25, 'رودبار'"
                + "UNION SELECT 350, 25, 'فومن'"
                + "UNION SELECT 351, 25, 'صومعه سرا'"
                + "UNION SELECT 352, 25, 'بندرانزلي'"
                + "UNION SELECT 353, 25, 'كلاچاي'"
                + "UNION SELECT 354, 25, 'هشتپر'"
                + "UNION SELECT 355, 25, 'رضوان شهر'"
                + "UNION SELECT 356, 25, 'ماسال'"
                + "UNION SELECT 357, 25, 'شفت'"
                + "UNION SELECT 358, 25, 'سياهكل'"
                + "UNION SELECT 359, 25, 'املش'"
                + "UNION SELECT 360, 25, 'لاهیجان'"
                + "UNION SELECT 361, 25, 'خشک بيجار'"
                + "UNION SELECT 362, 25, 'خمام'"
                + "UNION SELECT 363, 25, 'لشت نشا'"
                + "UNION SELECT 364, 25, 'بندر کياشهر'"
                + "UNION SELECT 365, 26, 'خرم آباد'"
                + "UNION SELECT 366, 26, 'ماهشهر'"
                + "UNION SELECT 367, 26, 'دزفول'"
                + "UNION SELECT 368, 26, 'بروجرد'"
                + "UNION SELECT 369, 26, 'دورود'"
                + "UNION SELECT 370, 26, 'اليگودرز'"
                + "UNION SELECT 371, 26, 'ازنا'"
                + "UNION SELECT 372, 26, 'نور آباد'"
                + "UNION SELECT 373, 26, 'كوهدشت'"
                + "UNION SELECT 374, 26, 'الشتر'"
                + "UNION SELECT 375, 26, 'پلدختر'"
                + "UNION SELECT 376, 27, 'ساري'"
                + "UNION SELECT 377, 27, 'آمل'"
                + "UNION SELECT 378, 27, 'بابل'"
                + "UNION SELECT 379, 27, 'بابلسر'"
                + "UNION SELECT 380, 27, 'بهشهر'"
                + "UNION SELECT 381, 27, 'تنكابن'"
                + "UNION SELECT 382, 27, 'جويبار'"
                + "UNION SELECT 383, 27, 'چالوس'"
                + "UNION SELECT 384, 27, 'رامسر'"
                + "UNION SELECT 385, 27, 'سواد كوه'"
                + "UNION SELECT 386, 27, 'قائم شهر'"
                + "UNION SELECT 387, 27, 'نكا'"
                + "UNION SELECT 388, 27, 'نور'"
                + "UNION SELECT 389, 27, 'بلده'"
                + "UNION SELECT 390, 27, 'نوشهر'"
                + "UNION SELECT 391, 27, 'پل سفيد'"
                + "UNION SELECT 392, 27, 'محمود آباد'"
                + "UNION SELECT 393, 27, 'فريدون كنار'"
                + "UNION SELECT 394, 28, 'اراك'"
                + "UNION SELECT 395, 28, 'آشتيان'"
                + "UNION SELECT 396, 28, 'تفرش'"
                + "UNION SELECT 397, 28, 'خمين'"
                + "UNION SELECT 398, 28, 'دليجان'"
                + "UNION SELECT 399, 28, 'ساوه'"
                + "UNION SELECT 400, 28, 'سربند'"
                + "UNION SELECT 401, 28, 'محلات'"
                + "UNION SELECT 402, 28, 'شازند'"
                + "UNION SELECT 403, 29, 'بندرعباس'"
                + "UNION SELECT 404, 29, 'قشم'"
                + "UNION SELECT 405, 29, 'كيش'"
                + "UNION SELECT 406, 29, 'بندر لنگه'"
                + "UNION SELECT 407, 29, 'بستك'"
                + "UNION SELECT 408, 29, 'حاجي آباد'"
                + "UNION SELECT 409, 29, 'دهبارز'"
                + "UNION SELECT 410, 29, 'انگهران'"
                + "UNION SELECT 411, 29, 'ميناب'"
                + "UNION SELECT 412, 29, 'ابوموسي'"
                + "UNION SELECT 413, 29, 'بندر جاسك'"
                + "UNION SELECT 414, 29, 'تنب بزرگ'"
                + "UNION SELECT 415, 29, 'بندر خمیر'"
                + "UNION SELECT 416, 29, 'پارسیان'"
                + "UNION SELECT 417, 29, 'قشم'"
                + "UNION SELECT 418, 30, 'همدان'"
                + "UNION SELECT 419, 30, 'ملاير'"
                + "UNION SELECT 420, 30, 'تويسركان'"
                + "UNION SELECT 421, 30, 'نهاوند'"
                + "UNION SELECT 422, 30, 'كبودر اهنگ'"
                + "UNION SELECT 423, 30, 'رزن'"
                + "UNION SELECT 424, 30, 'اسدآباد'"
                + "UNION SELECT 425, 30, 'بهار'"
                + "UNION SELECT 426, 31, 'يزد'"
                + "UNION SELECT 427, 31, 'تفت'"
                + "UNION SELECT 428, 31, 'اردكان'"
                + "UNION SELECT 429, 31, 'ابركوه'"
                + "UNION SELECT 430, 31, 'ميبد'"
                + "UNION SELECT 431, 31, 'طبس'"
                + "UNION SELECT 432, 31, 'بافق'"
                + "UNION SELECT 433, 31, 'مهريز'"
                + "UNION SELECT 434, 31, 'اشكذر'"
                + "UNION SELECT 435, 31, 'هرات'"
                + "UNION SELECT 436, 31, 'خضرآباد'"
                + "UNION SELECT 437, 31, 'شاهديه'"
                + "UNION SELECT 438, 31, 'حمیدیه شهر'"
                + "UNION SELECT 439, 31, 'سید میرزا'"
                + "UNION SELECT 440, 31, 'زارچ'"

                + ";"
                );
    } // End insert_Total_Cities
} // End class dbAdapter
