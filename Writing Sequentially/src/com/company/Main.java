package com.company;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	try(FileOutputStream binFile = new FileOutputStream("data.dat");
        FileChannel binChannel = binFile.getChannel()){
        ByteBuffer buffer = ByteBuffer.allocate(100);
		/*byte[] outputBytes = "Hello World!".getBytes();
		byte[] outputBytes2 = "Nice to meet you".getBytes();
		buffer.put(outputBytes).putInt(245).putInt(-98654).put(outputBytes).putInt(1000);
		buffer.flip();
*/
	    byte[] outputBytes = "Hello World!".getBytes();
	    buffer.put(outputBytes);
	    long int1Pos = outputBytes.length;
	    buffer.putInt(245);
	    long int2Pos = int1Pos + Integer.BYTES;
	    buffer.putInt(-98654);
	    byte[] outputBytes2 = "Nice to meet you".getBytes();
	    buffer.put(outputBytes2);
	    long int3Pos = int2Pos + Integer.BYTES + outputBytes2.length;
	    buffer.putInt(1000);
	    buffer.flip();
	    binChannel.write(buffer);

        RandomAccessFile ra = new RandomAccessFile("data.dat" , "rwd");
		FileChannel channel = ra.getChannel();
		ByteBuffer readBuffer = ByteBuffer.allocate(Integer.BYTES);
		channel.position(int3Pos);
		channel.read(readBuffer);
		readBuffer.flip();

		System.out.println("int3 = " + readBuffer.getInt());
    	readBuffer.flip();
		channel.position(int2Pos);
		channel.read(readBuffer);
		readBuffer.flip();

		System.out.println("int2 = " + readBuffer.getInt());
		readBuffer.flip();

	    channel.position(int1Pos);
		channel.read(readBuffer);
		readBuffer.flip();
		System.out.println("int1 = " + readBuffer.getInt());

		byte[] outputString = "Hello, World".getBytes(StandardCharsets.UTF_8);
		long str1Pos = 0 ;
		long newInt1Pos = outputString.length;
		long newInt2Pos = newInt1Pos + Integer.BYTES;
		byte[] outputString2 = "Nice to meet you".getBytes(StandardCharsets.UTF_8);
		long str2Pos = newInt2Pos + Integer.BYTES;
		long newInt3Pos = str2Pos + outputString2.length;

		ByteBuffer intBuffer = ByteBuffer.allocate(Integer.BYTES);
		intBuffer.putInt(245);
		intBuffer.flip();
		binChannel.position(newInt1Pos);
		binChannel.write(intBuffer);

		intBuffer.flip();
		intBuffer.putInt(-98654);
		intBuffer.flip();
		binChannel.position(newInt2Pos);
		binChannel.write(intBuffer);

		intBuffer.flip();
		intBuffer.putInt(1000);
		intBuffer.flip();
		binChannel.position(newInt3Pos);
		binChannel.write(intBuffer);

		binChannel.position(str1Pos);
		binChannel.write(ByteBuffer.wrap(outputString));
		binChannel.position(str2Pos);
		binChannel.write(ByteBuffer.wrap(outputString2));
	



    }catch (IOException e){
	    e.printStackTrace();
    }
    }
}
