/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int lo = 1, hi = n;
        int mid = lo + (hi - lo)/2;
        while ( lo <= hi){
            if(isBadVersion(mid)) hi = mid - 1;
            else lo = mid + 1;
            mid = lo + (hi - lo)/2;
        }
        return isBadVersion(mid) ? mid : 0;
        
    }
}
