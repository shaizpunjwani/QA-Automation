class LoginPage{

    username='[data-test="username"]';
    pwd='[data-test="password"]';
    login_btn='[data-test="login-button"]';

    get_Username_Selector()
    {
        return cy.get(this.username);
    }

    get_Pwd_Selector()
    {
        return cy.get(this.pwd);
    }

    get_Login_Btn()
    {
        return cy.get(this.login_btn);
    }

    Enter_Credentials(username, password)
    {
        cy.EnterValues(this.get_Username_Selector(), username);
        cy.EnterValues(this.get_Pwd_Selector(), password);
    
        this.get_Login_Btn().click();
    }


}

export default LoginPage;