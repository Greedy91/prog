package ��Ƶ;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.*;

public class cipin {
	public static void main(String[] args) 
	{
	  try{
		  FileReader fr1=new FileReader("1.txt");   //��ȡ�ı�
		  BufferedReader bf1=new BufferedReader(fr1);
		  String str1 = null;String [] str=null;String [] str2=null;
		  Map<String,Integer> map = new TreeMap<String,Integer>(); 
			/*map�ӿ�ͳ����ĸ����Ƶ��           ע��TreeMap<String,Integer>��HashMap<String,Integer> ����
			* ǰ���Ƚ��ַ����Զ����ֵ�˳�����򣬺��߲���
			*/
		  while((str1=bf1.readLine())!=null)            //���ж�ȡ
		  {					  
				 str=str1.split(" ");                      //���ո��з��ַ���               
				for(int i=0;i<str.length;i++)
				 {
				  str2=str[i].split("");                //��һ���ַ�����Ϊһ��һ�����ַ�����ҪĿ����Ϊ�˺ð���ĸ����ķ���ȥ��
				  String a=null;
				  for(int j=0;j<str2.length;j++)       
				  {	
					  if(str2.length>1)
					  {
						  if(str2[j].charAt(0)>='A'&&str2[j].charAt(0)<='Z'||str2[j].charAt(0)>='a'&&str2[j].charAt(0)<='z')				  
					    {
						  str2[j]=str2[j].toLowerCase();  //��д��Сд
						  if(a==null)
							  a=str2[j];
						  else
						      a=a+str2[j];                //һ��������ֻ����ĸ���ַ����������ĵ���
					    }
					  }
				  }
				  str[i]=a;			  
				 }
	    for (int j = 0; j < str.length; j++) 
	    {
	     if(str[j]!=null)  
	     {
	    	Integer count = map.get(str[j]);       //һ�����ʳ��ֵĴ���
	      if(count==null)                        //���û�г��ֹ�����һ��
	      {
	      map.put(str[j],1);
	      }
	      else                                  //�����ǰ���ֹ�����ô������һ
	      {
	      map.put(str[j],++count);
	      }
	     }
	    } 
	    sort(map);                        //��������ķ������������   
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
	}); //���� 
	    String [] str3=null; 
	    int len=infoIds.size();
	    int count=1;
	    
	try{
	    FileWriter fw=new FileWriter("Result1.txt");
	    BufferedWriter bw=new BufferedWriter(fw);
	    int q=0;
	    for (int i = 0; i < len; i++) 
	    {   //���  
	    	Map.Entry<String, Integer> id = infoIds.get(i); 
	    	if(id.getKey()!=null)                                       
			      str3=id.getKey().split("");
		    	if( str3!=null&&str3.length>3)                     //str3����Ϊ�գ����������ֻ�к���3����ĸ���ϵĵ��ʲŴ�ӡ
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
		   bw.write("\r\n");       //����
		   count=1;
		 }
	    }
	    bw.close();fw.close();
	}catch(Exception e){
		e.printStackTrace();} 
	} 
} 


