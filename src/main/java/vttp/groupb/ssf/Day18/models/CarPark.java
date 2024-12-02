package vttp.groupb.ssf.Day18.models;

public class CarPark {

    private int id;
    private String carPark;
    private String category;
    private String weekdayRate1;
    private String weekdayRate2;
    private String saturdayRate;
    private String sundayRate;

    public CarPark() {
    }

    public CarPark(int id, String carPark, String category, String weekdayRate1, String sundayRate, String weekdayRate2, String saturdayRate) {
        this.id = id;
        this.carPark = carPark;
        this.category = category;
        this.weekdayRate1 = weekdayRate1;
        this.sundayRate = sundayRate;
        this.weekdayRate2 = weekdayRate2;
        this.saturdayRate = saturdayRate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarPark() {
        return carPark;
    }

    public void setCarPark(String carPark) {
        this.carPark = carPark;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getWeekdayRate1() {
        return weekdayRate1;
    }

    public void setWeekdayRate1(String weekdayRate1) {
        this.weekdayRate1 = weekdayRate1;
    }

    public String getWeekdayRate2() {
        return weekdayRate2;
    }

    public void setWeekdayRate2(String weekdayRate2) {
        this.weekdayRate2 = weekdayRate2;
    }

    public String getSaturdayRate() {
        return saturdayRate;
    }

    public void setSaturdayRate(String saturdayRate) {
        this.saturdayRate = saturdayRate;
    }

    public String getSundayRate() {
        return sundayRate;
    }

    public void setSundayRate(String sundayRate) {
        this.sundayRate = sundayRate;
    }

    @Override
    public String toString() {
        return "CarPark{" +
                "id=" + id +
                ", carPark='" + carPark + '\'' +
                ", category='" + category + '\'' +
                ", weekdayRate1='" + weekdayRate1 + '\'' +
                ", weekdayRate2='" + weekdayRate2 + '\'' +
                ", saturdayRate='" + saturdayRate + '\'' +
                ", sundayRate='" + sundayRate + '\'' +
                '}';
    }
}
