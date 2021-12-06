package q1108;

/**
 * <p>1108. Defanging an IP Address</p>
 * <p>
 *   See <a href="https://leetcode.com/problems/defanging-an-ip-address/">
 *         https://leetcode.com/problems/defanging-an-ip-address/
 *       </a>
 * </p>
 */
class Solution {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}
