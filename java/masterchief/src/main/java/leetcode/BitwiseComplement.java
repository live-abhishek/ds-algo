package leetcode;

public class BitwiseComplement {
    public int bitwiseComplement(int N) {
        int numBits = (int)(Math.floor(Math.log(N)/Math.log(2))) + 1;
        return ((1 << numBits) - 1) ^ N;
    }

    public static void main(String[] args) {
        BitwiseComplement b = new BitwiseComplement();
        int a = b.bitwiseComplement(5);
        System.out.println(a);
    }
}
