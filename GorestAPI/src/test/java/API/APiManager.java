package API;

public class APiManager {

    private GetAPI fetch_data;

    public GetAPI FetchingData(){
        fetch_data=new GetAPI();
        return fetch_data;
    }
}
