package presentation;


import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.JTabbedPane;
import javax.swing.JPasswordField;
import javax.swing.JCheckBox;
import javax.swing.BoxLayout;
import javax.swing.JSplitPane;
import java.awt.GridLayout;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionEvent;

public class View {

	private JFrame frame;
	
	private JTabbedPane tabbedPane;
	
	private JPanel logInPanel;
	private JPanel addBookPanel;
	private JPanel viewBooksPanel;
	private JPanel addUserPanel;
	private JPanel viewUsersPanel;
	
	private JLabel lblPassword;
	private JLabel lblUsername;
	
	private JTextField txtUserName;
	
	private JButton btnLogIn;
	private JButton btnAdd;
	private JButton btnLogOut;
	
	private JPasswordField txtPassword;
	
	private JLabel lblNewLabel;
	private JLabel lblTitle;
	private JLabel lblAuthor;
	private JLabel lblGenre;
	
	private JTextField txtTitle;
	private JTextField txtAuthor;
	private JTextField txtPrice;
	private JTextField textQuantity;
	
	private JCheckBox chckbxFiction;
	private JCheckBox chckbxNonfiction;
	private JLabel lblName;
	private JLabel lblUsername_1;
	private JLabel lblPassword_1;
	private JTextField name;
	private JTextField username;
	private JButton btnAddUser;
	private JButton btnLogOutAddU;
	private JPasswordField password;
	private JLabel lblReenterPasword;
	private JPasswordField password2;
	private JLabel lblType;
	private JCheckBox chckbxAdmin;
	private JCheckBox chckbxEmployee;
	private JCheckBox csv;
	private JCheckBox pdf;
	private JSplitPane splitPane;
	private JPanel panelTable;
	private JPanel panel;
	private JScrollPane scrollPaneB;
	private JTable tableB;
	
	private DefaultTableModel modelB;
	private JTextField texAuthor;
	private JTextField txtQuantity;
	
	private JButton btnAuthorSearch;
	private JButton btnFiction;
	private JButton btnGetnonfiction;
	private JButton btnBuybooks;
	private JButton btnUpdatePrice;
	private JButton btnLogOutVU;
	private JTextField textTitle;
	private JButton btnTitlesearch;
	private JButton btnGeneratereport;
	private JSplitPane splitPane_1;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblTitle_1;
	private JLabel lblAuthor_1;
	private JButton btnUpdateQuantity;
	private JSplitPane splitPane_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JTable table;
	private JButton btnUpdate;
	private JButton btnDelete;
	private JButton btnLogOut_1;
	private DefaultTableModel modelU;
	private JLabel lblSelectUserselectmodifyupdate;
	private JButton btnSelect;


