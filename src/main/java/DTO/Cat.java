package DTO;

public class Cat
{
    String name;
    int id;
    float weight;

    public Cat(String name, int id, float weight)
    {
        this.name = name;
        this.id = id;
        this.weight = weight;
    }

    public String getName()
    {
        return name;
    }

    public int getId()
    {
        return id;
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
                ", id=" + id +
                ", weight=" + weight +
                '}';
    }
}
