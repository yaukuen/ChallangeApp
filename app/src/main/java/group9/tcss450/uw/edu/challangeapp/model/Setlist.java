package group9.tcss450.uw.edu.challangeapp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.Set;

/**
 * Created by daniel on 2/15/17.
 */

public class Setlist implements Serializable {
    private static Set<JSONArray> mJSONArraySet;

    public static Setlist getSetlist(JSONObject jsonObject) throws JSONException {
        JSONArray jsonArray = new JSONArray();
        try {
            jsonArray = jsonObject.getJSONArray("date");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        Setlist result = new Setlist();
        result.mJSONArraySet.add(jsonArray);
        return result;
    }

    public static Set<JSONArray> getmJSONArraySet() {
        return mJSONArraySet;
    }

    public static void setmJSONArraySet(Set<JSONArray> mJSONArraySet) {
        Setlist.mJSONArraySet = mJSONArraySet;
    }
}
