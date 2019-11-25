
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.net.*;

public class ExemploComPass extends JPanel {
    static JFrame frame;
    static String metal= "Metal"; 
    static String metalClassName = "javax.swing.plaf.metal.MetalLookAndFeel";
    static String motif = "Motif"; 
    static String motifClassName = "com.sun.java.swing.plaf.motif.MotifLookAndFeel";
    static String windows = "Windows"; 
    static String windowsClassName = "com.sun.java.swing.plaf.windows.WindowsLookAndFeel";
    JRadioButton metalButton, motifButton, windowsButton;

    static JMenuBar mymenubar;
    static JMenu arquivo;
    static JMenuItem sair; 

    private static String labelPrefix = "Número de clicks com o botão: ";
    private int numClicks = 0;

    static ImageIcon newfig, fig, Splash;

protected boolean isValid(String a, String b){
boolean resp=false;
	if(a.equals("thiago")&&b.equals("moreira")) {
		resp=true;
	}
	return resp;
}    


//Inicio da função
    public ExemploComPass() {
	// Create the buttons.
        final JLabel label = new JLabel(labelPrefix + "0    ");
	label.setHorizontalAlignment(SwingConstants.CENTER);
	JButton button = new JButton("Oi! Pessoal!");
        button.setMnemonic('o'); //for looks only; button does nada
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                numClicks++;
                label.setText(labelPrefix + numClicks);
            }
        });
        label.setLabelFor(button);


	metalButton = new JRadioButton(metal);
        metalButton.setMnemonic('t'); 
	metalButton.setActionCommand(metalClassName);

	motifButton = new JRadioButton(motif);
        motifButton.setMnemonic('m'); 
	motifButton.setActionCommand(motifClassName);

	windowsButton = new JRadioButton(windows);
        windowsButton.setMnemonic('w'); 
	windowsButton.setActionCommand(windowsClassName);

	// Group the radio buttons.
	ButtonGroup group = new ButtonGroup();
	group.add(metalButton);
	group.add(motifButton);
	group.add(windowsButton);

        // Register a listener for the radio buttons.
	RadioListener myListener = new RadioListener();
	metalButton.addActionListener(myListener);
	motifButton.addActionListener(myListener);
	windowsButton.addActionListener(myListener);
	
        JLabel yellowLabel = new JLabel("Boa Noite!");
        yellowLabel.setOpaque(true);
        yellowLabel.setBackground(Color.magenta);
        yellowLabel.setPreferredSize(new Dimension(80, 20));
	yellowLabel.setHorizontalAlignment(SwingConstants.CENTER);

	add(new JLabel(fig), BorderLayout.CENTER);
	JLabel link = new JLabel("New",newfig,SwingConstants.CENTER);
	add(link, BorderLayout.CENTER);
//	JLabel splashLabel = new JLabel(Splash);
	add(button);
	add(metalButton);
	add(motifButton,BorderLayout.EAST);
	add(windowsButton);
	add(label);
	add(yellowLabel);
//	add(splashLabel, BorderLayout.WEST);
   JButton fLog = new JButton("Log on");
    final JLabel fStatus = new JLabel("Por favor entre com o login e a senha");
    add(fStatus);
    final JTextField fUser=new JTextField(10);
    add(fUser);
    final JPasswordField fPass=new JPasswordField(10);
    add(fPass);
fLog.addActionListener(new ActionListener(){
	public void actionPerformed(ActionEvent e){
		if(isValid(fUser.getText(),fPass.getText())){
			fStatus.setText("Oi");
		}else {
			fStatus.setText("Senha ou login errados");
		}
}});
add(fLog);

//Tipos validos de localização : NORTH-SOUTH-EAST-WEST-CENTER
    }
//Fim da função

//Inicio do RadioButton
    //An ActionListener that listens to the radio buttons.
    class RadioListener implements ActionListener { 
	public void actionPerformed(ActionEvent e) { 
	    String lnfName = e.getActionCommand(); 
            try { 
		UIManager.setLookAndFeel(lnfName);
		SwingUtilities.updateComponentTreeUI(frame); 
		frame.pack(); 
            }  
	    catch (Exception exc) {
		JRadioButton button = (JRadioButton)e.getSource(); 
		button.setEnabled(false); 
		updateState(); 
                System.err.println("Could not load LookAndFeel: " + lnfName); 
            } 	    
	} 
    }
//Fim dos RadioButton

//para troca de seleção
    public void updateState() { 
	 String lnfName = UIManager.getLookAndFeel().getClass().getName(); 
	 if (lnfName.indexOf(metal) >= 0) { 
	     metalButton.setSelected(true); 
	 } else if (lnfName.indexOf(windows) >= 0) { 
	     windowsButton.setSelected(true); 
	 } else if (lnfName.indexOf(motif) >= 0) { 
	     motifButton.setSelected(true);
	 } else { 
	     System.err.println("SimpleExample is using an unknown L&F: " + lnfName);
	 } 
    }
//fim da troca

//Principal
    public static void main(String s[]) {
	newfig = new ImageIcon("newfig.gif"); 
	fig = new ImageIcon("fig.gif"); 
	Splash = new ImageIcon("Splash.jpg"); 

	ExemploComPass panel = new ExemploComPass();
	frame = new JFrame("Programa do 3º Módulo e 4º Ano");
	frame.addWindowListener(new WindowAdapter() {
	    public void windowClosing(WindowEvent e) {
	    	if(JOptionPane.showConfirmDialog(null, "Deseja realemente encerrar o programa?") == JOptionPane.YES_OPTION){
		    	System.exit(0);}
	    	}
	});
	panel.setBackground(Color.orange);
	panel.setBorder(BorderFactory.createEmptyBorder(
                                        10, //top
                                        15, //left
                                        5, //bottom
                                        15) //right
                                        );
//Formato do GridLayout: (int rows, int cols, int hgap, int vgap)
	panel.setLayout(new GridLayout(0, 1, 2, 2));
	JLabel splashLabel = new JLabel(Splash);
//	    frame.getContentPane().add("Center",splashLabel);
//	    frame.getContentPane().validate();
//	    frame.getContentPane().repaint();
	
	frame.getContentPane().add("Center", panel);

	arquivo = new JMenu("Arquivo");
        arquivo.setMnemonic('a'); 
	sair = arquivo.add(new JMenuItem("Sair"));
	sair.addActionListener(new ActionListener() {
	    public void actionPerformed(ActionEvent e) {
		System.exit(0);
	    }});

	mymenubar = new JMenuBar();
	mymenubar.add(arquivo);
//Adendos do Menu
//	mymenubar.setOpaque(true);
//	mymenubar.setBackground(Color.cyan);
//	mymenubar.setPreferredSize(new Dimension(300, 20));


	frame.setJMenuBar(mymenubar);

//Adendos para o frame
//frame.setClosable(true); 
//frame.setMaximizable(false); 
//frame.setIconifiable(true); 
//frame.setResizable(false); 
frame.setBounds(40, 40, 160, 160); 

	frame.pack();
	frame.setVisible(true);
	panel.updateState();
    } 
 //fim Principal

}