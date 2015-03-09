package yoo.app.views;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EmptyBorder;

import me.bbcode.BBcode;
import me.bbcode.BBcodeFactory;
import yoo.app.util.ColorPick;

public class YooFormatter extends JFrame {

	/**
	 * ID de serialização
	 */
	private static final long serialVersionUID = 4459971546283693130L;

	private JPanel contentPane;

	/* Botões */
	private JLabel btnFechar;
	private JLabel btnMinimizar;
	private JLabel Logo;
	private JTextArea txtMensagem;

	int posX = 0, posY = 0;
	private JButton bbcodeB;
	private JButton bbcode_COLOR;
	private JButton bbcode_CENTER;
	private JButton bbcode_SIZE;
	private JButton btnCopiar;
	private JButton btnSalvar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					YooFormatter frame = new YooFormatter();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	/**
	 * ColorPick.instance().selectColor(null, "Testando");
	 * System.out.println(ColorPick.instance().getSelectedHexColor());
	 */
	public YooFormatter() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 771, 374);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 191, 255));
		contentPane.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent event) {

				setLocation(event.getXOnScreen() - posX, event.getYOnScreen()
						- posY);
			}
		});
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent event) {

				posX = event.getX();
				posY = event.getY();
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);

		// Botao fechar
		btnFechar = new JLabel();
		btnFechar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent arg0) {

				// fechando
				System.out.println("YooFormatter fechado.");
				try {
					Thread.sleep(50);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				System.exit(0);
			}
		});
		btnFechar.setIcon(new ImageIcon(YooFormatter.class
				.getResource("/fechar.png")));
		btnFechar.setBounds(748, 5, 16, 16);// 618
		contentPane.add(btnFechar);

		// Botao minimizar
		btnMinimizar = new JLabel();
		btnMinimizar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {

				System.out.println("YooFormatter minimizado.");
				setState(JFrame.ICONIFIED);
			}
		});
		btnMinimizar.setIcon(new ImageIcon(YooFormatter.class
				.getResource("/minimizar.png")));
		btnMinimizar.setBounds(728, 5, 16, 16);
		contentPane.add(btnMinimizar);

		Logo = new JLabel();
		Logo.setIcon(new ImageIcon(YooFormatter.class.getResource("/logo.png")));
		Logo.setBounds(205, 10, 352, 66);
		contentPane.add(Logo);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(51, 102, 204));
		panel.setBounds(10, 76, 607, 82);
		contentPane.add(panel);
		panel.setLayout(null);

		bbcodeB = new JButton("B");
		bbcodeB.setForeground(Color.BLACK);
		bbcodeB.setBackground(Color.WHITE);
		bbcodeB.setBorder(null);
		bbcodeB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtMensagem.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null,
							"Nada foi selecionado!", "ERRO",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				BBcode myBBcode = BBcodeFactory.instance();
				String bbcode = myBBcode.code("B")
						.content(txtMensagem.getSelectedText()).create();
				txtMensagem.replaceSelection(bbcode);
			}
		});
		bbcodeB.setBounds(10, 11, 57, 23);
		panel.add(bbcodeB);

		bbcode_COLOR = new JButton("COLOR");
		bbcode_COLOR.setBorder(null);
		bbcode_COLOR.setBackground(Color.WHITE);
		bbcode_COLOR.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtMensagem.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null,
							"Nada foi selecionado!", "ERRO",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				ColorPick color = ColorPick.instance();
				color.selectColor(null, "Selecione a cor do texto");
				BBcode myBBcode = BBcodeFactory.instance();
				String bbcode = myBBcode.code("COLOR")
						.value(color.getSelectedHexColor())
						.content(txtMensagem.getSelectedText()).create();
				txtMensagem.replaceSelection(bbcode);
			}
		});
		bbcode_COLOR.setBounds(77, 11, 76, 23);
		panel.add(bbcode_COLOR);

		bbcode_CENTER = new JButton("CENTER");
		bbcode_CENTER.setBackground(Color.WHITE);
		bbcode_CENTER.setBorder(null);
		bbcode_CENTER.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (txtMensagem.getSelectedText() == null) {
					JOptionPane.showMessageDialog(null,
							"Nada foi selecionado!", "ERRO",
							JOptionPane.ERROR_MESSAGE);
					return;
				}

				BBcode myBBcode = BBcodeFactory.instance();
				String bbcode = myBBcode.code("CENTER")
						.content(txtMensagem.getSelectedText()).create();
				txtMensagem.replaceSelection(bbcode);
			}
		});
		bbcode_CENTER.setBounds(163, 11, 91, 23);
		panel.add(bbcode_CENTER);

		bbcode_SIZE = new JButton("SIZE");
		bbcode_SIZE.setBorder(null);
		bbcode_SIZE.setBackground(Color.WHITE);
		bbcode_SIZE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String tamanho;
				if (txtMensagem.getSelectedText() != null) {
					tamanho = JOptionPane.showInputDialog(null,
							"Por favor, coloque o tamanho da letra");
					if (tamanho == null || tamanho.equals("")) {
						JOptionPane.showMessageDialog(null,
								"Nenhum valor foi atribuido.", "ERRO",
								JOptionPane.ERROR_MESSAGE);
						return;
					}

				} else {
					JOptionPane.showMessageDialog(null,
							"Nada foi selecionado!", "ERRO",
							JOptionPane.ERROR_MESSAGE);
					return;
				}
				BBcode myBBcode = BBcodeFactory.instance();
				String bbcode = myBBcode.code("SIZE").value(tamanho)
						.content(txtMensagem.getSelectedText()).create();
				txtMensagem.replaceSelection(bbcode);
			}
		});
		bbcode_SIZE.setBounds(265, 11, 82, 23);
		panel.add(bbcode_SIZE);

		txtMensagem = new JTextArea();
		txtMensagem.setFont(new Font("Consolas", Font.PLAIN, 17));
		txtMensagem.setBounds(10, 170, 754, 193);
		contentPane.add(txtMensagem);

		btnCopiar = new JButton("COPIAR TUDO");
		btnCopiar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				StringSelection stringSelection = new StringSelection(
						txtMensagem.getText());
				Clipboard clpbrd = Toolkit.getDefaultToolkit()
						.getSystemClipboard();
				clpbrd.setContents(stringSelection, null);

			}
		});
		btnCopiar.setBackground(Color.LIGHT_GRAY);
		btnCopiar.setBorder(null);
		btnCopiar.setFont(new Font("Consolas", Font.PLAIN, 13));
		btnCopiar.setBounds(626, 76, 138, 35);
		contentPane.add(btnCopiar);

		btnSalvar = new JButton("SALVAR");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String data = new SimpleDateFormat("[dd-MM-yyyy - HH.mm]")
						.format(new Date());
				// Em um arquivo
				BufferedWriter writer;
				try {
					// Em vez de Post_, poderia ser o Titulo do tópico.. tipo:
					// txtTitulo.getText()
					writer = new BufferedWriter(new FileWriter("Post_" + data
							+ ".txt", false));
					txtMensagem.write(writer);
					writer.close();
					JOptionPane.showMessageDialog(null, "Postagem salva!",
							"Arquivo gerado", JOptionPane.INFORMATION_MESSAGE);

				} catch (IOException evt) {
					JOptionPane.showMessageDialog(null, "Um erro ocorreu");
					evt.printStackTrace();
				}
			}
		});
		btnSalvar.setBackground(Color.LIGHT_GRAY);
		btnSalvar.setBorder(null);
		btnSalvar.setBounds(627, 123, 138, 35);
		contentPane.add(btnSalvar);

	}
}
