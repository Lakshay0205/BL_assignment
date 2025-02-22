package JUnit.BasicProblems;
import org.junit.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;

public class ListManager {
    public void addElement(List<Integer> list, int element) {
        list.add(element);
    }

    public void removeElement(List<Integer> list, int element) {
        list.remove(Integer.valueOf(element));
    }

    public int getSize(List<Integer> list) {
        return list.size();
    }
}

public class ListManagerTest {
    @Test
    public void testAddElement() {
        List<Integer> list = new ArrayList<>();
        ListManager manager = new ListManager();
        manager.addElement(list, 5);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(5), list.get(0));
        manager.addElement(list, 10);
        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(10), list.get(1));
    }

    @Test
    public void testRemoveElement() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(10);
        ListManager manager = new ListManager();
        manager.removeElement(list, 5);
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(10), list.get(0));
        manager.removeElement(list, 10);
        assertEquals(0, list.size());
    }

    @Test
    public void testGetSize() {
        List<Integer> list = new ArrayList<>();
        ListManager manager = new ListManager();
        assertEquals(0, manager.getSize(list));
        manager.addElement(list, 5);
        assertEquals(1, manager.getSize(list));
        manager.addElement(list, 10);
        assertEquals(2, manager.getSize(list));
        manager.removeElement(list, 5);
        assertEquals(1, manager.getSize(list));
                manager.removeElement(list, 10);
                assertEquals(0, manager.getSize(list));
            }
        
            private void assertEquals(int i, int size) {
                // TODO Auto-generated method stub
                throw new UnsupportedOperationException("Unimplemented method 'assertEquals'");
            }
}