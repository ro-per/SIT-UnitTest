import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TestBoek {
    /*  REEKS 1 */
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
    Reeks reeksNull = null;
    Auteur aNull = new Auteur("Eric", "FREEMAN");

    String titelNull = null;
    String isbnNull = null;
    Boek bNull = new Boek(titelNull, isbnNull); //REEKSLOOS


    /**
     * -------------------- ISBN IS EEN STRING-OBJECT --------------------
     **/
    //TODO
    @Test
    void getISBN() {
        //getISBN: String-object is NIET null
        assertEquals(isbn1, b1.getISBN());

        //getISBN: String-object is null
        assertNull(isbnNull);

        //getISBN: isbn is geen String-object
        // TODO kan niet voorkomen, Boek boek = new Boek("string", 245); zal niet compileren

    }
    //TODO
    @Test
    void getAuteurs() {
        /**-------------------- AUTEURS IS EEN LIST-OBJECT --------------------**/
        //boek.getAuteurs: List-object is een NIET lege lijst
        b7.addAuteur(a1);
        b7.addAuteur(a2);
        List<Auteur> auteursVerwacht = new ArrayList<>();
        auteursVerwacht.add(a1);
        auteursVerwacht.add(a2);
        assertEquals(auteursVerwacht, b7.getAuteurs());

        //boek.getAuteurs: List-object is een lege lijst
        assertEquals(new ArrayList<>(), bNull.getAuteurs());

        //boek.getAuteurs: List-object is null //TODO kan dit ????


    }


    /**
     * -------------------- REEKS IS EEN REEKS-OBJECT --------------------
     **/
    //TODO
    @Test
    void testGetReeks() {
        //boek.getReeks: Reeks-object is NIET nulll
        assertEquals(milleniumTrilogie, b1.getReeks());

        //TODO EXCEPTION
        //boek.getReeks: Reeks-object is null
        assertNull(bNull.getReeks());

        //boek.getReeks: Reeks-object bestaand niet (reeks-attribuut is standaard null)
    }

    @Test
    void testSetReeks() {
        //setReeks: reeks-object
        b7.setReeks(programming);
        assertEquals(programming, b7.getReeks());
        //setReeks: null
        b7.setReeks(null);
        assertEquals(null, b7.getReeks());
    }
    //TODO
    @Test
    void testBehoortTotReeks() {
        //behoortTotReeks: boek behoort tot reeks
        assertTrue(b1.behoortTotReeks(milleniumTrilogie));
        //behoortTotReeks: boek behoort tot andere reeks
        assertFalse(b6.behoortTotReeks(milleniumTrilogie));

//TODO nullpointer exception
        try {
            //behoortTotReeks: boek heeft geen reeks
            bNull.behoortTotReeks(milleniumTrilogie);

            //behoortTotReeks: reeks is null //EXCEPTION
            assertFalse(bNull.behoortTotReeks(null));

            fail("expected NullpointerException");
        } catch (NullPointerException e) {
        }

    }

    /**
     * -------------------- AUTEUR IS EEN AUTEUR-OBJECT --------------------
     **/
    //TODO
    @Test
    void addAuteur() {
        //boek.getReeks: reeks bevat auteur
        List<Auteur> testAuteurs1 = new ArrayList<>();
        testAuteurs1.add(auteurMillenium);
        b1.addAuteur(auteurMillenium);
        assertEquals(testAuteurs1, b1.getAuteurs());

        //boek.getReeks: reeks bevat GEEN auteur
        List<Auteur> testAuteurs2 = new ArrayList<>();
        assertEquals(testAuteurs2, bNull.getAuteurs());

        //boek.getAuteurs.getAuteur: auteur aanwezig
        assertEquals(auteurMillenium, b1.getAuteurs().get(0));
    }
    //TODO
    @Test
    void heeftAuteur() {
        //boek.heeftAuteur: boek heeft een auteur
        b4.addAuteur(auteurDeZevenZussen);
        assertTrue(b4.heeftAuteur(auteurDeZevenZussen));
        //boek.heeftAuteur: boek heeft GEEN auteur
        assertFalse(b5.heeftAuteur(auteurDeZevenZussen));
    }

    /**
     * -------------------- TITEL IS EEN STRING-OBJECT --------------------
     **/
    //TODO
    @Test
    void testHeeftTitel() {
        //BOEK HEEFT STEEDS EEN TITEL (GEEN DEFAULT CONSTRUCTOR)

        //boek.heeftTitel: boek heeft een dezelfde titel
        assertTrue(b1.heeftTitel(titel1));

        //boek.heeftTitel: boek heeft een andere titel
        assertFalse(b1.heeftTitel(titel2));
    }
    //TODO
    @Test
    void testGetTitle() {
        //boek.getTitel: String-object is NIET NULL
        assertEquals(titel6, b6.getTitel());

        //boek.getTitel: String-object is NULL
        assertNull(bNull.getTitel());
    }


    /**
     * -------------------- TESTEN OP ANDERE METODES --------------------
     **/
    //TODO
    @Test
    void testToString() {
        //attributen van boek zijn NIET null
        String toString = "Boek [ISBN=" + isbn1 + ", auteurs=[" + auteurMillenium.toString() + "]]Medium [titel=" + titel1 + ", reeks=" + reeksNaamMillenium + "]";
        b1.addAuteur(auteurMillenium);
        assertEquals(toString, b1.toString());

        //attributen van boek zijn null
        String toStringNull = "Boek [ISBN=null, auteurs=[]]Medium [titel=null, reeks=null]";
        assertEquals(toStringNull, bNull.toString());
    }

    @Test
    void testHashCode() {
        //hashCode: verschillend object, intern gelijk
        assertEquals(b0.hashCode(), b1.hashCode());
        //hashCode: zelfde object
        assertEquals(b7.hashCode(), b7.hashCode());

    }

    @Test
    void testEquals() {
        //equals: verschillend object, intern gelijk
        assertTrue(b0.equals(b1));
        //equals: zelfde object
        assertTrue(b1.equals(b1));
        //equals: objecten van verschillend type
        assertFalse(b1.equals(a2));
        //equals: objecten zijn van een ander soort
        assertFalse(b1.equals(a1));

    }

}