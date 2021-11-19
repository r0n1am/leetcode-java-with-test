package q1146;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SnapshotArrayTest {

    @Test
    void shouldGetInitialValue() {
        SnapshotArray a = new SnapshotArray(1);
        assertEquals(0, a.get(0, 0));
    }

    @Test
    void shouldSetValue() {
        SnapshotArray a = new SnapshotArray(1);
        a.set(0, 1);
        assertEquals(1, a.get(0, 0));
    }

    @Test
    void shouldTakeSnapshot() {
        SnapshotArray a = new SnapshotArray(1);
        assertEquals(0, a.get(0, 0));

        int snapshotId = a.snap();
        assertEquals(0, snapshotId);
        a.set(0, 1);
        assertEquals(0, a.get(0, 0));
        assertEquals(1, a.get(0, 1));
    }

    @Test
    void shouldRunSampleTestCase() {
        SnapshotArray a = new SnapshotArray(3);
        a.set(0,5);
        int snapshotId = a.snap();
        assertEquals(0, snapshotId);
        a.set(0,6);
        assertEquals(5, a.get(0,0));
    }

    @Test
    void shouldRunFailedTestCase1() {
        SnapshotArray a = new SnapshotArray(4);

        int snapshotId = a.snap();
        assertEquals(0, snapshotId);

        snapshotId = a.snap();
        assertEquals(1, snapshotId);

        assertEquals(0, a.get(3,1));
        a.set(2, 4);

        assertEquals(0, a.get(2,0));
        assertEquals(0, a.get(2,1));
        assertEquals(4, a.get(2,2));

        snapshotId = a.snap();
        assertEquals(2, snapshotId);
        a.set(1, 4);

        assertEquals(0, a.get(1,0));
        assertEquals(0, a.get(1,1));
        assertEquals(0, a.get(1,2));
        assertEquals(4, a.get(1,3));
    }
}
