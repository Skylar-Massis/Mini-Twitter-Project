package minitwitter;

import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

public final class ControlPanelLayout extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(ControlPanelLayout.class.getName());
    private static ControlPanelLayout instance;
    // Makes the class a singleton
    public static ControlPanelLayout getInstance() {
        if(instance == null){
            instance = new ControlPanelLayout();
        }
        return instance;
    }
    
    
    //Constructor which helps make this into a singleton.
    private ControlPanelLayout() {
        initComponents();
    }
    
    //Used to make controlpanel a singleton
    public static void setInstance(ControlPanelLayout instance) {
        ControlPanelLayout.instance = instance;
    }



    @SuppressWarnings("unchecked")
    private void initComponents() {

        UserViewButton = new javax.swing.JButton();
        showTotalUsersButton = new javax.swing.JButton();
        addUserButton = new javax.swing.JButton();
        addGroupButton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        model = new DefaultTreeModel(roottree, true);
        userGroupTree = new javax.swing.JTree(model);
        userCreationTextField = new javax.swing.JTextField();
        groupCreationTextField = new javax.swing.JTextField();
        showPercentagePositiveButton = new javax.swing.JButton();
        showGroupTotalButton = new javax.swing.JButton();
        showTotalMessagesButton = new javax.swing.JButton();
        OutputBox = new javax.swing.JLabel();
        LastUpdatedUserButton = new javax.swing.JButton();
        ValidateUsersButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        UserViewButton.setText("Open User View");
        UserViewButton.addActionListener(this::UserViewButtonActionPerformed);

        showTotalUsersButton.setText("Show User Total");
        showTotalUsersButton.addActionListener(this::showTotalUsersButtonActionPerformed);

        addUserButton.setText("Add User");
        addUserButton.addActionListener(this::addUserButtonActionPerformed);

        addGroupButton.setText("Add Group");
        addGroupButton.addActionListener(this::addGroupButtonActionPerformed);

        userGroupTree.addTreeSelectionListener(this::userGroupTreeValueChanged);
        jScrollPane2.setViewportView(userGroupTree);

        showPercentagePositiveButton.setText("Show Postive Percent");
        showPercentagePositiveButton.addActionListener(this::showPercentagePositiveButtonActionPerformed);

        showGroupTotalButton.setText("Show Group Total");
        showGroupTotalButton.addActionListener(this::showGroupTotalButtonActionPerformed);

        showTotalMessagesButton.setText("Show Messages Total");
        showTotalMessagesButton.addActionListener(this::showTotalMessagesButtonActionPerformed);

        LastUpdatedUserButton.setText("Show Last Updated User");
        LastUpdatedUserButton.addActionListener(this::LastUpdatedUserButtonActionPerformed);

        ValidateUsersButton.setText("Validate All Users");
        ValidateUsersButton.addActionListener(this::ValidateUsersButtonActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 224, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showTotalMessagesButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(showTotalUsersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(LastUpdatedUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(showPercentagePositiveButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(showGroupTotalButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ValidateUsersButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(groupCreationTextField)
                            .addComponent(userCreationTextField))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(addUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(UserViewButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(OutputBox, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(388, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 405, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(userCreationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(addGroupButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(groupCreationTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(UserViewButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showTotalUsersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showGroupTotalButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(showPercentagePositiveButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(showTotalMessagesButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(LastUpdatedUserButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(ValidateUsersButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(OutputBox, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }

    //button to add users
    private void addUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
        User a = new User(userCreationTextField.getText()); 
        UserGroup selectedGroup = (UserGroup) selected.getUserObject();
        selectedGroup.addChild(a);
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(a, false);
        model.insertNodeInto(newNode, selected, selected.getChildCount());
        System.out.println(selectedGroup);
    }

    //Button to open UserView
    private void UserViewButtonActionPerformed(java.awt.event.ActionEvent evt) {
    Object obj = selected.getUserObject();
    if (obj instanceof User) {
        UserViewPanel view = new UserViewPanel((User) obj, root);
        view.setVisible(true);
    }
    }

    //Selects the value that is selected on tree
    private void userGroupTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {
        selPath = userGroupTree.getSelectionPath(); 
        selected = (DefaultMutableTreeNode) selPath.getLastPathComponent();
    }

    //Button that creates the UserGroup
    private void addGroupButtonActionPerformed(java.awt.event.ActionEvent evt) {
        UserGroup a = new UserGroup(groupCreationTextField.getText()); 
        UserGroup selectedGroup = (UserGroup) selected.getUserObject();
        selectedGroup.addChild(a);
        DefaultMutableTreeNode newNode = new DefaultMutableTreeNode(a, true);
        model.insertNodeInto(newNode, selected, selected.getChildCount());
        System.out.println(selectedGroup);
    }

    //Button that shows the total number of users.
    private void showTotalUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TotalUsersVisitor v = new TotalUsersVisitor();
        root.accept(v);
        OutputBox.setText("Total users: " + v.total);
    }

    //Button that shows the total number of groups
    private void showGroupTotalButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TotalGroupVisitor visitor = new TotalGroupVisitor();
        root.accept(visitor);
        OutputBox.setText("Total groups: " + visitor.total);
    }

    //Button that shows the total number of messages, it will add up all the messages that
    //appear on every users feed including duplicates.
    private void showTotalMessagesButtonActionPerformed(java.awt.event.ActionEvent evt) {
        TotalMessagesVisitor visitor = new TotalMessagesVisitor();
        root.accept(visitor);
        OutputBox.setText("Total messages: " + visitor.total);
    }

    //Button that shows the percentage of positive messages.
    private void showPercentagePositiveButtonActionPerformed(java.awt.event.ActionEvent evt) {
        PositiveMessagesVisitor visitor = new PositiveMessagesVisitor();
        root.accept(visitor);
        OutputBox.setText(String.format("Positive messages: %.1f%%", visitor.getPositivePercentage()));
    }

    //Button that shows the last updated action performed.
    private void LastUpdatedUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
            LastUpdatedUserVisitor visitor = new LastUpdatedUserVisitor();
        root.accept(visitor);
        User lastUser = visitor.getLastUpdatedUser();
        String result = (lastUser != null) ? "Last updated user: " + lastUser.getID() : "No users found.";
        OutputBox.setText(result);
    }

    //Button that validates all the user ID's and tells if they are all valid or not.
    private void ValidateUsersButtonActionPerformed(java.awt.event.ActionEvent evt) {
        IDValidationVisitor visitor = new IDValidationVisitor();
        root.accept(visitor);
        String result = visitor.isValid() ? "All IDs are valid." : "Invalid IDs found (duplicates or spaces).";
        javax.swing.JOptionPane.showMessageDialog(this, result);
    }
    
    private DefaultTreeModel model;
    DefaultMutableTreeNode selected = new DefaultMutableTreeNode();
    private TreePath selPath;
    private final UserGroup root = new UserGroup("Root");
    DefaultMutableTreeNode roottree = new DefaultMutableTreeNode(root, true);
    private javax.swing.JButton LastUpdatedUserButton;
    private javax.swing.JLabel OutputBox;
    private javax.swing.JButton UserViewButton;
    private javax.swing.JButton ValidateUsersButton;
    private javax.swing.JButton addGroupButton;
    private javax.swing.JButton addUserButton;
    private javax.swing.JTextField groupCreationTextField;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton showGroupTotalButton;
    private javax.swing.JButton showPercentagePositiveButton;
    private javax.swing.JButton showTotalMessagesButton;
    private javax.swing.JButton showTotalUsersButton;
    private javax.swing.JTextField userCreationTextField;
    private javax.swing.JTree userGroupTree;
}
