package com.leo9.dc27.huffman_code;


public class TestHCandDHC {
    public static void main(String[] args) {
        /* 测试哈夫曼编码和解码
        String sample_str = "i like like like java do you like a java";
        byte[] zip_byte_array = HuffmanCode.getHuffmanCodeByteArray(sample_str);
        byte[] origin_byte_array = HuffmanCode.decodeHuffmanCodeByteArray(zip_byte_array);
         */

        //测试哈夫曼编码压缩文件
        //输入源文件的路径, 这里的源文件是一个大小为473KB的图片
        String srcFilePath = "d://test.bmp";
        //定义一个输出压缩文件的路径
        String zipFilePath = "d://zip_test_bmp.leozip";
        //调用压缩文件的方法, 压缩后得到一个120KB的文件
        HuffmanCode.zipFile(srcFilePath, zipFilePath);

        //定义一个输出解压后的源文件的路径
        String unzipToPath = "d://unzip_test.bmp";
        //调用解压文件的方法, 解压后获取得源文件
        HuffmanCode.unzipFile(zipFilePath, unzipToPath);
    }
}

