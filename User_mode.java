package pos_program;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;
import java.util.*;

class 수정 extends JDialog{		//기존에 주문 했던 메뉴를 수정한다.
	String text;
	String text2="";
	수정(JTextArea text){			//기존에 주문 했던 메뉴를 입력 받는다.
		this.text=text.getText();
		String []arr=this.text.split(" ");
		setTitle("수정");
		setBounds(250, 150, 300, 200);
		getContentPane().setLayout(null);

		JLabel l=new JLabel("메뉴 이름  :");
		l.setBounds(67, 30, 76, 20);
		getContentPane().add(l);

		JLabel label = new JLabel("수량         :");
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
		
		Button b=new Button("수정");
		b.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String menu=t.getText();	
				String menu2="\n"+t.getText();	//"\n"을 추가해준 이유 : 공백으로 split를 했는데 2번째 줄 부터 메뉴 앞에"\n"이 붙기 때문에 "\n메뉴"로 해석한다.
				String score=t2.getText();
				if(arr[0].equals(menu)) {	//첫번째 메뉴일 때 처리("\n"이 붙어 있지 않는 경우)
					arr[4]=score;
				}
				for(int i=1; i<arr.length; i++) {	//첫번째 메뉴일 때 제외 처리("\n"이 붙어 있는  경우)
					if(arr[i].equals(menu2)) {
						arr[i+4]=score;
					}
				}
				for(int i=0; i<arr.length; i++) {
					text2+=arr[i]+" ";		//수정한 텍스트를 다시 공백을 이용하여 붙인다.
				}
				text.setText(text2);	//수정한 텍스트를 화면에 출력한다.
				setVisible(false);		//종료한다.
			}
		});
		b.setLocation(116,102);
		b.setSize(40,20);
		getContentPane().add(b);
		setVisible(true);
	}
}
class Kindof{		//메뉴의 종류에 따라서 str에 저장한다. ( 테이블 화면에 출력하기 위한 작업), 
	String str="";	//테이블 별로 계속 반복해야 하기 때문에 class로 지정.
	void 음식종류() {
		Menu_list abb=new Menu_list();
		int i=0;
		while(abb.price[i]!=null) {
		switch(abb.price[i]) {
		case "라면 : 3500":
			str+=abb.price[i]+" X "+String.valueOf(abb.ramen_count)+" \n";
			break;
		case "햄버거 : 5500":
			str+=abb.price[i]+" X "+String.valueOf(abb.ham_count)+" \n";
			break;
		case "떡볶이 : 4500":
			str+=abb.price[i]+" X "+String.valueOf(abb.dduck_count)+" \n";
			break;
		case "순대 : 3000":
			str+=abb.price[i]+" X "+String.valueOf(abb.sondae_count)+" \n";
			break;
		case "튀김 : 4000":
			str+=abb.price[i]+" X "+String.valueOf(abb.twogim_count)+" \n";
			break;
		case "김치찌개 : 8000":
			str+=abb.price[i]+" X "+String.valueOf(abb.kimchi_count)+" \n";
			break;
		case "제육볶음 : 9500":
			str+=abb.price[i]+" X "+String.valueOf(abb.jaeyuk_count)+" \n";
			break;
		case "부대찌개 : 8500":
			str+=abb.price[i]+" X "+String.valueOf(abb.budae_count)+" \n";
			break;
		case "육개장 : 7000":
			str+=abb.price[i]+" X "+String.valueOf(abb.yukgae_count)+" \n";
			break;
		case "갈비탕 : 13000":
			str+=abb.price[i]+" X "+String.valueOf(abb.galbee_count)+" \n";
			break;
		case "사이다 : 1500":
			str+=abb.price[i]+" X "+String.valueOf(abb.saida_count)+" \n";
			break;
		case "환타 : 1500":
			str+=abb.price[i]+" X "+String.valueOf(abb.hwanta_count)+" \n";
			break;
		case "콜라 : 1500":
			str+=abb.price[i]+" X "+String.valueOf(abb.cola_count)+" \n";
			break;
		case "소주 : 4500":
			str+=abb.price[i]+" X "+String.valueOf(abb.soju_count)+" \n";
			break;
		case "맥주 : 4000":
			str+=abb.price[i]+" X "+String.valueOf(abb.beer_count)+" \n";
			break;
		}
		i++;
	  }
	}
}
class 계산창 extends JDialog{		//계산을 수행한다.
	int a=0;
	public 계산창() {
		setTitle("계산 확인 창");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		JLabel label=new JLabel("계산 하시겠습니까?");
		label.setSize(350,30);
		label.setLocation(50,30);
		add(label);
		Font font=new Font("굴림체",Font.BOLD,20);
		label.setFont(font);
		
		Button b=new Button("확인");	//영수증에 메뉴를 출력한다.
		b.setLocation(80,100);
		b.setSize(40,20);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				a=1;			//확인인 경우 a=1을 넣어서 취소와 구별한다.
				setVisible(false);
			}
		});
		add(b);
		Button b2=new Button("취소");		//영수증에 메뉴를 출력하지 않고 취소한다.
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
class update {		//메뉴 별 재고량을 관리한다.
	String text;
	public update(String text) {
		this.text=text;
	}
	int Menu(String []arr,int k) {	//각각의 메뉴에 숫자를 부과하여 구별한다. 그리고 값을 리턴 한다.
		int A=0;
		switch(arr[k]) {
			case "라면":
				A=1;
				break;
			case "햄버거":
				A=2;
				break;
			case "떡볶이":
				A=3;
				break;
			case "순대":
				A=4;
				break;
			case "튀김":
				A=5;
				break;
			case "김치찌개":
				A=6;
				break;
			case "제육볶음":
				A=7;
				break;
			case "부대찌개":
				A=8;
				break;
			case "육개장":
				A=9;
				break;
			case "갈비탕":
				A=10;
				break;
			case "사이다":
				A=11;
				break;
			case "환타":
				A=12;
				break;
			case "콜라":
				A=13;
				break;
			case "소주":
				A=14;
				break;
			case "맥주":
				A=15;
				break;
		}
		return A;
	}
	void file() {			//메뉴별로 계산이 완료된 수량 및 가격을 갱신한다.
		int score=0;
		String []tex=text.split(" ");	//생성자로 받아온 텍스트를 공백으로 나눈다.
		String []arr=new String[100];
		arr[0]=tex[0];					//(0) : 메뉴 
		arr[1]=tex[2];					//(2) : 가격
		arr[2]=tex[4];					//(4) : 수량
		int j=3;
		for(int i=5; i<tex.length-5; i=i+5) {	//5,10,15...를 기준으로 for문을 계산한다.
			String []tex2=tex[i].split("\n");	//2번째 메뉴 부터는 "\n메뉴이름"형태이기 때문에 "\n"을 기준으로 split 한다.
			arr[j]=tex2[1];						//메뉴 저장
			arr[j+1]=tex[i+2];					//(i+2) : 가격
			arr[j+2]=tex[i+4];					//(i+4) : 수량
			j=j+3;								
		}
		Calendar today = Calendar.getInstance();		//오늘 날짜 구함
		String MON=String.valueOf(today.get(Calendar.MONTH)+1);
		String DAT=String.valueOf(today.get(Calendar.DATE));
		String MOD=MON+" / "+DAT;
		ArrayList<String[]> list = new ArrayList<String[]>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\재고별매출.txt"));
		} catch (FileNotFoundException ea) {
			ea.printStackTrace();
		}
		while(scan.hasNext()) {
			list.add(scan.nextLine().split("\t"));
		}
		scan.close();
		for(int i=0; i<list.size(); i++) {	
			if(list.get(i)[0].equals(MOD)) {
				score=1;					//만약에 오늘 날짜가 파일에 있다면 score=1, 없다면 score=0;
			}
		}
		if(score==0) {//만약 오늘 날짜가 없다면, 추가적으로 계산된 메뉴를 제외하고 모두 0으로 초기화 한다.
			try {
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\재고별매출.txt",true));
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
					if(B==0) {	//주문이 되어지지 않은 메뉴들은 0으로 초기화
						fi.write("0 0\t");
					}
					if(B==1) {	//주문이 되었다면 해당 되는 메뉴에 가격과 수량을 바탕으로(주문된 수만큼) 초기화 한다. 
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
		if(score==1) {		//재고 파일에 오늘 날짜가 입력이 되어있을 때
			try {	
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\재고별매출.txt"));		
				for(int l=0; l<list.size(); l++) {
					if(list.get(l)[0].equals(MOD)) {	//MOD와 list가 저장한 날짜의 값이 동일하다면 실행한다.
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
							if(B==1) {	//주문이 되었다면 해당 되는 메뉴에 가격과 수량을 기존의 데이터와 더하여 저장한다. 
								String []brr = list.get(l)[i].split(" ");
								int price=Integer.parseInt(brr[0])+(Integer.parseInt(arr[K+1])*Integer.parseInt(arr[K+2]));
								int count=Integer.parseInt(brr[1])+Integer.parseInt(arr[K+2]);
								String abb=String.valueOf(price)+" "+String.valueOf(count);
								fi.write(abb+"\t");
							}
							if(B==0) {	//주문이 되어지지 않은 메뉴들은 원래의 값으로 저장한다.
								fi.write(list.get(l)[i]+"\t");
							}
						}
						fi.write("\n");
					}
					else {				//MOD와 list가 저장한 날짜의 값이 동일하지 않다면 실행한다.
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
class 영수증계산 extends JDialog{		//현금과 카드인 경우를 구별하여 총 액을 계산한다.
	영수증계산(int sum,String st,String text){		//현금 카드를 구별하고(st), 총액(sum)을 입력 받는다.
		setTitle("영수증 계산");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		if(st.equals("현금")){		//현금일 경우 처리
			JLabel j_get=new JLabel("받은금액  : ");
			j_get.setSize(73,20);
			j_get.setLocation(47,20);
			getContentPane().add(j_get);
			
			JLabel j_put=new JLabel("거스름돈  : ");
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
			
			Button b=new Button("확인");
			b.setLocation(226,20);
			b.setSize(40,20);
			b.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					int a=Integer.parseInt(t_get.getText())-sum;
					t_put.setText(String.valueOf(a));	//거스름돈을 출력한다.
				}
			});
			getContentPane().add(b);
			
			Button b2=new Button("출력");
			b2.setLocation(108,93);
			b2.setSize(62,38);
			b2.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					update up=new update(text);
					up.file();
					ADD(sum);   	//출력버튼 선택 시 ADD함수로 이동
					setVisible(false);
				}
			});
			getContentPane().add(b2);
		}
		if(st.equals("카드")) {	//카드 선택의 경우 처리
			JLabel la = new JLabel("총 합계 금액 : ");
			la.setBounds(48, 43, 88, 37);
			getContentPane().add(la);
			
			JLabel la2 = new JLabel("");
			la2.setBounds(142, 43, 94, 37);
			la2.setText(String.valueOf(sum));
			getContentPane().add(la2);
			
			Button button = new Button("출력");
			button.addMouseListener(new MouseAdapter() {
				public void mouseClicked(MouseEvent e) {
					update up=new update(text);
					up.file();
				    ADD(sum);   	//출력버튼 선택 시 ADD함수로 이동	
					setVisible(false);
				}
			});
			button.setBounds(102, 96, 76, 37);
			getContentPane().add(button);
		}
		setModal(true);
		setVisible(true);
	}
	void ADD(int sum) {			//총 매출액에 계산한 총 금액을 더한다.
		int score=0;
		Calendar today = Calendar.getInstance();
		String MON=String.valueOf(today.get(Calendar.MONTH)+1);
		String DAT=String.valueOf(today.get(Calendar.DATE));
		String MOD=MON+"/"+DAT;
		ArrayList<String[]> list = new ArrayList<String[]>();
		Scanner scan = null;
		try {
			scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\총매출액.txt"));
		} catch (FileNotFoundException ea) {
			ea.printStackTrace();
		}
		while(scan.hasNext()) {
			list.add(scan.nextLine().split("\t"));
		}
		scan.close();
		for(int i=0; i<list.size(); i++) {
			if(list.get(i)[0].equals(MOD)) {	//오늘 날짜의 데이터가 있다면 score=1 없다면 score=0
				score=1;
			}
		}
		if(score==1) {	//오늘 날짜의 데이터 파일이 있다면, 기존의 데이터와 추가되는 데이터를 더해서 저장한다.
			try {
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\총매출액.txt"));
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
		if(score==0) {	//오늘 날짜의 데이터 파일이 없다면,하루 전 날짜에 이어서 현재 추가되는 데이터만 저장 한다.
			try {
				BufferedWriter fi = new BufferedWriter(new FileWriter("C:\\Users\\명주\\Desktop\\명주\\총매출액.txt",true));
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
		setTitle("사용자 모드");
		getContentPane().setLayout(null);
	
		JPanel panel = new JPanel();
		JScrollPane scrollPane = new JScrollPane(panel);	//scrollPane으로 영수증 창을 구현
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(12,98,161,256);
		getContentPane().add(scrollPane);
		panel.setBackground(Color.white);		
		
		JTextArea receipt = new JTextArea();				//panel에 표시 되어질 영수증 정보
		receipt.setText("");
		panel.add(receipt);
		receipt.setEditable(false);
	
		JButton cash = new JButton("현금");	
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
				new 영수증계산(sum,"현금",text);
				receipt.setText("");
			}
		});
		cash.setBounds(12, 354, 79, 40);
		getContentPane().add(cash);
		
		JButton card = new JButton("카드");
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
				new 영수증계산(sum,"카드",text);
				receipt.setText("");
			}
		});
		card.setBounds(88, 354, 85, 40);
		getContentPane().add(card);
		
