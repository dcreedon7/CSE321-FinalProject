import java.util.ArrayList;	
import java.util.Random;
import javax.swing.JCheckBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Miami CSE321 Group
 */
public class MainGui extends javax.swing.JFrame {
    
	private GameLogic logic;
	private ArrayList<Dice> diceList;
    private int rollCount = 0;
    private int round = 1;
    private int sumAbove = 0;
    private int yahtzeeCount = 0;
    
    public MainGui() {
        initComponents();
    }
    
    public void rollDice() {
        if (rollCount >= 3) {
            rollDice.setText("Select Score");
            return;
        }

        if (round == 14) {
            rollDice.setText("New Game?");
            round++;
            return;
        }

        if (round >= 15) { // reset game
            resetGame();
            return;
        }

        if (rollCount == 0) { // uncheck dice so they can be rolled
            uncheckDice();
            setRollable(true);
        }

        rollAllDice();

        // set the dice values
        setDiceValues();

        rollCount++;
        rollText.setText("Roll: " + rollCount);

        // update potential scores in the table
        updateTable();
    }

    private void uncheckDice() {
        jCheckBox1.setSelected(false);
        jCheckBox2.setSelected(false);
        jCheckBox3.setSelected(false);
        jCheckBox4.setSelected(false);
        jCheckBox5.setSelected(false);
    }

    private void setRollable(boolean rollable) {
        for (Dice d : diceList) {
            d.setRollable(rollable);
        }
    }

    private void rollAllDice() {
        for (Dice d : diceList) {
            d.roll();
        }
    }

    private void setDiceValues() {
        diceOne.setText("" + diceList.get(0).getValue());
        diceTwo.setText("" + diceList.get(1).getValue());
        diceThree.setText("" + diceList.get(2).getValue());
        diceFour.setText("" + diceList.get(3).getValue());
        diceFive.setText("" + diceList.get(4).getValue());
    }

    private void updateTable() {
        sTable.setValueAt(logic.calculateScoreForCategory("Ones", diceList), 0, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Twos", diceList), 1, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Threes", diceList), 2, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Fours", diceList), 3, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Fives", diceList), 4, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Sixes", diceList), 5, 2);

