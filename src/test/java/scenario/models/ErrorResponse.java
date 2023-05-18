package scenario.models;

import java.util.List;

public class ErrorResponse {
    private List<Error> data;
    private Object meta;

    public List<Error> getData() {
        return data;
    }

    public void setData(List<Error> data) {
        this.data = data;
    }

    public Object getMeta() {
        return meta;
    }

    public void setMeta(Object meta) {
        this.meta = meta;
    }
}
