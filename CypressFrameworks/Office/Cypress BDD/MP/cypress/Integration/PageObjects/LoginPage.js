class LoginPage{

    email=".col-sm-12 #Email";
    pwd=".col-sm-12 #Password";
    loginbtn="button[type='submit']";

    Get_Email()
    {
        return cy.get(this.email);
    }

    Get_Password()
    {
        return cy.get(this.pwd);
    }

    Get_Login_Btn()
    {
        return cy.get(this.loginbtn);
    }


    Enter_Values(username, password)
    {
        cy.EnterValues(this.Get_Email(), username);
        cy.EnterValues(this.Get_Password(), password);
        this.Get_Login_Btn().click();
    }
}

export default LoginPage;