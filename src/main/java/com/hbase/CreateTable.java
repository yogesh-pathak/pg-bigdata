package com.hbase;
import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.HColumnDescriptor;
import org.apache.hadoop.hbase.HTableDescriptor;
import org.apache.hadoop.hbase.MasterNotRunningException;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.HBaseAdmin;
import org.apache.hadoop.hbase.util.Bytes;

public class CreateTable {

	public static void main(String args[]) throws MasterNotRunningException, IOException {
		// Instantiating a configuration class
		Configuration conf = HBaseConfiguration.create();

		conf.clear();
		conf.set("hbase.zookeeper.quorum", "ip-20-0-31-210.ec2.internal");
		conf.set("hbase.zookeeper.property.clientPort", "2181");

		// Instantiating HBaseAdmin class
		HBaseAdmin admin = (HBaseAdmin)ConnectionFactory.createConnection(conf).getAdmin();
		String tableName = "Community_Summary_Table";
		TableName tname = TableName.valueOf(Bytes.toBytes(tableName));

		if (admin.tableExists(tableName)) {
			System.out.println("table already exists!");
		} else {


			HTableDescriptor tableDesc = new HTableDescriptor(tname);

			tableDesc.addFamily(new HColumnDescriptor(Bytes.toBytes("Origin_Stats")));
			tableDesc.addFamily(new HColumnDescriptor(Bytes.toBytes("Destination_Stats")));
			tableDesc.addFamily(new HColumnDescriptor(Bytes.toBytes("Revenue_Summary")));

			admin.createTable(tableDesc);

			System.out.println("create table " + tableName + " ok.");
		}

		//		Configuration conf = HBaseConfiguration.create();
		//		conf.set("hbase.zookeeper.quorum", "ip-20-0-31-210.ec2.internal");
		//		conf.set("hbase.zookeeper.property.clientPort", "2181");
		//		HBaseAdmin admin = (HBaseAdmin)ConnectionFactory.createConnection(conf).getAdmin();
		//		
		//		String tableName = "dummy";
		//		TableName tname = TableName.valueOf(Bytes.toBytes(tableName));
		//		TableDescriptorBuilder.ModifyableTableDescriptor tbuilder = new ModifyableTableDescriptor(tname);
		//
		//		//		TableDescriptorBuilder.ModifyableTableDescriptor tableDescBuilder = TableDescriptorBuilder.newBuilder(tname);
		//		//		tbuilder.build();
		//
		//		if (admin.tableExists(tname)) {
		//			System.out.println("table already exists!");
		//		} else {
		//			
		//			ColumnFamilyDescriptorBuilder columnDescBuilder = ColumnFamilyDescriptorBuilder
		//					.newBuilder(Bytes.toBytes("firstqualifier")).setBlocksize(32 * 1024)
		//					.setCompressionType(Compression.Algorithm.SNAPPY).setDataBlockEncoding(DataBlockEncoding.NONE);
		//			tbuilder.setColumnFamily(columnDescBuilder.build());
		//			
		//			admin.createTable(tbuilder);
		//			System.out.println("create table " + tableName + " ok.");
		//		}
	}
}