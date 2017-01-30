package kevinchau.miniappmobile;

/**
 * Created by Brittany Crow on 1/28/2017.
 */

import java.util.ArrayList;
import java.util.Calendar;

public class BucketItem {

    private String mName;
    private String mDescription;
    private double mLatitude;
    private double mLongitude;
    private long mDate;

    public BucketItem(String name, String description, double latitude, double longitude, long date) {

        mName = name;
        mDescription = description;
        mLatitude = latitude;
        mLongitude = longitude;
        mDate = date;

    }

    public String getName() {

        return mName;

    }

    public String getDesc() {

        return mDescription;

    }

    public double getLat() {

        return mLatitude;

    }

    public double getLong() {

        return mLongitude;

    }

    public long getDate() {

        return mDate;

    }

    private static int lastItemId = 0;

    public static ArrayList<BucketItem> createBucketList(int numItems) {

        ArrayList<BucketItem> bucketlist = new ArrayList<BucketItem>();

        Calendar c = Calendar.getInstance();
        int date = c.get(Calendar.DATE);

        /*for (int i = 1; i <= numItems; i++) {
            bucketlist.add(new BucketItem("Item #" + ++lastItemId,"", 0.0, 0.0, date));
        }*/

        bucketlist.add(new BucketItem("Get the first Bodos ticket","Be the first person to order at Bodos on the Corner.", 0.0, 0.0, date));
        bucketlist.add(new BucketItem("Apply for graduation","Make sure all major and minor requirements are fulfilled.", 0.0, 0.0, date));
        bucketlist.add(new BucketItem("Visit Monticello","Visit the home of our founder.", 0.0, 0.0, date));

        return bucketlist;

    }

}