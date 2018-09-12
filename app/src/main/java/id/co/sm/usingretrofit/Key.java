package id.co.sm.usingretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Key {

    public Key(String q, String key) {
        this.q = q;
        this.key = key;
    }

    @SerializedName("q")
    @Expose
    private String q;

    @SerializedName("key")
    @Expose
    private String key;

    public String getQ() {
        return q;
    }

    public void setQ(String q) {
        this.q = q;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public Key(){}



}
