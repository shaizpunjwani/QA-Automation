package API;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

public class GetResponse {

    List<Integer> ids = new ArrayList<>();
    List<String> names = new ArrayList<>();
    List<String> emails = new ArrayList<>();
    List<String> genders = new ArrayList<>();
    List<String> statuses = new ArrayList<>();

    public void GetGson(String response_string) {
        Gson gson = new Gson();
        ChildResponse[] child = gson.fromJson(response_string, ChildResponse[].class);
        for (ChildResponse ch : child) {
            ids.add(ch.getId());
            names.add(ch.getName());
            emails.add(ch.getEmail());
            genders.add(ch.getGender());
            statuses.add(ch.getStatus());
        }
    }

    public List<Integer> getIds() {
        return ids;
    }

    public List<String> getNames() {
        return names;
    }

    public List<String> getEmails() {
        return emails;
    }

    public List<String> getGenders() {
        return genders;
    }

    public List<String> getStatuses() {
        return statuses;
    }

}
