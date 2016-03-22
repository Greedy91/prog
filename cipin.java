package 词频;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class cipin {
	public static void main(String[] args) 
	{
	  try{
		  FileReader fr1=new FileReader("1.txt");   //读取文本
		  BufferedReader bf1=new BufferedReader(fr1);
		  String str1 = null;String [] str=null;String [] str2=null;
		  Map<String,Integer> map = new TreeMap<String,Integer>(); 
			/*map接口统计字母出现频率           注意TreeMap<String,Integer>和HashMap<String,Integer> 区别
			* 前者先将字符串自动按字典顺序排序，后者不会
			*/
		  while((str1=bf1.readLine())!=null)            //按行读取
		  {					  
				 str=str1.split(" ");                      //按空格切分字符串               
				for(int i=0;i<str.length;i++)
				 {
				  str2=str[i].split("");                //把一个字符串分为一个一个的字符，主要目的是为了好把字母以外的符号去掉
				  String a=null;
				  for(int j=0;j<str2.length;j++)       
				  {	
					  if(str2.length>1)
					  {
						  if(str2[j].charAt(0)>='A'&&str2[j].charAt(0)<='Z'||str2[j].charAt(0)>='a'&&str2[j].charAt(0)<='z')				  
					    {
						  str2[j]=str2[j].toLowerCase();  //大写变小写
						  if(a==null)
							  a=str2[j];
						  else
						      a=a+str2[j];                //一个完整的只有字母的字符串即完整的单词
					    }
					  }
				  }
				  str[i]=a;			  
				 }
	    for (int j = 0; j < str.length; j++) 
	    {
	     if(str[j]!=null)  
	     {
	    	Integer count = map.get(str[j]);       //一个单词出现的次数
	      if(count==null)                        //如果没有出现过，置一次
	      {
	      map.put(str[j],1);
	      }
	      else                                  //如果以前出现过，那么次数加一
	      {
	      map.put(str[j],++count);
	      }
	     }
	    } 
	    sort(map);                        //调用排序的方法，排序并输出   
	  }
		  fr1.close(); bf1.close();
	 }catch(Exception e){
			e.printStackTrace();}
    }
	public static void sort(Map<String,Integer> map){  
	    List<Map.Entry<String, Integer>> infoIds = new ArrayList<Map.Entry<String, Integer>>(map.entrySet());   
	    Collections.sort(infoIds, new Comparator<Map.Entry<String, Integer>>() {     
	        public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {     
	            return (o2.getValue() - o1.getValue());     
	        }     
	}); //排序 
	    String [] str3=null; 
	    int len=infoIds.size();
	    int count=1;
	    
	try{
	    FileWriter fw=new FileWriter("Result1.txt");
	    BufferedWriter bw=new BufferedWriter(fw);
	    int q=0;
	    for (int i = 0; i < len; i++) 
	    {   //输出  
	    	Map.Entry<String, Integer> id = infoIds.get(i); 
	    	if(id.getKey()!=null)                                       
			      str3=id.getKey().split("");
		    	if( str3!=null&&str3.length>3)                     //str3可能为空，且这个控制只有含有3个字母以上的单词才打印
		 if(count<=5)
	      {
	         q=id.getValue();
			 bw.write(id.getKey());
		     bw.write(":  ");
		     bw.write(String.valueOf(q));
		     bw.write("\t");
			 count++;
	      }
		 else
		 {
		   q=id.getValue();
		   bw.write(id.getKey());
		   bw.write(":  ");
		   bw.write(String.valueOf(q));
		   bw.write("\r\n");       //换行
		   count=1;
		 }
	    }
	    bw.close();fw.close();
	}catch(Exception e){
		e.printStackTrace();} 
	} 
} 


