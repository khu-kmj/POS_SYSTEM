package pos_program;
import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.io.*;

class 추가 extends JDialog{			//알바와 정직원 추가
	public 추가() {
		setTitle("추가");
		setBounds(250, 150, 300, 200);
		
		getContentPane().setLayout(null);
		JLabel l=new JLabel("이름 :");
		l.setBounds(84, 10, 47, 20);
		getContentPane().add(l);
	
		JLabel l2 = new JLabel("분류 :");
		l2.setBounds(84, 36, 47, 20);
		getContentPane().add(l2);

		JLabel l3 = new JLabel("정보 :");
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
		
		JLabel info_label = new JLabel("정직원인 경우 직책");
		info_label.setBounds(94, 87, 112, 15);
		getContentPane().add(info_label);
		
		JLabel info_label2 = new JLabel("알바생인 경우 근무 시작 일");
		info_label2.setBounds(94, 105, 148, 15);
		getContentPane().add(info_label2);
		
		Button b=new Button("추가");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(kind.getText().equals("정직원")) {
					try {
							BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\정직원정보.txt",true));
							fi.write(name.getText()+"\t"+"0"+"\t"+info.getText()+"\n");
							fi.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}		//만약에 정직원을 입력했다면 기존에 저장 되어있던 정직원정보 파일에 새로운 정보를 기입한다.
				
				if(kind.getText().equals("알바")) {
					try {
							BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\직원정보.txt",true));
							fi.write(name.getText()+"\t"+"0"+"\t"+info.getText()+"\n");
							fi.close();
						} catch (IOException e1) {
							e1.printStackTrace();
						}
					}		//만약에 알바를 입력했다면 기존에 저장 되어있던 직원정보 파일에 새로운 정보를 기입한다.
				setVisible(false);		//입력이 끝났다면 종료한다.
				}
		});
		b.setLocation(120,131);
		b.setSize(40,20);
		getContentPane().add(b);
		setModal(true);
		setVisible(true);
	}
}
class 수령 extends JDialog{		//아르바이트의 경우에만 수령한 경우
	public 수령(){				//정직원의 경우 30일을 채우면 자동으로 월급이 입금이 된다.
		setTitle("수령");
		setBounds(250, 150, 300, 200);
		setLayout(null);

		JLabel l=new JLabel("이름 :");
		l.setBounds(84, 50, 47, 20);
		add(l);
		
		JTextField t = new JTextField();
		add(t);
		t.setColumns(10);
		t.setBounds(132, 50, 74, 20);
		
		Button b=new Button("확인");
		b.addActionListener(new ActionListener() {			//직원 정보를 입력받고 확인 버튼을 선택했다면
			public void actionPerformed(ActionEvent e) {	//기존의 아르바이트 시간을 삭제하고 '0'로 초기화 한다.(월급을 수령했기 때문에)
				String name=t.getText();
				ArrayList<String[]> list = new ArrayList<String[]>();	//정보를 담기위한 ArrayList
				Scanner scan = null;
				try {													//직원 정보 파일을불러온다.
					scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\직원정보.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					list.add(scan.nextLine().split("\t"));
				}
				scan.close();
				try {
					BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\직원정보.txt"));
					for(int l=0; l<list.size(); l++) {
						if(list.get(l)[0].equals(name))	//파일 정보 중 입력한 이름과 같은 항목이 있다면
							fi.write(list.get(l)[0]+"\t"+String.valueOf(0)+"\t"+list.get(l)[2]+"\n");//0으로 초기화한다.
						else
							fi.write(list.get(l)[0]+"\t"+list.get(l)[1]+"\t"+list.get(l)[2]+"\n");//원래의 값으로 복원한다.
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
class 계산기 extends JDialog{			//아르바이트의 경우 급여를 계산한다.(분 단위 계산기)
	public 계산기(){
		setTitle("계산기");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		
		JLabel la=new JLabel("");
		la.setBounds(60,80,200,20);
		add(la);
		
		JLabel l=new JLabel("근무 시간(분)  :");
		l.setBounds(35, 30, 100, 20);
		add(l);

		JTextField t = new JTextField();
		getContentPane().add(t);
		t.setColumns(10);
		t.setBounds(130, 30, 60, 20);
		
		JLabel Newla = new JLabel("정직원의 경우 30일 기준 250만원");	//정직원의 경우 30일을 채우면 자동으로 월급을 
		Newla.setBounds(35, 70, 200, 15);						//지급 하기 때문에 계산기가 필요 없다고 가정.
		getContentPane().add(Newla);
		
		Button b=new Button("계산");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int asd=Integer.parseInt(t.getText())*140;
				String a="계산 결과 "+String.valueOf(asd)+"원 입니다.";
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
class 재고주문 extends JDialog{		//필요한 재고를 주문한다.
	public 재고주문(){
		setTitle("재고주문");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		
		JLabel l=new JLabel("메뉴 이름 : ");
		l.setBounds(50, 30, 100, 20);
		add(l);
		
		JTextField t = new JTextField();
		getContentPane().add(t);
		t.setColumns(10);
		t.setBounds(120, 30, 100, 20);
		
		JTextField t2 = new JTextField();
		JLabel l2=new JLabel("주문 개수 : ");
		l2.setBounds(50, 60, 100, 20);
		add(l2);
		add(t2);
		t2.setColumns(10);
		t2.setBounds(120, 60, 100, 20);
		
		Button bu=new Button("확인");
		bu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 ArrayList<String[]> list = new ArrayList<String[]>();
			        Scanner scan = null;
					try {		//기존의 재고관리 파일을 불러온다.
						scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\재고관리.txt"));
					} catch (FileNotFoundException ea) {
						ea.printStackTrace();
					}
			        while(scan.hasNext()) {
			            list.add(scan.nextLine().split("\t"));
			        }
			        scan.close();
			    	try {
						BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\재고관리.txt"));
						for(int l=0; l<list.size(); l++) {
							if(list.get(l)[0].equals(t.getText())) {	//입력한 메뉴와 동일하다면 기존의 개수에 추가 주문 수를 더해준다.
								int b=Integer.parseInt(t2.getText())+Integer.parseInt(list.get(l)[1]);
								fi.write(list.get(l)[0]+"\t"+String.valueOf(b)+"\n");
							}
							else	//입력한 메뉴가 아니라면 기존의 개수로 입력 한다.
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
class 이름 extends JDialog{		//근무자의 이름 및 정보를 입력한다(시간을 기록하여 급여를 제공하기 위함)
	String name;			
	String type;
	public 이름(){
		setTitle("근무 시작");
		setBounds(250, 150, 300, 200);
		getContentPane().setLayout(null);
		
		JTextField t = new JTextField();
		t.setBounds(124, 58, 103, 21);
		getContentPane().add(t);
		t.setColumns(10);
		
		JLabel label = new JLabel("Name :");
		label.setBounds(77, 58, 49, 21);
		getContentPane().add(label);
		
		JRadioButton r = new JRadioButton("알바");
		r.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type="알바";
			}
		});
		r.setBounds(190, 29, 61, 23);
		getContentPane().add(r);
		
		JRadioButton r1 = new JRadioButton("정직원");
		r1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				type="정직원";
			}
		});
		r1.setBounds(119, 29, 71, 23);
		getContentPane().add(r1);
		
		JLabel label_1 = new JLabel("Type :");
		label_1.setBounds(77, 30, 49, 21);
		getContentPane().add(label_1);
		
		Button bt = new Button("확인");
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
	String header[]= {"이름","근무 시간","근무 시작 일"};
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
		Font font=new Font("\"HY견고딕",Font.BOLD,30);
		
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
				이름 name=new 이름();
				name1=name.name;
				type=name.type;
				if(type.equals("정직원")) {		//정직원일 경우에 시간을 체크하지 않고 일 수로 계산 한다.
					textArea_1.setText(name1+"("+type+")님 출석체크 되었습니다!");
					ArrayList<String[]> list = new ArrayList<String[]>();
					Scanner scan = null;
					try {
						scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\정직원정보.txt"));
					} catch (FileNotFoundException ea) {
						ea.printStackTrace();
					}
					while(scan.hasNext()) {
						list.add(scan.nextLine().split("\t"));
					}	
					scan.close();
					try {	
						BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\정직원정보.txt"));
						for(int l=0; l<list.size(); l++) {
							if(list.get(l)[0].equals(name1)) {
								int b=Integer.parseInt(list.get(l)[1])+1;//정직원정보 파일에 기존의 일 수에 하루를 더한다.
								if(b==30)	//만약에 30일을 출석체크 했다면, 일 수를 0으로 초기화하고 월급을 제공한다.
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
				else {	//아르바이트의 경우에는 근무 날짜와 시간을 정확하게 기록한다.
					date=String.valueOf(today.get(Calendar.MONTH)+1)+"/"+String.valueOf(today.get(Calendar.DATE))+"  "+String.valueOf(today.get(Calendar.HOUR))+":"+String.valueOf(today.get(Calendar.MINUTE));
					textArea_1.setText(name1+"("+type+") 근무 시작 : "+date);
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
				if(type.equals("알바")) {
					Calendar today2 = Calendar.getInstance();
					end_date=String.valueOf(today2.get(Calendar.MONTH)+1)+"/"+String.valueOf(today2.get(Calendar.DATE))+"  "+String.valueOf(today2.get(Calendar.HOUR))+":"+String.valueOf(today2.get(Calendar.MINUTE));
					int add=60*(today2.get(Calendar.HOUR)-today.get(Calendar.HOUR))+Math.abs(today2.get(Calendar.MINUTE)-today.get(Calendar.MINUTE));
					//int add 변수에 근무가 끝나는 시간과 근무 시작 시간 차이를 계산하여 대입 한다.
					textArea_1.setText(name1+"("+type+") 근무 시작 : "+date+"\n"+"근무 종료 : "+ end_date);
					ArrayList<String[]> list = new ArrayList<String[]>();
					Scanner scan = null;
					try {
						scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\직원정보.txt"));
					} catch (FileNotFoundException ea) {
						ea.printStackTrace();
					}
					while(scan.hasNext()) {
						list.add(scan.nextLine().split("\t"));
					}
					scan.close();
					try {	//add(근무 시작 시간과 종료 시간의 차)를 기존의 직원정보에 저장된 근무 시간에 더해준다.
						BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\직원정보.txt"));
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
		
		JButton NewButton = new JButton("재고 주문");
		NewButton.setBackground(new Color(127, 255, 212));
		NewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new 재고주문();
			}
		});
		NewButton.setBounds(630, 108, 97, 85);
		getContentPane().add(NewButton);
		
		JRadioButton Alba = new JRadioButton("알바");
		Alba.setBackground(new Color(224, 255, 255));
		Alba.addMouseListener(new MouseAdapter() { //라디오 버튼을 통해서 알바 선택시에 아르바이트 근무 시간 및 정보 출력
			public void mouseClicked(MouseEvent e) {
				ab2.setVisible(false);
				 ArrayList<String[]> list = new ArrayList<String[]>();
				 Scanner scan = null;
				 try {
					 scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\직원정보.txt"));
				 } catch (FileNotFoundException ea) {
					 ea.printStackTrace();
				 }
				 while(scan.hasNext()) {
					 list.add(scan.nextLine().split("\t"));
				 }
				 scan.close();
				 String[][] stringArray = list.stream().toArray(String[][]::new);
				 String header[]= {"이름","근무 시간(분)","최초 근무 날짜"};
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
		
		JRadioButton worker = new JRadioButton("정직원");
		worker.setBackground(new Color(224, 255, 255));
		worker.addMouseListener(new MouseAdapter() { ////라디오 버튼을 통해서 정직원 선택시에 정직원 직책 및 일 수 출력
			public void mouseClicked(MouseEvent e) {
				ab.setVisible(false);
				ArrayList<String[]> list = new ArrayList<String[]>();
				Scanner scan = null;
				try {
					scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\정직원정보.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					list.add(scan.nextLine().split("\t"));
				}
				scan.close();
				String[][] stringArray = list.stream().toArray(String[][]::new);
				String header[]= {"이름","근무 일 수","직책"};
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
		
		JButton btnAdd = new JButton("추가");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new 추가();
			}
		});
		btnAdd.setBounds(320, 485, 70, 39);
		getContentPane().add(btnAdd);
		
		JButton btnCalcurator = new JButton("급여계산기");
		btnCalcurator.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new 계산기();
			}
		});
		btnCalcurator.setBounds(458, 485, 143, 39);
		getContentPane().add(btnCalcurator);
		
		JButton btnget = new JButton("수령");
		btnget.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new 수령();
			}
		});
		btnget.setBounds(389, 485, 70, 39);
		getContentPane().add(btnget);
		
		Button button_1 = new Button("하루");		//하루동안의 메뉴별 매출량 및 팔린 수량을 확인 할 수 있다.
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
					scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\재고별매출.txt"));
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
		        		if(Da.equals(Today))		//오늘 날짜 기준(Today)으로  Da와 같다면 list에 add 
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
		
		Button button_2 = new Button("일주일");	//일주일 동안의 메뉴별 매출량 및 팔린 수량을 확인 할 수 있다.
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
					scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\재고별매출.txt"));
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
						int S_Day=Day-7;		//오늘 날짜로부터 7일을 빼서 계산한다(Start_Day)
						String []sca=scan.nextLine().split("\t");
						String []Da=sca[0].split(" ");
						int Da_Day=Integer.parseInt(Da[2]);
						int Da_Mon=Integer.parseInt(Da[0]);
						if(S_Day<=0) {		//오늘 일 수가 7일 이하일 때
							if(Da_Mon==Date-1 && Da_Day>S_Day+30 || Da_Mon==Date && Da_Day<=Day)
								list2.add(sca);	
						}	//그 전 달의 정보와 이번 달을 포함하여 일주일간 기록을 출력한다.
						else {	//오늘 일 수가 8일 이상 일 경우
							if(Date==Da_Mon && Da_Day>S_Day && Da_Day<=Day)
								list2.add(sca);
						}	//이번 달에서만 일주일간 기록을 출력한다.
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

		Button button_3 = new Button("월");	//한달 전의 메뉴별 매출량 및 팔린 수량을 확인 할 수 있다.(10월이라면 9월 달 정보)
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
					scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\재고별매출.txt"));
				} catch (FileNotFoundException ea) {
					ea.printStackTrace();
				}
				while(scan.hasNext()) {
					if(a==0) {
						header=scan.nextLine().split("\t");
						a++;
					}
					else { //저번 달 매출 출력
						String Date=String.valueOf(today.get(Calendar.MONTH));//10월이라면 9월을 Date에 담는다.
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
			
		Button button_4 = new Button("총매출");	//가게의 총 매출을 확일 할 수 있다.(일 수별로)
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
					scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\총매출액.txt"));
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