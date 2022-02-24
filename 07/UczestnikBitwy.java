public interface UczestnikBitwy {
    int amunicja();
    void strzelaj();
    static void zatapia(UczestnikBitwy ucz){
        Okret okr = (Okret) ucz;
        okr.setName(okr.getName() + " - wrak");
        okr.deleteAmmo();
    }
}
