const config=require("../../fixtures/APIConfig.json")
function GetBaseUrl()
{
    return config.baseurl;

}

function GetEndpoint(key)
{
    return config.endpoints[key];
}

function SetBookid()
{
    config.bookid=value;

}

function GetBookId()
{
    return config.bookid;
}

module.exports={
    GetBaseUrl,
    GetEndpoint,
    GetBookId,
    SetBookid
}