package com.example.boot.demo;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageDecoder;
import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.message.MessageExt;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

/**
 * @Description
 * @Author: yjs
 * @Date: 2023/2/13 17:59
 */
public class DecodeDemo {

    public static void main(String[] args) throws Exception{
        File file = new File("E:\\data\\new\\store\\commitlog\\00000000000000000000");
        FileChannel fileChannel = new RandomAccessFile(file, "rw").getChannel();
        MappedByteBuffer mappedByteBuffer = fileChannel.map(FileChannel.MapMode.READ_WRITE, 0, 1024);
        ByteBuffer buffer = mappedByteBuffer.slice();
        MessageExt messageExt = MessageDecoder.decode(mappedByteBuffer);
        System.out.println(messageExt);
    }
}
