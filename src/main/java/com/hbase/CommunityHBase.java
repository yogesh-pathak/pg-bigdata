package com.hbase;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.HTable;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.util.Bytes;

public class CommunityHBase {

	public String companySummaryFile = "company_summary_table_1/000000_0";
	public String communityOrigSummaryFile = "pickup_community_summary_table_1/000000_0";
	public String communityDestSummaryFile = "dropoff_community_summary_table_1/000000_0";

	public String communityTableName = "CommunitySummary";
	public String [] communityColFamilies = {"OriginStats", "DestinationStats", "RevenueDetails"};

	public String companyTableName = "CompanySummary";
	public String [] companyColFamilies = {"TripCountStats", "RevenueDetails"};

	public String delim = ",";

	public static void main(String args[]) throws IOException {
		CommunityHBase obj = new CommunityHBase();
		obj.insertCompanySummaryData();
		obj.insertCommunityOrigSummaryData();
		obj.insertCommunityDestSummaryData();
		System.out.println("===============Loading Completed==================");
	}

	public Configuration setup() {
		// Instantiating a configuration class
		Configuration conf = HBaseConfiguration.create();

		conf.clear();
		conf.set("hbase.zookeeper.quorum", "ip-20-0-31-210.ec2.internal");
		conf.set("hbase.zookeeper.property.clientPort", "2181");
		System.out.println("===============Setup Completed==================");
		return conf;
	}

	public void insertCompanySummaryData() throws IOException {

		BufferedReader br = createReaderForFile(companySummaryFile);
		HTable htable = new HTable(setup(), companyTableName);

		// Company_Name, daily_trip_count, daily_total_amt, daily_total_miles, daily_total_mins, daily_avg_amt, daily_avg_miles, daily_avg_mins
		String line = br.readLine();
		int index = 0;

		while(line != null && !line.isEmpty() && index < 20) {
			String [] tokens = line.split(delim);
			if(tokens.length < 8) {
				continue;
			}

			String companyName = (tokens[0] == null || tokens[0].isEmpty())?"Unknown" : tokens[0];
			Put p = new Put(Bytes.toBytes(companyName));

			p.add(Bytes.toBytes(companyColFamilies[0]), Bytes.toBytes("daily_trip_count"), Bytes.toBytes(tokens[1]));
			p.add(Bytes.toBytes(companyColFamilies[1]), Bytes.toBytes("daily_total_amt"), Bytes.toBytes(tokens[2]));
			p.add(Bytes.toBytes(companyColFamilies[0]), Bytes.toBytes("daily_total_miles"), Bytes.toBytes(tokens[3]));
			p.add(Bytes.toBytes(companyColFamilies[0]), Bytes.toBytes("daily_total_mins"), Bytes.toBytes(tokens[4]));
			p.add(Bytes.toBytes(companyColFamilies[1]), Bytes.toBytes("daily_avg_amt"), Bytes.toBytes(tokens[5]));
			p.add(Bytes.toBytes(companyColFamilies[0]), Bytes.toBytes("daily_avg_miles"), Bytes.toBytes(tokens[6]));
			p.add(Bytes.toBytes(companyColFamilies[0]), Bytes.toBytes("daily_avg_mins"), Bytes.toBytes(tokens[7]));

			htable.put(p);
			line = br.readLine();
		}
		htable.close();
		System.out.println("===============Company Table Insertion Completed==================");
	}

	public void insertCommunityOrigSummaryData() throws IOException {

		BufferedReader br = createReaderForFile(communityOrigSummaryFile);
		HTable htable = new HTable(setup(), communityTableName);

		// pickup_community, daily_trip_count, daily_total_amt, daily_total_miles, daily_total_mins, daily_avg_amt, daily_avg_miles, daily_avg_mins
		String line = br.readLine();
		int index = 0;

		while(line != null && !line.isEmpty() && index < 20) {
			String [] tokens = line.split(delim);
			if(tokens.length < 8) {
				continue;
			}

			Put p = new Put(Bytes.toBytes(tokens[0]));

			p.add(Bytes.toBytes(communityColFamilies[0]), Bytes.toBytes("daily_trip_count"), Bytes.toBytes(tokens[1]));
			p.add(Bytes.toBytes(communityColFamilies[2]), Bytes.toBytes("orig_daily_total_amt"), Bytes.toBytes(tokens[2]));
			p.add(Bytes.toBytes(communityColFamilies[0]), Bytes.toBytes("daily_total_miles"), Bytes.toBytes(tokens[3]));
			p.add(Bytes.toBytes(communityColFamilies[0]), Bytes.toBytes("daily_total_mins"), Bytes.toBytes(tokens[4]));
			p.add(Bytes.toBytes(communityColFamilies[2]), Bytes.toBytes("orig_daily_avg_amt"), Bytes.toBytes(tokens[5]));
			p.add(Bytes.toBytes(communityColFamilies[0]), Bytes.toBytes("daily_avg_miles"), Bytes.toBytes(tokens[6]));
			p.add(Bytes.toBytes(communityColFamilies[0]), Bytes.toBytes("daily_avg_mins"), Bytes.toBytes(tokens[7]));

			htable.put(p);
			line = br.readLine();
		}
		htable.close();
		System.out.println("===============Community Origin Table Insertion Completed==================");
	}

	public void insertCommunityDestSummaryData() throws IOException {

		BufferedReader br = createReaderForFile(communityDestSummaryFile);
		HTable htable = new HTable(setup(), communityTableName);

		// pickup_community, daily_trip_count, daily_total_amt, daily_total_miles, daily_total_mins, daily_avg_amt, daily_avg_miles, daily_avg_mins
		String line = br.readLine();
		int index = 0;

		while(line != null && !line.isEmpty() && index < 20) {
			String [] tokens = line.split(delim);
			if(tokens.length < 8) {
				continue;
			}

			Put p = new Put(Bytes.toBytes(tokens[0]));

			p.add(Bytes.toBytes(communityColFamilies[1]), Bytes.toBytes("daily_trip_count"), Bytes.toBytes(tokens[1]));
			p.add(Bytes.toBytes(communityColFamilies[2]), Bytes.toBytes("dest_daily_total_amt"), Bytes.toBytes(tokens[2]));
			p.add(Bytes.toBytes(communityColFamilies[1]), Bytes.toBytes("daily_total_miles"), Bytes.toBytes(tokens[3]));
			p.add(Bytes.toBytes(communityColFamilies[1]), Bytes.toBytes("daily_total_mins"), Bytes.toBytes(tokens[4]));
			p.add(Bytes.toBytes(communityColFamilies[2]), Bytes.toBytes("dest_daily_avg_amt"), Bytes.toBytes(tokens[5]));
			p.add(Bytes.toBytes(communityColFamilies[1]), Bytes.toBytes("daily_avg_miles"), Bytes.toBytes(tokens[6]));
			p.add(Bytes.toBytes(communityColFamilies[1]), Bytes.toBytes("daily_avg_mins"), Bytes.toBytes(tokens[7]));

			htable.put(p);
			line = br.readLine();
		}
		htable.close();
		System.out.println("===============Community Destination Insertion Completed==================");
	}

	public BufferedReader createReaderForFile(String fileName) throws FileNotFoundException {
		Reader reader = new FileReader(new File(fileName));
		return new BufferedReader(reader);
	}
}