package com.online.exam.model;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name ="UserAuth")
public class UserAuth implements Serializable {

    private static final long serialVersionUID = 8697710001L;

    	@Id 
        @GeneratedValue( strategy = GenerationType.AUTO )
        @Column(name = "id_user_auth")
        private Long idUserAuth;

    	@Column(name = "users_id")
        private String userID;

    	@Column(name = "user_passwd")
        private String userPasswd;

    	@NotNull
        @Column(name = "Enabled", columnDefinition = "enum( 'TRUE', 'FALSE' ) DEFAULT 'FALSE'" )
        @Enumerated(EnumType.STRING)
        private UserAccountEnabled enabled;

    // constructor with init
    public UserAuth( String id,
            String password,
            UserAccountEnabled enable )
    {
        this();
        this.userID = id;
        this.userPasswd = password;
        this.enabled = enable;
    }

    // empty constructor
    public UserAuth() 
    {
        super();
    }

    public void setUserID( String id ) 
    {
        this.userID = id;
    }

    public Long getIdUserAuth() {
		return idUserAuth;
	}

	public void setIdUserAuth(Long idUserAuth) {
		this.idUserAuth = idUserAuth;
	}

	public String getUserID() 
    {
        return this.userID;
    }

    public void setUserPasswd( String password ) 
    {
        this.userPasswd = password;
    }

    public String getUserPasswd() 
    {
        return this.userPasswd;
    }

    public void setEnabled( UserAccountEnabled enable ) 
    {
        this.enabled = enable;
    }

    public UserAccountEnabled getEnabled() 
    {
        return this.enabled;
    }
}
