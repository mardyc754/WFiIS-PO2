public class Statek{
    protected String name;
    
    public Statek(String name){
        this.name = name;
    }

    public String toString(){
        return "Statek[" + name + "]";
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){ return name; }
}

class Okret extends Statek implements UczestnikBitwy, Silnikowy{
    int ammo;
    int power;
    public Okret(String name){
        super(name);
        ammo = 100;
    }
    public String toString(){
        return "Okret[" + name + "]";
    }
    public int amunicja(){ return ammo; }
    public void strzelaj(){ ammo--; }

    public void deleteAmmo(){ ammo = 0;}
    public void zwiekszMoc(int value){ power += value; }

}

class Liniowiec extends Statek implements Pasazerski, Silnikowy{
    int power;
    public Liniowiec(String name){
        super(name);
    }
    public String toString(){
        return "Liniowiec[" + name + "]";
    }
    public void zwiekszMoc(int value){ power += value; }
}

class Zaglowiec extends Statek implements Pasazerski{
    public Zaglowiec(){ super(""); }

}