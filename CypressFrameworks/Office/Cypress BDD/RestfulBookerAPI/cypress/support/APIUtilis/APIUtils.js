/// <reference types="Cypress" />
const data=require("../GetDataJson/GetData")

var baseurl=data.GetBaseUrl();

function Authorize(username, password)
{

    return cy.request({
        method: "POST",
        url: baseurl+data.GetEndpoint("auth"),
        body: {
            "username" : username,
            "password" : password
        }
    }).then((response)=>{
        return {
            response: response,
            token: response.body.token
        }
    })
}


function Create_Booking(payload)
{
    return cy.request({
        method: "POST",
        url: baseurl+data.GetEndpoint("create"),
        headers: {
            "Content-Type": "application/json"
        },
        body: payload
    }).then((result)=>{
        return {
        response: result
        }
    })
}

function Get_Booking(bookid)
{
    return cy.request({
        method: "GET",
        url: baseurl+data.GetEndpoint("create")+"/"+bookid
    }).then((result)=>{
        return {
            response: result
        }
    })
}

function Edit_Booking(token, bookid, payload)
{
    return cy.request({
        method: "PUT",
        url: baseurl+data.GetEndpoint("create")+"/"+bookid,
        headers: {
            "Content-Type": "application/json",
            "Accept": "application/json",
            "Cookie": "token="+token
        },
        body: payload
    }).then((result)=>{
        return {
        response: result
        }
    })
}

function Delete_Booking(token, bookid)
{
    return cy.request({
        method: "DELETE",
        url: baseurl+data.GetEndpoint("create")+"/"+bookid,
        headers: {
            "Content-Type": "application/json",
            "Cookie": "token="+token
        },
    }).then((result)=>{
        return {
        response: result
        }
    })

}




module.exports={
    Authorize,
    Create_Booking,
    Get_Booking,
    Edit_Booking,
    Delete_Booking
}