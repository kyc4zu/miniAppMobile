package kevinchau.miniappmobile;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.io.Serializable;
import java.util.Date;

public class BucketItem implements Serializable {

    private String mName;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;
    private String mDate;

    public BucketItem(String name, String description, double latitude, double longitude, String date) {

        mName = name;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;
        mDate = date;

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

    public void setLat(double lat) {
        mLatitude = lat;
    }

    public double getLat() {

        return mLatitude;

    }

    public void setLong(double lon) {
        mLongitude = lon;
    }

    public double getLong() {

        return mLongitude;

    }
    public void setDate(String date) {
        mDate = date;
    }


    public String getDate() {
        return mDate;

    }

        private static int lastItemId = 3; //3 cause 3 items already in

    public static ArrayList<BucketItem> CreateInitialBucketList(int numItems) {

        ArrayList<BucketItem> bucketlist = new ArrayList<BucketItem>();

        Calendar c = Calendar.getInstance();
        long date = c.get(Calendar.DATE);

        /*for (int i = 1; i <= numItems; i++) {
            bucketlist.add(new BucketItem("Item #" + ++lastItemId,"", 0.0, 0.0, date));
        }*/

        bucketlist.add(new BucketItem("Get the first Bodos ticket","Be the first person to order at Bodos on the Corner.", 0, 0, "2017-1-30"));
        bucketlist.add(new BucketItem("Apply for graduation","Make sure all major and minor requirements are fulfilled.", 0, 0, "2017-1-30"));
        bucketlist.add(new BucketItem("Visit Monticello","Visit the home of our founder.", 0, 0, "2017-1-30"));

        return bucketlist;

    }

}