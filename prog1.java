package prog;
import java.io.BufferedReader;  
import java.io.FileReader;

public class prog1 {

	public static void main(String[] args) {
		try {  
			             int[] a=new int[100];
			             BufferedReader reader = new BufferedReader(new FileReader("d://test.csv"));
			             String line = null;
			             int xb=0;                                       //�����±��ʼ��
			             int sum=0;                                      //�����
			             while((line=reader.readLine())!=null&&xb<100){  //��ȡǰ100����
			                 String item[] = line.split(",");            //���ݶ����з�     
			                 String first = item[item.length-3];         //��һ������ 
			                 int value = Integer.parseInt(first);        //ת������������ 
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
