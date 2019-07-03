package SoSoMobile.entity;

/**
 * Create by mysteriousTime
 * time on 2019/7/1  22:40
 */


/**
 * 嗖嗖移动卡套餐
 */
public abstract class ServicePackage {
    protected double price;  //套餐月资费(元)

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    //显示套餐数据
    public abstract void showInfo();
}
