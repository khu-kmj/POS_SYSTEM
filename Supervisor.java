package pos_program;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class �߰� extends JDialog{			//�˹ٿ� ������ �߰�
	public �߰�() {
		setTitle("�߰�");
		setBounds(250, 150, 300, 200);
		
		getContentPane().setLayout(null);
		JLabel l=new JLabel("�̸� :");
		l.setBounds(84, 10, 47, 20);
		getContentPane().add(l);
	
		JLabel l2 = new JLabel("�з� :");
		l2.setBounds(84, 36, 47, 20);
		getContentPane().add(l2);

		JLabel l3 = new JLabel("���� :");
		l3.setBounds(84, 61, 47, 20);
		getContentPane().add(l3);
		
		JTextField name = new JTextField();
		getContentPane().add(name);
		name.setColumns(10);
		name.setBounds(132, 10, 74, 20);
		
		JTextField kind = new JTextField();
		kind.setColumns(10);
		kind.setBounds(132, 36, 74, 20);
		getContentPane().add(kind);
		
		JTextField info = new JTextField();
		info.setColumns(10);
		info.setBounds(132, 61, 74, 20);
		getContentPane().add(info);
		
		JLabel info_label = new JLabel("�������� ��� ��å");
		info_label.setBounds(94, 87, 112, 15);
		getContentPane().add(info_label);
		
		JLabel info_label2 = new JLabel("�˹ٻ��� ��� �ٹ� ���� ��");
		info_label2.setBounds(94, 105, 148, 15);
		getContentPane().add(info_label2);
		
		Button b=new Button("�߰�");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kind.getText().equals("������")) {
					try {
							BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\����������.txt",true));
							fi.write(name.getText()+"\t"+"0"+"\t"+info.getText()+"\n");
							fi.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}		//���࿡ �������� �Է��ߴٸ� ������ ���� �Ǿ��ִ� ���������� ���Ͽ� ���ο� ������ �����Ѵ�.
				
				if(kind.getText().equals("�˹�")) {
					try {
							BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\��������.txt",true));
							fi.write(name.getText()+"\t"+"0"+"\t"+info.getText()+"\n");
							fi.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}		//���࿡ �˹ٸ� �Է��ߴٸ� ������ ���� �Ǿ��ִ� �������� ���Ͽ� ���ο� ������ �����Ѵ�.
				setVisible(false);		//�Է��� �����ٸ� �����Ѵ�.
				}
		});
		b.setLocation(120,131);
		b.setSize(40,20);
		getContentPane().add(b);
		setModal(true);
		setVisible(true);
	}
}
class ���� extends JDialog{		//�Ƹ�����Ʈ�� ��쿡�� ������ ���
	public ����(){				//�������� ��� 30���� ä��� �ڵ����� ������ �Ա��� �ȴ�.
		setTitle("����");
		setBounds(250, 150, 300, 200);
		setLayout(null);

		JLabel l=new JLabel("�̸� :");
		l.setBounds(84, 50, 47, 20);
		add(l);
		
		JTextField t = new JTextField();
		add(t);
		t.setColumns(10);
		t.setBounds(132, 50, 74, 20);
		
		Button b=new Button("Ȯ��");
		b.addActionListener(new ActionListener() {			//���� ������ �Է¹ް� Ȯ�� ��ư�� �����ߴٸ�
			public void actionPerformed(ActionEvent e) {	//������ �Ƹ�����Ʈ �ð��� �����ϰ� '0'�� �ʱ�ȭ �Ѵ�.(������ �����߱� ������)
				String name=t.getText();
				ArrayList<String[]> list = new ArrayList<String[]>();	//������ ������� ArrayList
				Scanner scan = null;
				try {													//���� ���� �������ҷ��´�.
					scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\��������.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					list.add(scan.nextLine().split("\t"));
				}
				scan.close();
				try {
					BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\��������.txt"));
					for(int l=0; l<list.size(); l++) {
						if(list.get(l)[0].equals(name))	//���� ���� �� �Է��� �̸��� ���� �׸��� �ִٸ�
							fi.write(list.get(l)[0]+"\t"+String.valueOf(0)+"\t"+list.get(l)[2]+"\n");//0���� �ʱ�ȭ�Ѵ�.
						else
							fi.write(list.get(l)[0]+"\t"+list.get(l)[1]+"\t"+list.get(l)[2]+"\n");//������ ������ �����Ѵ�.
					}
					fi.close();
				}
				catch (IOException e1) {
					e1.printStackTrace();
				}
				setVisible(false);
			}
		});
		b.setLocation(118,102);
		b.setSize(40,20);
		add(b);
		setModal(true);
		setVisible(true);
	}
}
class ���� extends JDialog{			//�Ƹ�����Ʈ�� ��� �޿��� ����Ѵ�.(�� ���� ����)
	public ����(){
		setTitle("����");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		
		JLabel la=new JLabel("");
		la.setBounds(60,80,200,20);
		add(la);
		
		JLabel l=new JLabel("�ٹ� �ð�(��)  :");
		l.setBounds(35, 30, 100, 20);
		add(l);

		JTextField t = new JTextField();
		getContentPane().add(t);
		t.setColumns(10);
		t.setBounds(130, 30, 60, 20);
		
		JLabel Newla = new JLabel("�������� ��� 30�� ���� 250����");	//�������� ��� 30���� ä��� �ڵ����� ������ 
		Newla.setBounds(35, 70, 200, 15);						//���� �ϱ� ������ ���Ⱑ �ʿ� ���ٰ� ����.
		getContentPane().add(Newla);
		
		Button b=new Button("���");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int asd=Integer.parseInt(t.getText())*140;
				String a="��� ��� "+String.valueOf(asd)+"�� �Դϴ�.";
				la.setText(a);
			}
		});
		b.setLocation(210,30);
		b.setSize(40,20);
		add(b);
		setModal(true);
		setVisible(true);
	}
}
class ����ֹ� extends JDialog{		//�ʿ��� ��� �ֹ��Ѵ�.
	public ����ֹ�(){
		setTitle("����ֹ�");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		
		JLabel l=new JLabel("�޴� �̸� : ");
		l.setBounds(50, 30, 100, 20);
		add(l);
		
		JTextField t = new JTextField();
		getContentPane().add(t);
		t.setColumns(10);
		t.setBounds(120, 30, 100, 20);
		
		JTextField t2 = new JTextField();
		JLabel l2=new JLabel("�ֹ� ���� : ");
		l2.setBounds(50, 60, 100, 20);
		add(l2);
		add(t2);
		t2.setColumns(10);
		t2.setBounds(120, 60, 100, 20);
		
		Button bu=new Button("Ȯ��");
		bu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ArrayList<String[]> list = new ArrayList<String[]>();
			        Scanner scan = null;
					try {		//������ ������ ������ �ҷ��´�.
						scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\������.txt"));
					} catch (FileNotFoundException ea) {
						ea.printStackTrace();
					}
			        while(scan.hasNext()) {
			            list.add(scan.nextLine().split("\t"));
			        }
			        scan.close();
			    	try {
						BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\������.txt"));
						for(int l=0; l<list.size(); l++) {
							if(list.get(l)[0].equals(t.getText())) {	//�Է��� �޴��� �����ϴٸ� ������ ������ �߰� �ֹ� ���� �����ش�.
								int b=Integer.parseInt(t2.getText())+Integer.parseInt(list.get(l)[1]);
								fi.write(list.get(l)[0]+"\t"+String.valueOf(b)+"\n");
							}
							else	//�Է��� �޴��� �ƴ϶�� ������ ������ �Է� �Ѵ�.
								fi.write(list.get(l)[0]+"\t"+list.get(l)[1]+"\n");
						}
						fi.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				setVisible(false);
			}
		});
		bu.setLocation(120,100);
		bu.setSize(40,20);
		add(bu);
		setModal(true);
		setVisible(true);
	}
}
class �̸� extends JDialog{		//�ٹ����� �̸� �� ������ �Է��Ѵ�(�ð��� ����Ͽ� �޿��� �����ϱ� ����)
	String name;			
	String type;
	public �̸�(){
		setTitle("�ٹ� ����");
		setBounds(250, 150, 300, 200);
		getContentPane().setLayout(null);
		
		JTextField t = new JTextField();
		t.setBounds(124, 58, 103, 21);
		getContentPane().add(t);
		t.setColumns(10);
		
		JLabel label = new JLabel("Name :");
		label.setBounds(77, 58, 49, 21);
		getContentPane().add(label);
		
		JRadioButton r = new JRadioButton("�˹�");
		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type="�˹�";
			}
		});
		r.setBounds(190, 29, 61, 23);
		getContentPane().add(r);
		
		JRadioButton r1 = new JRadioButton("������");
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type="������";
			}
		});
		r1.setBounds(119, 29, 71, 23);
		getContentPane().add(r1);
		
		JLabel label_1 = new JLabel("Type :");
		label_1.setBounds(77, 30, 49, 21);
		getContentPane().add(label_1);
		
		Button bt = new Button("Ȯ��");
		bt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name=t.getText();
				setVisible(false);
			}
		});

		bt.setBounds(124, 103, 38, 23);
		getContentPane().add(bt);
		setModal(true);
		setVisible(true);
	}

}
public class Supervisor extends JFrame{
	String date;
	String end_date;
	String header[]= {"�̸�","�ٹ� �ð�","�ٹ� ���� ��"};
	String name1;
	String type;
	JScrollPane ab=new JScrollPane();
	JScrollPane ab2=new JScrollPane();
	Calendar today=Calendar.getInstance();
	JScrollPane abc1=new JScrollPane();
	JScrollPane abc2=new JScrollPane();
	JScrollPane abc3=new JScrollPane();
	JScrollPane abc4=new JScrollPane();
	Supervisor(){
		getContentPane().setBackground(new Color(224, 255, 255));
		getContentPane().setLayout(null);
		Font font=new Font("\"HY�߰��",Font.BOLD,30);
		
		JLabel lblSales = new JLabel("Sales");
		lblSales.setForeground(new Color(255, 204, 51));
		lblSales.setFont(font);
		lblSales.setBounds(44, 24, 86, 48);
		getContentPane().add(lblSales);
		
		JTextArea textArea_1 = new JTextArea();
		textArea_1.setBounds(320, 117, 206, 76);
		getContentPane().add(textArea_1);
		textArea_1.setEditable(false);
		
		JButton btnStart = new JButton("Start");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				�̸� name=new �̸�();
				name1=name.name;
				type=name.type;
				if(type.equals("������")) {		//�������� ��쿡 �ð��� üũ���� �ʰ� �� ���� ��� �Ѵ�.
					textArea_1.setText(name1+"("+type+")�� �⼮üũ �Ǿ����ϴ�!");
					ArrayList<String[]> list = new ArrayList<String[]>();
					Scanner scan = null;
					try {
						scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\����������.txt"));
					} catch (FileNotFoundException ea) {
						ea.printStackTrace();
					}
					while(scan.hasNext()) {
						list.add(scan.nextLine().split("\t"));
					}	
					scan.close();
					try {	
						BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\����������.txt"));
						for(int l=0; l<list.size(); l++) {
							if(list.get(l)[0].equals(name1)) {
								int b=Integer.parseInt(list.get(l)[1])+1;//���������� ���Ͽ� ������ �� ���� �Ϸ縦 ���Ѵ�.
								if(b==30)	//���࿡ 30���� �⼮üũ �ߴٸ�, �� ���� 0���� �ʱ�ȭ�ϰ� ������ �����Ѵ�.
									fi.write(list.get(l)[0]+"\t"+0+"\t"+list.get(l)[2]+"\n");
								fi.write(list.get(l)[0]+"\t"+String.valueOf(b)+"\t"+list.get(l)[2]+"\n");
							}
							else
								fi.write(list.get(l)[0]+"\t"+list.get(l)[1]+"\t"+list.get(l)[2]+"\n");
						}
						fi.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
				else {	//�Ƹ�����Ʈ�� ��쿡�� �ٹ� ��¥�� �ð��� ��Ȯ�ϰ� ����Ѵ�.
					date=String.valueOf(today.get(Calendar.MONTH)+1)+"/"+String.valueOf(today.get(Calendar.DATE))+"  "+String.valueOf(today.get(Calendar.HOUR))+":"+String.valueOf(today.get(Calendar.MINUTE));
					textArea_1.setText(name1+"("+type+") �ٹ� ���� : "+date);
				}
			}
		});
		btnStart.setBounds(320, 64, 97, 23);
		getContentPane().add(btnStart);
		
