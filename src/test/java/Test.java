public class Test {
    public static void main(String[] args) {
        String s = "xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeellllllllllzzzzzzzz";
        String m = "xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeelllllllllmaaaaaaaa";
        String t = "xxxxxxxxxxxxxxxxxyyyyyyyyyyybbbbbbbccccccccddddddddddeeeeeeelllllllllmzzzzzzzz";

        System.out.println(s.compareTo(m));
        System.out.println(m.compareTo(t));
    }
}
