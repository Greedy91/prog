package prog;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.util.Scanner;
public class prog2 {

	public static void main(String[] args) {
		 try { 
			              System.out.println("输入数组长度：");
			              Scanner input=new Scanner(System.in);
			              int num=input.nextInt();
			              int[] a=new int[num];
			              BufferedReader reader = new BufferedReader(new FileReader("d://test.csv"));
			              String line = null;
			              int xb=0;
			              int sum=0;
			              while((line=reader.readLine())!=null&&xb<num){      //读取前num个数据
			                  String item[] = line.split(",");                //根据逗号切分     
			                  String first = item[item.length-3];             //第一列数据 
			                  int value = Integer.parseInt(first);            //转换成整形数据 
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
