package prog;
import java.io.BufferedReader;  
import java.io.FileReader;
import java.util.Scanner;
public class prog3 {

	public static void main(String[] args) {
		try { 
            System.out.println("�������鳤�ȣ�");
            Scanner input0=new Scanner(System.in);
            int num=input0.nextInt();
            int[] a=new int[num];
            BufferedReader reader = new BufferedReader(new FileReader("d://test.csv"));
            String line = null;
            int xb=0;
            int sum=0;
            int start,end;                                       //���������β
            System.out.println("����������䣨��0��ʼ��:");
                Scanner input1=new Scanner(System.in);
                start=input1.nextInt();
                Scanner input2=new Scanner(System.in);
                end=input2.nextInt();
            while((line=reader.readLine())!=null&&xb<num){       //��ȡǰnum������
                String item[] = line.split(",");                 //���ݶ����з�     
                String first = item[item.length-3];              //��һ������ 
                int value = Integer.parseInt(first);             //ת������������ 
                a[xb]=value;
                if(xb>=start&&xb<=end)
                {
                    sum+=a[xb];
                }
                xb++;
            }  
            System.out.println("�����"+sum);
        } catch (Exception e) {  
            e.printStackTrace();  
	}
}
}
