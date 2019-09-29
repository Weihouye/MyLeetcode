public class Test {
    public static void main(String[] args) {

        String s = revertString("abc");
        System.out.println(s);
    }

    public static String revertString(String s){
        int p = 0,q = s.length() - 1;   //定义左右两个指针
        char[] temp = new char[s.length()];

        while (p <= q){   //p>q 时结束
            if(p == q){
                temp[p] = s.charAt(p);
            }
            else {
                temp[p] = s.charAt(q);
                temp[q] = s.charAt(p);
            }
            p++;
            q--;
        }
        return new String(temp);
    }
}