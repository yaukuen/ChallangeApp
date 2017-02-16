package group9.tcss450.uw.edu.challangeapp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by daniel on 2/15/17.
 */

public class Setlist implements Serializable {
    private static int mShowid;
    private static String mShowdate;
    private static String mShort_date;
    private static String mLong_date;
    private static String mRelative_date;
    private static String mUrl;
    private static String mGapchart;
    private static String mArtist;
    private static int mArtistid:
    private static int mVenueid:
    private static String mVenue;
    private static String mLocation;
    private static String mSetlistdate;
    private static String mSetlistnotes;
    private static String mRating;

    public static Setlist getSetlist(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray = jsonObject.getJSONArray("date");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        mShowid = jsonArray.getInt(0);
        mShowdate = jsonArray.getString(1);
        mShort_date = jsonArray.getString(2);

    }
}
