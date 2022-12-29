public class CostumerCall {
    private String name, id, description;

    public CostumerCall(String name, String id, String description) {
        this.name = name;
        this.id = id;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return "Name:"+this.name+" ID:"+this.id+" Description:"+this.description;
    }
}
