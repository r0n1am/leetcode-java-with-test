package q1146;

import java.util.TreeMap;

/**
 * <p>1146. Snapshot Array</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/snapshot-array/">
 *         https://leetcode.com/problems/snapshot-array/
 *       </a>
 * </p>
 */
class SnapshotArray {

    static class Snapshot {
        TreeMap<Integer, Integer> values = new TreeMap<>();
    }

    private int currentSnapshotId;
    private final Snapshot[] snapshots;

    public SnapshotArray(int length) {
        this.snapshots = new Snapshot[length];
        this.currentSnapshotId = 0;
        initArray(length);
    }

    private void initArray(int length) {
        for (int i = 0; i < length; ++i) {
            snapshots[i] = new Snapshot();
            snapshots[i].values.put(currentSnapshotId, 0);
        }
    }

    public void set(int index, int val) {
        snapshots[index].values.put(currentSnapshotId, val);
    }
    
    public int snap() {
        return currentSnapshotId++;
    }
    
    public int get(int index, int snap_id) {
        return snapshots[index].values.floorEntry(snap_id).getValue();
    }
}

/**
 * Your SnapshotArray object will be instantiated and called as such:
 * SnapshotArray obj = new SnapshotArray(length);
 * obj.set(index,val);
 * int param_2 = obj.snap();
 * int param_3 = obj.get(index,snap_id);
 */