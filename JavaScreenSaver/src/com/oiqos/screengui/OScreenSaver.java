package com.oiqos.screengui;

import java.applet.Applet;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.io.File;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import java.awt.event.KeyAdapter;
import java.awt.Color;

public class OScreenSaver extends Applet {

	private static final long serialVersionUID = 1L;
	private JFrame frame;
	private JFileChooser fileChooser;
	private File gifFile;
	private String gifFileName;
	Dimension dim;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OScreenSaver window = new OScreenSaver();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public OScreenSaver() {
		initialize();
		gifFileName = findFile();
		Icon icon = new ImageIcon(gifFileName);
        label = new JLabel();
        label.setBackground(Color.BLACK);
        label.setSize(dim);
		label.setIcon(icon);
        frame.getContentPane().add(label);
	}
	
	private String findFile() {
		fileChooser = new JFileChooser();
		fileChooser.setDialogTitle("Choose GIF image for screensaver.");
		int jfcoption = fileChooser.showOpenDialog(frame);
		if(jfcoption != JFileChooser.APPROVE_OPTION){
			JOptionPane.showMessageDialog(frame,"Thanks for using OScreenSaver");
			System.exit(0);
		} else {
			gifFile = fileChooser.getSelectedFile();
		}
		String fileName = gifFile.getAbsolutePath();
		while(!fileName.endsWith("gif") && !fileName.endsWith("GIF") ){
			JOptionPane.showMessageDialog(frame, "Select an GIF file.");
			jfcoption = fileChooser.showOpenDialog(frame);
			if(jfcoption != JFileChooser.APPROVE_OPTION){
				JOptionPane.showMessageDialog(frame,"Thanks for using OScreenSaver");
				System.exit(0);
			} else {
				gifFile = fileChooser.getSelectedFile();
				fileName = gifFile.getAbsolutePath();
			}
		}
		return fileName;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.BLACK);
		frame.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					JOptionPane.showMessageDialog(frame,"Thanks for using OScreenSaver");
					System.exit(0);
				}
			}
		});
		frame.setBounds(100, 100, 450, 300);
		frame.setLocation(0, 0);
		frame.setUndecorated(true);
		frame.setAlwaysOnTop(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Toolkit toolkit =  Toolkit.getDefaultToolkit ();
		dim = toolkit.getScreenSize();
		frame.setSize(dim.width,dim.height);	
		frame.getContentPane().setFocusable(true);
		frame.setFocusable(true);
	}
}
