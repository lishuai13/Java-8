package entity;

/**
 * Person
 *
 * @author Zebe
 */
public class Person {

    /**
     * 所在城市
     */
    private City city;

    /**
     * 身高
     */
    private int height;

    /**
     * 构造器
     * @param city 所在城市
     * @param height 身高
     */
    public Person(City city, int height) {
        this.city = city;
        this.height = height;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}
