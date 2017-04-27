package com;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

import javax.xml.crypto.dsig.keyinfo.KeyValue;


/*
 * 1. User count.
 * 2. Date count
 */
public class CountBookAndDate
{
	String nFile = "E:/My_Workspace/input.csv";
    BufferedReader br = null;
    String line;
    String cvsSplitBy = ",";
    
    /*
     * 1. Count users who buy the books.
     * 2. Use HashMap to store value in key/pain form. 
     */
 	public void getBookcount()
	{
		int i=0;
		 Map<String, Integer> map = new TreeMap<String, Integer>();
	        try 
	        {
	            br = new BufferedReader(new FileReader(nFile));
	            while ((line = br.readLine()) != null)
	            {
	            	if(i>0)
	            	{
	            		String[] book = line.split(cvsSplitBy);
			            String key=book[0];
			            if(map.containsKey(key))
		                {
		            	
		            	   map.put(key, map.get(key)+1);
		                }
		                else
		                {
		            	   map.put(key, 1);
		                }
			       }
	            	i++;
		            
	            }
	            System.out.println("Bookwise Count: "+map);
	        } 
	        catch (FileNotFoundException e) 
	        {
	            e.printStackTrace();
	        }
	        catch (IOException e)
	        {
	            e.printStackTrace();
	        } 
	        finally
	        {
	            if (br != null) 
	            {
	                try 
	                {
	                    br.close();
	                } 
	                catch (IOException e) 
	                {
	                    e.printStackTrace();
	                }
	            }
	        }
	}
 	
 	/*
 	 * 1. Count how many books sold by datewise.
 	 * 2. Convert String date to into dd-MM-yyyy format.
 	 * 3. Use  SimpleDateFormat for formating purpose.
 	 * 
 	 * 
 	 */
	
	public void getDatecount() throws ParseException
	{
		 Map<String, Integer> map1 = new TreeMap<String, Integer>();
		 String key=null;
		 Date d1 = null;
		 int i=0;
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
         SimpleDateFormat sdf1=new SimpleDateFormat("dd-MM-yyyy");
         String testDString="";
         try
	        {                	         
           
                br = new BufferedReader(new FileReader(nFile));
	            while ((line = br.readLine()) != null)
	            {
	            	if(i>0)
	            	{
	            		//System.out.println(line);
			            String[] date = line.split(cvsSplitBy);
			            key=date[2];
			            d1 = sdf.parse(key);
		                //System.out.println(sdf1.format(d1));
		                testDString = sdf1.format(d1);
		                //System.out.println(testDString);
			            if(map1.containsKey(testDString))
		                {
			            	
			                map1.put(testDString, map1.get(testDString)+1);
		            	}
		                else
		                {
		            	   map1.put(testDString, 1);
		                }
	            	}
	            	i++;
	            }
	        }
	            catch (FileNotFoundException e) 
		        {
		            e.printStackTrace();
		        }
		        catch (IOException e)
		        {
		            e.printStackTrace();
		        } 
         catch (ParseException e)
         {
            System.out.println( e.getMessage());
         }
       
		        finally
		        {
		            if (br != null) 
		            {
		                try 
		                {
		                    br.close();
		                } 
		                catch (IOException e) 
		                {
		                    e.printStackTrace();
		                }
		            }
		        }
                System.out.println("Datewise Count: "+map1);
	       
	      
	}
   	public static void main(String[] args) throws ParseException 
    {
        CountBookAndDate tf=new CountBookAndDate();
        tf.getBookcount();
        tf.getDatecount();
    }

}


/* ---------------------------------- OUTPUT ------------------------------------------------ 
 * 
 * 
 * 
  Bookwise Count: {User001=4, User002=4, User003=4, User004=4, User005=4, User006=4, User007=3, User008=3, User009=3, User010=3, User011=3, User012=2}
Datewise Count: {11-02-2016=4, 12-02-2016=4, 13-02-2016=4, 14-02-2016=5, 15-02-2016=5, 16-02-2016=5, 17-02-2016=5, 18-02-2016=1, 19-02-2016=1, 20-02-2016=1, 21-02-2016=1, 22-02-2016=1, 23-02-2016=1, 24-02-2016=2, 25-02-2016=1}





*/
