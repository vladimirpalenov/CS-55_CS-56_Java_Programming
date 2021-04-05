public class HomeworkAssignment6_2 {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isAnagram("smc","SMC")==true);
        System.out.println(sol.isAnagram("smc","      ")==false);
        System.out.println(sol.isAnagram("smijjc","    u  ")==false);
        System.out.println(sol.isAnagram("School             master","The classroom")==true);
        System.out.println(sol.isAnagram("A#######","!!@!@a")==true);
        System.out.println(sol.isAnagram("1234566890","1234567890")==false);
        System.out.println(sol.isAnagram("1234567890i","i0987654321")==true);
    }
}
class Solution {
    /**
     * FUNCTION SIGNATURE: boolean isAnagram(String str1, String str2)
     * PURPOSE: The function checks if two given strings are anagrams.
     * Only alphanumerical characters are being compared.
     * PARAMETER:
     *     String str1, String str2
     * RETURN VALUE:
     *     boolean value true if given strings are anagrams, false if they are not.
     */
    public boolean isAnagram(String str1, String str2) {
        String lowCaseStr1 = str1.toLowerCase();
        String lowCaseStr2 = str2.toLowerCase();
        int a1 = 0, b1 = 0, c1 = 0, d1 = 0, e1 = 0, f1 = 0, g1 = 0, h1 = 0, i1 = 0, j1 = 0, k1 = 0, l1 = 0, m1 = 0;
        int n1 = 0, o1 = 0, p1 = 0, q1 = 0, r1 = 0, s1 = 0, t1 = 0, u1 = 0, v1 = 0, w1 = 0, x1 = 0, y1 = 0, z1 = 0;
        int _0_1 = 0, _1_1 = 0, _2_1 = 0, _3_1 = 0, _4_1 = 0, _5_1 = 0, _6_1 = 0, _7_1 = 0, _8_1 = 0, _9_1 = 0;
        int a2 = 0, b2 = 0, c2 = 0, d2 = 0, e2 = 0, f2 = 0, g2 = 0, h2 = 0, i2 = 0, j2 = 0, k2 = 0, l2 = 0, m2 = 0;
        int n2 = 0, o2 = 0, p2 = 0, q2 = 0, r2 = 0, s2 = 0, t2 = 0, u2 = 0, v2 = 0, w2 = 0, x2 = 0, y2 = 0, z2 = 0;
        int _0_2 = 0, _1_2 = 0, _2_2 = 0, _3_2 = 0, _4_2 = 0, _5_2 = 0, _6_2 = 0, _7_2 = 0, _8_2 = 0, _9_2 = 0;
        for (int count = 0; count < lowCaseStr1.length(); count++) {
            switch (lowCaseStr1.charAt(count)) {
                case 'a':
                    a1++;
                    break;
                case 'b':
                    b1++;
                    break;
                case 'c':
                    c1++;
                    break;
                case 'd':
                    d1++;
                    break;
                case 'e':
                    e1++;
                    break;
                case 'f':
                    f1++;
                    break;
                case 'g':
                    g1++;
                    break;
                case 'h':
                    h1++;
                    break;
                case 'i':
                    i1++;
                    break;
                case 'j':
                    j1++;
                    break;
                case 'k':
                    k1++;
                    break;
                case 'l':
                    l1++;
                    break;
                case 'm':
                    m1++;
                    break;
                case 'n':
                    n1++;
                    break;
                case 'o':
                    o1++;
                    break;
                case 'p':
                    p1++;
                    break;
                case 'q':
                    q1++;
                    break;
                case 'r':
                    r1++;
                    break;
                case 's':
                    s1++;
                    break;
                case 't':
                    t1++;
                    break;
                case 'u':
                    u1++;
                    break;
                case 'v':
                    v1++;
                    break;
                case 'w':
                    w1++;
                    break;
                case 'x':
                    x1++;
                    break;
                case 'y':
                    y1++;
                    break;
                case 'z':
                    z1++;
                    break;
                case '0':
                    _0_1++;
                    break;
                case '1':
                    _1_1++;
                    break;
                case '2':
                    _2_1++;
                    break;
                case '3':
                    _3_1++;
                    break;
                case '4':
                    _4_1++;
                    break;
                case '5':
                    _5_1++;
                    break;
                case '6':
                    _6_1++;
                    break;
                case '7':
                    _7_1++;
                    break;
                case '8':
                    _8_1++;
                    break;
                case '9':
                    _9_1++;
                    break;
            }
        }
        for (int count1 = 0; count1 < lowCaseStr2.length(); count1++) {
            switch (lowCaseStr2.charAt(count1)) {
                case 'a':
                    a2++;
                    break;
                case 'b':
                    b2++;
                    break;
                case 'c':
                    c2++;
                    break;
                case 'd':
                    d2++;
                    break;
                case 'e':
                    e2++;
                    break;
                case 'f':
                    f2++;
                    break;
                case 'g':
                    g2++;
                    break;
                case 'h':
                    h2++;
                    break;
                case 'i':
                    i2++;
                    break;
                case 'j':
                    j2++;
                    break;
                case 'k':
                    k2++;
                    break;
                case 'l':
                    l2++;
                    break;
                case 'm':
                    m2++;
                    break;
                case 'n':
                    n2++;
                    break;
                case 'o':
                    o2++;
                    break;
                case 'p':
                    p2++;
                    break;
                case 'q':
                    q2++;
                    break;
                case 'r':
                    r2++;
                    break;
                case 's':
                    s2++;
                    break;
                case 't':
                    t2++;
                    break;
                case 'u':
                    u2++;
                    break;
                case 'v':
                    v2++;
                    break;
                case 'w':
                    w2++;
                    break;
                case 'x':
                    x2++;
                    break;
                case 'y':
                    y2++;
                    break;
                case 'z':
                    z2++;
                    break;
                case '0':
                    _0_2++;
                    break;
                case '1':
                    _1_2++;
                    break;
                case '2':
                    _2_2++;
                    break;
                case '3':
                    _3_2++;
                    break;
                case '4':
                    _4_2++;
                    break;
                case '5':
                    _5_2++;
                    break;
                case '6':
                    _6_2++;
                    break;
                case '7':
                    _7_2++;
                    break;
                case '8':
                    _8_2++;
                    break;
                case '9':
                    _9_2++;
                    break;
            }
        }
      if (a1 == a2 && b1 == b2 && c1 == c2 && d1 == d2 && e1 == e2 && f1 == f2 && g1 == g2 && h1 == h2 &&
              i1 == i2 && j1 == j2 && k1 == k2 && l1 == l2 && m1 == m2 && n1 == n2 && o1 == o2 && p1 == p2 &&
              q1 == q2 && r1 == r2 && s1 == s2 && t1 == t2 && u1 == u2 && v1 == v2 && w1 == w2 && x1 == x2 &&
              y1 == y2 && z1 == z2 && _0_1 == _0_2 && _1_1 == _1_2 && _2_1 == _2_2 && _3_1 == _3_2 && _4_1 == _4_2 &&
              _5_1 == _5_2 && _6_1 == _6_2 && _7_1 == _7_2 && _8_1 == _8_2 && _9_1 == _9_2) {
          return true;
      } else{
          return false;
      }
    }
}
