package com.example.boot.demo;

import com.aliyun.openservices.shade.com.alibaba.rocketmq.common.UtilAll;

import java.net.UnknownHostException;
import java.nio.ByteBuffer;
import java.util.Arrays;

/**
 * @Description
 * @Author: yjs
 * @Date: 2023/2/13 14:23
 */
public class MsgIdDemo {

    public static void main(String[] args) throws UnknownHostException {
        // 有发送消息端生成的全局唯一id
        String msgId = "C0A8675F813418B4AAC240D04C470000";
        byte[] bytes = UtilAll.string2bytes(msgId);
        System.out.println(Arrays.toString(bytes));

        // String offsetMsgId = "C0A8675F00002A9F0000000000000000";
        // String offsetMsgId = "C0A8675F00002A9F00000000000000C3";
        // String offsetMsgId = "0BC1F05300002A9F000067E32BE14CF1";
        String offsetMsgId = "C0A8675F00002A9F0000000000000186";
        parseOffsetMsgId(offsetMsgId);

    }

    private static void parseOffsetMsgId(String offsetMsgId) throws UnknownHostException {
        // 由broker服务端根据ip地址端口号以及commitlog文件偏移量生成
        byte[] ipBytes = UtilAll.string2bytes(offsetMsgId.substring(0, 8));
        // System.out.println(InetAddress.getByAddress(ipBytes));
        System.out.println(Arrays.toString(ipBytes));
        System.out.println(String.format("%s.%s.%s.%s", ipBytes[0] & 0xFF, ipBytes[1] & 0xFF, ipBytes[2] & 0xFF, ipBytes[3] & 0xFF));
        // 端口号
        String portSub = offsetMsgId.substring(8, 16);
        System.out.println(portSub);
        byte[] portBytes = UtilAll.string2bytes(portSub);
        ByteBuffer portBuf = ByteBuffer.wrap(portBytes);
        System.out.println(portBuf.getInt());

        //物理偏移量
        String offsetSub = offsetMsgId.substring(16, 32);
        System.out.println(offsetSub);
        byte[] offsetBytes = UtilAll.string2bytes(offsetSub);
        ByteBuffer offsetBuf = ByteBuffer.wrap(offsetBytes);
        System.out.println(offsetBuf.getLong());
    }
}
