package minitwitter;

import javax.swing.DefaultListModel;

//This is the UserView object which displays the view for the user
public class UserViewPanel extends javax.swing.JFrame implements Observer {
    private final User user;
    private final UserGroup root;
    private final DefaultListModel<String> feedList = new DefaultListModel<>();
    private final DefaultListModel<String> followingList = new DefaultListModel<>();

    //This is the constructor for the UserView object
    public UserViewPanel(User user, UserGroup root) {
        this.user = user;
        this.root = root;
        initComponents();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        creationTimeLabel.setText("Created: " + new java.util.Date(user.getCreationTime()));
        lastUpdateTimeLabel.setText("Last updated: " + new java.util.Date(user.getLastUpdateTime()));

        for (String msg : user.getFeed()) feedList.addElement(msg);
        for (User f : user.getFollowing()) followingList.addElement(f.getID());

        user.addObserver(this);
    }

    //This overrides the update method.
    @Override
    public void update(String message) {
        feedList.addElement(message);
        lastUpdateTimeLabel.setText("Last updated: " + new java.util.Date(user.getLastUpdateTime()));
    }
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(UserViewPanel.class.getName());


    @SuppressWarnings("unchecked")
    private void initComponents() {
        jScrollPane3 = new javax.swing.JScrollPane();
        jTextArea2 = new javax.swing.JTextArea();
        followUserButton = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        followedUsersList = new javax.swing.JList<>(followingList);
        postTweetButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        userFeed = new javax.swing.JList<>(feedList);
        userInput = new javax.swing.JTextField();
        tweetInput = new javax.swing.JTextField();
        creationTimeLabel = new javax.swing.JLabel();
        lastUpdateTimeLabel = new javax.swing.JLabel();

        jTextArea2.setColumns(20);
        jTextArea2.setRows(5);
        jScrollPane3.setViewportView(jTextArea2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        followUserButton.setText("Follow User");
        followUserButton.addActionListener(this::followUserButtonActionPerformed);

        jScrollPane1.setViewportView(followedUsersList);

        postTweetButton.setText("Post Tweet");
        postTweetButton.addActionListener(this::postTweetButtonActionPerformed);

        jScrollPane4.setViewportView(userFeed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tweetInput, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(postTweetButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(userInput, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(followUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 312, Short.MAX_VALUE)
                    .addComponent(creationTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lastUpdateTimeLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(144, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(userInput)
                    .addComponent(followUserButton, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(postTweetButton, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tweetInput))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(creationTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lastUpdateTimeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
    }

    //This is the followUser button, which allows a user to follow another user
    //when the text in the text field matches another user's username
    private void followUserButtonActionPerformed(java.awt.event.ActionEvent evt) {
    String targetId = userInput.getText().trim();
    if (targetId.isEmpty()) return;
    UserLookupVisitor lookup = new UserLookupVisitor(targetId);
    root.accept(lookup);
    User target = lookup.getFound();
    
    user.getFollowing().add(target);
    target.getFollowedBy().add(user);
    followingList.addElement(target.getID());
    userInput.setText("");
    }

    //This is the button to post a tweet which other users will be able to see
    //if they are following the user who posted the tweet
    private void postTweetButtonActionPerformed(java.awt.event.ActionEvent evt) {
        String message = tweetInput.getText().trim();
        user.postTweet(message);
        tweetInput.setText("");
    

    }

    //Creating all the variables.
    private javax.swing.JLabel creationTimeLabel;
    private javax.swing.JButton followUserButton;
    private javax.swing.JList<String> followedUsersList;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea2;
    private javax.swing.JLabel lastUpdateTimeLabel;
    private javax.swing.JButton postTweetButton;
    private javax.swing.JTextField tweetInput;
    private javax.swing.JList<String> userFeed;
    private javax.swing.JTextField userInput;

}
