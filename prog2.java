package prog;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.util.Scanner;
public class prog2 {

	public static void main(String[] args) {
		 try { 
			              System.out.println("�������鳤�ȣ�");
			              Scanner input=new Scanner(System.in);
			              int num=input.nextInt();
			              int[] a=new int[num];
			              BufferedReader reader = new BufferedReader(new FileReader("d://test.csv"));
			              String line = null;
			              int xb=0;
			              int sum=0;
			              while((line=reader.readLine())!=null&&xb<num){      //��ȡǰnum������
			                  String item[] = line.split(",");                //���ݶ����з�     
			                  String first = item[item.length-3];             //��һ������ 
			                  int value = Integer.parseInt(first);            //ת������������ 
			                  a[xb]=value;
			                  sum+=a[xb];
			                  xb++;
			              }  
			              System.out.println("�����"+sum);
			          } catch (Exception e) {  
			              e.printStackTrace();  
			          } 

	}

}
