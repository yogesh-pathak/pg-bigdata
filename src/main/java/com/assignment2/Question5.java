/*
 * hadoop jar weatherRecordSplit.jar hdfs://nameservice1 bigdatapgp/common_folder/assignment2/weather_dataset/weather1.csv
 */
package com.assignment2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FSDataOutputStream;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

public class Question5 {

	public static void main(String []args) throws IOException {
		String hdfspath = args[0];
		Configuration conf = new Configuration();
		conf.set("fs.default.name", hdfspath);
		FileSystem fs = FileSystem.get(conf);
		Path path = new Path(args[1]);
		BufferedReader br=new BufferedReader(new InputStreamReader(fs.open(path)));
		//Creating output files
		Path indiaFilePath = new Path("india_weather.csv");
		if(fs.exists(indiaFilePath))
			fs.delete(indiaFilePath);
		FSDataOutputStream out1 = fs.create(indiaFilePath);
		BufferedWriter bufferedWriter1 = new BufferedWriter(new OutputStreamWriter(out1,StandardCharsets.UTF_8));
		
		Path restFilePath = new Path("row_weather.csv");
		if(fs.exists(restFilePath))
			fs.delete(restFilePath);
		FSDataOutputStream out2 = fs.create(restFilePath);
		BufferedWriter bufferedWriter2 = new BufferedWriter(new OutputStreamWriter(out2,StandardCharsets.UTF_8));
		
		try {
			String line;
			while ((line = br.readLine()) != null){
				System.out.println(line);
				if(line.split(",")[4].toLowerCase().equals("india")) {
					bufferedWriter1.write(line);
				}
				else bufferedWriter2.write(line);

			}
		}
		finally {
			// you should close out the BufferedReader
			br.close();
			bufferedWriter1.close();
			bufferedWriter2.close();
		}
	}

}