		JButton button = new JButton("Stop");
		button.setBounds(429, 64, 97, 23);
		getContentPane().add(button);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(type.equals("�˹�")) {
					Calendar today2 = Calendar.getInstance();
					end_date=String.valueOf(today2.get(Calendar.MONTH)+1)+"/"+String.valueOf(today2.get(Calendar.DATE))+"  "+String.valueOf(today2.get(Calendar.HOUR))+":"+String.valueOf(today2.get(Calendar.MINUTE));
					int add=60*(today2.get(Calendar.HOUR)-today.get(Calendar.HOUR))+Math.abs(today2.get(Calendar.MINUTE)-today.get(Calendar.MINUTE));
					//int add ������ �ٹ��� ������ �ð��� �ٹ� ���� �ð� ���̸� ����Ͽ� ���� �Ѵ�.
					textArea_1.setText(name1+"("+type+") �ٹ� ���� : "+date+"\n"+"�ٹ� ���� : "+ end_date);
					ArrayList<String[]> list = new ArrayList<String[]>();
					Scanner scan = null;
					try {
						scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\��������.txt"));
					} catch (FileNotFoundException ea) {
						ea.printStackTrace();
					}
					while(scan.hasNext()) {
						list.add(scan.nextLine().split("\t"));
					}
					scan.close();
					try {	//add(�ٹ� ���� �ð��� ���� �ð��� ��)�� ������ ���������� ����� �ٹ� �ð��� �����ش�.
						BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\����\\Desktop\\����\\��������.txt"));
						for(int l=0; l<list.size(); l++) {
							if(list.get(l)[0].equals(name1)) {
								int b;
								b=add+Integer.parseInt(list.get(l)[1]);
								fi.write(list.get(l)[0]+"\t"+String.valueOf(b)+"\t"+list.get(l)[2]+"\n");
							}
							else
								fi.write(list.get(l)[0]+"\t"+list.get(l)[1]+"\t"+list.get(l)[2]+"\n");
						}
						fi.close();
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				}
			}
		});
		JLabel lblWork = new JLabel("Work");
		lblWork.setFont(font);
		lblWork.setForeground(new Color(255, 204, 51));
		lblWork.setBounds(378, 25, 97, 29);
		getContentPane().add(lblWork);		
		
		JButton NewButton = new JButton("��� �ֹ�");
		NewButton.setBackground(new Color(127, 255, 212));
		NewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ����ֹ�();
			}
		});
		NewButton.setBounds(630, 108, 97, 85);
		getContentPane().add(NewButton);
		
		JRadioButton Alba = new JRadioButton("�˹�");
		Alba.setBackground(new Color(224, 255, 255));
		Alba.addMouseListener(new MouseAdapter() { //���� ��ư�� ���ؼ� �˹� ���ýÿ� �Ƹ�����Ʈ �ٹ� �ð� �� ���� ���
			public void mouseClicked(MouseEvent e) {
				ab2.setVisible(false);
				 ArrayList<String[]> list = new ArrayList<String[]>();
				 Scanner scan = null;
				 try {
					 scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\��������.txt"));
				 } catch (FileNotFoundException ea) {
					 ea.printStackTrace();
				 }
				 while(scan.hasNext()) {
					 list.add(scan.nextLine().split("\t"));
				 }
				 scan.close();
				 String[][] stringArray = list.stream().toArray(String[][]::new);
				 String header[]= {"�̸�","�ٹ� �ð�(��)","���� �ٹ� ��¥"};
				 JTable a=new JTable(stringArray,header);
				 ab=new JScrollPane(a);
				 ab.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				 ab.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				 ab.setBounds(320, 259, 280, 227);
				 getContentPane().add(ab);
				 setVisible(true);			
			}
		});
		Alba.setBounds(400, 230, 61, 23);
		getContentPane().add(Alba);
		
		JRadioButton worker = new JRadioButton("������");
		worker.setBackground(new Color(224, 255, 255));
		worker.addMouseListener(new MouseAdapter() { ////���� ��ư�� ���ؼ� ������ ���ýÿ� ������ ��å �� �� �� ���
			public void mouseClicked(MouseEvent e) {
				ab.setVisible(false);
				ArrayList<String[]> list = new ArrayList<String[]>();
				Scanner scan = null;
				try {
					scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\����������.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					list.add(scan.nextLine().split("\t"));
				}
				scan.close();
				String[][] stringArray = list.stream().toArray(String[][]::new);
				String header[]= {"�̸�","�ٹ� �� ��","��å"};
				JTable a=new JTable(stringArray,header);
				ab2=new JScrollPane(a);
				ab2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
				ab2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				ab2.setBounds(320, 259, 280, 227);
				getContentPane().add(ab2);
				setVisible(true);
			}
		});
		worker.setBounds(458, 230, 79, 23);
		getContentPane().add(worker);
		
		JButton btnAdd = new JButton("�߰�");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new �߰�();
			}
		});
		btnAdd.setBounds(320, 485, 70, 39);
		getContentPane().add(btnAdd);
		
		JButton btnCalcurator = new JButton("�޿�����");
		btnCalcurator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ����();
			}
		});
		btnCalcurator.setBounds(458, 485, 143, 39);
		getContentPane().add(btnCalcurator);
		
		JButton btnget = new JButton("����");
		btnget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ����();
			}
		});
		btnget.setBounds(389, 485, 70, 39);
		getContentPane().add(btnget);
		
		Button button_1 = new Button("�Ϸ�");		//�Ϸ絿���� �޴��� ���ⷮ �� �ȸ� ������ Ȯ�� �� �� �ִ�.
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abc2.setVisible(false);
				abc3.setVisible(false);
				abc4.setVisible(false);
				int a=0;
				String[] header = null;
				ArrayList<String[]> list2 = new ArrayList<String[]>();
				Scanner scan = null;
				try {
					scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\�������.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					if(a==0) {
						header=scan.nextLine().split("\t");
						a++;
					}
					else {
						String Date=String.valueOf(today.get(Calendar.MONTH)+1);
			        	String Day=String.valueOf(today.get(Calendar.DATE));
		        		String []sca=scan.nextLine().split("\t");
		        		String Da=sca[0];
		        		String Today=Date+" / "+Day;
		        		if(Da.equals(Today))		//���� ��¥ ����(Today)����  Da�� ���ٸ� list�� add 
		        			list2.add(sca);
			        	}
			        }
				scan.close();
				String[][] stringArray = list2.stream().toArray(String[][]::new);
				JTable abcd=new JTable(stringArray,header);
				abc1=new JScrollPane(abcd);
				abc1.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				abc1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				abcd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				abc1.setBounds(12, 117, 206, 434);
				getContentPane().add(abc1);
				setVisible(true);
			}
		});
		button_1.setBounds(10, 86, 39, 23);
		getContentPane().add(button_1);
		
		Button button_2 = new Button("������");	//������ ������ �޴��� ���ⷮ �� �ȸ� ������ Ȯ�� �� �� �ִ�.
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=0;
				abc1.setVisible(false);
				abc2.setVisible(false);
				abc3.setVisible(false);
				String[] header = null;
				ArrayList<String[]> list2 = new ArrayList<String[]>();
				Scanner scan = null;
				try {
					scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\�������.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					if(a==0) {
						header=scan.nextLine().split("\t");
						a++;
					}
					else {
						int Date=today.get(Calendar.MONTH)+1;
						int Day=today.get(Calendar.DATE);
						int S_Day=Day-7;		//���� ��¥�κ��� 7���� ���� ����Ѵ�(Start_Day)
						String []sca=scan.nextLine().split("\t");
						String []Da=sca[0].split(" ");
						int Da_Day=Integer.parseInt(Da[2]);
						int Da_Mon=Integer.parseInt(Da[0]);
						if(S_Day<=0) {		//���� �� ���� 7�� ������ ��
							if(Da_Mon==Date-1 && Da_Day>S_Day+30 || Da_Mon==Date && Da_Day<=Day)
								list2.add(sca);	
						}	//�� �� ���� ������ �̹� ���� �����Ͽ� �����ϰ� ����� ����Ѵ�.
						else {	//���� �� ���� 8�� �̻� �� ���
							if(Date==Da_Mon && Da_Day>S_Day && Da_Day<=Day)
								list2.add(sca);
						}	//�̹� �޿����� �����ϰ� ����� ����Ѵ�.
					}
				}
				scan.close();
				String[][] stringArray = list2.stream().toArray(String[][]::new);
				JTable abcd=new JTable(stringArray,header);
				abc4=new JScrollPane(abcd);
				abc4.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				abc4.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				abcd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				abc4.setBounds(12, 117, 206, 434);
				getContentPane().add(abc4);
				setVisible(true);
			}
		});
		button_2.setBounds(55, 86, 50, 23);
		getContentPane().add(button_2);

		Button button_3 = new Button("��");	//�Ѵ� ���� �޴��� ���ⷮ �� �ȸ� ������ Ȯ�� �� �� �ִ�.(10���̶�� 9�� �� ����)
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abc1.setVisible(false);
				abc2.setVisible(false);
				abc4.setVisible(false);
				int a=0;
				String[] header = null;
				ArrayList<String[]> list2 = new ArrayList<String[]>();
				Scanner scan = null;
				try {
					scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\�������.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					if(a==0) {
						header=scan.nextLine().split("\t");
						a++;
					}
					else { //���� �� ���� ���
						String Date=String.valueOf(today.get(Calendar.MONTH));//10���̶�� 9���� Date�� ��´�.
						String []sca=scan.nextLine().split("\t");
						String []Da=sca[0].split(" ");
						if(Da[0].equals(Date))
							list2.add(sca);
					}
				}
				scan.close();
				String[][] stringArray = list2.stream().toArray(String[][]::new);
				JTable abcd=new JTable(stringArray,header);
				abc3=new JScrollPane(abcd);
				abc3.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				abc3.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				abcd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				abc3.setBounds(12, 117, 206, 434);
				getContentPane().add(abc3);
				setVisible(true);
			}
		});
		button_3.setBounds(111, 86, 44, 23);
		getContentPane().add(button_3);
			
		Button button_4 = new Button("�Ѹ���");	//������ �� ������ Ȯ�� �� �� �ִ�.(�� ������)
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				abc1.setVisible(false);
				abc3.setVisible(false);
				abc4.setVisible(false);
				int a=0;
				String[] header = null;
				ArrayList<String[]> list2 = new ArrayList<String[]>();
				Scanner scan = null;
				try {
					scan = new Scanner(new File("C:\\Users\\����\\Desktop\\����\\�Ѹ����.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					if(a==0) {
						header=scan.nextLine().split("\t");
						a++;
					}
					else {
						list2.add(scan.nextLine().split("\t"));
					}
				}
				scan.close();
				String[][] stringArray = list2.stream().toArray(String[][]::new);
				JTable abcd=new JTable(stringArray,header);
				abc2=new JScrollPane(abcd);
				abc2.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
				abc2.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				abcd.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
				abc2.setBounds(12, 117, 206, 434);
				getContentPane().add(abc2);
				setVisible(true);
			}
		});
		button_4.setBounds(161, 86, 55, 23);
		getContentPane().add(button_4);
		setSize(800,600);
		setVisible(true);
	}
	public static void main(String[] args) {
		new Supervisor();
	}
}