package pos_program;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;

class MyThread extends Thread{			//초기 화면에서 시간 출력을 위한 쓰레드 활용
	JLabel label;
	MyThread(JLabel label){
		this.label=label;
	}
	public void run(){
		Calendar today = Calendar.getInstance();
		int min=today.get(Calendar.MINUTE);
		int hou=today.get(Calendar.HOUR);
		if(hou==0) {
			hou=12;
		}
		int sec=today.get(Calendar.SECOND);
		int M=today.get(Calendar.AM_PM);
		String A_PM;
		if(M==1) {
			A_PM="오후";
		}
		else
			A_PM="오전";
		while(true) {
			label.setText(A_PM+" "+String.valueOf(hou)+":"+String.valueOf(min)+":"+String.valueOf(sec));
			sec++;
			if(sec==60) {
				sec=0;
				min++;
				if(min==60) {
					min=0;
					hou++;
					if(hou==24) {
						hou=0;
						A_PM="오전";
					}
					if(hou==12 && min==0 && sec==0) {
						A_PM="오후";
					}
				}
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}
	}
}
class PassWord extends JDialog{		//관리자 모드를 실행하기 위한 비밀번호 입력
	String a;
	PassWord(String password){
		setTitle("PassWord");
		setBounds(250, 150, 300, 200);
		setLayout(null);
		
		JLabel jbb=new JLabel("password   : ");
		jbb.setSize(100,10);
		jbb.setLocation(48,22);
		add(jbb);
		
		JLabel jb2=new JLabel("");
		jb2.setSize(100,10);
		jb2.setLocation(70,50);
		jb2.setText(password);
		add(jb2);
			
		JPasswordField textField = new JPasswordField();
		textField.setLocation(120,20);
		textField.setSize(100,20);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		Button b=new Button("확인");
		b.setLocation(120,100);
		b.setSize(40,20);
		b.addMouseListener(new MouseAdapter() {		
			public void mouseClicked(MouseEvent e) {
				a=textField.getText();
				setVisible(false);
				if(a.equals("mjoo1106")) {		//비밀번호가 mjoo1106과 일치 할 시에 관리자 모드 실행
					new Supervisor();
				}
				else {
					new PassWord("PassWord Error");		//비밀번호가 다를 시에 에러 메세지를 출력하고 재호출함.
				}
			}
			});
		add(b);
		setModal(true);
		setVisible(true);
	}
}
public class Mode_select extends JFrame{
	Mode_select(){
		getContentPane().setBackground(new Color(255, 250, 205));
		setTitle("MJ의 레스토랑");
		getContentPane().setLayout(null);
		
		Font font_1=new Font("HY견고딕", Font.PLAIN, 25);
		JLabel jtime = new JLabel("");
		jtime.setBounds(311, 238, 244, 93);
		jtime.setFont(font_1);
		getContentPane().add(jtime);
		
		MyThread a=new MyThread(jtime);
		a.start();
		
		Font font_2=new Font("HY견고딕", Font.BOLD, 35);
		JLabel la = new JLabel("사장님이 지켜보고 있다.");
		la.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uC0AC\uC7A5\uB2D8\uADF8\uB9BC.png"));
		la.setForeground(new Color(240, 128, 128));
		la.setBounds(164, 341, 446, 152);
		la.setFont(font_2);
		getContentPane().add(la);
		
		Font font_3=new Font("양재블럭체", Font.BOLD, 50);
		JLabel la_2 = new JLabel("MJ 구내식당");
		la_2.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uAC04\uD310.png"));
		la_2.setForeground(new Color(127, 255, 0));
		la_2.setBounds(45, 63, 688, 124);
		getContentPane().add(la_2);
		la_2.setFont(font_3);
		
		JMenuBar menu=new JMenuBar();
		JMenu file = new JMenu("모드");
		JMenuItem item = new JMenuItem("사용자 모드");		
		item.addActionListener(new ActionListener() {		//사용자 모드 클릭시 사용자 모드 불러옴
			public void actionPerformed(ActionEvent e) {
				new User_mode();
			}
		});
		
		JMenuItem item2 = new JMenuItem("관리자 모드");
		item2.addActionListener(new ActionListener() {		//관리자 모드 클릭시 패스워드 창을 불러옴
			public void actionPerformed(ActionEvent e) {
				new PassWord("");
				}
		});
		
		file.add(item);
		file.add(item2);
		menu.add(file);
		setJMenuBar(menu);
		setSize(800,600);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}
	public static void main(String [] args) {
		new Mode_select();
	}
}