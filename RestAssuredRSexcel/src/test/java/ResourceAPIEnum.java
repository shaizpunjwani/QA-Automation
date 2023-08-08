public enum ResourceAPIEnum {

    addplace("/maps/api/place/add/json"),
    updateplace("/maps/api/place/update/json"),
    getplace("/maps/api/place/get/json");
    private String resource;


    ResourceAPIEnum(String s) {
        this.resource=s;
    }

    public String getResource(){
        return resource;
    }
}
