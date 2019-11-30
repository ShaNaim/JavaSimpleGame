/* Right Click Triggers The No Button (Only on the Main Panel)*/
import java.lang.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;

public class FoolGame extends JFrame implements MouseListener, ActionListener
{
    private JButton YesBut,NoBut,ExitBut,AgainBut,NoAgainBut;
    private JLabel Label1,YesLabel,NoLabel;
    private JPanel MainPanel,YesPanel,NoPanel;
    private Color BackGColor,YesColor,NoColor;
    private Font Myfont;
    private final int Length = 70;
    private final int  Width = 30;

    FoolGame()
    {
        super("Are You A Fool ?");
        this.setSize(800,550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Myfont = new Font("Consolas", Font.BOLD | Font.ITALIC, 25);

        MainPanel = new JPanel();
        BackGColor = new Color(64,84,117);
        MainPanel.setBackground(BackGColor);
        MainPanel.addMouseListener(this);
        MainPanel.setLayout(null);

        Label1 = new JLabel("Are You A FOOL ?");
        Label1.setBounds(270,200,250,100);
        Label1.setFont(Myfont);
        Label1.setForeground(new Color(255,255,255));
        MainPanel.add(Label1);

        YesBut = new JButton("YES");
        YesBut.setBounds(250,300,Length,Width);
        YesBut.setBackground(Color.RED);
        YesBut.addMouseListener(this);
        YesBut.addActionListener(this);
        MainPanel.add(YesBut);

        NoBut = new JButton("NO");
        NoBut.setBounds(450, 300, Length, Width);
        NoBut.setBackground(Color.GREEN);
        NoBut.addMouseListener(this);
        NoBut.addActionListener(this);
        MainPanel.add(NoBut);

        this.add(MainPanel);
        this.setVisible(true);
    }

    public void mouseClicked(MouseEvent me){}

  	public void mousePressed(MouseEvent me)
    {
      if(me.getButton() == MouseEvent.BUTTON3)
      {
        MainPanel.setVisible(false);
        this.ShowNoPanel();
      }
      else{}
    }
  	public void mouseReleased(MouseEvent me){}

  	public void mouseEntered(MouseEvent me)
  	{
        if(me.getSource().equals(NoBut))
        {
            Random rand = new Random();
            int randXaxis = rand.nextInt(700);
            int randYaxis = rand.nextInt(450);
            NoBut.setBounds(randXaxis,randYaxis,Length,Width);
        }
        else{}
    }
    public void mouseExited(MouseEvent me){}
    public void actionPerformed(ActionEvent ke)
    {
      if(ke.getSource().equals(YesBut))
      {
          MainPanel.setVisible(false);
          this.ShowYesPanel();
      }
      else if(ke.getSource().equals(AgainBut))
      {
          YesPanel.setVisible(false);
          MainPanel.setVisible(true);
      }
      else if(ke.getSource().equals(ExitBut))
      {
          System.exit(0);
      }
      else if(ke.getSource() == (NoAgainBut))
      {
        NoPanel.setVisible(false);
        MainPanel.setVisible(true);
      }
      else{}
    }

    public void ShowYesPanel()
    {
      YesPanel = new JPanel();
      BackGColor = new Color(64,84,254);
      YesPanel.setBackground(BackGColor);
      YesPanel.setLayout(null);

      YesLabel = new JLabel("I Told You So");
      YesLabel.setBounds(300,200,250,100);
      YesLabel.setFont(Myfont);
      YesLabel.setForeground(new Color(255,255,255));
      YesPanel.add(YesLabel);

      AgainBut = new JButton("Again");
      AgainBut.setBounds(250,300,Length,Width);
      AgainBut.setBackground(Color.RED);
      AgainBut.addActionListener(this);
      YesPanel.add(AgainBut);

      ExitBut = new JButton("Exit");
      ExitBut.setBounds(450, 300, Length, Width);
      ExitBut.setBackground(Color.GREEN);
      ExitBut.addActionListener(this);
      YesPanel.add(ExitBut);
      this.add(YesPanel);
      YesPanel.setVisible(true);
    }

    public void ShowNoPanel()
    {
      NoPanel = new JPanel();
      BackGColor = new Color(64,184,245);
      NoPanel.setBackground(BackGColor);
      NoPanel.setLayout(null);

      NoLabel = new JLabel("Congratulations You Win");
      NoLabel.setBounds(220,200,350,100);
      NoLabel.setFont(Myfont);
      NoLabel.setForeground(new Color(255,255,255));
      NoPanel.add(NoLabel);

      NoAgainBut = new JButton("Again");
      NoAgainBut.setBounds(250,300,Length,Width);
      NoAgainBut.setBackground(Color.RED);
      NoAgainBut.addActionListener(this);
      NoPanel.add(NoAgainBut);

      ExitBut = new JButton("Exit");
      ExitBut.setBounds(450, 300, Length, Width);
      ExitBut.setBackground(Color.GREEN);
      ExitBut.addActionListener(this);
      NoPanel.add(ExitBut);
      this.add(NoPanel);
      NoPanel.setVisible(true);
    }
}
