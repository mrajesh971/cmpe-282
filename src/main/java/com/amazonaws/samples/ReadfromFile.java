package com.amazonaws.samples;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.GetObjectRequest;


public class ReadfromFile {

	AmazonS3 s3;
	public void initilization(String accessKey, String secretKey) {
		  s3 = new AmazonS3Client(new BasicAWSCredentials(accessKey, secretKey));

}
		 
		  public void readFromS3Intance(String bucketName, String textFileName) throws IOException {
			    com.amazonaws.services.s3.model.S3Object s3object = s3.getObject(new GetObjectRequest(bucketName, textFileName));
			    BufferedReader reader = new BufferedReader(new InputStreamReader(s3object.getObjectContent()));
			    String line;
			    while((line = reader.readLine()) != null) {
			      System.out.println(line);
			    }
			  }
		  public static void main(String[] args) {
		    ReadfromFile obj = new ReadfromFile();
		    obj.initilization("xxxxxx", "xxxxxx");
		    try {
		    	obj.readFromS3Intance("xxxxxx", "hello.txt");
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		  }
}