        sTable.setValueAt(logic.calculateScoreForCategory("Three of a Kind", diceList), 8, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Four of a Kind", diceList), 9, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Full House", diceList), 10, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Small Straight", diceList), 11, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Large Straight", diceList), 12, 2);
        sTable.setValueAt(logic.calculateScoreForCategory("Chance", diceList), 13, 2);
        
        int yah = logic.calculateScoreForCategory("Yahtzee", diceList);
        if (yah > 0) {
        	yahtzeeCount++;
        	if (yahtzeeCount > 1) {
        		int bonus = Integer.parseInt("" + sTable.getValueAt(7, 1)) + 100;
        		sTable.setValueAt(bonus, 7, 1);
        	}
        }
        sTable.setValueAt(yah, 14, 2);
        
    }

    private void resetGame() {
    	sTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {
                    {"Ones", null, null},
                    {"Twos", null, null},
                    {"Threes", null, null},
                    {"Fours", null, null},
                    {"Fives", null, null},
                    {"Sixes", null, null},
                    {"Sum", null, null},
                    {"Bonus", "", null},
                    {"Three of a Kind", null, null},
                    {"Four of a Kind", null, null},
                    {"Full House", null, null},
                    {"Small Straight", null, null},
                    {"Large Straight", null, null},
                    {"Chance", null, null},
                    {"Yahtzee", null, null},
                    {"TOTAL SCORE", "", null}
                },
                new String [] {
                    "Score Type:", "My Picks", "Potential"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
    	
	    	// reset all counts back to 0
			rollCount = 0;
		    round = 1;
		    sumAbove = 0;
		    yahtzeeCount = 0;
		    
		    // reset all text to original
		    rollDice.setText("Roll Dice");
		    roundText.setText("Round: 1");
		    rollText.setText("Roll: 0");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {
    	diceList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            diceList.add(new Dice());
        }
        
        jCheckBox1 = new javax.swing.JCheckBox();
        jCheckBox2 = new javax.swing.JCheckBox();
        jCheckBox3 = new javax.swing.JCheckBox();
        jCheckBox4 = new javax.swing.JCheckBox();
        jCheckBox5 = new javax.swing.JCheckBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        sTable = new javax.swing.JTable();
        rollDice = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextPane1 = new javax.swing.JTextPane();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        diceOne = new javax.swing.JButton();
        diceTwo = new javax.swing.JButton();
        diceThree = new javax.swing.JButton();
        diceFour = new javax.swing.JButton();
        diceFive = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        roundText = new javax.swing.JTextPane();
        jScrollPane4 = new javax.swing.JScrollPane();
        rollText = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jCheckBox1.setText("Dice 1");
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JCheckBox checkBox = (JCheckBox) evt.getSource();
                if (checkBox.isSelected()) {
                	diceList.get(0).setRollable(false);
                } else {
                	diceList.get(0).setRollable(true);
                }
            }
        });
        
        jCheckBox2.setText("Dice 2");
        jCheckBox2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JCheckBox checkBox = (JCheckBox) evt.getSource();
                if (checkBox.isSelected()) {
                	diceList.get(1).setRollable(false);
                } else {
                	diceList.get(1).setRollable(true);
                }
            }
        });

        jCheckBox3.setText("Dice 3");
        jCheckBox3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JCheckBox checkBox = (JCheckBox) evt.getSource();
                if (checkBox.isSelected()) {
                	diceList.get(2).setRollable(false);
                } else {
                	diceList.get(2).setRollable(true);
                }
            }
        });

        jCheckBox4.setText("Dice 4");
        jCheckBox4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JCheckBox checkBox = (JCheckBox) evt.getSource();
                if (checkBox.isSelected()) {
                	diceList.get(3).setRollable(false);
                } else {
                	diceList.get(3).setRollable(true);
                }
            }
        });

        jCheckBox5.setText("Dice 5");
        jCheckBox5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	JCheckBox checkBox = (JCheckBox) evt.getSource();
                if (checkBox.isSelected()) {
                	diceList.get(4).setRollable(false);
                } else {
                	diceList.get(4).setRollable(true);
                }
            }
        });

        sTable.setModel(new javax.swing.table.DefaultTableModel( // creates a 3 x 15 table
                new Object [][] {
                    {"Ones", null, null},
                    {"Twos", null, null},
                    {"Threes", null, null},
                    {"Fours", null, null},
                    {"Fives", null, null},
                    {"Sixes", null, null},
                    {"Sum", null, null},
                    {"Bonus", "", null},
                    {"Three of a Kind", null, null},
                    {"Four of a Kind", null, null},
                    {"Full House", null, null},
                    {"Small Straight", null, null},
                    {"Large Straight", null, null},
                    {"Chance", null, null},
                    {"Yahtzee", null, null},
                    {"TOTAL SCORE", "", null}
                },
                new String [] {
                    "Score Type:", "My Picks", "Potential"
                }
            ) {
                boolean[] canEdit = new boolean [] {
                    false, false, false
                };

                public boolean isCellEditable(int rowIndex, int columnIndex) {
                    return canEdit [columnIndex];
                }
            });
        sTable.setShowGrid(true);
        jScrollPane1.setViewportView(sTable);
        
      //Add mouse listener to table
        sTable.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseClicked(java.awt.event.MouseEvent evt) {
		        int row = sTable.rowAtPoint(evt.getPoint());
		        // int col = sTable.columnAtPoint(evt.getPoint());
		        if (sTable.getValueAt(row, 1) == null) { // if column 1 is null when clicked then check column 2
		        	
		        	// resets table
		        	if (sTable.getValueAt(row, 2) != null) { // if column 2 is not null then add value to column 1
		        		sTable.setValueAt(sTable.getValueAt(row, 2), row, 1); // sets the value of column 1 in selected row
		        		rollCount = 0;
		        		rollText.setText("Roll: 0");
		        		round++;
		        		roundText.setText("Round: " + round);
		        		rollDice.setText("Roll Dice");
		        		for (int i = 0; i < 16; i++) { // sets all of 2 back to null after user selects
		        			sTable.setValueAt(null, i, 2);
		        		}
		        		
		        		// calculate the sum category
		        		sumAbove = 0;
		        		for (int i = 0; i < 6; i++) {
		        			
		        			if (sTable.getValueAt(i, 1) != null) {
		        				sumAbove += Integer.parseInt("" + sTable.getValueAt(i, 1));
		        			}
		        		}
		        		sTable.setValueAt(sumAbove, 6, 1);
		        		
		        		// calculate bonus category
		        		if (Integer.parseInt("" + sTable.getValueAt(6, 1)) > 63) { // if the sum category is > 63
		        			String val = "35";
		        			if (yahtzeeCount > 1) {
		        				val = "" + 100 * (yahtzeeCount - 1) + 35;
		        			}
		        			sTable.setValueAt(val, 7, 1);
		        		} else { // if the sum category is not greater than 63
		        			String val = "0";
		        			if (yahtzeeCount > 1) {
		        				val = "" + 100 * (yahtzeeCount - 1);
		        			}
		        			sTable.setValueAt(val, 7, 1);
		        		}
		        		
		        		// calculate total score of game at round 14 (game over)
		        		int total = 0;
		        		if (round == 14) {
		        			for (int i = 6; i < 15; i++) {
		        				total += Integer.parseInt("" + sTable.getValueAt(i, 1));
		        			}
		        			sTable.setValueAt(total, 15, 1);
		        			rollDice.setText("Continue...");
		        		}
		        		
		        	}
		            
		            sTable.setEnabled(false); // Disable the sTable so that the value can't be changed again
		        }
		    }
		});

        rollDice.setText("Roll Dice");
        
        // Roll Dice Button
        rollDice.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
            	rollDice();
            }
        });

        jTextPane1.setEditable(false);
        jTextPane1.setText("Select which dice you want to keep (You can reroll up to 3 times):");
        jScrollPane2.setViewportView(jTextPane1);

        jLabel1.setText("Dice 1");

        jLabel2.setText("Dice 2");

        jLabel3.setText("Dice 3");

        jLabel4.setText("Dice 4");

        jLabel5.setText("Dice 5");
        jLabel5.setToolTipText("");

        diceOne.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        diceOne.setText("" + diceList.get(0).getValue());
        diceOne.setEnabled(false);

        diceTwo.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        diceTwo.setText("" + diceList.get(1).getValue());
        diceTwo.setEnabled(false);

        diceThree.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        diceThree.setText("" + diceList.get(2).getValue());
        diceThree.setEnabled(false);

        diceFour.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        diceFour.setText("" + diceList.get(3).getValue());
        diceFour.setEnabled(false);

        diceFive.setFont(new java.awt.Font("Segoe UI", 1, 48)); // NOI18N
        diceFive.setText("" + diceList.get(4).getValue());
        diceFive.setEnabled(false);

        roundText.setEditable(false);
        roundText.setText("Round: 1");
        jScrollPane3.setViewportView(roundText);

        rollText.setEditable(false);
        rollText.setText("Roll: 0");
        jScrollPane4.setViewportView(rollText);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jCheckBox1)
                                .addGap(28, 28, 28)
                                .addComponent(jCheckBox2)
                                .addGap(39, 39, 39)
                                .addComponent(jCheckBox3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jCheckBox4)
                                .addGap(27, 27, 27)
                                .addComponent(jCheckBox5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(diceOne, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(9, 9, 9)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(diceTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(diceThree, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(diceFour, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(diceFive, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(6, 6, 6)))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(44, 44, 44)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(45, 45, 45)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(rollDice, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(160, 160, 160)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(diceOne, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diceTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diceThree, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diceFour, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(diceFive, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel5))
                .addGap(79, 79, 79)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jCheckBox1)
                    .addComponent(jCheckBox2)
                    .addComponent(jCheckBox3)
                    .addComponent(jCheckBox4)
                    .addComponent(jCheckBox5))
                .addGap(18, 18, 18)
                .addComponent(rollDice, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(21, 21, 21))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 469, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>                                    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
        	ex.printStackTrace();
            // java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
        	ex.printStackTrace();
        	//java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
        	ex.printStackTrace();
        	//java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        	ex.printStackTrace();
        	//java.util.logging.Logger.getLogger(Yahtzee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainGui gui = new MainGui();
                gui.setResizable(false); // disable resizing
                gui.setVisible(true);
            }
        });

    }
    
    // when a user clicks a the button, this method runs the operations for "correctness"
    public static void buttonOperations() {
    	
    }
    
    // when a user clicks a table this method runs the operations for "correctness"
    public static void tableOperations() {
    	
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton rollDice;
    private javax.swing.JButton diceOne;
    private javax.swing.JButton diceTwo;
    private javax.swing.JButton diceThree;
    private javax.swing.JButton diceFour;
    private javax.swing.JButton diceFive;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JCheckBox jCheckBox2;
    private javax.swing.JCheckBox jCheckBox3;
    private javax.swing.JCheckBox jCheckBox4;
    private javax.swing.JCheckBox jCheckBox5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable sTable;
    private javax.swing.JTextPane jTextPane1;
    private javax.swing.JTextPane roundText;
    private javax.swing.JTextPane rollText;
    // End of variables declaration                   

    public Object[][] getTableData() {
        DefaultTableModel model = (DefaultTableModel) sTable.getModel();
        int rows = model.getRowCount();
        int cols = model.getColumnCount();
        Object[][] data = new Object[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                data[i][j] = model.getValueAt(i, j);
            }
        }
        return data;
    }

	public void setsTable(javax.swing.JTable sTable) {
		this.sTable = sTable;
	}

	public String getRollText() {
		return rollText.getText();
	}

	public void setRollText(javax.swing.JTextPane rollText) {
		this.rollText = rollText;
	}

	public GameLogic getLogic() {
		return logic;
	}

	public void setLogic(GameLogic logic) {
		this.logic = logic;
	}

	public ArrayList<Dice> getDiceList() {
		return diceList;
	}

	public void setDiceList(ArrayList<Dice> diceList) {
		this.diceList = diceList;
	}

	public int getRollCount() {
		return rollCount;
	}

	public void setRollCount(int rollCount) {
		this.rollCount = rollCount;
	}

	public int getRound() {
		return round;
	}

	public void setRound(int round) {
		this.round = round;
	}

	public int getSumAbove() {
		return sumAbove;
	}

	public void setSumAbove(int sumAbove) {
		this.sumAbove = sumAbove;
	}

	public int getYahtzeeCount() {
		return yahtzeeCount;
	}

	public void setYahtzeeCount(int yahtzeeCount) {
		this.yahtzeeCount = yahtzeeCount;
	}
}
