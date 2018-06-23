package com.unisbadri.browsery.options;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

public class BrowserOptions extends JSONObject implements Parcelable {
    public static final String BROWSER_OPTIONS = "browseryOptions";

    public static final Integer BROWSER_DEFAULT = 0;

    private String BROWSER_TYPE = "";
    private String URL = "url";
    private String TITLE = "title";

    private String TRACKING_HISTORY = "trackingHistory";

    public BrowserOptions() {
        setBrowserType(BROWSER_DEFAULT);
    }

    public void unpack(String optionsPacked) {
        try {
            JSONObject object = new JSONObject(optionsPacked);

            setUrl(object.getString(URL));
            setTitle(object.getString(TITLE));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    public String pack() {
        return toString();
    }

    public void setBrowserType(Integer browserType) {
        putProperty(BROWSER_TYPE, browserType);
    }

    public Integer getBrowserType() {
        return (Integer) getProperty(BROWSER_TYPE);
    }

    public void setUrl(String url) {
        putProperty(URL, url);
    }

    public String getUrl() {
        return (String) getProperty(URL);
    }

    public void setTitle(String title) {
        putProperty(TITLE, title);
    }

    public String getTitle() {
        return (String) getProperty(TITLE);
    }

    public void trackHistory(Boolean isTrackingHistory) {
        putProperty(TRACKING_HISTORY, isTrackingHistory);
    }

    public Boolean isTrackingHistory() {
        return (Boolean) getProperty(TRACKING_HISTORY);
    }

    private void putProperty(String key, Object object) {
        try {
            put(key, object);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private Object getProperty(String key) {
        try {
            return get(key);
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(toString());
    }

    public static final Parcelable.Creator<BrowserOptions> CREATOR = new Parcelable.Creator<BrowserOptions>() {
        public BrowserOptions createFromParcel(Parcel in) {
            return new BrowserOptions(in);
        }

        public BrowserOptions[] newArray(int size) {
            return new BrowserOptions[size];
        }
    };

    private BrowserOptions(Parcel in) {
        unpack(in.readString());
    }
}
