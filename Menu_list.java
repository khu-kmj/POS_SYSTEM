package pos_program;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;
import javax.swing.*;
class 경고창 extends JDialog{		//재고가 5개 미만일 경우에 경고 메시지를 화면에 출력한다.
	경고창() {
		getContentPane().setBackground(new Color(250, 128, 114));
		setTitle("재고 없음");
		setBounds(250, 150, 300, 200);
		getContentPane().setLayout(null);
		
		JLabel label=new JLabel("재고가 5개 미만 입니다.");
		label.setForeground(new Color(255, 255, 255));
		label.setSize(272,30);
		label.setLocation(12,48);
		getContentPane().add(label);
		Font font=new Font("HY견고딕",Font.BOLD,23);
		label.setFont(font);
		
		Button b=new Button("확인");
		b.setBackground(new Color(255, 255, 255));
		b.setLocation(122,100);
		b.setSize(40,20);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			});
		getContentPane().add(b);
		setModal(true);
		setVisible(true);
	}
}
class FileWrite{		//재고 관리 파일을 열어서 주문한 수 만큼 차감한다.
	String menu;
	FileWrite(String menu){		//생성자를 통해서 주문이 들어간 메뉴를 입력 받는다.(기존의 수량에서 차감하기 위해서)
		this.menu=menu;
	}
	void File() {
		 ArrayList<String[]> list = new ArrayList<String[]>();
		 Scanner scan = null;
		 try {
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
				 if(list.get(l)[0].equals(menu)) {
					 int b=Integer.parseInt(list.get(l)[1])-1;
					 fi.write(list.get(l)[0]+"\t"+String.valueOf(b)+"\n");
					 if(b<5)
						 new 경고창();
				 }
				 else
					 fi.write(list.get(l)[0]+"\t"+list.get(l)[1]+"\n");
			 }
			 fi.close();
		 } catch (IOException e1) {
			 e1.printStackTrace();
		 }
	}
}
class 재고확인 extends JDialog{		//메뉴별로 남은 재고 수량을 확인할 수 있다.
	JLabel jb=new JLabel("");
	public 재고확인(){
		setTitle("재고확인");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		
		JLabel J_kind=new JLabel("종류   : ");		//검색 할 메뉴 이름
		J_kind.setSize(50,10);
		J_kind.setLocation(70,20);
		add(J_kind);
		
		JLabel J_stock=new JLabel("재고  : ");
		J_stock.setSize(50,10);
		J_stock.setLocation(70,50);
		add(J_stock);
		
		JTextField textField = new JTextField();
		textField.setLocation(120,20);
		textField.setSize(100,20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		jb.setSize(100,20);
		jb.setLocation(120,47);
		add(jb);
		
		Button b=new Button("확인");
		b.setLocation(120,100);
		b.setSize(40,20);
		b.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 ArrayList<String[]> list = new ArrayList<String[]>();
				 Scanner scan = null;
				 try {	//재고 관리 데이터로 부터 남은 재고 수량을 확인 한다.
					 scan = new Scanner(new File("C:\\Users\\명주\\Desktop\\명주\\재고관리.txt"));
				 } catch (FileNotFoundException ea) {
					 ea.printStackTrace();
				 }
				 while(scan.hasNext()) {
					 list.add(scan.nextLine().split("\t"));
				 }
				 scan.close();
				 for(int l=0; l<list.size(); l++) {
					 if(list.get(l)[0].equals(textField.getText())) {
						 jb.setText(String.valueOf(list.get(l)[1])+" 개");
					 }
				 }
			}
		});
		add(b);
		setModal(true);
		setVisible(true);
	}
}
public class Menu_list extends JDialog{
	String price[]= new String[200];
	int i=0;
	int ramen_count=0;
	int ham_count=0;
	int dduck_count=0;
	int sondae_count=0;
	int twogim_count=0;
	int kimchi_count=0;
	int jaeyuk_count=0;
	int budae_count=0;
	int yukgae_count=0;
	int galbee_count=0;
	int saida_count=0;
	int hwanta_count=0;
	int cola_count=0;
	int soju_count=0;
	int beer_count=0;
	Menu_list(){
		getContentPane().setBackground(new Color(255, 245, 238));
		setTitle("김명주");
		getContentPane().setLayout(null);
		
		Font fff=new Font("HY견고딕",Font.BOLD,35);
		JButton btnNewButton = new JButton("추가");		//메뉴 추가 버튼 클릭시 메뉴창 종료
		btnNewButton.setForeground(Color.GREEN);
		btnNewButton.setBackground(new Color(255, 255, 0));
		btnNewButton.setFont(fff);
		btnNewButton.setBounds(140, 10, 115, 58);
		getContentPane().add(btnNewButton);
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			});
		
		Font ffff=new Font("HY견고딕",Font.BOLD,20);
		JButton btnNewButton_2 = new JButton("재고 확인");
		btnNewButton_2.setForeground(new Color(0, 255, 0));
		btnNewButton_2.setBackground(new Color(255, 255, 0));
		btnNewButton_2.setFont(ffff);
		btnNewButton_2.setBounds(313, 10, 140, 58);
		getContentPane().add(btnNewButton_2);
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				new 재고확인();
			}
			});
		
		JButton btnNewButton_3 = new JButton("종료");		////메뉴 종료 버튼 클릭시 메뉴창 종료
		btnNewButton_3.setBackground(new Color(255, 255, 0));
		btnNewButton_3.setForeground(new Color(0, 255, 0));
		btnNewButton_3.setFont(fff);
		btnNewButton_3.setBounds(510, 10, 115, 58);
		getContentPane().add(btnNewButton_3);
		btnNewButton_3.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				setVisible(false);
			}
			});
		
		JLabel J_ramen = new JLabel("수량 :");	
		J_ramen.setBounds(140, 190, 47, 15);
		getContentPane().add(J_ramen);
		JLabel C_ramen = new JLabel("0");
		C_ramen.setBounds(175, 190, 35, 15);
		getContentPane().add(C_ramen);
		
		JButton B_ramen = new JButton("라면");
		B_ramen.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uB77C\uBA741.png"));
		B_ramen.setBounds(112, 90, 97, 90);
		getContentPane().add(B_ramen);
		B_ramen.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int j=0;
				 price[i]="라면 : 3500";
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}			
						j++;
					}
				 ramen_count++;
				 i++;
				 C_ramen.setText(String.valueOf(ramen_count));
				 FileWrite fw=new FileWrite("라면");
				 fw.File();
				 }
		});
		
		JLabel J_ham = new JLabel("수량 :");
		J_ham.setBounds(248, 190, 47, 15);
		getContentPane().add(J_ham);
		JLabel C_ham = new JLabel("0");
		C_ham.setBounds(283, 190, 35, 15);
		getContentPane().add(C_ham);
		
		JButton B_ham = new JButton("햄버거");
		B_ham.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uD584\uBC84\uAC70.png"));
		B_ham.setBounds(221, 90, 97, 90);
		getContentPane().add(B_ham);
		B_ham.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				int j=0;
				price[i]="햄버거 : 5500";
				while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
					if(i!=j && price[i].equals(price[j])){
						price[i]=null;
						i--;
					}
					j++;
				}
				ham_count++;
				 i++;
				 C_ham.setText(String.valueOf(ham_count));
				 FileWrite fw=new FileWrite("햄버거");
				 fw.File();
				 }
		});

		JLabel J_dduck = new JLabel("수량 :");
		J_dduck.setBounds(358, 190, 47, 15);
		getContentPane().add(J_dduck);
		JLabel C_dduck = new JLabel("0");
		C_dduck.setBounds(393, 190, 35, 15);
		getContentPane().add(C_dduck);

		JButton B_dduck = new JButton("떡볶이");
		B_dduck.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uB5A1\uBCF6\uC774.png"));	
		B_dduck.setBounds(330, 90, 97, 90);
		getContentPane().add(B_dduck);
		B_dduck.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="떡볶이 : 4500";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 dduck_count++;
				 i++;
				 C_dduck.setText(String.valueOf(dduck_count));
				 FileWrite fw=new FileWrite("떡볶이");
				 fw.File();
				 }
		});
	
		JLabel J_sondae = new JLabel("수량 :");
		J_sondae.setBounds(469, 190, 47, 15);
		getContentPane().add(J_sondae);
		JLabel C_sondae = new JLabel("0");
		C_sondae.setBounds(504, 190, 35, 15);
		getContentPane().add(C_sondae);
		
		JButton B_sondae = new JButton("순대");
		B_sondae.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uC21C\uB300.png"));
		B_sondae.setBounds(441, 90, 97, 90);
		getContentPane().add(B_sondae);
		B_sondae.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="순대 : 3000";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 sondae_count++;
				 i++;
				 C_sondae.setText(String.valueOf(sondae_count));
				 FileWrite fw=new FileWrite("순대");
				 fw.File();
				 }
		});
		
		JLabel J_twogim = new JLabel("수량 :");
		J_twogim.setBounds(578, 190, 47, 15);
		getContentPane().add(J_twogim);
		JLabel C_twogim = new JLabel("0");
		C_twogim.setBounds(613, 190, 35, 15);
		getContentPane().add(C_twogim);
		
		JButton B_twogim = new JButton("튀김");
		B_twogim.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uD280\uAE40.png"));
		B_twogim.setBounds(550, 90, 97, 90);
		getContentPane().add(B_twogim);
		B_twogim.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				 price[i]="튀김 : 4000";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 twogim_count++;
				 i++;
				 C_twogim.setText(String.valueOf(twogim_count));
				 FileWrite fw=new FileWrite("튀김");
				 fw.File();
				 }
		});
		
		JLabel J_kimchi = new JLabel("수량 :");
		J_kimchi.setBounds(140, 315, 47, 15);
		getContentPane().add(J_kimchi);
		JLabel C_kimchi = new JLabel("0");
		C_kimchi.setBounds(175, 315, 35, 15);
		getContentPane().add(C_kimchi);
		
		JButton B_kimchi = new JButton("김치찌개");
		B_kimchi.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uAE40\uCE58\uCC0C\uAC1C.png"));
		B_kimchi.setBounds(112, 215, 97, 90);
		getContentPane().add(B_kimchi);
		B_kimchi.addMouseListener(new MouseAdapter() {	
			public void mouseClicked(MouseEvent e) {
				 price[i]="김치찌개 : 8000";
				 int j=0;
				 while(price[j]!=null) {
						if(i!=j && price[i].equals(price[j])){	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
							price[i]=null;
							i--;
						}
						j++;
					}
				 kimchi_count++;
				 i++;
				 C_kimchi.setText(String.valueOf(kimchi_count));
				 FileWrite fw=new FileWrite("김치찌개");
				 fw.File();
				 }
		});
		
		JLabel J_jaeyuk = new JLabel("수량 :");
		J_jaeyuk.setBounds(248, 315, 47, 15);
		getContentPane().add(J_jaeyuk);
		JLabel C_jaeyuk = new JLabel("0");
		C_jaeyuk.setBounds(283, 315, 35, 15);
		getContentPane().add(C_jaeyuk);
		
		JButton B_jaeyuk = new JButton("제육볶음");
		B_jaeyuk.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uC81C\uC721\uBCF6\uC74C.png"));
		B_jaeyuk.setBounds(221, 215, 97, 90);
		getContentPane().add(B_jaeyuk);
		B_jaeyuk.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="제육볶음 : 9500";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 jaeyuk_count++;
				 i++;
				 C_jaeyuk.setText(String.valueOf(jaeyuk_count));
				 FileWrite fw=new FileWrite("제육볶음");
				 fw.File();
				 }
		});
		
		JLabel J_budae = new JLabel("수량 :");
		J_budae.setBounds(358, 315, 47, 15);
		getContentPane().add(J_budae);
		JLabel C_budae = new JLabel("0");
		C_budae.setBounds(393, 315, 35, 15);
		getContentPane().add(C_budae);
		
		JButton B_budae = new JButton("부대찌개");
		B_budae.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uBD80\uB300\uCC0C\uAC1C.png"));
		B_budae.setBounds(330, 215, 97, 90);
		getContentPane().add(B_budae);
		B_budae.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="부대찌개 : 8500";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 budae_count++;
				 i++;
				 C_budae.setText(String.valueOf(budae_count));
				 FileWrite fw=new FileWrite("부대찌개");
				 fw.File();
				 }
		});
		
		JLabel J_yukgae = new JLabel("수량 :");
		J_yukgae.setBounds(469, 315, 47, 15);
		getContentPane().add(J_yukgae);
		JLabel C_yukgae = new JLabel("0");
		C_yukgae.setBounds(504, 315, 35, 15);
		getContentPane().add(C_yukgae);
		
		JButton B_yukgae = new JButton("육개장");
		B_yukgae.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uC721\uAC1C\uC7A5.png"));
		B_yukgae.setBounds(441, 215, 97, 90);
		getContentPane().add(B_yukgae);
		B_yukgae.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="육개장 : 7000";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 yukgae_count++;
				 i++;
				 C_yukgae.setText(String.valueOf(yukgae_count));
				 FileWrite fw=new FileWrite("육개장");
				 fw.File();
				 }
		});
		
		JLabel J_galbee = new JLabel("수량 :");
		J_galbee.setBounds(578, 315, 47, 15);
		getContentPane().add(J_galbee);
		JLabel C_galbee = new JLabel("0");
		C_galbee.setBounds(613, 315, 35, 15);
		getContentPane().add(C_galbee);
		
		JButton B_galbee = new JButton("갈비탕");
		B_galbee.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uAC08\uBE44\uD0D5.png"));
		B_galbee.setBounds(550, 215, 97, 90);
		getContentPane().add(B_galbee);
		B_galbee.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="갈비탕 : 13000";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 galbee_count++;
				 i++;
				 C_galbee.setText(String.valueOf(galbee_count));
				 FileWrite fw=new FileWrite("갈비탕");
				 fw.File();
				 }
		});
		
		JLabel J_saida = new JLabel("수량 :");
		J_saida.setBounds(140, 440, 47, 15);
		getContentPane().add(J_saida);
		JLabel C_saida = new JLabel("0");
		C_saida.setBounds(175, 440, 35, 15);
		getContentPane().add(C_saida);
		
		JButton B_saida = new JButton("사이다");
		B_saida.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uC0AC\uC774\uB2E4.png"));
		B_saida.setBounds(112, 340, 97, 90);
		getContentPane().add(B_saida);
		B_saida.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="사이다 : 1500";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 saida_count++;
				 i++;
				C_saida.setText(String.valueOf(saida_count));
				 FileWrite fw=new FileWrite("사이다");
				 fw.File();
				 }
		});
		
		JLabel J_hwanta = new JLabel("수량 :");
		J_hwanta.setBounds(248, 440, 47, 15);
		getContentPane().add(J_hwanta);
		JLabel C_hwanta = new JLabel("0");
		C_hwanta.setBounds(283, 440, 35, 15);
		getContentPane().add(C_hwanta);
		
		JButton B_hwanta = new JButton("환타");
		B_hwanta.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uD658\uD0C0.png"));
		B_hwanta.setBounds(221, 340, 97, 90);
		getContentPane().add(B_hwanta);
		B_hwanta.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="환타 : 1500";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				hwanta_count++;
				 i++;
				 C_hwanta.setText(String.valueOf(hwanta_count));
				 FileWrite fw=new FileWrite("환타");
				 fw.File();
				 }
		});
		
		JLabel J_cola = new JLabel("수량 :");
		J_cola.setBounds(358, 440, 47, 15);
		getContentPane().add(J_cola);
		JLabel C_cola = new JLabel("0");
		C_cola.setBounds(393, 440, 35, 15);
		getContentPane().add(C_cola);
		
		JButton B_cola = new JButton("콜라");
		B_cola.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uCF5C\uB77C.png"));
		B_cola.setBounds(330, 340, 97, 90);
		getContentPane().add(B_cola);
		B_cola.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="콜라 : 1500";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 cola_count++;
				 i++;
				 C_cola.setText(String.valueOf(cola_count));
				 FileWrite fw=new FileWrite("콜라");
				 fw.File();
				 }
		});
		
		JLabel J_soju = new JLabel("수량 :");
		J_soju.setBounds(469, 440, 47, 15);
		getContentPane().add(J_soju);
		JLabel C_soju = new JLabel("0");
		C_soju.setBounds(504, 440, 35, 15);
		getContentPane().add(C_soju);
		
		JButton B_soju = new JButton("소주");
		B_soju.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uC18C\uC8FC.png"));
		B_soju.setBounds(441, 340, 97, 90);
		getContentPane().add(B_soju);
		B_soju.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="소주 : 4500";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 soju_count++;
				 i++;
				 C_soju.setText(String.valueOf(soju_count));
				 FileWrite fw=new FileWrite("소주");
				 fw.File();
			}
		});
		
		JLabel J_beer = new JLabel("수량 :");
		J_beer.setBounds(578, 440, 47, 15);
		getContentPane().add(J_beer);
		JLabel C_beer = new JLabel("0");
		C_beer.setBounds(613, 440, 35, 15);
		getContentPane().add(C_beer);
		
		JButton B_beer = new JButton("맥주");
		B_beer.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uB9E5\uC8FC.png"));	
		B_beer.setBounds(550, 340, 97, 90);
		getContentPane().add(B_beer);
		B_beer.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				 price[i]="맥주 : 4000";
				 int j=0;
				 while(price[j]!=null) {	//price 배열에 똑같은 정보가 추가로 하나 더 들어올 때 기존의 정보와 중복 처리 한다.
						if(i!=j && price[i].equals(price[j])){
							price[i]=null;
							i--;
						}
						j++;
					}
				 beer_count++;
				 i++;
				 C_beer.setText(String.valueOf(beer_count));
				 FileWrite fw=new FileWrite("맥주");
				 fw.File();
				 }
		});
	    ///////////////////////간판//////////////////////////
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(32, 90, 53, 90);
		getContentPane().add(panel);
		JLabel lblBul = new JLabel("분");
		panel.add(lblBul);
		lblBul.setForeground(Color.WHITE);
		lblBul.setFont(fff);
		JLabel lblBul2 = new JLabel("식");
		panel.add(lblBul2);
		lblBul2.setForeground(Color.WHITE);
		lblBul2.setFont(fff);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.orange);
		panel_1.setBounds(32, 215, 53, 90);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel label_7 = new JLabel("밥");
		label_7.setBounds(8, 27, 36, 41);
		panel_1.add(label_7);
		label_7.setForeground(Color.WHITE);
		label_7.setFont(new Font("HY견고딕", Font.BOLD, 35));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.green);
		panel_2.setBounds(32, 340, 53, 90);
		getContentPane().add(panel_2);
		
		JLabel label_8 = new JLabel("음");
		label_8.setForeground(Color.WHITE);
		label_8.setFont(new Font("HY견고딕", Font.BOLD, 35));
		panel_2.add(label_8);
		
		JLabel label_9 = new JLabel("료");
		label_9.setForeground(Color.WHITE);
		label_9.setFont(new Font("HY견고딕", Font.BOLD, 35));
		panel_2.add(label_9);
		////////////////////간판 종료/////////////////////////
		setBounds(50,50,700,500);
		setModal(true);
		setVisible(true);
	}
	public static void main(String[ ]args) {
		new Menu_list();
	}
}