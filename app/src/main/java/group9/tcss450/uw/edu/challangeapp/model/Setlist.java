package group9.tcss450.uw.edu.challangeapp.model;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/**
 * Created by daniel on 2/15/17.
 */

public class Setlist implements Serializable {
//    private static Set<JSONArray> mJSONArraySet;
//
//    public static Setlist getSetlist(JSONObject jsonObject) throws JSONException {
//        JSONArray jsonArray = new JSONArray();
//        try {
//            jsonArray = jsonObject.getJSONArray("date");
//        } catch (JSONException e) {
//            e.printStackTrace();
//        }
//        Setlist result = new Setlist();
//        result.mJSONArraySet.add(jsonArray);
//        return result;
//    }
//
//    public static Set<JSONArray> getmJSONArraySet() {
//        return mJSONArraySet;
//    }
//
//    public static void setmJSONArraySet(Set<JSONArray> mJSONArraySet) {
//        Setlist.mJSONArraySet = mJSONArraySet;
//    }

    private Integer showid;
    private String showdate;
    private String shortDate;
    private String longDate;
    private String relativeDate;
    private String url;
    private String gapchart;
    private String artist;
    private Integer artistid;
    private Integer venueid;
    private String venue;
    private String location;
    private String setlistdata;
    private String setlistnotes;
    private String rating;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public static Setlist setlistFromJson(final JSONObject setlist) throws JSONException {
        final Setlist result = new Setlist();
        try {
            Iterator<String> it = setlist.keys();
            while(it.hasNext()) {
                String next = it.next();
                Field f = result.getClass().getDeclaredField(next);
                f.set(result, setlist.get(next));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public Integer getShowid() {
        return showid;
    }

    public void setShowid(Integer showid) {
        this.showid = showid;
    }

    public String getShowdate() {
        return showdate;
    }

    public void setShowdate(String showdate) {
        this.showdate = showdate;
    }

    public String getShortDate() {
        return shortDate;
    }

    public void setShortDate(String shortDate) {
        this.shortDate = shortDate;
    }

    public String getLongDate() {
        return longDate;
    }

    public void setLongDate(String longDate) {
        this.longDate = longDate;
    }

    public String getRelativeDate() {
        return relativeDate;
    }

    public void setRelativeDate(String relativeDate) {
        this.relativeDate = relativeDate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getGapchart() {
        return gapchart;
    }

    public void setGapchart(String gapchart) {
        this.gapchart = gapchart;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public Integer getArtistid() {
        return artistid;
    }

    public void setArtistid(Integer artistid) {
        this.artistid = artistid;
    }

    public Integer getVenueid() {
        return venueid;
    }

    public void setVenueid(Integer venueid) {
        this.venueid = venueid;
    }

    public String getVenue() {
        return venue;
    }

    public void setVenue(String venue) {
        this.venue = venue;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getSetlistdata() {
        return setlistdata;
    }

    public void setSetlistdata(String setlistdata) {
        this.setlistdata = setlistdata;
    }

    public String getSetlistnotes() {
        return setlistnotes;
    }

    public void setSetlistnotes(String setlistnotes) {
        this.setlistnotes = setlistnotes;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
