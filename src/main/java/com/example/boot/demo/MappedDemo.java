package com.example.boot.demo;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.util.Arrays;

/**
 * @Description
 * @Author: yjs
 * @Date: 2023/2/13 16:59
 */
public class MappedDemo {

    public static void main(String[] args) throws IOException {
        File file = new File("E:\\data\\new\\store\\commitlog\\00000000000000000000");
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        System.out.println(mappedByteBuffer.limit());
        // total size(4) + magicCode(4) + body crc(4) + queueId(4) + msg flag(4) + queue offset(8) + physical offset(8) + sys flag(4) + born timestamp(8)
        // born host port(8 ipv4) + store timestamp(8) + store host port(8) + consume times(4)
        // total size
        System.out.println(mappedByteBuffer.getInt());
        // magic code
        System.out.println(mappedByteBuffer.getInt());
        // body crc
        System.out.println(mappedByteBuffer.getInt());
        // queue id
        System.out.println(mappedByteBuffer.getInt());
        // msg flag
        System.out.println(mappedByteBuffer.getInt());
        // queue offset
        System.out.println(mappedByteBuffer.getLong());
        // physical offset
        System.out.println(mappedByteBuffer.getLong());
        // sys flag
        System.out.println(mappedByteBuffer.getInt());
        // born timestamp
        System.out.println(mappedByteBuffer.getLong());
        // born host port
        byte[] bornHostBytes = new byte[4];
        mappedByteBuffer.get(bornHostBytes, 0, bornHostBytes.length);
        System.out.println(Arrays.toString(bornHostBytes));
        System.out.println(mappedByteBuffer.getInt());
        // store timestamp
        System.out.println(mappedByteBuffer.getLong());
        // store host port
        byte[] storeHostBytes = new byte[4];
        mappedByteBuffer.get(storeHostBytes, 0, storeHostBytes.length);
        System.out.println(Arrays.toString(storeHostBytes));
        System.out.println(mappedByteBuffer.getInt());
        System.out.println(mappedByteBuffer.getInt());

    }
}
