/*
 * Commands used: 
 * hadoop jar checksum.jar hdfs://ip-20-0-21-161.ec2.internal:8020
 * hdfs dfs -put file1.txt source/
 * hdfs dfs -rm source/file1.txt
 */
package com.assignment2;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileStatus;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.FileUtil;
import org.apache.hadoop.fs.Path;

public class Question1 {

	public static void main(String args[]) throws IOException {
		String hdfspath = args[0];
		Configuration conf = new Configuration();
		conf.set("fs.default.name", hdfspath);
		FileSystem fs = FileSystem.get(conf);
		List<String> listSource = getAllFilePath(new Path("source"), fs);
		List<String> listTarget = getAllFilePath(new Path("target"), fs);
		for(String sourcePath:listSource) {
			for(String targetPath : listTarget) {
				if(targetPath.endsWith(sourcePath.split("source")[1])) {
					if(compareChecksum(new Path(sourcePath), new Path(targetPath), fs) == false) {
						System.out.println("copying " + sourcePath);
						FileUtil.copy(fs, new Path(sourcePath), fs, new Path(targetPath), true, conf);
					}
				}
			}
		}
	}

	public static List<String> getAllFilePath(Path filePath, FileSystem fs) throws FileNotFoundException, IOException {
		List<String> fileList = new ArrayList<String>();
		FileStatus[] fileStatus = fs.listStatus(filePath);
		for (FileStatus fileStat : fileStatus) {
			fileList.add(fileStat.getPath().toString());
		}
		return fileList;
	}

	public static boolean compareChecksum(Path source, Path target, FileSystem fs) throws IOException {
		if(fs.getFileChecksum(source).equals(fs.getFileChecksum(target))) {
			return true;
		}
		else return false;
	}


}