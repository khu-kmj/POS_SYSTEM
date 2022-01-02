package pos_program;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import javax.swing.*;
import java.util.Calendar;

class MyThread extends Thread{			//�ʱ� ȭ�鿡�� �ð� ����� ���� ������ Ȱ��
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
			A_PM="����";
		}
		else
			A_PM="����";
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
						A_PM="����";
					}
					if(hou==12 && min==0 && sec==0) {
						A_PM="����";
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
class PassWord extends JDialog{		//������ ��带 �����ϱ� ���� ��й�ȣ �Է�
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
		
		Button b=new Button("Ȯ��");
		b.setLocation(120,100);
		b.setSize(40,20);
		b.addMouseListener(new MouseAdapter() {		
			public void mouseClicked(MouseEvent e) {
				a=textField.getText();
				setVisible(false);
				if(a.equals("mjoo1106")) {		//��й�ȣ�� mjoo1106�� ��ġ �� �ÿ� ������ ��� ����
					new Supervisor();
				}
				else {
					new PassWord("PassWord Error");		//��й�ȣ�� �ٸ� �ÿ� ���� �޼����� ����ϰ� ��ȣ����.
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
		setTitle("MJ�� �������");
		getContentPane().setLayout(null);
		
		Font font_1=new Font("HY�߰��", Font.PLAIN, 25);
		JLabel jtime = new JLabel("");
		jtime.setBounds(311, 238, 244, 93);
		jtime.setFont(font_1);
		getContentPane().add(jtime);
		
		MyThread a=new MyThread(jtime);
		a.start();
		
		Font font_2=new Font("HY�߰��", Font.BOLD, 35);
		JLabel la = new JLabel("������� ���Ѻ��� �ִ�.");
		la.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uC0AC\uC7A5\uB2D8\uADF8\uB9BC.png"));
		la.setForeground(new Color(240, 128, 128));
		la.setBounds(164, 341, 446, 152);
		la.setFont(font_2);
		getContentPane().add(la);
		
		Font font_3=new Font("�����ü", Font.BOLD, 50);
		JLabel la_2 = new JLabel("MJ �����Ĵ�");
		la_2.setIcon(new ImageIcon("C:\\Users\\\uBA85\uC8FC\\Desktop\\\uAC04\uD310.png"));
		la_2.setForeground(new Color(127, 255, 0));
		la_2.setBounds(45, 63, 688, 124);
		getContentPane().add(la_2);
		la_2.setFont(font_3);
		
		JMenuBar menu=new JMenuBar();
		JMenu file = new JMenu("���");
		JMenuItem item = new JMenuItem("����� ���");		
		item.addActionListener(new ActionListener() {		//����� ��� Ŭ���� ����� ��� �ҷ���
			public void actionPerformed(ActionEvent e) {
				new User_mode();
			}
		});
		
		JMenuItem item2 = new JMenuItem("������ ���");
		item2.addActionListener(new ActionListener() {		//������ ��� Ŭ���� �н����� â�� �ҷ���
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