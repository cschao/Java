import java.awt.*;
import java.awt.event.*;

public class app18_8b extends Frame implements ActionListener
{
	static app18_8b frm=new app18_8b();  //用app18_8b類別產生frm物件
	static Panel pnl=new Panel(new GridLayout(4,3));   //建立面板物件pnl
	static Panel pnl2=new Panel(new GridLayout(4,1));  //建立面板物件pnl2
	static Label lab=new Label("0.",Label.RIGHT);   //建立lab 初值為"0." 向右靠齊
   //產生button物件
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
		frm.setLayout(null); //取消排版
		frm.setSize(200,200);   //設定frm的大小
		frm.setLocation(100,100);  //設定frm的初始位置
		frm.setBackground(Color.white);  //設定frm得背景顏色
		frm.setResizable(false);   //設定frm不可以再調整大小

		lab.setBounds(20,30,160,20);  //設定lab的位置與大小
		lab.setBackground(new Color(255,230,200));   //設定lab得背景顏色
      //介面一 0~9、c、=
		pnl.setBounds(20,60,120,120); //設定pnl的位置與大小
		pnl.add(btn7); //將按鍵加入介面pnl
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
      //介面二 + - * /
		pnl2.setBounds(140,60,40,120);   //設定pnl2的位置與大小
		pnl2.add(btn10);  //將按鍵加入pnl2
		pnl2.add(btn11);
		pnl2.add(btn12);
		pnl2.add(btn13);
      //註冊
      btn0.addActionListener(frm);  //將frm向按鍵註冊
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

		frm.add(lab);  //將lab加入frm
		frm.add(pnl);  //將pnl加入frm
		frm.add(pnl2); //將pbl2加入frm

		frm.setVisible(true);
      //關閉
   	frm.addWindowListener(new WindowAdapter(){
       	public void windowClosing(WindowEvent e){System.exit(0);}});
	}

   public int operandl=0;  //保留準備運算的值
   public String str="";   //輸入控制 將輸入用字串串起
   public String op="";    //記錄運算子
	public void actionPerformed(ActionEvent e)
	{
		Button btn=(Button) e.getSource();  //讀取輸入的button
      //運算
      if(btn==btn10||btn==btn11||btn==btn12||btn==btn13||btn==btn15)//按下+-*/=時
      {
         int number=Integer.parseInt(lab.getText());
         switch(op)  //若之前有保留運算的先運算 op!=0
         {
             case "+":   // 加
                number = operandl+number;
                break;
             case "-":   // 減
                number = operandl-number;
                break;
             case "*":   // 乘
                number = operandl*number;
                break;
             case "/":   // 除
                if(number!=0)    // 避免 /0
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
      //清除
      else if(btn==btn14)//按下c時
      {
         str="";
         operandl=0;
         op="";
         lab.setText("0.");
      }
      //數字
      else//按下0~9
      {
         int num=Integer.parseInt(btn.getLabel());
         if(num!=0 || str.length()!=0)//避免輸入的第一個字串為0
         {
		      str+=btn.getLabel();
		      lab.setText(str);
         }
      }
	}
}