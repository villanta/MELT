/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Viewer;

import Model.Modeller;
import Model.QuestionPaper;
import Model.Section;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextArea;

/**
 *
 * @author mbaxkmt6
 */
public class TestSection extends JPanel{
    public JFrame mainFrame;
    public Modeller model;
    private JLabel title_label;
    private JLabel description_label;
    private JLabel instruction_label;
    private JTextArea title;
    private JTextArea description;
    private JTextArea instruction;
    private JTabbedPane subsections;
    public Section section;
    public TestSection(JFrame frame,Modeller model,QuestionPaper paper,ArrayList<TestSection> sectionList){
        this.model = model;
        mainFrame = frame;
        section = new Section();
        sectionList.add(this);
        paper.AddSection(section);
        initComponents();
    }

    
    private void initComponents() {
        setLayout(new GridBagLayout());
        GridBagConstraints con = new GridBagConstraints();
        
        con.gridx = 0;
        con.gridy = 0;
        con.weightx = 0.3;
        con.anchor = GridBagConstraints.NORTHWEST;
        title_label = new JLabel("title:  ");
        add(title_label,con);
        con.gridx = 1;
        con.weightx = 0.7;
        con.insets = new Insets(10,0,10,0);
        title = new JTextArea(1,10);
        add(title, con);
        
        description_label = new JLabel("description:  ");
        con.gridx = 0;
        con.gridy = 1;
        con.weightx = 0.3;
        add(description_label,con);
        con.gridx = 1;
        con.weightx = 0.7;
        description = new JTextArea(1,10);
        add(description, con);
        
        instruction_label = new JLabel("instruction:  ");
        con.gridx = 0;
        con.gridy = 2;
        con.weighty = 0;
        con.weightx = 0.3;
        add(instruction_label,con);
        con.gridx = 1;
        con.weightx = 0.7;
        instruction = new JTextArea(1,10);
        add(instruction, con);
        
        subsections = new JTabbedPane();
        con.gridx = 0;
        con.weighty = 1.0;
        con.gridy = 3;
        con.weightx = 1.0;
        con.fill = GridBagConstraints.BOTH;
        con.gridwidth = GridBagConstraints.REMAINDER;
        JPanel subsection1 = new Subsection(section);
        subsection1.setPreferredSize(new Dimension(200,200));
        subsections.addTab("subsection1",subsection1);
        add(subsections,con);
        
        JButton addSubsection = new JButton("Add Subsection");
        
        addSubsection.addActionListener(new java.awt.event.ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JPanel subsection = new Subsection(section);
                subsections.addTab("subsection2",subsection );
                subsections.revalidate();
            }
        });
        con.gridy = 4;
        con.weighty = 0;
        add(addSubsection,con);
    }
    
    public String getTitle(){
        return this.title.getText();
    }

    public String getDescription() {
        return this.description.getText();
    }
    
    public String getInstruction(){
        return this.instruction.getText();
    }
}
