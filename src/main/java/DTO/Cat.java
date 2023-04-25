package DTO;

public class Cat
{
    int catId;
    String name;

    float weight;

    public Cat(String name, int catId, float weight)
    {
        this.name = name;
        this.catId = catId;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public int getCatId()
    {
        return catId;
    }

    public float getWeight()
    {
        return weight;
    }

    @Override
    public String toString()
    {
        return "Cat{" +
                "name='" + name + '\'' +
                ", catId=" + catId +
                ", weight=" + weight +
                '}';
    }
}
