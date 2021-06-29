package com.company;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
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
			byte[] outputBytes = "Hello World!".getBytes();
			buffer.put(outputBytes);
			buffer.putInt(245);
			buffer.putInt(-98654);
			byte[] outputBytes2 = "nice to meet you".getBytes();
			buffer.putInt(1000);
			buffer.flip();
			binChannel.write(buffer);
		}catch (IOException e){
			e.printStackTrace();
		}
	}
}
