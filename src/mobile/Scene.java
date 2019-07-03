package mobile;

/**
 * Create by mysteriousTime
 * time on 2019/6/28  16:31
 */
public class Scene {//使用场景
    private String type;//场景消费类型
    private int data;//场景消费数据
    private String description;//场景描述
    private double price;//场景消费金额

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Scene(){}

    public Scene(String type, int data, String description, double price) {
        this.type = type;
        this.data = data;
        this.description = description;
        this.price = price;
    }

}
