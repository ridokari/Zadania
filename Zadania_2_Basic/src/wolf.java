

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

public class wolf extends javax.swing.JFrame {

	boolean boatleft = true;
	int cabbage = 1;
	int wolf = 1;
	int sheep = 1;
	int wincon = 1;

	// checking if at any point of the game player either won or lost
	public void winConCheck() {
		if (boatleft == true) {
			if (wolf == 3 && sheep == 3) {
				wincon = 0;
			} else if (sheep == 3 && cabbage == 3) {
				wincon = 0;
			}
		} else {
			if (wolf == 1 && sheep == 1) {
				wincon = 0;
			} else if (sheep == 1 && cabbage == 1) {
				wincon = 0;
			} else if (sheep == 3 && wolf == 3 && cabbage == 3) {
				wincon = 2;
			}
		}
		if (wincon == 0) {
			JOptionPane.showMessageDialog(null,"You lost");
		    System.exit(0);
	//preferably i would like to restart the game but had no idea how to do that.
		} else if (wincon == 2) {
			JOptionPane.showMessageDialog(null,"You won!");
		    System.exit(0);
		
		}
	}
// image loaders for boat cargo
	public void settingimage2(File file1) {
		try {
			BufferedImage lcargo = ImageIO.read(file1);
			jLabel8.setIcon(new ImageIcon(lcargo));
			jLabel8.setVisible(true);
			jLabel10.setVisible(false);
		} catch (IOException e) {
		}
	}

	public void settingimage1(File file1) {
		try {
			BufferedImage lcargo = ImageIO.read(file1);
			jLabel10.setIcon(new ImageIcon(lcargo));
			jLabel10.setVisible(true);
			jLabel8.setVisible(false);
		} catch (IOException e) {
		}
	}

	public void settinglcargo(File file2) {
		try {
			BufferedImage lcargo = ImageIO.read(file2);
			jLabel8.setIcon(new ImageIcon(lcargo));
			jLabel8.setVisible(true);
		} catch (IOException e) {
		}
	}

	public void settingrcargo(File file2) {
		try {
			BufferedImage lcargo = ImageIO.read(file2);
			jLabel10.setIcon(new ImageIcon(lcargo));
			jLabel10.setVisible(true);
		} catch (IOException e) {
		}
	}

	public wolf() throws IOException {
		initComponents();
	}

	private void initComponents() throws IOException {
		File file1 = new File("C:\\Users\\kujap\\Desktop\\wolf\\wolf.jpg");
		BufferedImage image1 = ImageIO.read(file1);
		File file2 = new File("C:\\Users\\kujap\\Desktop\\wolf\\sheep.jpg");
		BufferedImage image2 = ImageIO.read(file2);
		File file3 = new File("C:\\Users\\kujap\\Desktop\\wolf\\cabbage.jpg");
		BufferedImage image3 = ImageIO.read(file3);
		File file4 = new File("C:\\Users\\kujap\\Desktop\\wolf\\boat.jpg");
		BufferedImage image4 = ImageIO.read(file4);

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();
		jLabel5 = new javax.swing.JLabel(new ImageIcon(image2));
		jLabel6 = new javax.swing.JLabel(new ImageIcon(image1));
		jLabel7 = new javax.swing.JLabel(new ImageIcon(image3));
		jLabel8 = new javax.swing.JLabel();
		jLabel8.setVisible(false);
		jLabel9 = new javax.swing.JLabel(new ImageIcon(image4));
		jLabel10 = new javax.swing.JLabel();
		jLabel10.setVisible(false);
		jLabel11 = new javax.swing.JLabel(new ImageIcon(image4));
		jLabel11.setVisible(false);
		jLabel12 = new javax.swing.JLabel(new ImageIcon(image2));
		jLabel12.setVisible(false);
		jLabel13 = new javax.swing.JLabel(new ImageIcon(image1));
		jLabel13.setVisible(false);
		jLabel14 = new javax.swing.JLabel(new ImageIcon(image3));
		jLabel14.setVisible(false);
		jLabel15 = new javax.swing.JLabel();
		jLabel16 = new javax.swing.JLabel();
		jLabel17 = new javax.swing.JLabel();
		jLabel18 = new javax.swing.JLabel();
		jLabel19 = new javax.swing.JLabel();
		jLabel20 = new javax.swing.JLabel();
		jLabel21 = new javax.swing.JLabel();
		jLabel22 = new javax.swing.JLabel();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new java.awt.Dimension(900, 600));

