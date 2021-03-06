package tests;

import media.Boek;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import stubs.Auteur;
import stubs.Reeks;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestBoek {
    /*  REEKS 1  */
    String reeksNaamMillenium = "De Millenium Trilogie";
    Reeks milleniumTrilogie = new Reeks(reeksNaamMillenium);
    Auteur auteurMillenium = new Auteur("Stieg", "LARSON");

    String titel1 = "Mannen die vrouwen haten";
    String isbn1 = "9789056726201";
    Boek b1 = new Boek(titel1, milleniumTrilogie, isbn1);

    Boek b0 = new Boek(titel1, milleniumTrilogie, isbn1);


    String titel2 = "De vrouw die met vuur speelde";
    String isbn2 = "9789056725884";
    Boek b2 = new Boek(titel2, milleniumTrilogie, isbn2);

    String titel3 = "Gerechtigheid";
    String isbn3 = "9789056725891";
    Boek b3 = new Boek(titel3, milleniumTrilogie, isbn3);

    /*  REEKS 2 */
    Reeks deZevenZussen = new Reeks("De zeven zussen");
    Auteur auteurDeZevenZussen = new Auteur("Lucinda", "RILEY");

    String titel4 = "Maia's verhaal";
    String isbn4 = "9789401608299";
    Boek b4 = new Boek(titel4, deZevenZussen, isbn4); //AUTEURLOOS

    String titel5 = "Ally's verhaal";
    String isbn5 = "9789401608305";
    Boek b5 = new Boek(titel5, deZevenZussen, isbn5);

    String titel6 = "Stars verhaal";
    String isbn6 = "9789401608725";
    Boek b6 = new Boek(titel6, deZevenZussen, isbn6);

    /*  REEKS 3 */
    Reeks programming = new Reeks("Programming");
    Auteur a1 = new Auteur("Eric", "FREEMAN");
    Auteur a2 = new Auteur("Elisabeth", "ROBSON");

    String titel7 = "Head first Design Patterns";
    String isbn7 = "9780596007126";
    Boek b7 = new Boek(titel7, isbn7); //REEKSLOOS

    /*  REEKS 3 */
    String titelNull = null;
    String isbnNull = null;
    Boek bNull = new Boek(titelNull, isbnNull); //REEKSLOOS


    /*-------------------- ISBN IS EEN STRING-OBJECT --------------------*/
    @Test
    void getISBN() {
        //getISBN: String-object is NIET null
        Assertions.assertEquals(isbn1, b1.getISBN());
        //getISBN: String-object is null
        assertNull(isbnNull);
    }

    /* -------------------- REEKS IS EEN REEKS-OBJECT --------------------*/
    @Test
    void testGetReeks() {
        //boek.getReeks: stubs.Reeks-object is NIET nulll
        Assertions.assertEquals(milleniumTrilogie, b1.getReeks());
        //boek.getReeks: stubs.Reeks-object is null
        assertNull(bNull.getReeks());
    }

    @Test
    void testSetReeks() {
        //setReeks: reeks-object
        b7.setReeks(programming);
        Assertions.assertEquals(programming, b7.getReeks());
        //setReeks: null
        b7.setReeks(null);
        assertNull(b7.getReeks());
    }


    @Test
    void testBehoortTotReeks() {
        //behoortTotReeks: boek behoort tot reeks
        Assertions.assertTrue(b1.behoortTotReeks(milleniumTrilogie));
        //behoortTotReeks: boek behoort tot andere reeks
        Assertions.assertFalse(b6.behoortTotReeks(milleniumTrilogie));
    }

    /*-------------------- AUTEUR IS EEN AUTEUR-OBJECT --------------------*/
    @Test
    void addAuteur() {
        //boek.getReeks: reeks bevat auteur
        List<Auteur> testAuteurs1 = new ArrayList<>();
        testAuteurs1.add(auteurMillenium);
        b1.addAuteur(auteurMillenium);
        Assertions.assertEquals(testAuteurs1, b1.getAuteurs());
        //boek.getAuteurs: List-object is een lege lijst
        List<Auteur> testAuteurs2 = new ArrayList<>();
        Assertions.assertEquals(testAuteurs2, bNull.getAuteurs());
    }

    @Test
    void getAuteurs() {
        //boek.getAuteurs: List-object is een NIET lege lijst
        b7.addAuteur(a1);
        b7.addAuteur(a2);
        List<Auteur> auteursVerwacht = new ArrayList<>();
        auteursVerwacht.add(a1);
        auteursVerwacht.add(a2);
        Assertions.assertEquals(auteursVerwacht, b7.getAuteurs());
        //boek.getAuteurs: List-object is een lege lijst
        Assertions.assertEquals(new ArrayList<>(), bNull.getAuteurs());
        //boek.getAuteurs: List-object is een NIET lege lijst, auteur is null
        bNull.addAuteur(null);
        List<Auteur> verwachtNull = new ArrayList<>();
        verwachtNull.add(null);
        Assertions.assertEquals(verwachtNull, bNull.getAuteurs());
        //boek.getAuteurs.getAuteur: auteur aanwezig
        b1.addAuteur(auteurMillenium);
        Assertions.assertEquals(auteurMillenium, b1.getAuteurs().get(0));
    }

    @Test
    void heeftAuteur() {
        //boek.heeftAuteur: boek heeft een auteur
        b4.addAuteur(auteurDeZevenZussen);
        Assertions.assertTrue(b4.heeftAuteur(auteurDeZevenZussen));
        //boek.heeftAuteur: boek heeft GEEN auteur
        Assertions.assertFalse(b5.heeftAuteur(auteurDeZevenZussen));
    }

    /*-------------------- TITEL IS EEN STRING-OBJECT --------------------*/
    @Test
    void testHeeftTitel() {
        //boek.heeftTitel: boek heeft een dezelfde titel
        Assertions.assertTrue(b1.heeftTitel(titel1));
        //boek.heeftTitel: boek heeft een andere titel
        Assertions.assertFalse(b1.heeftTitel(titel2));
    }

    @Test
    void testGetTitle() {
        //boek.getTitel: String-object is NIET NULL
        Assertions.assertEquals(titel6, b6.getTitel());
        Assertions.assertNotNull(b6.getTitel());
        //boek.getTitel: String-object is NULL
        assertNull(bNull.getTitel());
    }


    /* -------------------- TESTEN OP ANDERE METODES --------------------*/
    @Test
    void testToString() {
        //attributen van boek zijn NIET null
        String toString = "media.Boek [ISBN=" + isbn1 + ", auteurs=[" + auteurMillenium.toString() + "]]media.Medium [titel=" + titel1 + ", reeks=" + reeksNaamMillenium + "]";
        b1.addAuteur(auteurMillenium);
        Assertions.assertEquals(toString, b1.toString());
        //attributen van boek zijn null
        String toStringNull = "media.Boek [ISBN=null, auteurs=[]]media.Medium [titel=null, reeks=null]";
        Assertions.assertEquals(toStringNull, bNull.toString());
        Assertions.assertNotNull(bNull.toString());
        //NullPointerException
        Boek b = null;
        Assertions.assertThrows(NullPointerException.class, () -> b.toString());
    }

    @Test
    void testHashCode() {
        //hashCode: verschillend object, intern gelijk
        Assertions.assertEquals(b0.hashCode(), b1.hashCode());
        Assertions.assertNotNull(b0.hashCode());
        Assertions.assertNotNull(b1.hashCode());
        //hashCode: zelfde object
        Assertions.assertEquals(b7.hashCode(), b7.hashCode());
        //NullPointerException
        Boek b = null;
        Assertions.assertThrows(NullPointerException.class, () -> b.hashCode());
    }

    @Test
    void testEquals() {
        //equals: verschillend object, intern gelijk
        Assertions.assertTrue(b0.equals(b1));
        //equals: zelfde object
        Assertions.assertTrue(b1.equals(b1));
        //equals: objecten van verschillend type
        Assertions.assertFalse(b1.equals(a2));
        //equals: objecten zijn van een ander soort
        Assertions.assertFalse(b1.equals(a1));
        //NullPointerException
        Boek b8 = null;
        Boek b9 = null;
        Assertions.assertThrows(NullPointerException.class, () -> b8.equals(b9));
    }
}