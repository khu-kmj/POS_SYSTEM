package pos_program;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

class ���� extends JDialog{		//������ �ֹ� �ߴ� �޴��� �����Ѵ�.
	String text;
	String text2="";
	����(JTextArea text){			//������ �ֹ� �ߴ� �޴��� �Է� �޴´�.
		this.text=text.getText();
		String []arr=this.text.split(" ");
		setTitle("����");
		setBounds(250, 150, 300, 200);
		getContentPane().setLayout(null);

		JLabel l=new JLabel("�޴� �̸�  :");
		l.setBounds(67, 30, 76, 20);
		getContentPane().add(l);

		JLabel label = new JLabel("����         :");
		label.setBounds(67, 60, 76, 20);
		getContentPane().add(label);
		
		JTextField t = new JTextField();
		getContentPane().add(t);
		t.setColumns(10);
		t.setBounds(142, 30, 76, 20);
		
		JTextField t2 = new JTextField();
		t2.setColumns(10);
		t2.setBounds(142, 60, 76, 20);
		getContentPane().add(t2);
		
		Button b=new Button("����");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=t.getText();	
				String menu2="\n"+t.getText();	//"\n"�� �߰����� ���� : �������� split�� �ߴµ� 2��° �� ���� �޴� �տ�"\n"�� �ٱ� ������ "\n�޴�"�� �ؼ��Ѵ�.
				String score=t2.getText();
				if(arr[0].equals(menu)) {	//ù��° �޴��� �� ó��("\n"�� �پ� ���� �ʴ� ���)
					arr[4]=score;
				}
				for(int i=1; i<arr.length; i++) {	//ù��° �޴��� �� ���� ó��("\n"�� �پ� �ִ�  ���)
					if(arr[i].equals(menu2)) {
						arr[i+4]=score;
					}
				}
				for(int i=0; i<arr.length; i++) {
					text2+=arr[i]+" ";		//������ �ؽ�Ʈ�� �ٽ� ������ �̿��Ͽ� ���δ�.
				}
				text.setText(text2);	//������ �ؽ�Ʈ�� ȭ�鿡 ����Ѵ�.
				setVisible(false);		//�����Ѵ�.
			}
		});
		b.setLocation(116,102);
		b.setSize(40,20);
		getContentPane().add(b);
		setVisible(true);
	}
}
class Kindof{		//�޴��� ������ ���� str�� �����Ѵ�. ( ���̺� ȭ�鿡 ����ϱ� ���� �۾�), 
	String str="";	//���̺� ���� ��� �ݺ��ؾ� �ϱ� ������ class�� ����.
	void ��������() {
		Menu_list abb=new Menu_list();
		int i=0;
		while(abb.price[i]!=null) {
		switch(abb.price[i]) {
		case "��� : 3500":
			str+=abb.price[i]+" X "+String.valueOf(abb.ramen_count)+" \n";
			break;
		case "�ܹ��� : 5500":
			str+=abb.price[i]+" X "+String.valueOf(abb.ham_count)+" \n";
			break;
		case "������ : 4500":
			str+=abb.price[i]+" X "+String.valueOf(abb.dduck_count)+" \n";
			break;
		case "���� : 3000":
			str+=abb.price[i]+" X "+String.valueOf(abb.sondae_count)+" \n";
			break;
		case "Ƣ�� : 4000":
			str+=abb.price[i]+" X "+String.valueOf(abb.twogim_count)+" \n";
			break;
		case "��ġ� : 8000":
			str+=abb.price[i]+" X "+String.valueOf(abb.kimchi_count)+" \n";
			break;
		case "�������� : 9500":
			str+=abb.price[i]+" X "+String.valueOf(abb.jaeyuk_count)+" \n";
			break;
		case "�δ�� : 8500":
			str+=abb.price[i]+" X "+String.valueOf(abb.budae_count)+" \n";
			break;
		case "������ : 7000":
			str+=abb.price[i]+" X "+String.valueOf(abb.yukgae_count)+" \n";
			break;
		case "������ : 13000":
			str+=abb.price[i]+" X "+String.valueOf(abb.galbee_count)+" \n";
			break;
		case "���̴� : 1500":
			str+=abb.price[i]+" X "+String.valueOf(abb.saida_count)+" \n";
			break;
		case "ȯŸ : 1500":
			str+=abb.price[i]+" X "+String.valueOf(abb.hwanta_count)+" \n";
			break;
		case "�ݶ� : 1500":
			str+=abb.price[i]+" X "+String.valueOf(abb.cola_count)+" \n";
			break;
		case "���� : 4500":
			str+=abb.price[i]+" X "+String.valueOf(abb.soju_count)+" \n";
			break;
		case "���� : 4000":
			str+=abb.price[i]+" X "+String.valueOf(abb.beer_count)+" \n";
			break;
		}
		i++;
	  }
	}
}
class ���â extends JDialog{		//����� �����Ѵ�.
	int a=0;
	public ���â() {
		setTitle("��� Ȯ�� â");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		JLabel label=new JLabel("��� �Ͻðڽ��ϱ�?");
		label.setSize(350,30);
		label.setLocation(50,30);
		add(label);
		Font font=new Font("����ü",Font.BOLD,20);
		label.setFont(font);
		
		Button b=new Button("Ȯ��");	//�������� �޴��� ����Ѵ�.
		b.setLocation(80,100);
		b.setSize(40,20);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				a=1;			//Ȯ���� ��� a=1�� �־ ��ҿ� �����Ѵ�.
				setVisible(false);
			}
		});
		add(b);
		Button b2=new Button("���");		//�������� �޴��� ������� �ʰ� ����Ѵ�.
		b2.setLocation(160,100);
		b2.setSize(40,20);
		b2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
		});
		add(b2);
		setModal(true);
		setVisible(true);
	}
}
class update {		//�޴� �� ����� �����Ѵ�.
	String text;
	public update(String text) {
		this.text=text;
	}
	int Menu(String []arr,int k) {	//������ �޴��� ���ڸ� �ΰ��Ͽ� �����Ѵ�. �׸��� ���� ���� �Ѵ�.
		int A=0;
		switch(arr[k]) {
			case "���":
				A=1;
				break;
			case "�ܹ���":
				A=2;
				break;
			case "������":
				A=3;
				break;
			case "����":
				A=4;
				break;
			case "Ƣ��":
				A=5;
				break;
			case "��ġ�":
				A=6;
				break;
			case "��������":
				A=7;
				break;
			case "�δ��":
				A=8;
				break;
			case "������":
				A=9;
				break;
			case "������":
				A=10;
				break;
			case "���̴�":
				A=11;
				break;
			case "ȯŸ":
				A=12;
				break;
			case "�ݶ�":
				A=13;
				break;
			case "����":
				A=14;
				break;
			case "����":
				A=15;
				break;
		}
		return A;
	}
	void file() {			//�޴����� ����� �Ϸ�� ���� �� ������ �����Ѵ�.
		int score=0;
		String []tex=text.split(" ");	//�����ڷ� �޾ƿ� �ؽ�Ʈ�� �������� ������.
		String []arr=new String[100];
		arr[0]=tex[0];					//(0) : �޴� 
		arr[1]=tex[2];					//(2) : ����
		arr[2]=tex[4];					//(4) : ����
		int j=3;
		for(int i=5; i<tex.length-5; i=i+5) {	//5,10,15...�� �������� for���� ����Ѵ�.
			String []tex2=tex[i].split("\n");	//2��° �޴� ���ʹ� "\n�޴��̸�"�����̱� ������ "\n"�� �������� split �Ѵ�.
			arr[j]=tex2[1];						//�޴� ����
			arr[j+1]=tex[i+2];					//(i+2) : ����
			arr[j+2]=tex[i+4];					//(i+4) : ����
			j=j+3;								
		}
		Calendar today = Calendar.getInstance();		//���� ��¥ ����
		String MON=String.valueOf(today.get(Calendar.MONTH)+1);
		String DAT=String.valueOf(today.get(Calendar.DATE));
		String MOD=MON+" / "+DAT;
		ArrayList<String[]> list = new ArrayList<String[]>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\�������.txt"));
		} catch (FileNotFoundException ea) {
			ea.printStackTrace();
		}
		while(scan.hasNext()) {
			list.add(scan.nextLine().split("\t"));
		}
		scan.close();
		for(int i=0; i<list.size(); i++) {	
			if(list.get(i)[0].equals(MOD)) {
				score=1;					//���࿡ ���� ��¥�� ���Ͽ� �ִٸ� score=1, ���ٸ� score=0;
			}
		}
		if(score==0) {//���� ���� ��¥�� ���ٸ�, �߰������� ���� �޴��� �����ϰ� ��� 0���� �ʱ�ȭ �Ѵ�.
			try {
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\�������.txt",true));
				fi.write(MOD+"\t");
				for(int i=1; i<16; i++) {
					int A=0;
					int K=0;
					int B=0;
					for(int k=0; k<j; k=k+3) {
						A=Menu(arr,k);
						if(i==A) {
							B=1;
							K=k;
						}
					}
					if(B==0) {	//�ֹ��� �Ǿ����� ���� �޴����� 0���� �ʱ�ȭ
						fi.write("0 0\t");
					}
					if(B==1) {	//�ֹ��� �Ǿ��ٸ� �ش� �Ǵ� �޴��� ���ݰ� ������ ��������(�ֹ��� ����ŭ) �ʱ�ȭ �Ѵ�. 
						int price=(Integer.parseInt(arr[K+1])*Integer.parseInt(arr[K+2]));
						int count=Integer.parseInt(arr[K+2]);
						String abb=String.valueOf(price)+" "+String.valueOf(count);
						fi.write(abb+"\t");
					}
				}
				fi.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(score==1) {		//��� ���Ͽ� ���� ��¥�� �Է��� �Ǿ����� ��
			try {	
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\�������.txt"));		
				for(int l=0; l<list.size(); l++) {
					if(list.get(l)[0].equals(MOD)) {	//MOD�� list�� ������ ��¥�� ���� �����ϴٸ� �����Ѵ�.
						fi.write(list.get(l)[0]+"\t");
						for(int i=1; i<16; i++) {
							int B=0;
							int A=0;
							int K=0;
							for(int k=0; k<j; k=k+3) {
								A=Menu(arr,k);
								if(i==A) {
									K=k;
									B=1;
								}
							}
							if(B==1) {	//�ֹ��� �Ǿ��ٸ� �ش� �Ǵ� �޴��� ���ݰ� ������ ������ �����Ϳ� ���Ͽ� �����Ѵ�. 
								String []brr = list.get(l)[i].split(" ");
								int price=Integer.parseInt(brr[0])+(Integer.parseInt(arr[K+1])*Integer.parseInt(arr[K+2]));
								int count=Integer.parseInt(brr[1])+Integer.parseInt(arr[K+2]);
								String abb=String.valueOf(price)+" "+String.valueOf(count);
								fi.write(abb+"\t");
							}
							if(B==0) {	//�ֹ��� �Ǿ����� ���� �޴����� ������ ������ �����Ѵ�.
								fi.write(list.get(l)[i]+"\t");
							}
						}
						fi.write("\n");
					}
					else {				//MOD�� list�� ������ ��¥�� ���� �������� �ʴٸ� �����Ѵ�.
						for(int i=0; i<16; i++)
							fi.write(list.get(l)[i]+"\t");
						fi.write("\n");
					}
				}
				fi.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
class ��������� extends JDialog{		//���ݰ� ī���� ��츦 �����Ͽ� �� ���� ����Ѵ�.
	���������(int sum,String st,String text){		//���� ī�带 �����ϰ�(st), �Ѿ�(sum)�� �Է� �޴´�.
		setTitle("������ ���");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		if(st.equals("����")){		//������ ��� ó��
			JLabel j_get=new JLabel("�����ݾ�  : ");
			j_get.setSize(73,20);
			j_get.setLocation(47,20);
			getContentPane().add(j_get);
			
			JLabel j_put=new JLabel("�Ž�����  : ");
			j_put.setSize(73,20);
			j_put.setLocation(47,50);
			getContentPane().add(j_put);
		
			JTextField t_get = new JTextField();
			t_get.setLocation(120,20);
			t_get.setSize(100,20);
			getContentPane().add(t_get);
			t_get.setColumns(10);
			
			JTextField t_put = new JTextField();
			t_put.setLocation(120,50);
			t_put.setSize(100,20);
			getContentPane().add(t_put);
			t_put.setColumns(10);
			
			Button b=new Button("Ȯ��");
			b.setLocation(226,20);
			b.setSize(40,20);
			b.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int a=Integer.parseInt(t_get.getText())-sum;
					t_put.setText(String.valueOf(a));	//�Ž������� ����Ѵ�.
				}
			});
			getContentPane().add(b);
			
			Button b2=new Button("���");
			b2.setLocation(108,93);
			b2.setSize(62,38);
			b2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					update up=new update(text);
					up.file();
					ADD(sum);   	//��¹�ư ���� �� ADD�Լ��� �̵�
					setVisible(false);
				}
			});
			getContentPane().add(b2);
		}
		if(st.equals("ī��")) {	//ī�� ������ ��� ó��
			JLabel la = new JLabel("�� �հ� �ݾ� : ");
			la.setBounds(48, 43, 88, 37);
			getContentPane().add(la);
			
			JLabel la2 = new JLabel("");
			la2.setBounds(142, 43, 94, 37);
			la2.setText(String.valueOf(sum));
			getContentPane().add(la2);
			
			Button button = new Button("���");
			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					update up=new update(text);
					up.file();
				    ADD(sum);   	//��¹�ư ���� �� ADD�Լ��� �̵�	
					setVisible(false);
				}
			});
			button.setBounds(102, 96, 76, 37);
			getContentPane().add(button);
		}
		setModal(true);
		setVisible(true);
	}
	void ADD(int sum) {			//�� ����׿� ����� �� �ݾ��� ���Ѵ�.
		int score=0;
		Calendar today = Calendar.getInstance();
		String MON=String.valueOf(today.get(Calendar.MONTH)+1);
		String DAT=String.valueOf(today.get(Calendar.DATE));
		String MOD=MON+"/"+DAT;
		ArrayList<String[]> list = new ArrayList<String[]>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\�Ѹ����.txt"));
		} catch (FileNotFoundException ea) {
			ea.printStackTrace();
		}
		while(scan.hasNext()) {
			list.add(scan.nextLine().split("\t"));
		}
		scan.close();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0].equals(MOD)) {	//���� ��¥�� �����Ͱ� �ִٸ� score=1 ���ٸ� score=0
				score=1;
			}
		}
		if(score==1) {	//���� ��¥�� ������ ������ �ִٸ�, ������ �����Ϳ� �߰��Ǵ� �����͸� ���ؼ� �����Ѵ�.
			try {
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\�Ѹ����.txt"));
				for(int l=0; l<list.size(); l++) {
					if(list.get(l)[0].equals(MOD)) {
						int b=Integer.parseInt(list.get(l)[1])+sum;
						fi.write(list.get(l)[0]+"\t"+String.valueOf(b)+"\n");
					}
					else
						fi.write(list.get(l)[0]+"\t"+list.get(l)[1]+"\n");
				}
				fi.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(score==0) {	//���� ��¥�� ������ ������ ���ٸ�,�Ϸ� �� ��¥�� �̾ ���� �߰��Ǵ� �����͸� ���� �Ѵ�.
			try {
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\�Ѹ����.txt",true));
				fi.write(MOD+"\t"+sum+"\n");
				fi.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}
}
public class User_mode extends JFrame{
	int add_count=0;
	User_mode(){
		getContentPane().setBackground(new Color(224, 255, 255));
		setTitle("����� ���");
		getContentPane().setLayout(null);
	
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);	//scrollPane���� ������ â�� ����
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12,98,161,256);
		getContentPane().add(scrollPane);
		panel.setBackground(Color.white);		
		
		JTextArea receipt = new JTextArea();				//panel�� ǥ�� �Ǿ��� ������ ����
		receipt.setText("");
		panel.add(receipt);
		receipt.setEditable(false);
	
		JButton cash = new JButton("����");	
		cash.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum=0;
				String text=receipt.getText();
				String []arr=receipt.getText().split(" ");
				for(int i=0; i<arr.length; i++) {
					if((i+1)%5==0) {
						sum+=Integer.parseInt(arr[i-2])*Integer.parseInt(arr[i]);
					}
				}
				System.out.println(text);
				new ���������(sum,"����",text);
				receipt.setText("");
			}
		});
		cash.setBounds(12, 354, 79, 40);
		getContentPane().add(cash);
		
		JButton card = new JButton("ī��");
		card.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int sum=0;
				String text=receipt.getText();
				String []arr=receipt.getText().split(" ");
				for(int i=0; i<arr.length; i++) {
					if((i+1)%5==0) {
						sum+=Integer.parseInt(arr[i-2])*Integer.parseInt(arr[i]);
					}
				}
				new ���������(sum,"ī��",text);
				receipt.setText("");
			}
		});
		card.setBounds(88, 354, 85, 40);
		getContentPane().add(card);
		
		JButton revise = new JButton("����");
		revise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ����(receipt);
			}
		});
		revise.setBounds(12, 391, 161, 40);
		getContentPane().add(revise);
		/////////////////////////���̺� ����//////////////////////////		
		JTextArea table_1 = new JTextArea();
		table_1.setText("");
		table_1.setEditable(false);
		table_1.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_1.getText());
				table_1.setText("");
			}
		});
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_1.setText(str);
				}
		});
		table_1.setBounds(196, 98, 114, 93);
		getContentPane().add(table_1);
		
		JTextArea table_2 = new JTextArea();
		table_2.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_2.getText());
				table_2.setText("");
			}
		});
		table_2.setText("");
		table_2.setEditable(false);
		table_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_2.setText(str);
			}
		});
		table_2.setBounds(322, 100, 114, 93);
		getContentPane().add(table_2);
		
		JTextArea table_3 = new JTextArea();
		table_3.setText("");
		table_3.setEditable(false);
		table_3.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_3.getText());
				table_3.setText("");
			}
		});
		table_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {				
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_3.setText(str);
				}
				
		});
		table_3.setBounds(448, 98, 114, 93);
		getContentPane().add(table_3);
		
		JTextArea table_4 = new JTextArea();
		table_4.setText("");
		table_4.setEditable(false);
		table_4.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_4.getText());
				table_4.setText("");
			}
		});
		table_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_4.setText(str);
				}
				
		});
		table_4.setBounds(574, 98, 114, 93);
		getContentPane().add(table_4);
		
		JTextArea table_5 = new JTextArea();
		table_5.setText("");
		table_5.setEditable(false);
		table_5.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_5.getText());
				table_5.setText("");
			}
		});
		table_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_5.setText(str);
				}
				
		});
		table_5.setBounds(196, 201, 114, 93);
		getContentPane().add(table_5);
		
		JTextArea table_6 = new JTextArea();
		table_6.setText("");
		table_6.setEditable(false);
		table_6.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_6.getText());
				table_6.setText("");
			}
		});
		table_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_6.setText(str);
				}
				
		});
		table_6.setBounds(322, 203, 114, 93);
		getContentPane().add(table_6);
		
		JTextArea table_7 = new JTextArea();
		table_7.setText("");
		table_7.setEditable(false);
		table_7.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_7.getText());
				table_7.setText("");
			}
		});
		table_7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_7.setText(str);
				}
				
		});
		table_7.setBounds(448, 201, 114, 93);
		getContentPane().add(table_7);
		
		JTextArea table_8 = new JTextArea();
		table_8.setText("");
		table_8.setEditable(false);
		table_8.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_8.getText());
				table_8.setText("");
			}
		});
		table_8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_8.setText(str);
				}
				
		});
		table_8.setBounds(574, 201, 114, 93);
		getContentPane().add(table_8);
		
		JTextArea table_9 = new JTextArea();
		table_9.setText("");
		table_9.setEditable(false);
		table_9.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_9.getText());
				table_9.setText("");
			}
		});
		table_9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_9.setText(str);
				}
				
		});
		table_9.setBounds(196, 304, 114, 93);
		getContentPane().add(table_9);
		
		JTextArea table_10 = new JTextArea();
		table_10.setText("");
		table_10.setEditable(false);
		table_10.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_10.getText());
				table_10.setText("");
			}
		});
		table_10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_10.setText(str);
				}
				
		});
		table_10.setBounds(322, 304, 114, 93);
		getContentPane().add(table_10);
		
		JTextArea table_11 = new JTextArea();
		table_11.setText("");
		table_11.setEditable(false);
		table_11.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_11.getText());
				table_11.setText("");
			}
		});
		table_11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_11.setText(str);
				}
				
		});
		table_11.setBounds(448, 301, 114, 93);
		getContentPane().add(table_11);
		
		JTextArea table_12 = new JTextArea();
		table_12.setText("");
		table_12.setEditable(false);
		table_12.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_12.getText());
				table_12.setText("");
			}
		});
		table_12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_12.setText(str);
				}
				
		});
		table_12.setBounds(574, 304, 114, 93);
		getContentPane().add(table_12);
		
		JTextArea table_13 = new JTextArea("");
		table_13.setBackground(Color.WHITE);
		table_13.setBounds(196, 413, 114, 95);
		table_13.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_13.getText());
				table_13.setText("");
			}
		});
		table_13.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_13.setText(str);
				}
				
		});
		getContentPane().add(table_13);
		table_13.setVisible(false);
		table_13.setEditable(false);
		
		JTextArea table_14 = new JTextArea("");
		table_14.setBackground(Color.WHITE);
		table_14.setBounds(322, 413, 114, 95);
		getContentPane().add(table_14);
		table_14.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_14.getText());
				table_14.setText("");
			}
		});
		table_14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_14.setText(str);
				}
				
		});
		table_14.setVisible(false);
		table_14.setEditable(false);
		
		JTextArea table_15 = new JTextArea("");
		table_15.setBackground(Color.WHITE);
		table_15.setBounds(448, 413, 114, 95);
		table_15.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_15.getText());
				table_15.setText("");
			}
		});
		table_15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_15.setText(str);
				}
				
		});
		getContentPane().add(table_15);
		table_15.setVisible(false);
		table_15.setEditable(false);
		
		JTextArea table_16 = new JTextArea("");
		table_16.setBackground(Color.WHITE);
		table_16.setBounds(574, 413, 114, 95);
		getContentPane().add(table_16);
		table_16.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				���â ���=new ���â();
				if(���.a==1)
					receipt.setText(table_16.getText());
				table_16.setText("");
			}
		});
		table_16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.��������();
				str=cas.str;
				table_16.setText(str);
				}
		});
		table_16.setVisible(false);
		table_16.setEditable(false);
		/////////////////////////���̺� ���� ��//////////////////////////		
		Font font=new Font("����ü",Font.BOLD,15);
		Font font2=new Font("HY�߰��", Font.BOLD, 35);
	    ///////////////////���̺� �߰�///////////////////////	
		JButton B_add = new JButton("ADD");
		B_add.setForeground(new Color(127, 255, 212));
		B_add.setFont(font);
		B_add.setBackground(new Color(0, 191, 255));
		B_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				switch(add_count) {
				case 0:
					table_13.setVisible(true);
					break;
				case 1:
					table_14.setVisible(true);
					break;
				case 2:
					table_15.setVisible(true);
					break;
				case 3:
					table_16.setVisible(true);
					break;
				}
				add_count++;
			}
		});
		B_add.setBounds(710, 160, 62, 52);
		getContentPane().add(B_add);
		///////////////////���̺� ����///////////////////////	
		JButton B_del = new JButton("DEL");
		B_del.setFont(font);
		B_del.setForeground(new Color(127, 255, 212));
		B_del.setBackground(new Color(0, 191, 255));
		B_del.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_count--;
				switch(add_count) {
				case 0:
					table_13.setVisible(false);
					break;
				case 1:
					table_14.setVisible(false);
					break;
				case 2:
					table_15.setVisible(false);
					break;
				case 3:
					table_16.setVisible(false);
					break;
				}
			}
		});
		B_del.setBounds(710, 262, 62, 52);
		getContentPane().add(B_del);
		////////////////�⺻ ����(�Ӹ���)///////////////////	
		JLabel label = new JLabel("TABLE");
		label.setForeground(new Color(255, 0, 255));
		label.setFont(font2);
		label.setBounds(369, 38, 144, 52);
		getContentPane().add(label);
		
		JLabel label2 = new JLabel("���");
		label2.setForeground(Color.MAGENTA);
		label2.setFont(new Font("HY�߰��", Font.BOLD, 35));
		label2.setBounds(48, 36, 79, 52);
		getContentPane().add(label2);
		
		JLabel lable_today = new JLabel();
		lable_today.setFont(font);
		Calendar today=Calendar.getInstance();
		String mo,ye,da;
		mo=String.valueOf(today.get(Calendar.MONTH)+1);
		ye=String.valueOf(today.get(Calendar.YEAR));
		da=String.valueOf(today.get(Calendar.DATE));
		lable_today.setText(ye+"-"+mo+"-"+da);
		lable_today.setBounds(48, 456, 104, 52);
		getContentPane().add(lable_today);
		///////////////////////////////////////////////	
		setSize(800,600);
		setVisible(true);
	}
	public static void main(String [] args) {
		new User_mode();
	}
}
