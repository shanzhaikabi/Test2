package com.company.DZPK.frame;

import com.company.DZPK.controller.GetUserDataClient;
import com.company.DZPK.controller.LoginClient;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.Color;

public class login_frame {

	public static JFrame login_frame;
	public static JTextField account_field;
	public static JLabel currentpeople_label;
	public static JLabel currentplayer_label;
	public static JLabel currentgame_label;
	public static JPasswordField password_field;
	public static JLabel gamename_label;
	public static JLabel error_label;
	public static final String login_error = "login_error!!!";
    public static login_frame window;

    /**
     * Launch the application.
     */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_frame window = new login_frame();
					window.login_frame.setVisible(true);
                    //Client.main(args);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

    public static void show() {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    window = new login_frame();
                    window.login_frame.setVisible(true);
                    //Client.main(args);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

	/**
	 * Create the application.
	 */
	public login_frame() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		login_frame = new JFrame();
		login_frame.getContentPane().setEnabled(false);
		login_frame.setTitle("\u5FB7\u5DDE\u6251\u514B\u5BF9\u6218\u7CFB\u7EDF");
		login_frame.setBounds(100, 100, 1052, 825);
		login_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login_frame.getContentPane().setLayout(null);
		
		JLabel title_label = new JLabel("\u5FB7\u5DDE\u6251\u514B\u5728\u7EBF\u5BF9\u6218");
		title_label.setBounds(58, 62, 523, 92);
		login_frame.getContentPane().add(title_label);
		title_label.setHorizontalAlignment(SwingConstants.CENTER);
		title_label.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 60));
		
		currentpeople_label = new JLabel("\u5F53\u524D\u5728\u7EBF\u4EBA\u6570\uFF1A");
		currentpeople_label.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 32));
		currentpeople_label.setBounds(100, 419, 423, 79);
		login_frame.getContentPane().add(currentpeople_label);
		
		currentplayer_label = new JLabel("\u5F53\u524D\u5BF9\u6218\u4EBA\u6570\uFF1A");
		currentplayer_label.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 32));
		currentplayer_label.setBounds(100, 479, 423, 79);
		login_frame.getContentPane().add(currentplayer_label);
		
		currentgame_label = new JLabel("\u5F53\u524D\u5B8C\u6210\u5BF9\u5C40\uFF1A");
		currentgame_label.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 32));
		currentgame_label.setBounds(100, 539, 423, 79);
		login_frame.getContentPane().add(currentgame_label);
		
		JLabel other_label = new JLabel("\u672C\u516C\u53F8\u5176\u4ED6\u6E38\u620F");
		other_label.setHorizontalAlignment(SwingConstants.CENTER);
		other_label.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 18));
		other_label.setBounds(654, 82, 269, 63);
		login_frame.getContentPane().add(other_label);
		
		JLabel warning_label = new JLabel("<html><body>\t<center>\u5065\u5EB7\u6E38\u620F\u5FE0\u544A<br>\r\n\u62B5\u5236\u4E0D\u826F\u6E38\u620F,\u62D2\u7EDD\u76D7\u7248\u6E38\u620F\u3002<br>\r\n\u6CE8\u610F\u81EA\u6211\u4FDD\u62A4,\u8C28\u9632\u53D7\u9A97\u4E0A\u5F53\u3002<br>\r\n\u9002\u5EA6\u6E38\u620F\u76CA\u8111,\u6C89\u8FF7\u6E38\u620F\u4F24\u8EAB\u3002<br>\r\n\u5408\u7406\u5B89\u6392\u65F6\u95F4,\u4EAB\u53D7\u5065\u5EB7\u751F\u6D3B\u3002<br>");
		warning_label.setFont(new Font("å®‹ä½“", Font.PLAIN, 24));
		warning_label.setHorizontalAlignment(SwingConstants.CENTER);
		warning_label.setBounds(537, 424, 403, 181);
		login_frame.getContentPane().add(warning_label);
		
		gamename_label = new JLabel("\u65E0");
		gamename_label.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 18));
		gamename_label.setHorizontalAlignment(SwingConstants.CENTER);
		gamename_label.setBounds(759, 158, 72, 18);
		login_frame.getContentPane().add(gamename_label);
		
		account_field = new JTextField();
		account_field.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 18));
		account_field.setBounds(160, 200, 320, 32);
		login_frame.getContentPane().add(account_field);
		account_field.setText("\u8BF7\u8F93\u5165\u7528\u6237\u540D");
		account_field.setColumns(10);
		
		password_field = new JPasswordField();
		password_field.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 18));
		password_field.setBounds(160, 260, 320, 32);
		login_frame.getContentPane().add(password_field);
		
		JButton register_button = new JButton("\u6CE8\u518C");
        register_button.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 18));
        register_button.setBounds(200, 323, 80, 32);

		login_frame.getContentPane().add(register_button);
		
		JButton login_button = new JButton("\u767B\u5F55");
        login_button.setFont(new Font("ï¿½ï¿½ï¿½ï¿½", Font.PLAIN, 18));
        login_button.setBounds(360, 323, 80, 32);
        login_button.addActionListener(e -> {
            String username = account_field.getText();
            String password = String.valueOf(password_field.getPassword());
            LoginClient.CheckLoginToServer(username, password);
        });
		login_frame.getContentPane().add(login_button);
		
		error_label = new JLabel("");
		error_label.setForeground(Color.RED);
		error_label.setFont(new Font("ËÎÌå", Font.PLAIN, 22));
		error_label.setBounds(200, 375, 242, 48);
		login_frame.getContentPane().add(error_label);
	}

	public static void setError_label(String string){
		error_label.setText(string);
	}
	public static void set_currentgame_label(String s)
	{
		currentgame_label.setText(s);
	}
	public static void set_currentpeople_label(String s)
	{
		currentpeople_label.setText(s);
	}
	public static void set_currentplayer_label(String s)
	{
		currentplayer_label.setText(s);
	}

	public static void GetUserData(){
	    window.login_frame.setVisible(false);
        GetUserDataClient.GetUserDataToServer(account_field.getText());
    }
}
