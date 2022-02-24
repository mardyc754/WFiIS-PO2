public interface Pasazerski { 
    class Bilet{
        int price;
        public Bilet(){}
        public Bilet(int price){ this.price = price; }
        public int cena(){ return price;}
        public void setPrice(int price){ this.price = price; }
    }
    Bilet bilet = new Bilet();
    
    default void ustawCeneBiletu(int price){
        bilet.setPrice(price);
    }
    
    default public Bilet bilet(){
        return new Pasazerski.Bilet(bilet.cena());
    }
}
