package rose.com.retrofit.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Items {
    @SerializedName("items")
    public List<Jadwal> items;

    public List<Jadwal> getItems() {

        return items;
    }

    public void setItem(List<Jadwal> item) {
        this.items = items;
    }

    public Items(List<Jadwal> items) {
        this.items = items;
    }
}
