/**
 * 
 */
package series;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/**
 * @author kise
 *
 */
public class Mzazi extends JFrame implements ActionListener {
	
	JMenuBar bar;
	JMenu mnuMembers, mnuBooks, mnuIssue, mnuPayment, mnuStudent, mnuNonStudent;
	JMenuItem miNew, miListAll, miEdit, miSearch, 
	memberNew, memberListAll, memberEdit, memberSearch,
	nonNew, nonListAll, nonEdit, nonSearch;
	
	JDesktopPane pane;

	public Mzazi() {
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		setSize(d);
		
		pane = new JDesktopPane();
		
		bar = new JMenuBar();
		
		mnuMembers = new JMenu("Members");	
		
		mnuStudent = new JMenu("Student");
		
		memberNew = new JMenuItem("New");
		memberNew.addActionListener(this);
		mnuStudent.add(memberNew);
		
		memberListAll = new JMenuItem("List all");
		memberListAll.addActionListener(this);
		mnuStudent.add(memberListAll);
		
		memberEdit = new JMenuItem("Edit");
		memberEdit.addActionListener(this);
		mnuStudent.add(memberEdit);
		
		memberSearch = new JMenuItem("Search");
		memberSearch.addActionListener(this);
		mnuStudent.add(memberSearch);
		
		mnuNonStudent = new JMenu("Non Student");
		nonNew = new JMenuItem("New");
		nonNew.addActionListener(this);
		mnuNonStudent.add(nonNew);
		
		nonListAll = new JMenuItem("List all");
		nonListAll.addActionListener(this);
		mnuNonStudent.add(nonListAll);
		
		nonEdit = new JMenuItem("Edit");
		nonEdit.addActionListener(this);
		mnuNonStudent.add(nonEdit);
		
		nonSearch = new JMenuItem("Search");
		nonSearch.addActionListener(this);
		mnuNonStudent.add(nonSearch);
		
		mnuMembers.add(mnuStudent);
		mnuMembers.add(mnuNonStudent);
		
		bar.add(mnuMembers);
		
		mnuBooks = new JMenu("Books");
		
		miNew = new JMenuItem("New");
		miNew.addActionListener(this);
		mnuBooks.add(miNew);
		miListAll = new JMenuItem("List all");
		miListAll.addActionListener(this);
		mnuBooks.add(miListAll);
		miEdit = new JMenuItem("Edit"); 
		miEdit.addActionListener(this);
		mnuBooks.add(miEdit);
		miSearch = new JMenuItem("Search");
		miSearch.addActionListener(this);
		mnuBooks.add(miSearch);
		
		bar.add(mnuBooks);
		
		mnuIssue = new JMenu("Issue");
		bar.add(mnuIssue);
		
		mnuPayment = new JMenu("Payment");
		bar.add(mnuPayment);
		
		setJMenuBar(bar);
		add(pane);
		
		setVisible(true);
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == miNew){
			pane.add(new BooksForm());
		}else if(src == miListAll){
			pane.add(new ListAllBooksForm());
			
		}else if(src == miEdit){
			pane.add(new EditBooksForm());
			
		}else if(src == miSearch){
			pane.add(new SearchBook());
			
		}else if(src == memberNew){
			pane.add(new NewStudentsForm());
			
		}else if(src == memberListAll){
			pane.add(new ListAllStudentsForm());
			
		}else if(src == memberEdit){
			pane.add(new EditStudentDetails());
			
		}else if(src == memberSearch){
			pane.add(new SearchStudentsForm());
			
		}else if(src == nonNew){
			pane.add(new NewNonStudentForm());
			
		}else if(src == nonListAll){
			pane.add(new ListAllNonStudentsForm());
			
		}else if(src == nonEdit){
			pane.add(new EditNonStudentsForm());
			
		}else if(src == nonSearch){
			pane.add(new SearchNonStudentsForm());
			
		}
		
	}

}
