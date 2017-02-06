package kevinchau.miniappmobile;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.io.Serializable;
import java.text.DateFormat;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;

public class BucketItem implements Serializable {

    private String mName;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;
    private String mDate;
    private boolean checked;

    public BucketItem(String name, String description, double latitude, double longitude, String date) {

        mName = name;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;
        mDate = date;
        checked = false;

    }

    public String getName() {

        return mName;

    }

    public void setName(String name) {
        mName = name;
    }



    public String getDesc() {

        return mDescription;

    }
    public void setDesc(String desc) {
        mDescription = desc;
    }

    public double getLat() {

        return mLatitude;

    }
    public void setLat(double lat) {
        mLatitude = lat;
    }


    public double getLong() {

        return mLongitude;

    }
    public void setLong(double lon) {
        mLongitude = lon;
    }

    public String getDate() {
        return mDate;

    }
    public void setDate(String date) {
        mDate = date;
    }

    public boolean getChecked(){

        return checked;

    }
    public void setChecked(boolean check) {

        checked = check;

    }
        private static int lastItemId = 3; //3 cause 3 items already in

    public static ArrayList<BucketItem> CreateInitialBucketList(int numItems) {

        ArrayList<BucketItem> bucketlist = new ArrayList<BucketItem>();

        Calendar c = Calendar.getInstance();
        long date = c.get(Calendar.DATE);

        /*for (int i = 1; i <= numItems; i++) {
            bucketlist.add(new BucketItem("Item #" + ++lastItemId,"", 0.0, 0.0, date));
        }*/

        bucketlist.add(new BucketItem("Get the first Bodos ticket","Be the first person to order at Bodos on the Corner.", 0, 0, "2016-01-01"));
        bucketlist.add(new BucketItem("Apply for graduation","Make sure all major and minor requirements are fulfilled.", 0, 0, "2017-01-15"));
        bucketlist.add(new BucketItem("Visit Monticello","Visit the home of our founder.", 0, 0, "2016-01-30"));

        return sort(bucketlist);

    }
    public static ArrayList<BucketItem> sort(ArrayList<BucketItem> bucketlist) {

        Collections.sort(bucketlist, new Comparator<BucketItem>() {
            @Override
            public int compare(BucketItem first, BucketItem second) {
                // parse string date into long for comparison
                String string_date1 = first.getDate();
                String string_date2 = second.getDate();
                long mill1 = 0;
                long mill2 = 0;

                SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
                try {
                    Date d = f.parse(string_date1);
                    mill1 = d.getTime();

                    Date d1 = f.parse(string_date2);
                    mill2 = d1.getTime();
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                // compare by check
                if (first.getChecked())
                    return 1;

                // compare by date
                if (mill1 > mill2)
                    return 1;

                else if (mill1 < mill2)
                    return -1;

                return 0;
            }
        });

        return bucketlist;
    }

}