	/**
	 * Create the application.
	 */
	public View() {
		initialize();
		this.tabbedPane.setEnabledAt(1, false);
		this.tabbedPane.setEnabledAt(2, false);
		this.tabbedPane.setEnabledAt(3, false);
		this.tabbedPane.setEnabledAt(4, false);

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBackground(new Color(154, 205, 50));
		frame.getContentPane().setBackground(new Color(154, 205, 50));
		frame.setBounds(100, 100, 625, 388);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setForeground(new Color(255, 255, 255));
		tabbedPane.setFont(new Font("Century Gothic", Font.PLAIN, 11));
		tabbedPane.setBackground(new Color(154, 205, 50));
		tabbedPane.setBounds(0, 0, 609, 349);
		frame.getContentPane().add(tabbedPane);
		
		logInPanel = new JPanel();
		logInPanel.setForeground(new Color(255, 255, 255));
		tabbedPane.addTab("Log In", null, logInPanel, null);
		tabbedPane.setForegroundAt(0, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(0, new Color(255, 255, 255));
		logInPanel.setBackground(new Color(154, 205, 50));
		logInPanel.setLayout(null);
		
		lblPassword = new JLabel("Password:");
		lblPassword.setBounds(151, 117, 64, 21);
		logInPanel.add(lblPassword);
		
		lblUsername = new JLabel("Username:");
		lblUsername.setBounds(151, 83, 64, 21);
		logInPanel.add(lblUsername);
		
		txtUserName = new JTextField();
		txtUserName.setBounds(269, 83, 86, 20);
		logInPanel.add(txtUserName);
		txtUserName.setColumns(10);
		
		btnLogIn = new JButton("Log In");
		btnLogIn.setBounds(200, 207, 89, 23);
		logInPanel.add(btnLogIn);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the BookStore!\r\n");
		lblWelcomeToThe.setBounds(137, 8, 255, 64);
		logInPanel.add(lblWelcomeToThe);
		lblWelcomeToThe.setForeground(new Color(255, 255, 255));
		lblWelcomeToThe.setFont(new Font("Century Gothic", Font.PLAIN, 18));
		
		txtPassword = new JPasswordField();
		txtPassword.setEchoChar('❤');
		txtPassword.setBounds(269, 117, 86, 20);
		logInPanel.add(txtPassword);
		
		addBookPanel = new JPanel();
		addBookPanel.setForeground(new Color(255, 255, 255));
		addBookPanel.setVisible(false);
		addBookPanel.setBackground(new Color(154, 205, 50));
		tabbedPane.addTab("AddBook", null, addBookPanel, null);
		addBookPanel.setLayout(null);
		
		lblNewLabel = new JLabel("Add a new book :)\r\n");
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setFont(new Font("Century Gothic", Font.PLAIN, 13));
		lblNewLabel.setBounds(198, 11, 225, 14);
		addBookPanel.add(lblNewLabel);
		
		lblTitle = new JLabel("Title:");
		lblTitle.setBounds(60, 74, 65, 14);
		addBookPanel.add(lblTitle);
		
		lblAuthor = new JLabel("Author:");
		lblAuthor.setBounds(60, 113, 46, 14);
		addBookPanel.add(lblAuthor);
		
		lblGenre = new JLabel("Genre:");
		lblGenre.setBounds(60, 153, 46, 14);
		addBookPanel.add(lblGenre);
		
		chckbxFiction = new JCheckBox("Fiction");
		chckbxFiction.setBackground(new Color(154, 205, 50));
		chckbxFiction.setBounds(134, 149, 97, 23);
		addBookPanel.add(chckbxFiction);
		
		chckbxNonfiction = new JCheckBox("Non-Fiction");
		chckbxNonfiction.setBackground(new Color(154, 205, 50));
		chckbxNonfiction.setBounds(256, 149, 97, 23);
		addBookPanel.add(chckbxNonfiction);
		
		JLabel lblPrice = new JLabel("Price:");
		lblPrice.setBounds(60, 200, 46, 14);
		addBookPanel.add(lblPrice);
		
		JLabel lblQuantity = new JLabel("Quantity:");
		lblQuantity.setBounds(60, 236, 65, 14);
		addBookPanel.add(lblQuantity);
		
		txtTitle = new JTextField();
		txtTitle.setBounds(135, 71, 96, 20);
		addBookPanel.add(txtTitle);
		txtTitle.setColumns(10);
		
		txtAuthor = new JTextField();
		txtAuthor.setBounds(134, 110, 97, 20);
		addBookPanel.add(txtAuthor);
		txtAuthor.setColumns(10);
		
		txtPrice = new JTextField();
		txtPrice.setBounds(134, 197, 97, 20);
		addBookPanel.add(txtPrice);
		txtPrice.setColumns(10);
		
		textQuantity = new JTextField();
		textQuantity.setBounds(134, 233, 97, 20);
		addBookPanel.add(textQuantity);
		textQuantity.setColumns(10);
		
		btnAdd = new JButton("ADD");
		btnAdd.setBounds(134, 286, 89, 23);
		addBookPanel.add(btnAdd);
		
		btnLogOut = new JButton("Log out");
		btnLogOut.setBounds(301, 286, 89, 23);
		addBookPanel.add(btnLogOut);
		tabbedPane.setForegroundAt(1, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(1, new Color(255, 255, 255));
		
		viewBooksPanel = new JPanel();
		viewBooksPanel.setForeground(new Color(255, 255, 255));
		viewBooksPanel.setVisible(false);
		viewBooksPanel.setBackground(new Color(154, 205, 50));
		tabbedPane.addTab("ViewBooks", null, viewBooksPanel, null);
		viewBooksPanel.setLayout(new BoxLayout(viewBooksPanel, BoxLayout.X_AXIS));
		
		splitPane = new JSplitPane();
		splitPane.setBackground(new Color(154, 205, 50));
		splitPane.setResizeWeight(0.1);
		viewBooksPanel.add(splitPane);
		
		panelTable = new JPanel();
		panelTable.setBackground(new Color(154, 205, 50));
		splitPane.setLeftComponent(panelTable);
		panelTable.setLayout(new GridLayout(1, 0, 0, 0));
		
		splitPane_1 = new JSplitPane();
		splitPane_1.setResizeWeight(0.5);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panelTable.add(splitPane_1);
		
		panel_1 = new JPanel();
		splitPane_1.setLeftComponent(panel_1);
		panel_1.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPaneB = new JScrollPane();
		panel_1.add(scrollPaneB);
		
		tableB = new JTable();
		tableB.setBackground(new Color(154, 205, 50));
		
		
		tableB.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Title", "Author", "Genre", "Quantity", "Price"
				}
			));
		scrollPaneB.setViewportView(tableB);
		modelB=(DefaultTableModel)tableB.getModel();
		