		JButton revise = new JButton("수정");
		revise.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new 수정(receipt);
			}
		});
		revise.setBounds(12, 391, 161, 40);
		getContentPane().add(revise);
		/////////////////////////테이블 관리//////////////////////////		
		JTextArea table_1 = new JTextArea();
		table_1.setText("");
		table_1.setEditable(false);
		table_1.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_1.getText());
				table_1.setText("");
			}
		});
		table_1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
				str=cas.str;
				table_1.setText(str);
				}
		});
		table_1.setBounds(196, 98, 114, 93);
		getContentPane().add(table_1);
		
		JTextArea table_2 = new JTextArea();
		table_2.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				계산창 계산=new 계산창();
				if(계산.a==1)
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
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_3.getText());
				table_3.setText("");
			}
		});
		table_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {				
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_4.getText());
				table_4.setText("");
			}
		});
		table_4.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_5.getText());
				table_5.setText("");
			}
		});
		table_5.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_6.getText());
				table_6.setText("");
			}
		});
		table_6.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_7.getText());
				table_7.setText("");
			}
		});
		table_7.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_8.getText());
				table_8.setText("");
			}
		});
		table_8.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_9.getText());
				table_9.setText("");
			}
		});
		table_9.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_10.getText());
				table_10.setText("");
			}
		});
		table_10.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_11.getText());
				table_11.setText("");
			}
		});
		table_11.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_12.getText());
				table_12.setText("");
			}
		});
		table_12.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_13.getText());
				table_13.setText("");
			}
		});
		table_13.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_14.getText());
				table_14.setText("");
			}
		});
		table_14.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_15.getText());
				table_15.setText("");
			}
		});
		table_15.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
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
				계산창 계산=new 계산창();
				if(계산.a==1)
					receipt.setText(table_16.getText());
				table_16.setText("");
			}
		});
		table_16.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				String str;
				Kindof cas=new Kindof();
				cas.음식종류();
				str=cas.str;
				table_16.setText(str);
				}
		});
		table_16.setVisible(false);
		table_16.setEditable(false);
		/////////////////////////테이블 관리 끝//////////////////////////		
		Font font=new Font("굴림체",Font.BOLD,15);
		Font font2=new Font("HY견고딕", Font.BOLD, 35);
	    ///////////////////테이블 추가///////////////////////	
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
		///////////////////테이블 삭제///////////////////////	
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
		////////////////기본 정보(머리말)///////////////////	
		JLabel label = new JLabel("TABLE");
		label.setForeground(new Color(255, 0, 255));
		label.setFont(font2);
		label.setBounds(369, 38, 144, 52);
		getContentPane().add(label);
		
		JLabel label2 = new JLabel("계산");
		label2.setForeground(Color.MAGENTA);
		label2.setFont(new Font("HY견고딕", Font.BOLD, 35));
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
