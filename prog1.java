package prog;
import java.io.BufferedReader;  
import java.io.FileReader;

public class prog1 {

	public static void main(String[] args) {
		try {  
			             int[] a=new int[100];
			             BufferedReader reader = new BufferedReader(new FileReader("d://test.csv"));
			             String line = null;
			             int xb=0;                                       //数组下标初始化
			             int sum=0;                                      //数组和
			             while((line=reader.readLine())!=null&&xb<100){  //读取前100数据
			                 String item[] = line.split(",");            //根据逗号切分     
			                 String first = item[item.length-3];         //第一列数据 
			                 int value = Integer.parseInt(first);        //转换成整形数据 
			                 a[xb]=value;
			                 sum+=a[xb];
		                     xb++;
			             }  
			             System.out.println("结果："+sum);
			         } catch (Exception e) {  
			             e.printStackTrace();  
			         } 
	}

}