		panel_2 = new JPanel();
		panel_2.setBackground(new Color(154, 205, 50));
		splitPane_1.setRightComponent(panel_2);
		panel_2.setLayout(null);
		
		textTitle = new JTextField();
		textTitle.setBounds(136, 8, 138, 20);
		panel_2.add(textTitle);
		textTitle.setColumns(10);
		
		btnTitlesearch = new JButton("Search");
		btnTitlesearch.setBounds(318, 7, 138, 23);
		panel_2.add(btnTitlesearch);
		
		texAuthor = new JTextField();
		texAuthor.setBounds(136, 39, 138, 20);
		panel_2.add(texAuthor);
		texAuthor.setColumns(10);
		
		btnAuthorSearch = new JButton("Search");
		btnAuthorSearch.setBounds(318, 41, 138, 23);
		panel_2.add(btnAuthorSearch);
		
		JLabel lblQuantity_1 = new JLabel("Quantity:");
		lblQuantity_1.setBounds(50, 73, 58, 14);
		panel_2.add(lblQuantity_1);
		
		txtQuantity = new JTextField();
		txtQuantity.setBounds(136, 70, 138, 20);
		panel_2.add(txtQuantity);
		txtQuantity.setColumns(10);
		
		btnBuybooks = new JButton("Sell");
		btnBuybooks.setBounds(318, 75, 138, 23);
		panel_2.add(btnBuybooks);
		
		lblTitle_1 = new JLabel("Title:");
		lblTitle_1.setBounds(50, 11, 58, 14);
		panel_2.add(lblTitle_1);
		
		lblAuthor_1 = new JLabel("Author:");
		lblAuthor_1.setBounds(50, 36, 58, 14);
		panel_2.add(lblAuthor_1);
		
		pdf = new JCheckBox("PDF");
		pdf.setBackground(new Color(154, 205, 50));
		pdf.setBounds(50, 109, 97, 23);
		panel_2.add(pdf);
		
		csv = new JCheckBox("CSV");
		csv.setBackground(new Color(154, 205, 50));
		csv.setBounds(153, 109, 97, 23);
		panel_2.add(csv);
		
		btnGeneratereport = new JButton("GenerateReport");
		btnGeneratereport.setBounds(318, 109, 138, 23);
		panel_2.add(btnGeneratereport);
	
		
		panel = new JPanel();
		panel.setBackground(new Color(154, 205, 50));
		splitPane.setRightComponent(panel);
		panel.setLayout(null);
		
		btnUpdatePrice = new JButton("Update price");
		btnUpdatePrice.setBounds(10, 96, 111, 23);
		panel.add(btnUpdatePrice);
		
		btnFiction = new JButton("GetFiction");
		btnFiction.setBounds(10, 130, 111, 23);
		panel.add(btnFiction);
		
		btnGetnonfiction = new JButton("GetNonFic");
		btnGetnonfiction.setBounds(10, 164, 109, 23);
		panel.add(btnGetnonfiction);
		
		btnLogOutVU = new JButton("LogOut");
		btnLogOutVU.setBounds(9, 269, 112, 23);
		panel.add(btnLogOutVU);
		
