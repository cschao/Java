import java.awt.*;
import java.awt.event.*;

public class app18_8b extends Frame implements ActionListener
{
	static app18_8b frm=new app18_8b();  //��app18_8b���O����frm����
	static Panel pnl=new Panel(new GridLayout(4,3));   //�إ߭��O����pnl
	static Panel pnl2=new Panel(new GridLayout(4,1));  //�إ߭��O����pnl2
	static Label lab=new Label("0.",Label.RIGHT);   //�إ�lab ��Ȭ�"0." �V�k�a��
   //����button����
   static Button btn0=new Button("0");
	static Button btn1=new Button("1");
	static Button btn2=new Button("2");
	static Button btn3=new Button("3");
	static Button btn4=new Button("4");
	static Button btn5=new Button("5");
	static Button btn6=new Button("6");
	static Button btn7=new Button("7");
	static Button btn8=new Button("8");
	static Button btn9=new Button("9");
   static Button btn10=new Button("+");
   static Button btn11=new Button("-");
   static Button btn12=new Button("*");
   static Button btn13=new Button("/");
   static Button btn14=new Button("C");
   static Button btn15=new Button("=");

	public static void main(String args[])
	{
		frm.setLayout(null); //�����ƪ�
		frm.setSize(200,200);   //�]�wfrm���j�p
		frm.setLocation(100,100);  //�]�wfrm����l��m
		frm.setBackground(Color.white);  //�]�wfrm�o�I���C��
		frm.setResizable(false);   //�]�wfrm���i�H�A�վ�j�p

		lab.setBounds(20,30,160,20);  //�]�wlab����m�P�j�p
		lab.setBackground(new Color(255,230,200));   //�]�wlab�o�I���C��
      //�����@ 0~9�Bc�B=
		pnl.setBounds(20,60,120,120); //�]�wpnl����m�P�j�p
		pnl.add(btn7); //�N����[�J����pnl
		pnl.add(btn8);
		pnl.add(btn9);
		pnl.add(btn4);
		pnl.add(btn5);
		pnl.add(btn6);
		pnl.add(btn1);
		pnl.add(btn2);
		pnl.add(btn3);
      pnl.add(btn0);
      pnl.add(btn14);
      pnl.add(btn15);
      //�����G + - * /
		pnl2.setBounds(140,60,40,120);   //�]�wpnl2����m�P�j�p
		pnl2.add(btn10);  //�N����[�Jpnl2
		pnl2.add(btn11);
		pnl2.add(btn12);
		pnl2.add(btn13);
      //���U
      btn0.addActionListener(frm);  //�Nfrm�V������U
      btn1.addActionListener(frm);
      btn2.addActionListener(frm);
      btn3.addActionListener(frm);
      btn4.addActionListener(frm);
      btn5.addActionListener(frm);
      btn6.addActionListener(frm);
      btn7.addActionListener(frm);
      btn8.addActionListener(frm);
      btn9.addActionListener(frm);
      btn10.addActionListener(frm);
      btn11.addActionListener(frm);
      btn12.addActionListener(frm);
      btn13.addActionListener(frm);
      btn14.addActionListener(frm);
      btn15.addActionListener(frm);

		frm.add(lab);  //�Nlab�[�Jfrm
		frm.add(pnl);  //�Npnl�[�Jfrm
		frm.add(pnl2); //�Npbl2�[�Jfrm

		frm.setVisible(true);
      //����
   	frm.addWindowListener(new WindowAdapter(){
       	public void windowClosing(WindowEvent e){System.exit(0);}});
	}

   public int operandl=0;  //�O�d�ǳƹB�⪺��
   public String str="";   //��J���� �N��J�Φr���_
   public String op="";    //�O���B��l
	public void actionPerformed(ActionEvent e)
	{
		Button btn=(Button) e.getSource();  //Ū����J��button
      //�B��
      if(btn==btn10||btn==btn11||btn==btn12||btn==btn13||btn==btn15)//���U+-*/=��
      {
         int number=Integer.parseInt(lab.getText());
         switch(op)  //�Y���e���O�d�B�⪺���B�� op!=0
         {
             case "+":   // �[
                number = operandl+number;
                break;
             case "-":   // ��
                number = operandl-number;
                break;
             case "*":   // ��
                number = operandl*number;
                break;
             case "/":   // ��
                if(number!=0)    // �קK /0
                number = operandl/number;
                break;
         }
         lab.setText(Integer.toString(number));
         op=btn.getLabel();
         if(op!="=")
         {
            operandl = number;
            str = "";
         }
      }
      //�M��
      else if(btn==btn14)//���Uc��
      {
         str="";
         operandl=0;
         op="";
         lab.setText("0.");
      }
      //�Ʀr
      else//���U0~9
      {
         int num=Integer.parseInt(btn.getLabel());
         if(num!=0 || str.length()!=0)//�קK��J���Ĥ@�Ӧr�ꬰ0
         {
		      str+=btn.getLabel();
		      lab.setText(str);
         }
      }
	}
}