		jButton1.setText("GO");
		jButton1.setPreferredSize(new java.awt.Dimension(80, 20));
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {

				if (boatleft == true) {
					jLabel9.setVisible(false);
					jLabel11.setVisible(true);
					if (wolf == 2) {
						settingimage1(file1);
					} else if (sheep == 2) {
						settingimage1(file2);
					} else if (cabbage == 2) {
						settingimage1(file3);
					}
					boatleft = false;
					winConCheck();
				} else {
					jLabel9.setVisible(true);
					jLabel11.setVisible(false);

					if (wolf == 2) {
						settingimage2(file1);
					} else if (sheep == 2) {
						settingimage2(file2);
					} else if (cabbage == 2) {
						settingimage2(file3);
					}

					boatleft = true;
					winConCheck();
				}
			}

		});

		jButton2.setText("Sheep");
		jButton2.setPreferredSize(new java.awt.Dimension(80, 20));
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				// jLabel5.setIcon((Icon) image4);

				if (boatleft == true) {
					if (sheep == 1 && wolf != 2 && cabbage != 2) {
						sheep = 2;
						jLabel5.setVisible(false);
						settinglcargo(file2);
					} else if (sheep == 2) {
						sheep = 1;
						jLabel5.setVisible(true);
						jLabel8.setVisible(false);
					}
				}

				else {
					if (sheep == 3 && wolf != 2 && cabbage != 2) {
						sheep = 2;
						jLabel12.setVisible(false);
						settingrcargo(file2);

					} else if (sheep == 2) {
						sheep = 3;
						jLabel12.setVisible(true);
						jLabel10.setVisible(false);

						winConCheck();

					}
				}

			}

		});

		jButton3.setText("Cabbage");
		jButton3.setPreferredSize(new java.awt.Dimension(80, 20));
		jButton3.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (boatleft == true) {
					if (cabbage == 1 && wolf != 2 && sheep != 2) {
						cabbage = 2;
						jLabel7.setVisible(false);
						settinglcargo(file3);
					} else if (cabbage == 2) {
						cabbage = 1;
						jLabel7.setVisible(true);
						jLabel8.setVisible(false);

					}
				} else {
					if (cabbage == 3 && wolf != 2 && sheep != 2) {
						cabbage = 2;
						jLabel14.setVisible(false);
						settingrcargo(file3);
					} else if (cabbage == 2) {
						cabbage = 3;
						jLabel14.setVisible(true);
						jLabel10.setVisible(false);

						winConCheck();
					}
				}

			}
		});

		jButton4.setText("Wolf");
		jButton4.setPreferredSize(new java.awt.Dimension(80, 20));
		jButton4.addActionListener(new java.awt.event.ActionListener() {

			public void actionPerformed(java.awt.event.ActionEvent evt) {
				if (boatleft == true) {
					if (wolf == 1 && sheep != 2 && cabbage != 2) {
						wolf = 2;
						jLabel6.setVisible(false);
						settinglcargo(file1);
					} else if (wolf == 2) {
						wolf = 1;
						jLabel6.setVisible(true);
						jLabel8.setVisible(false);

					}
				} else {
					if (wolf == 3 && sheep != 2 && cabbage != 2) {
						wolf = 2;
						jLabel13.setVisible(false);
						settingrcargo(file1);
					} else if (wolf == 2) {
						wolf = 3;
						jLabel13.setVisible(true);
						jLabel10.setVisible(false);

						winConCheck();
					}
				}

			}
		});

		jLabel5.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel6.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel7.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel8.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel9.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel10.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel11.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel12.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel13.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel14.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel15.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel16.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel17.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel18.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel19.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel20.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel21.setPreferredSize(new java.awt.Dimension(100, 120));
		jLabel22.setPreferredSize(new java.awt.Dimension(100, 120));

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addContainerGap()
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 319,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
				.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED).addComponent(jLabel14,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup()
								.addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel20, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
				.addContainerGap(20, Short.MAX_VALUE))
				.addGroup(layout.createSequentialGroup().addGroup(layout
						.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(17, 17, 17)
								.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addGap(430, 430, 430)
								.addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGroup(layout.createSequentialGroup().addContainerGap()
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGap(0, 0, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(43, 43, 43)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
										javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(
								javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
												javax.swing.GroupLayout.PREFERRED_SIZE))
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
										.addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)
										.addComponent(
												jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE,
												javax.swing.GroupLayout.DEFAULT_SIZE,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
								.createSequentialGroup()
								.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 16,
												javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addGap(35, 35, 35).addComponent(jLabel20,
										javax.swing.GroupLayout.PREFERRED_SIZE, 16,
										javax.swing.GroupLayout.PREFERRED_SIZE)))
						.addContainerGap(235, Short.MAX_VALUE)));

		pack();
	}

	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(wolf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(wolf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(wolf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(wolf.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					new wolf().setVisible(true);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
	}

	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel jLabel10;
	private javax.swing.JLabel jLabel11;
	private javax.swing.JLabel jLabel12;
	private javax.swing.JLabel jLabel13;
	private javax.swing.JLabel jLabel14;
	private javax.swing.JLabel jLabel5;
	private javax.swing.JLabel jLabel6;
	private javax.swing.JLabel jLabel7;
	private javax.swing.JLabel jLabel8;
	private javax.swing.JLabel jLabel9;
	private javax.swing.JLabel jLabel16;
	private javax.swing.JLabel jLabel17;
	private javax.swing.JLabel jLabel18;
	private javax.swing.JLabel jLabel19;
	private javax.swing.JLabel jLabel20;
	private javax.swing.JLabel jLabel21;
	private javax.swing.JLabel jLabel22;
	private javax.swing.JLabel jLabel15;

}