		btnUpdateQuantity = new JButton("UpdateStoc\r\n");
		btnUpdateQuantity.setBounds(10, 62, 111, 23);
		panel.add(btnUpdateQuantity);
		tabbedPane.setForegroundAt(2, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(2, new Color(255, 255, 255));
		
		addUserPanel = new JPanel();
		addUserPanel.setForeground(new Color(255, 255, 255));
		addUserPanel.setVisible(false);
		addUserPanel.setBackground(new Color(154, 205, 50));
		tabbedPane.addTab("AddUser", null, addUserPanel, null);
		addUserPanel.setLayout(null);
		
		lblName = new JLabel("Name:");
		lblName.setBounds(139, 59, 113, 14);
		addUserPanel.add(lblName);
		
		lblUsername_1 = new JLabel("Username:");
		lblUsername_1.setBounds(139, 93, 124, 14);
		addUserPanel.add(lblUsername_1);
		
		lblPassword_1 = new JLabel("Password:");
		lblPassword_1.setBounds(139, 135, 124, 14);
		addUserPanel.add(lblPassword_1);
		
		name = new JTextField();
		name.setBounds(287, 56, 102, 20);
		addUserPanel.add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setBounds(287, 90, 102, 20);
		addUserPanel.add(username);
		username.setColumns(10);
		
		btnAddUser = new JButton("ADD");
		btnAddUser.setBounds(207, 245, 89, 23);
		addUserPanel.add(btnAddUser);
		
		btnLogOutAddU = new JButton("Log Out");
		btnLogOutAddU.setBounds(367, 245, 89, 23);
		addUserPanel.add(btnLogOutAddU);
		
		password = new JPasswordField();
		password.setEchoChar('❤');
		password.setBounds(287, 132, 102, 20);
		addUserPanel.add(password);
		
		lblReenterPasword = new JLabel("Re-enter pasword:");
		lblReenterPasword.setBounds(139, 171, 132, 14);
		addUserPanel.add(lblReenterPasword);
		
		password2 = new JPasswordField();
		password2.setEchoChar('❤');
		password2.setBounds(287, 168, 102, 20);
		addUserPanel.add(password2);
		
		lblType = new JLabel("Type:");
		lblType.setBounds(139, 207, 46, 14);
		addUserPanel.add(lblType);
		
		chckbxAdmin = new JCheckBox("Admin");
		chckbxAdmin.setBackground(new Color(154, 205, 50));
		chckbxAdmin.setBounds(252, 203, 97, 23);
		addUserPanel.add(chckbxAdmin);
		
		chckbxEmployee = new JCheckBox("Employee");
		chckbxEmployee.setBackground(new Color(154, 205, 50));
		chckbxEmployee.setBounds(359, 203, 97, 23);
		addUserPanel.add(chckbxEmployee);
		tabbedPane.setForegroundAt(3, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(3, new Color(255, 255, 255));
		
		viewUsersPanel = new JPanel();
		viewUsersPanel.setForeground(new Color(255, 255, 255));
		viewUsersPanel.setVisible(false);
		viewUsersPanel.setBackground(new Color(154, 205, 50));
		tabbedPane.addTab("ViewUsers", null, viewUsersPanel, null);
		viewUsersPanel.setLayout(new BoxLayout(viewUsersPanel, BoxLayout.X_AXIS));
		
		splitPane_2 = new JSplitPane();
		splitPane_2.setResizeWeight(0.6);
		viewUsersPanel.add(splitPane_2);
		
		panel_3 = new JPanel();
		panel_3.setBackground(new Color(154, 205, 50));
		splitPane_2.setLeftComponent(panel_3);
		panel_3.setLayout(new GridLayout(1, 0, 0, 0));
		
		scrollPane = new JScrollPane();
		panel_3.add(scrollPane);
		
		table = new JTable();
		table.setBackground(new Color(154, 205, 50));
		table.setModel(new DefaultTableModel(
				new Object[][] {
				},
				new String[] {
					"Name", "Username", "Password", "UserType"
				}
			));
		scrollPane.setColumnHeaderView(table);
		modelU=(DefaultTableModel)table.getModel();
		
		
		
		panel_4 = new JPanel();
		panel_4.setBackground(new Color(154, 205, 50));
		splitPane_2.setRightComponent(panel_4);
		panel_4.setLayout(null);
		
		btnUpdate = new JButton("Update");
		btnUpdate.setBounds(58, 86, 89, 23);
		panel_4.add(btnUpdate);
		
		btnDelete = new JButton("Delete");
		btnDelete.setBounds(58, 174, 89, 23);
		panel_4.add(btnDelete);
		
		btnLogOut_1 = new JButton("Log out");
		btnLogOut_1.setBounds(58, 208, 89, 23);
		panel_4.add(btnLogOut_1);
		
		lblSelectUserselectmodifyupdate = new JLabel("Select user->Select->\r\nModify->Update");
		lblSelectUserselectmodifyupdate.setBounds(10, 11, 229, 40);
		panel_4.add(lblSelectUserselectmodifyupdate);
		
		btnSelect = new JButton("Select");
		btnSelect.setBounds(58, 52, 89, 23);
		panel_4.add(btnSelect);
		tabbedPane.setForegroundAt(4, new Color(255, 255, 255));
		tabbedPane.setBackgroundAt(4, new Color(255, 255, 255));
	}
	
	public JTabbedPane getTabbedPane() {
		return tabbedPane;
	}

	public String getUsername(){
		return this.txtUserName.getText();
	}
	public String getPassword(){
		return this.txtPassword.getText();
	}
	public void setUsername(String s){
		this.txtUserName.setText(s);
	}
	
	public void setPassword(String s){
		this.txtPassword.setText(s);
	}
	
	public void logIn(ActionListener al){
		btnLogIn.addActionListener(al);
	}
	
	public void addBookLogOut(ActionListener al){
		btnLogOut.addActionListener(al);
	}
	public void addBook(ActionListener al){
		btnAdd.addActionListener(al);
	}
	
	public void addUser(ActionListener al){
		btnAddUser.addActionListener(al);
	}
	
	public void addUserLogOut(ActionListener al){
		btnLogOutAddU.addActionListener(al);
	}
	
	public void AuthorSearch(ActionListener al){
		btnAuthorSearch.addActionListener(al);
	}
	
	public void FictionSearch(ActionListener al){
		btnFiction.addActionListener(al);
	}
	public void NonFictionSearch(ActionListener al){
		btnGetnonfiction.addActionListener(al);
	}
	
	public void BuyBook(ActionListener al){
		btnBuybooks.addActionListener(al);
	}
	public void UpdatePrice(ActionListener al){
		btnUpdatePrice.addActionListener(al);
	}
	public void UpdateQuantity(ActionListener al){
		btnUpdateQuantity.addActionListener(al);
	}
	public void SearchTitle(ActionListener al){
		btnTitlesearch.addActionListener(al);
	}
	public void ViewBookLogOut(ActionListener al){
		btnLogOutVU.addActionListener(al);
	}
	public void GenerateReport(ActionListener al){
		btnGeneratereport.addActionListener(al);
	}
	
	public void Update(ActionListener al){
		btnUpdate.addActionListener(al);
	}
	
	public void Select(ActionListener al){
		btnSelect.addActionListener(al);
	}
	
	public void Delete(ActionListener al){
		btnDelete.addActionListener(al);
	}
	
	public void LogOut(ActionListener al){
		btnLogOut_1.addActionListener(al);
	}
	public JPanel getLogInPanel() {
		return logInPanel;
	}

	public JPanel getAddBookPanel() {
		return addBookPanel;
	}

	public JPanel getViewBooksPanel() {
		return viewBooksPanel;
	}

	public JPanel getAddUserPanel() {
		return addUserPanel;
	}

	public JPanel getViewUsersPanel() {
		return viewUsersPanel;
	}
	

	public String getTitle() {
		return txtTitle.getText();
	}

	public void setTitle(String txtTitle) {
		this.txtTitle.setText(txtTitle);
	}
	
	public String getAuthor() {
		return txtAuthor.getText();
	}

	public void setAuthor(String txtTitle) {
		this.txtAuthor.setText(txtTitle);
	}
	
	public float getPrice() {
		return Float.parseFloat(this.txtPrice.getText());
	}

	public void setPrice(String txtPrice) {
		this.txtPrice.setText(txtPrice);
	}

	public int getQuantity() {
		return Integer.parseInt(textQuantity.getText());
	}

	public void setQuantity(String textQuantity) {
		this.textQuantity.setText(textQuantity);
	}

	public JCheckBox getChckbxFiction() {
		return chckbxFiction;
	}

	public JCheckBox getChckbxNonfiction() {
		return chckbxNonfiction;
	}
	
	public JCheckBox getAdmin() {
		return chckbxAdmin;
	}

	public JCheckBox getEmployee() {
		return chckbxEmployee;
	}
	
	public JCheckBox getPdf() {
		return pdf;
	}

	public JCheckBox getCsv() {
		return csv;
	}
	
	public String getName(){
		return name.getText();
	}
	
	public void setName(String s){
		name.setText(s);
	}
	
	public String getNewUsername(){
		return username.getText();
	}
	
	public void setNewUsername(String s){
		username.setText(s);
	}
	
	public String getPassword1(){
		return password.getText();
	}
	
	public void setPassword1(String s){
		password.setText(s);
	}
	
	public String getPassword2(){
		return password2.getText();
	}
	
	public void setPassword2(String s){
		password2.setText(s);
	}
	
	public String getTitleSearch(){
		return textTitle.getText();
	}
	
	public void setTitleSearch(String s){
		textTitle.setText(s);
	}
	
	public String getAuthorSearch(){
		return texAuthor.getText();
	}
	
	public void setAuthorSearch(String s){
		texAuthor.setText(s);
	}
	
	public int getQBook(){
		return Integer.parseInt(txtQuantity.getText());
	}
	
	public void setQBook(String s){
		txtQuantity.setText(s);
	}
	
	public JScrollPane getScrollPaneB() {
		return scrollPaneB;
	}

	public JTable getTableB() {
		return tableB;
	}

	public DefaultTableModel getModelB() {
		return modelB;
	}
	
	public JScrollPane getScrollPaneU() {
		return scrollPane;
	}

	public JTable getTable() {
		return table;
	}

	public DefaultTableModel getModel() {
		return modelU;
	}
}
