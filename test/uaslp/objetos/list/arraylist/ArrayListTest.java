package uaslp.objetos.list.arraylist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import uaslp.objetos.list.Iterator;

public class ArrayListTest {

    @Test
    public void givenANewyList_thenSizeIsZero() {
        //Given
        LinkedList<String> lista = new LinkedList<>();


        //When
        int size = lista.getSize();
        //Then
        Assertions.assertEquals(0, size);
    }

    @Test
    public void givenANewyList_whenAddAtTail_ThenSizeOne() {
        //Given
        LinkedList<String> lista = new LinkedList<>();

        //When
        lista.addAtTail("Uno");

        //Then
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenANonEmptyList_whenAddAtTail_ThenSizeIsIncreased(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");

        //When
        lista.addAtTail("Dos");

        //Then
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
    }

    @Test
    public void givenANewList_whenAddAtFront_ThenSizeIsOne(){
        //Given
        LinkedList<String> lista = new LinkedList<>();

        //When
        lista.addAtFront("Uno");

        //Then
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals("Uno", lista.getAt(0));
    }

    @Test
    public void givenAList_whenGetAtIndexIsLessThan0_ThenReturnNull(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When
        String result = lista.getAt(-1);

        //Then
       Assertions.assertNull(result);
    }

    @Test
    public void givenAList_whenGetAtIndexGreaterThanSize_ThenReturnNull(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When
        String result = lista.getAt(1);

        //Then
        Assertions.assertNull(result);
    }

    @Test
    public void givenANonEmptyList_whenAddAtFront_ThenSizeIsIncreased(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When
        lista.addAtFront("Dos");

        //Then
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
    }

    @Test
    public void givenAList_whenRemoveLessThanZero_ThenReturnFalse(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When
        boolean result = lista.remove(-1);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAList_whenRemoveGreaterThanSize_ThenReturnFalse(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When
        boolean result = lista.remove(1);

        //Then
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWithOneElement_whenRemove0_ThenReturnTrue(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");

        //When
        boolean result = lista.remove(0);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveHead_ThenReturnTrue(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtFront("Uno");
        lista.addAtFront("Dos");

        //When
        boolean result = lista.remove(0);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    @Test
    public void givenAListWithTwoElements_whenRemoveTail_ThenReturnTrue(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtTail("Dos");

        //When
        boolean result = lista.remove(1);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(1, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Uno");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveMid_ThenReturnTrue(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        //When
        boolean result = lista.remove(1);

        //Then
        Assertions.assertTrue(result);
        Assertions.assertEquals(2, lista.getSize());
        Assertions.assertEquals(lista.getAt(0), "Dos");
        Assertions.assertEquals(lista.getAt(1), "Tres");
    }

    @Test
    public void givenAListWith3Elements_whenRemoveAll_ThenSizeIsZero(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        //When
        lista.removeAll();

        //Then
        Assertions.assertEquals(0, lista.getSize());
    }

    @Test
    public void givenAListWith3Elements_whenSetAt1_ThenElementIsModified(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        //When
        boolean result = lista.setAt(1, "Cuatro");

        //Then
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Cuatro", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
        Assertions.assertTrue(result);
    }

    @Test
    public void givenAListWith3Elements_whenSetAtLessThanZero_ThenReturnNull(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        //When
        boolean result =lista.setAt(-1, "Cuatro");

        //Then
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
        Assertions.assertFalse(result);
    }

    @Test
    public void givenAListWith3Elements_whenSetAtIndex3_ThenReturnNull(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");
        lista.addAtTail("Tres");

        //When
        boolean result =lista.setAt(3, "Cuatro");

        //Then
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Dos", lista.getAt(0));
        Assertions.assertEquals("Uno", lista.getAt(1));
        Assertions.assertEquals("Tres", lista.getAt(2));
        Assertions.assertFalse(result);
    }

    //copiar
    @Test
    public void givenAListWith2Elements_whenAddAtFront_ThenArrayIsIncreasedSuccessful(){
        //Given
        LinkedList<String> lista = new LinkedList<>();
        lista.addAtTail("Uno");
        lista.addAtFront("Dos");

        //When
        lista.addAtFront("Tres");

        //Then
        Assertions.assertEquals(3, lista.getSize());
        Assertions.assertEquals("Tres", lista.getAt(0));
        Assertions.assertEquals("Dos", lista.getAt(1));
        Assertions.assertEquals("Uno", lista.getAt(2));
    }

    //copiar
    @Test
    public void givenAnArray_whenRemoveAllWithValue_ThenValuesAreRemoved(){
        //Given
        LinkedList<Integer> lista = new LinkedList<>();
        lista.addAtFront(10);
        lista.addAtFront(20);
        lista.addAtTail(30);
        lista.addAtFront(20);
        lista.addAtTail(40);
        lista.addAtFront(20);
        lista.addAtTail(30);

        //When
        lista.removeAllWithValue(20);

        //Then
        Assertions.assertEquals(4, lista.getSize());
        Assertions.assertEquals(10, lista.getAt(0));
        Assertions.assertEquals(30, lista.getAt(1));
        Assertions.assertEquals(40, lista.getAt(2));
        Assertions.assertEquals(30, lista.getAt(3));
    }


    //copiar
    @Test
    public void givenAnArrayWithNoCoincidences_whenRemoveAllWithValue_ThenValuesAreRemoved(){
        //Given
        LinkedList<Integer> lista = new LinkedList<>();
        lista.addAtFront(10);
        lista.addAtTail(30);
        lista.addAtTail(40);
        lista.addAtTail(30);

        //When
        lista.removeAllWithValue(20);

        //Then
        Assertions.assertEquals(4, lista.getSize());
        Assertions.assertEquals(10, lista.getAt(0));
        Assertions.assertEquals(30, lista.getAt(1));
        Assertions.assertEquals(40, lista.getAt(2));
        Assertions.assertEquals(30, lista.getAt(3));
    }

    //copiar
    @Test
    public void givenANonEmptyList_whenIterate_ThenIterationIsSuccessful(){
        //Given
        LinkedList<Integer> lista = new LinkedList<>();
        lista.addAtFront(10);
        lista.addAtTail(30);
        lista.addAtTail(40);
        lista.addAtTail(30);

        //When
        Iterator<Integer> iterator = lista.getIterator();

        //Then
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(10,iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30,iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(40,iterator.next());

        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(30,iterator.next());

        Assertions.assertFalse(iterator.hasNext());
    }
}
