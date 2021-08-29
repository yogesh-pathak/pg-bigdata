package com.assignment3;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.filecache.DistributedCache;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

public class EmployeePerLocation {

	public static void main(String [] args) throws Exception
	{
		if(args.length !=3)
		{
			System.err.println("Usage: EmpByLocation <input path> <output path> <cache path>");
			System.exit(-1);
		}

		Configuration conf = new Configuration();
		Job job = Job.getInstance(conf);
		job.setJarByClass(EmployeePerLocation.class);
		job.setJobName("Emp By Location");


		try {
			DistributedCache.addCacheFile(new Path(args[2]).toUri(), job.getConfiguration());

		}
		catch(Exception e){
			System.out.println(e);
		}
		job.setMapperClass(EmpByLocMapper.class);
		job.setReducerClass(EmpByLocReducer.class);
		job.setMapOutputKeyClass(IntWritable.class);
		job.setMapOutputValueClass(LongWritable.class);
		job.setOutputKeyClass(Text.class);
		job.setOutputValueClass(Text.class);
		job.setNumReduceTasks(2);
		Path outputPath = new Path(args[1]);
		FileInputFormat.addInputPath(job, new Path(args[0]));
		FileOutputFormat.setOutputPath(job, outputPath);
		// deleting the output path automatically from hdfs so that we don't have
		// to delete it explicitly
		outputPath.getFileSystem(conf).delete(outputPath);
		// exiting the job only if the flag value becomes false
		System.exit(job.waitForCompletion(true) ? 0 : 1);

	}

	public static class EmpByLocMapper extends Mapper<LongWritable, Text, IntWritable, LongWritable>{
		public void map(LongWritable key, Text value, Context con) throws IOException, InterruptedException
		{
			String line = value.toString();
			String[] values = line.split(",");
			if(!values[0].equals("EMPNO"))
			{	
				String sal = values[5];
				String deptno = values[7];
				con.write(new IntWritable(Integer.parseInt(deptno)), new LongWritable(Long.parseLong(sal)));
			}
		}
	}

	public static class EmpByLocReducer extends Reducer<IntWritable, LongWritable, Text, Text>
	{
		HashMap<Integer,String> depLoc = new HashMap<>();

		@Deprecated
		protected void setup(Context context) throws IOException,InterruptedException
		{
			try {
				Path[] files = DistributedCache.getLocalCacheFiles(context.getConfiguration());
				if (files != null && files.length > 0) {
					for (Path dept : files) {
						BufferedReader bufferedReader = new BufferedReader(new FileReader(dept.toString()));
						String records = null;
						while ((records = bufferedReader.readLine()) != null) {
							String[] cols = records.split(",");
							if (cols[0].equals("DEPTNO"))
								continue;
							else {
								depLoc.put(Integer.parseInt(cols[0]), cols[2]);
							}
						}
						bufferedReader.close();
					}

				}
			}catch (Exception e){

			}
		}

		public void reduce(IntWritable key, Iterable<LongWritable> values, 
				Context con) throws IOException, InterruptedException
		{
			int empCount = 0;
			long totalSalary = 0;
			for(LongWritable value : values)
			{
				empCount += 1;
				totalSalary += value.get();

			}
			Text text = new Text();
			if(depLoc.containsKey(key.get())) {
				text.set(depLoc.get(key.get()));
			}
			else {
				text.set("Key not found");
			}
			con.write(text, new Text(empCount + " " + totalSalary));
		}
	}
}















