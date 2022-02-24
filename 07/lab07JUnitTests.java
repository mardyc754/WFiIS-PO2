/*

# pobranie JUnit-a
wget https://repo1.maven.org/maven2/org/junit/platform/junit-platform-console-standalone/1.8.1/junit-platform-console-standalone-1.8.1.jar

# kompilacja testów i reszty projektu
javac *.java -cp junit-platform-console-standalone-1.8.1.jar 

# uruchomienie testów
java -jar junit-platform-console-standalone-1.8.1.jar -cp .  --scan-class-path

# https://en.wikipedia.org/wiki/HMS_Vanguard_(23)
# https://en.wikipedia.org/wiki/Titanic
# https://en.wikipedia.org/wiki/German_battleship_Bismarck
# https://en.wikipedia.org/wiki/HMS_King_George_V_(41)

*/


import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class lab07JUnitTests {
    
    @Test
    public void testA__1_punkt() {
        Statek s = new Statek("moj kajak");
        assertEquals("Statek[moj kajak]", s+"" );
        
        Okret o = new Okret("HMS Vanguard");
        assertEquals("Okret[HMS Vanguard]", o+"" );
        
        Liniowiec l = new Liniowiec("RMS Titanic");
        assertEquals("Liniowiec[RMS Titanic]", l+"" );
    }
    
    @Test
    public void testB__1_punkt() {
        Object obj1 = new Okret("HMS Vanguard");
        Object obj2 = new Liniowiec("RMS Titanic");
        
        Statek s1 = (Statek) obj1;
        Statek s2 = (Statek) obj2;
        
        Okret o1 = (Okret) s1;
        Liniowiec l1 = (Liniowiec) s2;
        
        assertThrows(ClassCastException.class, () -> { Okret x = (Okret) s2; } );
        assertThrows(ClassCastException.class, () -> { Liniowiec x = (Liniowiec) s1; } );        
    }
    
    @Test
    public void testC__1_punkt() {
        UczestnikBitwy okretRoyalNavy = new Okret("HMS Vanguard");
        UczestnikBitwy okretKriegsmarine = new Okret("Bismarck");
        Pasazerski statekWhiteStarLine = new Liniowiec("RMS Titanic");
        Pasazerski luxTorpeda = new Pociag();
        Object o1 = okretRoyalNavy;
        Object o2 = statekWhiteStarLine;
        assertThrows(ClassCastException.class, () -> { UczestnikBitwy x = (UczestnikBitwy) o2; } );
        assertThrows(ClassCastException.class, () -> { Pasazerski x = (Pasazerski) o1; } );
    }

    @Test
    public void testD__2_punkty() {
        Okret vanguard = new Okret("HMS Vanguard");
        UczestnikBitwy okretRoyalNavy = vanguard;
        UczestnikBitwy okretKriegsmarine = new Okret("Bismarck");
        
        int poczatkowyZapasAmunicji = 100;
        
        assertEquals(poczatkowyZapasAmunicji, vanguard.amunicja() );
        assertEquals(poczatkowyZapasAmunicji, okretKriegsmarine.amunicja() );
        
        vanguard.strzelaj();
        okretKriegsmarine.strzelaj();
        vanguard.strzelaj();
        
        assertEquals(poczatkowyZapasAmunicji-2, vanguard.amunicja() );
        assertEquals(poczatkowyZapasAmunicji-1, okretKriegsmarine.amunicja() );
    }
    
    @Test
    public void testE__1_punkt() {
        UczestnikBitwy okretRoyalNavy = new Okret("HMS King George V");
        assertEquals("Okret[HMS King George V]", okretRoyalNavy+"" );
        
        UczestnikBitwy okretKriegsmarine = new Okret("Bismarck");
        assertEquals("Okret[Bismarck]", okretKriegsmarine+"" );
        
        UczestnikBitwy.zatapia(okretKriegsmarine);
        
        assertEquals("Okret[Bismarck - wrak]", okretKriegsmarine+"" );
        assertEquals(0, okretKriegsmarine.amunicja() );
    }   
    
    @Test
    public void testF__2_punkty() {
        Statek titanic = new Liniowiec("RMS Titanic");
        Pasazerski p = (Liniowiec) titanic;
        
        p.ustawCeneBiletu(999);
        Pasazerski.Bilet biletNormalnie = p.bilet();
        assertEquals( 999 , biletNormalnie.cena() );
        
        p.ustawCeneBiletu(1199);
        Pasazerski.Bilet biletBlackFriday = p.bilet();
        assertEquals( 1199 , biletBlackFriday.cena() );
        
    }
    
    @Test
    public void testG__2_punkty() {
        Silnikowy s1 = new Okret("HMS Vanguard");
        Silnikowy s2 = new Liniowiec("RMS Titanic");
        s1.zwiekszMoc(Silnikowy.MOC_MAX);
        s2.zwiekszMoc(Silnikowy.MOC_MAX-1);
        
        Statek s = new Statek("moj kajak");
        assertThrows(ClassCastException.class, () -> { Silnikowy s3 = (Silnikowy) s; } );
        
        Pasazerski p = new Pociag();
        Silnikowy s4 = (Silnikowy)p;
        Pasazerski z = new Zaglowiec();
        assertThrows(ClassCastException.class, () -> { Silnikowy s5 = (Silnikowy) z; } );
    }    

}
