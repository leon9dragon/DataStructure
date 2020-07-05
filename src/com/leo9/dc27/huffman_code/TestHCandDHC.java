package com.leo9.dc27.huffman_code;


public class TestHCandDHC {
    public static void main(String[] args) {
        String sample_str = "i like like like java do you like a java";
        byte[] zip_byte_array = HuffmanCode.getHuffmanCodeByte(sample_str);
    }
}
