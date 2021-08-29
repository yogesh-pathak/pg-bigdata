/*
 * hdfs dfs -ls -R hdfs://ip-20-0-21-161.ec2.internal:8020//user/edureka_1128473/deleteFiles | sort  -n -k 5
 * hdfs dfs -ls -R hdfs://ip-20-0-21-161.ec2.internal:8020//user/edureka_1128473/deleteFiles | awk '{if($5==0){print($8)}}' >> out.txt
 * hdfs dfs -put out.txt
 */
package com.assignment2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.LocatedFileStatus;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.fs.RemoteIterator;

public class Question3 {

	public static void main(String args[]) throws IOException {
		String hdfspath = args[0];
		Configuration conf = new Configuration();
		conf.set("fs.default.name", hdfspath);
		FileSystem fs = FileSystem.get(conf);
		Path path = new Path(args[1]);
		//Getting the files recursively
		RemoteIterator<LocatedFileStatus> fileStatusListIterator = fs.listFiles(
		            path, true);
		List<Path> list = new ArrayList<Path>();
		while(fileStatusListIterator.hasNext()){
	        LocatedFileStatus fileStatus = fileStatusListIterator.next();
	        list.add(fileStatus.getPath());
	    }
		
		//finding files with size 0
		List<Path> list0SizeFiles = new ArrayList<Path>();
		for(Path file : list) {
			if(fs.getContentSummary(file).getSpaceConsumed() == 0) {
				list0SizeFiles.add(file);
				System.out.println("File with 0 size:" + file.toString());
				fs.delete(file);
			}
		}
	}
	
}